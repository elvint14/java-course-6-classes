package az.et.web.ee.lesson12.rest;

import az.et.web.ee.lesson12.rest.dao.StudentDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import freemarker.template.TemplateException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class DataSupplyServlet extends HttpServlet {

    private final ObjectMapper objectMapper
//            = new XmlMapper();
            = new JsonMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (PrintWriter pw = resp.getWriter()) {
            pw.write(objectMapper.writeValueAsString(StudentDao.STUDENTS));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
