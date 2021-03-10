package com.example.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

// Scope value  => session      jedna instance pro každou session
//              => singleton    jedna instance pro všechny requesty
//              => request      pro každý request nová instance
//              => prototype    pro každé zavolání nová instance

@Service
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CounterServiceImpl implements CounterService {

    private int counter = 0;

    @Override
    public void add() {
        counter += 1;
    }

    @Override
    public int getCounter() {
        return counter;
    }
}
