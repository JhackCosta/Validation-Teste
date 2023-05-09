package br.com.estudo.springvalidation.entites;


import com.fasterxml.jackson.annotation.JsonFormat;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@Setter @Getter
@NoArgsConstructor
public class Usuario {

    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "CPF")
    private String cpf;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(name = "DATA_NASCIMENTO")
    private LocalDate dataNascimento;

}
