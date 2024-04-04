package com.example.tiviaavaliacao.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.tiviaavaliacao.models.Beneficiario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BeneficiarioResponseDTO {
	private Long id;
	
	private String nome;
	
	private String telefone;
	
	private LocalDate dataNascimento;
	
	private LocalDateTime dataInclusao;
	
	private LocalDateTime dataAtualizacao;
}
