package com.db.corporate.bank.trading.service.v1.exception;

import com.db.corporate.bank.trading.service.v1.model.Error;

public class BadRequestException extends Exception {

    private static final long serialVerionUID = BadRequestException.class.getName().hashCode();
    private final Error error;

    public BadRequestException(Error error) {
        this.error = error;
    }

    public BadRequestException(Error error, Throwable cause) {
        super(cause);
        this.error = error;
    }

    public Error getError() {
        return error;
    }
}
