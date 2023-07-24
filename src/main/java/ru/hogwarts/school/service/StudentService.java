package ru.hogwarts.school.service;

import org.springframework.web.bind.annotation.RequestParam;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.List;

public interface StudentService {
    Student addStudent(Student student);
    Student getStudent(Long id);
    Student updateStudent(Long id, Student student);
    void deleteStudent(Long id);
    List<Student> getStudentByAge( int age);
    List<Student>findByAgeBetween(int min, int max);
    Faculty getFacultyByStudent(Long id);
}
