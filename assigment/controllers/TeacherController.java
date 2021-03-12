package com.assigment.controllers;

import com.assigment.entities.Teacher;
import com.assigment.repo.interfaces.ITeacherRepo;

import java.util.List;

public class TeacherController {
    private final ITeacherRepo repo;

    public TeacherController(ITeacherRepo repo) {
        this.repo = repo;
    }

    public String createTeacher( String name, Integer salary,String center) {
        Teacher employee = new Teacher(name, salary,center);

        boolean created = repo.createTeacher(employee);
//All the same as in center Controller, look their
        return (created ? "Employee was created!" : "Employee creation was failed!");
    }
    //All the same as in center Controller, look their
    public String getTeacher(int id) {
        Teacher teacher = repo.getTeacher(id);

        return (teacher == null ? "Teacher was not found!" : teacher.toString());
    }

    public String getAllTeachers() {
        List<Teacher> teachers = repo.getAllTeachers();

        return teachers.toString();
    }
}
