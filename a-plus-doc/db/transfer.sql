/*
Navicat MySQL Data Transfer

Source Server         : localhost(123456)
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : transfer

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2018-01-17 11:36:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `o_id` int(11) NOT NULL,
  `pid` int(11) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`o_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', '1', '11.00');
INSERT INTO `orders` VALUES ('2', '1', '22.00');
INSERT INTO `orders` VALUES ('3', '1', '33.00');
INSERT INTO `orders` VALUES ('4', '1', '44.00');
INSERT INTO `orders` VALUES ('5', '1', '55.00');
INSERT INTO `orders` VALUES ('6', '2', '55.00');
INSERT INTO `orders` VALUES ('7', '2', '55.00');

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `p_id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES ('1', 'jack');
INSERT INTO `person` VALUES ('2', 'lucy');

-- ----------------------------
-- Table structure for seckill
-- ----------------------------
DROP TABLE IF EXISTS `seckill`;
CREATE TABLE `seckill` (
  `seckill_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品库存ID',
  `name` varchar(120) NOT NULL COMMENT '商品名称',
  `number` int(11) NOT NULL COMMENT '库存数量',
  `start_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '秒杀开始时间',
  `end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '秒杀结束时间',
  `create_time` timestamp NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`seckill_id`),
  KEY `idx_start_time` (`start_time`),
  KEY `idx_end_time` (`end_time`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=1050 DEFAULT CHARSET=utf8 COMMENT='秒杀库存表';

-- ----------------------------
-- Records of seckill
-- ----------------------------
INSERT INTO `seckill` VALUES ('1000', '1000元秒杀iphone6', '100', '2017-07-13 17:42:26', '2017-05-09 00:00:00', '2017-03-21 13:48:11');
INSERT INTO `seckill` VALUES ('1001', '800元秒杀ipad', '200', '2017-07-13 17:42:32', '2017-05-08 00:00:00', '2017-03-21 13:48:11');
INSERT INTO `seckill` VALUES ('1002', '6600元秒杀mac book pro', '300', '2017-04-23 10:18:24', '2017-04-25 00:00:00', '2017-03-21 13:48:11');
INSERT INTO `seckill` VALUES ('1003', '7000元秒杀iMac', '400', '2017-04-23 10:18:26', '2017-04-25 00:00:00', '2017-03-21 13:48:11');
INSERT INTO `seckill` VALUES ('1032', '测试6', '9', '2017-07-17 11:36:53', '2017-07-17 11:36:53', '2017-07-17 11:36:53');
INSERT INTO `seckill` VALUES ('1033', '测试7', '9', '2017-07-17 11:36:53', '2017-07-17 11:36:53', '2017-07-17 11:36:53');
INSERT INTO `seckill` VALUES ('1034', '测试8', '9', '2017-07-17 11:36:53', '2017-07-17 11:36:53', '2017-07-17 11:36:53');
INSERT INTO `seckill` VALUES ('1035', '测试9', '9', '2017-07-17 11:36:53', '2017-07-17 11:36:53', '2017-07-17 11:36:53');
INSERT INTO `seckill` VALUES ('1036', '测试', '9', '2017-07-17 13:28:31', '2017-07-17 13:28:31', '2017-07-17 13:28:31');
INSERT INTO `seckill` VALUES ('1037', '测试0', '9', '2017-07-17 13:28:31', '2017-07-17 13:28:31', '2017-07-17 13:28:31');
INSERT INTO `seckill` VALUES ('1038', '测试1', '9', '2017-07-17 13:28:31', '2017-07-17 13:28:31', '2017-07-17 13:28:31');
INSERT INTO `seckill` VALUES ('1039', '测试2', '9', '2017-07-17 13:28:31', '2017-07-17 13:28:31', '2017-07-17 13:28:31');
INSERT INTO `seckill` VALUES ('1040', '测试3', '9', '2017-07-17 13:28:31', '2017-07-17 13:28:31', '2017-07-17 13:28:31');
INSERT INTO `seckill` VALUES ('1041', '测试4', '9', '2017-07-17 13:28:31', '2017-07-17 13:28:31', '2017-07-17 13:28:31');
INSERT INTO `seckill` VALUES ('1042', '测试5', '9', '2017-07-17 13:28:31', '2017-07-17 13:28:31', '2017-07-17 13:28:31');
INSERT INTO `seckill` VALUES ('1043', '测试6', '9', '2017-07-17 13:28:31', '2017-07-17 13:28:31', '2017-07-17 13:28:31');
INSERT INTO `seckill` VALUES ('1044', '测试7', '9', '2017-07-17 13:28:31', '2017-07-17 13:28:31', '2017-07-17 13:28:31');
INSERT INTO `seckill` VALUES ('1045', '飞龙在天2', '18', '2017-07-17 13:39:39', '2017-07-17 13:28:31', '2017-07-17 13:28:31');
INSERT INTO `seckill` VALUES ('1046', '飞龙在天2', '18', '2017-07-17 14:12:09', '2017-07-17 13:28:31', '2017-07-17 13:28:31');
INSERT INTO `seckill` VALUES ('1047', '飞龙在天', '19', '2017-07-17 13:35:41', '2017-07-17 13:35:41', '2017-07-17 13:35:41');
INSERT INTO `seckill` VALUES ('1048', '飞龙在天2', '18', '2017-07-17 13:35:41', '2017-07-17 13:35:41', '2017-07-17 13:35:41');
INSERT INTO `seckill` VALUES ('1049', '飞龙在天3', '17', '2017-07-17 13:35:41', '2017-07-17 13:35:41', '2017-07-17 13:35:41');

-- ----------------------------
-- Table structure for success_killed
-- ----------------------------
DROP TABLE IF EXISTS `success_killed`;
CREATE TABLE `success_killed` (
  `seckill_id` bigint(20) NOT NULL COMMENT '秒杀商品ID',
  `user_phone` bigint(20) NOT NULL COMMENT '用户手机号',
  `state` tinyint(4) NOT NULL DEFAULT -1 COMMENT '状态标识:-1:无效 0:成功 1:已付款 2:已发货',
  `create_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '创建时间',
  PRIMARY KEY (`seckill_id`,`user_phone`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='秒杀成功明细表';

-- ----------------------------
-- Records of success_killed
-- ----------------------------
INSERT INTO `success_killed` VALUES ('1000', '10086100861', '0', '2017-04-23 10:27:36');
INSERT INTO `success_killed` VALUES ('1000', '10086100862', '0', '2017-04-23 10:31:00');
INSERT INTO `success_killed` VALUES ('1000', '10086861000', '-1', '2017-05-23 17:21:07');
INSERT INTO `success_killed` VALUES ('1001', '10086100861', '0', '2017-05-06 23:30:49');
INSERT INTO `success_killed` VALUES ('1001', '10086100862', '0', '2017-04-23 10:48:32');
INSERT INTO `success_killed` VALUES ('1001', '10086100863', '0', '2017-05-07 00:15:06');
INSERT INTO `success_killed` VALUES ('1001', '10086861001', '0', '2017-05-23 17:21:20');
INSERT INTO `success_killed` VALUES ('1001', '13502181181', '0', '2017-07-13 17:35:17');
INSERT INTO `success_killed` VALUES ('1005', '18638602001', '0', '2017-07-13 17:41:19');

-- ----------------------------
-- Table structure for tb_article
-- ----------------------------
DROP TABLE IF EXISTS `tb_article`;
CREATE TABLE `tb_article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `content` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_article
-- ----------------------------
INSERT INTO `tb_article` VALUES ('1', '不明真相的美国人被UFO惊呆了 其实是长征7号', '据美国《洛杉矶时报》报道，当地时间周三晚(北京时间周四)，在美国中西部的犹他州、内华达州、加利福利亚州，数千人被划过夜空的神3224秘火球吓到');
INSERT INTO `tb_article` VALUES ('2', '法国巴黎圣母院为教堂恐袭案遇害神父举行大弥撒', '而据美国战略司令部证实，其实这是中国长征七号火箭重新进入大气层，刚好经过加利福利亚附近。');
INSERT INTO `tb_article` VALUES ('3', '日东京知事候选人小池百合子回击石原：浓妆可以', '然而昨晚的美国人民可不明真相，有些人甚至怀疑这些火球是飞机解体，还有些人猜测是流星雨。');
INSERT INTO `tb_article` VALUES ('4', '日资慰安妇基金在首尔成立 韩国示威者闯入抗议', '美国战略司令部发言人表示，到目前为止还没有任何受损报告，他说类似物体通常在大气中就会消失，这也解释了为何出现一道道光痕，这一切都并未造成什么威胁。');
INSERT INTO `tb_article` VALUES ('5', '中日关系正处十字路口日应寻求减少与华冲突', '中国长征七号火箭6月25日在海南文昌航天发射中心首次发射，并成功升空进入轨道。有学者指出长征七号第二级火箭一直在地球低轨运行，一个月后重新进入大气层。');

-- ----------------------------
-- Procedure structure for execute_seckill
-- ----------------------------
DROP PROCEDURE IF EXISTS `execute_seckill`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `execute_seckill`(IN v_seckill_id BIGINT, IN v_phone BIGINT,
    IN v_kill_time TIMESTAMP, OUT r_result INT)
BEGIN
    DECLARE insert_count INT DEFAULT 0;
    START TRANSACTION ;

    INSERT IGNORE INTO success_killed
    (seckill_id, user_phone, create_time)
      VALUES (v_seckill_id, v_phone, v_kill_time);
    SELECT row_count INTO insert_count;

    IF (insert_count = 0) THEN
      ROLLBACK ;
      SET r_result = -1;
    ELSEIF (insert_count < 0) THEN
      ROLLBACK ;
      SET r_result = -2;
    ELSE
      UPDATE seckill
        SET number = number - 1
      WHERE seckill_id = v_seckill_id
        AND end_time > v_kill_time
        AND start_time < v_kill_time
        AND number > 0;
      SELECT row_count INTO insert_count;

      IF (insert_count = 0) THEN
        ROLLBACK ;
        SET r_result = 0;
      ELSEIF (insert_count < 0) THEN
        ROLLBACK ;
        SET r_result = -2;
      ELSE
        COMMIT ;
        SET r_result = 1;
      END IF ;

    END IF ;

  END
;;
DELIMITER ;
