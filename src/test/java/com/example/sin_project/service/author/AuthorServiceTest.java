package com.example.sin_project.service.author;

import com.example.sin_project.dto.request.AuthorRequest;
import com.example.sin_project.dto.request.BookRequest;
import com.example.sin_project.entity.Author;
import com.example.sin_project.entity.Book;
import com.example.sin_project.exception.NotFoundException;
import com.example.sin_project.service.book.BookService;
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
public class AuthorServiceTest {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private AuthorServiceImp authorService;

    @BeforeEach
    public void setUp(){
    }

    @Test
    public void findById_existingBook_bookRetrieved(){
        // Arrange
        Author author = generateAuthor();

        // Act
        Author foundAuthor = authorService.findById(author.getId());

        //Assert
        assertSame(author, foundAuthor);
    }

    @Test(expected = NotFoundException.class)
    public void findById_wrongBookId_expectException(){
        // Arrange
        Long authorId = Long.MIN_VALUE;

        // Act
        Author foundAuthor = authorService.findById(authorId);

        fail("Exception not thrown.");
    }

    private Author generateAuthor() {
        Author author = new Author(new AuthorRequest("author", "author@gmail.com"));
        em.persist(author);
        return author;
    }

}