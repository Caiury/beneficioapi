package com.br.gov.caiury.beneficioapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.br.gov.caiury.beneficioapi.domain.model.Beneficiario;
import com.br.gov.caiury.beneficioapi.repository.BeneficiarioRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BeneficiarioService {

	private final BeneficiarioRepository beneficiarioRepository;

	public List<Beneficiario> listarTodos() {
		return beneficiarioRepository.findAll();
	}

	public Beneficiario cadastrar(Beneficiario beneficiarioRequest) {

		return beneficiarioRepository.save(beneficiarioRequest);
	}

	public void deletar(Long id) {
		beneficiarioRepository.deleteById(id);
	}

}
