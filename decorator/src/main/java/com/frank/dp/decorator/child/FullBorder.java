package com.frank.dp.decorator.child;

import com.frank.dp.decorator.core.Display;

/**
 * @version 1.0
 * @description：在字符串上下左右都加上装饰边框
 * @author: Yang.Chang
 * @project: java-design-patterns
 * @package: com.frank.dp.decorator.child、
 * @email: cy880708@163.com
 * @date: 2019/4/18 下午4:03
 * @mofified By:
 */
public class FullBorder extends Border {

    public FullBorder(Display display) {
        super(display);
    }

    /**
     * 字符数为被装饰物的字符数加上两侧边框字符数
     * @return
     */
    @Override
    public int getColumns() {
        return 1 + display.getColumns() + 1;
    }

    /**
     * 行数为被装饰物的行数加上上下边框的行数
     * @return
     */
    @Override
    public int getRows() {
        return 1 + display.getRows() + 1;
    }

    /**
     * 指定的那一行的字符串
     * @param row
     * @return
     */
    @Override
    public String getRowText(int row) {
        if(row == 0) {
            // 下边框
            return "+" + makeLine('-', display.getColumns()) + "+";
        } else
        if(row == display.getRows() + 1) {
            // 上边框
            return "+" + makeLine('-', display.getColumns()) + "+";
        } else {
            // 其它边框
            return "|" + display.getRowText(row - 1) + "|";
        }
    }

    /**
     * 生成一个重复count次字符ch的字符串
     * @param ch
     * @param count
     * @return
     */
    private String makeLine(char ch, int count) {
        StringBuffer buf = new StringBuffer();
        for(int i=0; i<count; i++) {
            buf.append(ch);
        }
        return buf.toString();
    }

}
