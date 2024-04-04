package com.example.tiviaavaliacao.services;

import java.util.List;
import java.util.Optional;

import com.example.tiviaavaliacao.dtos.DocumentoRequestDTO;
import com.example.tiviaavaliacao.dtos.DocumentoResponseDTO;
import com.example.tiviaavaliacao.models.Documento;

public interface DocumentoService {
	List<DocumentoResponseDTO> findAllByBeneficiarioId(Long beneficiarioId);
	
	Optional<DocumentoRequestDTO> findById(Long id);

	Documento save(DocumentoRequestDTO documento);
 
    void deleteById(Long id);
}
