package az.et.lesson13.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Student {

    private String name;
    private int age;
    private String group;
    private List<String> courses;

}
