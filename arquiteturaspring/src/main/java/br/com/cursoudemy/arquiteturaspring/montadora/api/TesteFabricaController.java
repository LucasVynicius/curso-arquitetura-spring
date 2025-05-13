package br.com.cursoudemy.arquiteturaspring.montadora.api;

import br.com.cursoudemy.arquiteturaspring.montadora.Carro;
import br.com.cursoudemy.arquiteturaspring.montadora.CarroStatus;
import br.com.cursoudemy.arquiteturaspring.montadora.Chave;
import br.com.cursoudemy.arquiteturaspring.montadora.Motor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteFabricaController {

    @Autowired
    private Motor motor;

    @PostMapping
    public CarroStatus ligarCarro(@RequestBody Chave chave){
        var carro = new Carro(motor);
        return carro.darIgnicao(chave);
    }
}
