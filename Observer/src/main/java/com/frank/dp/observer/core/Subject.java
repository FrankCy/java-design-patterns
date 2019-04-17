package com.frank.dp.observer.core;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @description：观察角色
 * @author: Yang.Chang
 * @project: java-design-patterns
 * @package: com.frank.dp.observer.core、
 * @email: cy880708@163.com
 * @date: 2019/4/17 下午6:31
 * @mofified By:
 */
public class Subject {

    private List<Observer> observers = new ArrayList<Observer>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
