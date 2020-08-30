package com.philipjhamilton.patterns.creational.abstractfactory;

import com.philipjhamilton.patterns.creational.abstractfactory.buttons.Button;
import com.philipjhamilton.patterns.creational.abstractfactory.checkboxes.Checkbox;
import com.philipjhamilton.patterns.creational.abstractfactory.factories.GUIFactory;

public class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory factory){
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void paint(){
        button.paint();
        checkbox.paint();
    }
}
