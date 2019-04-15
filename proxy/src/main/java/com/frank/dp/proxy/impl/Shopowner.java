package com.frank.dp.proxy.impl;

import com.frank.dp.proxy.service.BuySpicyStrips;

/**
 * @version 1.0
 * @description：真实实现类
 * @author: Yang.Chang
 * @project: java-design-patterns
 * @package: com.frank.dp.proxy.impl、
 * @email: cy880708@163.com
 * @date: 2019/4/15 上午10:11
 * @mofified By:
 */
public class Shopowner implements BuySpicyStrips {

    public void takeSpicyStrips() {
        System.out.println("店长到辣条厂家进货。");
    }

    @Override
    public void buySpicyStrips() {
        takeSpicyStrips();
        System.out.println("店长买到辣条。");
        sellSpicyStrips();
    }

    public void sellSpicyStrips() {
        System.out.println("店长正在零售。");
    }

}
