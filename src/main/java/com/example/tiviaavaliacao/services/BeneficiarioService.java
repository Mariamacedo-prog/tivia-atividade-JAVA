package com.example.tiviaavaliacao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;


import com.example.tiviaavaliacao.dtos.DocumentoRequestDTO;
import com.example.tiviaavaliacao.dtos.BeneficiarioRequestDTO;
import com.example.tiviaavaliacao.dtos.BeneficiarioResponseDTO;
import com.example.tiviaavaliacao.models.Beneficiario;
import com.example.tiviaavaliacao.models.Documento;
import com.example.tiviaavaliacao.repositories.BeneficiarioRepository;
import com.example.tiviaavaliacao.repositories.DocumentoRepository;

@Service
public class BeneficiarioService {
	private static final Logger logger = Logger.getLogger(BeneficiarioService.class.getName());



    
    public ResponseEntity<List<BeneficiarioResponseDTO>> findAll() {
    	return null;
    }

    public ResponseEntity<?> findById(Long id) {
		return null;
    	
    }
   
    public ResponseEntity<?> save(BeneficiarioRequestDTO beneficiario) {
    	return null;
    }
    
    public ResponseEntity<?> update(BeneficiarioRequestDTO beneficiarioRequest, Long id) {
    	return null;
    }
 
    public ResponseEntity<?> deleteById(Long id) {
    	return null;
    }
}