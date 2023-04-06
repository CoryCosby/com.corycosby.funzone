/*package com.corycosby.funzone.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserQueriesRun {

    public static void main(String[] args) {
        UserQueries userQueries = new UserQueries();
        try {
            // Create connection
            Connection conn = DriverManager.getConnection(userQueries.getUrl(), userQueries.getUser(), userQueries.getPassword());

            // Execute custom queries
            userQueries.findUsersByFirstName(conn, "O");
            userQueries.findUsersByLastName(conn, "S");
            userQueries.findUsersByEmail(conn, "@perscholasrocks.com");

            // Close connection
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
*/