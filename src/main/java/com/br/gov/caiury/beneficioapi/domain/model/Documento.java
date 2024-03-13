package com.br.gov.caiury.beneficioapi.domain.model;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Documento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String tipoDocumento;
	private String descricao;
	private OffsetDateTime dataInclusao = OffsetDateTime.now();
	@JsonProperty(access = Access.READ_ONLY)
	private OffsetDateTime dataAtualizacao;

}
