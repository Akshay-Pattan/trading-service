package com.db.corporate.bank.trading.service.v1.validation;

import com.db.corporate.bank.trading.service.v1.exception.BadRequestException;
import com.db.corporate.bank.trading.service.v1.exception.ErrorHandler;
import com.db.corporate.bank.trading.service.v1.model.SignalRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SignalRequestValidatorTest {

    @Test
    public void testSuccessfulValidation() {
        Assertions.assertDoesNotThrow(() -> SignalRequestValidator.validateSignalRequest(new SignalRequest().signal(1)));
    }
    @Test
    public void testForMissingSignalRequest() {
        Assertions.assertThrows(BadRequestException.class, () -> SignalRequestValidator.validateSignalRequest(null));
    }

    @Test
    public void testValidationErrorForMissingSignalRequest() {
        try{
            SignalRequestValidator.validateSignalRequest(null);
        } catch (BadRequestException e) {
            Assertions.assertNotNull(e);
            Assertions.assertNotNull(e.getError());
            Assertions.assertEquals(ErrorHandler.MISSING_MANDATORY_ERROR_CODE, e.getError().getErrorCode());
            Assertions.assertEquals(ErrorHandler.MISSING_MANDATORY_ERROR, e.getError().getErrorDescription());
        }
    }

    @Test
    public void testValidationErrorForMissingSignalAttribute() {
        try{
            SignalRequestValidator.validateSignalRequest(new SignalRequest().signal(null));
        } catch (BadRequestException e) {
            Assertions.assertNotNull(e);
            Assertions.assertNotNull(e.getError());
            Assertions.assertEquals(ErrorHandler.MISSING_MANDATORY_ERROR_CODE, e.getError().getErrorCode());
            Assertions.assertEquals(ErrorHandler.MISSING_MANDATORY_ERROR, e.getError().getErrorDescription());
        }
    }
}
