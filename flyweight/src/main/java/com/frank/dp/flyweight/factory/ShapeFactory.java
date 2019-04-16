package com.frank.dp.flyweight.factory;

import com.frank.dp.flyweight.impl.Circle;
import com.frank.dp.flyweight.service.Shape;

import java.util.HashMap;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: java-design-patterns
 * @package: com.frank.dp.flyweight.factory、
 * @email: cy880708@163.com
 * @date: 2019/4/16 上午10:21
 * @mofified By:
 */
public class ShapeFactory {

    private static final HashMap<String, Shape> circleMap = new HashMap<>();

    public static Shape getCircle(String color) {
        Circle circle = (Circle)circleMap.get(color);

        if(circle == null) {
            circle = new Circle(color);
            circleMap.put(color, circle);
            System.out.println("Creating circle of color : " + color);
        }
        return circle;
    }

}
