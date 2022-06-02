package com.lasat.common;

import com.lasat.common.data.Person;
import com.lasat.common.data.User;

import java.io.Serializable;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class Package implements Serializable {
    private User user;
    private String name;
    private String[] args;
    private Person person;
    private SortedMap<Long, Person> sortedMap;
    private String answer;
    private boolean checkedID;

    public Package (User user, String name, String[] args) {
        this.user = user;
        this.name = name;
        this.args = args;
    }
    public Package (User user, String name, String[] args, Person person) {
        this.user = user;
        this.name = name;
        this.args = args;
        this.person = person;
    }
    public Package (User user, String name, SortedMap<Long, Person> sortedMap) {
        this.user = user;
        this.name = name;
        this.sortedMap = sortedMap;
    }
    public Package (User user, String name, String answer) {
        this.user = user;
        this.name = name;
        this.answer = answer;
    }
    public Package (User user, String name, Person person) {
        this.user = user;
        this.name = name;
        this.person = person;
    }
    public Package (User user, String name, boolean checkedID) {
        this.checkedID = checkedID;
        this.user = user;
        this.name = name;
    }
    public Package (User user, String name) {
        this.user = user;
        this.name = name;
    }

    public boolean getCheckedID() { return checkedID; }

    public void setCheckedID(boolean checkedID) { this.checkedID = checkedID; }

    public User getUser () { return user; }

    public void setUser (User user) { this.user = user; }

    public String getName () {
        return name;
    }

    public String[] getArgs () {
        return args;
    }

    public Person getPerson () {
        return person;
    }

    public SortedMap<Long, Person> getSortedMap () {
        return sortedMap;
    }

    public String getAnswer () {
        return answer;
    }

    public void setArgs (String[] args) {
        this.args = args;
    }

    public void setName (String name) {
        this.name = name;
    }

    public void setPerson (Person person) {
        this.person = person;
    }

}
