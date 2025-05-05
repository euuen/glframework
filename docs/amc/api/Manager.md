# Manager

## <span>`create`</span>

<card>

### 作用

创建，或者说是初始化Manager。

::: warning
大部分情况下，你不应该自己手动使用这个方法，这个方法在Application中会被隐式使用
:::

</card>

## <span>`destroy`</span>

<card>

### 作用

销毁Manager

</card>

## <span>`enable`</span>

## <span>`disable`</span>

## <span>`onEnable`</span>

## <span>`onDisable`</span>

## <span>`initialize`</span>

<card>

### 作用

你应该继承Manager类，覆盖此方法才能在Manager被初始化时执行你的代码

</card>

<card>

### 示例

```java
public class MyMgr extends Manager {
    @Override
    public void initialize(){
        // your custom code
    }
}
```

</card>

## <span>`update`</span>

## <span>`cleanup`</span>

## <span>`regWork`</span>

<card>

### 作用

注册一个作业（Work），此Manager负责更新此作业，但是具体的作业由工人（Worker）操作

</card>

<card>

### 类型说明

|参数|类型|
|-|-|
|worker|Worker|
|resource|Object|

</card>

## <span>`setId`</span>

<card>

### 简介

默认情况下，AMC并不会为你的manager设置id。在初始化之前，如果你还没有设置id的话，amc在初始化的时候就会根据你manager的class信息设置id。id在查询manager时非常重要。

::: warning
如果你要添加一个id已经存在在amc系统的中的manager，比如，amc中已经有一个manager对象有A这个id，但是，如果你还要添加一个manager（与上面那个manager是两个对象），而且id也是A的话，amc不会报错，也不会提示，只会把顶掉之前的那个manager。
:::

</card>

<card>

### 类型说明

|参数|类型|
|-|-|
|id|String|

</card>
