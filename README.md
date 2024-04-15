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

### 7. 适配器模式
将一个类的接口转换成客户希望的另一个接口。适配器模式可以让原本由于接口不兼容而不能一起工作的类可以一起工作。

**适配器提供给客户的方法依然是客户希望的方法**，只是该方法的实现是通过调用被适配器的方法实现的。
* 适配器接口类(target)：含有客户希望的接口方法（例如duck的quack()方法）
```java
class Target{
  void quack();
}
```
* 被适配器类(adaptee)：含有客户不希望的接口方法（例如turkey的gobble()方法）
```java
class Adaptee{
  void gobble(){
    ......
  }
}
```
* 适配器实现类(adapter)：实现Target接口，**含有被适配器的引用**
```java
class Adapter implements Target{
  private Adaptee adaptee;
  ......
  @Override
  void quack(){
    adaptee.gobble();
  }
}
```
适配器模式：进行接口的转换，将一个不兼容的接口包装起来，转化为一个兼容的接口。（adapter 和 adaptee 的方法名称不一样）
装饰器模式：给接口添加新的功能。（装饰者 和 被装饰者 的方法名称都是一样）

### 8. 外观模式
提供了一个统一的接口，用来访问子系统中的一群接口。外观定义了一个高层接口，让子系统更容易使用。
外观模式的目的还是方便客户端的使用，将一些复杂的操作封装起来，提供一个简单的接口给客户端。

外观接口：定义了一个高层接口，其中包含了子系统的引用。
```java
class Facade{
  private Component1 component1;
  private Component2 component2;
  ......
  void method(){
    component1.method();
    component2.method();
  }
}
```
和适配器模式的区别：适配器模式是将一个接口转换成另一个接口，外观模式是将一群接口封装成一个接口，简化对接口的调用。

很多设计的思路都是设计一个中间层，将外部 和 内部进行解耦合：
适配器模式的中间层是：适配器接口（target），其中的组件是：被适配器接口（adaptee）
命令模式的中间层是：命令接口（command），其中的组件是：命令的执行者（receiver）
外观模式的中间层是：外观接口（facade），其中的组件是：子系统的接口（component）

### 9. 模板方法模式
定义了一个算法的骨架，将一些步骤的具体实现延迟到子类中。 虽然许多时候 组合要优于 继承，但是继承仍然有许多的好处：减少代码的复用，封装代码的逻辑。
模版方法是平时使用比较多的设计模式，例如平时写业务代码时存在多个repository，其中大部分的主体逻辑是相同的，
只有一些具体的实现有些不同，这时就可以写一个抽象的repository，将相同的逻辑写在抽象类中，将不同的逻辑留给具体的实现类。
模版类(AbstractTemplate)：定义了一个模版方法，其中包含了一些具体的逻辑，以及一些抽象的方法，这些抽象的方法留给子类实现。
**⚠️ 抽象的方法尽量使用protected，对子类可见，对其他类不可见。**
**⚠️ 模版方法使用public + final修饰，对外部可见，同时子类不能重写**
```java
abstract class AbstractTemplate{
  // 模版方法 使用public + final修饰，不允许子类重写
  public final void templateMethod(){
    // 具体的逻辑
    ......
    // 抽象的方法
    abstractMethod();
    // 钩子方法
    hookMethod();
  }
  // 抽象的方法
  protected abstract void abstractMethod();
  
  // 钩子方法
  protected void hookMethod(){
    // 钩子方法是一个空方法，子类可以选择性的重写
  }
}
```
* 具体的实现类(Concrete)：实现了抽象的方法，以及钩子方法。
```java
class Concrete extends AbstractTemplate{
  @Override
  protected void abstractMethod(){
    // 具体的实现
    ......
  }
  
  @Override
  protected void hookMethod(){
    // 钩子方法的具体实现
    ......
  }
}
```
好莱坞原则：不要调用我们，我们会调用你。在模版方法中，父类调用子类的方法，而不是子类调用父类的方法。

### 10. 迭代器模式
提供一种方法顺序访问一个聚合对象中的各个元素，而又不暴露其内部的表示。
* 迭代器接口(Iterator)：定义了迭代器的方法
```java
interface Iterator{
  boolean hasNext();
  Object next();
}
```
* 具体的迭代器实现类(ConcreteIterator)：实现了迭代器接口, 定义了一组迭代的操作
```java
class ConcreteIterator implements Iterator{
  @Override
  boolean hasNext(){
    ......
  }
  @Override
  Object next(){
    ......
  }
}
```
* 聚合接口(Aggregate)：定义了聚合的方法
```java
interface Aggregate{
  // 具体使用哪个迭代器由 子类决定
  Iterator createIterator();
}
```
* 具体的聚合实现类(ConcreteAggregate)：实现了聚合接口
```java
class ConcreteAggregate implements Aggregate{
  
  // 具体使用哪个迭代器由 子类决定
  @Override
  Iterator createIterator(){
    return new ConcreteIterator();
  }
}
```
有一种工厂方法的感觉：
工厂接口 -> 聚合接口
产品接口 -> 迭代器接口

### 11. 组合模式
节点接口: 树中的节点，相当于组合的每个 元素。比如说含有：add方法、remove方法等等
叶子节点：实现 节点接口，不对add方法，remove方法提供功能
普通节点：实现 节点接口，对其中的所有方法进行实现

Todo
外部的迭代器模式：**没太理解，烦死了😡**

### 12. 状态模式
允许对象在内部状态改变时改变它的行为，对象看起来好像修改了它的类。
上下文类(Context): 含有一个状态的引用，用于切换状态。

```java
import com.kingpopen.statepattern.State;
import lombok.extern.slf4j.Slf4j;

class Context {

  // 一个状态的引用
  private State state;

  // 切换状态的方法
  void changeState(State state) {
    this.state = state;
  }
  
  // 给外部调用的方法
  void request() {
    state.handle();
  }
}
```
```java
状态接口(State): 定义了状态中可以执行的方法
```java
interface State{
  void handle();
}
```
具体的状态实现类(ConcreteState): 实现了状态接口，定义了状态的具体行为。
**其中含有一个上下文的引用**
**值得注意的是切换状态的逻辑 是放在了具体的状态类内部，这样减少了耦合性**，需要该逻辑就只需要找到对应的状态类去修改。
```java
class ConcreteState implements State{
  private Context context;
  ......
  @Override
  void handle(){
    // 具体的状态行为
    ......
    // 切换状态
    context.changeState(new ConcreteState());
  }
}
```
### 13. 代理模式（proxy pattern）
代理模式：使用代理模式创建代表，让代表对象控制某个对象的访问，代理类（提交给外部访问的类） 和 被代理类（真正做事情的类）都实现同一个接口。

远程代理：为远程的对象（服务端的对象）创建代理，客户端使用代理对象进行访问。

远程接口：这个接口是客户端 和 服务端共同使用的接口，并且该接口需要继承Remote类（作为一个远程接口的标识）

远程实现类：远程实现类需要实现远程接口，并且将远程接口进行注册。
```java
// 自定义的远程接口
public interface MyRemote extends Remote {

  void sayHello();
}

// 服务端的远程接口实现
public class MyRemoteImpl implements MyRemote {

  @Override
  public void sayHello() {
    // ......
  }
}

// 进行注册
Registry registry = LocateRegistry.createRegistry(1099);
registry.rebind("RemoteHello", service);

// 客户端通过网络访问注册表 获取到对应的信息 进行访问
Registry registry = LocateRegistry.getRegistry("localhost", 1099);
MyRemote stub = (MyRemote)registry.lookup("RemoteHello");
stub.sayHello();
```
动态代理：可以在**运行时**创建一个代理类，实现一个或多个接口，利用java.lang.reflect包
接口类（Person）：给代理类和被代理类用于实现的接口，定义相关的方法。
InvocationHandler接口：动态代理和普通代理不同的一点是：
* 普通的代理：是在代理对象中含有一个被代理对象的引用，具体执行都是调用被代理对象的引用执行。
* 动态代理：被代理对象的引用是放在invocationHandler类中，具体的执行逻辑是放在invocationHandler类对象的invoke方法中。
```java
public interface Person{
  void setName(final String name);
  void setAge(final int age);
}

public class MyInvocationHandler implements InvocationHandler {
  // 被代理对象的引用
  private Person person;

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    // 执行之前的 逻辑 ......
    method.invoke(person, args); // 被代理对象的执行逻辑
    // 执行之后的 逻辑 ......
    return null;
  }
}

// 生成代理对象
Proxy.newProxyInstance(
        person.getClass().getClassLoader(),  // 类加载器
        person.getClass().getInterfaces(),   // 类中定义的接口
        new MyInvocationHandler(person)
        )
```
- [ ] 具体的代理对象生成细节，需要通过看相关生成的字节码才知道。
- [ ] cglib动态代理可以不需要定义接口。
### 14. 模式的模式(compound pattern)
将多种模式组合在一起使用
* 装饰器模式 和 适配器模式很像，都是实现一个接口。
* 适配器模式中调用的引用是其他类（Goose类）。
* 装饰器模式中调用的引用还是接口类（Quackable接口），同时会修改方法的行为。
* 工厂模式管理鸭子：工厂是抽象的（有两种工厂），产品也是抽象的（有两种类型的产品）
* 观察者模式：
  * Observable 主题，鸭子就是主题，当鸭子叫时，就通知观察者（调用观察者的方法）。
  * Observer 观察者，观察者可以将自己注册到主题上（内部含有主题的引用）

* MVC(Model-View-Controller):
* Model: 存储了数据、状态、逻辑
* View：依赖Model的改变决定显示的内容
* Controller: 依赖View的改变，控制Model的改变

## # 15. 真实世界的模式
模式是在某种特定场景下针对某种问题的解决方案。
模式是被发现的，而不是被创建的。
设计系统时一开始要以简单为主，不要用很复杂的模式解决简单的问题。（Keep it simple）
设计模式的分类（感觉 行为型 和 结构型不好区分）：
* 创建型：涉及到对象的实例化，将客户从需要实例化的对象中解耦开来。
* 行为型：关注对象之间的通信、协作、职责分配等问题，解决对象之间沟通、交互的问题。
* 结构型：如何组合类和对象形成一个更大的结构。

### 16. 剩余的模式
剩余的模式在具体的工作中用到了再具体学习吧。
* 桥接模式
* 生成器模式
* 责任链模式
* 蝇量模式
* 解释器模式
* 中介者模式
* 备忘录模式
* 原型模式
* 访问者模式
