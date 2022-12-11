package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.exception.FacultyNotFoundException;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FacultyService {
    private long sequence = 0;
    private final Map<Long, Faculty> facultes = new HashMap<>();

    private void checkExistsFaculty(Long id){
        if (!facultes.containsKey(id)) {
            throw new FacultyNotFoundException();
        }
    }

    public Faculty addFaculty(Faculty Faculty){
        long newId = sequence++;
        Faculty.setId(newId);
        facultes.put(newId, Faculty);
        return Faculty;
    }

    public Faculty editFaculty(Long id, Faculty Faculty){
        checkExistsFaculty(id);

        Faculty currentFaculty = facultes.get(id);
        currentFaculty.setColor(Faculty.getColor());
        currentFaculty.setName(Faculty.getName());
        return currentFaculty;
    }

    public Faculty getFaculty(Long id){
        checkExistsFaculty(id);
        return facultes.get(id);
    }

    public void delFaculty(Long id){
        checkExistsFaculty(id);
        facultes.remove(id);
    }

    public Collection<Faculty> getAll(){
        return facultes.values();
    }

    public Collection<Faculty> getFacultes(String color){
        return facultes.values().stream()
                .filter(e -> e.getColor().equals(color))
                .collect(Collectors.toList());
    }
}
