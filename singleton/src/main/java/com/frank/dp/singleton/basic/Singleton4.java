package com.frank.dp.singleton.basic;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: java-design-patterns
 * @package: com.frank.dp.Singleton4.basic、
 * @email: cy880708@163.com
 * @date: 2019/4/16 下午2:47
 * @mofified By:
 */
public class Singleton4 {

    private static class Singleton4Holder {
        private static final Singleton4 INSTANCE = new Singleton4();
    }

    private Singleton4 (){}

    /**
     * 当Singleton使用时，不会初始化 INSTANCE，只有在实际调用getInstance()时，才会初始化对象。
     * @return
     */
    public static final Singleton4 getInstance() {
        return Singleton4Holder.INSTANCE;
    }
}
