package com.db.corporate.bank.trading.service.v1.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class SignalSingleton {

    private static SignalSingleton signalSingleton;
    private List<Integer> mappedSignals = new ArrayList<>();

    private SignalSingleton() {
        //nothing to initialize
    }

    public synchronized static SignalSingleton getInstance(){
        if ( null == signalSingleton) {
            signalSingleton = new SignalSingleton();
        }
        return signalSingleton;
    }

    public List<Integer> getMappedSignals() {
        return mappedSignals;
    }

    public void setMappedSignals(List<String> mappedSignals) {
        this.mappedSignals = mappedSignals.stream().map(Integer::parseInt).collect(Collectors.toList());
    }
}
