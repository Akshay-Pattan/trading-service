package com.db.corporate.bank.trading.service.v1.api.impl;

import com.db.corporate.bank.trading.service.v1.exception.BadRequestException;
import com.db.corporate.bank.trading.service.v1.model.SignalRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ExecuteAlgoApiDelegateImplTest {

    @Test
    public void testExecuteAlgorithm() {
        Assertions.assertDoesNotThrow(() -> new ExecuteAlgoApiDelegateImpl().executeAlgorithm(new SignalRequest().signal(1)));
    }

    @Test
    public void testExecuteAlgorithmForBadRequestError() {
        ResponseEntity responseEntity = new ExecuteAlgoApiDelegateImpl().executeAlgorithm(null);
        Assertions.assertNotNull(responseEntity);
        Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), responseEntity.getStatusCodeValue());
        Assertions.assertNotNull(responseEntity.getBody());
    }

}
