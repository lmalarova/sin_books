package com.example.sin_project.service.contract;

import com.example.sin_project.entity.Author;
import com.example.sin_project.entity.Contract;
import com.example.sin_project.entity.ContractRequest;
import com.example.sin_project.entity.PublishingHouse;
import com.example.sin_project.exception.FieldMissingException;
import com.example.sin_project.exception.NotFoundException;
import com.example.sin_project.repository.ContractRepository;
import com.example.sin_project.service.author.AuthorServiceImp;
import com.example.sin_project.service.publishingHouse.PublishingHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContractServiceImp implements ContractService {
    private final ContractRepository contractRepository;

    @Autowired
    private AuthorServiceImp authorService;

    @Autowired
    private PublishingHouseService publishingHouseService;

    @Autowired
    public ContractServiceImp(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @Override
    public Contract findById(Long id){
        if(id == null)
            throw new FieldMissingException();
        return contractRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public Contract signContract(ContractRequest request) {
        Contract contract = new Contract(request);

        authorService.addContract(contract);

        publishingHouseService.addContract(contract);
        return contract;
    }

    public void save(Contract contract) {
    this.contractRepository.save(contract);
}
}
