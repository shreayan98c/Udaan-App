/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.srm.udaanapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author shrea
 */
public class CRUDFunctions {
    
    public void display() {
        Connection con = null;
        Statement statement1 = null;
        ResultSet result = null;
        try {
            //step 1 - connect to driver(load driver)
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String user = "root"; //root@localhost
            String pass = "mysql";

            //step 2- form a connection
            con = DriverManager.getConnection("jdbc:mysql://localhost/udaan", user, pass);
            System.out.println("Successfullly connected to db!");

            String sql1 = "select * from udaan.asset;";

            statement1 = con.createStatement();
            result = statement1.executeQuery(sql1);

            int count = 0;

            while (result.next()) {
                int assetid = result.getInt(1);
                String assetname = result.getString(2);
                int assetcount = result.getInt(3);

                String output = "Employee #%d: %s - %d";
                System.out.println(String.format(output, assetid, assetname, assetcount));
            }
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
//        finally {
//            try {
//                result.close();
//            } catch (SQLException err) {
//                err.getMessage();
//            }
//            try {
//                statement1.close();
//            } catch (SQLException err) {
//                err.getMessage();
//            }
//            try {
//                con.close();
//            } catch (SQLException err) {
//                err.getMessage();
//            }
//        }
    }
    
    
    public int insert(String assetname, int assetcount) {
        Connection con = null;
        PreparedStatement statement = null;
        try {
            //step 1 - connect to driver(load driver)
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String user = "root"; //root@localhost
            String pass = "mysql";

            //step 2- form a connection
            con = DriverManager.getConnection("jdbc:mysql://localhost/udaan", user, pass);
            System.out.println("Successfullly connected to db!");

            //step 3 - inserting to table
            String sql = "INSERT INTO udaan.asset(assetname,assetcount) VALUES(?,?); ";
            statement = con.prepareStatement(sql);
            statement.setString(1, assetname);
            statement.setInt(2, assetcount);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
                return 1;
            }

        } catch (SQLException err) {
            System.out.println(err.getMessage());
            err.printStackTrace();
            return 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return 0;
        }// finally {
        /* try {
                
                statement.close();
            } catch (SQLException err) {
                err.getMessage();
            }
            try {
                con.close();
            } catch (SQLException err) {
                err.getMessage();
            }
        }*/ return 0;
    }
    
    public int insert_task(String taskname, String taskcreate, int taskfreq, String taskdeadline, int taskworkerid) {
        Connection con = null;
        PreparedStatement statement = null;
        try {
            //step 1 - connect to driver(load driver)
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String user = "root"; //root@localhost
            String pass = "mysql";

            //step 2- form a connection
            con = DriverManager.getConnection("jdbc:mysql://localhost/udaan", user, pass);
            System.out.println("Successfullly connected to db!");

            //step 3 - inserting to table
            String sql = "INSERT INTO udaan.task(taskname,taskcreatedat,taskfreq,taskdeadline,taskworkerid) VALUES(?,?,?,?,?); ";
            statement = con.prepareStatement(sql);
            statement.setString(1, taskname);
            statement.setString(2, taskcreate);
            statement.setInt(3, taskfreq);
            statement.setString(4, taskdeadline);
            statement.setInt(5, taskworkerid);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
                return 1;
            }

        } catch (SQLException err) {
            System.out.println(err.getMessage());
            err.printStackTrace();
            return 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return 0;
        }// finally {
        /* try {
                
                statement.close();
            } catch (SQLException err) {
                err.getMessage();
            }
            try {
                con.close();
            } catch (SQLException err) {
                err.getMessage();
            }
        }*/ return 0;
    }
    
    
    public int insert_worker(String workername, String workercreate, String workeremail, String workerphone, String workergender) {
        Connection con = null;
        PreparedStatement statement = null;
        try {
            //step 1 - connect to driver(load driver)
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String user = "root"; //root@localhost
            String pass = "mysql";

            //step 2- form a connection
            con = DriverManager.getConnection("jdbc:mysql://localhost/udaan", user, pass);
            System.out.println("Successfullly connected to db!");

            //step 3 - inserting to table
            String sql = "INSERT INTO udaan.worker(workername,workercreatedat,workeremail,workerphone,workergender) VALUES(?,?,?,?,?); ";
            statement = con.prepareStatement(sql);
            statement.setString(1, workername);
            statement.setString(2, workercreate);
            statement.setString(3, workeremail);
            statement.setString(4, workerphone);
            statement.setString(5, workergender);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
                return 1;
            }

        } catch (SQLException err) {
            System.out.println(err.getMessage());
            err.printStackTrace();
            return 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return 0;
        }// finally {
        /* try {
                
                statement.close();
            } catch (SQLException err) {
                err.getMessage();
            }
            try {
                con.close();
            } catch (SQLException err) {
                err.getMessage();
            }
        }*/ return 0;
    }
    
}
