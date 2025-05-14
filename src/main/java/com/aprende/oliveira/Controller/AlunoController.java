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

    @PutMapping("/{id}")
    public Aluno atulizaAluno(@PathVariable Long id
            ,@RequestBody Aluno alteraAluno){

        Aluno atualizado = service.buscarAlunoId(id);
        if (atualizado == null) return null;

        atualizado.setNome(alteraAluno.getNome());
        atualizado.setEmail(alteraAluno.getEmail());
        atualizado.setTelefone(alteraAluno.getTelefone());

        return service.criarAluno(atualizado);
    }

    @DeleteMapping("/{id}")
    public void excluirAluno(@PathVariable Long id){
        service.deletarAluno(id);
    }

    @GetMapping("/{id}")
    public Aluno buscaAlunoPorID(@PathVariable Long id){
        return service.buscarAlunoId(id);
    }
}
