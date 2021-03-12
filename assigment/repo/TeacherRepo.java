package com.assigment.repo;

import com.assigment.data.interfaces.IDB;
import com.assigment.entities.Teacher;
import com.assigment.repo.interfaces.ITeacherRepo;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class TeacherRepo implements ITeacherRepo {
    private final IDB db;

    public TeacherRepo(IDB db) {
        this.db = db;
    }
    //through this we put connection to our db
    @Override
    public boolean createTeacher(Teacher teacher) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO teacher(name,salary,center) VALUES (?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, teacher.getName());
            st.setInt(3, teacher.getSalary());
            st.setString(1, teacher.getCenter());

            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Teacher getTeacher(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT name,salary,center FROM employee WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Teacher teacher = new Teacher(
                        rs.getString("name"),
                        rs.getInt("salary"),
                        rs.getString("center"));

                return teacher;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT name,salary,center FROM teacher";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Teacher> teachers = new LinkedList<>();
            while (rs.next()) {
                Teacher teacher = new Teacher(
                        rs.getString("name"),
                        rs.getInt("salary"),
                        rs.getString("center"));

                teachers.add(teacher);
            }

            return teachers;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}
