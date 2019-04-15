package com.frank.dp.proxy.test;

import com.frank.dp.proxy.impl.Friend;
import com.frank.dp.proxy.impl.Shopowner;
import com.frank.dp.proxy.service.BuySpicyStrips;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: java-design-patterns
 * @package: com.frank.dp.proxy.test、
 * @email: cy880708@163.com
 * @date: 2019/4/15 上午11:32
 * @mofified By:
 */
public class BuySpicyStripsTest {

    public static void main(String[] args) {
        // 老板买辣条（代理买辣条）
//        BuySpicyStrips buy = new Friend(new Shopowner());
        // 自己买辣条（不用老板）
        BuySpicyStrips buy = new Friend(null);
        buy.buySpicyStrips();
    }

}
