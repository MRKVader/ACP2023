package week6.sql;

import java.sql.*;

public class InsertPreparementStatmentGDBC {

    public static final String URL = "jdbc:mysql://localhost:3306/acp12";
    public static final String USER = "admin";
    public static final String PASS = "!Made1989";
    public static final String ALL_QUERY = "SELECT id, full_name, age, birth_date,  salary, address_id FROM students";

    public static void main(String[] args) {

        StudentSQL student = new StudentSQL(((int) (Math.random() * 1000)), "Solovey", 0, new java.util.Date(), 6800, 1);


        try (Connection connection = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement preparedStatement =
                     connection.prepareStatement("INSERT INTO students(id, full_name, age, birth_date,  salary, address_id) VALUES (?, ?, ?, ?, ?, ?)");) {

            preparedStatement.setInt(1, student.getId());
            preparedStatement.setString(2, student.getFullName());
            preparedStatement.setInt(3, 0);
            preparedStatement.setDate(4,new Date(student.getBirthDate().getTime()));
            preparedStatement.setDouble(5, student.getSalary());
            preparedStatement.setInt(6, student.getAddressId());

            preparedStatement.execute();
            
            connection.setAutoCommit(false);

            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}