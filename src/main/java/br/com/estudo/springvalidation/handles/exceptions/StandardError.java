package br.com.estudo.springvalidation.handles.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Getter @Setter
public class StandardError {

    private LocalDateTime timestamp;
    private Integer Status;
    private String error;
    private String path;

}
