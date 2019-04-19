package com.frank.dp.basic.absct;

/**
 * @version 1.0
 * @description：员工类（八个方法、三个成员变量）
 * @author: Yang.Chang
 * @project: java-design-patterns
 * @package: com.frank.dp.basic.absct、
 * @email: cy880708@163.com
 * @date: 2019/4/19 下午5:30
 * @mofified By:
 */
public abstract class Employee {

    private String name;

    private String address;

    private int number;

    public Employee(String name, String address, int number) {
        System.out.println("Constructing an Employee");
        this.name = name;
        this.address = address;
        this.number = number;
    }

    public double computePay() {
        System.out.println("Inside Employee computePay");
        return 0.0;
    }

    public void mailCheck() {
        System.out.println("Mailing a check to " + this.name
                + " " + this.address);
    }

    @Override
    public String toString() {
        return name + " " + address + " " + number;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String newAddress) {
        address = newAddress;
    }

    public int getNumber() {
        return number;
    }

}
