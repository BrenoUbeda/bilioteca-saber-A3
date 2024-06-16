package br.com.biblioteca_saber_A3.domain;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Bibliotecario {
    private String nomeBibliotecario;
    @Id
    private String cpfBibliotecario;
    private String email;
    private String usuario;
    private String senha;
}
