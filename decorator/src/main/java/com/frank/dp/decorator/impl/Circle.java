package com.frank.dp.decorator.impl;

import com.frank.dp.decorator.service.Shape;

/**
 * @version 1.0
 * @description：圆形
 * @author: Yang.Chang
 * @project: java-design-patterns
 * @package: com.frank.dp.decorator.impl、
 * @email: cy880708@163.com
 * @date: 2019/4/18 下午5:20
 * @mofified By:
 */
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Shape: Circle");
    }
}
