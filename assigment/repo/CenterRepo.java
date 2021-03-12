package com.assigment.repo;

import com.assigment.data.interfaces.IDB;
import com.assigment.entities.Center;
import com.assigment.repo.interfaces.ICenterRepo;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class CenterRepo implements ICenterRepo {
    private final IDB db;
    //through this we put connection to our db
    public CenterRepo(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createCenter(Center center) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO center(title,location) VALUES (?,?)";
            PreparedStatement st = con.prepareStatement(sql); //put sql line through our connection(con)
            st.setString(1, center.getTitle());
            st.setString(3, center.getLocation());
// put this values and replace &
            st.execute();
            return true;
        } catch (SQLException throwables) { //problems with enter, it is throws this
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
    public Center getCenter(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,title,location,work FROM center WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
//same as before, but sql change to select
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Center center = new Center(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("location"),
                        rs.getBoolean("work")
                ); // we get data from sql answer

                return center;
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
            }//mistakes in enterings
        }
        return null;
    }

    @Override
    public List<Center> getAllCenters() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,title,location,work FROM center";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            //same as before
            List<Center> centers = new LinkedList<>();
            //we take list of answers, we use library linked list and list
            while (rs.next()) {
                Center center = new Center(rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("location"),
                        rs.getBoolean("work")
                );
   // add to answer line that we took and stop after all data taken
                centers.add(center);
            }

            return centers;
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
    public boolean startCenter(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT name FROM director WHERE id=?";
            PreparedStatement st1 = con.prepareStatement(sql);
            st1.setInt(1, id);
            String sql1 = "SELECT name FROM mentor WHERE id=?";
            PreparedStatement st2 = con.prepareStatement(sql1);
            st2.setInt(1, id);
            String sql2 = "SELECT name FROM teacher WHERE id=?";
            PreparedStatement st3 = con.prepareStatement(sql2);
            st3.setInt(1, id);

//same as before, but sql change to select
            ResultSet rs = st1.executeQuery();
            ResultSet rs2 = st2.executeQuery();
            ResultSet rs3 = st3.executeQuery();
            if (rs.next() & rs2.next() & rs3.next()) {
                String sql4 = "INSERT INTO center(work) VALUES (?)";
                PreparedStatement st4 = con.prepareStatement(sql4); //put sql line through our connection(con)
                st4.setString(1, "1");
            };// I have a work a type that shows that center work or not, so if we have at least one of each worker it starts working

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
            }//mistakes in enterings
        }
        return false;
    }
}
