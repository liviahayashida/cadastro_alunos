package com.example.cadastro_alunos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.cadastro_alunos.model.Aluno;
import com.example.cadastro_alunos.repository.AlunoRepository;

@Service 
public class AlunoService {
    private AlunoRepository alunoRepository;
    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }


    public Aluno cadastrar(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public List<Aluno> listarTodos() {
        return alunoRepository.findAll();
    }

    public Aluno buscarPorId(Long id){
        return alunoRepository.findById(id).orElse(null);
    }
    
    public void excluirPorId(Long id){
        alunoRepository.deleteById(id);
    }

    public Aluno atualizar(Long id, Aluno alunoNovosDados){
        Aluno alunoExistente = alunoRepository.findById(id).orElse(null);
        if (alunoExistente != null) {
            alunoExistente.setNome(alunoNovosDados.getNome());
            alunoExistente.setEmail(alunoNovosDados.getEmail());
            alunoExistente.setCurso(alunoNovosDados.getCurso());
            return alunoRepository.save(alunoExistente);
        }
        return null;
    }
}