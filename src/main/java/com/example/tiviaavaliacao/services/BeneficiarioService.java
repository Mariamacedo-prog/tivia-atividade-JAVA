package com.example.tiviaavaliacao.services;

import java.util.List;

import java.util.Optional;

import com.example.tiviaavaliacao.dtos.BeneficiarioRequestDTO;
import com.example.tiviaavaliacao.dtos.BeneficiarioResponseDTO;
import com.example.tiviaavaliacao.dtos.BeneficiarioUpdateRequestDTO;
import com.example.tiviaavaliacao.models.Beneficiario;


public interface BeneficiarioService {
	List<BeneficiarioResponseDTO> findAll();

	Optional<BeneficiarioResponseDTO> findById(Long id);
   
    Beneficiario save(BeneficiarioRequestDTO beneficiario);
 
    void deleteById(Long id);

	Beneficiario update(BeneficiarioUpdateRequestDTO beneficiario, Long id);
}