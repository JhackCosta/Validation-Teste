package br.com.estudo.springvalidation.Entitites;



import br.com.estudo.springvalidation.Controllers.UsuarioController;
import br.com.estudo.springvalidation.DTO.UsuarioDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ControllersTeste {

    @Autowired
    private UsuarioController metodo;


    /*Nesse metodo eu queria pegar 0 valor da resposta HTTP, porém ele sempre cria entao tta errado.
    achei que ele validava antes de adicionar */

    @Test
    public void TestePost(){

        UsuarioDTO usuario = new UsuarioDTO();
        usuario.setNome("j");
        usuario.setCpf("123.456.789-10");
        usuario.setDataNascimento(LocalDate.now());

        System.out.println("Resposta " + metodo.postUsuario(usuario));
        //retorno:
        //Resposta <201 CREATED Created,UsuarioRespostaDTO(id=1, nome=j, dataNascimento=2023-04-28),[]> //

    }



}
