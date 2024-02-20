package database;

import java.sql.*;
public class DbConnection {
    public static Connection dbConnect()
    {
        try
        {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Project","root","12QWasZX.#");
            System.out.println("connected to database");
        return conn;
        }
        catch(Exception e)
        {
        }
        return null;
    }

}