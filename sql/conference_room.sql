/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50635
Source Host           : localhost:3306
Source Database       : conference_room

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2019-02-12 22:28:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for reservation
-- ----------------------------
DROP TABLE IF EXISTS `reservation`;
CREATE TABLE `reservation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `room_id` int(11) DEFAULT NULL,
  `user` varchar(32) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `begintime` time DEFAULT NULL,
  `endtime` time DEFAULT NULL,
  `mark` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_reservation_room` (`room_id`),
  CONSTRAINT `fk_reservation_room` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reservation
-- ----------------------------
INSERT INTO `reservation` VALUES ('1', '1', 'ordinary', '13988888888', '2018-01-02', '13:30:00', '15:00:00', '审核通过');
INSERT INTO `reservation` VALUES ('2', '2', 'ordinary', '13988888888', '2018-01-06', '15:00:00', '16:30:00', '审核通过');
INSERT INTO `reservation` VALUES ('3', '1', 'ordinary', '13988888888', '2018-01-08', '09:00:00', '11:00:00', '审核通过');
INSERT INTO `reservation` VALUES ('4', '1', 'ordinary', '13988888888', '2018-01-09', '15:00:00', '16:30:00', '审核通过');
INSERT INTO `reservation` VALUES ('5', '3', 'ordinary', '13988888888', '2018-01-12', '10:00:00', '12:00:00', '审核通过');
INSERT INTO `reservation` VALUES ('6', '2', 'ordinary', '13988888888', '2018-01-12', '13:00:00', '15:00:00', '审核通过');
INSERT INTO `reservation` VALUES ('8', '1', 'ordinary', '13988888888', '2018-01-22', '09:00:00', '10:00:00', '取消申请');
INSERT INTO `reservation` VALUES ('9', '1', 'ordinary', '13988888888', '2018-01-22', '10:30:00', '11:30:00', '待审核');
INSERT INTO `reservation` VALUES ('10', '2', 'ordinary', '13988888888', '2018-01-22', '15:00:00', '17:00:00', '审核通过');
INSERT INTO `reservation` VALUES ('11', '3', 'ordinary', '13988888888', '2018-01-22', '10:00:00', '12:00:00', '待审核');
INSERT INTO `reservation` VALUES ('12', '3', 'ordinary', '13988888888', '2018-01-23', '09:00:00', '10:00:00', '审核通过');
INSERT INTO `reservation` VALUES ('13', '1', 'ordinary', '13988888888', '2018-01-24', '09:00:00', '10:00:00', '取消申请');
INSERT INTO `reservation` VALUES ('14', '1', 'ordinary', '13988888888', '2018-02-02', '09:00:00', '10:00:00', '审核通过');
INSERT INTO `reservation` VALUES ('15', '1', '201801', '13988888888', '2018-02-10', '09:00:00', '10:00:00', '待审核');
INSERT INTO `reservation` VALUES ('16', '3', '201801', '13988888888', '2018-02-10', '10:00:00', '11:00:00', '待审核');
INSERT INTO `reservation` VALUES ('17', '1', '201801', '13988888888', '2018-02-10', '00:30:00', '13:30:00', '审核通过');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL,
  `role_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'admin');
INSERT INTO `role` VALUES ('2', 'ordinary');

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL,
  `message` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES ('1', 'J305', '大型会议室，可使用多媒体，适合开会、讲座');
INSERT INTO `room` VALUES ('2', '第一会议室327', '能够使用多媒体，适合组会，论文答辩');
INSERT INTO `room` VALUES ('3', '第三会议室329', '能够使用多媒体，适合开组会，硕/博士毕业论文答辩');
INSERT INTO `room` VALUES ('4', 'J123', '大型会议室，可容纳200人，适合举办讲座');
INSERT INTO `room` VALUES ('5', 'J226', '小包间会议室，适合小组讨论');
INSERT INTO `room` VALUES ('6', 'J211', '小会议室，适合二十人小型会议，含多媒体');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `role` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_role` (`role`),
  CONSTRAINT `fk_user_role` FOREIGN KEY (`role`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('201801', '123', '2');
INSERT INTO `user` VALUES ('admin', 'emadmin', '1');
INSERT INTO `user` VALUES ('ordinary', '123456', '2');
