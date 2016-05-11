package com.company;

import com.company.data.DataBase;
import com.company.data.Idea;
import com.company.data.Student;
import com.company.enums.CommandEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Renaud on 10/05/2016.
 */
public class CommandParser {
    private String cmd;
    private CommandEnum action;
    private String args;
    private DataBase db;

    public CommandParser(DataBase db, String command)
    {
        cmd = command;
        action = parseAction();
        args = parseArguments();
        this.db = db;
    }

    private CommandEnum parseAction()
    {
        CommandEnum ret;
        try {
            ret = CommandEnum.valueOf(cmd.split(" ")[0]);
        } catch (IllegalArgumentException e){
            ret = CommandEnum.QUIT;
        }
        return ret;
    }

    public String parseArguments() {
        int firstSpace = cmd.indexOf(' ');
        return cmd.substring(firstSpace+1);
    }

    public String act()
    {
        String result = "Nothing to show here";
        switch(parseAction())
        {
            case ADD:
                result = handleAdd();
                break;
            case IDEAS:
                result = handleIdeas();
                break;
            case PARTICIPATE:
                result = handleParticipate();
                break;
            case STUDENTS:
                result = handleStudents();
                break;
            case GREET:
                result = "Hi there, welcome!";
                break;
            case QUIT:
                result = "Bye!";
                break;
            default:
                result = "Do you need Help? Available Commands are: (tbd)";
                break;
        }
        return result;
    }

    private void cleanChevrons(String [] args)
    {
        for (int i = 0; i < args.length; i++)
        {
            if (args[i].charAt(0) == '<')
            {
                args[i] = args[i].substring(1);
            }
            if (args[i].charAt(args[i].length()-1) == '>')
            {
                args[i] = args[i].substring(0,args[i].length()-1);
            }
        }
    }

    public String handleAdd()
    {
        String [] argTab = args.split("><");
        for (int i = 0; i < 4; i++) {
            cleanChevrons(argTab);
        }
        Student s = new Student(argTab[1],argTab[0]);
        Idea i = new Idea(db,argTab[0],argTab[1],argTab[2],argTab[3]);
        db.addIdea(i);
        db.addParticipation(i.getId(),s);
        return "Added Student's "+argTab[0]+ " idea to the database";
    }

    public String handleIdeas()
    {
        List<Idea> ideas = db.getIdeas();
        // Reponse du serveur
        String list = "";
        String ls = System.lineSeparator();
        for(Idea id : ideas){
            list+="ID: "+id.getId()+" Author:"+id.getAuthorName()+" EMAIL:"+id.getAuthorMail()+ls+"\t"+id.getDescription()+ls+id.getTech()+ls+ls;
        }
        if(list == "")
            return "aucune idée n'a encore été soumise."+ls;
        return list;

    }

    public String  handleParticipate()
    {
        String [] argTab = args.split("><");
        for (int i = 0; i < 3; i++) {
            cleanChevrons(argTab);
        }
        //TODO
        return "Participate OK";
    }

    public String  handleStudents()
    {
        return "Students are a list! (TBD)";
    }


}
