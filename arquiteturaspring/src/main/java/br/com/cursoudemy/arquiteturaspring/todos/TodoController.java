package br.com.cursoudemy.arquiteturaspring.todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("todos")
public class TodoController {

    @Autowired
    private TodoService service;

    @PostMapping
    public TodoEntity salvar(@RequestBody TodoEntity todo){
        return service.salvar(todo);
    }
}
