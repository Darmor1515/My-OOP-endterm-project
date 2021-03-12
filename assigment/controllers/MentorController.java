package com.assigment.controllers;

import com.assigment.entities.Mentor;
import com.assigment.repo.interfaces.IMentorRepo;

import java.util.List;

public class MentorController {
    private final IMentorRepo repo;
    //All the same as in center Controller, look their
    public MentorController(IMentorRepo repo) {
        this.repo = repo;
    }
    //All the same as in center Controller, look their
    public String createMentor( String name, Integer salary, String center) {
        Mentor mentor = new Mentor(name, salary,center);
//All the same as in center Controller, look their
        boolean created = repo.createMentor(mentor);

        return (created ? "Mentor was created!" : "Mentor creation was failed!");
    }

    public String getMentor(int id) {
        Mentor mentor = repo.getMentor(id);

        return (mentor == null ? "Mentor was not found!" : mentor.toString());
    }

    public String getAllMentors() {
        List<Mentor> mentors = repo.getAllMentors();

        return mentors.toString();
    }
}
