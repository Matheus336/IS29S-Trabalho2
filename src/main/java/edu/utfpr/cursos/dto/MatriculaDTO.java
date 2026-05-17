package edu.utfpr.cursos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record MatriculaDTO(
        Long id,

        @NotNull(message = "Data é obrigatória")
        LocalDate dataMatricula,

        @NotBlank(message = "Status é obrigatório")
        String status,

        @NotNull(message = "Aluno é obrigatório")
        Long alunoId,

        @NotNull(message = "Curso é obrigatório")
        Long cursoId
) {}
