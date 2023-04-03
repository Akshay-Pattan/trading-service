package com.db.corporate.bank.trading.service.v1.api.impl;



import com.db.corporate.bank.trading.service.v1.api.HealthApiDelegate;
import com.db.corporate.bank.trading.service.v1.model.Health;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service(value = "HealthApiDelegate")
public class HealthApiDelegateImpl implements HealthApiDelegate {

    public ResponseEntity<Health> getHealth() {
        return ResponseEntity.status(HttpStatus.OK).body(new Health().status(Health.StatusEnum.UP));
    }
}
