package com.philipjhamilton.patterns.behavioral.memento.command;

public interface Command {
    String getName();
    void execute();
}