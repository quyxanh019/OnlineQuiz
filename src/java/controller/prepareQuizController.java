package controller;

import dal.QuestionDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class prepareQuizController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            request.getRequestDispatcher("prepareQuiz.jsp").forward(request, response);

        } catch (Exception e) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String message = null;
            String numOfQuiz = request.getParameter("numOfQuiz");
            System.out.println("----------" + numOfQuiz);
            QuestionDAO questionDB = new QuestionDAO();
            int totalQuiz = questionDB.count();
            int quiz = Integer.MAX_VALUE;

            //check empty
            if (numOfQuiz != null) {
                try {
                    quiz = Integer.parseInt(numOfQuiz);
                    //check Large number of questions
                    if (quiz > totalQuiz) {
                        message = "The number of questions cannot be greater than " + totalQuiz;
                    }
                    //check Small number of questions
                    if (quiz < 1 && totalQuiz > 0) {
                        message = "The number of questions cannot be less than 0";
                    }
                } catch (Exception e) {
                    message = "incorrec format";
                }
            }
            else {
                message = "Number of questions cannot be empty";
            }

            request.setAttribute("quiz", quiz);
            request.setAttribute("message", message);
            if (message == null) {
                request.getRequestDispatcher("takeQuiz").forward(request, response);
            }
            else {
                request.getRequestDispatcher("prepareQuiz.jsp").forward(request, response);
            }

        } catch (Exception e) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
