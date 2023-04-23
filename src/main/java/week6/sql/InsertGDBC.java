package week6.sql;

import java.sql.*;

public class InsertGDBC {

    public static final String URL = "jdbc:mysql://localhost:3306/acp12";
    public static final String USER = "admin";
    public static final String PASS = "!Made1989";
    public static final String ALL_QUERY = "SELECT id, full_name, age, birth_date,  salary, address_id FROM students";

    public static void main(String[] args) {

        StudentSQL student = new StudentSQL(-1, "Solovey", 0, new java.util.Date(), 6800, 1);


        try (Connection connection = DriverManager.getConnection(URL, USER, PASS);
             Statement statement = connection.createStatement();) {
            connection.setAutoCommit(false);
            statement.executeUpdate(String.format("INSERT INTO students(id, full_name, age, birth_date,  salary, address_id) VALUES (%1$s, '%2$s', %3$s, '%4$ty-%4$tm-%4$td', %5$.2f, %6$s)",
                    student.getId(),
                    student.getFullName(),
                    student.getAge(),
                    student.getBirthDate(),
                    student.getSalary(),
                    student.getAddressId()));
            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}