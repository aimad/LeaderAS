/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

/**
 *
 * @author ELKAOUMI
 */
import java.sql.*;

public class DataBaseConnection {

    Connection conn;
    Statement st;
    ResultSet rs;

    public DataBaseConnection() {
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            String url = "jdbc:postgresql://localhost:5432/lds_db";
            conn = DriverManager.getConnection(url, "postgres", "mamana");
            st = conn.createStatement();
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IllegalAccessException ex) {
            System.out.println(ex.getMessage());
        } catch (InstantiationException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public ResultSet getSelection(String sql) {
        try {
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            
        }
        return rs;
    }

    public int getNumberOfRecords(String sql) {
        rs = getSelection(sql);
        int i = 0;
        try {
            while (rs.next()) {
                i++;
            }
        } catch (SQLException ex) {
            
        }
        return i;
    }

    public void execute(String sql) {
        try {
            st.executeUpdate(sql);
//conn.commit();
        } catch (SQLException ex) {
           
        }
    }
    public static void main(String args[])
    {
    DataBaseConnection db=new DataBaseConnection();
    db.execute("INSERT INTO fournisseur VALUES ('1','XX','xx@xx.com','0677889988','0677889988','rue xx ','test test')");
    }
}