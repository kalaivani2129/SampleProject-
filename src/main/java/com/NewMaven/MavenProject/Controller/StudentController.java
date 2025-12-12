package com.NewMaven.MavenProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.NewMaven.MavenProject.Model.Student;
import com.NewMaven.MavenProject.Service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/add")
    public String save(@RequestBody Student student) {
        return service.saveStudent(student);
    }

    @GetMapping("/all")
    public List<Student> getAll() {
        return service.getAllStudents();
    }

    @GetMapping("/get/{id}")
    public Student getStudent(@PathVariable int id) {
        return service.getStudentById(id);
    }

    @PutMapping("/update/{id}")
    public Student update(@PathVariable int id, @RequestBody Student student) {
        return service.updateStudent(id, student);
    }

    // @DeleteMapping("/delete/{id}")
    // public Student delete(@PathVariable int id) {
    //     return service.deleteStudent(id);
    //    }
}
