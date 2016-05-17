package com.company.errors.participate;

import com.company.errors.ServerError;

/**
 * Created by Renaud on 17/05/2016.
 */
public class ErrDuplicate extends ServerError {

    public ErrDuplicate()
    {
        this.msg = "PARTICIPATE ERR DUPLICATE";
    }

}
