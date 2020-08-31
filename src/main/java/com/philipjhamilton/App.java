package com.philipjhamilton;

import com.philipjhamilton.patterns.behavioral.chainofresponsibility.ATMDispenseChain;
import com.philipjhamilton.patterns.behavioral.command.editor.Editor;
import com.philipjhamilton.patterns.behavioral.iterator.Profile;
import com.philipjhamilton.patterns.behavioral.iterator.social.Facebook;
import com.philipjhamilton.patterns.behavioral.iterator.social.LinkedIn;
import com.philipjhamilton.patterns.behavioral.iterator.social.SocialNetwork;
import com.philipjhamilton.patterns.behavioral.iterator.spammer.SocialSpammer;
import com.philipjhamilton.patterns.behavioral.observer.listeners.EmailNotificationListener;
import com.philipjhamilton.patterns.behavioral.observer.listeners.LogOpenListener;
import com.philipjhamilton.patterns.behavioral.strategy.order.Order;
import com.philipjhamilton.patterns.behavioral.strategy.strategies.PayByCreditCard;
import com.philipjhamilton.patterns.behavioral.strategy.strategies.PayByPayPal;
import com.philipjhamilton.patterns.behavioral.strategy.strategies.PayStrategy;
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
import com.philipjhamilton.patterns.structural.decorator.decorators.*;
import com.philipjhamilton.patterns.structural.facade.points.Line;
import com.philipjhamilton.patterns.structural.facade.points.Point;
import com.philipjhamilton.patterns.structural.facade.video.VideoConversionFacade;
import com.philipjhamilton.patterns.structural.flyweight.forest.Forest;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
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

        //Composite pattern example (Uncomment because of GUI)
//        ImageEditor editor = new ImageEditor();
//
//        editor.loadShapes(
//                new Circle(10, 10, 10, Color.BLUE),
//
//                new CompoundShape(
//                        new Circle(110, 110, 50, Color.RED),
//                        new Dot(160, 160, Color.RED)
//                ),
//
//                new CompoundShape(
//                        new Rectangle(250, 250, 100, 100, Color.GREEN),
//                        new Dot(240, 240, Color.GREEN),
//                        new Dot(240, 360, Color.GREEN),
//                        new Dot(360, 360, Color.GREEN),
//                        new Dot(360, 240, Color.GREEN)
//                )
//        );

        //Command Pattern Example (Uncomment because of GUI)
        //Editor editor = new Editor();
        //editor.init();

        // DECORATOR PATTERN EXAMPLE
        String salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000";
        DataSourceDecorator encoded = new CompressionDecorator(
                new EncryptionDecorator(
                        new FileDataSource("OutputDemo.txt")));
        encoded.writeData(salaryRecords);
        DataSource plain = new FileDataSource("OutputDemo.txt");

        System.out.println("- Input ----------------");
        System.out.println(salaryRecords);
        System.out.println("- Encoded --------------");
        System.out.println(plain.readData());
        System.out.println("- Decoded --------------");
        System.out.println(encoded.readData());

        // Strategy Example
        boolean strategyEnabled = false;
        if (strategyEnabled) {
            Map<Integer, Integer> priceOnProducts = new HashMap<>();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Order order = new Order();
            PayStrategy strategy = null;

            priceOnProducts.put(1, 2200);
            priceOnProducts.put(2, 1850);
            priceOnProducts.put(3, 1100);
            priceOnProducts.put(4, 890);

            while (!order.isClosed()) {
                int cost;

                String continueChoice;
                do {
                    System.out.print("Please, select a product:" + "\n" +
                            "1 - Mother board" + "\n" +
                            "2 - CPU" + "\n" +
                            "3 - HDD" + "\n" +
                            "4 - Memory" + "\n");
                    int choice = Integer.parseInt(reader.readLine());
                    cost = priceOnProducts.get(choice);
                    System.out.print("Count: ");
                    int count = Integer.parseInt(reader.readLine());
                    order.setTotalCost(cost * count);
                    System.out.print("Do you wish to continue selecting products? Y/N: ");
                    continueChoice = reader.readLine();
                } while (continueChoice.equalsIgnoreCase("Y"));

                if (strategy == null) {
                    System.out.println("Please, select a payment method:" + "\n" +
                            "1 - PalPay" + "\n" +
                            "2 - Credit Card");
                    String paymentMethod = reader.readLine();

                    // Client creates different strategies based on input from
                    // user, application configuration, etc.
                    if (paymentMethod.equals("1")) {
                        strategy = new PayByPayPal();
                    } else {
                        strategy = new PayByCreditCard();
                    }
                }

                order.processOrder(strategy);

                System.out.print("Pay " + order.getTotalCost() + " units or Continue shopping? P/C: ");
                String proceed = reader.readLine();
                if (proceed.equalsIgnoreCase("P")) {
                    // Finally, strategy handles the payment.
                    if (strategy.pay(order.getTotalCost())) {
                        System.out.println("Payment has been successful.");
                    } else {
                        System.out.println("FAIL! Please, check your data.");
                    }
                    order.setClosed(true);
                }
            }
        }

        // ITERATOR PATTERN EXAMPLE
        boolean enableIterator = false;
        if (enableIterator) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please specify social network to target spam tool (default:Facebook):");
            System.out.println("1. Facebook");
            System.out.println("2. LinkedIn");
            String choice = scanner.nextLine();

            SocialNetwork network;
            if (choice.equals("2")) {
                network = new LinkedIn(createTestProfiles());
            } else {
                network = new Facebook(createTestProfiles());
            }

            SocialSpammer spammer = new SocialSpammer(network);
            spammer.sendSpamToFriends("anna.smith@bing.com",
                    "Hey! This is Anna's friend Josh. Can you do me a favor and like this post [link]?");
            spammer.sendSpamToCoworkers("anna.smith@bing.com",
                    "Hey! This is Anna's boss Jason. Anna told me you would be interested in [link].");
        }

        // Facade Pattern
        Line lineA = new Line(new Point(2, 4), new Point(5, 7));
        lineA.move(-2, -4);
        System.out.println( "after move:  " + lineA );
        lineA.rotate(45);
        System.out.println( "after rotate: " + lineA );
        Line lineB = new Line( new Point(2, 1), new Point(2.866, 1.5));
        lineB.rotate(30);
        System.out.println("30 degrees to 60 degrees: " + lineB);

        // Facade Pattern example II
        VideoConversionFacade converter = new VideoConversionFacade();
        File mp4Video = converter.convertVideo("youtubevideo.ogg", "mp4");

        // Flyweight pattern examples
        boolean showFlyweightExample = false;
        if(showFlyweightExample) {
            int CANVAS_SIZE = 500;
            int TREES_TO_DRAW = 1000000;
            int TREE_TYPES = 2;

            Forest forest = new Forest();
            for (int i = 0; i < Math.floor(TREES_TO_DRAW / TREE_TYPES); i++) {
                forest.plantTree(random(0, CANVAS_SIZE), random(0, CANVAS_SIZE),
                        "Summer Oak", Color.GREEN, "Oak texture stub");
                forest.plantTree(random(0, CANVAS_SIZE), random(0, CANVAS_SIZE),
                        "Autumn Oak", Color.ORANGE, "Autumn Oak texture stub");
            }
            forest.setSize(CANVAS_SIZE, CANVAS_SIZE);
            forest.setVisible(true);

            System.out.println(TREES_TO_DRAW + " trees drawn");
            System.out.println("---------------------");
            System.out.println("Memory usage:");
            System.out.println("Tree size (8 bytes) * " + TREES_TO_DRAW);
            System.out.println("+ TreeTypes size (~30 bytes) * " + TREE_TYPES + "");
            System.out.println("---------------------");
            System.out.println("Total: " + ((TREES_TO_DRAW * 8 + TREE_TYPES * 30) / 1024 / 1024) +
                    "MB (instead of " + ((TREES_TO_DRAW * 38) / 1024 / 1024) + "MB)");
        }

        // Observer pattern
        com.philipjhamilton.patterns.behavioral.observer.editor.Editor editor = new com.philipjhamilton.patterns.behavioral.observer.editor.Editor();
        editor.events.subscribe("open", new LogOpenListener("/path/to/log/file.txt"));
        editor.events.subscribe("save", new EmailNotificationListener("admin@example.com"));

        try {
            editor.openFile("test.txt");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }


    private static List<Profile> createTestProfiles() {
        List<Profile> data = new ArrayList<Profile>();
        data.add(new Profile("anna.smith@bing.com", "Anna Smith", "friends:mad_max@ya.com", "friends:catwoman@yahoo.com", "coworkers:sam@amazon.com"));
        data.add(new Profile("mad_max@ya.com", "Maximilian", "friends:anna.smith@bing.com", "coworkers:sam@amazon.com"));
        data.add(new Profile("bill@microsoft.eu", "Billie", "coworkers:avanger@ukr.net"));
        data.add(new Profile("avanger@ukr.net", "John Day", "coworkers:bill@microsoft.eu"));
        data.add(new Profile("sam@amazon.com", "Sam Kitting", "coworkers:anna.smith@bing.com", "coworkers:mad_max@ya.com", "friends:catwoman@yahoo.com"));
        data.add(new Profile("catwoman@yahoo.com", "Liza", "friends:anna.smith@bing.com", "friends:sam@amazon.com"));
        return data;
    }

}
