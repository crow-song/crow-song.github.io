package jdbc;
import java.sql.*;
public class jdbcConn {
    public static Connection getConnection(){
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "dfwhj43815";
        Connection conn = null;
        try {
            //加载驱动程序
            Class.forName(driverClassName);
            //获得数据库连接
            conn = DriverManager.getConnection(url,username,password);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;

    }
}
