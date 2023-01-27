package SqlJdbs2;

import java.sql.*;

public class Food {
    private final String URL = "jdbc:postgresql://localhost:5433/jdbs2";
    private final String USER = "postgres";
    private final String PASSWORD = "12";
    private Connection connection;

    public Food() {
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

    public void getFood() {
        Food food = new Food();
        String query = "select * from food;";
        try {
            Statement statement = food.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt((1));
                String title_of_food = resultSet.getString(2);
                String about_food = resultSet.getString(3);
                int fk_cafesId = resultSet.getInt((4));
                System.out.print(id + " " + title_of_food + " - " + about_food + " " + "айди кафе - " + fk_cafesId);
                System.out.println();
                /*System.out.println(title);
                System.out.println(cuisine_type);*/
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
