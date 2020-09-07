package com.frank.dp.test;

import com.frank.dp.factory.PayStrategyFactory;
import com.frank.dp.strategy.BankPayStrategy;
import com.frank.dp.strategy.PayActivity;
import com.frank.dp.strategy.WechatPayStrategy;
import com.frank.dp.strategy.ZhiFuBaoPayStrategy;
import com.frank.dp.utils.StringUtils;

/**
 *
 *
 * @author cy
 * @version Test.java, v 0.1 2020年09月07日 22:20 cy Exp $
 */
public class Test {

    /*
    public static void main(String[] args) {
        PayActivity zhiFuBaoPay = new PayActivity(new ZhiFuBaoPayStrategy());
        PayActivity weChatPay = new PayActivity(new WechatPayStrategy());
        PayActivity bankPay = new PayActivity(new BankPayStrategy());

        zhiFuBaoPay.executePayStrategy();
        weChatPay.executePayStrategy();
        bankPay.executePayStrategy();
    }
    */

    /*
    public static void main(String[] args) {
        PayActivity payActivity = null;

        String payKey = "BANK";

        if(StringUtils.equals(payKey, "ZHIFUBAO")) {
            payActivity = new PayActivity(new ZhiFuBaoPayStrategy());
        } else
        if(StringUtils.equals(payKey, "WECHAT")) {
            payActivity = new PayActivity(new WechatPayStrategy());
        } else
        if(StringUtils.equals(payKey, "BANK")) {
            payActivity = new PayActivity(new BankPayStrategy());
        }
        payActivity.executePayStrategy();
    }
    */

    public static void main(String[] args) {
        String payKey = "WECHAT";
        PayActivity payActivity = new PayActivity(PayStrategyFactory.getPayStrategy(payKey));
        payActivity.executePayStrategy();
    }


}
