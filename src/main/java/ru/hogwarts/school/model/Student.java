package ru.hogwarts.school.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Student {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int age;

}
