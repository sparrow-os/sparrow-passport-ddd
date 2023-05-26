# 应用层
流程+数据准备工作


- Application层
应用层主要作用就是编排业务,只负责业务流程串联，不负责业务逻辑

application层其实是有固定套路的，在之前的文章有过阐述，大致流程：
```agsl
application service method(Command command) {
     //参数检验
    check(command);
    //可以用domain的战术对象，而没有domain service 也可以
    Aggregate aggregate = repository.findAggregate(command);
    //复杂的需要domain service
    aggregate.operate(command);
    repository.saveOrUpdate(aggregate);
    publish(event);
    return DTOAssembler.to(aggregate);
}
```

业务流程 VS 业务规则
对于这两者怎么区分，也就是application service 与 domain service 的区分，最简单的方式：业务规则是有if/else的，业务流程没有

现在都是防御性编程，在check(command)部分，会做很多的precondition

比如转帐业务中，对于余额的前提判断：
```
public void preDebit(Account account, double amount) {
double newBalance = account.balance() - amount;
if (newBalance < 0) {
throw new DebitException("Insufficient funds");
}
}
```
这算是业务规则还是业务流程呢？这一段代码可以算是precondition，但也是业务规则的一部分，颇有争议，但没有正确答案，只是看你代码是否有`复用性`，
目前我个人倾向于放在业务规则中，也就是domain层
