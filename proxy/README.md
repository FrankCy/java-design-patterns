# 代理模式 #
## 简介 ##
**```代理模式：接口 + 真是实现类 + 代理类```**
## 各自角色 ##
### 买辣条例子 ###
- Friend 代理类
- BuySpicyStrips 接口
- Shopowner 真实实现类
- BuySpicyStripsTest 测试类<br/>

执行结果
```shell
Frank 正在商店!
店长到辣条厂家进货。
店长买到辣条。
店长正在零售。
Frank 买到辣条正在去送给 Nancy !
```

### 打印机例子 ###
- Printer 表示带名字的打印机的类（本人）
- Printable Printer 和 PrinterProxy 的共同接口
- printerProxy 表示带名字的打印机的类（代理人）
- PrinterTest 测试类<br/>

执行结果
```shell
现在的名字是：Alice.
现在的名字是：Bob.
正在生成 Printer 的实例(Bob)....Disconnected from the target VM, address: '127.0.0.1:61575', transport: 'socket'
.结束。
 === Bob ===
Hello, World.
```