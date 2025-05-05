# System

System出现的目的不是为了搞无谓的封装，事实上有manager就够了，我之所以还要弄一个System是因为我要多线程。System的api其实和Application的差不多。因为实际上，Application就是在内部创建了一个baseSystem，那么它和System的操作方法很想也不足为奇了。

如果你把System添加到Application中，那么这个System的循环就会在另外一个子线程运行，不过这样也因此带来了一系列的多线程安全问题。我这里才用的方案是`execute`+`CopyOnWriteArray`，效率吗，就不敢恭维了。

## <span>`create`</span>

## <span>`destroy`</span>

## <span>`pause`</span>

## <span>`resume`</span>

## <span>`onPause`</span>

## <span>`onResume`</span>

## <span>`initialize`</span>

## <span>`update`</span>

## <span>`cleanup`</span>

## <span>`execute`</span>

## <span>`regManger`</span>

## <span>`initializeMangers`</span>

## <span>`getManger`</span>

## <span>`rmManger`</span>