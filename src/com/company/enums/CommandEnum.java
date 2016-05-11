package com.company.enums;

/**
 * Created by Renaud on 10/05/2016.
 */
public enum CommandEnum {

    ADD("add"),IDEAS("ideas"),PARTICIPATE("participate"),STUDENTS("students"), GREET("greet!"), QUIT("quit");

    String cmd;

    CommandEnum(String cmd)
    {
        this.cmd = cmd;
    }


}
