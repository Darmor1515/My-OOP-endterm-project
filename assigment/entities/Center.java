package com.assigment.entities;

public class Center {
    private int id;
    private String title;
    private String location;
    private Boolean work;//parametrs that table have and we must have the same here, our inversly we create table the same as this one
    public Center(){
    }
    public Center(String title, String location){ //constructor for creating Center, this constructor change from others(other enteties
        setTitle(title);
        setLocation(location);
    }

    public Center(int id,String title, String location, Boolean work){//Take data
        setId(id);
        setTitle(title);
        setLocation(location);
        setWork(work);
    }

//getters and setters to use

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public Boolean getWork() {
        return work;
    }

    public void setWork(Boolean work) {
        this.work = work;
    }
//to output data to console from tostring method
    @Override
    public String toString(){
        return "Center=[ id= " +getId()+ ",title= "+getTitle()+",location= "+getLocation()+",work= "+getWork()+"]";

    }
}
