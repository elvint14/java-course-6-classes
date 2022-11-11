package az.et.recap.lesson04.register_app.dao;

import az.et.recap.lesson04.register_app.dao.entity.UserEntity;

import java.util.Optional;

public class RegisterDaoPostgresImpl implements RegisterDao {

    // CRUD - Create, Retrieve (Read), Update, Delete
    public Optional<UserEntity> findByEmail(final String email) {
        return Optional.empty();
    }

    public UserEntity addUser(UserEntity newUserEntity) {
        return null;
    }

}
