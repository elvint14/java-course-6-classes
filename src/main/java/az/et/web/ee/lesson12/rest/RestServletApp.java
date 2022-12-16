package az.et.web.ee.lesson12.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class RestServletApp {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8081);
        ObjectMapper objectMapper = new ObjectMapper();
        ServletContextHandler handler = new ServletContextHandler();

        handler.addServlet(new ServletHolder(new DataSupplyServlet()), "/supply");
        handler.addServlet(new ServletHolder(new DataConsumeServlet(objectMapper)), "/consume");

        server.setHandler(handler);
        server.start();
        server.join();
    }

}
