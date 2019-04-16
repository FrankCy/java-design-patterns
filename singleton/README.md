# Java —— Singleton 单例模式 #
**创造型模式**
- **```想确保任何情况下都绝对只有1个实例```**
- **```想在程序上表现出“只存在一个实例”```**
## 简介 ##
单例模式涉及到一个单一的类，该类负责创建自己的对象，同时确保只有单个对象被创建。这个类提供了一种访问其唯一的对象的方式，可以直接访问，不需要实例化该类的对象。
### 注意 ###
- 1、单例类只能有一个实例。
- 2、单例类必须自己创建自己的唯一实例。
- 3、单例类必须给所有其他对象提供这一实例。
## 用处 ##
当想控制实例数目，节省系统资源的时候。可以解决一个全局使用的类频繁地创建与销毁的问题。
## 简单例子 ##
### 基础示例 ###
- Singleton类
```java
public class SingleObject {

    /**
     * 创建 SingleObject 的一个对象
     */
    private static SingleObject instance = new SingleObject();

    /**
     * 让构造函数为 private，这样该类就不会被实例化
     */
    private SingleObject(){}

    /**
     * 获取唯一可用的对象
     * @return
     */
    public static SingleObject getInstance(){
        return instance;
    }

    public void showMessage(){
        System.out.println("Hello World!");
    }

}
```
- 测试类
```java
public class SingletonPatternDemo {

    public static void main(String[] args) {
        //不合法的构造函数
        //编译时错误：构造函数 SingleObject() 是不可见的
        //SingleObject object = new SingleObject();

        //获取唯一可用的对象
        SingleObject object = SingleObject.getInstance();

        //显示消息
        object.showMessage();
    }

}
```
- 运行结果
```shell
Hello World!
```
### 懒汉式（线程不安全） ###
Lazy 初始化：是
多线程安全：否

```最大的问题就是不支持多线程。因为没有加锁 synchronized，所以严格意义上它并不算单例模式。```
这种方式 lazy loading 很明显，不要求线程安全，在```多线程不能正常工作。```
```java
public class Singleton {

    private static Singleton instance;

    private Singleton (){}

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

}
```
### 懒汉式（线程安全） ###
Lazy 初始化：是
多线程安全：是
这种方式具备很好的 lazy loading（懒加载），能够在多线程中很好的工作，但是，效率很低，99% 情况下不需要同步。
- 优点
第一次调用才初始化，避免内存浪费。
- 缺点
必须加锁 synchronized 才能保证单例，但加锁会影响效率。
```java
public class Singleton1 {

    private static Singleton1 instance;

    private Singleton1 (){}

    /**
     * 与懒汉式加载（线程不安全但区别在于使用了 synchronized 声明）
     * @return
     */
    public static synchronized Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }

}
```
### 饿汉式 ###
Lazy 初始化：是
多线程安全：是
这种方式```比较常用```，但```容易产生垃圾对象```。
- 优点
没有加锁，执行效率会提高。
- 缺点
类加载时就初始化，浪费内存。

```基于 classloader 机制避免了多线程的同步问题，不过，instance 在类装载时就实例化，虽然导致类装载的原因有很多种，在单例模式中大多数都是调用 getInstance 方法， 但是也不能确定有其他的方式（或者其他的静态方法）导致类装载，这时候初始化 instance 显然没有达到 lazy loading 的效果。```
```java
public class Singleton2 {
	// instance 在类装载时就实例化
    private static Singleton2 instance = new Singleton2();

    private Singleton2 (){}

    public static Singleton2 getInstance() {
        return instance;
    }

}
```
### 双检索 / 双重校验锁（DCL，即 double-checked locking） ###
JDK 版本：1.5起
Lazy 初始化：是
多线程安全：是
这种方式```采用双锁机制，安全且在多线程情况下能保持高性能。```
getInstance() 的性能对应用程序很关键。
```java
public class Singleton3 {

    /**
     * volatile 修饰的成员变量在每次被线程访问时，都强制从共享内存中重新读取该成员变量的值
     */
    private volatile static Singleton3 Singleton3;

    private Singleton3 (){}

    public static Singleton3 getSingleton3() {
        if (Singleton3 == null) {
            /**
             * synchronized 关键字声明的方法同一时间只能被一个线程访问。
             */
            synchronized (Singleton3.class) {
                if (Singleton3 == null) {
                    Singleton3 = new Singleton3();
                }
            }
        }
        return Singleton3;
    }

}
```

### 登记式/静态内部类 ###
Lazy 初始化：是
多线程安全：是
```达到双检锁方式一样的功效，但实现更简单。```
对静态域使用延迟初始化，应使用这种方式而不是双检锁方式。这种方式只适用于静态域的情况，双检锁方式可在实例域需要延迟初始化时使用。
这种方式同样利用了 classloader 机制来保证初始化 instance 时只有一个线程，它跟第 **```饿汉式```** 种方式不同的是： **```饿汉式```** 方式只要 Singleton 类被装载了，那么 instance 就会被实例化（没有达到 lazy loading 效果），而这种方式是 Singleton 类被装载了，instance 不一定被初始化。因为 SingletonHolder 类没有被主动使用，只有通过显式调用 getInstance 方法时，才会显式装载 SingletonHolder 类，从而实例化 instance。想象一下，如果实例化 instance 很消耗资源，所以想让它延迟加载，另外一方面，又不希望在 Singleton 类加载时就实例化，因为不能确保 Singleton 类还可能在其他的地方被主动使用从而被加载，那么这个时候实例化 instance 显然是不合适的。这个时候，这种方式相比 **```饿汉式```** 方式就显得很合理。
```java
public class Singleton4 {

    private static class Singleton4Holder {
        private static final Singleton4 INSTANCE = new Singleton4();
    }

    private Singleton4 (){}

    /**
     * 当Singleton使用时，不会初始化 INSTANCE，只有在实际调用getInstance()时，才会初始化对象。
     * @return
     */
    public static final Singleton4 getInstance() {
        return Singleton4Holder.INSTANCE;
    }
}
```
### 枚举 ###
Lazy 初始化：否
多线程安全：是
```实现单例模式的最佳方法[runoob推荐]```。它更简洁，自动支持序列化机制，绝对防止多次实例化。
这种方式是 Effective Java 作者 Josh Bloch 提倡的方式，它```不仅能避免多线程同步问题，而且还自动支持序列化机制，防止反序列化重新创建新的对象，绝对防止多次实例化。```不过，由于 JDK1.5 之后才加入 enum 特性，用这种方式写不免让人感觉生疏，在实际工作中，也很少用。
不能通过 reflection attack 来调用私有构造方法。
```java
public enum Singleton5 {

    INSTANCE;

    public void whateverMethod() {

    }
}
```

**```推荐：一般情况下，不建议使用前两种懒汉方式，建议使用饿汉方式。只有在要明确实现 lazy loading 效果时，才会使用登记方式。如果涉及到反序列化创建对象时，可以尝试使用枚举方式。如果有其他特殊的需求，可以考虑使用双检锁方式。```**

## 涉及角色 ##
- Singleton
单例模式中，只有Singleton一个角色。
Singleton角色中有一个返回唯一实例的```static方法```。该方法总是会返回一个实例。
## 要点 ##
### 构造函数 ###
构造函数一定要是私有的。
## 相关的设计模式 ##
- AbstractFactory 抽象工厂模式
- Builder 建造者模式
- Facade 外观模式
- Prototype 原型模式
## 应用实例 ##
- 一个班级只有一个班主任。
- 多进程多线程环境下，出现多个进程或线程操作同一个文件的现象，所有的文件处理必须通过唯一的实例来进行。
- 一些设备管理器通常会被设置为单例模式，比如一个电脑有两台打印机，在输出的时候就要处理，不能两台打印机打印同一个文件。
- 饿了要吃饭也是一个单例，不同菜系的菜馆都可以满足我填饱肚子的需求，在真的走进菜馆吃饭的话，不能同时去多个菜馆消费填饱肚子。
### 优点 ###
- 1、内存只有一个实例，减少内存开销，尤其频繁创建和销毁实例（比如页面缓存）。
- 2、避免对资源的多重占用（比如写文件操作）。

## 使用场景 ##
- 1、要求生产唯一序列号。
- 2、WEB中的计数器，不用每次刷新都在数据库里加一次，用单例先缓存起来。
- 3、创建的一个对象需要消耗的资源过多，比如 I/O 与数据库的连接等。

**```注意事项：getInstance() 方法中需要使用同步锁 synchronized (Singleton.class) 防止多线程同时进入造成 instance 被多次实例化。```**
## 代码 ##
[GitHub —— Singleton 单例模式](https://github.com/FrankCy/java-design-patterns/tree/master/singleton)