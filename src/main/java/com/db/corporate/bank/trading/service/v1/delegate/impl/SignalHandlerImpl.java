package com.db.corporate.bank.trading.service.v1.delegate.impl;

import com.db.corporate.bank.trading.service.v1.delegate.SignalHandler;
import com.db.corporate.bank.trading.service.v1.service.Algo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "SignalHandler")
public class SignalHandlerImpl implements SignalHandler {

    @Autowired
    Algo algo;

    @Override
    public void handleSignal(int signal) {
        switch (signal) {
            case 1:
                algo.setUp();
                algo.setAlgoParam(1, 60);
                algo.performCalc();
                algo.submitToMarket();
                break;
            case 2:
                algo.reverse();
                algo.setAlgoParam(1, 80);
                algo.submitToMarket();
                break;
            case 3:
                algo.setAlgoParam(1, 90);
                algo.setAlgoParam(2, 15);
                algo.performCalc();
                algo.submitToMarket();
                break;
            default:
                algo.cancelTrades();
                break;
        }
        algo.doAlgo();
    }
}
