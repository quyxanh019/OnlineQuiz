package controller;

import dal.QuestionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Question;
import model.User;

public class resultQuizController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();

            ArrayList<Question> listQuiz = (ArrayList<Question>) session.getAttribute("listQuiz");
            session.removeAttribute("listQuiz");

            int countTrue = 0;
            String message = null;
            String status = "reject";
            String strScore = "";

            Date date = new Date();
            //time submit
            long end = date.getTime() / 1000;
            long endTime = (long) session.getAttribute("endTime");

            //delete session
            session.removeAttribute("endTime");

            //reject
            if (end > endTime) {
                message = "reject";
            }
            else {
                //check correct answers
                for (int i = 0; i < listQuiz.size(); i++) {
                    //get array answers 
                    String[] ans = request.getParameterValues("ans" + i);
                    String strAns = "";
                    if (ans != null) {
                        //convert array answer to string answer
                        for (int j = 0; j < ans.length; j++) {
                            strAns += ans[j];
                        }
                    }

                    //compare result
                    if (strAns.equals(listQuiz.get(i).getAnswer())) {
                        countTrue++;
                    }
                }

                //Process score to display
                int rawScore = (countTrue * 100 / listQuiz.size());
                float score = (float) rawScore / 10;
                strScore = score + "";
                if (strScore.endsWith(".0")) {
                    strScore = strScore.substring(0, strScore.length() - 2);
                }

                //Process percent to display
                float percent = (float) rawScore;
                String strPercent = percent + "";
                if (strPercent.endsWith(".0")) {
                    strPercent = strPercent.substring(0, strPercent.length() - 2);
                }

                status = (score < 5) ? "Fail" : "Pass";

                request.setAttribute("status", status);
                request.setAttribute("strScore", strScore);
                request.setAttribute("strPercent", strPercent);
            }

            //insert history
            User u = (User) session.getAttribute("user");
            QuestionDAO quizDB = new QuestionDAO();
            quizDB.insertHistory(u.getId(), strScore, status);

            request.setAttribute("message", message);
            request.getRequestDispatcher("resultQuiz.jsp").forward(request, response);
        } catch (Exception ex) {
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
