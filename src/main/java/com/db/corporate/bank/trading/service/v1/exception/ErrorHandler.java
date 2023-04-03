package com.db.corporate.bank.trading.service.v1.exception;

import com.db.corporate.bank.trading.service.v1.model.Error;

public class ErrorHandler {

    private static final String INTERNAL_SERVER_ERROR = "Internal Server Error";
    private static final String INTERNAL_SERVER_ERROR_CODE = "000100";

    public static Error unhandledExceptionError() {
        return new Error().errorCode(INTERNAL_SERVER_ERROR_CODE).errorDescription(INTERNAL_SERVER_ERROR);
    }
}
