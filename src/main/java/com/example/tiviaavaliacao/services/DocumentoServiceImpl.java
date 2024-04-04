package com.example.tiviaavaliacao.services;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.example.tiviaavaliacao.dtos.DocumentoRequestDTO;
import com.example.tiviaavaliacao.dtos.DocumentoResponseDTO;
import com.example.tiviaavaliacao.models.Documento;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class DocumentoServiceImpl implements DocumentoService{
   	private static final Logger logger = Logger.getLogger(DocumentoServiceImpl.class.getName());

	@Override
	public List<DocumentoResponseDTO> findAllByBeneficiarioId(Long beneficiarioId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<DocumentoRequestDTO> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public Documento save(DocumentoRequestDTO documento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

}
