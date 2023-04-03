package com.db.corporate.bank.trading.service.v1.api.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class HealthApiDelegateImplTest {

    @Test
    public void testGetHealth() {
        ResponseEntity responseEntity = new HealthApiDelegateImpl().getHealth();
        Assertions.assertNotNull(responseEntity);
        Assertions.assertNotNull(responseEntity.getBody());
        Assertions.assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
    }
}
