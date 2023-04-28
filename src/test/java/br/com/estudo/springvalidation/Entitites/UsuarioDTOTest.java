package br.com.estudo.springvalidation.Entitites;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import br.com.estudo.springvalidation.DTO.UsuarioDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/*Plano inicial é testar se o spring validation ta validando corretamente sem precisar ficar testando no postman*/

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UsuarioDTOTest {

    private final LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();

    @Test
    void testNomeNotBlank() {
        UsuarioDTO usuario = new UsuarioDTO();
        usuario.setNome("");
        usuario.setCpf("123.456.789-10");
        usuario.setDataNascimento(LocalDate.now());

        /*era para ele me retorna um BindException mas me retorna so java.lang.IllegalStateException*/
        assertThrows(org.springframework.validation.BindException.class, () -> validator.validate(usuario));


    }

}
