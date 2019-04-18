package com.frank.dp.observer.impl;

import com.frank.dp.observer.core.Observer;
import com.frank.dp.observer.core.Subject;

/**
 * @version 1.0
 * @description：创建实际观察者类
 * @author: Yang.Chang
 * @project: java-design-patterns
 * @package: com.frank.dp.observer.impl、
 * @email: cy880708@163.com
 * @date: 2019/4/17 下午6:36
 * @mofified By:
 */
public class OctalObserver extends Observer {

    public OctalObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Octal String: "
                + Integer.toOctalString( subject.getState() ) );
    }

}
