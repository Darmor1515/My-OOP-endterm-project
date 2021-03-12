package com.assigment.repo;

import com.assigment.data.interfaces.IDB;
import com.assigment.entities.Director;
import com.assigment.repo.interfaces.IDirectorRepo;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DirectorRepo implements IDirectorRepo {
    private final IDB db;

    public DirectorRepo(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createDirector(Director director) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO director(name,center,salary) VALUES (?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
// all exectly as Center repo, nothing changes
            st.setString(1, director.getName());
            st.setString(1, director.getCenter());
            st.setInt(3, director.getSalary());
// all exectly as Center repo, nothing changes
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
    }// all exectly as Center repo, nothing changes

    @Override//use this because we implement I...
    public Director getDirector(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,center,salary FROM Director WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Director director = new Director(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("center"),
                        rs.getInt("salary"));

                return director;
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
    // all exectly as Center repo, nothing changes
    @Override
    public List<Director> getAllDirectors() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT name,center,salary FROM director";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Director> directors = new LinkedList<>();
            while (rs.next()) {
                Director director = new Director(

                        rs.getString("name"),
                        rs.getString("center"),
                        rs.getInt("salary"));
                directors.add(director);
            }

            return directors;
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
