package az.et.web.ee.lesson10;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.OutputStream;
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

}
