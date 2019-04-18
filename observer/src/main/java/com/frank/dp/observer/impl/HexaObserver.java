package com.frank.dp.observer.impl;

import com.frank.dp.observer.core.Observer;
import com.frank.dp.observer.core.Subject;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: java-design-patterns
 * @package: com.frank.dp.observer.impl、
 * @email: cy880708@163.com
 * @date: 2019/4/17 下午6:37
 * @mofified By:
 */
public class HexaObserver extends Observer {

    public HexaObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Hex String: " + Integer.toHexString( subject.getState() ).toUpperCase() );
    }

}
