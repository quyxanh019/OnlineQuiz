package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import model.Question;
import model.User;

public final class manageQuiz_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/header.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"css/manageQuiz.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <script src=\"javascript/js.js\" type=\"text/javascript\"></script>\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("\n");
      out.write("        ");

            int totalQuestion = (int) request.getAttribute("totalQuestion");
            int pageCount = (int) request.getAttribute("pageCount");
            ArrayList<Question> listQuestions = (ArrayList<Question>) request.getAttribute("listQuestions");
            String text = (String) request.getAttribute("text");
            int index = (int) request.getAttribute("index");
            String error = (String) request.getAttribute("error");
        
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"header\">\n");
      out.write("                ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"css/header.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <title>header</title>\n");
      out.write("        ");

            User u = (User) session.getAttribute("user");
        
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"top_box\">\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <div class=\"menu_bg\">\n");
      out.write("            <div class=\"menu\">\n");
      out.write("                <a href=\"infor\">Home</a>\n");
      out.write("                <a href=\"#\">Take Quiz</a>\n");
      out.write("                <a href=\"makeQuiz\">Make Quiz</a>\n");
      out.write("                <a href=\"manageQuiz\">Manage Quiz</a>\n");
      out.write("                ");
if (u != null) {
      out.write("\n");
      out.write("                <a href=\"logout\">Logout</a>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <div class=\"main\">\n");
      out.write("                ");
if (error != null) {
      out.write("\n");
      out.write("                <h3>Number of question: <span class=\"blue\">");
      out.print(totalQuestion);
      out.write("</span></h3>\n");
      out.write("                <table>\n");
      out.write("                    <colgroup>\n");
      out.write("                        <col class=\"labelCol\">\n");
      out.write("                        <col class=\"fieldCol\">\n");
      out.write("                        <col class=\"fieldAction\">\n");
      out.write("                    </colgroup>\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            <th>Question</th>\n");
      out.write("                            <th>Date Created</th>\n");
      out.write("                            <th>Action</th>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody>\n");
      out.write("                        ");
for (Question elem : listQuestions) {
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td>");
      out.print(elem.getContent());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(elem.getDateFormat());
      out.write("</td>\n");
      out.write("                            <td><a onclick=\"delQuestion('");
      out.print(index);
      out.write("', '");
      out.print(elem.getId());
      out.write("')\">Delete</a></td>\n");
      out.write("                        </tr>\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    </tbody>\n");
      out.write("                </table>\n");
      out.write("                <div class=\"paging\">\n");
      out.write("                    ");
for (int i = 1; i <= pageCount; i++) {
      out.write("\n");
      out.write("                    ");
if (i == index) {
      out.write("\n");
      out.write("                    <a class=\"here\">");
      out.print(i);
      out.write("</a>\n");
      out.write("                    ");
}
                    else {
      out.write("\n");
      out.write("                    <a href=\"manageQuiz?index=");
      out.print(i);
      out.write('"');
      out.write('>');
      out.print(i);
      out.write("</a>\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                </div>\n");
      out.write("                ");
}
                else {
      out.write("\n");
      out.write("                ");
      out.print(error);
      out.write("\n");
      out.write("                ");
}
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
