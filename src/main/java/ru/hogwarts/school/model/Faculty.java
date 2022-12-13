package ru.hogwarts.school.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;
@Entity
public class Faculty {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String color;

    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY,
            mappedBy = "faculty")
    private Set<Student> students;

    public Faculty(long id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}

