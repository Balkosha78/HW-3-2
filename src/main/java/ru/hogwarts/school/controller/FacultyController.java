package ru.hogwarts.school.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.FacultyService;

import java.util.List;

@RestController
@RequestMapping("/faculties")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }


    @GetMapping("/{id}")
    public Faculty getFaculty(@PathVariable Long id){
        return facultyService.getFaculty(id);
    }

    @PostMapping
    public Faculty addFaculty(@RequestBody Faculty faculty){
        return facultyService.addFaculty(faculty);
    }
    @PutMapping
    public ResponseEntity<Faculty> updateFaculty(@PathVariable Long id, @RequestBody Faculty faculty){
        Faculty savedFaculty = facultyService.updateFaculty(id, faculty);
        if (savedFaculty == null){
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(savedFaculty);
        }
    }
    @DeleteMapping("/{id}")
    public void deleteFaculty(@PathVariable Long id){
        facultyService.deleteFaculty(id);
    }
    @GetMapping("/by-color")
    public List<Faculty> getFacultiesByColor(@RequestParam String color){
        return facultyService.getFacultiesByColor(color);
    }
    @GetMapping("/by-color-or-name")
    public List<Faculty> getFacultiesByColorOrName(@RequestParam String color, @RequestParam String name){
        return facultyService.getFacultiesByColorOrName(color, name);
    }
    @GetMapping("/{id}/students")
    public List<Student> getStudents(@PathVariable Long id){
        return facultyService.getStudents(id);
    }

}
