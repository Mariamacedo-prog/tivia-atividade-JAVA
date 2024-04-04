package com.example.tiviaavaliacao.services;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.tiviaavaliacao.dtos.DocumentoRequestDTO;
import com.example.tiviaavaliacao.dtos.DocumentoResponseDTO;
import com.example.tiviaavaliacao.models.Beneficiario;
import com.example.tiviaavaliacao.models.Documento;
import com.example.tiviaavaliacao.repositories.DocumentoRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class DocumentoServiceImpl implements DocumentoService{
   	private static final Logger logger = Logger.getLogger(DocumentoServiceImpl.class.getName());

	
    private final DocumentoRepository documentoRepository;

    @Override
    public List<DocumentoResponseDTO> findAllByBeneficiarioId(Long beneficiarioId) {
        List<Documento> documentos = documentoRepository.findAllByBeneficiarioId(beneficiarioId);
        
        List<DocumentoResponseDTO> responseDTOs = new ArrayList<>();
        for (Documento documento : documentos) {
        	DocumentoResponseDTO newDocumentoDTO = mapToResponseDTO(documento);
        	
            responseDTOs.add(newDocumentoDTO);
        }
        return responseDTOs;
    }

	@Override
	public Optional<DocumentoResponseDTO> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public Documento save(DocumentoRequestDTO documentoDto, Long beneficiarioId) {
		Documento entity = mapToEntity(documentoDto, beneficiarioId);
	   	return documentoRepository.save(entity);
	}

	@Override
	public void deleteByBeneficiarioId(Long beneficiarioId) {
		documentoRepository.deleteAllByBeneficiarioId(beneficiarioId);
	}
	
	@Override
	public void saveAllDocumento(List<DocumentoRequestDTO> documentoList, Long beneficiarioId) {
		if (documentoList.size() >= 1) {
	        for (DocumentoRequestDTO documento : documentoList) {
	            save(documento, beneficiarioId);
	        }
	    }
	}
	
    private DocumentoResponseDTO mapToResponseDTO(Documento documento) {
    	DocumentoResponseDTO responseDTO = new DocumentoResponseDTO();
        responseDTO.setId(documento.getId());
        responseDTO.setTipoDocumento(documento.getTipoDocumento());
        responseDTO.setDescricao(documento.getDescricao());
        responseDTO.setDataInclusao(documento.getDataInclusao());
        responseDTO.setDataAtualizacao(documento.getDataAtualizacao());
        
        return responseDTO;
    }

    private Documento mapToEntity(DocumentoRequestDTO documentoRequestDTO, Long beneficiarioId) {
    	Documento entity = new Documento();
    	entity.setTipoDocumento(documentoRequestDTO.getTipoDocumento());
    	entity.setDescricao(documentoRequestDTO.getDescricao());
    	entity.setBeneficiarioId(beneficiarioId);
        entity.setDataInclusao(LocalDateTime.now());
        entity.setDataAtualizacao(LocalDateTime.now());
        return entity;
    }
}
