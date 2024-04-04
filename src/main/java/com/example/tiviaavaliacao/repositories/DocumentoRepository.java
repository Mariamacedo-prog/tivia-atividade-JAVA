package com.example.tiviaavaliacao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.tiviaavaliacao.models.Documento;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Long> {

	 @Query("SELECT d FROM Documento d WHERE d.beneficiarioId = ?1")
	 List<Documento> findAllByBeneficiarioId(Long beneficiarioId);
}