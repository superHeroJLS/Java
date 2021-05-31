# 桥接模式
桥接模式通过分离一个抽象接口和它的实现部分，使得设计可以按两个维度独立扩展。
桥接模式就是为了避免直接继承带来的子类爆炸。

# 举例子
概念过于抽象，举个例子：
假设某个汽车厂商生产三种品牌的汽车：Big、Tiny和Boss，每种品牌又可以选择燃油、纯电和混合动力。如果用传统的继承来表示各个最终车型，
一共有3个抽象类加9个最终子类：
```
Car
    BigCar
        BigFuelCar
        BigElectricCar
        BigHybridCar
    TinyCar
        TinyFuelCar
        TinyElectricCar
        TinyHybridCar
    BossCar
        BossFuelCar
        BossElectricCar
        BossHybridCar
```
如果要新增一个品牌，或者加一个新的引擎（比如核动力），那么子类的数量增长更快。
所以，桥接模式就是为了避免直接继承带来的子类爆炸。
`Java具体如何实现桥接模式，就是以“组合”的方式替代“继承”`

# 总结
桥接模式实现比较复杂，实际应用也非常少，但它提供的设计思想值得借鉴，即不要过度使用继承，而是优先拆分某些部件，使用组合的方式来扩展功能。


