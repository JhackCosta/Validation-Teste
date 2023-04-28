package br.com.estudo.springvalidation.Controllers;


import br.com.estudo.springvalidation.DTO.UsuarioDTO;
import br.com.estudo.springvalidation.DTO.UsuarioRespostaDTO;
import br.com.estudo.springvalidation.Service.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController

@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl service;

    @GetMapping("/list")
    public List<UsuarioRespostaDTO> getAllUsuario() {
        return service.getAllUsuario();
    }

    @GetMapping("/id={id}")
    public UsuarioRespostaDTO findById(@PathVariable Long id){
        return service.getUsuarioById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<UsuarioRespostaDTO> postUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO) {
            return new ResponseEntity<>(service.createUsuario(usuarioDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete={id}")
    public void deleteUsuario(@PathVariable Long id){
        service.deleteUsuario(id);
    }

}
