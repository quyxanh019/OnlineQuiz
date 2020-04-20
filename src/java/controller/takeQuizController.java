package controller;

import dal.QuestionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Question;

public class takeQuizController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

        } catch (Exception e) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            int quiz = (int) request.getAttribute("quiz");
            QuestionDAO questionDAO = new QuestionDAO();

            ArrayList<Question> listQuiz = questionDAO.getRandomQuestion(quiz);
            HttpSession session = request.getSession();
            session.setAttribute("listQuiz", listQuiz);

            long timePerQuiz = 10;
            long totalTime = listQuiz.size() * timePerQuiz;

            long startTime = 0;
            long endTime = 0;
            Date date = new Date();
            //time start to do quiz
            startTime = date.getTime() / 1000;
            endTime = startTime + totalTime;
            session.setAttribute("endTime", endTime);

            request.setAttribute("totalTime", totalTime);
            request.getRequestDispatcher("takeQuiz.jsp").forward(request, response);

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
