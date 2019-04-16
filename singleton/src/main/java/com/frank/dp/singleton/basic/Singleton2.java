package com.frank.dp.singleton.basic;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: java-design-patterns
 * @package: com.frank.dp.Singleton2.basic、
 * @email: cy880708@163.com
 * @date: 2019/4/16 下午2:32
 * @mofified By:
 */
public class Singleton2 {

    // instance 在类装载时就实例化
    private static Singleton2 instance = new Singleton2();

    private Singleton2 (){}

    public static Singleton2 getInstance() {
        return instance;
    }

}
