package br.com.estudo.springvalidation.controllers;


import br.com.estudo.springvalidation.dtos.UsuarioDTO;
import br.com.estudo.springvalidation.dtos.UsuarioRespostaDTO;
import br.com.estudo.springvalidation.services.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import javax.validation.Valid;
import java.util.List;


@RestController

@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl service;

    @GetMapping("/list")
    public ResponseEntity<Object> getAllUsuario() {

        List<UsuarioRespostaDTO> response = service.getAllUsuario();
        if (response.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            for(UsuarioRespostaDTO user: response){
                long id = user.getId();
                user.add(linkTo(methodOn(UsuarioController.class).findById(id)).withSelfRel());
            }
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @GetMapping("/id={id}")
    public ResponseEntity<UsuarioRespostaDTO> findById(@PathVariable Long id){

        UsuarioRespostaDTO response = service.getUsuarioById(id);

        response.add(linkTo(methodOn(UsuarioController.class).getAllUsuario()).withRel("Lista completa"));
        return new ResponseEntity<>( response, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<UsuarioRespostaDTO> postUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO) {
            return new ResponseEntity<>(service.createUsuario(usuarioDTO), HttpStatus.CREATED);
    }

    @PutMapping ("/update/id={id}")
    public ResponseEntity<UsuarioRespostaDTO> alter(@PathVariable Long id,@RequestBody @Valid UsuarioDTO usuarioDTO){
        return new ResponseEntity<>(service.updateUsuario(id, usuarioDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete={id}")
    public void deleteUsuario(@PathVariable Long id){
        service.deleteUsuario(id);
    }

}
