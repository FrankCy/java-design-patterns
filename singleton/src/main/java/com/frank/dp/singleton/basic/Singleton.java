package com.frank.dp.singleton.basic;

/**
 * @version 1.0
 * @description：懒汉式（线程不安全）,不适合多线程环境
 * @author: Yang.Chang
 * @project: java-design-patterns
 * @package: com.frank.dp.singleton.basic、
 * @email: cy880708@163.com
 * @date: 2019/4/16 下午2:20
 * @mofified By:
 */
public class Singleton {

    private static Singleton instance;

    private Singleton (){}

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

}
