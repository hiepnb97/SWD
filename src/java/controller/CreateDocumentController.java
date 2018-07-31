/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.AuthorDocumentDAO;
import db.CoauthorDocumentDAO;
import db.DocumentDAO;
import db.UserDAO;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import models.AuthorDocument;
import models.CoauthorDocument;
import models.Document;
import models.User;
import org.bson.types.ObjectId;

/**
 *
 * @author Hoang Hiep
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, // 10 MB 
        maxFileSize = 1024 * 1024 * 50, // 50 MB
        maxRequestSize = 1024 * 1024 * 100)
public class CreateDocumentController extends HttpServlet {

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

        HttpSession session = request.getSession();
        ObjectId userID = (ObjectId) (session.getAttribute("sessionmemberid"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String coauthor = request.getParameter("coauthor");

        //upload
        String applicationPath = request.getServletContext().getRealPath("");
        // constructs path of the directory to save uploaded file
        String uploadFilePath = applicationPath + File.separator + "doc" + File.separator + session.getAttribute("sessionmemberid");

        // creates the save directory if it does not exists
        File fileSaveDir = new File(uploadFilePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }
        System.out.println("Upload File Directory=" + fileSaveDir.getAbsolutePath());

        String fileName = "";
        //Get all the parts from request and write it to the file on server

        List<Part> fileParts = request.getParts().stream().filter(part -> "file".equals(part.getName())).collect(Collectors.toList()); // Retrieves <input type="file" name="file" multiple="true">

        for (Part filePart : fileParts) {
            fileName = getFileName(filePart);
            if (!fileName.equals("")) {
                filePart.write(uploadFilePath + File.separator + fileName);
            }
        }

        // save to mongodb
        DocumentDAO documentDAO = new DocumentDAO();
        ObjectId documentID = documentDAO.createDocument(new Document(title, content, fileName));
        // author
        AuthorDocumentDAO authorDocumentDAO = new AuthorDocumentDAO();
        authorDocumentDAO.createAuthorDocument(new AuthorDocument(userID, documentID));
        UserDAO userDAO = new UserDAO();
        CoauthorDocumentDAO coauthorDocumentDAO = new CoauthorDocumentDAO();
        // coauthor
        String[] coauthorsUsername = coauthor.split(",");
        for (String coauthorUsername : coauthorsUsername) {
            try {
                String coauthorId = userDAO.getUserId(coauthorUsername);
                CoauthorDocument cD = new CoauthorDocument(new ObjectId(coauthorId), documentID);
                coauthorDocumentDAO.createCoauthorDocument(cD);
            }catch (Exception e){
                
            }
        }
        /*
        request.getRequestDispatcher("UserInfo?userid=" + userID).forward(
                request, response);*/
        response.sendRedirect("home.jsp");
    }

    private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        System.out.println("content-disposition header= " + contentDisp);
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=") + 2, token.length() - 1);
            }
        }
        return "";
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
