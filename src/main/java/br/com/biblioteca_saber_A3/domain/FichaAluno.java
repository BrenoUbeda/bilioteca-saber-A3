package br.com.biblioteca_saber_A3.domain;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class FichaAluno {
    private String nomeAluno;
    private String email;
    private String telefone;
    private String matricula;
    @Id
    private String cpfAluno;
    private Integer codigoLivro;

    public void setLivro(Livro livro) {
    }

}
