package SqlJdbs2;

import java.sql.*;

public class Orders {
    private final String URL = "jdbc:postgresql://localhost:5433/jdbs2";
    private final String USER = "postgres";
    private final String PASSWORD = "12";
    private Connection connection;

    public Orders() {
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

    public void getOrders() {
        Orders orders = new Orders();
        String query = "select * from orders;";
        try {
            Statement statement = orders.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt((1));
                int fk_cafesId = resultSet.getInt(2);
                int fk_foodId = resultSet.getInt(3);
                String who_take_order = resultSet.getString(4);
                System.out.print("айди заказа " + id + " айди кафе " + fk_cafesId + " айди блюда " + fk_foodId
                + " заказ для " + who_take_order);
                System.out.println();
                /*System.out.println(title);
                System.out.println(cuisine_type);*/
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
