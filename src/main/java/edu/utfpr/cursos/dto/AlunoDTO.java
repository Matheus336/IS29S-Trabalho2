package edu.utfpr.cursos.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public record AlunoDTO(
        Long id,

        @NotBlank(message = "Nome é obrigatório")
        String nome,

        @NotBlank(message = "E-mail é obrigatório")
        @Email(message = "E-mail precisa ser válido")
        String email,

        @NotNull(message = "Idade é obrigatória")
        @Min(value = 16, message = "Idade deve ser maior ou igual a 16")
        Integer idade,

        String telefone
) {}
