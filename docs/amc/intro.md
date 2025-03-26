# AMC

## AMC的来历

<p>忆昔当年，还是忘不了那些糟糕代码的痛——神秘的空指针异常，无法理解的上古代码，奇奇怪怪的千层判断，惊慌失措的return语句，莫名其妙的局部变量，出人意料的运行顺序......</p>
<p>这些都是不规范的代码所造成的<strike>（也有可能是我自己的原因）</strike>，当年学clean code也是这个原因，尝试以更低的复杂度写出更高级且多样化的功能。</p>
<p>很庆幸生在了OOD的时代，OOD使我的大脑负担减少了不少，但是我觉得还不够；知道clean code和bob（Robert Martin）大叔后，我又觉得clean code是很好，但是他写起来太讲究了，而且一些原则到现在不是很实用了；在后来，我接触到了JMonekyEngine，他的AppState&Control设计哲学给我带来了启发，但是自定义程度不够；在它们的启发和我要高自定义的需要下，我借鉴猴子的代码，设计出了AMC</p>

讲了这么多，那么AMC到底关注什么？又解决了什么问题？

1.AMC关注系统层面的构建
2.AMC解决了组件代码组织的问题，让新开发成员可以快速上手项目



AMC是Application-Manager-Control的缩写，这三个概念在AMC中十分重要也比较基础。下面是对这三个概念的解释。

## Application

Application是一个用来管理Manager的类。一个程序中只能存在一个Application，因为它采用的是单例模式。例如MC的`MinecraftClient`

## Manager

你可以把你的程序分解成几个模块，然后封装到Manager中，然后使用Application的`addManager()`方法添加到Application中。例如MC的`AchievementManager`,`PlayerManager`

## Control

这个是用来控制单个对象的控制器，比如控制角色的移动可以用`MoveControl`，控制角色饱食度可以用`HungerControl`。

>忽然感觉自己的解释能力好差😥，算了，等我有时间在详细解释
