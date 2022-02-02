package misc;

public enum Feeling {
    NICE("nice"),
    DISGUSTING("disgusting");

    private final String feeling;

    Feeling(String feeling) {
        this.feeling = feeling;
    }

    @Override
    public String toString() {
        return feeling;
    }
}
