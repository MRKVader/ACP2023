package week6.sql;

import java.sql.*;

public class Intro_JDBC {

    public static final String URL = "jdbc:mysql://localhost:3306/acp12";
    public static final String USER = "admin";
    public static final String PASS = "!Made1989";
    public static final String ALL_QUERY = "SELECT id, full_name, age, birth_date,  salary, address_id FROM students";

    public static void main(String[] args) throws ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = null;
        Statement statement = null;
        ResultSet result = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            statement = connection.createStatement();
            result = statement.executeQuery(ALL_QUERY);
            while (result.next()) {
                int id = result.getInt("id");
                String fullName = result.getString("full_name");
                int age = result.getInt("age");
                Date birthDate = result.getDate("birth_date");
                double salary = result.getDouble("salary");
                int addressId = result.getInt("address_id");

                System.out.println(new StudentSQL(id, fullName, age, birthDate, salary, addressId));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(result != null){
                try {
                    result.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } if (statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
