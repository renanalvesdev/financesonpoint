package br.com.renanlabs.mvc.financesonpoint.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.renanlabs.mvc.financesonpoint.model.Carteira;
import br.com.renanlabs.mvc.financesonpoint.repository.CarteiraRepository;

@Component
public class CarteiraConverter implements Converter<String, Carteira> {

@Autowired
private CarteiraRepository repository;

    @Override
    public Carteira convert(String arg0) {
        Long id = Long.valueOf(arg0);
    	return repository.getOne(id);
    }



}