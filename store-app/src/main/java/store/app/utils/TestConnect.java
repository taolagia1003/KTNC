/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.app.utils;
import java.sql.*;

/**
 *
 * @author asus
 */
public class TestConnect {

    /**
     * @param args the command line arguments
     */
     public static void main(String []agrs){
    Connection conn;
    String url;
    try{
        url= "jdbc:sqlserver://localhost:1433;databaseName=QuanLyBanHang;user=sa;password=123";
        //url= "jdbc:mysql://localhost:3306/edusys";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //Class.forName("com.mysql.jdbc.Driver");//my sql
        conn= DriverManager.getConnection(url);
        System.out.println("ok");
    }catch(Exception ex){
            ex.printStackTrace();
    }
  }  
}
