package com.aprende.oliveira.Interface;

import com.aprende.oliveira.Model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
