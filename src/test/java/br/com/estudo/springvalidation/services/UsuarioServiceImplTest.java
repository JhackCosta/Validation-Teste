package br.com.estudo.springvalidation.services;

import br.com.estudo.springvalidation.dtos.UsuarioDTO;
import br.com.estudo.springvalidation.dtos.UsuarioRespostaDTO;
import br.com.estudo.springvalidation.entites.Usuario;
import br.com.estudo.springvalidation.repositories.UsuarioRepostiory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UsuarioServiceImplTest {

    private final long id = 1L;
    private final String nome = "Joao silva";
    private final String cpf = "876.887.878.87";
    private final LocalDate dataNascimento = LocalDate.now();

    @InjectMocks
    private UsuarioServiceImpl service;

    @Mock
    private  UsuarioRepostiory repository;

    @Mock
    private ModelMapper modelMapper;

    private Usuario user;
    private UsuarioDTO userDTO;
    private UsuarioRespostaDTO userRespostaDTO;
    private Optional<Usuario> opcionalUser;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    void whenFindByIdThenDTOResponse() {

        Mockito.when(repository.findById(id)).thenReturn(opcionalUser);
        Mockito.when(service.getUsuarioById(id)).thenReturn(userRespostaDTO);

        UsuarioRespostaDTO response = service.getUsuarioById(id);

        Assertions.assertEquals(UsuarioRespostaDTO.class, response.getClass());

    }

    @Test
    void createUsuario() {

    }

    @Test
    void getAllUsuario() {
    }



    @Test
    void updateUsuario() {
    }

    @Test
    void deleteUsuario() {
    }

    @Test
    void converterParaEntidade() {
    }

    @Test
    void converterParaDTO() {
    }

    private void startUser(){
        user = new Usuario(id, nome, cpf, dataNascimento);
        userDTO = new UsuarioDTO(nome, cpf, dataNascimento);
        userRespostaDTO = new UsuarioRespostaDTO(id, nome, dataNascimento);
        opcionalUser = Optional.of(new Usuario(id, nome, cpf, dataNascimento));

    }
}