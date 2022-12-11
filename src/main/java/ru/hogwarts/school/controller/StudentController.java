package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public Collection<Student> getAll(){
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable("id") long id){
        return studentService.getStudent(id);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @PutMapping()
    public Student editStudent(@RequestBody Student student){
        return studentService.editStudent(student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delStudent(@PathVariable("id") Long id){
        studentService.delStudent(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/get")
    public Collection<Student> getStudent(@RequestParam("age") int age){
        return studentService.getStudents(age);
    }
}
