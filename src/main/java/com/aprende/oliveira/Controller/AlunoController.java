package com.aprende.oliveira.Controller;


import com.aprende.oliveira.Model.Aluno;
import com.aprende.oliveira.Servico.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    private final AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }
    
    @GetMapping
    public List<Aluno> buscarAlunos(){
        return service.listaDeAluno();
    }

    @PostMapping
    public Aluno salvarAluno(@RequestBody Aluno novoAluno){
        return service.criarAluno(novoAluno);
    }

    @DeleteMapping("/id")
    public void excluirAluno(@PathVariable Long id){
        service.deletarAluno(id);
    }

    @GetMapping("/id")
    public Aluno buscaAlunoPorID(@PathVariable Long id){
        return service.buscarAlunoId(id);
    }



}
