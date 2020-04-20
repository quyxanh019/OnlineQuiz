package controller;

import dal.QuestionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.GregorianCalendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Question;

public class makeQuizController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try {

            request.getRequestDispatcher("makeQuiz.jsp").forward(request, response);

        } catch (Exception e) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try {
        String message = "";

        String content = request.getParameter("content");
        String option1 = request.getParameter("opt1");
        String option2 = request.getParameter("opt2");
        String option3 = request.getParameter("opt3");
        String option4 = request.getParameter("opt4");
        String[] answer = request.getParameterValues("answer");

        String strAnswer = "";

        //check answer checked
        String[] checkedAnswer = {"", "", "", ""};
        if (answer != null) {
            for (int i = 0; i < answer.length; i++) {
                strAnswer += answer[i];
                for (int j = 0; j < checkedAnswer.length; j++) {
                    //answer checked, assign checked
                    if (answer[i].equals(j + 1 + "")) {
                        checkedAnswer[j] = "checked";
                    }
                }
            }
        }

        //check content
        if (content.trim().equals("")) {
            message = "Question content cannot be empty";
        } //check option 1
        else if (option1.trim().equals("")) {
            message = "Option 1 cannot be empty";
        } //check option 2
        else if (option2.trim().equals("")) {
            message = "Option 2 cannot be empty";
        } //check option 3
        else if (option3.trim().equals("")) {
            message = "Option 3 cannot be empty";
        } //check option 4
        else if (option4.trim().equals("")) {
            message = "Option 4 cannot be empty";
        } //check no answer
        else if (answer == null) {
            message = "Please select answer(s)";
        } //check all answer
        else if (answer != null && answer.length == 4) {
            message = "Cannot select all answers";
        }
        
      
        boolean isInsert = false;
        //insert if no error
        if (message.equals("")) {
            Question question = new Question(content, option1, option2, option3, option4, strAnswer);
            QuestionDAO questionDB = new QuestionDAO();
            questionDB.insertQuestion(question);
            message = "Question added successfully";
            isInsert = true;
        }

        
        request.setAttribute("isInsert", isInsert);
        request.setAttribute("message", message);
        request.setAttribute("content", content);
        request.setAttribute("opt1", option1);
        request.setAttribute("opt2", option2);
        request.setAttribute("opt3", option3);
        request.setAttribute("opt4", option4);
        request.setAttribute("answer", checkedAnswer);

        request.getRequestDispatcher("makeQuiz.jsp").forward(request, response);

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
