package com.br.gov.caiury.beneficioapi.domain.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Pattern;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Beneficiario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String telefone;
	@Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$", message = "Formato de data de nascimento inválido. Use o formato dd/MM/yyyy.")
	private String dataDeNascimento;
	@CreationTimestamp
	@JsonProperty(access = Access.READ_ONLY)
	private OffsetDateTime dataInclusao;
	@UpdateTimestamp
	@JsonProperty(access = Access.READ_ONLY)
	private OffsetDateTime dataAtualizacao;
	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Documento> documentos = new ArrayList<>();

}
