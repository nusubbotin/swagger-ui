package ru.hogwarts.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repositories.StudentRepository;

import java.util.Collection;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    public Student editStudent(Student student){
        return studentRepository.save(student);
    }

    public Student getStudent(Long id){
        return studentRepository.findById(id).get();
    }

    public void delStudent(Long id){
        studentRepository.deleteById(id);
    }

    public Collection<Student> getAll(){

        return studentRepository.findAll();
    }

    public Collection<Student> getStudents(int age){
        return studentRepository.findByAge(age);
    }
}
