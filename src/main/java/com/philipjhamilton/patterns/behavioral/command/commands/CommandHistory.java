package com.philipjhamilton.patterns.behavioral.command.commands;

import java.util.Stack;

public class CommandHistory {
    private Stack<Command> history = new Stack<Command>();

    public void push(Command c) {
        history.push(c);
    }

    public Command pop() {
        return history.pop();
    }

    public boolean isEmpty() { return history.isEmpty(); }
}