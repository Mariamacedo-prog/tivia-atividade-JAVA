package com.example.tiviaavaliacao.controllers;

import java.util.Optional;
import java.util.logging.Logger;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tiviaavaliacao.dtos.DocumentoRequestDTO;
import com.example.tiviaavaliacao.dtos.DocumentoResponseDTO;
import com.example.tiviaavaliacao.models.Documento;
import com.example.tiviaavaliacao.services.DocumentoService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/documentos")
@RequiredArgsConstructor
public class DocumentoController {
	private final DocumentoService service;
	private static final Logger logger = Logger.getLogger(DocumentoController.class.getName());

	@Operation(summary = "Lista Documentos", description = "Lista todos os Documentos pelo beneficiarioId")
    @GetMapping("/{beneficiarioId}")
    public ResponseEntity<Object> getBeneficiarioById(@PathVariable Long beneficiarioId) {
		List<DocumentoResponseDTO> documentos = service.findAllByBeneficiarioId(beneficiarioId);
		
	    if (!documentos.isEmpty()) {
	        return ResponseEntity.status(HttpStatus.OK).body(documentos);
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrados Documentos para este beneficiario!");
	    }
    }
	
	@Operation(summary = "Criar Documento", description = "Criação de Documentos")
    @PostMapping("/{beneficiarioId}")
    public ResponseEntity<Object> createBeneficiario(@PathVariable Long beneficiarioId, @RequestBody DocumentoRequestDTO documento) {
	    Documento model = service.save(documento, beneficiarioId);
	    if (model != null) {
	    	Optional<DocumentoResponseDTO> optional = service.findById(model.getId());
	        return ResponseEntity.status(HttpStatus.CREATED).body(optional);
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível salvar o Documento");
	    }
	}
	
//    @Operation(summary = "Deleta Beneficiario", description = "Deleta o Beneficiario pelo Id")
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Object>  deleteBeneficiario(@PathVariable Long id) {
//    	Optional<DocumentoResponseDTO> beneficiario = service.findById(id);
//	    if (beneficiario.isEmpty())
//	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Beneficiario não encontrado!");
//	
//	    service.deleteById(id);
//	    return ResponseEntity.status(HttpStatus.OK).body("Beneficiario deletado com sucesso!");
//    }
}
