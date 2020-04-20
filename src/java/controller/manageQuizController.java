package controller;

import dal.QuestionDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Question;

public class manageQuizController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            String error = null;
            QuestionDAO questionDB = new QuestionDAO();
            String pageIndex = request.getParameter("index");
            //search page always in page 1
            if (pageIndex == null) {
                pageIndex = "1";
            }
            int index = 1;
            try {
                index = Integer.parseInt(pageIndex);
            } catch (NumberFormatException e) {
                error = "Not found page 111";
            }
            String delete = request.getParameter("delID");
            int pageSize = 3;
            int countQuestionPaging = questionDB.countQuestionPaging(index, pageSize);

            if (delete != null) {
                int questionID = 0;
                try {
                    questionID = Integer.parseInt(delete);
                    boolean flag = questionDB.deleteQuestion(questionID);
                    // no quiz is deleted
                    if (!flag) {
                        error = "Not found question";
                    }
                    else {
                        //return front page if delete last quiz in page
                        if (countQuestionPaging == 1) {
                            index--;
                        }
                        //cout quiz paging againt
                        countQuestionPaging = questionDB.countQuestionPaging(index, pageSize);
                    }

                } catch (NumberFormatException e) {
                    error = "Not found question";
                }

            }

            int totalQuestion = questionDB.count();

            //get total page seach
            int pageCount = (totalQuestion % pageSize == 0) ? totalQuestion / pageSize : totalQuestion / pageSize + 1;

            //get news per page
            ArrayList<Question> listQuestions = questionDB.paging(index, pageSize);

            //check page valid
            if (totalQuestion > 0) {
                if (index > pageCount || (index < 1)) {
                    error = "Not found page";
                }
            }

            //send data to jsp
            request.setAttribute("countQuestionPaging", countQuestionPaging);
            request.setAttribute("listQuestions", listQuestions);
            request.setAttribute("index", index);
            request.setAttribute("pageCount", pageCount);
            request.setAttribute("error", error);

            request.getRequestDispatcher("manageQuiz.jsp").forward(request, response);

        } catch (Exception e) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

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
