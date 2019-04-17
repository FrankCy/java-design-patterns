package com.frank.dp.observer.test;

import com.frank.dp.observer.child.RandomNumberGenerator;
import com.frank.dp.observer.core.NumberGenerator;
import com.frank.dp.observer.impl.DigitObserver;
import com.frank.dp.observer.impl.GraphObserver;
import com.frank.dp.observer.service.Observer;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: java-design-patterns
 * @package: com.frank.dp.observer.test、
 * @email: cy880708@163.com
 * @date: 2019/4/16 下午7:01
 * @mofified By:
 */
public class Main {
    public static void main(String[] args) {
        NumberGenerator generator = new RandomNumberGenerator();
        Observer observer1 = new DigitObserver();
        Observer observer2 = new GraphObserver();
        generator.addObserver(observer1);
        generator.addObserver(observer2);
        generator.execute();
    }
}
