# AndroidComponentDemo
一个简单的Android组件化demo：

###module说明：
- baselib: 所有组件所共同依赖的lib。网络层、数据层、Router应放置于此处
- componentXXX: 根据不同的业务线独立出来不同的组件。基本业务代码均应位于此module中
- appXXX:app壳工程。一般内部无代码。app模块主要用于分离依赖各个的独立component。便于分组件加载。让单独的组件也可以作为独立应用使用；如：
```
appusercenter   ->  componentusercenter
appsocial       ->  componentsocial
app模块为总模块。用于加载所有模块并进行配置的。故需要依赖所有组件：
app             ->  componentsocial ... componentusercenter
```
**此demo只是简单的对组件化时的架构分层管理做说明。实际应用中需要根据具体需要决定具体的组件粒度。基本规则应该是app壳 -> component -> lib**
###使用组件化的注意事项
1. 由于现在所有Activity均放置于component中。所以生成的R文件不是常量。导致ButterKnife此类的需要使用R资源的lib不可用
**--突然有人提醒。ButterKnife对于在Library中使用有特别的解决方案。所以需要用ButterKnife的童鞋。可以参考[ButterKnife Library使用解决方案](http://www.see-source.com/blog/300000113/1324.html)**
2. 使用组件化应对资源文件的命名有严格约束。避免导致加载多模块组件的时候由于资源命名冲突导致一些额外问题
3. 由于多组件的存在。在加载多组件时会容易出现Manifest merge问题。建议了解一下AndroidStudio merger相关知识。

相关资料：

[组件间页面跳转通信传值](https://github.com/yjfnypeu/Router)

[Android项目架构之业务组件化](http://blog.csdn.net/dfskhgalshgkajghljgh/article/details/52486383)

[Android组件化开发实践](http://www.jianshu.com/p/186fa07fc48a)
