package br.com.estudo.springvalidation.entites;


import com.fasterxml.jackson.annotation.JsonFormat;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Usuario {

    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "CPF", unique = true)
    private String cpf;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(name = "DATA_NASCIMENTO")
    private LocalDate dataNascimento;

}
