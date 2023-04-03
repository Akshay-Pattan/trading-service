package com.db.corporate.bank.trading.service.v1.delegate.impl;

import com.db.corporate.bank.trading.service.v1.delegate.SignalHandler;
import com.db.corporate.bank.trading.service.v1.service.Algo;
import com.db.corporate.bank.trading.service.v1.util.SignalSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "SignalHandler")
public class SignalHandlerImpl implements SignalHandler {

    @Autowired
    Algo algo;

    @Override
    public void handleSignal(int signal) {
        List<Integer> mappedSignals = SignalSingleton.getInstance().getMappedSignals();
        if (mappedSignals.contains(signal)) {
            algo.setUp();
            algo.setAlgoParam(1,60);
            algo.performCalc();
            algo.submitToMarket();
        } else {
            algo.cancelTrades();
        }
        algo.doAlgo();
    }
}
