package az.et.web.ee.lesson12.templateengine;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class DynamicServerApp {
    public static void main(String[] args) throws Exception {

        Server server = new Server(8080);
        ServletContextHandler handler = new ServletContextHandler();

        // template engine configuration
        TemplateEngine templateEngine = TemplateEngine.folder("templates");

        // servlets
        handler.addServlet(new ServletHolder(new DynamicServlet(templateEngine)), "/dynamic1");
        // handler.addServlet(new ServletHolder(new DynamicServlet2(templateEngine)), "/dynamic2");

        server.setHandler(handler);
        server.start();
        server.join();
    }
}