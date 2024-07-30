package employee.management.sys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class connection {

    Connection c;
    Statement s;

    public connection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagementsystem", "root", "pbian12345");
            s = c.createStatement();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
