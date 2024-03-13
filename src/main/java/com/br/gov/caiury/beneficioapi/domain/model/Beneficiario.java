package com.br.gov.caiury.beneficioapi.domain.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Beneficiario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String telefone;
	private String dataDeNascimento;
	@JsonProperty(access = Access.READ_ONLY)
	private OffsetDateTime dataInclusao = OffsetDateTime.now();
	@JsonProperty(access = Access.READ_ONLY)
	private OffsetDateTime dataAtualizacao;
	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Documento>documentos= new ArrayList<>();
	

}
