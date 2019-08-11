/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.srm.udaanapp;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.*;
import java.sql.*;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author shrea
 */
@WebServlet(name = "Display", urlPatterns = {"/Display"})
public class Display extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Display</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Display at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String user = "root@localhost"; //root@localhost
                String pass = "mysql";
                
                Statement statement1 = null;
                ResultSet result = null;
                
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost;databaseName=udaan", user, pass);
                
                String sql1 = "select * from udaan.asset;";

                statement1 = con.createStatement();
                result = statement1.executeQuery(sql1);

                
                JSONArray jarr = new JSONArray();

                while (result.next()) {
                    int assetid = result.getInt("assetid");
                    String assetname = result.getString("assetname");
                    int assetcount = result.getInt("assetcount");
                    

                    JSONObject obj = new JSONObject();
                    obj.put("Asset Name", assetname);
                    obj.put("Asset Count", assetcount);
                    obj.put("Asset ID", assetid);
                    
                    jarr.put(obj);
                }

                JSONObject returnObj = new JSONObject();
                returnObj.put("sEcho", (request.getParameter("sEcho")));
                returnObj.put("iTotalRecords", jarr.length());
                returnObj.put("iTotalDisplayRecords", jarr.length());
                returnObj.put("aaData", jarr);
                out.println(returnObj);
                //response.sendRedirect("display.html");
            } catch (SQLException err) {
                err.printStackTrace();
            } catch (ClassNotFoundException err) {
                err.printStackTrace();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}