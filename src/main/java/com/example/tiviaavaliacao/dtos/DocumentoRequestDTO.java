package com.example.tiviaavaliacao.dtos;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.tiviaavaliacao.models.Documento;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class DocumentoRequestDTO {
	private String tipoDocumento;
	private String descricao;
	
	public DocumentoRequestDTO() {}
	
	@Autowired
	public DocumentoRequestDTO(Documento documentoModel) {
	    setTipoDocumento(documentoModel.getTipoDocumento());
	    setDescricao(documentoModel.getDescricao());
	}
}
