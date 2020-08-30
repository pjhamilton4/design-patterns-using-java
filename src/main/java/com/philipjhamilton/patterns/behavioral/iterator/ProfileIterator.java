package com.philipjhamilton.patterns.behavioral.iterator;

public interface ProfileIterator {
    Profile getNext();
    boolean hasNext();
    void reset();
}
