package az.et.web.ee.lesson11.registerapp.controller;

import az.et.web.ee.lesson11.registerapp.model.dto.CommonResponseDto;
import az.et.web.ee.lesson11.registerapp.model.dto.RegisterDto;
import az.et.web.ee.lesson11.registerapp.model.request.RegisterRequest;
import az.et.web.ee.lesson11.registerapp.service.RegisterService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.eclipse.jetty.http.HttpStatus;

import java.io.IOException;
import java.io.PrintWriter;

public class RegisterController extends HttpServlet {

    private final RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int status;
        String result;
        String redirectUrl;
        PrintWriter pw = resp.getWriter();

        try {
            String age = req.getParameter("age");
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            RegisterRequest registerRequest = new RegisterRequest(Integer.parseInt(age), name, email, password);
            CommonResponseDto<RegisterDto> registerResponse = register(registerRequest);

            result = registerResponse.toString();
            status = HttpStatus.OK_200;
            redirectUrl = "/login";
        } catch (Exception e) {
            result = e.getMessage();
            redirectUrl = "/register";
            status = HttpStatus.BAD_REQUEST_400;
        }

        pw.write(result);
        resp.setStatus(status);
        // resp.sendRedirect(redirectUrl);
    }

    public CommonResponseDto<RegisterDto> register(RegisterRequest request) {
        if (request.getName() == null || request.getName().isBlank()) {
            throw new IllegalArgumentException("User's name cannot be blank!");
        }

        RegisterDto registeredUser = registerService.register(request);

        return new CommonResponseDto<>(registeredUser, 200);
    }

}
