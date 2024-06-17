package br.com.biblioteca_saber_A3.domain;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class FichaAluno {
    private String nomeAluno;
    private String email;
    private String telefone;
    private String matricula;
    @Getter
    @Setter
    @Id
    private String cpfAluno;
    private Integer codigoLivro;

    public FichaAluno() {

    }

    public static String getCpfAluno() {
        return "";
    }


    public void setLivro(Livro livro) {
    }

}
