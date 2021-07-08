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



----------------------

spring boot 启动过程

    SpringAppliction 负责
    创建一个合适的ApplictionContext实例
    注册一个CommandLinePropertySource负责将命令行参数转化为spring proprty
    刷新application context 加载所有的单例bean
    激活所有的CommandLineRunner(一个接口,表示要run的bean) bean
    Create an appropriate ApplicationContext instance (depending on your classpath)
    Register a CommandLinePropertySource to expose command line arguments as Spring properties
    Refresh the application context, loading all singleton beans
    Trigger any CommandLineRunner beans

    l Spring是提供基本功能的核心
    
    l SpringMVC是基于Spring的MVC框架
    
    l SpringBoot是一个快速开发集成包，用于简化Spring配置；
    
    l SpringCloud是基于SpringBoot的服务管理框架。


    msyql内置引擎：
    1.Archive 只支持insert select 缓存所有的写并压缩 磁盘IO更少 select需要全表扫描 适合日志和数据采集
    非事务型引擎
    2.CSV引擎 将CSV文件作为表来处理 不支持索引 可以用来做数据交换
    3.Memory引擎 内存型 数据重启会丢失 支持hash索引 表锁 不支持blob text 查询中的临时表用的就是他 当
    有blob text时 用MYISAM 
    4.merge引擎  myisam的变种 merge表是由多个myisam表合并而来的虚拟表 用于日志类或数据仓库类
    5.NDB集群引擎
    第三方引擎
    1.pethinkdb 基于固态
    2.infobright 面向列的引擎 适合10tb以上数据量 为数据分析和数据仓库设计 数据高度压缩 按块排序
    社区引擎
    1.groonga 全文索引引擎
    2.oqgraph 支持图操作
    3.spider 支持分区 实现分片功能 可以针对分片做并行查询
    