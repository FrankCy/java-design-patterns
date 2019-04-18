package com.frank.dp.observer.core;

/**
 * @version 1.0
 * @description：观察者类
 * @author: Yang.Chang
 * @project: java-design-patterns
 * @package: com.frank.dp.observer.core、
 * @email: cy880708@163.com
 * @date: 2019/4/17 下午6:34
 * @mofified By:
 */
public abstract class Observer {

    protected Subject subject;

    public abstract void update();
}
