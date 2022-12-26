package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repositories.StudentRepository;

import java.util.Collection;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    Logger logger = LoggerFactory.getLogger(StudentService.class);

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student){
        logger.info("addStudent: starting");
        Student newStudent = studentRepository.save(student);
        logger.info("addStudent: finish");
        return newStudent;
    }

    public Student editStudent(Student student){
        logger.info("editStudent: starting");
        Student editStudent = studentRepository.save(student);
        logger.info("editStudent: finish");
        return editStudent;
    }

    public Student getStudent(Long id){
        logger.info("getStudent: starting");
        Student student = studentRepository.findById(id).get();
        logger.info("getStudent: finish");
        return student;
    }

    public void delStudent(Long id){
        logger.info("delStudent: starting");
        studentRepository.deleteById(id);
        logger.info("delStudent: finish");
    }

    public Collection<Student> getAll(){
        logger.info("getAll: starting");
        Collection<Student> students = studentRepository.findAll();
        logger.info("getAll: finish");
        return students;
    }

    public Collection<Student> getStudents(int age){
        logger.info("getStudents: starting");
        Collection<Student> students = studentRepository.findByAge(age);
        logger.info("getStudents: finish");
        return students;
    }

    public Collection<Student> findByAgeBetween(int min, int max){
        logger.info("findByAgeBetween: starting");
        Collection<Student> students = studentRepository.findByAgeBetween(min, max);
        logger.info("findByAgeBetween: finish");
        return students;
    }

    public Faculty getStudentFaculty(Long id){
        logger.info("getStudentFaculty: starting");
        Faculty faculty = studentRepository.findById(id).get().getFaculty();
        logger.info("getStudentFaculty: finish");
        return faculty;
    }

    public int getStudentCount() {
        logger.info("getStudentCount: starting");
        int studentCount = studentRepository.getStudentCount();
        logger.info("getStudentCount: finish");
        return studentCount;
    }

    public int getAgeAvg() {
        logger.info("getAgeAvg: starting");
        int ageAvg = studentRepository.getAgeAvg();
        logger.info("getAgeAvg: finish");
        return ageAvg;
    }

    public Collection<String> getLast(int count) {
        logger.info("getLast: starting");
        Collection<String> students = studentRepository.getLast(count);
        logger.info("getLast: finish");
        return students;
    }
}
