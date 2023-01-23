package studentsDatabase;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Students students = new Students();
        System.out.println("Имя студента с определенной буквой");
        students.getStudentsName();
        System.out.println("возвраст самого взрослого студента");
        students.getMaxAge();
        System.out.println("возвраст самого молодого студента");
        students.getMinAge();
        System.out.println("средняя оценка всех студентво");
        students.getAvgRatings();
        System.out.println("количество студентов");
        students.getCountOfStudenets();
        System.out.println("сумма степендии всех студентов");
        students.getScholarshipsStudents();
        System.out.println("студент добавлен!");
        students.addStud();



    }
}