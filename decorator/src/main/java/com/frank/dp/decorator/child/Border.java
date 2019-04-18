package com.frank.dp.decorator.child;

import com.frank.dp.decorator.core.Display;

/**
 * @version 1.0
 * @description：装饰边框的抽象类【通过继承，装饰边框与被装饰物具有了相同的方法】
 * @author: Yang.Chang
 * @project: java-design-patterns
 * @package: com.frank.dp.decorator.child、
 * @email: cy880708@163.com
 * @date: 2019/4/18 下午3:39
 * @mofified By:
 */
public abstract class Border extends Display {

    /**
     * 表示被装饰物
     */
    protected Display display;

    /**
     * 在生成实例时通过参数指定被装饰物
     * @param display
     */
    protected Border(Display display) {
        this.display = display;
    }

}
