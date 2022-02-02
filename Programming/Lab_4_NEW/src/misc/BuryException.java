package misc;

public class BuryException extends RuntimeException {
    public BuryException() {
        super("Не получилось закопаться!");
    }
}