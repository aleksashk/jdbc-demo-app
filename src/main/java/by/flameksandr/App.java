package by.flameksandr;

import java.sql.*;

public class App {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/student?useSSL=false";
        String userName = "root";
        String password = "password";
        String query = "select * from nepal";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection(url, userName, password);
        Statement st = connection.createStatement();
        ResultSet resultSet = st.executeQuery(query);
        resultSet.next();

        String name = resultSet.getInt(1) + " : " +
                resultSet.getString(2) + " : " +
                resultSet.getInt(3);
        System.out.println(name);

        st.close();
        connection.close();
    }
}
