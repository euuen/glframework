# Application

## public static void getInstance()

<div class="card">
    <h3>作用</h3>
    <p>获取Application实例</p>
</div>


### 例子

```java
Application app = Application.getInstance();
```

## public void initialize()

### 作用

你应该继承Application，覆盖此方法，此方法会在Application被初始化的时候调用。

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
