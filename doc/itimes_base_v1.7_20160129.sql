/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50529
Source Host           : localhost:3306
Source Database       : itimes_base

Target Server Type    : MYSQL
Target Server Version : 50529
File Encoding         : 65001

Date: 2016-01-29 18:55:04
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
-- Table structure for `item`
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `item_id` bigint(32) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `date` date NOT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  `location_id` bigint(20) DEFAULT NULL,
  `project_id` bigint(20) DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of item
-- ----------------------------
INSERT INTO `item` VALUES ('1', '1', '2016-01-09', '1', '1', '1', 'test', 'test', '4.0', '2016', '01', '09', '01', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('2', '2', '2016-01-10', '1', '1', '1', 'test2', 'test', '3.0', '2016', '01', '10', '01', 'iyihua2', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('3', '1', '2016-01-01', '1', '1', '1', 'test3', 'test', '2.0', '2016', '01', '01', '01', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('4', '1', '2016-01-20', '2', '1', '2', 'test4', 'test', '5.0', '2016', '01', '20', '02', 'iyihua', 'learn', 'apps', 'home', null);
INSERT INTO `item` VALUES ('5', '1', '2016-01-13', '1', '1', '1', '买菜app', null, '1.0', '2016', '01', '13', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('6', '1', '2016-01-13', '1', '1', '1', '做饭好好吃', null, '1.0', '2016', '01', '13', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('7', '1', '2016-01-13', '1', '1', '1', '天天不要停', null, '1.0', '2016', '01', '13', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('8', '1', '2016-01-13', '1', '1', '1', 'work on app style!!', null, '1.0', '2016', '01', '13', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('9', '1', '2016-01-13', '1', '1', '1', '2016-01-13', null, '1.0', '2016', '01', '13', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('10', '1', '2016-01-13', '1', '1', '1', '2016-01-13', null, '1.0', '2016', '01', '13', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('11', '1', '2016-01-13', '1', '1', '1', '2016-01-13', null, '1.0', '2016', '01', '13', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('12', '1', '2016-01-13', '1', '1', '1', '2016-01-13', null, '1.0', '2016', '01', '13', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('13', '1', '2016-01-13', '1', '1', '1', '2016-01-13', null, '1.0', '2016', '01', '13', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('14', '1', '2016-01-14', '1', '1', '1', '2016-01-14', null, '1.0', '2016', '01', '14', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('15', '1', '2016-01-14', '1', '1', '1', '2016-01-14', null, '1.0', '2016', '01', '14', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('16', '1', '2016-01-14', '1', '1', '1', '2016-01-14', null, '1.0', '2016', '01', '14', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('17', '1', '2016-01-14', '1', '1', '1', '2016-01-14', null, '1.0', '2016', '01', '14', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('18', '1', '2016-01-14', '1', '1', '1', '2016-01-14', null, '1.0', '2016', '01', '14', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('19', '1', '2016-01-14', '1', '1', '1', '2016-01-14', null, '1.0', '2016', '01', '14', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('20', '1', '2016-01-14', '1', '1', '1', '2016-01-14', null, '1.0', '2016', '01', '14', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('21', '1', '2016-01-15', '1', '1', '1', '2016-01-15', null, '1.0', '2016', '01', '15', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('22', '1', '2016-01-15', '1', '1', '1', '2016-01-15', null, '1.0', '2016', '01', '15', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('23', '1', '2016-01-15', '1', '1', '1', '2016-01-15', null, '1.0', '2016', '01', '15', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('24', '1', '2016-01-15', '1', '1', '1', '2016-01-15', null, '1.0', '2016', '01', '15', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('25', '1', '2016-01-15', '1', '1', '1', '2016-01-15', null, '1.0', '2016', '01', '15', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('26', '1', '2016-01-16', '1', '1', '1', '2016-01-16', null, '1.0', '2016', '01', '16', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('27', '1', '2016-01-16', '1', '1', '1', '2016-01-16', null, '1.0', '2016', '01', '16', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('28', '1', '2016-01-16', '1', '1', '1', '2016-01-16', null, '1.0', '2016', '01', '16', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('29', '1', '2016-01-16', '1', '1', '1', '2016-01-16', null, '1.0', '2016', '01', '16', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('30', '1', '2016-01-16', '1', '1', '1', '2016-01-16', null, '1.0', '2016', '01', '16', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('31', '1', '2016-01-16', '1', '1', '1', '2016-01-16', null, '1.0', '2016', '01', '16', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('32', '1', '2016-01-16', '1', '1', '1', '2016-01-16', null, '1.0', '2016', '01', '16', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('33', '1', '2016-01-17', '1', '1', '1', '2016-01-17', null, '1.0', '2016', '01', '17', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('34', '1', '2016-01-17', '1', '1', '1', '2016-01-17', null, '1.0', '2016', '01', '17', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('35', '1', '2016-01-17', '1', '1', '1', '2016-01-17', null, '1.0', '2016', '01', '17', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('36', '1', '2016-01-17', '1', '1', '1', '2016-01-17', null, '1.0', '2016', '01', '17', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('37', '1', '2016-01-17', '1', '1', '1', '2016-01-17', null, '1.0', '2016', '01', '17', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('38', '1', '2016-01-18', '1', '1', '1', '2016-01-18', null, '1.0', '2016', '01', '18', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('39', '1', '2016-01-18', '1', '1', '1', '2016-01-18', null, '1.0', '2016', '01', '18', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('40', '1', '2016-01-18', '1', '1', '1', '2016-01-18', null, '1.0', '2016', '01', '18', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('41', '1', '2016-01-18', '1', '1', '1', '2016-01-18', null, '1.0', '2016', '01', '18', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('42', '1', '2016-01-18', '1', '1', '1', '2016-01-18', null, '1.0', '2016', '01', '18', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('43', '1', '2016-01-18', '1', '1', '1', '2016-01-18', null, '1.0', '2016', '01', '18', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('44', '1', '2016-01-19', '1', '1', '1', '2016-01-19', null, '1.0', '2016', '01', '19', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('45', '1', '2016-01-19', '1', '1', '1', '2016-01-19', null, '1.0', '2016', '01', '19', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('46', '1', '2016-01-19', '1', '1', '1', '2016-01-19', null, '1.0', '2016', '01', '19', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('47', '1', '2016-01-19', '1', '1', '1', '2016-01-19', null, '1.0', '2016', '01', '19', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('48', '1', '2016-01-19', '1', '1', '1', '2016-01-19', null, '1.0', '2016', '01', '19', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('49', '1', '2016-01-19', '1', '1', '1', '2016-01-19', null, '1.0', '2016', '01', '19', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('50', '1', '2016-01-20', '1', '1', '1', '2016-01-20', null, '1.0', '2016', '01', '20', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('51', '1', '2016-01-20', '1', '1', '1', '2016-01-20', null, '1.0', '2016', '01', '20', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('52', '1', '2016-01-20', '1', '1', '1', '2016-01-20', null, '1.0', '2016', '01', '20', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('53', '1', '2016-01-20', '1', '1', '1', '2016-01-20', null, '1.0', '2016', '01', '20', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('54', '1', '2016-01-20', '1', '1', '1', '2016-01-20', null, '1.0', '2016', '01', '20', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('55', '1', '2016-01-20', '1', '1', '1', '2016-01-20', null, '1.0', '2016', '01', '20', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('56', '1', '2016-01-21', '1', '1', '1', '2016-01-21', null, '1.0', '2016', '01', '21', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('57', '1', '2016-01-21', '1', '1', '1', '2016-01-21', null, '1.0', '2016', '01', '21', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('58', '1', '2016-01-21', '1', '1', '1', '2016-01-21', null, '1.0', '2016', '01', '21', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('59', '1', '2016-01-21', '1', '1', '1', '2016-01-21', null, '1.0', '2016', '01', '21', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('60', '1', '2016-01-21', '1', '1', '1', '2016-01-21', null, '1.0', '2016', '01', '21', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('61', '1', '2016-01-21', '1', '1', '1', '2016-01-21', null, '1.0', '2016', '01', '21', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('62', '1', '2016-01-22', '1', '1', '1', '2016-01-22', null, '1.0', '2016', '01', '22', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('63', '1', '2016-01-22', '1', '1', '1', '2016-01-22', null, '1.0', '2016', '01', '22', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('64', '1', '2016-01-22', '1', '1', '1', '2016-01-22', null, '1.0', '2016', '01', '22', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('65', '1', '2016-01-22', '1', '1', '1', '2016-01-22', null, '1.0', '2016', '01', '22', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('66', '1', '2016-01-23', '1', '1', '1', 'work on web', null, '1.0', '2016', '01', '23', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('67', '1', '2016-01-23', '1', '1', '1', 'work on app', null, '1.0', '2016', '01', '23', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('68', '1', '2016-01-23', '1', '1', '1', 'using english', null, '1.0', '2016', '01', '23', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('69', '1', '2016-01-23', '1', '1', '1', '无敌风火轮', null, '1.0', '2016', '01', '23', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('70', '1', '2016-01-23', '1', '1', '1', '做饭好好吃', null, '1.0', '2016', '01', '23', '20', 'iyihua', 'work', 'app', 'home', null);
INSERT INTO `item` VALUES ('71', '1', '2016-01-29', '2', '1', '2', '地方发的佛挡杀佛都是', '', '2.0', '2016', '1', '29', '5', null, '第一类hh', 'test', null, null);

-- ----------------------------
-- Table structure for `location`
-- ----------------------------
DROP TABLE IF EXISTS `location`;
CREATE TABLE `location` (
  `location_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `location` varchar(64) NOT NULL,
  `user_id` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`location_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of location
-- ----------------------------
INSERT INTO `location` VALUES ('1', 'home', '1');
INSERT INTO `location` VALUES ('2', 'company', '1');

-- ----------------------------
-- Table structure for `project`
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `project_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(64) NOT NULL,
  `user_id` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`project_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES ('1', 'app432434fdfsdfd', '1');
INSERT INTO `project` VALUES ('2', 'test', '1');
INSERT INTO `project` VALUES ('3', 'addingfsfsddsf', '1');
INSERT INTO `project` VALUES ('4', 'test22222', '2');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(4) NOT NULL,
  `role_name` varchar(64) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'user');
INSERT INTO `role` VALUES ('2', 'admin');

-- ----------------------------
-- Table structure for `tag`
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag` (
  `tag_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tag_name` varchar(64) NOT NULL,
  `user_id` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`tag_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tag
-- ----------------------------
INSERT INTO `tag` VALUES ('1', 'testtags', '1');

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
INSERT INTO `user` VALUES ('1', 'iyihua', '0', '123456', '1');
INSERT INTO `user` VALUES ('2', 'iyihua2', '1', '123456', '1');

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` int(4) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1');
INSERT INTO `user_role` VALUES ('1', '2');
INSERT INTO `user_role` VALUES ('2', '1');
