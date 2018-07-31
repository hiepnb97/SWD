/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.ColleagueDAO;
import db.FriendDAO;
import db.RequestFriendDAO;
import db.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
public class SuggestFriendController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            HttpSession session = request.getSession();
            UserDAO userDAO = new UserDAO();
            RequestFriendDAO requestFriendDAO = new RequestFriendDAO();
            FriendDAO friendDAO = new FriendDAO();
            ColleagueDAO colleagueDAO = new ColleagueDAO();

            ArrayList<User> users = userDAO.showAllUser();
            /* TODO output your page here. You may use following sample code. */
 /*
            out.print("<p>Request sent:</p>");
            
            for (User user : users) {

                ObjectId fromUserID = (ObjectId) (session.getAttribute("sessionmemberid"));
                ObjectId toUserID = user.getId();
                if (RequestFriendDAO.checkRequestSent(fromUserID, toUserID)) {
                    out.print("<p>" + user.getUserName() + " &emsp; <a href='CancelRequestFriendController?toUserID=" + user.getId() + "'>Cancel Request</a>");
                }
            }
             */
            // Suggest Friend
            for (User user : users) {
                ObjectId fromUserID = (ObjectId) (session.getAttribute("sessionmemberid"));
                ObjectId toUserID = user.getId();
                if (requestFriendDAO.checkRequestSent(fromUserID, toUserID) == false && requestFriendDAO.checkRequestSent(toUserID, fromUserID) == false && !fromUserID.equals(toUserID) && friendDAO.checkIsFriend(fromUserID, toUserID) == false && friendDAO.checkIsFriend(toUserID, fromUserID) == false) {
                    // hien thi loi moi ket ban
                    out.print("<p><a href='UserInfo?userid=" + user.getId() + "'>" + user.getUserName() + "</a> - <a href='AddFriendController?toUserID=" + user.getId() + "'>Add Friend</a></p>");

                }
            }
            // suggest colleague
            out.print("<hr>Colleague you may know:<br><br>");
            for (User user : users) {
                ObjectId fromUserID = (ObjectId) (session.getAttribute("sessionmemberid"));
                ObjectId toUserID = user.getId();

                // hien thi xem neu chua phai dong nghiep
                if (!colleagueDAO.checkColleague(fromUserID, toUserID) && !fromUserID.equals(toUserID)) {
                    out.print("<p><a href='UserInfo?userid=" + user.getId() + "'>" + user.getUserName() + "</a> " + "- <a href='AddColleagueController?toUserID=" + user.getId() + "'>Add Colleague</a></p>");
                }

            }
            /*
            out.print("<p>Friend: </p>");
            for (User user : users) {
                ObjectId fromUserID = (ObjectId) (session.getAttribute("sessionmemberid"));
                ObjectId toUserID = user.getId();
                if (FriendDAO.checkIsFriend(fromUserID, toUserID) || FriendDAO.checkIsFriend(toUserID, fromUserID)) {
                    out.print("<p>" + user.getUserName() + " &emsp; <a href='RemoveFriendController?toUserID=" + user.getId() + "'>Remove Friend</a> </p>");
                }
            }

            out.print("<p>List Request: </p>");
            for (User user : users) {
                ObjectId fromUserID = (ObjectId) (session.getAttribute("sessionmemberid"));
                ObjectId toUserID = user.getId();
                if (RequestFriendDAO.checkRequestSent(toUserID, fromUserID)) {
                    out.print("<p>" + user.getUserName() + " &emsp; <a href='AcceptFriendController?toUserID=" + user.getId() + "'>Accept</a>");
                }
            }

            out.print("<p>Colleague: </p>");
            for (User user : users) {
                ObjectId fromUserID = (ObjectId) (session.getAttribute("sessionmemberid"));
                ObjectId toUserID = user.getId();
                if (ColleagueDAO.checkColleague(fromUserID, toUserID)) {
                    out.print("<p>" + user.getUserName() + " &emsp; <a href='CancelColeagueController?toUserID=" + user.getId() + "'>Cancel Colleague</a>");
                }
            }
             */
        }
    }
}
