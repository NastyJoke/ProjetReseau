package com.company.errors.participate;

import com.company.errors.ServerError;

/**
 * Created by Renaud on 17/05/2016.
 */
public class ErrInvalidId extends ServerError {

    public ErrInvalidId()
    {
        this.msg = "PARTICIPATE ERR INVALID_ID";
    }

}
