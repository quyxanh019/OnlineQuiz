package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.User;

public final class makeQuiz_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link href=\"css/makeQuiz.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        ");

            boolean isInsert = false;
            String message = (String) request.getAttribute("message");
            String content = "";
            String option1 = "";
            String option2 = "";
            String option3 = "";
            String option4 = "";
            String[] answer = {"", "", "", ""};

            if (message != null) {
                content = (String) request.getAttribute("content");
                option1 = (String) request.getAttribute("opt1");
                option2 = (String) request.getAttribute("opt2");
                option3 = (String) request.getAttribute("opt3");
                option4 = (String) request.getAttribute("opt4");
                answer = (String[]) request.getAttribute("answer");
                isInsert = (boolean) request.getAttribute("isInsert");
            }
        
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
      out.write("                <a href=\"#\">Manage Quiz</a>\n");
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
if (isInsert) {
      out.write("\n");
      out.write("                <h2>Question added successfully</h2>\n");
      out.write("                <a href=\"makeQuiz\">Add another question</a>\n");
      out.write("                ");
}
                else {
      out.write("\n");
      out.write("                <form action=\"makeQuiz\" method=\"post\">\n");
      out.write("                    <table>\n");
      out.write("                        <tbody>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Question: </td>\n");
      out.write("                                <td><textarea name=\"content\">");
      out.print(content);
      out.write("</textarea></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Option 1</td>\n");
      out.write("                                <td><textarea name=\"opt1\">");
      out.print(option1);
      out.write("</textarea></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Option 2</td>\n");
      out.write("                                <td><textarea name=\"opt2\" >");
      out.print(option2);
      out.write("</textarea></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Option 3</td>\n");
      out.write("                                <td><textarea name=\"opt3\" >");
      out.print(option3);
      out.write("</textarea></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Option 4</td>\n");
      out.write("                                <td><textarea name=\"opt4\">");
      out.print(option4);
      out.write("</textarea></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Answer(s)</td>\n");
      out.write("                                <td>\n");
      out.write("                                    <input type=\"checkbox\" name=\"answer\" value=\"1\" ");
      out.print(answer[0]);
      out.write("> Option 1\n");
      out.write("                                    <input type=\"checkbox\" name=\"answer\" value=\"2\" ");
      out.print(answer[1]);
      out.write("> Option 2\n");
      out.write("                                    <input type=\"checkbox\" name=\"answer\" value=\"3\" ");
      out.print(answer[2]);
      out.write("> Option 3\n");
      out.write("                                    <input type=\"checkbox\" name=\"answer\" value=\"4\" ");
      out.print(answer[3]);
      out.write("> Option 4\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td></td>\n");
      out.write("                                <td><input type=\"submit\" value=\"Save\"></td>\n");
      out.write("                            </tr>\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("                </form>\n");
      out.write("                ");
 if (message != null) {
      out.write("\n");
      out.write("                <span class=\"failed\">");
      out.print(message);
      out.write("</span>\n");
      out.write("                ");
 }
      out.write("\n");
      out.write("                ");
}
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
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
