package Exceptions;

public class MesmoNomeError extends Exception{
    public MesmoNomeError(String message) {
        super(message);
    }

    public String message() {
        return "J� existe uma ONG com esse nome.";
    }
}
