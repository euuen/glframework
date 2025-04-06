# 第一章：hello AMC

## 配置AMC环境

目前AMC还是作为glframework的一个子组件来写的。因为AMC只是一个干巴巴的骨架，搭配GLEngine才富有血肉。所以，请把glframework clone到你的项目然后就可以用了。~~（我太懒了，懒得打包成jar）~~

```sh
git clone https://github.com/euuen/glframework.git
```

## 一个最基本的例子

不过，我们还是先从println开始讲起AMC的使用方法。下面是一个示范代码。

```java
public class MyApp extends Application{
    int i = 0;

    @Override
    public void initialize(){
        System.out.println("hello amc | initilizing...");
    }

    @Override
    public void update(){
        if (i == 3){
            stop();
        }
        System.out.println("updating...");
        i++;
    }

    @Override
    public void cleanup(){
        System.out.println("bye amc | cleanup...")
    }

    public static void main(String[] args){
        MyApp app = new MyApp();
        app.start();
    }
}
```

输出结果为：

```cpp
hello amc | initilizing...
updating...
updating...
updating...
bye amc | cleanup...
```

这个类MyApp继承了Application类，然后覆盖了它的initialize方法。我们实例化MyApp后，需要用start方法启动Application。只会AMC才会执行你的initialize方法。

初始化你的Application后，就会开始循环执行update方法。可以看到，在update中有一个判断，当i==3时执行stop函数然后返回，这意味着这个update方法只会被执行三次，也就是说只会输出三次updating。然后执行stop的时候会执行cleanup方法。执行完cleanup后，然后AMC会调用exit函数退出。所以注意，stop后面的代码是不能被执行的

## 复杂化我们的程序

现在，假设我们有两个模块，一个叫A，一个叫B，他们二者分别需要各自输出Sending info和Recving info。如果我们把A和B的逻辑混合在一个update方法中，这会使得update变得非常巨大，如果以后要添加新的模块的话，可能还会让update变得更加臃肿。

解决方法是把它们分割到两个Manager中，在Manager中分别实现他们二者的逻辑。

> 你会发现Manager的API与Application惊人的相似

```java
class MgrA extends Manager{
    @Override
    public void initialize() {
        super.initialize();
        System.out.println("initialize A");
    }

    @Override
    public void update(){
        System.out.println("sending info");
    }

    @Override
    public void cleanup(){
        System.out.println("cleanup A")
    }
}

class MgrB extends Manager{
    @Override
    public void initialize() {
        super.initialize();
        System.out.println("initialize B");
    }

    @Override
    public void update(){
        System.out.println("recving info");
    }

    @Override
    public void cleanup(){
        System.out.println("cleanup B")
    }
}
```

在定义完了两个组件后，我们应该把它们添加到你的Application中

```java
public class MyApp extends Application{
    int i = 0;

    @Override
    public void initialize(){
        System.out.println("hello amc | initilizing...");
        addManager(new MgrA());
        addManager(new MgrB());
    }

    @Override
    public void update(){
        System.out.println("updating...");
        i++;
        if (i == 1){
            stop();
        }
    }

    @Override
    public void cleanup(){
        System.out.println("bye amc | cleanup...")
    }

    public static void main(String[] args){
        MyApp app = new MyApp();
        app.start();
    }
}
```

输出的结果为：

```cpp
hello amc | initilizing...
initialize A        // [!code ++]
intiialize B        // [!code ++]
updating...
sending info        // [!code ++]
recving info        // [!code ++]
cleanup A           // [!code ++]
cleanup B           // [!code ++]
bye amc | cleanup...
```

> 我想聪明的你一定能看懂AMC的运行顺序吧。

::: warning 注意
这里有几个地方要强调

1. addManager时，会触发manager的initialize方法
2. cleanup的时候，会先cleanup manager，在清除Application
3. manager的运行顺序取决于他们的添加顺序
:::

## 结合Application与Manager与Control才叫AMC

现在，假设这么一个情况，你有一个生物需要控制，比如控制位移，控制它的饱食度。那应该怎么做呢？我们需要时刻更新位移与饱食度。那么最好的方法是使用AMC的Controlee与Control

Controlee是被控制的对象，Control则是控制器

> 说实话有一段时间我在想怎么用英语简洁的表达被控制的对象，后来看到Employee我就想出来了。Controlee算是我自己捏造的一个单词吧。~~或许外国人也可能用过~~

```java
public class Creature extends Controlee {
    public Vector3f location;
    public float hungry = 20f;
    public float health = 20f;
    public HungryControl hungryCrtl = new HungryControl();
    public HealthControl healthCrtl = new HealthControl();
    public PhysicsControl phyCrtl = new PhysicsControl();
    
    public Creature(Vector 3f location){
        this.location = location;
        addControl(hungryCrtl);
        addControl(healthCrtl);
        addControl(phyCrtl);
        ((MyApp) Application.instace).phyMgr.addPhysicsControl(crt.phyCtrl);
    }
}

class HungryControl extends Control{
    @Override
    public void update(){
        Creature crt = (Creature) getControlee();
        ctr.hungry -= 0.1f;
        System.out.println("updating hungry...");
    }
}

class HealthControl extends Control{
    @Override
    public void update(){
        Creature crt = (Creature) getControlee();
        if (crt.hungry < 0.0f){
            crt.health -= 1.5f;
        }
        System.out.println("updating health...");
        if (crt.health <= 0.0f){
            // stop是静态方法，因为AMC的Application遵循单例模式
            Application.stop();
        }
    }
}

class PhysicsControl extends Control {
    // 一些坐标和速度相关的参数
    @Override
    public void update(){
        Creature crt = (Creature) getControlee();

        // 把物理引擎中的数据同步到OpenGL空间

        System.out.println("physics test...");
    }

    @Override
    public void refresh(){
        // 这里是故意加的，真实的物理控制器应该没有这行。如果要实现相同的功能，可以通过控制器设置速度。
        crt.location.move(new Vector3f(0.1f, 0f, 0f));

        // 碰撞检测
    }
}
```

这段代码可能有点长，但是不难看懂

这里有三个控制器控制生物。分别是饥饿值，健康值，物理控制器（负责位移和与其他物体的碰撞）

注意看，这里覆盖了两个方法，一个是update，一个是refresh。它们两个的作用都是刷新Control，既然功能一样为什么还要做成两个方法？这里解释一下，update是交给Controlee更新的，而Controlee是交给Manager更新的，而Manager是交给Application更新的，那refresh呢？refresh是交给Manager更新的。

这里解释一下为什么要这样设计的原因。因为考虑到物理引擎和图像引擎往往要更新的内容不一样，干脆我就设计两个函数算了。物理引擎要更新的是物体的坐标和速度，主线程则要同步。

这里的Indentifier是Manager的id，一般在你的Manager的构造函数中。（如果你不设置Manager的id，addManager后会自动给你随机设置。）

下面这个把Creature添加到程序的代码可以解释这点。

```java
class CreatureManager extends Manager {
    public CreatureManager(){
        super.id = new Identifier("CreatureManager");
    }

    public addCreature(Creature crt){
        creatures.add(crt);
        addControlee(crt);
    }
    // 省略部分逻辑代码
}

class PhysicsManager extends Manger{
    public PhysicsManager(){
        super.id = new Identifier("PhysicsManager");
    }

    public addPhysicsControl(PhysicsControl phyCrtl){
        phyCtrls.add(phyCtrl);
        addControl(phyCtrl);
    }
    // 省略部分逻辑代码
}

public class MyApp extends Application{
    CreatureManger crtMgr crtMgr = new CreatureManger();
    PhysicsManager phyMgr = new PhysicsManger();
    @Override
    public void initialize(){
        addManager(crtMgr);
        addManager(phyMgr);

        crtMgr.addCreature(new Creature());
        }

    public static void main(String[] args){
        MyApp app = new MyApp();
        app.start();
    }
}
```

::: warning 警告
只有在`addXXX()`的时候才会初始化`XXX`。
:::

预计的结果是，饱食度会掉到0一下，然后开始掉健康值，小于0后退出程序。
