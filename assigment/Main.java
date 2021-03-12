package com.assigment;
import com.assigment.controllers.CenterController;
import com.assigment.data.PostgresDB;
import com.assigment.data.interfaces.IDB;
import com.assigment.repo.*;
import com.assigment.repo.interfaces.*;

public class Main {

    public static void main(String[] args) {
        IDB db = new PostgresDB();//here one problems that stoped me, my misunderstanding did not allow to create multiple controllers
        ICenterRepo centerRepo = new CenterRepo(db);
        IDirectorRepo directorRepo = new DirectorRepo(db);
        IMentorRepo mentorRepo = new MentorRepo(db);
        IStudentRepo studentRepo = new StudentRepo(db);
        ITeacherRepo teacherRepo = new TeacherRepo(db);//all repothitories
        EducationCenterFrontEnd app = new EducationCenterFrontEnd(centerRepo,directorRepo,mentorRepo,studentRepo,teacherRepo);
        app.start();//start app
    }
}
