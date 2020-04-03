package application.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Student {

    private UUID id;
    private final Integer age;
    private final String FirstName;
    private final String LastName;
    private final String course;

    public Student(
            @JsonProperty("id") UUID id,
            @JsonProperty("age")Integer age,
            @JsonProperty("firstName")String firstName,
            @JsonProperty("lastName")String lastName,
            @JsonProperty("course")String course) {
        this.id = id;
        this.age = age;
        FirstName = firstName;
        LastName = lastName;
        this.course = course;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getCourse() {
        return course;
    }
}
