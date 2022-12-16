package az.et.web.ee.lesson12.templateengine;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class TemplateEngine {
    private static final String BASE_PATH = "src/main/java/az/et/web/ee/lesson12/";
    private static final String encoding = String.valueOf(StandardCharsets.UTF_8);
    private final Configuration conf;

    private TemplateEngine(String folder) throws IOException {
        this.conf = new Configuration(Configuration.VERSION_2_3_30) {{
            setDirectoryForTemplateLoading(new File(BASE_PATH.concat(folder)));
            setDefaultEncoding(encoding);
            setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            setWrapUncheckedExceptions(true);
            setLogTemplateExceptions(false);
        }};
    }

    public static TemplateEngine folder(String folder) throws IOException {
        return new TemplateEngine(folder);
    }

    public void render(String template, HashMap<String, Object> data, HttpServletResponse resp) {
        resp.setCharacterEncoding(encoding);

        try (PrintWriter writer = resp.getWriter()) {
            this.conf.getTemplate(template).process(data, writer);
        } catch (IOException | TemplateException e) {
            throw new RuntimeException("Freemarker error", e);
        }
    }

}