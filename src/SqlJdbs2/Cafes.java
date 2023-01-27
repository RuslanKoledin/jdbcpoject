package SqlJdbs2;

import studentsDatabase.Students;

import java.sql.*;

public class Cafes {
    private final String URL = "jdbc:postgresql://localhost:5433/jdbs2";
    private final String USER = "postgres";
    private final String PASSWORD = "12";
    private Connection connection;

    public Cafes() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    public void getCafes() {
        Cafes cafes = new Cafes();
        String query = "select * from cafes;";
        try {
            Statement statement = cafes.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt((1));
                String title = resultSet.getString(2);
                String cuisine_type = resultSet.getString(3);
                System.out.print(id + " "+ title + "-" + cuisine_type);
                System.out.println();
                /*System.out.println(title);
                System.out.println(cuisine_type);*/
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
