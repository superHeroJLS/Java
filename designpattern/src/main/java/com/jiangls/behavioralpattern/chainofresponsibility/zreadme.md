# 责任链模式（Chain of Responsibility Pattern）
责任链模式（Chain of Responsibility）是一种处理请求的模式，它让多个处理器都有机会处理该请求，直到其中某个处理成功为止。
责任链模式把多个处理器串成链，然后让请求在链上传递：
```
Request --> ProcessA --> ProcessB --> ProcessC --> Target
```

在实际场景中，财务审批就是一个责任链模式。假设某个员工需要报销一笔费用，审核者可以分为：
1. Manager：只能审核1000元以下的报销；
2. Director：只能审核10000元以下的报销；
3. CEO：可以审核任意额度。
用责任链模式设计此报销流程时，每个审核者只关心自己责任范围内的请求，并且处理它。
对于超出自己责任范围的，扔给下一个审核者处理，这样，将来继续添加审核者的时候，不用改动现有逻辑。
# 最佳实践
1. Java servlet中的Filter
2. Spring中的Interceptor
