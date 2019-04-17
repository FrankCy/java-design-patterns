package com.frank.dp.observer.impl;

import com.frank.dp.observer.core.NumberGenerator;
import com.frank.dp.observer.service.Observer;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: java-design-patterns
 * @package: com.frank.dp.observer.impl、
 * @email: cy880708@163.com
 * @date: 2019/4/16 下午6:52
 * @mofified By:
 */
public class DigitObserver implements Observer {

    @Override
    public void update(NumberGenerator generator) {
        System.out.println("DigitObserver : " + generator.getNumber());
        try{
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
