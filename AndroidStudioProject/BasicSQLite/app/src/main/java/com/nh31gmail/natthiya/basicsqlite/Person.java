package com.nh31gmail.natthiya.basicsqlite;

/**
 * Created by Natth on 11/3/2016.
 */
public class Person {


    private String name;

    public Person(String name) {
        this.name = name;
    }


    public Person(int id, String name, String email) {

        this.name = name;

    }
    public Person()
    {

    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
