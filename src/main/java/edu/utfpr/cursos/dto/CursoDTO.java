package edu.utfpr.cursos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record CursoDTO (
    Long id,

    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, message = "Nome deve possuir mais que 3 caracteres")
    String nome,

    @NotNull(message = "Carga horária é obrigatória")
    @Positive(message = "Carga horária deve ser maior que 0")
    Integer cargaHoraria,

    @NotBlank(message = "Categoria é obrigatória")
    String categoria,

    @NotNull(message = "O campo ativo é obrigatório")
    Boolean ativo
) {}