package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.exception.StudentNotFoundException;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private long sequence = 0;
    private final Map<Long, Student> strudents = new HashMap<>();

    private void checkExistsStudent(Long id){
        if (!strudents.containsKey(id)) {
            throw new StudentNotFoundException();
        }
    }

    public Student addStudent(Student student){
        long newId = sequence++;
        student.setId(newId);
        strudents.put(newId, student);
        return student;
    }

    public Student editStudent(Long id, Student student){
        checkExistsStudent(id);

        Student currentStudent = strudents.get(id);
        currentStudent.setAge(student.getAge());
        currentStudent.setName(student.getName());
        return currentStudent;
    }

    public Student getStudent(Long id){
        checkExistsStudent(id);
        return strudents.get(id);
    }

    public void delStudent(Long id){
        checkExistsStudent(id);
        strudents.remove(id);
    }

    public Collection<Student> getAll(){
        return strudents.values();
    }

    public Collection<Student> getStudents(int age){
        return strudents.values().stream()
                .filter(e -> e.getAge() == age)
                .collect(Collectors.toList());
    }
}
