import java.util.Scanner;

public class Move {
    public String next;

    void choice(){
        System.out.println("Выбирите время:"+"\n"+" день или вечер");
    }
    void scan(){
        Scanner scanner = new Scanner(System.in);
        next = scanner.next();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
