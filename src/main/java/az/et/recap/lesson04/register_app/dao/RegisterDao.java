package az.et.recap.lesson04.register_app.dao;

import az.et.recap.lesson04.register_app.dao.entity.UserEntity;
import az.et.recap.lesson04.register_app.model.RegisterDto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

// dao -> data access object, dal - data access layer
// n-layered architecture
public interface RegisterDao {

    // CRUD - Create, Retrieve (Read), Update, Delete
    Optional<UserEntity> findByEmail(final String email);

    UserEntity addUser(UserEntity newUserEntity);

}
