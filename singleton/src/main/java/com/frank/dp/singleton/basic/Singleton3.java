package com.frank.dp.singleton.basic;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: java-design-patterns
 * @package: com.frank.dp.Singleton3.basic、
 * @email: cy880708@163.com
 * @date: 2019/4/16 下午2:36
 * @mofified By:
 */
public class Singleton3 {

    /**
     * volatile 修饰的成员变量在每次被线程访问时，都强制从共享内存中重新读取该成员变量的值
     */
    private volatile static Singleton3 Singleton3;

    private Singleton3 (){}

    public static Singleton3 getSingleton3() {
        if (Singleton3 == null) {
            /**
             * synchronized 关键字声明的方法同一时间只能被一个线程访问。
             */
            synchronized (Singleton3.class) {
                if (Singleton3 == null) {
                    Singleton3 = new Singleton3();
                }
            }
        }
        return Singleton3;
    }

}
