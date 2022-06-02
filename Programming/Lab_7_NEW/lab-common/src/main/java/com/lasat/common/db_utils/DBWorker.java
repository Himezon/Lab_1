package com.lasat.common.db_utils;

import com.lasat.common.data.Person;
import com.lasat.common.data.User;

import java.util.SortedMap;
import java.util.TreeMap;

public interface DBWorker {

    long addPerson(Person person, User user);
    long addUser(User user);
    long updatePerson(Person person);
    long checkUser(User user);
    long deletePersonsByUser(User user);
    long deletePersonById(long personId);
    SortedMap<Long, Person> selectAllPersons();

}