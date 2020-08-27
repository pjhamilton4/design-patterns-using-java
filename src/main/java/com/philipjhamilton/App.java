package com.philipjhamilton;

import com.philipjhamilton.patterns.behavioral.chainofresponsibility.ATMDispenseChain;
import com.philipjhamilton.patterns.behavioral.chainofresponsibility.Currency;
import com.philipjhamilton.patterns.creational.factory.API;
import com.philipjhamilton.patterns.creational.factory.APIFactory;
import com.philipjhamilton.patterns.creational.objectpool.UserTemp;
import com.philipjhamilton.patterns.creational.objectpool.UserTempOjbectPool;
import com.philipjhamilton.patterns.creational.prototype.Shape;
import com.philipjhamilton.patterns.creational.prototype.ShapeCache;
import com.philipjhamilton.patterns.creational.singleton.SingletonLazyInit;
import com.philipjhamilton.patterns.structural.adapter.RoundHole;
import com.philipjhamilton.patterns.structural.adapter.RoundPeg;
import com.philipjhamilton.patterns.structural.adapter.SquarePeg;
import com.philipjhamilton.patterns.structural.adapter.SquarePegAdapter;

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

        //Factory pattern
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
    }
}
