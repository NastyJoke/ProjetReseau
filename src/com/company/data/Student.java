package com.company.data;

/**
 * Created by Renaud on 10/05/2016.
 */
public class Student {

    private String mail;
    private String name;

    public Student(String mail, String name)
    {
        this.mail = mail;
        this.name = name;
    }

    @Override
    public String toString()
    {
        return name + " <" + mail + ">";
    }

}
