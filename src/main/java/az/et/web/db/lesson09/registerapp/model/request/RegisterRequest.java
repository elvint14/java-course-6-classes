package az.et.web.db.lesson09.registerapp.model.request;

import java.util.Objects;

public class RegisterRequest {

    private int age;
    private String name;
    private String email;
    private String password;

    public RegisterRequest(int age, String name, String email, String password) {
        this.age = age;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public RegisterRequest(int age, String name, String email) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegisterRequest that = (RegisterRequest) o;
        return this.age == that.age
                && Objects.equals(this.name, that.name)
                && Objects.equals(this.email, that.email)
                && Objects.equals(this.password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name, email, password);
    }

    @Override
    public String toString() {
        return String.format("{age=%d, name='%s', email='%s', password='%s'}",
                age, name, email, password);
    }

}
