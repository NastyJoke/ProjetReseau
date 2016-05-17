package com.company;

import com.company.data.DataBase;
        import org.junit.Test;

        import static org.junit.Assert.*;

/**
 * Created by Renaud on 10/05/2016.
 */
public class CommandParserTest {
    @Test
    public void testHandleAdd() throws Exception {
        DataBase db = new DataBase();
        CommandParser c = new CommandParser(db, "ADD <a><b><c><d>");
        c.act();

        System.out.println(db.getIdeas());
    }

}