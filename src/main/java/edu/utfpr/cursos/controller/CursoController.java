package edu.utfpr.cursos.controller;

import edu.utfpr.cursos.dto.CursoDTO;
import edu.utfpr.cursos.model.Aluno;
import edu.utfpr.cursos.model.Curso;
import edu.utfpr.cursos.repository.CursoRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Tag(
        name = "Curso",
        description = "Endpoints responsáveis pelo gerenciamento de cursos"
)
@RestController
@RequestMapping("/curso")
public class CursoController {
    private final CursoRepository cursoRepository;
    public CursoController(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    // Cadastra Curso
    @PostMapping
    public ResponseEntity<Void> add(@Valid @RequestBody CursoDTO cursoDTO) {
        this.cursoRepository.save(toCurso(cursoDTO));
        return ResponseEntity.ok().build();
    }

    // Consulta Curso por ID
    @GetMapping("/{id}")
    public ResponseEntity<CursoDTO> getOne(@PathVariable Long id) {
        Curso cursoDB = this.cursoRepository.findById(id).orElse(null);
        if (cursoDB == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(toCursoDTO(cursoDB));
    }

    // Consulta lista de Cursos
    @GetMapping
    public ResponseEntity<Page<CursoDTO>> getAll(Pageable pageable) {
        Page<Curso> cursoPage = this.cursoRepository.findAll(pageable);
        return ResponseEntity.ok(cursoPage.map(this::toCursoDTO));
    }

    // Atualiza Curso
    @PutMapping("/{id}")
    public ResponseEntity<CursoDTO> update( @PathVariable Long id, @Valid @RequestBody CursoDTO cursoDTO) {
        Curso curso = this.cursoRepository.findById(id).orElse(null);
        if (curso == null) {
            return ResponseEntity.notFound().build();
        }
        curso.setNome(cursoDTO.nome());
        curso.setCargaHoraria(cursoDTO.cargaHoraria());
        curso.setCategoria(cursoDTO.categoria());
        curso.setAtivo(cursoDTO.ativo());
        this.cursoRepository.save(curso);
        return ResponseEntity.ok(toCursoDTO(curso));
    }

    // Deleta Curso
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Curso curso = this.cursoRepository.findById(id).orElse(null);
        if (curso == null) {
            return ResponseEntity.notFound().build();
        }
        this.cursoRepository.delete(curso);
        return ResponseEntity.noContent().build();
    }

    // Conversões
    private Curso toCurso(CursoDTO cursoDTO) {
        Curso curso = new Curso();
        curso.setId(cursoDTO.id());
        curso.setNome(cursoDTO.nome());
        curso.setCargaHoraria(cursoDTO.cargaHoraria());
        curso.setCategoria(cursoDTO.categoria());
        curso.setAtivo(cursoDTO.ativo());
        return curso;
    }

    private CursoDTO toCursoDTO(Curso curso) {
         CursoDTO cursoDTO = new CursoDTO(
                curso.getId(),
                curso.getNome(),
                curso.getCargaHoraria(),
                curso.getCategoria(),
                curso.getAtivo()
        );
        return cursoDTO;
    }
}