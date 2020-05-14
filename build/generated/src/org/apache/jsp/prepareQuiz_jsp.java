package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.User;

public final class prepareQuiz_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"css/prepareQuiz.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("\n");
      out.write("        ");

            String message = (String) request.getAttribute("message");
            int quiz = 0;
            if (message != null) {
                quiz = (int) request.getAttribute("quiz");
            }
        
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"header\">\n");
      out.write("                ");
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
      out.write("        </div>\n");
      out.write("        <div class=\"menu_bg\">\n");
      out.write("            <div class=\"menu\">\n");
      out.write("                <table border=\"0\">\n");
      out.write("                    <tr>\n");
      out.write("                        <th><a href=\"infor\">Home</a></th>\n");
      out.write("                        <th><a href=\"prepareQuiz\">Take Quiz</a></th>\n");
      out.write("                        <th><a href=\"makeQuiz\">Make Quiz</a></th>\n");
      out.write("                        <th><a href=\"manageQuiz\">Manage Quiz</a></th>\n");
      out.write("                        <th>\n");
      out.write("                            ");
if (u != null) {
      out.write("\n");
      out.write("                            <a href=\"logout\">Logout</a>\n");
      out.write("                            ");
}
      out.write("\n");
      out.write("                        </th>\n");
      out.write("                    </tr>\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <div class=\"main\">\n");
      out.write("                <div class=\"wellcome\">Welcome <span class=\"username\">");
      out.print(u.getUsername());
      out.write("</span></div>\n");
      out.write("                    ");
 if (message != null) {
      out.write("\n");
      out.write("                <div>");
      out.print(message);
      out.write("</div>\n");
      out.write("                ");
 }
      out.write("\n");
      out.write("                <form action=\"prepareQuiz\" method=\"post\">\n");
      out.write("\n");
      out.write("                    <div>Enter number of question: </div>\n");
      out.write("                    <input class=\"input\" type=\"text\" value=\"\" name=\"numOfQuiz\" required=\"\">\n");
      out.write("                    <br>\n");
      out.write("                    <br>\n");
      out.write("                    <input type=\"submit\" value=\"Start\">\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
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
