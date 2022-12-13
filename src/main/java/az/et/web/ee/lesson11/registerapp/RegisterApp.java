package az.et.web.ee.lesson11.registerapp;

import az.et.web.ee.lesson11.LoginServlet;
import az.et.web.ee.lesson11.registerapp.config.DataSourceConfig;
import az.et.web.ee.lesson11.registerapp.config.PostgresDataSourceConfig;
import az.et.web.ee.lesson11.registerapp.controller.RegisterController;
import az.et.web.ee.lesson11.registerapp.dao.RegisterDao;
import az.et.web.ee.lesson11.registerapp.dao.impl.RegisterDaoPostgresImpl;
import az.et.web.ee.lesson11.registerapp.exception.UserAlreadyException;
import az.et.web.ee.lesson11.registerapp.model.dto.CommonResponseDto;
import az.et.web.ee.lesson11.registerapp.model.dto.RegisterDto;
import az.et.web.ee.lesson11.registerapp.model.request.RegisterRequest;
import az.et.web.ee.lesson11.registerapp.service.RegisterService;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class RegisterApp {

    private final RegisterController registerController;

    public RegisterApp(RegisterController registerController) {
        this.registerController = registerController;
    }

    public static void main(String[] args) throws Exception {
        final DataSourceConfig dataSourceConfig = new PostgresDataSourceConfig();
        final RegisterDao registerDao = new RegisterDaoPostgresImpl(dataSourceConfig.getConnection());
        final RegisterService registerService = new RegisterService(registerDao);
        new RegisterApp(new RegisterController(registerService)).run();
    }

    private void run() throws Exception {
        Server server = new Server(9000);

        ServletContextHandler handler = new ServletContextHandler();
        handler.addServlet(new ServletHolder(registerController), "/register");
        handler.addServlet(new ServletHolder(new LoginServlet()), "/login");

        server.setHandler(handler);
        server.start();
        server.join();
    }

}
