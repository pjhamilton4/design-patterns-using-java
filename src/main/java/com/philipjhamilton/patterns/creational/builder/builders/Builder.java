package com.philipjhamilton.patterns.creational.builder.builders;

import com.philipjhamilton.patterns.creational.builder.cars.Type;
import com.philipjhamilton.patterns.creational.builder.components.Engine;
import com.philipjhamilton.patterns.creational.builder.components.GPSNavigator;
import com.philipjhamilton.patterns.creational.builder.components.Transmission;
import com.philipjhamilton.patterns.creational.builder.components.TripComputer;

public interface Builder {
    void setType(Type type);
    void setSeats(int seats);
    void setTransmission(Transmission transmission);
    void setTripComputer(TripComputer tripComputer);
    void setGPSNavigator(GPSNavigator gpsNavigator);
    void setEngine(Engine engine);
}
