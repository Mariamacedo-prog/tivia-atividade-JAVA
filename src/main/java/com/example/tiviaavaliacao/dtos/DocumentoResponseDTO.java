package com.example.tiviaavaliacao.dtos;

import java.time.LocalDateTime;

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
public class DocumentoResponseDTO {
	private Long id;
	
	private String tipoDocumento;
	
	private String descricao;
	
	private LocalDateTime dataInclusao;
	
	private LocalDateTime dataAtualizacao;
}
