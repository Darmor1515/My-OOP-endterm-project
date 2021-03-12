package com.assigment.entities;

public class Director {
    private int id;
    private String name;
    private String center;
    private int salary;

    public Director(){

    }
    public Director(String name, String center, int salary){//constructor for create
        setName(name);
        setCenter(center);
        setSalary(salary);
    }

    public Director(int id, String name, String center, int salary){// constructor to input
        setId(id);
        setName(name);
        setCenter(center);
        setSalary(salary);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public String getCenter() {
        return center;
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

    public void setCenter(String center) {
        this.center = center;
    }

    @Override
    public String toString(){
        return "Director=[ id= " +getId()+ ",name= "+getName()+",salary= "+getSalary()+",center= "+getCenter()+"]";

    }
}
