package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.User;

public final class quizPage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"css/takeQuiz.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <script src=\"javascript/js.js\" type=\"text/javascript\"></script>\n");
      out.write("        <title>JSP Page</title>\n");
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
      out.write("                <h3>Welcome <span class=\"userName\">quyxanh019</span></h3>\n");
      out.write("                <h4 id=\"TimeSpan\">Time remaining: <span id=\"timeDisplay\">00:00</span></h4>\n");
      out.write("                <h5 id=\"qustionPos\">Question: 0/0</h5>\n");
      out.write("                <form id=\"quizForm\" action=\"TakeQuiz\" method=\"post\">\n");
      out.write("                    <input type=\"hidden\" name=\"req\" value=\"quizResult\">\n");
      out.write("                    <input type=\"hidden\" name=\"numOfQuiz\" value=\"4\">\n");
      out.write("\n");
      out.write("                    <div id=\"q2\" class=\"hidden\">\n");
      out.write("                        <input type=\"hidden\" name=\"q1\" value=\"1\"\n");
      out.write("                               <p>hom nay la thu may</p>\n");
      out.write("                        <ul>\n");
      out.write("\n");
      out.write("                            <input type=\"checkbox\" name=\"ans1-2\">\n");
      out.write("                            <li>chac chan la thu 2</li><br>\n");
      out.write("                            <input type=\"checkbox\" name=\"ans1-2\">\n");
      out.write("                            <li>chac chan la thu 2</li><br>\n");
      out.write("                            <input type=\"checkbox\" name=\"ans1-2\">\n");
      out.write("                            <li>chac chan la thu 2</li><br>\n");
      out.write("                            <input type=\"checkbox\" name=\"ans1-2\">\n");
      out.write("                            <li>chac chan la thu 2</li><br>\n");
      out.write("\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <input type=\"submit\" value=\"Finish\">    \n");
      out.write("                    <button id=\"next\" type=\"button\" onclick=\"nextQuestion()\">Next</button>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("            <script>\n");
      out.write("            countDown();\n");
      out.write("        </script>\n");
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
