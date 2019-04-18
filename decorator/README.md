# Java —— Decorator 装饰器模式 #
**结构型模式**
**装饰边框与被装饰物的一致性**
## 简介 ##
首先看一个比喻：
假设有一块蛋糕，涂上奶油，其它什么有不加，就是奶油蛋糕。如果加上草莓，就是草莓蛋糕。如果```再```加上一块黑色巧克力，上面用白色巧克力写上名，然后插上蜡烛，就变成一块生日蛋糕。
无论是蛋糕、奶油蛋糕、草莓蛋糕还是生日蛋糕，它们的核心都是蛋糕。
- **```允许一个现有对象，添加新的功能，同时，不改变其结构。```**
- **```这种模式创建了一个装饰类，用来包装原有的类，并在保持类方法签名完整性的前提下，提供了额外的功能。```**
## 用处 ##
动态地给一个对象添加一些额外的指责。就增加功能来说，装饰器模式较生成子类更为灵活。
## 简单例子 ##
**示例中的程序功能是给文字添加装饰边框。这里所谓的装饰边框是指用“-” 、“+” 、“|” 等字符组成的边框：**
```shell
+-------------+
| Hello,world.|
+-------------+
```

### 结构 ###
|  | 说明 |
|:--|:--|
| Display | 用于显示字符串的抽象类 |
| StringDisplay | 用于显示单行字符串的类 |
| Border | 用于显示装饰边框的抽象类 |
| SideBorder | 用于显示左右边框的类 |
| FullBorder | 用于显示上下左右边框的类 |
| Main | 测试类 |

### 代码 ###
- Display
**显示多行字符串的抽象类**
```java
public abstract class Display {

    /**
     * 获取横向字符数
     * @return
     */
    public abstract int getColumns();

    /**
     * 获取纵向行数
     * @return
     */
    public abstract int getRows();

    /**
     * 获取row行的字符串
     * @param row
     * @return
     */
    public abstract String getRowText(int row);


    /**
     * 显示全部
     */
    public final void show() {
        for(int i=0; i<getRows(); i++) {
            System.out.println(getRowText(i));
        }
    }

}

```
- StringDisplay
**显示单行字符串的类，肩负着Display类中声明的抽象方法**
```java
public class StringDisplay extends Display {

    /**
     * 要显示的字符串
     */
    private String string;

    /**
     * 通过参数传入显示的字符串
     * @return
     */
    public StringDisplay(String string) {
        this.string = string;
    }

    /**
     * 字节数
     * @return
     */
    @Override
    public int getColumns() {
        return string.getBytes().length;
    }

    /**
     * 行数是1
     * @return
     */
    @Override
    public int getRows() {
        return 1;
    }

    /**
     * 仅当row为0时返回值
     * @param row
     * @return
     */
    @Override
    public String getRowText(int row) {
        if(row == 0) {
            return string;
        } else {
            return null;
        }
    }
}
```
- Border
**装饰边框的抽象类【通过继承，装饰边框与被装饰物具有了相同的方法】**
```java
public abstract class Border extends Display {

    /**
     * 表示被装饰物
     */
    protected Display display;

    /**
     * 在生成实例时通过参数指定被装饰物
     * @param display
     */
    protected Border(Display display) {
        this.display = display;
    }

}
```
- SideBorder
**具体的装饰边框 "|"**
```java
public class SideBorder extends Border {

    /**
     * 表示装饰边框的字符
     */
    private char borderChar;

    /**
     * 通过构造函数指定Display和装饰边框字符
     * @param display
     * @param ch
     */
    public SideBorder(Display display, char ch) {

        super(display);

        this.borderChar = ch;

    }

    /**
     * 字符数为字符串字符数加上两侧边框字符数
     * @return
     */
    @Override
    public int getColumns() {
        return 1 + display.getColumns() + 1;
    }

    /**
     * 行数即被装饰物的行数
     * @return
     */
    @Override
    public int getRows() {
        return display.getRows();
    }

    /**
     * 指定的那一行的字符串为被装饰物的字符串加上两侧的边框的字符
     * @param row
     * @return
     */
    @Override
    public String getRowText(int row) {
        return borderChar + display.getRowText(row) + borderChar;
    }
}
```
- FullBorder
**在字符串上下左右都加上装饰边框**
```java
public class FullBorder extends Border {

    public FullBorder(Display display) {
        super(display);
    }

    /**
     * 字符数为被装饰物的字符数加上两侧边框字符数
     * @return
     */
    @Override
    public int getColumns() {
        return 1 + display.getColumns() + 1;
    }

    /**
     * 行数为被装饰物的行数加上上下边框的行数
     * @return
     */
    @Override
    public int getRows() {
        return 1 + display.getRows() + 1;
    }

    /**
     * 指定的那一行的字符串
     * @param row
     * @return
     */
    @Override
    public String getRowText(int row) {
        if(row == 0) {
            // 下边框
            return "+" + makeLine('-', display.getColumns()) + "+";
        } else
        if(row == display.getRows() + 1) {
            // 上边框
            return "+" + makeLine('-', display.getColumns()) + "+";
        } else {
            // 其它边框
            return "|" + display.getRowText(row - 1) + "|";
        }
    }

    /**
     * 生成一个重复count次字符ch的字符串
     * @param ch
     * @param count
     * @return
     */
    private String makeLine(char ch, int count) {
        StringBuffer buf = new StringBuffer();
        for(int i=0; i<count; i++) {
            buf.append(ch);
        }
        return buf.toString();
    }

}
```
- Main
```java
public class Main {
    public static void main(String[] args) {
        // 显示单行字符串的类（相当于蛋糕的核心蛋糕[蛋糕胚子]）
        Display b1 = new StringDisplay("Hello, world.");

        // 具体的装饰边框 "|"
        Display b2 = new SideBorder(b1, '#');

        // 在字符串上下左右都加上装饰边框
        Display b3 = new FullBorder(b2);

        b1.show();
        b2.show();
        b3.show();
        Display b4 = new SideBorder(
                         new FullBorder(
                             new FullBorder(
                                 new SideBorder(
                                     new FullBorder(
                                         new StringDisplay("你好， 世界。")
                                     ),
                                     '*'
                                 )
                             )
                         ),
                     '/'
                     );
        b4.show();

    }
}
```
- 运行结果
```shell
Hello, world.
#Hello, world.#
+---------------+
|#Hello, world.#|
+---------------+
/+-----------------+/
/|+---------------+|/
/||*+-----------+*||/
/||*|你好， 世界。|*||/
/||*+-----------+*||/
/|+---------------+|/
/+-----------------+/
```
- Main时序图
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190418164304576.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9mcmFua3lvdW5nLmJsb2cuY3Nkbi5uZXQ=,size_16,color_FFFFFF,t_70)
## 涉及角色 ##
- Component
增加功能时核心角色。
以上述比喻来说，装饰前的蛋糕就是Component角色。Component角色只是定义蛋糕的接口（API）。
示例中，由Display代表此角色。
- ConcreteComponent
实现Component角色定义的具体蛋糕。
示例中，StringDisplay代表此角色。
- Decorator（装饰物）
具有与Component角色相同的接口（API）。在它内部保存了被装饰对象 —— Component角色。Decorator知道自己要装饰的对象。
示例中，Border代表此角色。
- ConcreteDecorator（具体的装饰物）
具体的Decorator角色。
示例中，SideBorder和FullBorder代表此角色。

## 相关的设计模式 ##
- Adapter 适配器模式
Decorator装饰器模式可以在不改变被装饰物的接口（API）的前提下，为被装饰物添加边框（透明性）。
Adapter适配器模式用于适配两个不同的接口（API）。
- Strategy 策略模式
Decorator装饰器模式可以像改变被装饰物的边框或是为被装饰物添加多重边框那样，来增加类的功能。
Strategy 策略模式通过整体地替换算法来改变类的功能。
## 应用实例 ##
- 孙悟空有 72 变，当他变成"庙宇"后，他的根本还是一只猴子，但是他又有了庙宇的功能。
- 不论一幅画有没有画框都可以挂在墙上，但是通常都是有画框的，并且实际上是画框被挂在墙上。在挂在墙上之前，画可以被蒙上玻璃，装到框子里；这时画、玻璃和画框形成了一个物体。
### 优点 ###
装饰类和被装饰类可以独立发展，不会相互耦合，装饰模式是继承的一个替代模式，装饰模式可以动态扩展一个实现类的功能。
### 缺点 ###
多层装饰比较复杂。
## 使用场景 ##
- 扩展一个类的功能。
- 动态增加功能，动态撤销。
## 注意事项 ##
可代替继承。
## 代码 ##
[GitHub —— Decorator 装饰器模式](https://github.com/FrankCy/java-design-patterns/tree/master/decorator)
