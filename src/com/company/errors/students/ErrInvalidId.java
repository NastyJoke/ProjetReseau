package com.company.errors.students;

import com.company.errors.ServerError;

/**
 * Created by Renaud on 17/05/2016.
 */
public class ErrInvalidId extends ServerError {

    public ErrInvalidId()
    {
        this.msg = "STUDENTS ERR INVALID_ID";
    }

}
