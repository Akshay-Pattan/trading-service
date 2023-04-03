package com.db.corporate.bank.trading.service.v1.exception;

import com.db.corporate.bank.trading.service.v1.model.Error;

public class ErrorHandler {

    private static final String INTERNAL_SERVER_ERROR = "Internal Server Error";
    private static final String MISSING_MANDATORY_ERROR = "Missing Mandatory Attribute";
    private static final String INTERNAL_SERVER_ERROR_CODE = "000100";
    private static final String MISSING_MANDATORY_ERROR_CODE = "000101";

    public static Error unhandledExceptionError() {
        return new Error().errorCode(INTERNAL_SERVER_ERROR_CODE).errorDescription(INTERNAL_SERVER_ERROR);
    }

    public static Error missingMandatoryAttribute(String attribute) {
        return new Error().errorCode(MISSING_MANDATORY_ERROR_CODE).errorDescription(MISSING_MANDATORY_ERROR).path(attribute);
    }
}
