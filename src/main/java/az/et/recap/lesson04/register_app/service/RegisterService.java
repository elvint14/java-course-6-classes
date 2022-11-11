package az.et.recap.lesson04.register_app.service;

import az.et.recap.lesson04.register_app.dao.RegisterDao;
import az.et.recap.lesson04.register_app.dao.entity.UserEntity;
import az.et.recap.lesson04.register_app.exception.UserAlreadyException;
import az.et.recap.lesson04.register_app.model.RegisterDto;

import java.util.Optional;

public class RegisterService {

    private final RegisterDao registerDao;

    public RegisterService(RegisterDao registerDao) {
        this.registerDao = registerDao;
    }

    public RegisterDto register(RegisterDto registerDto) {
        // check email
        final String email = registerDto.getEmail();
        Optional<UserEntity> userByEmail = registerDao.findByEmail(email);
        if (userByEmail.isPresent()) throw new UserAlreadyException("User with email " + email + " already exists!");

        // dto -> entity; mapping
        UserEntity newUserEntity = new UserEntity(registerDto.getAge(),
                registerDto.getName(),
                registerDto.getEmail(),
                registerDto.getPassword());
        UserEntity addedUser = registerDao.addUser(newUserEntity);
        return new RegisterDto(addedUser.getAge(), addedUser.getName(), addedUser.getEmail());
    }

}
