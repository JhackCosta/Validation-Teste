package br.com.estudo.springvalidation.services;


import br.com.estudo.springvalidation.dtos.UsuarioDTO;
import br.com.estudo.springvalidation.dtos.UsuarioRespostaDTO;
import br.com.estudo.springvalidation.entites.Usuario;

import java.util.List;

public interface UsuarioService {

    UsuarioRespostaDTO createUsuario(UsuarioDTO usuarioDto);

    List<UsuarioRespostaDTO> getAllUsuario();

    UsuarioRespostaDTO getUsuarioById(long id);

    Usuario updateUsuario(long id, Usuario usuario);

    void deleteUsuario(long id);

    Usuario converterParaEntidade(UsuarioDTO usuarioDTO);

    UsuarioRespostaDTO converterParaDTO(Usuario usuario);
}
