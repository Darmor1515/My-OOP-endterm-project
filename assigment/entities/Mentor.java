package com.assigment.entities;

public class Mentor {
    private int id;
    private String name;
    private int salary;
    private String center;
    public Mentor(){

    }
    public Mentor(String name, int salary, String center){
        setName(name);
        setSalary(salary);
        setCenter(center);
    }

    public Mentor(int id, String name, int salary, String center){
        setId(id);
        setName(name);
        setSalary(salary);
        setCenter(center);
    }
    public int getId() {
        return id;
    }

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    @Override
    public String toString(){
        return "Mentor=[ id= " +getId()+ ",name= "+getName()+",cost= "+getSalary()+",center= "+getCenter()+"]";

    }
}
