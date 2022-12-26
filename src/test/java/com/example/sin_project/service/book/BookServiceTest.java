package com.example.sin_project.service.book;

import com.example.sin_project.dto.request.AuthorRequest;
import com.example.sin_project.dto.request.BookRequest;
import com.example.sin_project.entity.Author;
import com.example.sin_project.entity.Book;
import com.example.sin_project.exception.NotFoundException;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest()
public class BookServiceTest {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private BookServiceImp service;

    @BeforeEach
    public void setUp(){
    }

    @Test
    public void findById_existingBook_bookRetrieved(){
        // Arrange
        Book book = generateBook();

        // Act
        Book foundBook = service.findById(book.getId());

        //Assert
        assertSame(book, foundBook);
    }

    @Test(expected = NotFoundException.class)
    public void findById_wrongBookId_expectException(){
        // Arrange
        Long bookId = Long.MIN_VALUE;

        // Act
        Book foundBook = service.findById(bookId);

        fail("Exception not thrown.");
    }

    private Book generateBook() {
        new Author(new AuthorRequest("author", "author@gmail.com"));
        Book book = new Book(new BookRequest("123", "name", 1L));
        em.persist(book);
        return book;
    }

}

