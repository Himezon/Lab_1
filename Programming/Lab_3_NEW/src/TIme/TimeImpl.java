package TIme;

public class TimeImpl implements Time{

    @Override
    public void changeTime(TimeEnum time){
        System.out.println("Наступил/а " + time.getName() + ".");
    }
}
