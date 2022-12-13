package az.et.web.ee.lesson11;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.OutputStream;

public class CalcServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. input
        String x = req.getParameter("x");
        String y = req.getParameter("y");
        String op = req.getParameter("op");
        System.out.println(x);
        System.out.println(y);
        System.out.println(op);

        // 2. process
        Calculator calculator = new Calculator();
        String result = calculator.doOp(x, y, op);

        // 3. output
        try (OutputStream os = resp.getOutputStream()) {
            os.write(result.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
