package az.et.web.ee.lesson12.rest;

import az.et.web.ee.lesson12.rest.model.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.OutputStream;

import static az.et.web.ee.lesson12.rest.dao.StudentDao.STUDENTS;

public class DataConsumeServlet extends HttpServlet {

    private final ObjectMapper objectMapper;

    public DataConsumeServlet(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try (OutputStream os = resp.getOutputStream()) {
            Student student = objectMapper.readValue(req.getReader(), Student.class);
            System.out.println(student);
            STUDENTS.add(student);
            os.write(objectMapper.writeValueAsBytes(STUDENTS));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
