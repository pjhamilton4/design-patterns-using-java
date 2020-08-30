package com.philipjhamilton.patterns.creational.abstractfactory.factories;

import com.philipjhamilton.patterns.creational.abstractfactory.buttons.Button;
import com.philipjhamilton.patterns.creational.abstractfactory.buttons.MacOSButton;
import com.philipjhamilton.patterns.creational.abstractfactory.checkboxes.Checkbox;
import com.philipjhamilton.patterns.creational.abstractfactory.checkboxes.MacOSCheckbox;

public class MacOSFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}
