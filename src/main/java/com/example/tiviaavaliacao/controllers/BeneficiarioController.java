package com.example.tiviaavaliacao.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import com.example.tiviaavaliacao.dtos.BeneficiarioRequestDTO;
import com.example.tiviaavaliacao.services.BeneficiarioService;



@RestController
@RequestMapping("/api/beneficiarios")
public class BeneficiarioController {
    private final BeneficiarioService beneficiarioService;

    @Autowired
    public BeneficiarioController(BeneficiarioService beneficiarioService) {
        this.beneficiarioService = beneficiarioService;
    }

    @Operation(summary = "Lista Beneficiarios", description = "Lista todos os Beneficiarios")
    @GetMapping
    public String getAllBeneficiarios() {
        return "Hello world";
    }


}