package com.example.tiviaavaliacao.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.tiviaavaliacao.models.Beneficiario;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BeneficiarioResponseDTO {
private Long id;
	
	private String nome;
	
	private String telefone;
	
	private LocalDate dataNascimento;
	
	private LocalDateTime dataInclusao;
	
	private LocalDateTime dataAtualizacao;
	
	public BeneficiarioResponseDTO() {}
	
	@Autowired
	public BeneficiarioResponseDTO(Beneficiario beneficiarioModel) {
		setDataNascimento(beneficiarioModel.getDataNascimento());
		setDataAtualizacao(beneficiarioModel.getDataAtualizacao());
		setDataInclusao(beneficiarioModel.getDataInclusao());
	    setNome(beneficiarioModel.getNome());
	    setId(beneficiarioModel.getId());
	    setTelefone(beneficiarioModel.getTelefone()); 
	}
	
}
