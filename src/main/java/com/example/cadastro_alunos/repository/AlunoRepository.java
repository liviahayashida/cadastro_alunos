package com.example.cadastro_alunos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cadastro_alunos.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}