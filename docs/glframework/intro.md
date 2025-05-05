# 欢迎使用glframework

::: tip
在使用之前，你可能还需要学习一些关于本库使用的框架[AMC](/amc/intro)
:::

一下是一个简单的示例可以快速上手glframework

```java
public class MyGame extends Application{
    Cube cube = new Cube();
    @Override
    public void initialize(){
        regSystem(new GLEngine());
        initSystem(new GLEngine());

        SceneManager sceneMgr = getManager(SceneManager.class, true);

        sceneMgr.addModel(cube);
    }

    @Override
    public void update(){
        cube.rotateYD(10);
    }

    @Override
    public void cleanup(){
        cube = null;
    }
}
```

正如你所见，GLEngine的调用就是这么简单。什么？你说调用太复杂了，没有JMonkeyEngine那么简单。但是你如果你用到后面，你会发现glframework其实用起来更自由。