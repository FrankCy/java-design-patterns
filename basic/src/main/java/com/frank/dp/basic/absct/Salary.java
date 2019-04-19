package com.frank.dp.basic.absct;

/**
 * @version 1.0
 * @description：薪水类
 * @author: Yang.Chang
 * @project: java-design-patterns
 * @package: com.frank.dp.basic.absct、
 * @email: cy880708@163.com
 * @date: 2019/4/19 下午5:38
 * @mofified By:
 */
public class Salary extends Employee{

    //Annual salary（年产量）
    private double salary;

    public Salary(String name, String address, int number, double
            salary) {
        super(name, address, number);
        setSalary(salary);
    }

    @Override
    public void mailCheck() {
        System.out.println("Within mailCheck of Salary class ");
        System.out.println("Mailing check to " + getName()
                + " with salary " + salary);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double newSalary) {
        if (newSalary >= 0.0) {
            salary = newSalary;
        }
    }

    @Override
    public double computePay() {
        System.out.println("Computing salary pay for " + getName());
        return salary / 52;
    }
}
