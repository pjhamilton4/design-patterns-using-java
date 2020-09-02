package com.philipjhamilton.patterns.behavioral.mediator.components;

import com.philipjhamilton.patterns.behavioral.mediator.Mediator;

public interface Component {
    void setMediator(Mediator mediator);
    String getName();
}
