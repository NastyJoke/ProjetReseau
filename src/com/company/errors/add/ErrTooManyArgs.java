package com.company.errors.add;

import com.company.errors.ServerError;

/**
 * Created by Renaud on 17/05/2016.
 */
public class ErrTooManyArgs extends ServerError {

    public ErrTooManyArgs()
    {
        this.msg = "ADD ERR TOO_MANY_ARGS";
    }

}
