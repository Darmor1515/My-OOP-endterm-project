package com.assigment.repo.interfaces;

import com.assigment.entities.Center;

import java.util.List;

public interface ICenterRepo {
    //here methods that we use to take data from db, they can be called main, starting point
    boolean createCenter(Center center);
    Center getCenter(int id);
    List<Center> getAllCenters();
}
