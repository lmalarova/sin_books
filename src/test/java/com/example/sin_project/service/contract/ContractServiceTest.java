package com.example.sin_project.service.contract;

import com.example.sin_project.dto.request.AuthorRequest;
import com.example.sin_project.dto.request.BookRequest;
import com.example.sin_project.dto.request.ContractRequest;
import com.example.sin_project.dto.request.PublishingHouseRequest;
import com.example.sin_project.entity.Author;
import com.example.sin_project.entity.Book;
import com.example.sin_project.entity.Contract;
import com.example.sin_project.entity.PublishingHouse;
import com.example.sin_project.exception.NotFoundException;
import com.example.sin_project.service.book.BookServiceImp;
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
public class ContractServiceTest {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private ContractServiceImp contractService;

    @BeforeEach
    public void setUp(){
    }

    @Test
    public void createContract_findById(){
        // Arrange
        Contract contract = signContract();

        // Act
        Contract foundContract = contractService.findById(contract.getId());

        //Assert
        assertSame(contract, foundContract);
    }

    private Contract signContract() {
        new PublishingHouse(new PublishingHouseRequest("house"));
        new Author(new AuthorRequest("author", "author@gmail.com"));
        Contract contract = new Contract(new ContractRequest("contract", 1L, 1L, "content"));
        em.persist(contract);
        return contract;
    }

}
