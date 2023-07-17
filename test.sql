/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50509
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50509
 File Encoding         : 65001

 Date: 17/07/2023 22:53:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tbl_user
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user`  (
  `id` bigint(32) NOT NULL,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pwd` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `age` int(11) NOT NULL,
  `tel` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `deleted` int(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tbl_user
-- ----------------------------
INSERT INTO `tbl_user` VALUES (1, 'tom', '123', 12, '12345678911', 0);
INSERT INTO `tbl_user` VALUES (2, 'jetty', 'jetty', 13, '12345678912', 0);
INSERT INTO `tbl_user` VALUES (3, 'a', 'a', 10, '31234567891', 0);
INSERT INTO `tbl_user` VALUES (4, 'tom2', '123', 12, '12345678912', 0);
INSERT INTO `tbl_user` VALUES (5, 'tom2', '123', 12, '12345678912', 0);
INSERT INTO `tbl_user` VALUES (6, 'tom2', '123', 12, '12345678912', 0);

SET FOREIGN_KEY_CHECKS = 1;
