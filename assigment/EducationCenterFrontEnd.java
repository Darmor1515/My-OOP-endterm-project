package com.assigment;

import com.assigment.controllers.*;
import com.assigment.repo.*;
import com.assigment.repo.interfaces.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EducationCenterFrontEnd {//all controllers that we took from main here
    private final CenterController controller;
    private final DirectorController controller2;
    private final MentorController controller3;
    private final StudentController controller4;
    private final TeacherController controller5;
    private final Scanner scanner; //just scanner

//constructor to take all repo
    public EducationCenterFrontEnd(ICenterRepo centerRepo, IDirectorRepo directorRepo, IMentorRepo mentorRepo, IStudentRepo studentRepo, ITeacherRepo teacherRepo) {
        controller= new CenterController(centerRepo);//access to controllers
        controller2= new DirectorController(directorRepo);
        controller3= new MentorController(mentorRepo);
        controller4= new StudentController(studentRepo);
        controller5= new TeacherController(teacherRepo);
        scanner = new Scanner(System.in);
    }

    public void start() throws InputMismatchException {
        while (true) {//here circle to ability to come back to menu again and again
            System.out.println();///just front end
            System.out.println("Welcome to My EducationCenter");
            System.out.println("Select option:");
            System.out.println("1. Center Menu");
            System.out.println("2. Director Menu");
            System.out.println("3. Mentor Menu");
            System.out.println("4. Student Menu");
            System.out.println("5. Teacher Menu");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-5): ");
                int option = scanner.nextInt();
                if (option == 1) { //easy if
                    getCenterMenu(); // go to chosen menu
                } else if (option == 2) {
                    getDirectorMenu();
                } else if (option == 3) {
                    getMentorMenu();
                } else if (option == 4) {
                    getStudentMenu();
                } else if (option == 5) {
                    getTeacherMenu();
                 } else {
                    break;//stop circle and all programm
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("*************************");

        }//our mistakes, exepions that i did not understand well(only one of things that i can not explain
    }
    public void  getCenterMenu() {//start menu
        System.out.println("1. Get Center by id");
        System.out.println("2. Create Center");
        System.out.println("3. Get all Centers");
        System.out.println("0. Back to Menu");
        System.out.println();//front end again
        while (true) {//same trick here
            try {

                System.out.print("Enter option (1-3): ");
                int option = scanner.nextInt();
                if (option == 1) {//take data that we need to get Center
                    System.out.print("Enter Id ");
                    System.out.println(); //way to make better programm, by changing front end
                    int id = scanner.nextInt();
                    String response = controller.getCenter(id);
                    System.out.println(response);
                } else if (option == 2) {//other option, to create
                    System.out.print("Enter Title ");
                    System.out.println();
                    String title = scanner.nextLine();
                    System.out.print("Enter Location ");
                    System.out.println();
                    String location = scanner.nextLine();
                    String response = controller.createCenter(title, location);
                    System.out.println(response);
                } else if (option == 3) {// get all, we do not need any data, so it short
                    String response = controller.getAllCenters();
                    System.out.println(response);
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public void  getDirectorMenu() {//all same and same
        System.out.println("1. Get Director by id");
        System.out.println("2. Create Director");
        System.out.println("3. Get all Directors");
        System.out.println("0. Back to Menu");
        System.out.println();
        while (true) {
            try {

                System.out.print("Enter option (1-3): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    System.out.print("Enter Id ");
                    int id = scanner.nextInt();
                    String response = controller2.getDirector(id);
                    System.out.println(response);
                } else if (option == 2) {
                    System.out.print("Enter Name ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Center");
                    String center = scanner.nextLine();
                    ////int i = Integer.parseInt(**string**);
                    System.out.print("Enter Salary");
                    int salary = scanner.nextInt();
                    String response = controller2.createDirector(name,center,salary);
                    System.out.println(response);
                } else if (option == 3) {
                    String response = controller2.getAllDirectors();
                    System.out.println(response);
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public void  getMentorMenu() {//all same and same
        System.out.println("1. Get Mentor by id");
        System.out.println("2. Create Mentor");
        System.out.println("3. Get all Mentors");
        System.out.println("0. Back to Menu");
        System.out.println();
        while (true) {
            try {

                System.out.print("Enter option (1-3): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    System.out.print("Enter Id ");
                    int id = scanner.nextInt();
                    String response = controller3.getMentor(id);
                    System.out.println(response);
                } else if (option == 2) {
                    System.out.print("Enter Name");
                    String name = scanner.nextLine();
                    System.out.print("Enter Salary");
                    String center = scanner.nextLine();
                    System.out.print("Enter Center");
                    int salary = scanner.nextInt();
                    String response = controller3.createMentor(name,salary,center);
                    System.out.println(response);
                } else if (option == 3) {
                    String response = controller3.getAllMentors();
                    System.out.println(response);
                } else {
                    break;

                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public void  getStudentMenu() {//all same and same
        System.out.println("1. Get Student by id");
        System.out.println("2. Create Student");
        System.out.println("3. Get all Students");
        System.out.println("0. Back to Menu");
        System.out.println();
        while (true) {
            try {

                System.out.print("Enter option (1-3): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    System.out.print("Enter Id ");
                    int id = scanner.nextInt();
                    String response = controller4.getStudent(id);
                    System.out.println(response);
                } else if (option == 2) {
                    System.out.print("Enter Name");
                    String name = scanner.nextLine();
                    System.out.print("Enter Salary");
                    String center = scanner.nextLine();
                    System.out.print("Enter Center");
                    int salary = scanner.nextInt();
                    String response = controller4.createStudent(name,salary,center);
                    System.out.println(response);
                } else if (option == 3) {
                    String response = controller4.getAllStudents();
                    System.out.println(response);
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public void  getTeacherMenu() {//all same and same
        System.out.println("1. Get Teacher by id");
        System.out.println("2. Create Teacher");
        System.out.println("3. Get all Teachers");
        System.out.println("0. Back to Menu");
        System.out.println();
        while (true) {
            try {
                System.out.print("Enter option (1-3): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    System.out.print("Enter Id ");
                    int id = scanner.nextInt();
                    String response = controller5.getTeacher(id);
                    System.out.println(response);
                } else if (option == 2) {
                    System.out.print("Enter Name");
                    String name = scanner.nextLine();
                    System.out.print("Enter Salary");
                    String center = scanner.nextLine();
                    System.out.print("Enter Center");
                    int salary = scanner.nextInt();
                    String response = controller5.createTeacher(name,salary,center);
                    System.out.println(response);
                } else if (option == 3) {
                    String response = controller5.getAllTeachers();
                    System.out.println(response);
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
