package com.frank.dp.proxy.impl;

import com.frank.dp.proxy.service.Printable;

/**
 * @version 1.0
 * @description：本人
 * @author: Yang.Chang
 * @project: java-design-patterns
 * @package: com.frank.dp.proxy.impl、
 * @email: cy880708@163.com
 * @date: 2019/4/15 下午2:16
 * @mofified By:
 */
public class Printer implements Printable {

    private String name;

    /**
     * 构造函数
     * @param name
     */
    public Printer(String name) {
        this.name = name;
        heavyJob("正在生成 Printer 的实例("+ name +")");
    }

    /**
     * 设置名字
     * @param name
     */
    @Override
    public void setPrinterName(String name) {
        this.name = name;
    }

    /**
     * 获取名字
     * @return
     */
    @Override
    public String getPrinterName() {
        return name;
    }

    /**
     * 显示带打印机名字带文字
     * @param string
     */
    @Override
    public void print(String string) {
        System.out.println(" === " + name + " === ");
        System.out.println(string);
    }

    /**
     * 重活
     * @param msg
     */
    private void heavyJob(String msg) {
        System.out.print(msg);
        for (int i=0 ; i<5 ; i++) {
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(".");
        }
        System.out.println("结束。");
    }
}
