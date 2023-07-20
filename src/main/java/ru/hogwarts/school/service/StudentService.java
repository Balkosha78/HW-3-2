package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;


@Service
public class StudentService {
    @Autowired
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public Student createStudent(Student student){
        return studentRepository.save(student);
    }
    public Student findStudent(long id){
        return studentRepository.findById(id).orElse(null) ;
    }

    public Student editStudent(Student student){
            return studentRepository.save(student);
    }
    public void deleteStudent(long id){
        studentRepository.deleteById(id);
    }

    public Collection<Student> findByAge(int age) {
        return studentRepository.findAll();
    }
}
