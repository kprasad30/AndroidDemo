package com.prasad.androiddemo.ListViewDemo;

/**
 * Created by Prasad on 11/04/15.
 */
public class Addressbook {

    private String Name;
    private String Surname;
    private int age;


    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getName() {
        return Name;
    }

    public int getAge() {
        return age;
    }

    public String getSurname() {
        return Surname;
    }
}
