# AMC

::: warning 警告
本项目处于开发中，可能只有文档却没有相应的代码实现。另外，如果你觉得文档有什么地方写的不清楚，或者写错了的话，请一定投一个issue，谢谢。

不过呢，可能你投了一个issue我也不太可能立马解决。因为我这个项目纯粹的就是为了玩吧，额，反正如果要投入生产环境中使用的话我可不能保证稳定性啊。我觉得现在应该有比我更成熟的框架了，我做一做这个只是为了练习一下java。说实话，我也不指望我靠这个项目就干嘛干嘛，没关系，自己当个玩具玩吧。因为它的本质和玩游戏差不多（不务正业），所以我可能没有多少时间开发此项目。
:::

## AMC的来历

<p>忆昔当年，还是忘不了那些糟糕代码的痛——神秘的空指针异常，无法理解的上古代码，奇奇怪怪的千层判断，惊慌失措的return语句，莫名其妙的局部变量，出人意料的运行顺序......</p>
<p>这些都是不规范的代码所造成的<strike>（也有可能是我自己的原因）</strike>，当年学clean code也是这个原因，尝试以更低的复杂度写出更高级且多样化的功能。</p>
<p>很庆幸生在了OOD的时代，OOD使我的大脑负担减少了不少，但是我觉得还不够；知道clean code和bob（Robert Martin）大叔后，我又觉得clean code是很好，但是他写起来太讲究了，而且一些原则到现在不是很实用了；在后来，我接触到了JMonekyEngine，他的AppState&Control设计哲学给我带来了启发，但是自定义程度不够；在它们的启发和我要高自定义的需要下，我借鉴猴子的代码，设计出了AMC。</p>

讲了这么多，那么AMC到底关注什么？又解决了什么问题？

## AMC关注的方面与解决的问题

1. AMC关注系统层面的构建。任何一个系统都应该层次分明，各模块各司其职，就好比政府一样，每个模块代表不同的部门。AMC提供了一系列API，可以很方便地构建出一个结构清晰的系统。
2. AMC解决了组件代码组织的问题。正是因为有了清晰的结构和合理的抽象，使得代码的组织变得井井有条。
3. 新开发成员可以快速上手项目。新开发成员可以选择自行阅读AMC自动生成的文档（还在考虑要不要做）

<!-- AMC是Application-Manager-Control的缩写，这三个概念在AMC中十分重要也比较基础。下面是对这三个概念的解释。

## Application

Application是一个用来管理Manager的类。一个程序中只能存在一个Application，因为它采用的是单例模式。例如MC的`MinecraftClient`

## Manager

你可以把你的程序分解成几个模块，然后封装到Manager中，然后使用Application的`addManager()`方法添加到Application中。例如MC的`AchievementManager`,`PlayerManager`

## Control

这个是用来控制单个对象的控制器，比如控制角色的移动可以用`MoveControl`，控制角色饱食度可以用`HungerControl`。

>忽然感觉自己的解释能力好差😥，算了，等我有时间在详细解释 -->
