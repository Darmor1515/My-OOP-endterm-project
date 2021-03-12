package com.assigment.controllers;

import com.assigment.entities.Director;
import com.assigment.repo.interfaces.IDirectorRepo;

import java.util.List;

public class DirectorController {
    private final IDirectorRepo repo;
//All the same as in center Controller, look their
    public DirectorController(IDirectorRepo repo) {
        this.repo = repo;
    }

    public String createDirector( String name,String center, Integer salary) {
        Director director = new Director(name,center, salary);
//All the same as in center Controller, look their
        boolean created = repo.createDirector(director);

        return (created ? "Director was created!" : "Director creation was failed!");
    }
    //All the same as in center Controller, look their
    public String getDirector(int id) {
        Director director = repo.getDirector(id);

        return (director == null ? "Director was not found!" : director.toString());
    }

    public String getAllDirectors() {
        List<Director> directors = repo.getAllDirectors();

        return directors.toString();
    }
}
