# 适配器模式
将一个类的接口转换成客户希望的另外一个接口，使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。
适配器模式是Adapter，也称Wrapper，是指如果一个接口需要B接口，但是待传入的对象却是A接口，怎么办？
Adapter模式可以将一个A接口转换为B接口，使得新的对象符合B接口规范。
编写Adapter实际上就是编写一个实现了B接口，并且内部持有A接口的类：
```
public BAdapter implements B {
    private A a;
    public BAdapter(A a) {
        this.a = a;
    }
    public void b() {
        a.a();
    }
}
```