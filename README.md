## 设计模式
### 1. 策略模式（strategy pattern）
一个类中容易变化的部分 可以抽离成类的一个属性，使用组合方式。
组合优于继承，继承有利于代码复用，组合的可扩展性更强。

* 策略接口(武器的行为接口)
* 具体的策略实现这个接口(小刀武器，宝剑武器 ...)
* 使用策略的类, 将策略作为属性（角色类）

个人认为书中的策略模式举的例子不是很好~

### 2. 观察者模式(Observer pattern)
一个类想要快速的知道另一个类的数据改变。主要的思想是：
将观察者类的对象 作为成员变量 交给主题类进行管理，当主题类发生变化时，
调用自身属性中维护的观察者列表对应的执行方法。

需要注意的是：通常观察者类中会含有一个主题类的引用，
同时注册观察者，其实是通过观察者内部的 主题类引用进行 注册。

* 主题接口：其中含有：添加观察者，删除观察者，通知观察者的方法。
* 主题接口实现：其中含有具体管理 观察者的数据结构（通常使用一个list），
来实现添加、删除、通知观察者。
* 观察者接口：包含一个通知的方法，用于在主题中被调用。
* 观察者获取数据存在：拉（观察者自己通过主题的引用获取数据） 
和 推（主题调用观察者的通知方法，通过参数传递给观察者）两种模式。

**问题：如果观察者中保存了一份主题的引用，那么观察者可能会通过这个引用执行了很多越权的事情，
比如：调用通知所有的观察者的方法 或者 删除了其他的观察者。** 这种问题如何处理呢？

### 3. 装饰器模式(Decorator pattern)

以jdk中的InputStream为例：
* 抽象组件（InputStream类）: 抽象组件是一个抽象类 或者 接口，定义了相应的方法。
```java
abstract class InputStream{
  // 抽象的read方法
  abstract int read();
  
  ......
}
```
* 具体组件：对抽象组件的实现，实现了某些具体功能。
  * FileInputStream: 实现了读取文件的功能。
  * ByteArrayInputStream: 实现了读取字节数组的功能。

```java
import java.io.InputStream;

class FileInputStream extends InputStream {

  @Override
  public int read() {
    // 对read方法进行实现
    ......
  }
}
```
* 抽象装饰器（FilterInputStream）：**含有一个抽象组件的引用的属性**，
对抽象组件中方法(例如：read() 方法)进行实现(也可以不实现，留给具体的装饰器实现)，
如果实现是通过抽象组件的引用实现的。

```java
import java.io.InputStream;

class FilterInputStream extends InputStream {

  // in 指向一个具体的组件
  private InputStream in;

  // 通过构造函数传入具体的组件
  pulbic FilterInputStream(InputStream in) {
    this.in = in;
  }
  ......

  // 该方法可实现 也可不实现
  @Override
  public int read() {
    // 调用 具体组件的read方法
    in.read();
  }
  ......
}

```
* 装饰器(LowerCaseInputStream)：继承(或实现) 抽象装饰器，重写(或实现) 抽象装饰器中的方法。
```java
class LowerCaseInputStream extends FilterInputStream{
  public LowCaseInputStream(InputStream in){
    super(in);
  }
  
  @Override
  public int read(){
    // 借助被包装的 具体组件的 in.read() 实现当前类的read方法
    ......
  }
}
```

