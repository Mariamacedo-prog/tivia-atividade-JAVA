package com.example.tiviaavaliacao.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.tiviaavaliacao.dtos.BeneficiarioRequestDTO;
import com.example.tiviaavaliacao.dtos.BeneficiarioResponseDTO;
import com.example.tiviaavaliacao.dtos.BeneficiarioUpdateRequestDTO;
import com.example.tiviaavaliacao.models.Beneficiario;
import com.example.tiviaavaliacao.repositories.BeneficiarioRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
@Transactional
public class BeneficiarioServiceImpl implements BeneficiarioService{
	private static final Logger logger = Logger.getLogger(BeneficiarioServiceImpl.class.getName());

    private final BeneficiarioRepository beneficiarioRepository;


    @Override
    public List<BeneficiarioResponseDTO> findAll() {
        List<Beneficiario> beneficiaries = beneficiarioRepository.findAll();
        List<BeneficiarioResponseDTO> responseDTOs = new ArrayList<>();
        for (Beneficiario beneficiary : beneficiaries) {
            responseDTOs.add(mapToResponseDTO(beneficiary));
        }
        return responseDTOs;
    }

    @Override
    public Optional<BeneficiarioResponseDTO> findById(Long id) {
        Optional<Beneficiario> beneficiaryOptional = beneficiarioRepository.findById(id);
        return beneficiaryOptional.map(this::mapToResponseDTO);
    }
    
    @Override
    public Beneficiario save(BeneficiarioRequestDTO beneficiario) {
        Beneficiario entity = mapToEntity(beneficiario);
   	 	return beneficiarioRepository.save(entity);
    }

    @Override
    public Beneficiario update(BeneficiarioUpdateRequestDTO beneficiario, Long id) {
        Beneficiario beneficiarioFound = beneficiarioRepository.findById(id).orElse(null);
        if (beneficiarioFound != null) {
        	if(!beneficiario.getNome().isEmpty()) {
        		beneficiarioFound.setNome(beneficiario.getNome());
        	}           	
        	if(!beneficiario.getTelefone().isEmpty()) {
        		beneficiarioFound.setTelefone(beneficiario.getTelefone());
        	}           	
        	if(beneficiario.getDataNascimento() != null) {
        		beneficiarioFound.setDataNascimento(beneficiario.getDataNascimento());
        	}           	
        	beneficiarioFound.setDataAtualizacao(LocalDateTime.now());
            Beneficiario newBeneficiario = beneficiarioRepository.save(beneficiarioFound);
            
            return newBeneficiario;
        } else {
            return null;
        }
    }
    
    @Override
    public void deleteById(Long id) {
        beneficiarioRepository.deleteById(id);
    }

    private BeneficiarioResponseDTO mapToResponseDTO(Beneficiario beneficiary) {
        BeneficiarioResponseDTO responseDTO = new BeneficiarioResponseDTO();
        responseDTO.setId(beneficiary.getId());
        responseDTO.setNome(beneficiary.getNome());
        responseDTO.setTelefone(beneficiary.getTelefone());
        responseDTO.setDataNascimento(beneficiary.getDataNascimento());
        responseDTO.setDataInclusao(beneficiary.getDataInclusao());
        responseDTO.setDataAtualizacao(beneficiary.getDataAtualizacao());
        
        return responseDTO;
    }

    private Beneficiario mapToEntity(BeneficiarioRequestDTO beneficiarioRequest) {
        Beneficiario entity = new Beneficiario();
        entity.setNome(beneficiarioRequest.getNome());
        entity.setTelefone(beneficiarioRequest.getTelefone());
        entity.setDataNascimento(beneficiarioRequest.getDataNascimento());
        // Set dataInclusao and dataAtualizacao to current date/time
        entity.setDataInclusao(LocalDateTime.now());
        entity.setDataAtualizacao(LocalDateTime.now());
        return entity;
    }
}
