package com.company.errors.add;

import com.company.errors.ServerError;

/**
 * Created by Renaud on 17/05/2016.
 */
public class ErrMissingArg extends ServerError {

    public ErrMissingArg()
    {
        this.msg = "ADD ERR MISSING_ARG";
    }

}
