package az.et.web.ee.lesson11;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.eclipse.jetty.http.HttpStatus;

import java.io.PrintWriter;
import java.time.LocalDateTime;

public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try (PrintWriter pw = resp.getWriter()) {
            pw.write("Hello, Java EE!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
