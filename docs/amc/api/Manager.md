# Manager

## <span>`regWork`</span>

<card>

### 作用

注册一个作业（Work），此Manager负责更新此作业。

</card>

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
