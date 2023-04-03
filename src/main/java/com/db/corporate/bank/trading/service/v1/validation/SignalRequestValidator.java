package com.db.corporate.bank.trading.service.v1.validation;

import com.db.corporate.bank.trading.service.v1.exception.BadRequestException;
import com.db.corporate.bank.trading.service.v1.exception.ErrorHandler;
import com.db.corporate.bank.trading.service.v1.model.SignalRequest;

public final class SignalRequestValidator {

    private static final String SIGNAL_ATTRIBUTE = "signal";

    private SignalRequestValidator() {
        //nothing to initialize
    }

    public static void validateSignalRequest(SignalRequest signalRequest) throws BadRequestException {
        if (null == signalRequest) {
            throw new BadRequestException(ErrorHandler.missingMandatoryAttribute(SIGNAL_ATTRIBUTE));
        } else if (null == signalRequest.getSignal()) {
            throw new BadRequestException(ErrorHandler.missingMandatoryAttribute(SIGNAL_ATTRIBUTE));
        }
    }
}
