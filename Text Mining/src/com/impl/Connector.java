package com.impl;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.database.DBQuery;


public class Connector extends DBQuery{
   HttpServletRequest request = null;
   HttpServletResponse response = null;
   RequestDispatcher rd = null;
   GenericServlet generic = null;
   HttpSession session = null;
   String redirect_page="";

    public Connector(HttpServletRequest req,HttpServletResponse resp,GenericServlet gen) throws SQLException {
        this.request = req;
        this.response = resp;
        this.generic = gen;
        this.session = req.getSession();
    }
   
    
    public void register(String fname,String lname,String email,String phone,String pass) throws SQLException, ServletException, IOException
    {
        String[] arr = {fname,lname,email,phone,pass,"false"};
        String tbl1 = "register";
        
        String[] arr1 = {email,pass,"inactive","user"};
        String tb2 = "login";
        
        String redirect_page = generic.getServletConfig().getInitParameter("index");
        int i = DB_INSERT(arr, tbl1);
        int j = DB_INSERT(arr1, tb2);
        
        if(i!=0 && j!=0)
        {
        	session.setAttribute("msg", "Sucessfully Registered!!!");
            rd = request.getRequestDispatcher(redirect_page);
            rd.forward(request, response);
        }
    }
   
    public void login(String id,String pass) throws SQLException, ServletException, IOException
    {
        String[] data = {id,pass};
        String[] column_name = {"email","password"};
        String tb1 = "login";
        String con_type = "with condition";
        
        ResultSet rs = DB_SELECT(data, column_name, tb1, con_type);
        if(rs.next())
        {
            String type = rs.getString("utype");
            String Name= null;
            System.out.println("utype= "+type);
                if(type.equalsIgnoreCase("admin"))
                {
                    redirect_page = generic.getServletConfig().getInitParameter("admin_home");
                    session.setAttribute("type", type);
                    rd = request.getRequestDispatcher(redirect_page);
                    rd.forward(request, response);
                }
                else if(type.equalsIgnoreCase("user"))
                {
                    String sta = rs.getString("status");
                    if(sta.equalsIgnoreCase("active"))
                    {
                    	String[] D = {id};
                    	String[] cond = {"email"};
                    	String tb2 = "";
                    	
                    	Name = rs.getString("");
                        redirect_page = generic.getServletConfig().getInitParameter("user_home");
                        session.setAttribute("type", id);
                        rd = request.getRequestDispatcher(redirect_page);
                        rd.forward(request, response);
                    }
                    else if(sta.equalsIgnoreCase("inactive"))
                    {
                        session.setAttribute("msg", "Account not yet activated!!!");
                        redirect_page = generic.getServletConfig().getInitParameter("index");
                        rd = request.getRequestDispatcher(redirect_page);
                        rd.forward(request, response);
                    }
                }
        }
        else
                {
                    session.setAttribute("msg", "Invalid username or password");
                    redirect_page = generic.getServletConfig().getInitParameter("index");
                    rd = request.getRequestDispatcher(redirect_page);
                    rd.forward(request, response);
                }
    }
    
    public void view_user() throws SQLException, ServletException, IOException
    {
        ArrayList<String[]> arr = new ArrayList<String[]>();
        ResultSet rs = DB_SELECT(new String[]{"user"}, new String[]{"utype"}, "login", "with condition");
        while(rs.next())
        {
            arr.add(new String[]{rs.getString("email"),rs.getString("status")});
        }
        
        session.setAttribute("arr", arr);
        redirect_page = generic.getServletConfig().getInitParameter("admin_view_user");
        rd = request.getRequestDispatcher(redirect_page);
        rd.forward(request, response);
    }
    
    public void update_status(String id, String type) throws SQLException, IOException
    {
        int val = 0;
        val = DB_UPDATE(new String[]{type}, new String[]{"status"}, new String[]{id}, new String[]{"email"}, "login");
       if(val !=0)
       {
         response.getWriter().write("done");
       }
    }
    
    public void search(String type) throws SQLException, IOException, ServletException
    {
    	System.out.println("search......");
        String get_data = "";
        ArrayList<String> data = new ArrayList<>();
        if(type.equalsIgnoreCase("Data Mining")){
     	   get_data = "Data Mining";
        }
        else if(type.equalsIgnoreCase("Networking")){
     	   get_data = "Networking";
        }
        else if(type.equalsIgnoreCase("Mobile Computing")){
     	   get_data = "Mobile Computing";
        }
        else if(type.equalsIgnoreCase("Cloud Computing")){
     	   get_data = "Cloud Computing";
        }
        else if(type.equalsIgnoreCase("Internet Of Things")){
     	   get_data = "Internet Of Things";
 }
        ResultSet rs = DB_SELECT(null, null, "corpus", "without condition");
        while(rs.next()){
     	   data.add(rs.getString(get_data)+"@"+rs.getString("documentName"));
        }
        session.setAttribute("data", data);
       redirect_page = generic.getServletConfig().getInitParameter("result");
       System.out.println(redirect_page);
       rd = request.getRequestDispatcher(redirect_page);
       rd.forward(request, response);
    }
    
    public void add_data(String inc_id,String c_loc,String c_place,String c_type) throws SQLException, SQLException, ServletException, IOException
    {
        String[] arr = {inc_id,c_loc,c_place,c_type};
        String tbl = "dataset";
        int i = DB_INSERT(arr, tbl);
        if(i!=0)
        {
            session.setAttribute("msg", "Sucessfully Inserted");
           redirect_page = generic.getServletConfig().getInitParameter("admin_home");
        rd = request.getRequestDispatcher(redirect_page);
        rd.forward(request, response);
        }
    }
    public void get_cluster_name() throws ServletException, IOException{
    	String clusterNames = propertyImpl.getproperty(Constants.cluster_names);
    	String[] C = clusterNames.split(",");
    	session.setAttribute("Clusters", C);
    	redirect_page = generic.getServletConfig().getInitParameter("search");
    	rd = request.getRequestDispatcher(redirect_page);
        rd.forward(request, response);
    }
    
}
