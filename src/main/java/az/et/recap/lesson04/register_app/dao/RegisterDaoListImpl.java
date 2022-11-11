package az.et.recap.lesson04.register_app.dao;

import az.et.recap.lesson04.register_app.dao.entity.UserEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class RegisterDaoListImpl implements RegisterDao {

    private static final List<UserEntity> USERS = new ArrayList<>(
            Arrays.asList(
                    new UserEntity(24, "Elvin", "e@e.com", "123"),
                    new UserEntity(20, "Elvin2", "e@e.com", "123")
            )
    );

    // CRUD - Create, Retrieve (Read), Update, Delete
    public Optional<UserEntity> findByEmail(final String email) {
        return USERS.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst();
    }

    public UserEntity addUser(UserEntity newUserEntity) {
        newUserEntity.setId((long) (Math.random() * 1000));
        newUserEntity.setCreateDate(LocalDateTime.now());
        newUserEntity.setUpdateDate(LocalDateTime.now());
        USERS.add(newUserEntity);
        USERS.forEach(user -> System.err.println(user));
        return newUserEntity;
    }

}
