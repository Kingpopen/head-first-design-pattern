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

```java
import com.kingpopen.observerpattern.normal.Observer;

interface Subject {

  // 添加
  addObserver(Observer observer);

  // 移除
  removeObserver(Observer observer);
  
  // 通知
  notifyObserver();
}
```
* 观察者接口：包含一个通知的方法，用于在主题中被调用。
* 观察者获取数据存在：拉（观察者自己通过主题的引用获取数据） 
和 推（主题调用观察者的通知方法，通过参数传递给观察者）两种模式。

```java
interface Observer {

  // 通知
  void notify();
}

class AObserver implements Observer{
  // 主题的引用
  private Subject subject;
  ......
  @Override
  void notify(){
    ......
  }
}
```

**问题：如果观察者中保存了一份主题的引用，那么观察者可能会通过这个引用执行了很多越权的事情，
比如：调用通知所有的观察者的方法 或者 删除了其他的观察者。** 这种问题如何处理呢？

### 3. 装饰器模式(Decorator pattern)
一个类A想要动态的扩展另一个类B的功能(func)的时候，可以将类B作为类A的成员变量，
然后在类A中的func里面：调用类B的func 进行功能的扩展。

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
### 4. 工厂模式
一个A类中需要创建B类，为了将创建的过程 和 A类的业务逻辑解耦，可以采用工厂模式对B类进行创建。
#### 4.1 简单工厂
* 产品: 有一个抽象的产品类接口（本书中是披萨接口类），所有的具体产品类都实现这个产品接口（芝士披萨、蛤俐披萨等等）。
* 创建者: 只有一个具体的创建者类。
#### 4.2 工厂方法
可能存在不同的创建者 有不同的创建规则，因此可以使用工厂方法设计模式

* 产品: 有一个抽象的产品类接口，每个具体的产品实现这个产品接口。
* 创建者: 也有一个抽象的创建者接口（本书中是 披萨店），每个具体的创建者实现创建者接口（有纽约的披萨店、芝加哥的披萨店等）
**本书中还采用 模版方法 设计模式，将下单披萨的过程生成一个模版。**
#### 4.3 抽象工厂
产品还可能是一个产品族，因此会有多个产品接口，可以使用抽象工厂设计模式。
* 原材料族: 一个披萨依赖多种原材料（面团、蛤俐、芝士等等），每个原材料都是一个接口
同时，每个原材料接口都有多个实现（厚面团、薄面团、冻蛤俐、新鲜蛤俐等等）
* 原材料创建者: 存在一个原材料的创建者接口，其中包含了所有的创建原材料方法(createDough, createClam, createCheese等等)
具体的原材料创建者（纽约原材料创建者，芝加哥原材料创建者 等等）实现这些接口。
原材料族 和 原材料创建者之间是使用的 抽象工厂设计模式。
* 披萨: 披萨也是一个接口，它依赖于原材料创建者，具体的披萨（芝士披萨、蛤俐披萨等等）实现这个披萨接口。
* 披萨店: 披萨店也是一个接口，具体的披萨店（纽约披萨店、芝加哥披萨店等等）实现这个披萨店接口
披萨店（创建者） 和 披萨（产品） 之间感觉是工厂方法设计模式。

这个代码整体还是有些复杂，我觉得举数据库的例子比较容易理解 抽象工厂。
产品族：数据库连接接口（connection） 数据库statement接口
* connection接口实现：mysql connection，oracle connection
* statement接口实现：mysql statement， oracle statement

创建者：创建者接口中含有 创建connection 和 创建 statement的方法。
```java
interface AbstractFactory{
  Connection createConnection();
  Statement createStatement();
}
```
这种模式的缺点就是：当需要新加一个产品接口的时候会有些复杂，需要在创建者接口中添加一个方法，

所有的具体创建者实现类又要实现这个方法，改动会比较大。

### 5. 单例模式
确保一个类只有一个实例，并给全局进行访问。
* 构造函数必须是私有
* 引用必须是volatile + static, volatile保证了引用的可见性，但不能保证原子性。
* 实例化方法内部必须使用锁
```java
public class Singleton {
  // 单例的引用(volatile + 静态)
  private volatile static Singleton singletonInstance;

  // 私有的构造函数
  private Singleton(){
    // 在多线程获取单例的情况下， 只会被初始化一次
    log.info("Singleton的实例被创建!");
  }

  // 双重检查锁
  public static Singleton getSingletonInstance() {
    if (Objects.isNull(singletonInstance)){
      // 使用类对象作为锁 保证同步
      synchronized (Singleton.class){
        // 再一次判断
        if (Objects.isNull(singletonInstance)){
          singletonInstance = new Singleton();
        }
      }
    }
    // singletonInstance不为null 就不用抢占锁 减少性能开销
    return singletonInstance;
  }
}
```

### 6.命令模式
将请求封装成对象，以便使用不同的请求、队列或者日志来参数化其他对象。
* 命令接口：定义了命令的执行方法(Command)
```java
interface Command{
  void execute();
} 
```
* 具体命令：实现命令接口，例如：打开电灯的命令(LightOnCommand)、关闭电灯的命令(LightOffCommand)
命令类的实现类中会含有一个执行者的引用，用于实现具体的执行操作。
```java
class LightOnCommand implements Command{
  private Light light;
  ......
  @Override
  void execute(){
    light.on();
  }
}
```
* 命令的执行者：命令的具体执行对象，例如：电灯(Light)
```java
class Light{
  void on(){
    ......
  }
}
```
* 命令的调用者：调用命令的对象，其中含有命令属性，例如：遥控器(RemoteControl)
```java
class RemoteControl{
  private Command command;
  ......
  
  void buttonOn(){
    command.execute();
  }
}
```
给我的感觉就是：命令的调用者不直接操作命令的执行者，将两者接耦开来。（之前没怎么使用过。）
应用场景：任务队列，日志等等。
日志的例子：日志的记录是一个命令，日志的执行者是一个日志类，日志的调用者是一个业务类。