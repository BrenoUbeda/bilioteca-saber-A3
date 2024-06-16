package br.com.biblioteca_saber_A3.service;
import br.com.biblioteca_saber_A3.domain.Bibliotecario;
import br.com.biblioteca_saber_A3.domain.FichaAluno;
import br.com.biblioteca_saber_A3.domain.Livro;
import br.com.biblioteca_saber_A3.repository.BibliotecarioRepository;
import br.com.biblioteca_saber_A3.repository.FichaAlunoRepository;
import br.com.biblioteca_saber_A3.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BibliotecarioService {
    @Autowired
    private BibliotecarioRepository bibliotecarioRepository;
    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private FichaAlunoRepository fichaAlunoRepository;

    public Bibliotecario criarBibliotecario(Bibliotecario bibliotecario) {
        return bibliotecarioRepository.save(bibliotecario);
    }

    public Bibliotecario login(String email, String senha) {
        return bibliotecarioRepository.findByEmailAndSenha(email, senha);
    }



    public void reservarLivro(String cpfAluno, Integer codigoLivro) {
    }

    public void devolverLivro(String cpfAluno, Integer codigoLivro) {
    }
}


