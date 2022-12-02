package com.example.lab3web.beans;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ClockBean implements Serializable {
    private String time;

    public ClockBean() {
        updateTime();
    }

    public void updateTime() {
        time = ZonedDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss - VV O"));
    }

    public String getTime() {
        updateTime();
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
