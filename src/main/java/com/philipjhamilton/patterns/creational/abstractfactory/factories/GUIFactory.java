package com.philipjhamilton.patterns.creational.abstractfactory.factories;

import com.philipjhamilton.patterns.creational.abstractfactory.buttons.Button;
import com.philipjhamilton.patterns.creational.abstractfactory.checkboxes.Checkbox;

public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
