package com.example.sin_project.service.contract;

import com.example.sin_project.entity.Contract;
import com.example.sin_project.entity.ContractRequest;

import java.util.List;

public interface ContractService {
    Contract findById(Long id);
    Contract signContract(ContractRequest request);
}
