package az.et.lesson13.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
public class Student {

    @NotBlank
    private String name;

    private int age;

    @NotBlank
    private String group;

    @NotEmpty
    @Size(min = 1, max = 10)
    private List<String> courses;

}
