package com.company.data;

/**
 * Created by Renaud on 10/05/2016.
 */
public class Idea {

    private int id;
    private String description;
    private String tech;
    private String authorMail;
    private String authorName;

    public Idea(DataBase db, String authorName, String authorMail, String description, String tech)
    {
        this.id = db.getIdeas().size();
        this.authorMail = authorMail;
        this.authorName = authorName;
        this.description = description;
        this.tech = tech;
    }

    public int getId()
    {
        return id;
    }

    public boolean equals(Idea i)
    {
        return (i.getId() == id);
    }

    @Override
    public String toString()
    {
        return id+"";
    }


}
