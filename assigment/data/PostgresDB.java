package com.assigment.data;

import com.assigment.data.interfaces.IDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
public class PostgresDB implements IDB {
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
       /// String connectionUrl = ; did not liked it so put directly in connection
        String connectionUrl = "jdbc://mysql://phpmyadmin:3306/db?";
        try {
            // Here we load the driver’s class file into memory at the runtime
            // did not understood well, but it is library with which we connect to our db
            Class.forName("com.mysql.jdbc.Driver");
            /// I use my sql so changed connection to it(was postgres?)
              // Establish the connection
            //Enter url, user and password, but it is different for sql, so i lost and can not find way to connect to by db
            // it is main problem in all by project
             Connection con =DriverManager.getConnection(connectionUrl ,"root", "");
            return con;
        } catch (Exception e) { // exceptions in connection
            System.out.println(e);
            throw e;
        }

    }
}
