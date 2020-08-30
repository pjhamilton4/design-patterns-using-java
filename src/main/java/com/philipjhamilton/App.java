package com.philipjhamilton;

import com.philipjhamilton.patterns.behavioral.chainofresponsibility.ATMDispenseChain;
import com.philipjhamilton.patterns.creational.abstractfactory.Application;
import com.philipjhamilton.patterns.creational.abstractfactory.factories.MacOSFactory;
import com.philipjhamilton.patterns.creational.abstractfactory.factories.WindowsFactory;
import com.philipjhamilton.patterns.creational.builder.Director;
import com.philipjhamilton.patterns.creational.builder.builders.CarBuilder;
import com.philipjhamilton.patterns.creational.builder.builders.CarManualBuilder;
import com.philipjhamilton.patterns.creational.builder.cars.Car;
import com.philipjhamilton.patterns.creational.builder.cars.Manual;
import com.philipjhamilton.patterns.creational.factory.API;
import com.philipjhamilton.patterns.creational.factory.APIFactory;
import com.philipjhamilton.patterns.creational.prototype.Shape;
import com.philipjhamilton.patterns.creational.prototype.ShapeCache;
import com.philipjhamilton.patterns.creational.singleton.SingletonLazyInit;
import com.philipjhamilton.patterns.structural.adapter.RoundHole;
import com.philipjhamilton.patterns.structural.adapter.RoundPeg;
import com.philipjhamilton.patterns.structural.adapter.SquarePeg;
import com.philipjhamilton.patterns.structural.adapter.SquarePegAdapter;
import com.philipjhamilton.patterns.structural.bridge.devices.Radio;
import com.philipjhamilton.patterns.structural.bridge.devices.Tv;
import com.philipjhamilton.patterns.structural.bridge.remotes.AdvancedRemote;
import com.philipjhamilton.patterns.structural.bridge.remotes.BasicRemote;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SingletonLazyInit test = SingletonLazyInit.getInstance();

        System.out.println("Singleton Lazy Init hashCode: " + test.hashCode());
        SingletonLazyInit test2 = SingletonLazyInit.getInstance();

        System.out.println("Singleton Lazy Init hashCode: " + test2.hashCode());

        ShapeCache.loadCache();

        Shape s = ShapeCache.getShape("0");

        System.out.println(s);

        Shape s2 = ShapeCache.getShape("1");

        System.out.println(s2);

        Shape s3 = ShapeCache.getShape("2");

        System.out.println(s3);

        //Factory patterns
        API api = APIFactory.getApiInstance("v1");

        api.doOneMoreThing();
        api.doSomething();

        api = APIFactory.getApiInstance("v2");

        api.doOneMoreThing();
        api.doSomething();

        //Chain of responsibility
        ATMDispenseChain atmDispenser = new ATMDispenseChain();

        atmDispenser.dispense(530);

        //Adapter pattern
        RoundHole hole = new RoundHole(5);
        RoundPeg rpeg = new RoundPeg(5);
        if (hole.fits(rpeg)) {
            System.out.println("Round peg r5 fits round hole r5.");
        }

        SquarePeg smallSqPeg = new SquarePeg(2);
        SquarePeg largeSqPeg = new SquarePeg(20);
        // hole.fits(smallSqPeg); // Won't compile.

        // Adapter solves the problem.
        SquarePegAdapter smallSqPegAdapter = new SquarePegAdapter(smallSqPeg);
        SquarePegAdapter largeSqPegAdapter = new SquarePegAdapter(largeSqPeg);
        if (hole.fits(smallSqPegAdapter)) {
            System.out.println("Square peg w2 fits round hole r5.");
        }
        if (!hole.fits(largeSqPegAdapter)) {
            System.out.println("Square peg w20 does not fit into round hole r5.");
        }

        //Builder patterns
        Director director = new Director();
        CarBuilder builder = new CarBuilder();

        director.constructSportsCar(builder);

        Car car = builder.getResult();
        System.out.println("Car built: " + car.getType());

        CarManualBuilder manualBuilder = new CarManualBuilder();

        // Director may know several building recipes.
        director.constructSportsCar(manualBuilder);
        Manual carManual = manualBuilder.getResult();
        System.out.println("\nCar manual built:\n" + carManual.print());

        //Bridge Patter
        Tv tv = new Tv();
        Radio radio = new Radio();

        System.out.println("Tests with basic remote.");
        BasicRemote basicRemote = new BasicRemote(tv);
        basicRemote.power();
        tv.printStatus();

        System.out.println("Tests with advanced remote.");
        AdvancedRemote advancedRemote = new AdvancedRemote(radio);
        advancedRemote.power();
        advancedRemote.mute();
        radio.printStatus();

        //Abstract Factory Example

        MacOSFactory macFactory = new MacOSFactory();
        WindowsFactory winFactory = new WindowsFactory();
        Application abstractFactory = new Application(macFactory);

        abstractFactory.paint();

        abstractFactory = new Application(winFactory);

        abstractFactory.paint();
    }
}
