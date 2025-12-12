package com.NewMaven.MavenProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.NewMaven.MavenProject.Model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
