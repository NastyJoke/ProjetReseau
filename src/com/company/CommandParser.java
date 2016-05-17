package com.company;

import com.company.data.DataBase;
import com.company.data.Idea;
import com.company.data.Student;
import com.company.enums.CommandEnum;
import com.company.errors.add.*;
import com.company.errors.ideas.ErrEmptyList;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        Pattern namePattern = Pattern.compile("^[a-zA-Z]+$");
        Pattern mailPattern = Pattern.compile("^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*\n" +
                "      @[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$;");

        Matcher nameMatcher;
        Matcher mailMatcher;

        String [] argTab = args.split("><");
        if (argTab.length < 4)
            return (new ErrMissingArg().toString());
        else if (argTab.length > 4)
            return (new ErrTooManyArgs().toString());

        for (int i = 0; i < 4; i++) {
            cleanChevrons(argTab);
        }

        nameMatcher = namePattern.matcher(argTab[0]);
        mailMatcher = mailPattern.matcher(argTab[1]);

        if (!nameMatcher.matches())
            return (new ErrEtudiant()).toString();
        if (!mailMatcher.matches())
            return (new ErrMail().toString());
        if (argTab[2].equals("") || argTab[3].equals(""))
            return (new ErrVoidArg().toString());


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
            return (new ErrEmptyList().toString());
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
