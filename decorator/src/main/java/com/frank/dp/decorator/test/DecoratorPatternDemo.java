package com.frank.dp.decorator.test;

import com.frank.dp.decorator.child.RedShapeDecorator;
import com.frank.dp.decorator.impl.Circle;
import com.frank.dp.decorator.impl.Rectangle;
import com.frank.dp.decorator.service.Shape;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: java-design-patterns
 * @package: com.frank.dp.decorator.test、
 * @email: cy880708@163.com
 * @date: 2019/4/18 下午5:22
 * @mofified By:
 */
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Shape circle = new Circle();

        Shape redCircle = new RedShapeDecorator(new Circle());

        Shape redRectangle = new RedShapeDecorator(new Rectangle());
        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle of red border");
        redCircle.draw();

        System.out.println("\nRectangle of red border");
        redRectangle.draw();
    }
}
