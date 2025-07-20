package com.techlab.sysgestion.exception;

public class ClientNotFound extends RuntimeException{
    public ClientNotFound(String message){
        super(message);
    }

    public ClientNotFound(String message, Throwable cause){
        super(message, cause);
    }
}
