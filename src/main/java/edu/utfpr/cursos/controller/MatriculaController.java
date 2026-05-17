package edu.utfpr.cursos.controller;

import edu.utfpr.cursos.dto.MatriculaDTO;
import edu.utfpr.cursos.model.Aluno;
import edu.utfpr.cursos.model.Curso;
import edu.utfpr.cursos.model.Matricula;
import edu.utfpr.cursos.repository.AlunoRepository;
import edu.utfpr.cursos.repository.CursoRepository;
import edu.utfpr.cursos.repository.MatriculaRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Tag(
        name = "Matriculas",
        description = "Endpoints responsáveis pelo gerenciamento de matriculas"
)
@RestController
@RequestMapping("/matricula")
public class MatriculaController {

    private final MatriculaRepository matriculaRepository;
    private final AlunoRepository alunoRepository;
    private final CursoRepository cursoRepository;

    public MatriculaController(
            MatriculaRepository matriculaRepository,
            AlunoRepository alunoRepository,
            CursoRepository cursoRepository
    ) {
        this.matriculaRepository = matriculaRepository;
        this.alunoRepository = alunoRepository;
        this.cursoRepository = cursoRepository;
    }

    // Cadastra matrícula
    @PostMapping
    public ResponseEntity<Void> add(@Valid @RequestBody MatriculaDTO matriculaDTO) {
        Matricula matricula = toMatricula(matriculaDTO);
        if (matricula == null) {
            return ResponseEntity.badRequest().build();
        }
        this.matriculaRepository.save(matricula);
        return ResponseEntity.ok().build();
    }

    // Busca matrícula por ID
    @GetMapping("/{id}")
    public ResponseEntity<MatriculaDTO> getOne(@PathVariable Long id) {
        Matricula matricula = this.matriculaRepository.findById(id).orElse(null);
        if (matricula == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(toMatriculaDTO(matricula));
    }

    // Lista todas as matrículas
    @GetMapping
    public ResponseEntity<Page<MatriculaDTO>> getAll(Pageable pageable) {
        Page<Matricula> matriculaPage = this.matriculaRepository.findAll(pageable);
        return ResponseEntity.ok(matriculaPage.map(this::toMatriculaDTO));
    }

    // Atualiza matrícula
    @PutMapping("/{id}")
    public ResponseEntity<MatriculaDTO> update(
            @PathVariable Long id,
            @Valid @RequestBody MatriculaDTO matriculaDTO
    ) {
        Matricula matricula = this.matriculaRepository.findById(id).orElse(null);
        if (matricula == null) {
            return ResponseEntity.notFound().build();
        }
        Aluno aluno = this.alunoRepository.findById(matriculaDTO.alunoId()).orElse(null);
        Curso curso = this.cursoRepository.findById(matriculaDTO.cursoId()).orElse(null);
        if (aluno == null || curso == null) {
            return ResponseEntity.badRequest().build();
        }
        matricula.setDataMatricula(matriculaDTO.dataMatricula());
        matricula.setStatus(matriculaDTO.status());
        matricula.setAluno(aluno);
        matricula.setCurso(curso);
        this.matriculaRepository.save(matricula);
        return ResponseEntity.ok(toMatriculaDTO(matricula));
    }

    // Deleta matrícula
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Matricula matricula = this.matriculaRepository.findById(id).orElse(null);
        if (matricula == null) {
            return ResponseEntity.notFound().build();
        }
        this.matriculaRepository.delete(matricula);
        return ResponseEntity.noContent().build();
    }

    // Conversões
    private Matricula toMatricula(MatriculaDTO matriculaDTO) {
        Aluno aluno = this.alunoRepository.findById(matriculaDTO.alunoId()).orElse(null);
        Curso curso = this.cursoRepository.findById(matriculaDTO.cursoId()).orElse(null);
        if (aluno == null || curso == null) {
            return null;
        }
        Matricula matricula = new Matricula();
        matricula.setId(matriculaDTO.id());
        matricula.setDataMatricula(matriculaDTO.dataMatricula());
        matricula.setStatus(matriculaDTO.status());
        matricula.setAluno(aluno);
        matricula.setCurso(curso);
        return matricula;
    }

    private MatriculaDTO toMatriculaDTO(Matricula matricula) {
         MatriculaDTO matriculaDTO = new MatriculaDTO(
                matricula.getId(),
                matricula.getDataMatricula(),
                matricula.getStatus(),
                matricula.getAluno().getId(),
                matricula.getCurso().getId()
        );
        return matriculaDTO;
    }
}