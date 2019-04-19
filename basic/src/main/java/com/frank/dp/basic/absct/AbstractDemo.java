package com.frank.dp.basic.absct;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: java-design-patterns
 * @package: com.frank.dp.basic.absct、
 * @email: cy880708@163.com
 * @date: 2019/4/19 下午5:35
 * @mofified By:
 */
public class AbstractDemo {
    public static void main(String[] args) {
        // 抽象类不允许被实例化！
//        Employee employee = new Employee();
        Salary s = new Salary("Mohd Mohtashim", "Ambehta, UP", 3, 3600.00);

        Employee e = new Salary("John Adams", "Boston, MA", 2, 2400.00);

        System.out.println("Call mailCheck using Salary reference --");
        s.mailCheck();

        System.out.println("\n Call mailCheck using Employee reference--");
        e.mailCheck();


    }
}
