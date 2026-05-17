package edu.utfpr.cursos.controller;

import edu.utfpr.cursos.dto.AlunoDTO;
import edu.utfpr.cursos.model.Aluno;
import edu.utfpr.cursos.repository.AlunoRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Tag(
        name = "Alunos",
        description = "Endpoints responsáveis pelo gerenciamento de alunos"
)
@RestController
@RequestMapping("/aluno")
public class AlunoController {
    private final AlunoRepository alunoRepository;

    public AlunoController(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    //Cadastra Aluno
    @PostMapping
    public ResponseEntity<Void> add(@Valid @RequestBody AlunoDTO alunoDTO) {
        this.alunoRepository.save(toAluno(alunoDTO));
        return ResponseEntity.ok().build();
    }

    //Consulta Aluno por ID
    @GetMapping("/{id}")
    public ResponseEntity<AlunoDTO> getOne(@PathVariable("id") Long id){
        Aluno alunoDB = this.alunoRepository.findById(id).orElse(null);
        if(alunoDB == null){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(toAlunoDTO(alunoDB));
        }
    }

    //Consulta uma lista de Alunos
    @GetMapping
    public ResponseEntity<Page<AlunoDTO>> getAllPageable(Pageable pageable){
        Page<Aluno> alunoPage = this.alunoRepository.findAll(pageable);
        return ResponseEntity.ok(alunoPage.map(this::toAlunoDTO));
    }

    //Atualiza um aluno
    @PutMapping("/{id}")
    public ResponseEntity<AlunoDTO> update(@PathVariable Long id, @Valid @RequestBody AlunoDTO alunoDTO) {
        Aluno aluno = this.alunoRepository.findById(id).orElse(null);
        if (aluno == null) {
            return ResponseEntity.notFound().build();
        }
        aluno.setNome(alunoDTO.nome());
        aluno.setIdade(alunoDTO.idade());
        aluno.setEmail(alunoDTO.email());
        aluno.setTelefone(alunoDTO.telefone());
        this.alunoRepository.save(aluno);
        return ResponseEntity.ok(toAlunoDTO(aluno));
    }

    //Deleta um aluno
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Aluno aluno = this.alunoRepository.findById(id).orElse(null);
        if (aluno == null) {
            return ResponseEntity.notFound().build();
        }
        this.alunoRepository.delete(aluno);
        return ResponseEntity.noContent().build();
    }


// Conversões de dados
    private Aluno toAluno(AlunoDTO alunoDTO) {
        Aluno aluno = new Aluno();
        aluno.setId(alunoDTO.id());
        aluno.setNome(alunoDTO.nome());
        aluno.setEmail(alunoDTO.email());
        aluno.setIdade(alunoDTO.idade());
        aluno.setTelefone(alunoDTO.telefone());
        return aluno;
    }

    private AlunoDTO toAlunoDTO(Aluno aluno) {
        AlunoDTO alunoDTO = new AlunoDTO(
                aluno.getId(),
                aluno.getNome(),
                aluno.getEmail(),
                aluno.getIdade(),
                aluno.getTelefone()
        );
        return alunoDTO;
    }
}