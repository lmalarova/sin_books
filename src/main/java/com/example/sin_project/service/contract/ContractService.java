package com.example.sin_project.service.contract;

import com.example.sin_project.entity.Contract;
import com.example.sin_project.dto.request.ContractRequest;

public interface ContractService {
    Contract findById(Long id);
    Contract create(ContractRequest request);
    Contract findByAuthorAndPublishingHouse(Long authorId, Long publishingHouseId);
    void save(Contract contract);
}
