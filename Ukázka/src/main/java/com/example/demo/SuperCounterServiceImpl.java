package com.example.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

// Scope value  => session      jedna instance pro každou session
//              => singleton    jedna instance pro všechny requesty
//              => request      pro každý request nová instance
//              => prototype    pro každé zavolání nová instance

@Service
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SuperCounterServiceImpl implements CounterService {

    private int counter = 1;

    @Override
    public void add() {
        counter *= 2;
    }

    @Override
    public int getCounter() {
        return counter;
    }
}
