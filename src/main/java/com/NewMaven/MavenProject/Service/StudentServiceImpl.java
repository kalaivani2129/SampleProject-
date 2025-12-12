package com.NewMaven.MavenProject.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NewMaven.MavenProject.Model.Student;
import com.NewMaven.MavenProject.Repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repo;

    @Override
    public String saveStudent(Student student) {
        repo.save(student);
        return "Student saved successfully";
    }

    @Override
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    @Override
    public Student getStudentById(int id) {
        Optional<Student> st = repo.findById(id);
        return st.orElse(null);
    }

    @Override
    public Student updateStudent(int id, Student student) {
        Optional<Student> exist = repo.findById(id);
        if (exist.isPresent()) {
            Student s = exist.get();
            s.setName(student.getName());
            s.setEmail(student.getEmail());
            repo.save(s);
            return s;
        }
        return null;
    }

    @Override
    public Student deleteStudent(int id) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteStudent'");
    }

    // @Override
    // public String deleteStudent(int id) {
    //     if (repo.existsById(id)) {
    //         repo.deleteById(id);
    //         return "Student deleted successfully";
    //     } else {
    //         return "Student not found";
    //     }
    // }
}
