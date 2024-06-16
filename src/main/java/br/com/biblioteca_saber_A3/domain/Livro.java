package br.com.biblioteca_saber_A3.domain;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Livro {
    @Id
    private Integer codigoLivro;
    private String nomeLivro;
    private String autor;
    private String editora;
    private Integer ano;
    private String categoria;
    private String imagemLivro;
    private String dataReserva;
    private String dataDevolucao;
    private String status;
    private String cpfAluno;

    public Object getFichaAluno() {
        return null;
    }

    public void setFichaAluno(FichaAluno aluno) {

    }
}
