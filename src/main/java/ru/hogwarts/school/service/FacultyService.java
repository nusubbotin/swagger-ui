package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repositories.FacultyRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;

    Logger logger = LoggerFactory.getLogger(StudentService.class);

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

     public Collection<Faculty> getFaculties(String color){
        return facultyRepository.findByColor(color);
    }

    public Collection<Faculty> getFacultiesByNameOrColor(String namePart, String colorPart){
        return facultyRepository.findByNameContainsIgnoreCaseOrColorContainsIgnoreCase(namePart, colorPart);
    }

    public Collection<Student> findStudentsById(Long id){

        return facultyRepository.findById(id).get().getStudents();
    }

    public String getMaxName() {
        logger.info("getMaxName: Start");
        Collection<Faculty> faculties = facultyRepository.findAll();

        logger.info("getMaxName: calc maxLength");
        int maxLength = faculties.stream()
                .mapToInt(e-> e.getName().length())
                .max().orElse(0);
        logger.info("getMaxName: calc maxLength="+ maxLength);

        logger.info("getMaxName: calc MaxName");
        String maxName = faculties.stream()
                .map(e-> e.getName())
                .filter(e -> e.length() == maxLength)
                .limit(1)
                .collect(Collectors.joining());

        logger.info("getMaxName: calc MaxName="+maxName);
        return maxName;
    }
}
