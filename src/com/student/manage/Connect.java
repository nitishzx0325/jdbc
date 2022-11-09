package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
    static Connection con;
    public static Connection craeteconnection(){
        try {
//            load the driver
            Class.forName("com.mysql.jdbc.Driver");

//          create the connection
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");


        }
        catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
