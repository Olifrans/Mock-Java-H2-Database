package com.aprende.oliveira.Servico;

import com.aprende.oliveira.Interface.AlunoRepository;
import com.aprende.oliveira.Model.Aluno;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {
    private final AlunoRepository repository;

    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    public List<Aluno> listaDeAluno(){
        return repository.findAll();
    }

    public Aluno criarAluno(Aluno alunos){
        return repository.save(alunos);
    }

    public Aluno buscarAlunoId(Long id){
        return repository.findById(id).orElse(null);
    }

    public void deletarAluno(Long id){
        repository.deleteById(id);
    }



}
