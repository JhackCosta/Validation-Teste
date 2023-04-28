package br.com.estudo.springvalidation.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class UsuarioDTO {

    @NotBlank
    @NotNull
    @Size(min = 6, max = 50)
    private String nome;

    @NotBlank
    @NotNull
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}|\\d{3}\\.\\d{3}\\.\\d{3}\\.\\d{2}")
    private String cpf;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

}
