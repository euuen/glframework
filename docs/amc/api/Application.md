# Application

## <span>`getInstance`</span>

<card>
    
### 作用

获取Application实例

</card>

<card>

### 例子

```java
Application app = Application.getInstance();
```

</card>

::: tip 我的小小建议
在自己的Application中覆盖这个方法吧。因为此方法返回的类型只是基类，如果你要用自己的Application中的一些方法，还要显式转换一下类型是吧，最好自己实现一个，这样就不用显式地转换类型了。
:::

## <span>`initilize`</span>

<card>

### 作用

你应该继承Application，覆盖此方法，此方法会在Application被初始化的时候调用。

</card>

<card>

### 例子


```java
public class MyApp extends Application{
    public void initialize(){
        System.out.println("hello amc");
    }

    public static void main(String[] args){
        MyApp app = new MyApp();
        app.start();
    }
}
```

</card>

## <span>`update`</span>

## <span>`cleanup`</span>

## <span>`execute`</span>

::: tip
Application其实隐式地在内部，在主线程创建了一个baseSystem，这个execute其实相当于是在baseSystem的环境下执行的
:::

## <span>`start`</span>

## <span>`stop`</span>

## <span>`pause`</span>

## <span>`resume`</span>

## <span>`regManager`</span>

::: tip
Application其实隐式地在内部，在主线程创建了一个baseSystem，此函数相当于是向baseSystem内添加Manager
:::

::: warning
注册完Manager后，Manager还不会立即执行初始化，你必须要自己手动执行`initializeManagers`方法后Manager才能得到初始化
:::

<card>

### 作用

添加管理器。

</card>

<card>

### 例子

```java
app.regManager(new MyMgr());
```

</card>

## <span>`initManager`</span>

## <span>`addManager`</span>

## <span>`rmManager`</span>

<card>

### 作用

删除Manager

</card>

## <span>`getManager`</span>

::: tip
此方法会只会在baseSystem中查询是否有指定的Manager，如果要想全局查找，请使用`getManagerGlobally`方法
:::

<card>

### 作用

通过id获取指定的Manager。不过id一般是由class设置的，所以直接输入class就好了。

</card>

<card>

### 类型说明

此方法为静态方法。

|参数|类型|
|-|-|
|id|String|
|globallyFind|Boolean（选填）|

|返回值|类型|
|-|-|
|Manager|Manager|

如果查询不到对应的Manager，会返回null值

</card>

<card>

### 示例

```java
Manager mgr = Application.getManager(MyMgr.class);
```

</card>

## <span>`getManagerGlobally`</span>

## <span>`regSystem`</span>

## <span>`initSystem`</span>

## <span>`addSystem`</span>

## <span>`rmSystem`</span>

## <span>`getSystem`</span>
