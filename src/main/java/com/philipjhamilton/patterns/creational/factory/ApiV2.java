package com.philipjhamilton.patterns.creational.factory;

public class ApiV2 implements API{
    @Override
    public void doSomething() {
        System.out.println("doing something v2!");
    }

    @Override
    public void doOneMoreThing() {
        System.out.println("doing one more thing v2!");
    }
}
