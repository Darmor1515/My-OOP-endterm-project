package com.assigment.repo;

import com.assigment.data.interfaces.IDB;
import com.assigment.entities.Mentor;
import com.assigment.repo.interfaces.IMentorRepo;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class MentorRepo implements IMentorRepo {
    private final IDB db;

    public MentorRepo(IDB db) {
        this.db = db;
    }
//through this we put connection to our db
    @Override
    public boolean createMentor(Mentor mentor) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO mentor(name,salary,center) VALUES (?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
// all exactly as Center repo, nothing changes
            st.setString(1, mentor.getName());
            st.setInt(3, mentor.getSalary());
            st.setString(3, mentor.getCenter());

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
    public Mentor getMentor(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,salary,center FROM mentor WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Mentor mentor = new Mentor(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("salary"),
                rs.getString("center"));

                return mentor;
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
    public List<Mentor> getAllMentors() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,salary,center FROM mentor";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Mentor> mentors = new LinkedList<>();
            while (rs.next()) {
                Mentor mentor = new Mentor(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("salary"),
                        rs.getString("center"));
                mentors.add(mentor);
            }

            return mentors;
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
