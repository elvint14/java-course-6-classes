package az.et.web.ee.lesson11.registerapp.dao.impl;

import az.et.web.ee.lesson11.registerapp.dao.RegisterDao;
import az.et.web.ee.lesson11.registerapp.dao.entity.UserEntity;

import java.time.LocalDate;
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
        newUserEntity.setCreateDate(LocalDate.now());
        newUserEntity.setUpdateDate(LocalDate.now());
        USERS.add(newUserEntity);
        USERS.forEach(System.err::println);
        return newUserEntity;
    }

}
