package com.company.errors.students;

import com.company.errors.ServerError;

/**
 * Created by Renaud on 17/05/2016.
 */
public class ErrEmptyList extends ServerError {

    public ErrEmptyList()
    {
        this.msg = "STUDENTS EMPTY_LIST";
    }

}
