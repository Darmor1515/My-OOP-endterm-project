package com.assigment.repo.interfaces;


import com.assigment.entities.Mentor;

import java.util.List;

public interface IMentorRepo {
    boolean createMentor(Mentor mentor);
    Mentor getMentor(int id);
    List<Mentor> getAllMentors();
}
