package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.FacultyService;

import java.util.Collection;

@RestController
@RequestMapping("/faculty")

public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("/{id}")
    public Faculty getFaculty(@PathVariable("id") long id){
        return facultyService.getFaculty(id);
    }

    @PostMapping
    public Faculty createFaculty(@RequestBody Faculty faculty){
        return facultyService.addFaculty(faculty);
    }

    @PutMapping
    public Faculty editFaculty(@RequestBody Faculty faculty){
        return facultyService.editFaculty(faculty);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delFaculty(@PathVariable("id") Long id){
        facultyService.delFaculty(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get")
    public Collection<Faculty> getFaculties(@RequestParam(required = false) String color,
                                          @RequestParam(required = false) String namePart,
                                          @RequestParam(required = false) String colorPart
    ){
        if (color != null){
            return facultyService.getFaculties(color);
        } else if (namePart != null & colorPart != null) {
            return facultyService.getFacultiesByNameOrColor(namePart, colorPart);
        }

        return facultyService.getAll();
    }

    @GetMapping("/getStudents/{id}")
    public Collection<Student> getStudentsById(@PathVariable("id") Long id){
        return facultyService.findStudentsById(id);
    }
}
