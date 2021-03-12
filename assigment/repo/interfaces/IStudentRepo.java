package com.assigment.repo.interfaces;

import com.assigment.entities.Student;

import java.util.List;

public interface IStudentRepo {
    boolean createStudent(Student student);
    Student getStudent(int id);
    List<Student> getAllStudents();
}
