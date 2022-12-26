package com.example.sin_project.service.library;

import com.example.sin_project.dto.request.*;
import com.example.sin_project.entity.Book;
import com.example.sin_project.entity.Library;
import com.example.sin_project.entity.PublishingHouse;
import com.example.sin_project.exception.NotFoundException;
import com.example.sin_project.service.author.AuthorServiceImp;
import com.example.sin_project.service.book.BookServiceImp;
import com.example.sin_project.service.publishingHouse.PublishingHouseServiceImp;
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
public class LibraryServiceTest {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private LibraryServiceImp libraryService;

    @Autowired
    private BookServiceImp bookService;

    @Autowired
    private AuthorServiceImp authorService;

    @BeforeEach
    public void setUp(){
    }

    @Test
    public void findById_existingLibrary_LibraryRetrieved(){
        // Arrange
        Library library = createLibrary();

        // Act
        Library foundLibrary = libraryService.findById(library.getId());

        //Assert
        assertSame(library, foundLibrary);
    }

    @Test(expected = NotFoundException.class)
    public void findById_wrongLibraryId_expectException(){
        // Arrange
        Long libraryId = Long.MIN_VALUE;

        // Act
        Library foundLibrary = libraryService.findById(libraryId);

        fail("Exception not thrown.");
    }

    @Test
    public void addBookToLibrary_existingBook_libraryWithBookRetrieved() {
        // Arrange
        this.authorService.create(new AuthorRequest("author", "author@gmail.com"));
        Book book = this.bookService.create(new BookRequest("123", "name", 1L));
        Library library = addBookToLibrary(book);

        // Act
        Library newLibrary = new Library(new LibraryRequest("library"));
        List<Book> books = new ArrayList<>();
        books.add(book);
        newLibrary.setBooks(books);

        assertEquals(library.getBooks(), newLibrary.getBooks());
    }

    private Library createLibrary() {
        Library library = new Library(new LibraryRequest("library"));
        em.persist(library);
        return library;
    }

    private Library addBookToLibrary(Book book) {
        Library library = this.libraryService.create(new LibraryRequest("library"));
        this.libraryService.addBook(library.getId(), new BookIdRequest(book.getId()));
        em.persist(library);
        return library;
    }

}