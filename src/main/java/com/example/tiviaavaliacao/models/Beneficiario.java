package com.example.tiviaavaliacao.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.example.tiviaavaliacao.dtos.BeneficiarioResponseDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "BENEFICIARIO")
@Getter
@Setter
public class Beneficiario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "telefone")
	private String telefone;
	
	@Column(name = "data_nascimento")
    private LocalDate dataNascimento;
	
	@Column(name = "data_inclusao")
	private LocalDateTime dataInclusao;
	
	@Column(name = "data_atualizacao")
	private LocalDateTime dataAtualizacao;
	
	public Beneficiario() {}
	
	public Beneficiario(Long id, String nome, String telefone, LocalDate dataNascimento, LocalDateTime dataInclusao, LocalDateTime dataAtualizacao) {
	    this.id = id;
	    this.nome = nome;
	    this.telefone = telefone;
	    this.dataNascimento = dataNascimento;
	    this.dataInclusao = dataInclusao;
	    this.dataAtualizacao = dataAtualizacao;
	}
	
	public Beneficiario(String nome, String telefone, LocalDate dataNascimento, LocalDateTime dataInclusao, LocalDateTime dataAtualizacao) {
		this.setDataNascimento(dataNascimento);
		this.setDataAtualizacao(dataInclusao);
		this.setDataInclusao(dataAtualizacao);
		this.setNome(nome);
		this.setTelefone(telefone);
	}
	
	public Beneficiario(BeneficiarioResponseDTO beneficiarioDto) {
		this.setDataNascimento(beneficiarioDto.getDataNascimento());
		this.setDataAtualizacao(beneficiarioDto.getDataAtualizacao());
		this.setDataInclusao(beneficiarioDto.getDataInclusao());
		this.setNome(beneficiarioDto.getNome());
		this.setTelefone(beneficiarioDto.getTelefone());
	}
}
