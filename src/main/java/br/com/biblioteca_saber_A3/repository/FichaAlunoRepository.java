package br.com.biblioteca_saber_A3.repository;

import br.com.biblioteca_saber_A3.domain.FichaAluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FichaAlunoRepository extends JpaRepository<FichaAluno, String> {}
