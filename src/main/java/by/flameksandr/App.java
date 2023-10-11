package by.flameksandr;

import java.sql.*;

public class App {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/student?useSSL=false";
        String userName = "root";
        String password = "password";
        String query = "insert into nepal values (107, 'hiroky', 3450990)";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection(url, userName, password);
        Statement st = connection.createStatement();
        int count = st.executeUpdate(query);
        System.out.println(count + " row/s affected");

        st.close();
        connection.close();
    }
}
