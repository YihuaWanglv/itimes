/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50529
Source Host           : localhost:3306
Source Database       : itimes_item

Target Server Type    : MYSQL
Target Server Version : 50529
File Encoding         : 65001

Date: 2016-01-06 09:17:21
*/

SET FOREIGN_KEY_CHECKS=0;
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
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of items
-- ----------------------------
