package com.frank.dp.singleton.basic;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: java-design-patterns
 * @package: com.frank.dp.singleton.basic、
 * @email: cy880708@163.com
 * @date: 2019/4/16 下午2:24
 * @mofified By:
 */
public class Singleton1 {

    private static Singleton1 instance;

    private Singleton1 (){}

    /**
     * 与懒汉式加载（线程不安全但区别在于使用了 synchronized 声明）
     * @return
     */
    public static synchronized Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }

}
