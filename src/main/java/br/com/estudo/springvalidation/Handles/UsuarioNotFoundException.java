package br.com.estudo.springvalidation.Handles;

public class UsuarioNotFoundException extends RuntimeException{

    public UsuarioNotFoundException( Long id){
        super( "Erro:\n Codigo: 1\n Mensagem: Usuario não encontrado com o id " + id);
    }
}

