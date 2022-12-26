package com.example.sin_project.controller;

import com.example.sin_project.dto.ContractDTO;
import com.example.sin_project.dto.DTOMapper;
import com.example.sin_project.dto.request.ContractRequest;
import com.example.sin_project.service.contract.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contract")
public class ContractController {
    private final ContractService contractService;
    private final DTOMapper dtoMapper;

    @Autowired
    public ContractController(ContractService contractService, DTOMapper dtoMapper) {
        this.contractService = contractService;
        this.dtoMapper = dtoMapper;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ContractDTO> create(@RequestBody ContractRequest request) {
        return ResponseEntity.ok(dtoMapper.contractToDto(contractService.create(request)));
    }
}
