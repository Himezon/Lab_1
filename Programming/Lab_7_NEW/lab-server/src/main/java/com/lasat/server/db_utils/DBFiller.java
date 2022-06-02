package com.lasat.server.db_utils;

import com.lasat.common.data.*;
import com.lasat.common.db_utils.DBWorker;
import com.lasat.server.utils.Encryptor;
import com.lasat.server.utils.MD2Encryptor;

import java.sql.*;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

public class DBFiller {

    private SortedMap<Long, Person> createPersonsSortedMapFromResultSet (ResultSet resultSet) throws SQLException {
        SortedMap<Long, Person> resultSortedMap = new TreeMap<>();
        while (resultSet.next()) {
            Person person = new Person();
            person.setAuthor(resultSet.getString("author"));
            person.setId(resultSet.getLong("id"));
            person.setName(resultSet.getString("person_name"));
            person.getCoordinates().setX(resultSet.getFloat("coordinates_x"));
            person.getCoordinates().setY(resultSet.getInt("coordinates_y"));
            person.setCreationDate(ZonedDateTime.ofInstant(resultSet.getTimestamp("creation_date").toInstant(), ZoneId.of("UTC")));
            person.setHeight(resultSet.getLong("height"));
            if (resultSet.getFloat("weight") <= 0) {
                person.setWeight(null);
            }
            if (resultSet.getString("hair_color") == null) {
                person.setHairColor("");
            }
            if (resultSet.getString("nationality") == null) {
                person.setNationality("");
            }
            person.getLocation().setX(resultSet.getInt("location_x"));
            person.getLocation().setY(resultSet.getDouble("location_y"));
            person.getLocation().setZ(resultSet.getInt("location_z"));
            resultSortedMap.put(person.getId(), person);
        }
        return resultSortedMap;
    }
    public SortedMap<Long, Person> getSortedMapPersons() {
        try {
            DBConnector dbConnector = new DBConnector();
            String query = "select * from persons";
            PreparedStatement statement = dbConnector.getConnection().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            return createPersonsSortedMapFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
