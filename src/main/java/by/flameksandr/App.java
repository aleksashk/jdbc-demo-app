package by.flameksandr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/student?useSSL=false";
        String userName = "root";
        String password = "password";
        String query = "insert into nepal values (?, ?, ?)";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Employee id: ");
        int uid = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the employee_name: ");
        String uname = scanner.nextLine();
        System.out.println("Enter the salary: ");

        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid number for salary.");
            scanner.next();
        }

        double usalary = scanner.nextDouble();

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection(url, userName, password);
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, uid);
        preparedStatement.setString(2, uname);
        preparedStatement.setDouble(3, usalary);

        int k = preparedStatement.executeUpdate();
        if (k != 0) {
            System.out.println("Data is added successfully");
        } else {
            System.out.println("Something is wrong");
        }
        connection.setAutoCommit(true);
        preparedStatement.close();
        connection.close();
    }
}
