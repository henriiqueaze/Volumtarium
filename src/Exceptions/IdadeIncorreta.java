package Exceptions;

public class IdadeIncorreta extends Exception{
    public IdadeIncorreta(String message) {
        super(message);
    }

    public String message() {
        return "Idade não permitida para o cadastramento na oportunidade.";
    }
}
