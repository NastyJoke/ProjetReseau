package com.company.data;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Renaud on 10/05/2016.
 */
public class DataBaseTest {

    @Test
    public void testGetParticipationsById()
    {
        DataBase db = new DataBase();
        Student s1 = new Student("mail1","name1");
        Student s2 = new Student("mail2","name2");

        Idea i1 = new Idea(db,"desc","tech1","mail1","name1");
        db.addIdea(i1);
        Idea i2 = new Idea(db,"desc","tech2","mail2","name2");
        db.addIdea(i2);

        db.addParticipation(0,s1);
        db.addParticipation(1,s2);
        db.addParticipation(1,s1);


        System.out.println(db.getParticipationsById(1));
        System.out.println(db.getParticipationsById(0));

    }

}