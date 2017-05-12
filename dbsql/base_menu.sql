/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : ssm

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2017-05-12 09:46:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for base_menu
-- ----------------------------
DROP TABLE IF EXISTS `base_menu`;
CREATE TABLE `base_menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT,
  `p_menu_id` int(11) DEFAULT NULL,
  `menu_name` varchar(50) DEFAULT NULL,
  `menu_url` varchar(100) DEFAULT NULL,
  `menu_type` varchar(20) DEFAULT NULL COMMENT '显示类别0、用户1、管理员2、常规',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10010 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_menu
-- ----------------------------
INSERT INTO `base_menu` VALUES ('10001', null, '首页', '/crainnogao/?pageNum=1', '2');
INSERT INTO `base_menu` VALUES ('10002', null, '归档', '/crainnogao/documents', '0');
INSERT INTO `base_menu` VALUES ('10003', null, '相册', '/crainnogao/album', '0');
INSERT INTO `base_menu` VALUES ('10004', null, '微博', '/crainnogao/weibo', '0');
INSERT INTO `base_menu` VALUES ('10005', null, '统计', '/crainnogao/statistics', '0');
INSERT INTO `base_menu` VALUES ('10006', null, '关于', '/crainnogao/about', '0');
INSERT INTO `base_menu` VALUES ('10007', null, '发表日志', null, '1');
INSERT INTO `base_menu` VALUES ('10008', null, '查看日志', null, '1');
INSERT INTO `base_menu` VALUES ('10009', null, '用户管理', null, '1');
