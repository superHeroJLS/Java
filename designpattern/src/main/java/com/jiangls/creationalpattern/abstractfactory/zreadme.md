# 抽象工厂
抽象工厂模式是为了让创建工厂和一组产品与使用相分离，并可以随时切换到另一个工厂以及另一组产品；
抽象工厂模式实现的关键点是定义`工厂接口`和`产品接口`，但如何实现工厂与产品本身需要留给具体的`子类`实现，客户端`只和抽象工厂与抽象产品`打交道。
# 抽象工厂和工厂方法区别
抽象工厂模式和工厂方法不太一样，它要解决的问题比较复杂，不但`工厂是抽象`的，`产品是抽象`的，而且有`多个产品`需要创建，
因此，这个抽象工厂会对应到`多个实际工厂`，每个实际工厂负责创建`多个实际产品`：
