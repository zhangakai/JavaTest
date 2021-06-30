#工作总结

---------------------------------

day1:

    安装软件，配置环境
    IntelliJ IDEA
    PyCharm
    JDK 1.8
    git安装使用，配置全局gitignore
    maven配置，找mentor获取settings.xml
    postman安装
    数据库软件（sequel pro 安装）
    阿里Java规范
    

day2:

    从代码仓库拉取代码 代码有两个部分：API 和 web
    api模块使用openfeign @feignClient 注解用的多 
    本地测试application 调用接口
    
    相关规范：
    DO（ Data Object）：与数据库表结构一一对应，通过DAO层向上传输数据源对象。
    DTO（ Data Transfer Object）：数据传输对象，Service或Manager向外传输的对象。
    BO（ Business Object）：业务对象。 由Service层输出的封装业务逻辑的对象。
    AO（ Application Object）：应用对象。 在Web层与Service层之间抽象的复用对象模型，极为贴近展示层，复用度不高。
    VO（ View Object）：显示层对象，通常是Web向模板渲染引擎层传输的对象。
    POJO（ Plain Ordinary Java Object）：POJO专指只有setter/getter/toString的简单类，包括DO/DTO/BO/VO等。
    Query：数据查询对象，各层接收上层的查询请求。 注意超过2个参数的查询封装，禁止使用Map类来传输。

