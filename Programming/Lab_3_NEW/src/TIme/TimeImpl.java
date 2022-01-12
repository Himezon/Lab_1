package tIme;

import java.util.Objects;

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
    public int hashCode(){
        return Objects.hash(season);
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        if (this == obj)
            return true;
        TimeImpl other = (TimeImpl) obj;
        return Objects.equals(season, other.season);
    }
}
