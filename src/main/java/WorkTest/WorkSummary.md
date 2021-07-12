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



new relic 服务器监控 免费 
percona server mysql性能监控
pt-query-digest 分析查询日志

set profiling = num; 设置查询语句的标识从多少开始 
select * from  查询语句
show profile for query 1; 1代表第几个查询语句 


grep 输出符合匹配模式的行
-i ignore 忽略大小写
-l list 列出本目录包含匹配模式的文件
-r recursion 列出本目录以及子目录包含匹配模式的文件
-n number 列出匹配的行在原文件中的行号
-w word  匹配整个单词 
-v verse 反转 意思是输出不匹配的行
"^foo" 以foo开头
"foo$" 以foo结尾
-A after 指定匹配后显示多少行
grep "error" -A 5 -B 10 error.log 显示文件中 error和其前10行和后5行

awk 进行匹配然后可以对匹配的行做修改 一般用grep做匹配 awk做修改
用法 awk '____  {action}' filename
例如
awk '/mange/ {print} ' filename  
print $0 输出所有列
print $1 输出第一列
print NR, $1 NR 打印行和行号 number row
awk ‘NR==3, NR==6 {print NR,$0}’ test 显示第三行到第六行
awk '{print NF}' test 每行字段数 number filed  awk '{print NF}' test  
awk '{print $NF}' test   输出最后一列
awk 'OFS="/" {print $1,$4}' test  Andy/45000 指定分隔符 output filed separator
awk 'BEGIN {print "my test file"} {print $0}' test 一眼就看出来没什么好说哒哒哒哒 

sed 流编辑器 用于搜索 查找 替换 插入 删除 常用来查找和替换



磁盘
df Report file system disk space usage
df -h human readable 查看全局磁盘空间利用信息 
df -sh 当前目录磁盘信息


ps
ps -ef 使用标准语法查看系统中的每个进程 = ps -aux(当前在内存内的进程)
ps -eLf 要获得关于线程的信息
ps -T -p 查看进程的线程


top
top -H 查看线程
top 查看进程


lsof list standard output information 
lsof -u username 查看username打开的所有文件
lsof -i tcp:port 查看特定端口的所有运行进程
lsof -i 4 查看IPv4
lsof -i 6
lsof -i tcp:1-1024 
lsof -i -u username 找出username跑的命令
lsof -i list all network connections
lsof -p num search by pid (会显示多个用户)
kill -9 `lsof -t -u username` Kill all Activity of Particular User

find
(1)find / -name httpd.conf　　#在根目录下查找文件httpd.conf，表示在整个硬盘查找
(2)find /etc -name httpd.conf　　#在/etc目录下文件httpd.conf
(3)find /etc -name 'srm'　　#使用通配符(0或者任意多个)。表示在/etc目录下查找文件名中含有字符串‘srm’的文件
(4)find . -name 'srm' 　　#表示当前目录下查找文件名开头是字符串‘srm’的文件

2.按照文件特征查找
(1)find / -amin -10 　　# 查找在系统中最后10分钟访问的文件(access time)
(2)find / -atime -2　　 # 查找在系统中最后48小时访问的文件
(3)find / -empty 　　# 查找在系统中为空的文件或者文件夹
(4)find / -group cat 　　# 查找在系统中属于 group为cat的文件
(5)find / -mmin -5 　　# 查找在系统中最后5分钟里修改过的文件(modify time)
(6)find / -mtime -1 　　#查找在系统中最后24小时里修改过的文件
(7)find / -user fred 　　#查找在系统中属于fred这个用户的文件
(8)find / -size +10000c　　#查找出大于10000000字节的文件(c:字节，w:双字，k:KB，M:MB，G:GB)
(9)find / -size -1000k 　　#查找出小于1000KB的文件
find /tmp/cg/testLinux -name "*.log"


ser -n '/start_time/,/end_time/' filename



java command

    jps
    - l: Output main class full name or jar path
    jmap jstat jinfo jstack 



Java cpu使用率过高
    
    1.top 定位Java进程ID 看哪个进程使用最多
    2.top -h -p pid 上一步的进程拿过来 看哪个线程使用最多 这里用tid表示
    3.jstack pid -> filename  将线程栈信息输出到文件里 可以生成三次 数据更准确
    4.将pid 转化为16进制 cat jstack-output.txt | grep -i tid

    可能的原因
    1.分配实例频繁 导致gc频繁 最终造成cpu  +++++ 啊 好无聊 实习没人管我每天写写笔记。。。
    2.死锁 线程争用问题 
    3.IO操作 如写入文件系统或与后端关系数据库管理系统或消息队列的交互
    一个错误配置的数据库连接池 其中不断创建和销毁资源以提供与Spring和JPA的应用程序的Java数据库连接
    可以触发高Java CPU使用率 糟糕的I / O资源管理也可能导致泄露的内存
    4.应用程序具有大量HTTP请求 以及每个请求响应周期上解析JSON和XML的关联开销
    通常会触发cpu ++++
    5.自己代码的问题 包括但不限于
    a.无限循环 b.递归写错了 c.数据结构选错了 如在大量数据上不用arraylist 用踏吗的LinkedList
    d.多次计算一个值 建议用临时变量保存下来 


内存泄露

    内存泄漏是存在于不再使用的堆中存在的对象的情况
    但垃圾收集器无法从内存中删除它们 还要维护它们（辛苦了gc大哥)
    
    内存泄漏的一些现象
    当应用程序连续运行很长时间时 性能严重下降
    爆outofmemoryError
    自发和奇怪的应用程序崩溃
    偶尔会耗尽连接对象

    潜在原因
    1.大量运用静态字段
    2.用了资源忘了close
    3.equals() and hashCode() 没写好 导致hash类插入不能覆盖旧对象
    4.非静态内部类实例化时需要实例化外部类 建议写成静态内部类
    5.重写类的'finalize（）方法时 GC将它们放进一个队列进行最终确定
    相当于延迟收集了 如果此时有大量新对象创建 会爆outof...
    6.threadlocal 使用不当 记得不用的对象及时调用.remove()方法



mysql 索引是否失效问题

    版本5.7 
    tablein`id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `logic_id` int(11) unsigned NOT NULL COMMENT '机器人的逻辑id',
    `wechat_username` varchar(32) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT '微信id',
    `specialized` tinyint(3) unsigned DEFAULT NULL COMMENT '角色1 小助手 2 Master 3 Slave 4 个人号 5 苦工号 6 直播号 8 销售号 10潜行号',
    `status` tinyint(3) unsigned NOT NULL COMMENT '状态 0 可用, 1 不可用',
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    KEY `idx_logic_id` (`logic_id`),
    KEY `idx_username` (`wechat_username`),
    KEY `idx_specialized` (`specialized`)
    
    ad_device_status_info	0	PRIMARY	        1	id	        A	    404356	NULL	NULL		BTREE		
    ad_device_status_info	1	idx_logic_id	1	logic_id	A	    1598	NULL	NULL		BTREE		
    ad_device_status_info	1	idx_username	1	wechat_username	A	3546	NULL	NULL		BTREE		
    ad_device_status_info	1	idx_specialized	1	specialized	A	    36	NULL	NULL	    YES	BTREE		

    1.
    select * from ad_device_status_info  where   logic_id > 30000;
    >3000 不走索引; <1000 走索引 另外测试了几个值 并不固定；以前是按区分数占总数量的30% 现在考虑更多因素 这个值不固定了
    != 不走索引 
    select logic_id ....... 无论是什么范围（> < !=...) 都走索引 因为不用回表 但是需要回表 就看范围大小了
    比如 select * from  --- where id != < > 也走索引 

    2.
	select * from ad_device_status_info  where  logic_id < 1000 and wechat_username like "%sfd%";
    虽然后面的wechat_username like "%fjwe% 会失效 但是前面的logic_id生效了 这就是using index condition
    
    3.带函数 类型转换的不走索引 例如 id +1 = 10; cast(id)
    
     



