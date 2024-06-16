package br.com.biblioteca_saber_A3.repository;
import br.com.biblioteca_saber_A3.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Integer> {

}
