package com.assigment.repo.interfaces;

import com.assigment.entities.Teacher;

import java.util.List;

public interface ITeacherRepo {
    boolean createTeacher(Teacher teacher);
    Teacher getTeacher(int id);
    List<Teacher> getAllTeachers();
}
