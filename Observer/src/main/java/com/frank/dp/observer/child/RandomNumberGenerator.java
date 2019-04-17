package com.frank.dp.observer.child;

import com.frank.dp.observer.core.NumberGenerator;

import java.util.Random;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: java-design-patterns
 * @package: com.frank.dp.observer.impl、
 * @email: cy880708@163.com
 * @date: 2019/4/16 下午6:45
 * @mofified By:
 */
public class RandomNumberGenerator extends NumberGenerator {

    /**
     * 随机数生成器
     */
    private Random random = new Random();

    /**
     * 当前数值
     */
    private int number;

    /**
     * 获取当前数值
     * @return
     */
    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void execute() {
        for(int i=0; i<20; i++) {
            number = random.nextInt(50);
            notifyObservers();
        }
    }

}
