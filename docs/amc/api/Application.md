# Application

## <span>`getInstance`</span>

<card>
    <h3>作用</h3>
    <p>获取Application实例</p>
</card>

<card>

### 例子

```java
Application app = Application.getInstance();
```

</card>

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

## <span>`getManager`</span>

::: tip
此方法会在每一个System中查询是否有指定的Manager
:::

<card>

### 作用

通过id获取指定的Manager。

</card>

<card>

### 类型说明

此方法为静态方法。

|参数|类型|
|-|-|
|id|String|

|返回值|类型|
|-|-|
|Manager|Manager|

如果查询不到对应的Manager，会返回null值

</card>

<card>

### 示例

```java
String id = "MyMgr";
Manager mgr = Application.getManager();
```

</card>

## <span>`rmManager`</span>

## <span>`regSystem`</span>

## <span>`rmSystem`</span>
