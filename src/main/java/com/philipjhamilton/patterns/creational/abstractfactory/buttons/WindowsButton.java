package com.philipjhamilton.patterns.creational.abstractfactory.buttons;

public class WindowsButton implements Button{
    @Override
    public void paint() {
        System.out.println("You have created a windowsButton.");
    }
}
