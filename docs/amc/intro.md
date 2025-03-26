# AMC

AMC是Application-Manager-Control的缩写，这三个概念在AMC中十分重要也比较基础。下面是对这三个概念的解释。

## Application

Application是一个用来管理Manager的类。一个程序中只能存在一个Application，因为它采用的是单例模式。例如MC的`MinecraftClient`

## Manager

你可以把你的程序分解成几个模块，然后封装到Manager中，然后使用Application的`addManager()`方法添加到Application中。例如MC的`AchievementManager`,`PlayerManager`

## Control

这个是用来控制单个对象的控制器，比如控制角色的移动可以用`MoveControl`，控制角色饱食度可以用`HungerControl`。

>忽然感觉自己的解释能力好差😥，算了，等我有时间在详细解释
