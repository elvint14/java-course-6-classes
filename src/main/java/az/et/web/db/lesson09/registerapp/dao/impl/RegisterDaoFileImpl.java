package az.et.web.db.lesson09.registerapp.dao.impl;

import az.et.web.db.lesson09.registerapp.dao.RegisterDao;
import az.et.web.db.lesson09.registerapp.dao.entity.UserEntity;

import java.util.Optional;

public class RegisterDaoFileImpl implements RegisterDao {

    // CRUD - Create, Retrieve (Read), Update, Delete
    public Optional<UserEntity> findByEmail(final String email) {
        return Optional.empty();
    }

    public UserEntity addUser(UserEntity newUserEntity) {
        return null;
    }

}
