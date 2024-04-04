package com.example.tiviaavaliacao.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.tiviaavaliacao.models.Beneficiario;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BeneficiarioRequestDTO {
	private String nome;

	private String telefone;
    
	private LocalDate dataNascimento;

	private List<DocumentoRequestDTO> documentos;
	
	private LocalDateTime dataInclusao;
	
	private LocalDateTime dataAtualizacao;
}
