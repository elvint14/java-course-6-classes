package az.et.recap.lesson04.register_app;

import az.et.recap.lesson04.register_app.controller.RegisterController;
import az.et.recap.lesson04.register_app.dao.RegisterDao;
import az.et.recap.lesson04.register_app.dao.RegisterDaoFileImpl;
import az.et.recap.lesson04.register_app.dao.RegisterDaoListImpl;
import az.et.recap.lesson04.register_app.dao.RegisterDaoPostgresImpl;
import az.et.recap.lesson04.register_app.exception.UserAlreadyException;
import az.et.recap.lesson04.register_app.model.CommonResponseDto;
import az.et.recap.lesson04.register_app.model.RegisterDto;
import az.et.recap.lesson04.register_app.service.RegisterService;

public class RegisterApp {

    public static void main(String[] args) {
        RegisterApp.run();
    }

    private static void run() {
        final RegisterDao registerDao = new RegisterDaoPostgresImpl();
//                = new RegisterDaoFileImpl();
//                = new RegisterDaoListImpl();

        final RegisterService registerService = new RegisterService(registerDao);
        final RegisterController registerController = new RegisterController(registerService);

        try {
            CommonResponseDto<RegisterDto> response =
                    registerController.register(new RegisterDto(20, "Elvin3", "a@a.com", "1234"));
            System.out.println("User registered successfully, user info:" + response);

//            CommonResponseDto<RegisterDto> response2 =
//                    registerController.register(new RegisterDto(20, "Elvin3", "a@a.com", "1234"));
//            System.out.println("User registered successfully, user info:" + response);

            CommonResponseDto<RegisterDto> response3 =
                    registerController.register(new RegisterDto(20, "", "a@a.com", "1234"));
            System.out.println("User registered successfully, user info:" + response);
        } catch (UserAlreadyException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e ){
            System.err.println(e.getMessage());
        }
    }

}
