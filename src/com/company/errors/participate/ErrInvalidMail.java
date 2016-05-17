package com.company.errors.participate;

import com.company.errors.ServerError;

/**
 * Created by Renaud on 17/05/2016.
 */
public class ErrInvalidMail extends ServerError {

    public ErrInvalidMail()
    {
        this.msg = "PARTICIPATE ERR INVALID_MAIL";
    }

}
