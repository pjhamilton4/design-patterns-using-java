package com.philipjhamilton.patterns.creational.prototype;

import java.util.HashMap;

public class ShapeCache {

    private static HashMap<String, Shape> map = new HashMap<String, Shape>();

    public static Shape getShape(String id){
        Shape cachedShape = map.get(id);
        return (Shape) cachedShape.clone();
    }

    public static void loadCache(){

        Rectangle rt = new Rectangle();
        rt.setId("0");

        map.put(rt.getId(), rt);

        Circle cr = new Circle();
        cr.setId("1");

        map.put(cr.getId(), cr);

        Square sq = new Square();
        sq.setId("2");

        map.put(sq.getId(), sq);
    }

}
