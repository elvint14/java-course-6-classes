package az.et.web.db.lesson09.registerapp;

import az.et.web.db.lesson09.registerapp.config.DataSourceConfig;
import az.et.web.db.lesson09.registerapp.config.PostgresDataSourceConfig;
import az.et.web.db.lesson09.registerapp.controller.RegisterController;
import az.et.web.db.lesson09.registerapp.dao.RegisterDao;
import az.et.web.db.lesson09.registerapp.dao.impl.RegisterDaoPostgresImpl;
import az.et.web.db.lesson09.registerapp.exception.UserAlreadyException;
import az.et.web.db.lesson09.registerapp.model.dto.CommonResponseDto;
import az.et.web.db.lesson09.registerapp.model.dto.RegisterDto;
import az.et.web.db.lesson09.registerapp.model.request.RegisterRequest;
import az.et.web.db.lesson09.registerapp.service.RegisterService;

public class RegisterApp {

    private final RegisterController registerController;

    public RegisterApp(RegisterController registerController) {
        this.registerController = registerController;
    }

    public static void main(String[] args) {
        final DataSourceConfig dataSourceConfig = new PostgresDataSourceConfig();
        final RegisterDao registerDao = new RegisterDaoPostgresImpl(dataSourceConfig.getConnection());
        final RegisterService registerService = new RegisterService(registerDao);
        new RegisterApp(new RegisterController(registerService)).run();
    }

    private void run() {
        try {
            CommonResponseDto<RegisterDto> result = registerController.register(
                    new RegisterRequest(24, "Elvin", "et@a.com", "123"));

            System.out.println(result);
        } catch (UserAlreadyException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

}
