package misc;

public class BiteException extends RuntimeException {
    public BiteException() {
        super("Шкура не была пробита!");
    }
}