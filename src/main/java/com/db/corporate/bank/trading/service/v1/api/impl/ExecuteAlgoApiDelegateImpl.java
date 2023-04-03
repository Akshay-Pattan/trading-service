package com.db.corporate.bank.trading.service.v1.api.impl;

import com.db.corporate.bank.trading.service.v1.api.ExecuteAlgoApiDelegate;
import com.db.corporate.bank.trading.service.v1.model.SignalRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service(value = "ExecuteAlgoApiDelegate")
public class ExecuteAlgoApiDelegateImpl implements ExecuteAlgoApiDelegate {

    public ResponseEntity<Void> executeAlgorithm(SignalRequest signalRequest) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
