package br.com.biblioteca_saber_A3.controller;

import br.com.biblioteca_saber_A3.domain.Livro;
import br.com.biblioteca_saber_A3.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/livros")
public class LivroController {
    @Autowired
    private LivroService livroService;

    @PostMapping
    public ResponseEntity<Livro> cadastrarLivro(@RequestParam("imagemLivro") MultipartFile imagemLivro, @RequestPart Livro livro) {
        // Processar upload da imagem
        // Definir caminho da imagem no objeto livro
        return ResponseEntity.status(201).body(livroService.cadastrarLivro(livro));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Livro> atualizarLivro(@PathVariable Integer codigo, @RequestBody Livro livro) {
        livro.setCodigoLivro(codigo);
        return ResponseEntity.ok(livroService.atualizarLivro(livro));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> apagarLivro(@PathVariable Integer codigo) {
        livroService.apagarLivro(codigo);
        return ResponseEntity.status(200).build();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Livro> buscarLivro(@PathVariable Integer codigo) {
        Livro livro = livroService.buscarLivro(codigo);
        if (livro != null) {
            return ResponseEntity.ok(livro);
        } else {
            return ResponseEntity.status(404).build();
        }
    }
}