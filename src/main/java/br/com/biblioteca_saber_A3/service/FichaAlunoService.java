package br.com.biblioteca_saber_A3.service;

import br.com.biblioteca_saber_A3.domain.FichaAluno;
import br.com.biblioteca_saber_A3.dto.DevolucaoLivroDTO;
import br.com.biblioteca_saber_A3.dto.ReservaLivroDTO;
import br.com.biblioteca_saber_A3.repository.FichaAlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class FichaAlunoService {
    @Autowired
    private FichaAlunoRepository fichaAlunoRepository;
    @Autowired
    private BibliotecarioService bibliotecarioService;

    public FichaAluno criarFichaAluno(FichaAluno fichaAluno) {
        return fichaAlunoRepository.save(fichaAluno);
    }

    public FichaAluno buscarFichaAluno(String cpf) {
        return fichaAlunoRepository.findById(cpf).orElse(null);
    }

    public List<FichaAluno> listarTodosAlunos() {
        return fichaAlunoRepository.findAll();
    }

    @PostMapping("/reservar-livro")
    public ResponseEntity<Void> reservarLivro(@RequestBody ReservaLivroDTO reserva) {
        bibliotecarioService.reservarLivro(reserva.getCpfAluno(), reserva.getCodigoLivro());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/devolver-livro")
    public ResponseEntity<Void> devolverLivro(@RequestBody DevolucaoLivroDTO devolucao) {
        bibliotecarioService.devolverLivro(devolucao.getCpfAluno(), devolucao.getCodigoLivro());
        return ResponseEntity.ok().build();
    }
}



