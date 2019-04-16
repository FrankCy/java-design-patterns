package com.frank.dp.flyweight.test;

import com.frank.dp.flyweight.factory.ShapeFactory;
import com.frank.dp.flyweight.impl.Circle;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: java-design-patterns
 * @package: com.frank.dp.flyweight.test、
 * @email: cy880708@163.com
 * @date: 2019/4/16 上午10:22
 * @mofified By:
 */
public class FlyweightPatternDemo {

    private static final String[] COLORS = {"Red", "Green", "Blue", "White", "Black"};

    public static void main(String[] args) {
        for(int i=0; i < 20; ++i) {
            Circle circle = (Circle) ShapeFactory.getCircle(getRandomColor());
            circle.setX(getRandomX());
            circle.setY(getRandomY());
            circle.setRadius(100);
            circle.draw();
        }
    }

    private static String getRandomColor() {
        return COLORS[(int)(Math.random()*COLORS.length)];
    }

    private static int getRandomX() {
        return (int)(Math.random()*100 );
    }

    private static int getRandomY() {
        return (int)(Math.random()*100);
    }

}
