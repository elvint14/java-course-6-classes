package az.et.web.db.lesson09.registerapp.dao.entity;

import java.time.LocalDate;
import java.util.Objects;

public class UserEntity {

    private Long id;
    private Integer age;
    private String name;
    private String email;
    private String password;
    private LocalDate createDate;
    private LocalDate updateDate;

    public UserEntity(Long id, Integer age, String name, String email, String password, LocalDate createDate, LocalDate updateDate) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.email = email;
        this.password = password;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public UserEntity(int age, String name, String email, String password) {
        this.age = age;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(age, that.age) && Objects.equals(name, that.name) && Objects.equals(email, that.email)
                && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name, email, password);
    }

    @Override
    public String toString() {
        return String.format("{id=%d, age=%d, name='%s', email='%s', password='%s', createDate=%s, updateDate=%s}",
                id, age, name, email, password, createDate, updateDate);
    }
}
