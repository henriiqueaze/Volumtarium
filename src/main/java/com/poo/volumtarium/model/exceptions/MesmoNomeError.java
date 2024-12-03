package com.poo.volumtarium.model.exceptions;

public class MesmoNomeError extends Exception{
    public MesmoNomeError(String message) {
        super(message);
    }

    public String message() {
        return "Já existe uma ONG com esse nome.";
    }
}
