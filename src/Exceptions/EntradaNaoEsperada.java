package Exceptions;

public class EntradaNaoEsperada extends Exception{
    public EntradaNaoEsperada(String message) {
        super(message);
    }

    public String message() {
        return "Entrada Inesperada! Favor, tente novamente.";
    }
}
