package az.et.web.ee.lesson11.registerapp.dao;

import az.et.web.ee.lesson11.registerapp.dao.entity.UserEntity;

import java.util.Optional;

public interface RegisterDao {

    Optional<UserEntity> findByEmail(final String email);

    UserEntity addUser(UserEntity newUserEntity);

}
