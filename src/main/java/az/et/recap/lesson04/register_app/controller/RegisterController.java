package az.et.recap.lesson04.register_app.controller;

import az.et.recap.lesson04.register_app.model.CommonResponseDto;
import az.et.recap.lesson04.register_app.model.RegisterDto;
import az.et.recap.lesson04.register_app.service.RegisterService;

import java.util.regex.Pattern;

public class RegisterController {

    private final RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    public CommonResponseDto<RegisterDto> register(RegisterDto registerDto) {
        // validate registerDto
        if (registerDto.getName() == null || registerDto.getName().isBlank())
            throw new IllegalArgumentException("User's name cannot be blank!");

        RegisterDto registeredUser = registerService.register(registerDto);

        return new CommonResponseDto<>(registeredUser, 200);
    }

}
