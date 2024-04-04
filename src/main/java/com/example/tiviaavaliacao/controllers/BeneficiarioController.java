package com.example.tiviaavaliacao.controllers;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

import com.example.tiviaavaliacao.dtos.BeneficiarioRequestDTO;
import com.example.tiviaavaliacao.dtos.BeneficiarioResponseDTO;
import com.example.tiviaavaliacao.models.Beneficiario;
import com.example.tiviaavaliacao.services.BeneficiarioService;




@RestController
@RequestMapping("/api/beneficiarios")
@RequiredArgsConstructor
public class BeneficiarioController {
	private final BeneficiarioService service;
	private static final Logger logger = Logger.getLogger(BeneficiarioService.class.getName());
	 
	@Operation( summary = "Listar todos os Beneficiarios", description = "Serviço que lista todos os beneficiarios da base de dados")
    @GetMapping
    public ResponseEntity<Object> getAll() {
		 return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

	@Operation(summary = "Lista Beneficiario", description = "Lista todos os Beneficiario pelo ID")
    @GetMapping("/{id}")
    public ResponseEntity<Object> getBeneficiarioById(@PathVariable Long id) {
		Optional<BeneficiarioResponseDTO> beneficiario = service.findById(id);
	    if (beneficiario.isPresent()) {
	        return ResponseEntity.status(HttpStatus.OK).body(beneficiario.get());
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Beneficiário não encontrado");
	    }
    }
	
	@Operation(summary = "Cria Beneficiario", description = "Criação de beneficiario e de seus documentos  (OBS: o campo TipoDocumento só aceita os dados do ENUM TipoDocumento)")
    @PostMapping
    public ResponseEntity<Object> createBeneficiario(@RequestBody BeneficiarioRequestDTO beneficiario) {
	    Beneficiario model = service.save(beneficiario);
	    if (model != null) {
	    	Optional<BeneficiarioResponseDTO> optional = service.findById(model.getId());
	        return ResponseEntity.status(HttpStatus.CREATED).body(optional);
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível salvar o beneficiário");
	    }
	}
	
    @Operation(summary = "Atualiza Beneficiario", description = "Permite atualizar o beneficiario pelo ID e adicionar NOVOS documentos    (OBS: o campo TipoDocumento só aceita os dados do ENUM TipoDocumento)")
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateBeneficiario(@PathVariable Long id, @RequestBody BeneficiarioRequestDTO beneficiario) {
    	Beneficiario model = service.update(beneficiario, id);
  	    if (model != null) {
  	    	Optional<BeneficiarioResponseDTO> optional = service.findById(model.getId());
  	        return ResponseEntity.status(HttpStatus.CREATED).body(optional);
  	    } else {
  	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível atualizar o beneficiário");
  	    }
    }
	
    @Operation(summary = "Deleta Beneficiario", description = "Deleta o Beneficiario pelo Id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object>  deleteBeneficiario(@PathVariable Long id) {
    	Optional<BeneficiarioResponseDTO> beneficiario = service.findById(id);
	    if (beneficiario.isEmpty())
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Beneficiario não encontrado!");
	
	    service.deleteById(id);
	    return ResponseEntity.status(HttpStatus.OK).body("Beneficiario deletado com sucesso!");
    }
}