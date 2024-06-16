package br.com.biblioteca_saber_A3.controller;

import br.com.biblioteca_saber_A3.domain.FichaAluno;
import br.com.biblioteca_saber_A3.service.FichaAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class FichaAlunoController {
    @Autowired
    private FichaAlunoService fichaAlunoService;

    @PostMapping
    public ResponseEntity<FichaAluno> criarFichaAluno(@RequestBody FichaAluno fichaAluno) {
        return ResponseEntity.status(201).body(fichaAlunoService.criarFichaAluno(fichaAluno));
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<FichaAluno> buscarFichaAluno(@PathVariable String cpf) {
        FichaAluno fichaAluno = fichaAlunoService.buscarFichaAluno(cpf);
        if (fichaAluno != null) {
            return ResponseEntity.ok(fichaAluno);
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/todos")
    public ResponseEntity<List<FichaAluno>> listarTodosAlunos() {
        return ResponseEntity.ok(fichaAlunoService.listarTodosAlunos());
    }
}

