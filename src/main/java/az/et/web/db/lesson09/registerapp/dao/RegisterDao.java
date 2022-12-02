package az.et.web.db.lesson09.registerapp.dao;

import az.et.web.db.lesson09.registerapp.dao.entity.UserEntity;

import java.sql.Connection;
import java.util.Optional;

public interface RegisterDao {

    Optional<UserEntity> findByEmail(final String email);

    UserEntity addUser(UserEntity newUserEntity);

}
