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
            return;
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

```
hello amc | initilizing...
updating...
updating...
updating...
bye amc | cleanup...
```

这个类MyApp继承了Application类，然后覆盖了它的initialize方法。我们实例化MyApp后，需要用start方法启动Application。只会AMC才会执行你的initialize方法。

初始化你的Application后，就会开始循环执行update方法。可以看到，在update中有一个判断，当i==3时执行stop函数然后返回，这意味着这个update方法只会被执行三次，也就是说只会输出三次updating。然后执行stop的时候会执行cleanup方法。

注意，**要执行这个return方法**，因为使用了stop函数后，update方法不会立即停止，为了避免后面的代码可能会调用已经被清理掉的资源应该及时return。虽然有些时候你可以把stop方法放到最后执行以避免return方法，但是这么做还是个好习惯。

::: details 不执行return的输出
```
hello amc | initilizing...
updating...
updating...
updating...
bye amc | cleanup...
updateing...
```

注意看，这里出现了不应该出现的updating输出。
:::

## 复杂化我们的程序

现在，假设