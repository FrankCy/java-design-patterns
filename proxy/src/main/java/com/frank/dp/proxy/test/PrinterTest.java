package com.frank.dp.proxy.test;

import com.frank.dp.proxy.impl.PrinterProxy;
import com.frank.dp.proxy.service.Printable;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: java-design-patterns
 * @package: com.frank.dp.proxy.test、
 * @email: cy880708@163.com
 * @date: 2019/4/15 下午2:31
 * @mofified By:
 */
public class PrinterTest {
    public static void main(String[] args) {
        Printable p = new PrinterProxy("Alice");
        // 获取打印机名并打印
        System.out.println("现在的名字是：" + p.getPrinterName() + ".");
        // 重新设置打印机名
        p.setPrinterName("Bob");
        System.out.println("现在的名字是：" + p.getPrinterName() + ".");
        // 显示打印内容，调用的时候Printer实例才被生成。
        p.print("Hello, World.");
    }
}
