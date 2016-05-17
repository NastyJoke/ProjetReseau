package com.company.errors.ideas;

import com.company.errors.ServerError;

/**
 * Created by Renaud on 17/05/2016.
 */
public class ErrEmptyList extends ServerError {

    public ErrEmptyList()
    {
        this.msg = "IDEAS EMPTY_LIST";
    }

}
