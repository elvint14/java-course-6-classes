package az.et.web.ee.lesson11.registerapp.dao.impl;

import az.et.web.ee.lesson11.registerapp.dao.RegisterDao;
import az.et.web.ee.lesson11.registerapp.dao.entity.UserEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;

public class RegisterDaoPostgresImpl implements RegisterDao {
    private static final String FIND_BY_EMAIL_SQL = "SELECT * FROM users where email = ?";
    public static final String ADD_USER_SQL = "INSERT INTO users (age, name, email, password) VALUES (?, ?, ?, ?)";

    private final Connection conn;

    public RegisterDaoPostgresImpl(Connection conn) {
        this.conn = conn;
    }


    @Override
    public Optional<UserEntity> findByEmail(final String email) {
        try {
            PreparedStatement ps = conn.prepareStatement(FIND_BY_EMAIL_SQL);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            Long id = null;
            int age = 0;
            String name = null;
            String password = null;
            LocalDate createDate = null;
            LocalDate updateDate = null;
            while (rs.next()) {
                id = rs.getLong("id");
                age = rs.getInt("age");
                name = rs.getString("name");
                password = rs.getString("password");
                createDate = rs.getDate("create_date").toLocalDate();
                updateDate = rs.getDate("update_date").toLocalDate();
            }
            UserEntity userEntityByEmail = new UserEntity(id, age, name, email, password, createDate, updateDate);
            System.out.println(userEntityByEmail);
            return Optional.of(userEntityByEmail);
        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public UserEntity addUser(UserEntity newUserEntity) {
        try {
            PreparedStatement ps = conn.prepareStatement(ADD_USER_SQL);
            ps.setInt(1, newUserEntity.getAge());
            ps.setString(2, newUserEntity.getName());
            ps.setString(3, newUserEntity.getEmail());
            ps.setString(4, newUserEntity.getPassword());
            int i = ps.executeUpdate();
            return newUserEntity;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
