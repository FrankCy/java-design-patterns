package com.frank.dp.decorator.child;

import com.frank.dp.decorator.core.Display;

/**
 * @version 1.0
 * @description：显示单行字符串的类（相当于蛋糕的核心蛋糕[蛋糕胚子]）
 * @author: Yang.Chang
 * @project: java-design-patterns
 * @package: com.frank.dp.decorator.impl、
 * @email: cy880708@163.com
 * @date: 2019/4/18 下午3:27
 * @mofified By:
 */
public class StringDisplay extends Display {

    /**
     * 要显示的字符串
     */
    private String string;

    /**
     * 通过参数传入显示的字符串
     * @return
     */
    public StringDisplay(String string) {
        this.string = string;
    }

    /**
     * 字节数
     * @return
     */
    @Override
    public int getColumns() {
        return string.getBytes().length;
    }

    /**
     * 行数是1
     * @return
     */
    @Override
    public int getRows() {
        return 1;
    }

    /**
     * 仅当row为0时返回值
     * @param row
     * @return
     */
    @Override
    public String getRowText(int row) {
        if(row == 0) {
            return string;
        } else {
            return null;
        }
    }
}
