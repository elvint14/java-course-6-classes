package az.et.web.db.lesson09.registerapp.model.dto;

import java.util.Objects;

// dto  -> data transfer object
// POJO -> Plain Old Java Object
public class RegisterDto {

    private int age;
    private String name;
    private String email;

    public RegisterDto(int age, String name, String email) {
        this.age = age;
        this.name = name;
        this.email = email;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegisterDto that = (RegisterDto) o;
        return this.age == that.age
                && Objects.equals(this.name, that.name)
                && Objects.equals(this.email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name, email);
    }

    @Override
    public String toString() {
        return String.format("{age=%d, name='%s', email='%s'}", age, name, email);
    }

}
