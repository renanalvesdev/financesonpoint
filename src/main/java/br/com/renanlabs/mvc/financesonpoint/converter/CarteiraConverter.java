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
    	
    	try {
    		return (arg0 != null && arg0.length() > 0 )? repository.getOne(Long.valueOf(arg0)) : null;
		} catch (Exception e) {
			System.out.println("houve um erro na conversao;");
			return null;
		}
        
    }



}