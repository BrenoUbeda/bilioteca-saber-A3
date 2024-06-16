package br.com.biblioteca_saber_A3.repository;
import br.com.biblioteca_saber_A3.domain.Bibliotecario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BibliotecarioRepository extends JpaRepository<Bibliotecario, String> {
    Bibliotecario findByEmailAndSenha(String email, String senha);
}