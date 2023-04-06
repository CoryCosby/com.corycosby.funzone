/*package com.corycosby.funzone.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserQueries {

  private static final String url = "jdbc:mysql://localhost:3306/mydb";
  private static final String user = "root";
  private static final String password = "mypassword";

  public static void main(String[] args) {
    try {
      // Create connection
      Connection conn = DriverManager.getConnection(url, user, password);

      // Execute custom queries
      findUsersByFirstName(conn, "O");
      findUsersByLastName(conn, "S");
      findUsersByEmail(conn, "@perscholasrocks.com");

      // Close connection
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void findUsersByFirstName(Connection conn, String firstName) throws SQLException {
    String query = "SELECT * FROM user WHERE first_name LIKE '" + firstName + "%'";
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery(query);
    while (rs.next()) {
      System.out.println(rs.getString("first_name") + " " + rs.getString("last_name"));
    }
    rs.close();
    stmt.close();
  }

  public static void findUsersByLastName(Connection conn, String lastName) throws SQLException {
    String query = "SELECT * FROM user WHERE last_name LIKE '" + lastName + "%'";
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery(query);
    while (rs.next()) {
      System.out.println(rs.getString("first_name") + " " + rs.getString("last_name"));
    }
    rs.close();
    stmt.close();
  }

  public static void findUsersByEmail(Connection conn, String email) throws SQLException {
    String query = "SELECT * FROM user WHERE email LIKE '%" + email + "'";
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery(query);
    while (rs.next()) {
      System.out.println(rs.getString("first_name") + " " + rs.getString("last_name"));
    }
    rs.close();
    stmt.close();
  }
}
*/