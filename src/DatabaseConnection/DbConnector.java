package DatabaseConnection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public abstract class DbConnector {

    private Connection connection;


    protected DbConnector() {
        String url = "jdbc:mysql://localhost:3306/foodiestore?useTimezone=true&serverTimezone=UTC";
        String user = "root";
        String password = "root";


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            System.out.println("Working perfectly!");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public Connection getConnection() {
        return connection;
    }
}
