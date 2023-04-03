package com.db.corporate.bank.trading.service.v1.exception;

import com.db.corporate.bank.trading.service.v1.model.Error;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ErrorHandlerTest {

    private static final String SIGNAL = "signal";

    @Test
    public void testUnhandledExceptionError() {
        Error error = ErrorHandler.unhandledExceptionError();
        Assertions.assertNotNull(error);
        Assertions.assertEquals(ErrorHandler.INTERNAL_SERVER_ERROR_CODE, error.getErrorCode());
        Assertions.assertEquals(ErrorHandler.INTERNAL_SERVER_ERROR, error.getErrorDescription());
        Assertions.assertNull(error.getPath());
    }

    @Test
    public void testMissingMandatoryAttribute() {
        Error error = ErrorHandler.missingMandatoryAttribute(SIGNAL);
        Assertions.assertNotNull(error);
        Assertions.assertEquals(ErrorHandler.MISSING_MANDATORY_ERROR_CODE, error.getErrorCode());
        Assertions.assertEquals(ErrorHandler.MISSING_MANDATORY_ERROR, error.getErrorDescription());
        Assertions.assertEquals(SIGNAL, error.getPath());
    }
}
