package controller;

import dal.UserDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;

public class registerController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            if (session.getAttribute("user") != null) {
                response.sendRedirect("infor");
            } else {
                request.getRequestDispatcher("register.jsp").forward(request, response);
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
            String type = request.getParameter("type");
            String email = request.getParameter("email");

            //check text input blank
            if (username.trim().equals("") || password.trim().equals("") || email.trim().equals("")) {
                message = "Please enter all";
            }
            //check mail 
            boolean isEmail = email.matches("^([\\w\\-]+)@([\\w\\-]+)((\\.(\\w){2,3}){1,2})$");
            if (message.equals("") && !isEmail) {
                message = "Email is incorrect format";
            }
            UserDAO userDB = new UserDAO();
            //check user
            User u = userDB.getUser(username);
            //User does not exist and email correct
            if (u == null && message.equals("") && isEmail) {
                User userRegister = new User(username, password, email, Boolean.parseBoolean(type));
                userDB.insertUser(userRegister);
                message = "Sign Up Success";
            } else if (u != null) {
                message = "Username already exists";
            }

            request.setAttribute("message", message);
            request.setAttribute("username", username);
            request.setAttribute("email", email);
            request.setAttribute("type", type);
            request.setAttribute("password", password);

            request.getRequestDispatcher("register.jsp").forward(request, response);
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
