package com.NewMaven.MavenProject.Service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.NewMaven.MavenProject.Model.Student;

@Service
public interface StudentService {
    String saveStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(int id);
    Student updateStudent(int id, Student student);
    Student deleteStudent(int id);
}
