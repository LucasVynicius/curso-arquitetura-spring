package br.com.cursoudemy.arquiteturaspring.todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService service;

    @PostMapping
    public TodoEntity salvar(@RequestBody TodoEntity todo){
        try {
            return service.salvar(todo);
        } catch (IllegalArgumentException e){
            var mensagemErro = e.getMessage();
            throw new ResponseStatusException(HttpStatus.CONFLICT, mensagemErro);
        }
    }

    @PutMapping("{id}")
    public TodoEntity atualizarStatus(@PathVariable("id") Integer id, @RequestBody TodoEntity todo){
        todo.setId(id);
        return service.atualizarStatus(todo);
    }

    @GetMapping("{id}")
    public TodoEntity buscarPeloId(@PathVariable("id") Integer id){
        return service.buscarPeloId(id);
    }
}
