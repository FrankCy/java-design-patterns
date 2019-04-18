package com.frank.dp.decorator.core;

/**
 * @version 1.0
 * @description：可显示多行字符多抽象类
 * @author: Yang.Chang
 * @project: java-design-patterns
 * @package: com.frank.dp.decorator.core、
 * @email: cy880708@163.com
 * @date: 2019/4/18 下午1:55
 * @mofified By:
 */
public abstract class Display {

    /**
     * 获取横向字符数
     * @return
     */
    public abstract int getColumns();

    /**
     * 获取纵向行数
     * @return
     */
    public abstract int getRows();

    /**
     * 获取row行的字符串
     * @param row
     * @return
     */
    public abstract String getRowText(int row);


    /**
     * 显示全部
     */
    public final void show() {
        for(int i=0; i<getRows(); i++) {
            System.out.println(getRowText(i));
        }
    }

}
