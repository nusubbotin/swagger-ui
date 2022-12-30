package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repositories.StudentRepository;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

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

    public Double getAgeAvg() {
        logger.info("getAgeAvg: starting");
        //int ageAvg = studentRepository.getAgeAvg();
        Collection<Student> students = studentRepository.findAll();
        Double ageAvg = students.stream()
                        .map(e -> e.getAge())
                        .mapToInt(e->e)
                        .average().orElse(0);
        logger.info("getAgeAvg: finish");
        return ageAvg;
    }

    public Collection<String> getLast(int count) {
        logger.info("getLast: starting");
        Collection<String> students = studentRepository.getLast(count);
        logger.info("getLast: finish");
        return students;
    }

    public Collection<String> getSortedStudentByName(String firstChar) {
        logger.info("getSortedStudentByName: starting");
        Collection<Student> students = studentRepository.findAll();
        Collection<String> studentsNameList = students.stream()
                .map(e ->  e.getName().toUpperCase())
                .filter(e -> e.startsWith(firstChar))
                .sorted()
                .toList();
        logger.info("getSortedStudentByName: finish");
        return studentsNameList;
    }

    public int getNumber() {
        int sum = Stream.iterate(1, a -> a +1)
                .limit(1_000_000)
                .parallel()
                .reduce(0, (a, b) -> a + b);
        return sum;
    }

    public void presenParallelOutput() {
        List<Student> students = studentRepository.findAll();

        System.out.println(students.get(0).getName());
        System.out.println(students.get(1).getName());

        Thread thread = new Thread(() -> {
            System.out.println(students.get(2).getName());
            System.out.println(students.get(3).getName());
        });
        thread.start();

        new Thread(() -> {
            System.out.println(students.get(4).getName());
            System.out.println(students.get(5).getName());
        }).start();
    }
}
