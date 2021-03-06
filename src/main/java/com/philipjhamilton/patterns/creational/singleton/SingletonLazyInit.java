package com.philipjhamilton.patterns.creational.singleton;

import java.io.Serializable;
import java.util.HashMap;

public class SingletonLazyInit implements Serializable {

    private static volatile SingletonLazyInit instance = null;
    private static HashMap<String, String> data = new HashMap<String, String>();

    private SingletonLazyInit(){
        if (instance != null){
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public static SingletonLazyInit getInstance(){
        if (instance == null){ //if there is no instance available... create new one
            synchronized(SingletonLazyInit.class){
                if (instance == null) instance = new SingletonLazyInit();
            }
        }

        return instance;
    }

    // TODO - Implement some functionality to pull data or do tasks

    protected SingletonLazyInit readResolve() {
        return getInstance();
    }
}
