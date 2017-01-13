/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : ssm

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2017-01-13 16:01:04
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
INSERT INTO `logs` VALUES ('170113134847', 'crainnogao博客前言', '前言', '##### 这是crainnogao成立以来第一篇正式的日志 \n&emsp;&emsp;差不多两个多月前我开始了解idea,正式接触idea,都说这个比eclipse强大,的确用过才知道。但是对于我而言，刚开始理解是有点困难，难的不是idea这个软件的使用，而是还是java的一些配置文件，maven什么的。  \n\n&emsp;&emsp;这些内容我本身理解起来就有些障碍，但是结果这两个月的摸索也算学到了不少，我的这个博客还没有发布出去，因为服务器真心贵啊，买不起啊啊啊啊啊。。。  \n\n&emsp;&emsp;现在目前呢可以先这样，我先还是在本地上运行吧，以后有机会再放到服务器上。这个博客本身还有很多缺陷，不过大体上可以简单的以一种正常网站的形式运行了，以后慢慢改善吧~~~  \n\n&emsp;&emsp;不过我是真心觉得这个markdown不怎么好用，难道就没有别的方法嘛嘛嘛。。。。\n&emsp;&emsp;', '2017-01-13 13:48:47', '2017-01-13 13:48:47');
INSERT INTO `logs` VALUES ('170113135436', 'test', 'test', '##### 这是crainnogao成立以来第一篇正式的日志 \n<font size=6>&emsp;&emsp;差不多两个多月前我开始了解idea,正式接触idea,都说这个比eclipse强大,的确用过才知道。但是对于我而言，刚开始理解是有点困难，难的不是idea这个软件的使用，而是还是java的一些配置文件，maven什么的。  \n\n&emsp;&emsp;这些内容我本身理解起来就有些障碍，但是结果这两个月的摸索也算学到了不少，我的这个博客还没有发布出去，因为服务器真心贵啊，买不起啊啊啊啊啊。。。  \n\n&emsp;&emsp;现在目前呢可以先这样，我先还是在本地上运行吧，以后有机会再放到服务器上。这个博客本身还有很多缺陷，不过大体上可以简单的以一种正常网站的形式运行了，以后慢慢改善吧~~~  \n\n&emsp;&emsp;不过我是真心觉得这个markdown不怎么好用，难道就没有别的方法嘛嘛嘛。。。。</font>', '2017-01-13 13:54:36', '2017-01-13 13:54:36');
INSERT INTO `logs` VALUES ('170113135643', 'markdown标题大小', '标题', '# 这是H1\n## 这是H2\n### 这是H3\n#### 这是H4\n##### 这是H5\n###### 这是H6', '2017-01-13 13:56:43', '2017-01-13 13:56:43');
