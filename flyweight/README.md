# Java —— Flyweight 享元模式 #
```结构型模式```<br/>
```Flyweight  【/'flaɪweɪt/ 轻量级的】```<br/>
```共享对象，避免浪费。```<br/>
## 简介 ##
通过尽量共享实例来避免new出实例，主要用于减少创建对象和数量，以减少内存占用和提高性能。
<br/>```当需要某个实例时，不通过new生成实例，尽量共用已存在当实例。这就是Flyweight模式的核心内容。```
## 用处 ##
- 系统中有大量对象。
- 这些对象消耗大量内存。
- 这些对象的状态大部分可以外部化。
- 这些对象可以按照内蕴状态分为很多组，当把外蕴对象从对象中剔除出来时，每一组对象都可以用一个对象代替。
- 系统不依赖这些对象身份，这些对象是不可分辨的。

## 简单例子 ##
**获取指定颜色的圆，如果有就获取，如果没有就画一个。**
- Shape 绘画接口
```java
public interface Shape {

    /**
     * 绘画
     */
    void draw();

}
```

- Circle 圆对象
```java
public class Circle implements Shape {

    private String color;

    private int x;

    private int y;

    private int radius;

    public Circle(String color){
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Circle: Draw() [Color : " + color
                +", x : " + x +", y :" + y +", radius :" + radius);
    }
}
```

- ShapeFactory 画画的工厂，有的话就取出来，没有就画一个
```java
public class ShapeFactory {

    private static final HashMap<String, Shape> circleMap = new HashMap<>();

    public static Shape getCircle(String color) {
        Circle circle = (Circle)circleMap.get(color);

        if(circle == null) {
            circle = new Circle(color);
            circleMap.put(color, circle);
            System.out.println("Creating circle of color : " + color);
        }
        return circle;
    }

}
```

- FlyweightPatternDemo 测试类
```java
public class FlyweightPatternDemo {

    private static final String[] COLORS = {"Red", "Green", "Blue", "White", "Black"};

    public static void main(String[] args) {
        for(int i=0; i < 20; ++i) {
            Circle circle = (Circle) ShapeFactory.getCircle(getRandomColor());
            circle.setX(getRandomX());
            circle.setY(getRandomY());
            circle.setRadius(100);
            circle.draw();
        }
    }

    private static String getRandomColor() {
        return COLORS[(int)(Math.random()*COLORS.length)];
    }

    private static int getRandomX() {
        return (int)(Math.random()*100 );
    }

    private static int getRandomY() {
        return (int)(Math.random()*100);
    }

}
```
- 执行结果
```shell
Creating circle of color : White
Circle: Draw() [Color : White, x : 44, y :6, radius :100
Creating circle of color : Green
Circle: Draw() [Color : Green, x : 81, y :25, radius :100
Creating circle of color : Red
Circle: Draw() [Color : Red, x : 72, y :59, radius :100
Circle: Draw() [Color : Green, x : 87, y :99, radius :100
Creating circle of color : Blue
Circle: Draw() [Color : Blue, x : 69, y :52, radius :100
Circle: Draw() [Color : Green, x : 29, y :65, radius :100
Circle: Draw() [Color : Green, x : 70, y :20, radius :100
Circle: Draw() [Color : White, x : 43, y :44, radius :100
Circle: Draw() [Color : Blue, x : 4, y :46, radius :100
Circle: Draw() [Color : Red, x : 31, y :47, radius :100
Circle: Draw() [Color : White, x : 40, y :65, radius :100
Creating circle of color : Black
Circle: Draw() [Color : Black, x : 11, y :99, radius :100
Circle: Draw() [Color : Green, x : 20, y :5, radius :100
Circle: Draw() [Color : Blue, x : 37, y :90, radius :100
Circle: Draw() [Color : Blue, x : 3, y :89, radius :100
Circle: Draw() [Color : Green, x : 81, y :30, radius :100
Circle: Draw() [Color : Blue, x : 63, y :16, radius :100
Circle: Draw() [Color : Black, x : 83, y :33, radius :100
Circle: Draw() [Color : Green, x : 63, y :3, radius :100
Circle: Draw() [Color : Red, x : 90, y :39, radius :100
```

## 要点 ##
### 对多个地方产生影响 ###
Flyweight模式核心的 **“共享”**，<br/>```如果要改变被共享的对象，就会对多个地方产生影响。```
### Intrinsic 与 Extrinsic ###
**内在与外在，也叫内蕴和外蕴。**
“应当共享的信息和不应当共享的信息是的专有名词。”
- Intrinsic
 ```应当共享的信息被称为Intrinsic信息。```
 不依赖于位置与状况，可以共享。
- Extrinsic
 ```不应当共享的信息被称为Extrinsic信息。```
 依赖于位置与状况，不能共享。

### 不要让被共享实例被垃圾回收器回收了 ###
```Java垃圾回收器，通过new关键字分配空间，如果分配了过多的内存，就会导致内存不足。然后Java虚拟机就会开始垃圾回收处理。```
**```所以在程序设计时，一定要考虑到共享实例的设计，“不要让被共享实例被垃圾回收器回收了”```**
### 内存之外的其它资源 ###
除了内存资源以外，```时间也是一种资源，new关键字生成实例会花费时间。通过Flyweight模式共享实例可以减少使用new关键字生成实例次数。提高程序运行速度。```
## 相关的设计模式 ##
- Proxy 代理模式
生成实例需要花费较长时间，使用Flyweight模式可以提高程序处理的速度。
而```Proxy 代理模式是通过设置代理提高程序的处理速度```。
- Composite 组合模式
```有时可以使用Flyweight模式共享Composite模式中的Leaf角色。```
## 代码 ##
[GitHub —— Flyweight 模式](https://github.com/FrankCy/java-design-patterns/tree/master/flyweight)

