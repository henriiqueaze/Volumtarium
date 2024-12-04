package com.poo.volumtarium.model.exceptions;

public class ListaVazia extends Exception{

    public ListaVazia(String message) {
        super(message);
    }

    public String message(){
        return "A lista encontra-se vazia.";
    }
}
