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
INSERT INTO `logs` VALUES ('170113134846', '范围而服人父母让你看积分', '饭卡里让你飞', '##### 什么是cookie?  \n	cookie 是存储于访问者的计算机中的变量。每当同一台计算机通过浏览器请求某个页面时，就会发送这个 cookie。你可以使用 JavaScript 来创建和取回 cookie 的值。\n##### 创建和存储\n	var exdate=new Date(); //当前时间\n	exdate=setDate(exdate.getDate()+expiredays) \n	\n##### 读取cookie\n\n	var uid = document.cookie.substring(4);\n	var userName = document.cookie.substring(9);\n', '2017-01-18 16:17:34', '2017-01-18 16:17:34');
INSERT INTO `logs` VALUES ('170113134847', 'crainnogao博客前言', '前言', '##### 这是crainnogao成立以来第一篇正式的日志 \n&emsp;&emsp;差不多两个多月前我开始了解idea,正式接触idea,都说这个比eclipse强大,的确用过才知道。但是对于我而言，刚开始理解是有点困难，难的不是idea这个软件的使用，而是还是java的一些配置文件，maven什么的。  \n\n&emsp;&emsp;这些内容我本身理解起来就有些障碍，但是结果这两个月的摸索也算学到了不少，我的这个博客还没有发布出去，因为服务器真心贵啊，买不起啊啊啊啊啊。。。  \n\n&emsp;&emsp;现在目前呢可以先这样，我先还是在本地上运行吧，以后有机会再放到服务器上。这个博客本身还有很多缺陷，不过大体上可以简单的以一种正常网站的形式运行了，以后慢慢改善吧~~~  \n\n&emsp;&emsp;不过我是真心觉得这个markdown不怎么好用，难道就没有别的方法嘛嘛嘛。。。。\n&emsp;&emsp;', '2017-01-13 13:48:47', '2017-01-13 13:48:47');
INSERT INTO `logs` VALUES ('170113135643', 'markdown标题大小', '标题', '# 这是H1\n## 这是H2\n### 这是H3\n#### 这是H4\n##### 这是H5\n###### 这是H6', '2017-01-13 13:56:43', '2017-01-13 13:56:43');
INSERT INTO `logs` VALUES ('170118160613', 'js cookie 用法', 'cookie', '##### 什么是cookie?  \n	cookie 是存储于访问者的计算机中的变量。每当同一台计算机通过浏览器请求某个页面时，就会发送这个 cookie。你可以使用 JavaScript 来创建和取回 cookie 的值。\n##### 创建和存储 cookie\n	var exdate=new Date(); //当前时间\n	exdate=setDate(exdate.getDate()+expiredays) \n	document.cookie = \"uid=\"+resp.data.uid+\"expires=\"+exdate;\n	document.cookie = \"name=\"+resp.data.userName+\"expires=\"+exdate;\n##### 读取cookie\n	var uid = document.cookie.substring(4);\n	var userName = document.cookie.substring(9);', '2017-01-18 16:06:13', '2017-01-18 16:06:13');
INSERT INTO `logs` VALUES ('170118160931', '如何创建和获取cookies', 'JavaScript Cookies', '##### 什么是cookie?  \n	cookie 是存储于访问者的计算机中的变量。每当同一台计算机通过浏览器请求某个页面时，就会发送这个 cookie。你可以使用 JavaScript 来创建和取回 cookie 的值。\n##### 创建和存储 cookie\n```\n	var exdate=new Date(); //当前时间\n	exdate=setDate(exdate.getDate()+expiredays) \n	document.cookie = \"uid=\"+resp.data.uid+\"expires=\"+exdate;\n	document.cookie = \"name=\"+resp.data.userName+\"expires=\"+exdate;\n```\n##### 读取cookie\n```\n	var uid = document.cookie.substring(4);\n	var userName = document.cookie.substring(9);\n```', '2017-01-18 16:09:31', '2017-01-18 16:09:31');

