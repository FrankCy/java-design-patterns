# Java —— Observer 观察者模式 #
**行为型模式**
- **```当对象存在一对多时，使用观察者模式(Observer Pattern)。 一个对象被修改时，则会自动通知它的依赖对象；```**
- **```发送状态变化通知；```**
## 简介 ##
Observer “进行观察的人”，即“观察者”的意思。
在观察者模式中，当观察对象的状态发生变化时，会通知给观察者。```Observer 模式适用于根据对象状态进行相应处理的场景。```

```定义对象间的一种一对多的依赖关系，当一个对象的状态发生改变时，所有依赖于它的对象都得到通知并被自动更新。```
## 用处 ##
一个对象状态改变给其他对象通知的问题，而且要考虑到易用和低耦合，保证高度的协作。
## 简单例子 ##
| 类名 | 说明 |
|:--|:--|
| Observer | 表示观察者的接口 |
| NumberGenerator | 表示生成数值的对象的抽象类 |
| RandomNumberGenerator | 生成随机数类 |
| DigitObserver | 表示以数字形式显示数值的类 |
| GraphObserver | 表示以简单的图示形式显示数值的类 |
| Main | 测试程序 |

- Observer 接口
“观察者”接口，具体观察者会实现这个接口。
```在此，这个Observer接口的作用是，便于我们理解Observer示例程序而编写的，它与Java类库中的java.util.Observer接口不同。```
用于生成数值的NumberGenerator类会调用update方法。```Generator有“生成器”、“产生器”的意思。```调用update方法，NumberGenerator类就会将“生成的数值发生变化，请更新显示内容”的通知发给Observer。
```java
public interface Observer {

    public abstract void update (NumberGenerator generator);

}
```
- NumberGenerator
```用于生成数值的抽象类。```生成数值的方法(execute方法)和获取数值的方法(getNumber方法)都是抽象方法，需要子类去实现。
observer字段中保存有观察NumberGenerator的Observer们。
addObserver 方法用于注册Observer，而deleteObserver方法用于删除Observer。
notifyObservers方法会向所有的Observer发送通知，告诉它们“我生成的数值发生了变化，请更新显示内容”。该方法会调用每个Observer的update方法。
```java
public abstract class NumberGenerator {

    /**
     * 保存所有Observer
     */
    private ArrayList<Observer> observers = new ArrayList();

    /**
     * 注册observer
     * @param observer
     */
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     *  删除Observer
     * @param observer
     */
    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * 向所有Observer发送通知
     */
    public void notifyObservers() {
        Iterator it = observers.iterator();
        while ( it.hasNext()) {
            Observer observer = (Observer) it.next();
            observer.update(this);
        }
    }

    /**
     * 获取数值
     * @return
     */
    public abstract int getNumber();

    /**
     * 生成数值
     */
    public abstract void execute();

}
```

- RandomNumberGenerator
```NumberGenerator的子类，会生成随机数。```
random是java.util.Random的实例（随机数生成器）。number保存当前生成的随机数。
getNumber方法用于获取number字段的值。
execute方法会生成20个随机数（0 ~ 49的整数），并```通过notifyObservers方法把每次生成结果通知观察者。```这里使用的nextInt方法是java.util.Random类的方法，它的功能是返回下一个随机整数值（取值范围大于0，小于指定值）。
```java
public class RandomNumberGenerator extends NumberGenerator {

    /**
     * 随机数生成器
     */
    private Random random = new Random();

    /**
     * 当前数值
     */
    private int number;

    /**
     * 获取当前数值
     * @return
     */
    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void execute() {
        for(int i=0; i<20; i++) {
            number = random.nextInt(50);
            notifyObservers();
        }
    }

}
```

- DigitObserver
```实现Observer接口，功能是以数字形式显示观察到的数值。```
update方法接收NumberGenerator的实例作为参数，然后通过调用NumberGenerator类的实例的getNumber方法可以可以获取当前数值，并输出这个数值。
```为了看清它是如何显示数值的，这里使用Tread.sleep来降低了程序运行速度。```
```java
public class DigitObserver implements Observer {

    @Override
    public void update(NumberGenerator generator) {
        System.out.println("DigitObserver : " + generator.getNumber());
        try{
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
```
- GraphObserver
```实现Observer接口。该类会将观察到的数值以 ***** 这样的简单图示的形式显示出来；```
```java
public class GraphObserver implements Observer {
    @Override
    public void update(NumberGenerator generator) {
        System.out.println(" ==== GraphObserver ===");
        int count = generator.getNumber();

        for(int i=0; i<count; i++) {
            System.out.print("*");
        }

        System.out.println("");
        try {
            Thread.sleep(100);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```

- Main
测试类，生成一个RandomNumberGenerator类的实例和两个观察者，其中observer1 是DigitObserver类的实例，observer2 是 GraphObserver类的实例。
在使用addObserver注册观察者后，它还会调用generator.execute()方法生成随机数。
```java
public class Main {
    public static void main(String[] args) {
        // 通过观察角色获取具体的观察者
        NumberGenerator generator = new RandomNumberGenerator();
        Observer observer1 = new DigitObserver();
        Observer observer2 = new GraphObserver();
        // 通过addObserver方法注册多个Observer
        generator.addObserver(observer1);
        generator.addObserver(observer2);
        // 执行具体观察者execute函数，向所有的Observer发送通知
        generator.execute();
    }
}
```
- 运行结果
```shell
DigitObserver : 42
 ==== GraphObserver ===
******************************************
DigitObserver : 25
 ==== GraphObserver ===
*************************
DigitObserver : 24
 ==== GraphObserver ===
************************
DigitObserver : 23
 ==== GraphObserver ===
***********************
DigitObserver : 41
 ==== GraphObserver ===
*****************************************
DigitObserver : 27
 ==== GraphObserver ===
***************************
DigitObserver : 12
 ==== GraphObserver ===
************
DigitObserver : 42
 ==== GraphObserver ===
******************************************
DigitObserver : 26
 ==== GraphObserver ===
**************************
DigitObserver : 18
 ==== GraphObserver ===
******************
DigitObserver : 40
 ==== GraphObserver ===
****************************************
DigitObserver : 45
 ==== GraphObserver ===
*********************************************
DigitObserver : 20
 ==== GraphObserver ===
********************
DigitObserver : 33
 ==== GraphObserver ===
*********************************
DigitObserver : 23
 ==== GraphObserver ===
***********************
DigitObserver : 34
 ==== GraphObserver ===
**********************************
DigitObserver : 47
 ==== GraphObserver ===
***********************************************
DigitObserver : 32
 ==== GraphObserver ===
********************************
DigitObserver : 15
 ==== GraphObserver ===
***************
DigitObserver : 31
 ==== GraphObserver ===
*******************************
```

- Main时序图
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190417175151939.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9mcmFua3lvdW5nLmJsb2cuY3Nkbi5uZXQ=,size_16,color_FFFFFF,t_70)

## 涉及角色 ##
- Subject（观察角色）
表示观察对象。```定义注册观察者和删除观察者的方法。```此外，它还声明了“获取现在的状态”的方法。
示例中，由NumberGenerator代表此角色。

- ConcreteSubject（具体的观察对象）
表示具体的被观察对象。```自身状态发生变化后，会通知素有已注册的Observer角色。```
示例中，RandomNumberGenerator代表此角色。

- Observer（观察者）
负责```接收来自 Subject 角色的状态变化通知。```为此，声明了update方法。
示例中，由Observer接口代表此角色。

- ConcreteObserver（具体的观察者）
表示具体的Observer。当```update方法被调用后，会去获取观察的对象的最新状态。```
示例中，由DigitObserver类和GraphObserver类代表此角色。

## 要点 ##
### 这里也出现了可替换性 ###
- 利用抽象类和接口从具体类中抽出抽象方法。
- 在将实例作为参数传递至类中，或者在类的字段中保存实例时，不使用具体类型，而是使用抽象类型和接口。
### Observer的顺序 ###
### 当Observer的行为会对Subject产生影响时 ###
### 传递更新信息的方式 ###
### 从“观察”变为“通知” ###
### MVC（Model / View / Controller） ###

## 相关的设计模式 ##
- Mediator 中介者模式

## 应用实例 ##
- 拍卖
拍卖师观察最高标价，然后通知给其他竞拍者竞价。
- 比喻
西游记，孙悟空请菩萨降服红孩儿，菩萨洒一地水找来一只乌龟，乌龟就是观察者，他观察菩萨洒水的动作。
### 优点 ###
- 观察者和被观察者是抽象耦合的。
- 建立一套触发机制。
### 缺点 ###
- 一个被观察者对象有很多的直接和间接的观察者的话，将所有的观察者都通知到会花费很多时间。
- 如果在观察者和观察目标之间有循环依赖的话，观察目标会触发它们之间进行循环调用，可能导致系统崩溃。
- 观察者模式没有相应的机制让观察者知道所观察的目标对象是怎么发生变化的，而仅仅只是知道观察目标发生了变化。
## 使用场景 ##
- 一个抽象模型有两个方面，其中一个方面依赖于另一个方面。将这些方面封装在独立的对象中使它们可以各自独立地改变和复用。
- 一个对象的改变将导致其他一个或多个对象也发生改变，而不知道具体有多少对象将发生改变，可以降低对象之间的耦合度。
- 一个对象必须通知其他对象，而并不知道这些对象是谁。
- 需要在系统中创建一个触发链，A对象的行为将影响B对象，B对象的行为将影响C对象……，可以使用观察者模式创建一种链式触发机制。

## 注意事项 ##
- JAVA 中已经有了对观察者模式的支持类。
- 避免循环引用。
- 如果顺序执行，某一观察者错误会导致系统卡壳，一般采用异步方式。

## 代码 ##
[GitHub —— Observer 观察者模式](https://github.com/FrankCy/java-design-patterns/tree/master/Observer)