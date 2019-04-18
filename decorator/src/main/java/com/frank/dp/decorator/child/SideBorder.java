package com.frank.dp.decorator.child;

import com.frank.dp.decorator.core.Display;

/**
 * @version 1.0
 * @description：具体的装饰边框 "|"
 * @author: Yang.Chang
 * @project: java-design-patterns
 * @package: com.frank.dp.decorator.child、
 * @email: cy880708@163.com
 * @date: 2019/4/18 下午3:48
 * @mofified By:
 */
public class SideBorder extends Border {

    /**
     * 表示装饰边框的字符
     */
    private char borderChar;

    /**
     * 通过构造函数指定Display和装饰边框字符
     * @param display
     * @param ch
     */
    public SideBorder(Display display, char ch) {

        super(display);

        this.borderChar = ch;

    }

    /**
     * 字符数为字符串字符数加上两侧边框字符数
     * @return
     */
    @Override
    public int getColumns() {
        return 1 + display.getColumns() + 1;
    }

    /**
     * 行数即被装饰物的行数
     * @return
     */
    @Override
    public int getRows() {
        return display.getRows();
    }

    /**
     * 指定的那一行的字符串为被装饰物的字符串加上两侧的边框的字符
     * @param row
     * @return
     */
    @Override
    public String getRowText(int row) {
        return borderChar + display.getRowText(row) + borderChar;
    }
}
