package com.philipjhamilton.patterns.creational.abstractfactory.checkboxes;

public class WindowsCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("You have created a WindowsCheckbox");
    }
}
