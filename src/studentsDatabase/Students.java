package studentsDatabase;

import java.sql.*;

public class Students {
    private final String URL = "jdbc:postgresql://localhost:5433/students";
    private final String USER = "postgres";
    private final String PASSWORD = "12";
    private Connection connection;

    public Students() {
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

    //Выборка студентов с  в буквой А
    public void getStudentsName() {
        Students students = new Students();
        String query = "select full_name from students where full_name like '%a%';";
        try {
            Statement statement = students.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String fullName = resultSet.getString("full_name");
                System.out.println(fullName);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Самый высокий возвраст среди студентов
    public void getMaxAge() {
        Students students = new Students();
        String query2 = "select max(age) as old_student from students";
        try {
            Statement statement2 = students.getConnection().createStatement();
            ResultSet resultSet2 = statement2.executeQuery((query2));
            while (resultSet2.next()) {
                int maxAge = resultSet2.getInt(1);
                System.out.println(maxAge);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Самый минимальный возвраст среди студентоv
    public void getMinAge() {
        Students students = new Students();
        String query = "select min(age) as old_student from students";
        try {
            Statement statement = students.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery((query));
            while (resultSet.next()) {
                int minAge = resultSet.getInt(1);
                System.out.println(minAge);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
        //среднее значение оценок всех студентво
    public void getAvgRatings() {
        Students students1 = new Students();
        String query1 = "select avg(ratings_students) as avg_rating from students;";
        try {
            Statement statement = students1.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery((query1));
            while (resultSet.next()) {
                int avg = resultSet.getInt(1);
                System.out.println(avg);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //получение количества всех студентво
    public void getCountOfStudenets() {
        Students students1 = new Students();
        String query1 = "select max(age) as old_student from students";
        try {
            Statement statement = students1.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query1);
            while (resultSet.next()) {
                int count = resultSet.getInt(1);
                System.out.println(count);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //суммах степендии всех студентов
    public  void getScholarshipsStudents() {
        Students students = new Students();
        String query = "select sum(scholarships) as scholarships_students from students";
        try {
            Statement statement = students.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int scholarships = resultSet.getInt(1);
                System.out.println(scholarships);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
        //добавление студента
    public void addStud() {
        Students students1 = new Students();
        String update = "insert into students values (8,'Rus',19,3,800)";
        try {
            Statement statement2 = connection.createStatement();
            statement2.executeUpdate(update);
            System.out.println("Update is correct");
        } catch (SQLException e) {
            System.out.println("Error");
            throw new RuntimeException(e);
        }
    }
}


