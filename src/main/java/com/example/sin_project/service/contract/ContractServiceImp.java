package com.example.sin_project.service.contract;

import com.example.sin_project.entity.Author;
import com.example.sin_project.entity.Contract;
import com.example.sin_project.dto.request.ContractRequest;
import com.example.sin_project.entity.PublishingHouse;
import com.example.sin_project.exception.FieldMissingException;
import com.example.sin_project.exception.NotFoundException;
import com.example.sin_project.repository.ContractRepository;
import com.example.sin_project.service.author.AuthorServiceImp;
import com.example.sin_project.service.publishingHouse.PublishingHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            throw new FieldMissingException("ID_MISSING");
        return contractRepository.findById(id).orElseThrow(() ->new NotFoundException("CONTRACT_NOT_FOUND"));
    }

    @Override
    public Contract create(ContractRequest request) {
        Contract contract = new Contract(request);
        Author author = authorService.findById(request.getAuthorId());
        if(author == null) {
            throw new NotFoundException("AUTHOR_NOT_FOUND");
        }
        contract.setAuthor(author);

        PublishingHouse publishingHouse = publishingHouseService.findById(request.getPublishingHouseId());
        if(publishingHouse == null) {
            throw new NotFoundException("PUBLISHING_HOUSE_NOT_FOUND");
        }
        contract.setPublishingHouse(publishingHouse);

        this.contractRepository.save(contract);
        authorService.addContract(contract);
        publishingHouseService.addContract(contract);
        return contract;
    }

    @Override
    public Contract findByAuthorAndPublishingHouse(Long authorId, Long publishingHouseId) {
        Author author = this.authorService.findById(authorId);
        PublishingHouse publishingHouse = this.publishingHouseService.findById(publishingHouseId);
        List<Contract> authorContracts = author.getContracts();
        for(Contract contract: authorContracts) {
            if(contract.getPublishingHouse() == publishingHouse) {
                return contract;
            }
        }
        throw new NotFoundException("CONTRACT_NOT_FOUND");
    }

    public void save(Contract contract) {
    this.contractRepository.save(contract);
}
}
