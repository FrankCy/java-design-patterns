package com.frank.dp.observer.core;

import com.frank.dp.observer.service.Observer;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @version 1.0
 * @description：观察角色
 * @author: Yang.Chang
 * @project: java-design-patterns
 * @package: com.frank.dp.observer.core、
 * @email: cy880708@163.com
 * @date: 2019/4/16 下午6:30
 * @mofified By:
 */
public abstract class NumberGenerator {

    /**
     * 保存所有Observer
     */
    private ArrayList<Observer> observers = new ArrayList();

    /**
     * 注册observer
     * @param observer
     */
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     *  删除Observer
     * @param observer
     */
    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * 向所有Observer发送通知
     */
    public void notifyObservers() {
        Iterator it = observers.iterator();
        while ( it.hasNext()) {
            Observer observer = (Observer) it.next();
            observer.update(this);
        }
    }

    /**
     * 获取数值
     * @return
     */
    public abstract int getNumber();

    /**
     * 生成数值
     */
    public abstract void execute();

}
