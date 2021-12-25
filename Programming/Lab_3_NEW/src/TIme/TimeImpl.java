package TIme;

public class TimeImpl implements Time{
    private String season;

    public TimeImpl(String season){
        this.season = season;
    }

    @Override
    public void changeTime(TimeEnum time){
        System.out.println(time.getName() + " has come.");
    }

    public  String getMsg(String msg){
        switch (msg){
            case "summer":
                return "wasn't dark";

            case "winter":
                return "was dark";

            case "spring":
                return "little dark";

            case "autumn":
                return "little dark";
        }
        return msg;
    }

    public String getSeason(){
        return season;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
