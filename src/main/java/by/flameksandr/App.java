package by.flameksandr;

import java.sql.*;

public class App {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/student?useSSL=false";
        String userName = "root";
        String password = "password";
        String query = "select name from nepal where id=101";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection(url, userName, password);
        Statement st = connection.createStatement();
        ResultSet resultSet = st.executeQuery(query);
        resultSet.next();
        String name = resultSet.getString("name");
        System.out.println(name);

        st.close();
        connection.close();
    }
}
