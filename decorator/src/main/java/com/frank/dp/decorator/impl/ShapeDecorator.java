package com.frank.dp.decorator.impl;

import com.frank.dp.decorator.service.Shape;

/**
 * @version 1.0
 * @description：绘画装饰抽象类，实现绘画形状接口
 * @author: Yang.Chang
 * @project: java-design-patterns
 * @package: com.frank.dp.decorator.core、
 * @email: cy880708@163.com
 * @date: 2019/4/18 下午5:21
 * @mofified By:
 */
public abstract class ShapeDecorator implements Shape {

    protected Shape decoratedShape;

    /**
     * 绘图装饰器
     * @param decoratedShape
     */
    public ShapeDecorator(Shape decoratedShape){
        this.decoratedShape = decoratedShape;
    }

    /**
     * 绘图
     */
    @Override
    public void draw(){
        decoratedShape.draw();
    }

}
