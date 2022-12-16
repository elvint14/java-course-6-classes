package az.et.web.ee.lesson11;

import az.et.web.ee.lesson11.registerapp.controller.RegisterController;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class JettyServerApp {

    public static void main(String[] args) throws Exception {
        Server server = new Server(9000);

        ServletContextHandler handler = new ServletContextHandler();
        handler.addServlet(new ServletHolder(new HelloWorldServlet()), "/hello");
        handler.addServlet(new ServletHolder(new RedirectServlet("/hello")), "/main");
        handler.addServlet(new ServletHolder(new RedirectServlet("/hello")), "/homepage");
        handler.addServlet(new ServletHolder(new StaticServlet("image")), "/image/*");
        handler.addServlet(new ServletHolder(new StaticServlet("js")), "/js/*");
        handler.addServlet(new ServletHolder(new StaticServlet("css")), "/css/*");
        handler.addServlet(new ServletHolder(new LoginServlet()), "/login");
        handler.addServlet(new ServletHolder(new CalcServlet()), "/calc");

        server.setHandler(handler);
        server.start();
        server.join();
    }

}
