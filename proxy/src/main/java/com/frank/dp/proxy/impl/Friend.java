package com.frank.dp.proxy.impl;

import com.frank.dp.proxy.service.BuySpicyStrips;

/**
 * @version 1.0
 * @description： 【代理类】
 * @author: Yang.Chang
 * @project: java-design-patterns
 * @package: com.frank.dp.proxy.impl、
 * @email: cy880708@163.com
 * @date: 2019/4/15 上午10:08
 * @mofified By:
 */
public class Friend implements BuySpicyStrips {

    private BuySpicyStrips buySpicyStrips;

    public Friend(BuySpicyStrips buySpicyStrips) {
        this.buySpicyStrips = buySpicyStrips;
    }

    public void goShopping() {
        System.out.println("Frank 正在商店!");
    }

    @Override
    public void buySpicyStrips() {
        goShopping();
        if (buySpicyStrips == null) {
            System.out.println("Frank 自己买辣条，不用代理买!");
        } else {
            buySpicyStrips.buySpicyStrips();
        }
        delivery();
    }

    public void delivery() {
        System.out.println("Frank 买到辣条正在去送给 Nancy !");
    }
}
