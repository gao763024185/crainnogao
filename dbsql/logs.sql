/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : ssm

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2017-02-15 17:25:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for logs
-- ----------------------------
DROP TABLE IF EXISTS `logs`;
CREATE TABLE `logs` (
  `log_id` varchar(15) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `log_title` varchar(100) DEFAULT NULL,
  `log_summary` varchar(100) DEFAULT NULL,
  `log_content` varchar(10000) DEFAULT NULL,
  `log_created` datetime DEFAULT NULL,
  `log_update` datetime DEFAULT NULL,
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of logs
-- ----------------------------
INSERT INTO `logs` VALUES ('1701131348', 'crainnogao博客前言', '前言', '##### 这是crainnogao成立以来第一篇正式的日志 \n&emsp;&emsp;差不多两个多月前我开始了解idea,正式接触idea,都说这个比eclipse强大,的确用过才知道。但是对于我而言，刚开始理解是有点困难，难的不是idea这个软件的使用，而是还是java的一些配置文件，maven什么的。  \n\n&emsp;&emsp;这些内容我本身理解起来就有些障碍，但是结果这两个月的摸索也算学到了不少，我的这个博客还没有发布出去，因为服务器真心贵啊，买不起啊啊啊啊啊。。。  \n\n&emsp;&emsp;现在目前呢可以先这样，我先还是在本地上运行吧，以后有机会再放到服务器上。这个博客本身还有很多缺陷，不过大体上可以简单的以一种正常网站的形式运行了，以后慢慢改善吧~~~  \n\n&emsp;&emsp;不过我是真心觉得这个markdown不怎么好用，难道就没有别的方法嘛嘛嘛。。。。\n&emsp;&emsp;', '2017-01-13 13:48:47', '2017-01-13 13:48:47');
INSERT INTO `logs` VALUES ('1701191150', '2016年总结', '年度总结', '##### &emsp;今天是2016年我在图众意义上工作的最后一天\n##### &emsp;(明天大扫除年夜饭,大家都很忙,估计也不怎么工作了吧~)  \n##### &emsp;2016年4.5号是我进公司的第一天,也是人生中的第一天上班,那天很开心。至今我工作了，九个半月。这九个多月我完成了一个身份的转型，从学生生活到工作生活的转变，这其实对我来说还是比较困难的，学生的角色我一当就是16年，这是一项伟大的事业，没有之前的16年的成长就没有今天的我，原本我以为我还可以再多做几年学生的，可是梦想破灭了，但是也算是一种尝试，我不后悔尝试，也不奢望再来一次，只看日后道路如何了吧。\n##### &emsp;说说我的工作吧:\n##### &emsp;四年都是主修计算机专业，但是学校课堂里针对java开发方面的知识仅仅局限于java基础，并没有学的很深入。入职初期，我最先学习的是:虽然大学四年都是主修计算机专业，但是学校课堂里针对java开发方面的知识仅仅局限于java基础，并没有学的很深入。入职初期，我最先学习的是:  \n(1)**ssi框架**，我们公司用的就是这个ssi框架(即spring+srpingmvc+ibatise)。spring是企业级 Java 应用程序开发框架，Springmvc提供了模型-视图-控制的体系结构。iBATIS(持久层框架)是把实体类和sql语句之间建立了映射关系，这种策略可以允许开发人员自己来写合适的sql语句。然而针对持久层iBatise，现在用的比较多的就是mybatise持久层框架，这算是对ibatise的一种升级。我们公司的项目也应该与时俱进，以后有时间的话可以考虑采用mybatise来代替ibatise。之后学习的是:  \n(2)**maven**的相关知识，我们公司的项目建立的就是maven项目。其实对于maven的学习我也是理解能力有限，但也是一直都在学习中。下面是我对maven的一些简单的概念上的理解:\n&emsp;Apache Maven 是一套软件工程管理和整合工具。Maven 工程结构和内容被定义在pom.xml。POM 包含了关于工程和各种配置细节的信息，Maven 使用这些信息构建工程。POM 也包含了目标和插件。当执行一个任务或者目标时，Maven 会查找当前目录下的 POM，从其中读取所需要的配置信息，然后执行目标。每个工程应该只有一个 POM 文件。另一个比较重要的就是maven仓库。Maven 本地仓库保存的是我们工程的所有依赖jar包。当运行一次 Maven 构建，Maven 会自动下载所有依赖的 jar 文件到本地仓库中。这样避免了每次构建时都引用存放在远程机器上的依赖文件。maven还有中央仓库，是由 Maven 社区提供的仓库，其中包含了大量常用的库。\n上面两个知识算是java开发比较基础和重要的两个内容，也是我比较难以理解的两点，我也一直都在积累学习。  \n(3)第三点就说说我在公司项目中负责的工作内容。入职以后我一直都在参与爱发货的研发和版本迭代。参与过的产品模块有货源、专线、订单、用户还有56tc的用户认证等一些内容。刚刚参与项目的时候，我什么都不会，说的简单点就是不知道代码该写在哪里，幸好有同事帮我，我一直都记得是韩亚飞同事教我如何使用springmvc，说的简单点就是如何将数据库的数据经过处理拿到页面上，因为之前在学校里学过dao、servlet和controller层与层的关系，所以经过同事的讲解学的也比较快。后期的学习中也遇到了比较多的问题，在我自己的努力下还有同事的帮助下也都得到了解决，尤其是金磊同事教会了我很多。\n##### &emsp;其实不懂的地方还真的很多，做这个博客也是为了把学到的东西自己运用一遍。', '2017-01-19 11:50:33', '2017-01-19 11:50:33');
INSERT INTO `logs` VALUES ('1702061404', 'mybatise学习笔记', 'mybatise', '##### mybatis就是一个封装来jdbc的持久层框架，它和hibernate都属于ORM框架，但是具体的说，hibernate是一个完全的orm框架，而mybatis是一个不完全的orm框架。\n\n##### Mybatis让程序员只关注sql本身，而不需要去关注如连接的创建、statement的创建等操作。\n\n##### Mybatis会将输入参数、输出结果进行映射。', '2017-02-06 14:04:44', '2017-02-06 14:04:45');
INSERT INTO `logs` VALUES ('1702151722', 'Object常用公用方法', 'object类', '##### **①toString方法**\n	String toString()\n##### 该方法用得比较多，一般子类都有覆盖。\n##### **②equals方法**\n	boolean equals(Object obj)\n##### 该方法是非常重要的一个方法。一般equals和==是不一样的，但是在Object中两者是一样的。子类一般都要重写这个方法。\n##### **③hashCode方法**\n	int hashCode()\n##### 该方法用于哈希查找，可以减少在查找中使用equals的次数，重写了equals方法一般都要重写hashCode方法。这个方法在一些具有哈希功能的Collection中用到。\n\n##### 1.equals(obj2)==true。可以推出obj1.hash- Code()==obj2.ha一般必须满足obj1.equals(obj2)==true。可以推出obj1.hash- Code()==obj2.hashCode()，但是hashCode相等不一定就满足equals。不过为了提高效率，应该尽量使上面两个条件接近等价。\n##### ==:表示判断两个字符串在内存中首地址的地址是否相同\n##### equals:比较存储在两个字符串中对象中的内容是否相同\n##### 如果不重写hashcode(),在HashSet中添加两个equals的对象，会将两个对象都加入进去。\n##### **④wait方法**\n	void wait()\n##### wait方法就是使当前线程等待该对象的锁，当前线程必须是该对象的拥有者，也就是具有该对象的锁。wait()方法一直等待，直到获得锁或者被中断。wait(long timeout)设定一个超时间隔，如果在规定时间内没有获得锁就返回。\n\n##### 调用该方法后当前线程进入睡眠状态，直到以下事件发生。\n\n##### （1）其他线程调用了该对象的notify方法。\n\n##### （2）其他线程调用了该对象的notifyAll方法。\n\n##### （3）其他线程调用了interrupt中断该线程。\n\n##### （4）时间间隔到了。\n\n##### 此时该线程就可以被调度了，如果是被中断的话就抛出一个InterruptedException异常。此时该线程就可以被调度了，如果是被中断的话就抛出一个InterruptedException异常。\n##### **⑤notify方法**\n	void notify()\n##### 该方法唤醒在该对象上等待的某个线程。\n##### **⑥notifyAll方法**\n	void notifyAll()\n##### 该方法唤醒在该对象上等待的所有线程。\n##### **⑦clone方法**\n	protected Object clone()\n##### 保护方法，实现对象的浅复制，只有实现了Cloneable接口才可以调用该方法，否则抛出CloneNotSupportedException异常。\n##### 主要是JAVA里除了8种基本类型传参数是值传递，其他的类对象传参数都是引用传递，我们有时候不希望在方法里讲参数改变，这是就需要在类中复写clone方法。\n##### **⑧getClass方法**\n	Class<?> getClass()\n##### final方法，获得运行时类型。', '2017-02-15 17:22:36', '2017-02-15 17:22:36');
