package com.frank.dp.decorator.child;

import com.frank.dp.decorator.impl.ShapeDecorator;
import com.frank.dp.decorator.service.Shape;

/**
 * @version 1.0
 * @description：绘制红色矩形的装饰器，继承绘制装饰器
 * @author: Yang.Chang
 * @project: java-design-patterns
 * @package: com.frank.dp.decorator.child、
 * @email: cy880708@163.com
 * @date: 2019/4/18 下午5:21
 * @mofified By:
 */
public class RedShapeDecorator extends ShapeDecorator {

    /**
     * 构造函数绘制红色装饰器
     * @param decoratedShape
     */
    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    /**
     * 绘制
     */
    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    /**
     * 设置红色边框
     * @param decoratedShape
     */
    private void setRedBorder(Shape decoratedShape){
        System.out.println("Border Color: Red");
    }

}
