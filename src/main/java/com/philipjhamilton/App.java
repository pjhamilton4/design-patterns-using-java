package com.philipjhamilton;

import com.philipjhamilton.patterns.creational.prototype.Shape;
import com.philipjhamilton.patterns.creational.prototype.ShapeCache;
import com.philipjhamilton.patterns.creational.singleton.SingletonLazyInit;

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

        System.out.println(s.getType());

        Shape s2 = ShapeCache.getShape("1");

        System.out.println(s2.getType());

        Shape s3 = ShapeCache.getShape("2");

        System.out.println(s3.getType());

    }
}
