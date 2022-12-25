package ru.hogwarts.school.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.Collection;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Collection<Student> findByAge(int age);

    Collection<Student> findByAgeBetween(int min, int max);

    @Query(value = "SELECT count(1) FROM student", nativeQuery = true)
    int getStudentCount();

    @Query(value = "SELECT avg(age) FROM student", nativeQuery = true)
    int getAgeAvg();


    @Query(value = "select s.name from (SELECT * FROM student order by id desc LIMIT :count) as s order by id", nativeQuery = true)
    Collection<String> getLast(int count);
}
