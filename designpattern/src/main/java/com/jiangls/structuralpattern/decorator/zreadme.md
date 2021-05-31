# 装饰器模式
动态地给一个对象添加一些额外的职责。就增加功能来说，相比生成子类更为灵活。
装饰器（Decorator）模式，是一种在运行期动态给某个对象的实例增加功能的方法。

# 最佳实践
Java中的`FilterInputStream`及其子类就是`Decorator`模式的实现。
使用Decorator模式，在顶层接口下(比如InputStream)，可以独立增加核心功能(比如FileInputStream)，
也可以独立增加附加功能(比如FilterInputStream及其子类)，二者互不影响；
