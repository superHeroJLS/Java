# 同步和异步
同步IO是指，读写IO时代码必须等待数据返回后才继续执行后续代码，它的优点是代码编写简单，缺点是CPU执行效率低。

而异步IO是指，读写IO时仅发出请求，然后立刻执行后续代码，它的优点是CPU执行效率高，缺点是代码编写复杂。

Java标准库的包java.io提供了同步IO，而java.nio则是异步IO。上面我们讨论的InputStream、OutputStream、Reader和Writer都是同步IO的抽象类，对应的具体实现类，以文件为例，有FileInputStream、FileOutputStream、FileReader和FileWriter。

本节我们只讨论Java的同步IO，即输入/输出流的IO模型。

# 小结
IO流是一种流式的数据输入/输出模型：

二进制数据以byte为最小单位在InputStream/OutputStream中单向流动；

字符数据以char为最小单位在Reader/Writer中单向流动。

Java标准库的java.io包提供了同步IO功能：

字节流接口：InputStream/OutputStream；

字符流接口：Reader/Writer。

> IO-廖雪峰：https://www.liaoxuefeng.com/wiki/1252599548343744/1255945227202752