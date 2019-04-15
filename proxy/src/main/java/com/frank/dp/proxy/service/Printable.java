package com.frank.dp.proxy.service;

/**
 * @version 1.0
 * @description：公共接口
 * @author: Yang.Chang
 * @project: java-design-patterns
 * @package: com.frank.dp.proxy.service、
 * @email: cy880708@163.com
 * @date: 2019/4/15 下午1:52
 * @mofified By:
 */
public interface Printable {

    /**
     * 设置名字
     * @param name
     */
    void setPrinterName(String name);

    /**
     * 获取名字
     * @return
     */
    String getPrinterName();

    /**
     * 显示文字（打印输出）
     * @param string
     */
    void print(String string);

}
