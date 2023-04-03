package com.db.corporate.bank.trading.service.v1.api.impl;

import com.db.corporate.bank.trading.service.v1.api.ExecuteAlgoApiDelegate;
import com.db.corporate.bank.trading.service.v1.delegate.SignalHandler;
import com.db.corporate.bank.trading.service.v1.exception.BadRequestException;
import com.db.corporate.bank.trading.service.v1.exception.ErrorHandler;
import com.db.corporate.bank.trading.service.v1.model.SignalRequest;
import com.db.corporate.bank.trading.service.v1.validation.SignalRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service(value = "ExecuteAlgoApiDelegate")
public class ExecuteAlgoApiDelegateImpl implements ExecuteAlgoApiDelegate {

    @Autowired
    SignalHandler signalHandler;

    public ResponseEntity executeAlgorithm(SignalRequest signalRequest) {
        try {
            SignalRequestValidator.validateSignalRequest(signalRequest);
            signalHandler.handleSignal(signalRequest.getSignal().intValue());
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (BadRequestException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getError());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorHandler.unhandledExceptionError());
        }
    }
}
