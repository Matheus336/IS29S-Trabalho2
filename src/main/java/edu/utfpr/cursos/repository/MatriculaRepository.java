package edu.utfpr.cursos.repository;

import edu.utfpr.cursos.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
}
