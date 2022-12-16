package az.et.web.ee.lesson12.templateengine;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.HashMap;

public class DynamicServlet extends HttpServlet {

    private final TemplateEngine templateEngine;

    public DynamicServlet(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        HashMap<String, Object> data = new HashMap<>();
        String name = req.getParameter("name");
        data.put("name", name);
        templateEngine.render("dynamic1.ftl", data, resp);
    }

}