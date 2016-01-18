/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50529
Source Host           : localhost:3306
Source Database       : itimes_base

Target Server Type    : MYSQL
Target Server Version : 50529
File Encoding         : 65001

Date: 2016-01-15 09:24:00
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `category_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `category_name` varchar(64) NOT NULL,
  `category_type` tinyint(4) NOT NULL DEFAULT '0',
  `parent_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '1', 'updateing3333', '1', null);
INSERT INTO `category` VALUES ('2', '1', '第一类hh', '1', null);
INSERT INTO `category` VALUES ('4', '1', 'ggggg', '0', null);
INSERT INTO `category` VALUES ('5', '1', '中国人', '0', null);

-- ----------------------------
-- Table structure for `items`
-- ----------------------------
DROP TABLE IF EXISTS `items`;
CREATE TABLE `items` (
  `item_id` bigint(32) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `date` date NOT NULL,
  `category_id` bigint(20) NOT NULL,
  `location_id` bigint(20) DEFAULT NULL,
  `project_id` bigint(20) NOT NULL,
  `item` varchar(256) DEFAULT NULL,
  `tags` varchar(256) DEFAULT NULL,
  `duration` decimal(6,1) NOT NULL DEFAULT '0.0',
  `year` varchar(5) NOT NULL,
  `month` varchar(2) NOT NULL,
  `day` varchar(2) NOT NULL,
  `week` varchar(2) DEFAULT NULL,
  `user_name` varchar(64) DEFAULT NULL,
  `category_name` varchar(64) DEFAULT NULL,
  `project_name` varchar(64) DEFAULT NULL,
  `location_name` varchar(64) DEFAULT NULL,
  `result` varchar(2048) DEFAULT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of items
-- ----------------------------
INSERT INTO `items` VALUES ('1', '1', '2016-01-09', '1', '1', '1', 'test', 'test', '4.0', '2016', '01', '09', '01', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `items` VALUES ('2', '2', '2016-01-10', '1', '1', '1', 'test2', 'test', '3.0', '2016', '01', '10', '01', 'iyihua2', 'work', 'app', 'home', null);
INSERT INTO `items` VALUES ('3', '1', '2016-01-01', '1', '1', '1', 'test3', 'test', '2.0', '2016', '01', '01', '01', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `items` VALUES ('4', '1', '2016-01-20', '2', '1', '2', 'test4', 'test', '5.0', '2016', '01', '20', '02', 'iyihua', 'learn', 'apps', 'home', null);

-- ----------------------------
-- Table structure for `location`
-- ----------------------------
DROP TABLE IF EXISTS `location`;
CREATE TABLE `location` (
  `location_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `location` varchar(64) NOT NULL,
  `user_id` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`location_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of location
-- ----------------------------

-- ----------------------------
-- Table structure for `project`
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `project_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(64) NOT NULL,
  `user_id` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project
-- ----------------------------

-- ----------------------------
-- Table structure for `tags`
-- ----------------------------
DROP TABLE IF EXISTS `tags`;
CREATE TABLE `tags` (
  `tag_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tag_name` varchar(64) NOT NULL,
  `user_id` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tags
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `type` tinyint(4) NOT NULL DEFAULT '0',
  `password` varchar(64) NOT NULL,
  `enable` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'iyihua', '0', '', '0');
INSERT INTO `user` VALUES ('2', 'iyihua2', '1', '', '0');
