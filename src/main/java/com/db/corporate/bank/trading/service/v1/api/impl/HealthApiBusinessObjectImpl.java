package com.db.corporate.bank.trading.service.v1.api.impl;

import com.db.corporate.bank.trading.service.v1.api.HealthApi;
import com.db.corporate.bank.trading.service.v1.model.Health;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class HealthApiBusinessObjectImpl implements HealthApi {
    @Override
    public ResponseEntity<Health> healthGet() {
        return ResponseEntity.status(HttpStatus.OK).body(new Health().status(Health.StatusEnum.UP));
    }
}
