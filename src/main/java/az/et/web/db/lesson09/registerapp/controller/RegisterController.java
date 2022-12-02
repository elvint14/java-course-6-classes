package az.et.web.db.lesson09.registerapp.controller;

import az.et.web.db.lesson09.registerapp.model.dto.CommonResponseDto;
import az.et.web.db.lesson09.registerapp.model.dto.RegisterDto;
import az.et.web.db.lesson09.registerapp.model.request.RegisterRequest;
import az.et.web.db.lesson09.registerapp.service.RegisterService;

public class RegisterController {

    private final RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    public CommonResponseDto<RegisterDto> register(RegisterRequest request) {
        if (request.getName() == null || request.getName().isBlank()) {
            throw new IllegalArgumentException("User's name cannot be blank!");
        }

        RegisterDto registeredUser = registerService.register(request);

        return new CommonResponseDto<>(registeredUser, 200);
    }

}
