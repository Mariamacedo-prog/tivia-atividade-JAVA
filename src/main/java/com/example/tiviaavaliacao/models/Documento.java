package com.example.tiviaavaliacao.models;

import java.time.LocalDateTime;

import com.example.tiviaavaliacao.dtos.DocumentoRequestDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "DOCUMENTO")
@AllArgsConstructor
@Data
public class Documento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @Column(name = "tipo_documento")
    private String tipoDocumento;

	@Column(name = "descricao")
    private String descricao;

	@Column(name = "data_inclusao")
    private LocalDateTime dataInclusao;

	@Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

    @Column(name = "beneficiario_id")
    private Long beneficiarioId;
    
    public Documento (){
    	
    }
    
	public Documento(LocalDateTime dataInclusao,LocalDateTime dataAtualizacao, DocumentoRequestDTO documentoModel, Beneficiario beneficiarioModel) {
		this.setDataAtualizacao(dataAtualizacao);
		this.setDataInclusao(dataInclusao);
		this.setTipoDocumento(documentoModel.getTipoDocumento());
		this.setDescricao(documentoModel.getDescricao());
		this.setBeneficiarioId(beneficiarioModel.getId());
	}
}
