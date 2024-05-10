package com.br.gov.caiury.beneficioapi.controller;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.gov.caiury.beneficioapi.domain.model.Beneficiario;
import com.br.gov.caiury.beneficioapi.repository.BeneficiarioRepository;
import com.br.gov.caiury.beneficioapi.service.BeneficiarioService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/beneficiarios")
@AllArgsConstructor
public class BeneficiarioController {

	private final BeneficiarioService beneficiarioervice;
	private final BeneficiarioRepository beneficiarioRepository;

	@GetMapping
	public List<Beneficiario> listar() {
		return beneficiarioervice.listarTodos();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Beneficiario> listarPorId(@PathVariable Long id) {
		return beneficiarioRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Beneficiario> salvar(@RequestBody Beneficiario beneficiarioRequest) {
		return ResponseEntity.status(HttpStatus.CREATED).body(beneficiarioervice.cadastrar(beneficiarioRequest));
	}

	@PutMapping("{id}")
	public ResponseEntity<Beneficiario> atualizarBeneficiario(@PathVariable Long id,
			@RequestBody Beneficiario beneficiario) {
		try {
			Beneficiario beneficiarioAtual = beneficiarioRepository.findById(id).orElse(null);
			if (beneficiarioAtual != null) {
				BeanUtils.copyProperties(beneficiario, beneficiarioAtual, "id");
			}
			beneficiarioAtual = beneficiarioervice.cadastrar(beneficiarioAtual);

			return ResponseEntity.ok(beneficiarioAtual);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		if (!beneficiarioRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.noContent().build();
	}
}
