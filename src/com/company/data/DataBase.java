package com.company.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Renaud on 10/05/2016.
 */
public class DataBase {

    private List<Idea> ideas;
    private Map<Integer,List<Student>> participations;

    public DataBase()
    {
        ideas = new ArrayList<>();
        participations = new HashMap<>();
    }

    public void addIdea(Idea i)
    {
        ideas.add(i);
        participations.put(i.getId(),new ArrayList<>());
    }

    public void addParticipation(int i, Student s)
    {
        participations.get(i).add(s);
    }

    public List<Idea> getIdeas()
    {
        return ideas;
    }

    public Map<Integer, List<Student>> getParticipations()
    {
        return participations;
    }

    public List<Student> getParticipationsById(int id)
    {
        Map<Integer, Student> out = new HashMap<>();
        for (Map.Entry e : participations.entrySet())
        {
            if ((Integer)e.getKey() == id) // si l'id correspond
            {
                return (List)e.getValue();
            }
        }
        //ERR EMPTY LIST
        return null;
    }


}
