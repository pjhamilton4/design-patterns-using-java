package com.philipjhamilton.patterns.creational.builder;

import com.philipjhamilton.patterns.creational.builder.builders.Builder;
import com.philipjhamilton.patterns.creational.builder.cars.Type;
import com.philipjhamilton.patterns.creational.builder.components.Engine;
import com.philipjhamilton.patterns.creational.builder.components.GPSNavigator;
import com.philipjhamilton.patterns.creational.builder.components.Transmission;
import com.philipjhamilton.patterns.creational.builder.components.TripComputer;

public class Director {

    public void constructSportsCar(Builder builder){
        builder.setType(Type.SPORTS_CAR);
        builder.setSeats(2);
        builder.setEngine(new Engine(4.0, 0));
        builder.setTransmission(Transmission.MANUAL);
        builder.setTripComputer(new TripComputer());
        builder.setGPSNavigator(new GPSNavigator());
    }

    public void constructCityCar(Builder builder){
        builder.setType(Type.SPORTS_CAR);
        builder.setSeats(2);
        builder.setEngine(new Engine(1.2, 0));
        builder.setTransmission(Transmission.AUTOMATIC);
        builder.setTripComputer(new TripComputer());
        builder.setGPSNavigator(new GPSNavigator());
    }

    public void constructSUV(Builder builder){
        builder.setType(Type.SUV);
        builder.setSeats(4);
        builder.setEngine(new Engine(2.5, 0));
        builder.setTransmission(Transmission.MANUAL);
        builder.setTripComputer(new TripComputer());
        builder.setGPSNavigator(new GPSNavigator());
    }

}
