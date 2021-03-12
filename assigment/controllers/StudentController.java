package com.assigment.controllers;

import com.assigment.entities.Student;
import com.assigment.repo.interfaces.IStudentRepo;

import java.util.List;

public class StudentController {
    private final IStudentRepo repo;
    //All the same as in center Controller, look their
    public StudentController(IStudentRepo repo) {
        this.repo = repo;
    }
    //All the same as in center Controller, look their
    public String createStudent( String name, Integer salary,String center) {
        Student student = new Student(name, salary,center);

        boolean created = repo.createStudent(student);

        return (created ? "Student was created!" : "Student creation was failed!");
    }

    public String getStudent(int id) {
        Student student = repo.getStudent(id);

        return (student == null ? "Student was not found!" : student.toString());
    }

    public String getAllStudents() {
        List<Student> students = repo.getAllStudents();

        return students.toString();
    }
}
