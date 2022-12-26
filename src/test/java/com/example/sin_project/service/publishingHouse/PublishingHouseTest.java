package com.example.sin_project.service.publishingHouse;

import com.example.sin_project.dto.request.*;
import com.example.sin_project.entity.Book;
import com.example.sin_project.entity.PublishingHouse;
import com.example.sin_project.exception.NotFoundException;
import com.example.sin_project.service.author.AuthorServiceImp;
import com.example.sin_project.service.book.BookServiceImp;
import com.example.sin_project.service.contract.ContractServiceImp;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest()
public class PublishingHouseTest {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private PublishingHouseServiceImp publishingHouseService;

    @Autowired
    private ContractServiceImp contractService;

    @Autowired
    private BookServiceImp bookService;

    @Autowired
    private AuthorServiceImp authorService;

    @BeforeEach
    public void setUp(){
    }

    @Test
    public void findById_existingPublishingHouse_publishingHouseRetrieved(){
        // Arrange
        PublishingHouse publishingHouse = createPublishingHouse();

        // Act
        PublishingHouse foundPublishingHouse = publishingHouseService.findById(publishingHouse.getId());

        //Assert
        assertSame(publishingHouse, foundPublishingHouse);
    }

    @Test(expected = NotFoundException.class)
    public void findById_wrongPublishingHouseId_expectException(){
        // Arrange
        Long publishingHouseId = Long.MIN_VALUE;

        // Act
        PublishingHouse foundPublishingHouse = publishingHouseService.findById(publishingHouseId);

        fail("Exception not thrown.");
    }

    @Test
    public void publishBook_existingBook_publishingHouseWithBookRetrieved() {
        // Arrange
        this.authorService.create(new AuthorRequest("author", "author@gmail.com"));
        Book book = this.bookService.create(new BookRequest("123", "name", 1L));
        PublishingHouse publishingHouse = publishBook(book);

        // Act
        PublishingHouse newPublishingHouse = new PublishingHouse(new PublishingHouseRequest("house"));
        List<Book> books = new ArrayList<>();
        books.add(book);
        newPublishingHouse.setBooks(books);

        assertEquals(publishingHouse.getBooks(), newPublishingHouse.getBooks());
    }

    private PublishingHouse createPublishingHouse() {
        PublishingHouse publishingHouse = new PublishingHouse(new PublishingHouseRequest("house"));
        em.persist(publishingHouse);
        return publishingHouse;
    }

    private PublishingHouse publishBook(Book book) {
        PublishingHouse publishingHouse = this.publishingHouseService.create(new PublishingHouseRequest("house"));
        this.contractService.create(new ContractRequest("name", book.getAuthor().getId(), publishingHouse.getId(), "content"));
        this.publishingHouseService.publishBook(publishingHouse.getId(), new BookIdRequest(book.getId()));
        em.persist(publishingHouse);
        return publishingHouse;
    }

}
