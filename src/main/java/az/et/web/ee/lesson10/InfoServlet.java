package az.et.web.ee.lesson10;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.time.LocalDateTime;

public class InfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try (PrintWriter pw = resp.getWriter()) {
            System.out.println("GET method called -> " + LocalDateTime.now());
            pw.write("Hello, Java EE!");
        } catch (Exception e) {
            System.out.println(e);
        }

//        try (OutputStream os = resp.getOutputStream()) {
//            os.write("Hello, World!".getBytes());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

}
