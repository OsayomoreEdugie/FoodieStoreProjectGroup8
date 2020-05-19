package DBconnection;


import Users.User;

import java.sql.*;
import java.util.ArrayList;

public class DBUserQueries {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    private ArrayList<User> userInformation;

    public DBUserQueries() {
        try {

            this.statement = connection.createStatement();

            this.userInformation = new ArrayList<>();
        } catch (SQLException sq) {
            System.out.println(sq.getMessage());
        }
    }

}






