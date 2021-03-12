package com.assigment.repo;

import com.assigment.data.interfaces.IDB;
import com.assigment.entities.Student;
import com.assigment.repo.interfaces.IStudentRepo;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class StudentRepo implements IStudentRepo {
    private final IDB db;
    //through this we put connection to our db
    public StudentRepo(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createStudent(Student student) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO student(name,salary,center) VALUES (?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, student.getName());
            st.setInt(3, student.getSalary());
            st.setString(1, student.getCenter());

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
    public Student getStudent(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT name,salary,center FROM Student WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Student student = new Student(
                        rs.getString("name"),
                        rs.getInt("salary"),
                        rs.getString("center"));

                return student;
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
    public List<Student> getAllStudents() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT name,salary,center FROM employees";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Student> students = new LinkedList<>();
            while (rs.next()) {
                Student student = new Student(
                        rs.getString("name"),
                        rs.getInt("salary"),
                        rs.getString("center"));

                students.add(student);
            }

            return students;
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
