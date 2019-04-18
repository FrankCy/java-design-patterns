package com.frank.dp.decorator.test;

import com.frank.dp.decorator.child.FullBorder;
import com.frank.dp.decorator.child.SideBorder;
import com.frank.dp.decorator.child.StringDisplay;
import com.frank.dp.decorator.core.Display;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: java-design-patterns
 * @package: com.frank.dp.decorator.test、
 * @email: cy880708@163.com
 * @date: 2019/4/18 下午4:11
 * @mofified By:
 */
public class Main {
    public static void main(String[] args) {
        // 显示单行字符串的类（相当于蛋糕的核心蛋糕[蛋糕胚子]）
        Display b1 = new StringDisplay("Hello, world.");

        // 具体的装饰边框 "|"
        Display b2 = new SideBorder(b1, '#');

        // 在字符串上下左右都加上装饰边框
        Display b3 = new FullBorder(b2);

        b1.show();
        b2.show();
        b3.show();
        Display b4 = new SideBorder(
                         new FullBorder(
                             new FullBorder(
                                 new SideBorder(
                                     new FullBorder(
                                         new StringDisplay("你好，世界。")
                                     ),
                                     '*'
                                 )
                             )
                         ),
                     '/'
                     );
        b4.show();

    }
}
