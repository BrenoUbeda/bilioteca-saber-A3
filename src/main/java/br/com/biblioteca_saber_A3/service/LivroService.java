package br.com.biblioteca_saber_A3.service;

import br.com.biblioteca_saber_A3.domain.Livro;
import br.com.biblioteca_saber_A3.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    public Livro cadastrarLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    public Livro atualizarLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    public void apagarLivro(Integer codigo) {
        livroRepository.deleteById(codigo);
    }

    public Livro buscarLivro(Integer codigo) {
        return livroRepository.findById(codigo).orElse(null);
    }
}