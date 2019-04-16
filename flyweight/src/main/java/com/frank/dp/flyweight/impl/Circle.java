package com.frank.dp.flyweight.impl;

import com.frank.dp.flyweight.service.Shape;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: java-design-patterns
 * @package: com.frank.dp.flyweight.impl、
 * @email: cy880708@163.com
 * @date: 2019/4/16 上午10:21
 * @mofified By:
 */
public class Circle implements Shape {

    private String color;

    private int x;

    private int y;

    private int radius;

    public Circle(String color){
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Circle: Draw() [Color : " + color
                +", x : " + x +", y :" + y +", radius :" + radius);
    }
}
