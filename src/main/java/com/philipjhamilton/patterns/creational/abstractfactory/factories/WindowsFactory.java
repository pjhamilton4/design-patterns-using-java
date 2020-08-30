package com.philipjhamilton.patterns.creational.abstractfactory.factories;

import com.philipjhamilton.patterns.creational.abstractfactory.buttons.Button;
import com.philipjhamilton.patterns.creational.abstractfactory.buttons.WindowsButton;
import com.philipjhamilton.patterns.creational.abstractfactory.checkboxes.Checkbox;
import com.philipjhamilton.patterns.creational.abstractfactory.checkboxes.WindowsCheckbox;

public class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
