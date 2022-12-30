package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
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


    @GetMapping("/{id}")
    public Student getStudent(@PathVariable("id") Long id){
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
    public Collection<Student> getStudent(@RequestParam(required = false) Integer age,
                                          @RequestParam(required = false) Integer min,
                                          @RequestParam(required = false) Integer max
    ){
        if (age != null){
            return studentService.getStudents(age);
        } else if (min != null & max != null) {
            return studentService.findByAgeBetween(min.intValue(), max.intValue());
        }

        return studentService.getAll();
    }

    @GetMapping("/getFaculty/{id}")
    public Faculty getFacultyById(@PathVariable("id") Long id){
        return studentService.getStudentFaculty(id);
    }

    @GetMapping("/count")
    public int getStudentCount(){
        return studentService.getStudentCount();
    }

    @GetMapping("/age_avg")
    public Double getAgeAvg(){
        return studentService.getAgeAvg();
    }

    @GetMapping("/getLast")
    public Collection<String> getLast(@RequestParam int count){
        return studentService.getLast(count);
    }

    @GetMapping("/getSortedStudentByName/{firstChar}")
    public Collection<String> getSortedStudentByName(@PathVariable("firstChar") String firstChar){
        return studentService.getSortedStudentByName(firstChar);
    }

    @GetMapping("getNumber")
    public int getNumber(){
        return studentService.getNumber();
    }

    @GetMapping("/presenParallelOutput")
    public void presenParallelOutput(){
      studentService.presenParallelOutput();
    }

    @GetMapping("/presenSynchronizedOutput")
    public void presenSynchronizedOutput(){
        studentService.presenSynchronizedOutput();
    }
}
