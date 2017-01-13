/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : ssm

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2017-01-13 16:02:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for feed
-- ----------------------------
DROP TABLE IF EXISTS `feed`;
CREATE TABLE `feed` (
  `id` int(11) NOT NULL,
  `log_id` varchar(15) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `feed_content` varchar(500) DEFAULT NULL,
  `feed_time` datetime DEFAULT NULL,
  `status` varchar(2) DEFAULT NULL COMMENT '状态:0无效1有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of feed
-- ----------------------------
