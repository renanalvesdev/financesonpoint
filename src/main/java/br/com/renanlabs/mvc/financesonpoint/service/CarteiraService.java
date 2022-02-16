package br.com.renanlabs.mvc.financesonpoint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.renanlabs.mvc.financesonpoint.model.Carteira;
import br.com.renanlabs.mvc.financesonpoint.repository.CarteiraRepository;

@Service
public class CarteiraService {
	
	@Autowired
	private CarteiraRepository carteiraRepository;
	
	public void save(Carteira carteira) {
		carteiraRepository.save(carteira);
	}
}
