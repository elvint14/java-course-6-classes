package az.et.web.ee.lesson11;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.eclipse.jetty.http.HttpStatus;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static az.et.web.ee.lesson10.StaticServlet.BASE_PATH;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try (OutputStream os = resp.getOutputStream()) {
            Path path = Paths.get(BASE_PATH, "templates", "login.html");
            Files.copy(path, os);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("pass");
        PrintWriter pw = resp.getWriter();
        try {
            requireNonNull(email);
            requireNonNull(password);
            pw.write("login successful!");
            resp.setStatus(HttpStatus.OK_200);
            // resp.sendRedirect("/calc");
        } catch (IllegalStateException e) {
            pw.write("login unsuccessful!");
            resp.setStatus(HttpStatus.UNAUTHORIZED_401);
            e.printStackTrace();
        }
    }

    private static void requireNonNull(String s) {
        if (s == null || s.isBlank()) {
            throw new IllegalStateException("Cannot be null!" + s);
        }
    }

}
