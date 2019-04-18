package com.frank.dp.observer.test;

import com.frank.dp.observer.core.Subject;
import com.frank.dp.observer.impl.BinaryObserver;
import com.frank.dp.observer.impl.HexaObserver;
import com.frank.dp.observer.impl.OctalObserver;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: java-design-patterns
 * @package: com.frank.dp.observer.test、
 * @email: cy880708@163.com
 * @date: 2019/4/17 下午6:46
 * @mofified By:
 */
public class ObserverPatternDemo {

    public static void main(String[] args) {
        Subject subject = new Subject();

        new HexaObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);
    }

}
