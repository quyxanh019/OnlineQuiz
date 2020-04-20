package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class loginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse resp = (HttpServletResponse) response;
            HttpSession session = req.getSession();
            //Visit the login page if you are not already logged in
            if (session.getAttribute("user") == null) {
                resp.sendRedirect("login");
            } else {
                chain.doFilter(request, response);
            }

        } catch (Exception ex) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

}
