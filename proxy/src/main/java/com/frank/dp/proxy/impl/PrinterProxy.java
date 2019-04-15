package com.frank.dp.proxy.impl;

import com.frank.dp.proxy.service.Printable;

/**
 * @version 1.0
 * @description：代理
 * @author: Yang.Chang
 * @project: java-design-patterns
 * @package: com.frank.dp.proxy.impl、
 * @email: cy880708@163.com
 * @date: 2019/4/15 下午2:27
 * @mofified By:
 */
public class PrinterProxy implements Printable {

    /**
     * 名字
     */
    private String name;

    /**
     * 本人
     */
    private Printer real;

    /**
     * 构造函数
     * @param name
     */
    public PrinterProxy(String name) {
        this.name = name;
    }

    /**
     * 设置名字
     * @param name
     */
    @Override
    public void setPrinterName(String name) {
        if(real != null) {
            // 同时设置"本人"的名字
            real.setPrinterName(name);
        }
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
     * 显示
     * @param string
     */
    @Override
    public void print(String string) {
        realize();
        real.print(string);
    }

    /**
     * 生成 "本人"
     */
    private synchronized void realize() {
        if(real == null) {
            real = new Printer(name);
        }
    }
}
