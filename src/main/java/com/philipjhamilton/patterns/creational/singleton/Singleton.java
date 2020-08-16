package com.philipjhamilton.patterns.creational.singleton;

import java.io.Serializable;
import java.util.HashMap;

public class Singleton implements Serializable {

    private static volatile Singleton instance = null;
    private static HashMap<String, String> data = new HashMap<String, String>();

    private Singleton(){
        if (instance != null){
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public static Singleton getInstance(){
        if (instance == null){ //if there is no instance available... create new one
            synchronized(Singleton.class){
                if (instance == null) instance = new Singleton();
            }
        }

        return instance;
    }

    // TODO - Implement some functionality to pull data or do tasks

    protected Singleton readResolve() {
        return getInstance();
    }
}
