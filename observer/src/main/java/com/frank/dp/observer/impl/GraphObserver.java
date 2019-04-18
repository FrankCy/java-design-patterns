package com.frank.dp.observer.impl;

import com.frank.dp.observer.core.NumberGenerator;
import com.frank.dp.observer.service.Observer;

/**
 * @version 1.0
 * @description：具体观察者
 * @author: Yang.Chang
 * @project: java-design-patterns
 * @package: com.frank.dp.observer.impl、
 * @email: cy880708@163.com
 * @date: 2019/4/16 下午6:55
 * @mofified By:
 */
public class GraphObserver implements Observer {
    @Override
    public void update(NumberGenerator generator) {
        System.out.println(" ==== GraphObserver ===");
        int count = generator.getNumber();

        for(int i=0; i<count; i++) {
            System.out.print("*");
        }

        System.out.println("");
        try {
            Thread.sleep(100);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
