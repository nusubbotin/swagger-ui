package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repositories.FacultyRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FacultyService {
    private FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty addFaculty(Faculty faculty){
        return facultyRepository.save(faculty);
    }

    public Faculty editFaculty(Faculty faculty){
        return facultyRepository.save(faculty);
    }

    public Faculty getFaculty(Long id){
       return facultyRepository.findById(id).get();
    }

    public void delFaculty(Long id){
        facultyRepository.deleteById(id);
    }

    public Collection<Faculty> getAll(){
        return facultyRepository.findAll();
    }

    public Collection<Faculty> getFacultes(String color){
        return facultyRepository.findByCollor(color);
    }
}
