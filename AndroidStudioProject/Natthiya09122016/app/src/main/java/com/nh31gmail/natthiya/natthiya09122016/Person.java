package com.nh31gmail.natthiya.natthiya09122016;

/**
 * Created by Natth on 12/9/2016.
 */
public class Person {
    private int id;
    private String name;



    public Person() {
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;


    }

    public int getId() {
        return id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
