package com.assigment.repo.interfaces;

import com.assigment.entities.Director;

import java.util.List;

public interface IDirectorRepo {
    boolean createDirector(Director director);
    Director getDirector(int id);
    List<Director> getAllDirectors();
}
