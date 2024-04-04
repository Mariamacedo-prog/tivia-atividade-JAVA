package com.example.tiviaavaliacao.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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
public class BeneficiarioUpdateRequestDTO {
	private String nome;

	private String telefone;
    
	private LocalDate dataNascimento;
}
