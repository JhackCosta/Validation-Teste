package br.com.estudo.springvalidation.handles;

public class UsuarioNotFoundException extends RuntimeException{

    public UsuarioNotFoundException(String message){
        super(message);
    }
}

