package com.nh31gmail.natthiya.hw;

/**
 * Created by Natth on 11/24/2016.
 */
public class Person {
    private int id;
    private String name,email;

    public Person() {

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Person(int id, String name, String email) {

        this.id = id;
        this.name = name;
        this.email = email;
    }



}
