package br.com.cursoudemy.arquiteturaspring.todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TodoValidator {

    @Autowired
    private TodoRepository repository;

    public void validar(TodoEntity todo){
        if (existeTodoComDescricao(todo.getDescricao())){
            throw new IllegalArgumentException(("Já existe um TODO com essa descrição."));
        }
    }

    private boolean existeTodoComDescricao(String descricao){
        return repository.existsByDescricao(descricao);
    }
}
