package br.com.biblioteca_saber_A3.controller;
import br.com.biblioteca_saber_A3.domain.Bibliotecario;
import br.com.biblioteca_saber_A3.domain.FichaAluno;
import br.com.biblioteca_saber_A3.domain.Livro;
import br.com.biblioteca_saber_A3.repository.FichaAlunoRepository;
import br.com.biblioteca_saber_A3.repository.LivroRepository;
import br.com.biblioteca_saber_A3.service.BibliotecarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/bibliotecarios")
public class BibliotecarioController {
    @Autowired
    private BibliotecarioService bibliotecarioService;
    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private FichaAlunoRepository fichaAlunoRepository;

    @PostMapping
    public ResponseEntity<Bibliotecario> criarBibliotecario(@RequestBody Bibliotecario bibliotecario) {
        return ResponseEntity.status(201).body(bibliotecarioService.criarBibliotecario(bibliotecario));
    }

    @PostMapping("/login")
    public ResponseEntity<Bibliotecario> login(@RequestBody Map<String, String> credenciais) {
        Bibliotecario bibliotecario = bibliotecarioService.login(credenciais.get("email"), credenciais.get("senha"));
        if (bibliotecario != null) {
            return ResponseEntity.ok(bibliotecario);
        } else {
            return ResponseEntity.status(401).build();
        }
    }
    @PostMapping("/reservar-livro")
    public void reservarLivro(String cpfAluno, Integer codigoLivro) {
        Livro livro = livroRepository.findById(codigoLivro).orElse(null);
        if (livro != null && livro.getFichaAluno() == null) {
            FichaAluno aluno = fichaAlunoRepository.findById(cpfAluno).orElse(null);
            if (aluno != null) {
                livro.setFichaAluno(aluno);
                livroRepository.save(livro);
                aluno.setLivro(livro);
                fichaAlunoRepository.save(aluno);
            }
        }


    }
    @PostMapping("/devolver-livro")
    public void devolverLivro(String cpfAluno, Integer codigoLivro) {

    }



}
