package com.philipjhamilton.patterns.creational.objectpool;

import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public abstract class ObjectPool<T> {
    private final BlockingQueue<T> objs;

    public ObjectPool(){
        this.objs = new ArrayBlockingQueue<T>(10, false);
    }

    public ObjectPool(Collection<? extends T> objs) {
        this.objs = new ArrayBlockingQueue<T>(objs.size(), false, objs);
    }

    public abstract T createObject();

    public T borrow() throws InterruptedException {
        return this.objs.poll(5000, TimeUnit.SECONDS);
    }

    public void giveBack(T object) throws InterruptedException {
        this.objs.put(object);
    }
}