package az.et.web.ee.lesson11;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.eclipse.jetty.http.HttpStatus;

import java.io.IOException;
import java.io.PrintWriter;

public class RedirectServlet extends HttpServlet {

    private final String url;

    public RedirectServlet(String url) {
        this.url = url;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setStatus(HttpStatus.MOVED_PERMANENTLY_301);
        resp.sendRedirect(url);
    }

}
