package az.et.web.db.lesson09.registerapp.service;

import az.et.web.db.lesson09.registerapp.dao.RegisterDao;
import az.et.web.db.lesson09.registerapp.dao.entity.UserEntity;
import az.et.web.db.lesson09.registerapp.exception.UserAlreadyException;
import az.et.web.db.lesson09.registerapp.model.dto.RegisterDto;
import az.et.web.db.lesson09.registerapp.model.request.RegisterRequest;

public class RegisterService {

    private final RegisterDao registerDao;

    public RegisterService(RegisterDao registerDao) {
        this.registerDao = registerDao;
    }

    public RegisterDto register(RegisterRequest request) {
        final String email = request.getEmail();
        registerDao.findByEmail(email).ifPresent(user -> {
            if (user.getId() != null) {
                throw new UserAlreadyException("User with email '" + email + "' already exists!");
            }
        });

        final UserEntity newUserEntity = new UserEntity(request.getAge(),
                request.getName(),
                request.getEmail(),
                request.getPassword());
        UserEntity addedUser = registerDao.addUser(newUserEntity);

        return new RegisterDto(addedUser.getAge(), addedUser.getName(), addedUser.getEmail());
    }

}
