package com.assigment.controllers;

import com.assigment.entities.Center;
import com.assigment.repo.interfaces.ICenterRepo;

import java.util.List;

public class CenterController {
    private final ICenterRepo repo;

    public CenterController(ICenterRepo repo) {
        this.repo = repo;
    }//Constructor for use in main so through I..Repo we go to controller(i did not found my mistake here
    //sp had to spend some time to understand that we do not go through just Repo to controller

    public String createCenter( String title, String location) {
        Center center = new Center(title , location);

        boolean created = repo.createCenter(center);//go through back through this controller to repo of center and their we take method create center

        return (created ? "Center was created!" : "Center creation was failed!");//if: created: not
    }

    public String getCenter(int id) {
        Center center = repo.getCenter(id);
//go through back through this controller to repo of center and their we take method find center
        return (center == null ? "Center was not found!" : center.toString());
    }
    public String startCenter(int id) {
        Boolean center = repo.startCenter(id);
//go through back through this controller to repo of center and their we take method find center
        return (center == false ? "Center do not have enough worker!" : "Center opened, you are welcome!");
        //center opened and now students can study their
    }

    public String getAllCenters() {
        List<Center> centers = repo.getAllCenters();
//go through back through this controller to repo of center and their we take method tak all centers
        return centers.toString();
    }
}
