/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.RequestFriendDAO;
import db.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import org.bson.types.ObjectId;

/**
 *
 * @author Hoang Hiep
 */
public class ListRequestFriendController extends HttpServlet {

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
            HttpSession session = request.getSession();
            out.print("<h3>All Request Received:</h3>");
            UserDAO userDAO = new UserDAO();
            RequestFriendDAO requestFriendDAO = new RequestFriendDAO();
            ArrayList<User> users = userDAO.showAllUser();
            int count = 0;
            for (User user : users) {
                ObjectId fromUserID = (ObjectId) (session.getAttribute("sessionmemberid"));
                ObjectId toUserID = user.getId();
                if (requestFriendDAO.checkRequestSent(toUserID, fromUserID)) {
                    count++;
                    out.print("<p><a href='UserInfo?userid=" + user.getId() + "'>" + user.getUserName() + "</a> &emsp; <a href='AcceptFriendController?toUserID=" + user.getId() + "'>Accept</a> / <a href='DontAcceptRequestFriend?toUserID=" + user.getId() + "'>Remove</a>");
                }
            }
            out.print("<p>Total: " + count + " result.</p>");
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
