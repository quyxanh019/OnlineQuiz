package controller;

import dal.UserDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;

public class loginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            if (session.getAttribute("user") != null) {
                response.sendRedirect("infor");
            } else {
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String message = "";

            String username = request.getParameter("username");
            String password = request.getParameter("password");
            UserDAO userDB = new UserDAO();
            //check user
            User u = userDB.getUser(username);
            //User does not exist
            if (u != null) {
                //check password
                if (u.getPassword().equals(password)) {
                    HttpSession session = request.getSession();
                    session.setAttribute("user", u);
                    response.sendRedirect("infor");
                    return;
                } else {
                    message = "Password is incorrect";
                }
            } else {
                message = "User account or password is incorrect";
            }
            request.setAttribute("message", message);
            request.setAttribute("username", username);
            request.setAttribute("password", password);

            request.getRequestDispatcher("login.jsp").forward(request, response);
        } catch (Exception e) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
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
