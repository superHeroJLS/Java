# 字符串、数组和广义表
## 字符串
### 串的顺序存储
采用字符数组将串中的字符序列依次存储在数组的相邻单位中
### 串的链式存储
串的链式存储有单字符链表和块链表2种
### 串的实现
1. **Java将字符串以及操作封装成字符串类，实现字符串抽象数据类型，这正是数据结构的理论成果促进程序设计语言的表现。Java字符串类主要有常量字符串String、变量字符串StringBuffer。都采用顺序存储结构。**

2. **C/C++采用字符数组或字符指针表示字符串，但字符串不同于字符数组，字符串只是采用字符数组作为其存储结构，它要实现字符串抽象数据类型的所有操作**
### 串的模式匹配算法
1. Brute-Force(BF)算法：BF算法的基本思想是蛮力匹配，从目标串的target的每一个字符开始依次与模式串pattern的字符进行比较
2. KMP算法：KMP算法demo，KMP算法是一种无回溯的的模式匹配算法，目标串不回溯，改进了Brute-Force算法。
Knuth-Morris-Pratt算法（KMP）以三个发明者命名，起头的那个K就是著名科学家Donald Knuth

参考：https://www.icourse163.org/learn/ZZU-1207193805?tid=1461941470#/learn/content?type=detail&id=1238766413&cid=1259545397

**KMP算法详解，参考次文章理解KMP算法**：https://blog.csdn.net/yyzsir/article/details/89462339