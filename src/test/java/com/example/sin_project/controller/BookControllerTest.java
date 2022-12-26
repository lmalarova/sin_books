package com.example.sin_project.controller;

import com.example.sin_project.dto.BookDTO;
import com.example.sin_project.dto.DTOMapper;
import com.example.sin_project.dto.request.AuthorRequest;
import com.example.sin_project.dto.request.BookRequest;
import com.example.sin_project.entity.Book;
import com.example.sin_project.service.author.AuthorServiceImp;
import com.example.sin_project.service.book.BookServiceImp;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(MockitoExtension.class)
public class BookControllerTest extends BaseControllerTestRunner {

    @MockBean
    private BookServiceImp bookServiceMock;

    @MockBean
    private AuthorServiceImp authorServiceMock;

    @SpyBean
    private DTOMapper dtoMapper;

    @Autowired
    private BookController sut;

    @Test
    public void getByIdReturnsMatchingBook() throws Exception {
        this.authorServiceMock.create(new AuthorRequest("author", "author@gmail.com"));
        final Book book = new Book(new BookRequest("123", "name", 1L));
        book.setId(1L);
        when(bookServiceMock.findById(book.getId())).thenReturn(book);
        final MvcResult mvcResult = mockMvc.perform(get("/book/" + book.getId())).andReturn();

        final BookDTO result = readValue(mvcResult, BookDTO.class);
        verify(dtoMapper).bookToDto(book);
        assertNotNull(result);
        assertEquals(book.getId(), result.getId());
        assertEquals(book.getName(), result.getName());
    }
}

