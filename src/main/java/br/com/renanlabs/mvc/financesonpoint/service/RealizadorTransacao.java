package br.com.renanlabs.mvc.financesonpoint.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.renanlabs.mvc.financesonpoint.model.CarteiraTransacao;


@Component
public interface RealizadorTransacao {

	@Transactional
	public void efetua(CarteiraTransacao carteiraTransacao);
}
