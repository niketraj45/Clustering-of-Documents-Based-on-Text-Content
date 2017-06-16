/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.impl.Constants;
import com.impl.propertyImpl;

public class DBQuery extends DBFormat implements DBConnection {
Connection con = null;
ResultSet rs = null;
Statement st = null;

    public DBQuery() throws SQLException {
        con = getConnection();
        st = con.createStatement();
    }

    @Override
    public Connection getConnection() {
        Connection con = null;
        try {
        	System.out.println(propertyImpl.getproperty(Constants.db_driver));
            Class.forName(propertyImpl.getproperty(Constants.db_driver));
            String db_info = propertyImpl.getproperty(Constants.db_url)+propertyImpl.getproperty(Constants.db_ip)+":"+propertyImpl.getproperty(Constants.db_port)+"/"+propertyImpl.getproperty(Constants.db_name);
            con = DriverManager.getConnection(db_info,propertyImpl.getproperty(Constants.db_username),propertyImpl.getproperty(Constants.db_password));
        } catch (SQLException ex) {
            Logger.getLogger(DBQuery.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    public int DB_INSERT(String[] column_data,String table_name) throws SQLException
    {
        int i = 0;
        String query = INSERT(column_data, table_name);
        System.out.println("q= "+query);
        i = st.executeUpdate(query);
        return i;
    }
    
    public ResultSet DB_SELECT(String[] data,String[] column_name,String table_name,String select_type) throws SQLException
    {
        String query = SELECT(data, column_name, table_name, select_type);
        rs = st.executeQuery(query);
        return rs;
    }
    
    public int DB_UPDATE(String[] data,String[] column_name,String[] condition_data,String[] condition_column,String table_name) throws SQLException
    {
        String query = UPDATE(data, column_name, condition_data, condition_column, table_name);
        int i = st.executeUpdate(query);
        return i;
    }
    
}
