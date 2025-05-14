package br.com.cursoudemy.arquiteturaspring.todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private TodoValidator validator;

    @Autowired
    private MailSender mailSender;

    public TodoEntity salvar(TodoEntity novotodo){
        validator.validar(novotodo);
        return todoRepository.save(novotodo);
    }

    public TodoEntity atualizarStatus (TodoEntity novoTodo){
        String status = novoTodo.getConcluido() == Boolean.TRUE ? "Concluido" : "Não concluido";
        mailSender.enviar("Todo " + novoTodo.getDescricao() + " foi atualizado para " + status );
        return todoRepository.save(novoTodo);
    }

    public TodoEntity buscarPeloId(Integer id){
        return todoRepository.findById(id).orElse(null);
    }
}
