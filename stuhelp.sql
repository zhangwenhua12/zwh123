/*
 Navicat MySQL Data Transfer

 Source Server         : abc
 Source Server Type    : MySQL
 Source Server Version : 50540
 Source Host           : localhost:3306
 Source Schema         : stuhelp

 Target Server Type    : MySQL
 Target Server Version : 50540
 File Encoding         : 65001

 Date: 08/08/2019 19:40:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bbs
-- ----------------------------
DROP TABLE IF EXISTS `bbs`;
CREATE TABLE `bbs`  (
  `studentid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `studentname` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `createtime` time NOT NULL,
  `detail` varchar(1500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `good` int(11) DEFAULT 0,
  `detial` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`studentid`, `createtime`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bbs
-- ----------------------------
INSERT INTO `bbs` VALUES ('2016211001001031', '卢', '马上毕业了', '00:20:19', '大家好，哈哈哈哈', 1, NULL);

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `commentid` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `groupid` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `postid` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `commenterid` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `commentcontent` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `commenttime` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  INDEX `com1`(`groupid`) USING BTREE,
  INDEX `com2`(`postid`) USING BTREE,
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`groupid`) REFERENCES `grouping` (`groupid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`postid`) REFERENCES `post` (`postid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '1', '1', '123', '好好准备考试', '2019-7-26-18-55-25');
INSERT INTO `comment` VALUES ('2', '1', '1', '123', '文言文好难啊', '2019-7-26-18-53-22');
INSERT INTO `comment` VALUES ('3', '1', '1', '123', '英语考试加油啊', '2019-7-26-18-53-22');

-- ----------------------------
-- Table structure for coursetable
-- ----------------------------
DROP TABLE IF EXISTS `coursetable`;
CREATE TABLE `coursetable`  (
  `studentid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `classNo` int(11) NOT NULL,
  `mon` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '',
  `tue` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '',
  `wed` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '',
  `thu` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '',
  `fri` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '',
  `sat` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '',
  `sun` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '',
  PRIMARY KEY (`studentid`, `classNo`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '课程表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of coursetable
-- ----------------------------
INSERT INTO `coursetable` VALUES ('123', 1, '高数', '', '', '', '', '', '');
INSERT INTO `coursetable` VALUES ('123', 2, '', '文言文', '', '', '', '', '');
INSERT INTO `coursetable` VALUES ('123', 3, '', '', '语文', '', '', '', '高数');
INSERT INTO `coursetable` VALUES ('123', 4, '', '', '', '数学', '', '数学', '');
INSERT INTO `coursetable` VALUES ('123', 5, '', '', '', '', '英语', '', '');
INSERT INTO `coursetable` VALUES ('12345', 1, '', '', '', '', '', '', '');
INSERT INTO `coursetable` VALUES ('12345', 2, '高数', '', '', '', '', '', '');
INSERT INTO `coursetable` VALUES ('12345', 3, '', '', '语文', '数学', '', '', '高数');
INSERT INTO `coursetable` VALUES ('12345', 4, '', '高数', '', '', '', '数学', '');
INSERT INTO `coursetable` VALUES ('12345', 5, '', '', '', '', '文言文', '', '');
INSERT INTO `coursetable` VALUES ('123456', 1, '语文', '', '', '', '', '', '');
INSERT INTO `coursetable` VALUES ('123456', 2, '', '语文', '', '', '', '', '');
INSERT INTO `coursetable` VALUES ('123456', 3, '', '', '语文', '', '', '', '');
INSERT INTO `coursetable` VALUES ('123456', 4, '', '', '语文', '', '', '', '');
INSERT INTO `coursetable` VALUES ('123456', 5, '', '', '', '语文', '', '', '');
INSERT INTO `coursetable` VALUES ('2016211001001031', 1, '', '', '', '', '', '', '');
INSERT INTO `coursetable` VALUES ('2016211001001031', 2, '', '', '', '', '', '', '');
INSERT INTO `coursetable` VALUES ('2016211001001031', 3, '', '', '', '', '', '', '');
INSERT INTO `coursetable` VALUES ('2016211001001031', 4, '', '', '', '', '', '', '');
INSERT INTO `coursetable` VALUES ('2016211001001031', 5, '', '', '', '', '', '', '');

-- ----------------------------
-- Table structure for examschedule
-- ----------------------------
DROP TABLE IF EXISTS `examschedule`;
CREATE TABLE `examschedule`  (
  `studentid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `examname` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `examtime` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `examplace` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `createtime` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`createtime`, `studentid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of examschedule
-- ----------------------------
INSERT INTO `examschedule` VALUES ('12345', 'JLPT N2', '2018-07-01', '日语二级考试', '大连理工大学外国语学院', '2018-03-27-22-22-31');
INSERT INTO `examschedule` VALUES ('12345', 'CET 6', '2018-06-28', '大学英语六级考试', '学汇楼', '2018-03-27-22-22-40');

-- ----------------------------
-- Table structure for filesys
-- ----------------------------
DROP TABLE IF EXISTS `filesys`;
CREATE TABLE `filesys`  (
  `fileid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `filename` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `size` double NOT NULL,
  `createtime` datetime NOT NULL,
  PRIMARY KEY (`fileid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for good
-- ----------------------------
DROP TABLE IF EXISTS `good`;
CREATE TABLE `good`  (
  `topicstudentid` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createtime` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `goodstudentid` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`topicstudentid`, `createtime`, `goodstudentid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of good
-- ----------------------------
INSERT INTO `good` VALUES ('2016211001001031', '2019-07-09-16-36-55', '2016211001001031');

-- ----------------------------
-- Table structure for grouping
-- ----------------------------
DROP TABLE IF EXISTS `grouping`;
CREATE TABLE `grouping`  (
  `groupid` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `groupcreid` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `groupname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `groupnum` int(10) DEFAULT NULL,
  `post` int(10) DEFAULT NULL,
  `createtime` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `groupintroduce` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`groupid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of grouping
-- ----------------------------
INSERT INTO `grouping` VALUES ('1', '12345', '高数', 2, 3, '2019-7-28-18-49-23', '学习高等数学');
INSERT INTO `grouping` VALUES ('2', '12345', '文言文', 2, 2, '2019-7-28-15-49-23', '学习文言文');
INSERT INTO `grouping` VALUES ('3', '12345', '英语', 2, 2, '2019-7-26-15-49-23', '学习英语');

-- ----------------------------
-- Table structure for memo
-- ----------------------------
DROP TABLE IF EXISTS `memo`;
CREATE TABLE `memo`  (
  `studentid` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createtime` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `title` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `detail` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `home` int(2) DEFAULT NULL COMMENT '首页推送 1:是 0:否',
  PRIMARY KEY (`studentid`, `createtime`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of memo
-- ----------------------------
INSERT INTO `memo` VALUES ('12345', '2018-03-29-16-10-25', '完成数据结构笔记', '今天学习第六章的知识          \n---------------------------------------\n完成关于B树的笔记               \n---------------------------------------\n复习链表结点的删除和添加\n--------------------------------------\n完成课后练习', 1);
INSERT INTO `memo` VALUES ('12345', '2018-04-05-14-48-22', '社团招新', '计算机学社招新开始\n\n周三下午去大学生活动中心进行商讨招新相关事宜', 1);
INSERT INTO `memo` VALUES ('12345', '2019-07-09-16-32-43', '卢', '哈哈哈哈', 1);
INSERT INTO `memo` VALUES ('qq200258', '2018-04-19-20-42-08', '自习', '1', 1);

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post`  (
  `postid` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `groupid` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `posterid` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `posttime` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `commentnum` int(10) DEFAULT NULL,
  `topic` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `content` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`postid`) USING BTREE,
  INDEX `post`(`groupid`) USING BTREE,
  CONSTRAINT `post_ibfk_1` FOREIGN KEY (`groupid`) REFERENCES `grouping` (`groupid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES ('1', '1', '12345', '2019-7-26-18-53-22', 3, '高数', '马上要进行高数考试了');
INSERT INTO `post` VALUES ('2', '1', '12345', '2019-7-26-18-53-22', 2, '文言文', '语文考试要开始了');
INSERT INTO `post` VALUES ('3', '1', '12345', '2019-7-26-18-53-22', 1, '英语', '大学生英语考试');

-- ----------------------------
-- Table structure for redundant
-- ----------------------------
DROP TABLE IF EXISTS `redundant`;
CREATE TABLE `redundant`  (
  `userid` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `groupid` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `permissions` int(10) DEFAULT NULL,
  INDEX `bb`(`userid`) USING BTREE,
  INDEX `bb1`(`groupid`) USING BTREE,
  CONSTRAINT `redundant_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`username`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `redundant_ibfk_2` FOREIGN KEY (`groupid`) REFERENCES `grouping` (`groupid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of redundant
-- ----------------------------
INSERT INTO `redundant` VALUES ('12345', '1', 2);
INSERT INTO `redundant` VALUES ('123', '1', 0);

-- ----------------------------
-- Table structure for relationship
-- ----------------------------
DROP TABLE IF EXISTS `relationship`;
CREATE TABLE `relationship`  (
  `userid` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `friendid` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `relationstate` int(5) NOT NULL,
  INDEX `fe`(`userid`) USING BTREE,
  INDEX `fer`(`friendid`) USING BTREE,
  CONSTRAINT `fe` FOREIGN KEY (`userid`) REFERENCES `user` (`username`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fer` FOREIGN KEY (`friendid`) REFERENCES `user` (`username`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `username` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `sex` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `collage` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '所在学院',
  `major` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '专业',
  `grade` int(11) DEFAULT NULL COMMENT '年级',
  `classno` int(11) DEFAULT NULL COMMENT '班级',
  `phone` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `identity` int(11) DEFAULT NULL,
  `introduction` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '这家伙很懒,什么也没留下',
  `isphonesecret` tinyint(1) DEFAULT 1,
  `ismailsecret` tinyint(4) DEFAULT 1,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '1：学生\n2：教职工' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('123', '123', '下面', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '这家伙很懒,什么也没留下', 1, 1);
INSERT INTO `user` VALUES ('12345', '1', '测试11', '男', '信息科学技术学院', '软件工程', 2016, 4, '13012345678', '12346@qq.com', 1, '这个人很懒，什么也没留下', 1, 0);
INSERT INTO `user` VALUES ('123456', '1111', '小美', '女', '国际学院', '软件开发', 2016, 5, '13869548975', '1942986748@qq.com', 0, '这家伙很懒,什么也没留下', 1, 1);
INSERT INTO `user` VALUES ('201621100100103', 'wen123456', '测试10', '男', '软件学院', '移动开发', 2018, 1, '15279421143', '123456@qq.com', NULL, '这家伙很懒,什么也没留下', 1, 1);
INSERT INTO `user` VALUES ('2016211001001031', 'wen12345678', '卢', '男', '软件学院', '移动开发', 2016, 4, '13755245280', '3329997883@qq.com', 1, '我喜欢打游戏', 0, 0);
INSERT INTO `user` VALUES ('2016211001001032', 'zwh123456', '李哥', '男', '软件学院', '移动开发', 2016, 4, '18179421142', '12635621@4214325', NULL, '这家伙很懒,什么也没留下', 1, 1);
INSERT INTO `user` VALUES ('2016211001001033', 'zwh123456', '小吴', '男', '软件学院', '移动开发', 2018, 2, '13755245280', '12635621@4214325', NULL, '这家伙很懒,什么也没留下', 1, 1);

SET FOREIGN_KEY_CHECKS = 1;
