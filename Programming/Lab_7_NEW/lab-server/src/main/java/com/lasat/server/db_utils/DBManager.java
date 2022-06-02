package com.lasat.server.db_utils;

import com.lasat.common.data.Color;
import com.lasat.common.data.Country;
import com.lasat.common.data.Person;
import com.lasat.server.db_utils.DBConnector;
import com.lasat.server.utils.MD2Encryptor;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DBManager {

    private final DBConnector dbConnector = new DBConnector();
    private final MD2Encryptor encryptor = new MD2Encryptor();

    /*private void addConstantsToTable(Connection connection, String insertQuery, Object[] rows) throws SQLException {
        for (Object row : rows) {
            try (PreparedStatement addConstantToTable = connection.prepareStatement(insertQuery);) {
                addConstantToTable.setString(1, row.toString());
                addConstantToTable.execute();
            }
        }
    }*/

    public void init() {
        String idSequenceCreationQuery = DBEnum.CREATE_SEQUENCE.getQuery();
        String userTableCreationQuery = DBEnum.CREATE_USERS_TABLE.getQuery();
        String personTableCreationQuery = DBEnum.CREATE_PERSONS_TABLE.getQuery();
        try (
                Connection connection = dbConnector.getConnection();
                PreparedStatement idSequenceStatement = connection.prepareStatement(idSequenceCreationQuery);
                PreparedStatement userTableStatement = connection.prepareStatement(userTableCreationQuery);
                PreparedStatement personsTableStatement = connection.prepareStatement(personTableCreationQuery);
        ) {
            idSequenceStatement.execute();
            userTableStatement.execute();
            personsTableStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean checkIfUserRegistered(String username, String password) {
        String query = DBEnum.FIND_USER_BY_LOG_AND_PASS.getQuery();
        try (
                Connection connection = dbConnector.getConnection();
                PreparedStatement statement = connection.prepareStatement(query);
        ) {
            statement.setString(1, username);
            statement.setString(2, encryptor.encrypt(password));
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean registerNewUser(String userLogin, String userPassword) {
        String query = DBEnum.ADD_USER.getQuery();
        try (
                Connection connection = dbConnector.getConnection();
                PreparedStatement statement = connection.prepareStatement(query);
        ) {
            statement.setString(1, userLogin);
            statement.setString(2, encryptor.encrypt(userPassword));
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Long[] clearByUserName(String userLogin) {
        String query = DBEnum.CLEAR_ALL_PERSONS_BY_USER.getQuery();
        try (
                Connection connection = dbConnector.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)
        ) {
            statement.setString(1, userLogin);
            ResultSet resultSet = statement.executeQuery();
            List<Long> result = new ArrayList<>(); // Тут все удалённые id-шники
            while (resultSet.next()) {
                result.add(resultSet.getLong("id"));
            }
            Long[] ids = new Long[result.size()]; // Массив длиной в количество удалённых id-шников
            ids = result.toArray(ids);
            return ids;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public long clearByIdAndUserName(Long id, String userName) {
        String query = DBEnum.DELETE_PERSON_BY_ID.getQuery();
        try (
                Connection connection = dbConnector.getConnection();
                PreparedStatement statement = connection.prepareStatement(query);
        ) {
            statement.setLong(1, id);
            statement.setString(2, userName);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getLong("id");
            } else {
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public long addPersonToDB(Person person) {
        String query = DBEnum.ADD_PERSON.getQuery();
        try (
                Connection connection = dbConnector.getConnection();
                PreparedStatement statement = connection.prepareStatement(query);
        ) {
            Long id = generateId();
            int paramCounter = 1;
            statement.setLong(paramCounter++, id);
            paramCounter = setPersonInfoToStatementFromPersonName(statement, person, paramCounter);
            statement.setString(paramCounter, person.getAuthor());
            //System.out.println(paramCounter);
            statement.executeUpdate();
            return id;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
    private long generateId() {
        try (Connection connection = dbConnector.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(DBEnum.GENERATE_NEXT_ID.getQuery());
            if (rs.next()) {
                return rs.getInt("nextval");
            } else {
                return -1;
            }
        } catch (SQLException e) {
            return -1;
        }
    }

    public long updateByIdAndUser (Person person, Long id, String user) {
        String query = DBEnum.UPDATE_BY_ID_AND_USER.getQuery();
        try (
                Connection connection = dbConnector.getConnection();
                PreparedStatement statement = connection.prepareStatement(query);
        ) {
            int paramCounter = setPersonInfoToStatementFromPersonName(statement, person, 1);
            statement.setLong(paramCounter++, id);
            statement.setString(paramCounter++, user);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getLong("id");
            } else {
                return 0;
            }
        } catch (SQLException e) {
            return -1;
        }
    }

    private int setPersonInfoToStatementFromPersonName (PreparedStatement statement, Person person, int paramCounterStart) throws SQLException {
        int paramCounter = paramCounterStart;
        statement.setString(paramCounter++, person.getName());
        statement.setFloat(paramCounter++, person.getCoordinates().getX());
        statement.setInt(paramCounter++, person.getCoordinates().getY());
        statement.setTimestamp(paramCounter++, Timestamp.from(person.getCreationDate().toInstant()));
        statement.setLong(paramCounter++, person.getHeight());
        if (person.getWeight()!=null) {
            statement.setFloat(paramCounter++, person.getWeight());
        } else {
            statement.setNull(paramCounter++, Types.FLOAT);
        }
        if (person.getHairColor() != null) {
            statement.setString(paramCounter++, String.valueOf(person.getHairColor()));
        } else {
            statement.setNull(paramCounter++, Types.VARCHAR);
        }
        if (person.getNationality() != null) {
            statement.setString(paramCounter++, String.valueOf(person.getNationality()));
        } else {
            statement.setNull(paramCounter++, Types.VARCHAR);
        }
        statement.setInt(paramCounter++, person.getLocation().getX());
        statement.setDouble(paramCounter++, person.getLocation().getY());
        statement.setInt(paramCounter++, person.getLocation().getZ());
        return paramCounter;
    }
}
