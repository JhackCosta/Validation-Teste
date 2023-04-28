package br.com.estudo.springvalidation.Service;


import br.com.estudo.springvalidation.DTO.UsuarioDTO;
import br.com.estudo.springvalidation.DTO.UsuarioRespostaDTO;
import br.com.estudo.springvalidation.Handles.UsuarioNotFoundException;
import br.com.estudo.springvalidation.Repository.UsuarioRepostiory;
import br.com.estudo.springvalidation.entites.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private final UsuarioRepostiory repostiory;

    @Autowired
    private ModelMapper modelMapper;

    public UsuarioServiceImpl(UsuarioRepostiory repostiory) {
       this.repostiory = repostiory;
    }

    @Override
    public UsuarioRespostaDTO createUsuario(UsuarioDTO usuarioDto) {
       Usuario user =  repostiory.save(converterParaEntidade(usuarioDto));
       return converterParaDTO(user);
    }

    @Override
    public List<UsuarioRespostaDTO> getAllUsuario() {

       List<Usuario> usuario = repostiory.findAll();
       List<UsuarioRespostaDTO> listResposnse = new ArrayList<>();

        for( Usuario users: usuario){
            listResposnse.add(converterParaDTO(users));
        }
        return listResposnse;
    }

    @Override
    public UsuarioRespostaDTO getUsuarioById(long id) {

        Usuario result = repostiory.findById(id)
                .orElseThrow(()-> new UsuarioNotFoundException(id));

        return converterParaDTO(result);
    }

    @Override
    public Usuario updateUsuario(long id, Usuario usuarioRequest) {

        Usuario usuario = repostiory.findById(id)
               .orElseThrow(()-> new UsuarioNotFoundException(id));

        usuario.setNome(usuarioRequest.getNome());
        usuario.setCpf(usuarioRequest.getCpf());
        usuario.setDataNascimento(usuarioRequest.getDataNascimento());

        return repostiory.save(usuario);
    }

    @Override
    public void deleteUsuario(long id) {
        Usuario usuario = repostiory.findById(id)
                .orElseThrow(()-> new UsuarioNotFoundException(id));

        repostiory.delete(usuario);
    }

    @Override
    public Usuario converterParaEntidade(UsuarioDTO usuarioDTO) {
        return modelMapper.map(usuarioDTO, Usuario.class);
    }

    @Override
    public UsuarioRespostaDTO converterParaDTO(Usuario usuario) {
        return modelMapper.map(usuario, UsuarioRespostaDTO.class);
    }

}
