/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50539
Source Host           : localhost:3306
Source Database       : cxrc

Target Server Type    : MYSQL
Target Server Version : 50539
File Encoding         : 65001

Date: 2016-09-24 23:04:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for acct_authority
-- ----------------------------
DROP TABLE IF EXISTS `acct_authority`;
CREATE TABLE `acct_authority` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 NOT NULL,
  `url` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=gbk ROW_FORMAT=COMPACT COMMENT='权限表';

-- ----------------------------
-- Records of acct_authority
-- ----------------------------
INSERT INTO `acct_authority` VALUES ('1', 'LOGIN', '');
INSERT INTO `acct_authority` VALUES ('2', 'ADMIN', '');
INSERT INTO `acct_authority` VALUES ('3', 'USER', null);
INSERT INTO `acct_authority` VALUES ('4', 'HR', null);
INSERT INTO `acct_authority` VALUES ('5', 'PROFESSOR', null);
INSERT INTO `acct_authority` VALUES ('6', 'EXPERT1', null);
INSERT INTO `acct_authority` VALUES ('7', 'EXPERT2', null);

-- ----------------------------
-- Table structure for acct_role
-- ----------------------------
DROP TABLE IF EXISTS `acct_role`;
CREATE TABLE `acct_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=gbk ROW_FORMAT=COMPACT COMMENT='角色表';

-- ----------------------------
-- Records of acct_role
-- ----------------------------
INSERT INTO `acct_role` VALUES ('1', 'Admin');
INSERT INTO `acct_role` VALUES ('4', '初审专家');
INSERT INTO `acct_role` VALUES ('3', '初级审核人员');
INSERT INTO `acct_role` VALUES ('5', '复审专家');
INSERT INTO `acct_role` VALUES ('2', '普通职工');
INSERT INTO `acct_role` VALUES ('6', '高级审核人员');

-- ----------------------------
-- Table structure for acct_role_authority
-- ----------------------------
DROP TABLE IF EXISTS `acct_role_authority`;
CREATE TABLE `acct_role_authority` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL,
  `authority_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKAE243466DE3FB930` (`role_id`),
  KEY `FKAE2434663FE97564` (`authority_id`),
  CONSTRAINT `acct_role_authority_ibfk_1` FOREIGN KEY (`authority_id`) REFERENCES `acct_authority` (`id`),
  CONSTRAINT `FKAE243466DE3FB930` FOREIGN KEY (`role_id`) REFERENCES `acct_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=gbk ROW_FORMAT=COMPACT COMMENT='角色-权限对应表';

-- ----------------------------
-- Records of acct_role_authority
-- ----------------------------
INSERT INTO `acct_role_authority` VALUES ('1', '1', '1');
INSERT INTO `acct_role_authority` VALUES ('2', '1', '3');
INSERT INTO `acct_role_authority` VALUES ('3', '3', '4');
INSERT INTO `acct_role_authority` VALUES ('4', '1', '2');
INSERT INTO `acct_role_authority` VALUES ('7', '4', '6');
INSERT INTO `acct_role_authority` VALUES ('8', '5', '7');
INSERT INTO `acct_role_authority` VALUES ('10', '4', '1');
INSERT INTO `acct_role_authority` VALUES ('11', '1', '4');
INSERT INTO `acct_role_authority` VALUES ('12', '5', '1');
INSERT INTO `acct_role_authority` VALUES ('13', '6', '1');
INSERT INTO `acct_role_authority` VALUES ('17', '1', '5');
INSERT INTO `acct_role_authority` VALUES ('23', '2', '3');
INSERT INTO `acct_role_authority` VALUES ('24', '2', '1');
INSERT INTO `acct_role_authority` VALUES ('25', '3', '1');
INSERT INTO `acct_role_authority` VALUES ('31', '6', '5');
INSERT INTO `acct_role_authority` VALUES ('32', '6', '4');

-- ----------------------------
-- Table structure for acct_user
-- ----------------------------
DROP TABLE IF EXISTS `acct_user`;
CREATE TABLE `acct_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `apply_type` int(11) DEFAULT NULL COMMENT '0:杰出青年 。1：创新团队 2:领军人才。',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `login_name` varchar(255) NOT NULL DEFAULT '' COMMENT '登陆用户名',
  `name` varchar(255) DEFAULT NULL COMMENT '真实姓名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `body_id` bigint(20) DEFAULT NULL COMMENT '所属组织ID',
  `id_num` varchar(50) DEFAULT NULL COMMENT '身份证号',
  `telephone` varchar(20) DEFAULT NULL COMMENT '电话',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机',
  `telefax` varchar(20) DEFAULT NULL COMMENT '传真',
  `zip_code` varchar(255) DEFAULT NULL COMMENT '邮编',
  PRIMARY KEY (`id`),
  UNIQUE KEY `login_name` (`login_name`),
  KEY `body_id` (`body_id`),
  CONSTRAINT `acct_user_ibfk_1` FOREIGN KEY (`body_id`) REFERENCES `body` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户表';

-- ----------------------------
-- Records of acct_user
-- ----------------------------
INSERT INTO `acct_user` VALUES ('1', '0', 'jl@qq.com', 'tongdehui', '蒋磊', '96e79218965eb72c92a549dd5a330112', '1', '12313244545', '', '', '', null);
INSERT INTO `acct_user` VALUES ('2', '0', 'sdfsf@22.com', 'user1', 'JL', '96e79218965eb72c92a549dd5a330112', '1', '371423199301201111', '', '', '', null);
INSERT INTO `acct_user` VALUES ('3', '0', 'sdfsf@22.com', 'hr', '初级审核人A', '96e79218965eb72c92a549dd5a330112', '245', '', '010-222222', '22222222222', '', null);
INSERT INTO `acct_user` VALUES ('4', '0', 'sdfsf@22.com', 'admin', '高级审核人A', '96e79218965eb72c92a549dd5a330112', '244', '', '', '', '', null);
INSERT INTO `acct_user` VALUES ('5', '0', 'sdfsf@22.com', 'user2', '初审专家', '96e79218965eb72c92a549dd5a330112', '253', null, '010-444444', '44444444444', null, null);
INSERT INTO `acct_user` VALUES ('6', '0', 'sdfsf@22.comsdfsf@22.com', 'user3', '复审专家', '96e79218965eb72c92a549dd5a330112', '252', null, '010-555555', '55555555555', null, null);
INSERT INTO `acct_user` VALUES ('7', '0', 'sdfsf@22.com', 'user4', '赵五', '96e79218965eb72c92a549dd5a330112', '244', '371423199301205555', '', '', '', null);
INSERT INTO `acct_user` VALUES ('8', '0', 'shiyao@163.com', 'user5', '王六', '96e79218965eb72c92a549dd5a330112', '245', '111111111', '010-677777', '53646466446', null, null);
INSERT INTO `acct_user` VALUES ('13', '0', '11@1.com', '11@1.com', 'test', '96e79218965eb72c92a549dd5a330112', '254', '1111111', 'test', 'test', '', null);
INSERT INTO `acct_user` VALUES ('14', '0', '2@1.com', '2@1.com', 'test2', '96e79218965eb72c92a549dd5a330112', '1', '2222', null, null, null, null);
INSERT INTO `acct_user` VALUES ('15', '0', '1@1.com', '1@1.com', 'user3', '96e79218965eb72c92a549dd5a330112', '1', '111111111111111111', null, null, null, null);
INSERT INTO `acct_user` VALUES ('16', '0', '123@qq.com', '123', 'lei', '96e79218965eb72c92a549dd5a330112', '245', '123', null, null, null, null);
INSERT INTO `acct_user` VALUES ('17', '0', '1233@qq.com', '1233', '111', '96e79218965eb72c92a549dd5a330112', '244', '123', '123', '132', '', '132');
INSERT INTO `acct_user` VALUES ('18', '0', '123456@qq.com', '123456', '张三', '96e79218965eb72c92a549dd5a330112', '244', '123456', null, null, null, null);
INSERT INTO `acct_user` VALUES ('19', '0', '123456@qq.com', '12345654321', '张三三', '96e79218965eb72c92a549dd5a330112', '244', '12345654321', null, null, null, null);
INSERT INTO `acct_user` VALUES ('20', '0', '1234566@qq.com', '1234321', '张三', '96e79218965eb72c92a549dd5a330112', '244', '1234321', null, null, null, null);
INSERT INTO `acct_user` VALUES ('21', '0', '22222@163.com', '2222', '2222', '96e79218965eb72c92a549dd5a330112', '244', '222222', '22222', null, null, null);
INSERT INTO `acct_user` VALUES ('22', '0', '111@163.com', '12343210', 'jianglei', '96e79218965eb72c92a549dd5a330112', '244', '12343210', null, null, null, null);
INSERT INTO `acct_user` VALUES ('24', '0', '123123@123.com', '123123132', '刘德华', '96e79218965eb72c92a549dd5a330112', '244', '123123132', null, null, null, null);
INSERT INTO `acct_user` VALUES ('25', '0', '123@123.com', '123123', '王宝强', '96e79218965eb72c92a549dd5a330112', '244', '123123', null, null, null, null);
INSERT INTO `acct_user` VALUES ('26', '0', '111@163.com', '371423199301201221', 'jiang', '96e79218965eb72c92a549dd5a330112', '244', '371423199301201221', '', '', '', null);

-- ----------------------------
-- Table structure for acct_user_role
-- ----------------------------
DROP TABLE IF EXISTS `acct_user_role`;
CREATE TABLE `acct_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKFE85CB3EDE3FB930` (`role_id`),
  KEY `FKFE85CB3E836A7D10` (`user_id`),
  CONSTRAINT `acct_user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `acct_user` (`id`),
  CONSTRAINT `acct_user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `acct_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=gbk ROW_FORMAT=COMPACT COMMENT='用户角色表';

-- ----------------------------
-- Records of acct_user_role
-- ----------------------------
INSERT INTO `acct_user_role` VALUES ('1', '1', '1');
INSERT INTO `acct_user_role` VALUES ('33', '2', '1');
INSERT INTO `acct_user_role` VALUES ('34', '3', '5');
INSERT INTO `acct_user_role` VALUES ('35', '4', '6');
INSERT INTO `acct_user_role` VALUES ('38', '7', '2');
INSERT INTO `acct_user_role` VALUES ('39', '8', '2');
INSERT INTO `acct_user_role` VALUES ('44', '13', '2');
INSERT INTO `acct_user_role` VALUES ('45', '14', '2');
INSERT INTO `acct_user_role` VALUES ('46', '15', '2');
INSERT INTO `acct_user_role` VALUES ('47', '22', '2');
INSERT INTO `acct_user_role` VALUES ('48', '5', '2');
INSERT INTO `acct_user_role` VALUES ('49', '6', '2');
INSERT INTO `acct_user_role` VALUES ('50', '16', '1');
INSERT INTO `acct_user_role` VALUES ('51', '17', '1');
INSERT INTO `acct_user_role` VALUES ('52', '18', '3');
INSERT INTO `acct_user_role` VALUES ('53', '19', '3');
INSERT INTO `acct_user_role` VALUES ('54', '20', '3');
INSERT INTO `acct_user_role` VALUES ('55', '21', '1');
INSERT INTO `acct_user_role` VALUES ('57', '24', '2');
INSERT INTO `acct_user_role` VALUES ('58', '25', '4');
INSERT INTO `acct_user_role` VALUES ('59', '26', '5');

-- ----------------------------
-- Table structure for apply
-- ----------------------------
DROP TABLE IF EXISTS `apply`;
CREATE TABLE `apply` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL DEFAULT '0',
  `apply_date` varchar(255) DEFAULT NULL COMMENT '申请时间',
  `apply_type` varchar(255) DEFAULT NULL COMMENT '1.杰出青年2.科技领军人物3.创新团队',
  `status` varchar(255) DEFAULT '0' COMMENT '0:初试状态;1:提交初审;2:初审通过;3:初审公示;4:进入复审;5:提交复审;6:复审通过;7:复审公示;7:领导审核;8:评审通过;9:评审不通过',
  `pre_approve_date` varchar(255) DEFAULT NULL COMMENT '主管单位操作时间',
  `pre_approve_id` varchar(255) DEFAULT NULL COMMENT '主管单位操作者id',
  `pre_approve_sug` text COMMENT '主管单位意见',
  `finial_approve_date` varchar(255) DEFAULT NULL COMMENT '评审小组操作时间',
  `finial_approve_id` varchar(255) DEFAULT NULL COMMENT '评审小组操作者id',
  `finial_approve_sug` text COMMENT '评审小组意见',
  `expert1_date` varchar(255) DEFAULT NULL COMMENT '初审专家操作时间',
  `expert1_id` varchar(255) DEFAULT NULL COMMENT '初审专家操作者id',
  `expert1_score` varchar(255) DEFAULT NULL COMMENT '初审专家平均分',
  `expert1_sug` text COMMENT '初审专家意见',
  `expert2_date` varchar(255) DEFAULT NULL COMMENT '复审专家操作时间',
  `expert2_id` varchar(255) DEFAULT NULL COMMENT '复审专家操作者id',
  `expert2_score` varchar(255) DEFAULT NULL COMMENT '复审专家平均分',
  `expert2_sug` text COMMENT '复审专家意见',
  PRIMARY KEY (`Id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `apply_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `acct_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COMMENT='申请记录表';

-- ----------------------------
-- Records of apply
-- ----------------------------
INSERT INTO `apply` VALUES ('4', '2', '2014-08-08 00:00:00', '杰出青年', '已通过', '2014-08-30', '0', null, '2014-08-31', '0', null, '2014-09-01', '0', '88', '可以', '2014-09-10', '0', '88', '可以');
INSERT INTO `apply` VALUES ('5', '3', '2016-08-01 00:00:00', '杰出青年', '终审中', '2016-08-08', '0', '', '2016-08-08', '0', '', null, null, null, null, null, null, null, null);
INSERT INTO `apply` VALUES ('8', '6', '2016-06-01 00:00:00', '杰出青年', '已通过', '2016-06-09', '0', '', '2016-06-11', '0', '', '', '', '', '', '', '', '99', '很不错，成绩合格，符合要求，予以通过');
INSERT INTO `apply` VALUES ('10', '14', '2016-07-01 00:00:00', '科技领军', '已通过', '2016-07-10', '0', '', '2016-07-15', '0', '', '2016-07-16', '0', '0', '', '2016-07-20', '0', '0', null);
INSERT INTO `apply` VALUES ('12', '16', '2016-09-14 11:44:30', '杰出青年', '终审中', '2016-09-14', '0', '', '2016-09-14', '0', '', '2016.09.14', '0', '0', '', '', '0', '0', '');
INSERT INTO `apply` VALUES ('23', '25', '2016-09-14 16:24:47', '杰出青年', '已通过', '', '', '', '', '', '', '2016-09-20', '25', '88', '合格，可以进入终审环节', '2016-09-20', '25', '88', '合格，可以进入终审环节');
INSERT INTO `apply` VALUES ('24', '4', '2016-09-14 18:00:04', '杰出青年', '待审核', '2016-09-18', '18', '建议分到专家一组', '2016-09-19', '4', '可以分到专家一组', '', '0', '', '', '', '0', '', '');
INSERT INTO `apply` VALUES ('29', '1', '2016-09-19 11:01:25', '杰出青年', '未通过', '', '0', '', '', '0', '', '2016-09-19', '25', '88', '初审合格', '2016-09-19', '26', '', '');
INSERT INTO `apply` VALUES ('30', '7', '2016-09-19 11:36:14', '杰出青年', '已通过', '2016-09-19', '18', '建议分到专家一组', '2016-09-19', '4', '同意', '2016-09-19', '25', '88', '成绩合格，建议进入复选', '2016-09-19', '26', '99', '成绩优秀，予以通过');
INSERT INTO `apply` VALUES ('31', '1', '2016-09-19 18:18:41', '杰出青年', '待审核', '', '0', '', '', '0', '', '', '0', '', '', '', '0', '', '');

-- ----------------------------
-- Table structure for apply_group
-- ----------------------------
DROP TABLE IF EXISTS `apply_group`;
CREATE TABLE `apply_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '分组名称',
  `pId` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='申报领域分组表';

-- ----------------------------
-- Records of apply_group
-- ----------------------------
INSERT INTO `apply_group` VALUES ('1', '1', '1', '1');

-- ----------------------------
-- Table structure for apply_menu
-- ----------------------------
DROP TABLE IF EXISTS `apply_menu`;
CREATE TABLE `apply_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_id` varchar(50) DEFAULT NULL COMMENT '申请文件的ID',
  `menu_details` varchar(255) DEFAULT NULL COMMENT '申请文件的名称',
  `menu_type` varchar(255) DEFAULT NULL COMMENT '申请文件类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of apply_menu
-- ----------------------------
INSERT INTO `apply_menu` VALUES ('1', 'jcqnDoc01', '1. 基本信息', '杰出青年');
INSERT INTO `apply_menu` VALUES ('2', 'jcqnDoc02', '2.近五年科研情况', '杰出青年');
INSERT INTO `apply_menu` VALUES ('3', 'jcqnDoc03', '3.推荐人选自我评价', '杰出青年');
INSERT INTO `apply_menu` VALUES ('4', 'jcqnDoc04', '4.未来研究计划及当前研究基础', '杰出青年');
INSERT INTO `apply_menu` VALUES ('5', 'jcqnDoc05', '5. 工作单位发展需求与推荐人选的相关性及工作单位提供的支持保障措施', '杰出青年');
INSERT INTO `apply_menu` VALUES ('6', 'jcqnDoc06', '6.承诺与推荐意见', '杰出青年');
INSERT INTO `apply_menu` VALUES ('7', 'jcqnDoc07', '7. 报送材料明细', '杰出青年');
INSERT INTO `apply_menu` VALUES ('8', 'kjljDoc01', '1.基本信息', '科技领军');
INSERT INTO `apply_menu` VALUES ('9', 'kjljDoc02', '2.近五年科研情况', '科技领军');
INSERT INTO `apply_menu` VALUES ('10', 'kjljDoc03', '3.推荐人选自我评价', '科技领军');
INSERT INTO `apply_menu` VALUES ('11', 'kjljDoc04', '4.未来研究计划及当前研究基础', '科技领军');
INSERT INTO `apply_menu` VALUES ('12', 'kjljDoc05', '5. 工作单位发展需求与推荐人选的相关性及工作单位提供的支持保障措施', '科技领军');
INSERT INTO `apply_menu` VALUES ('13', 'kjljDoc06', '6.承诺与推荐意见', '科技领军');
INSERT INTO `apply_menu` VALUES ('14', 'kjljDoc07', '7. 报送材料明细', '科技领军');
INSERT INTO `apply_menu` VALUES ('15', 'cxtdDoc01', '1.基本信息', '创新团队');
INSERT INTO `apply_menu` VALUES ('16', 'cxtdDoc02', '2.近五年主要科研情况', '创新团队');
INSERT INTO `apply_menu` VALUES ('17', 'ctxdDoc03', '3.团队及负责人自我评价', '创新团队');
INSERT INTO `apply_menu` VALUES ('18', 'cxtdDoc04', '4.团队发展规划及基础情况', '创新团队');
INSERT INTO `apply_menu` VALUES ('19', 'cxtdDoc05', '5.工作单位发展需求与推荐团队的相关性及工作单位提供的支持保障措施', '创新团队');
INSERT INTO `apply_menu` VALUES ('20', 'cxtdDoc06', '6.承诺与推荐意见', '创新团队');
INSERT INTO `apply_menu` VALUES ('21', 'cxtdDoc07', '7.报送材料明细', '创新团队');

-- ----------------------------
-- Table structure for body
-- ----------------------------
DROP TABLE IF EXISTS `body`;
CREATE TABLE `body` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pId` varchar(255) DEFAULT NULL,
  `bodyType` varchar(255) DEFAULT NULL,
  `name` varchar(4000) DEFAULT NULL COMMENT '单位名称',
  `code` varchar(255) DEFAULT NULL COMMENT '组织机构代码',
  `legal_person` varchar(255) DEFAULT NULL COMMENT '法定代表人',
  `telephone` varchar(255) DEFAULT NULL COMMENT '电话',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机',
  `telefax` varchar(255) DEFAULT NULL COMMENT '传真',
  `zip_code` varchar(255) DEFAULT NULL COMMENT '邮编',
  `contact` varchar(255) DEFAULT NULL COMMENT '单位联系人',
  `address` varchar(255) DEFAULT NULL COMMENT '单位地址',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `web` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=255 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='组织结构表';

-- ----------------------------
-- Records of body
-- ----------------------------
INSERT INTO `body` VALUES ('1', '0', '事业单位', '中国地质科学院', null, null, '010-00000000', null, '010-00000000', null, '待定', '北京市西城区阜外大街45号院', 'webmaster@mail.cgs.gov.cn', null);
INSERT INTO `body` VALUES ('244', '1', '事业单位', '专家一组', null, null, '010-68335853', null, '010-68310894', null, '王小烈', '北京市西城区百万庄大街２６号', 'office@cags.net.cn', null);
INSERT INTO `body` VALUES ('245', '1', '事业单位', '专家二组', null, null, '010-68412303', null, '010-68422326', null, '龙长兴', '北京市海淀区民族大学南路11号', 'gmkjch@cags.ac.cn', null);
INSERT INTO `body` VALUES ('252', '1', '事业单位', '专家三组', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `body` VALUES ('253', '1', '事业单位', '专家四组', null, null, null, null, null, null, '佟德慧2', null, null, null);
INSERT INTO `body` VALUES ('254', '1', '事业单位', '专家五组', null, null, '', null, null, null, '佟德慧3', null, null, null);

-- ----------------------------
-- Table structure for calendar
-- ----------------------------
DROP TABLE IF EXISTS `calendar`;
CREATE TABLE `calendar` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `jieshao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of calendar
-- ----------------------------
INSERT INTO `calendar` VALUES ('1', '2010-01-01', '2016-12-31', '根据打分表，独立打出分数，并提出合理意见。打分过程一定要按照公平公正的原则，合理打分。严禁一切形式的徇私舞弊，违者直接取消申报资格。<div><br></div><div>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 谢谢</div>');

-- ----------------------------
-- Table structure for cxtd_base_info
-- ----------------------------
DROP TABLE IF EXISTS `cxtd_base_info`;
CREATE TABLE `cxtd_base_info` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(10) DEFAULT NULL,
  `team_id` int(50) NOT NULL COMMENT '团队ID',
  `team_name` varchar(255) DEFAULT NULL COMMENT '团队名称',
  `research_direction` varchar(255) DEFAULT NULL COMMENT '研究方向',
  `subordinate_subject1` varchar(255) DEFAULT NULL COMMENT '所属学科1',
  `subordinate_subject2` varchar(255) DEFAULT NULL COMMENT '所属学科2',
  `project_type` varchar(255) DEFAULT NULL COMMENT '项目依托类别',
  `orther` varchar(255) DEFAULT NULL,
  `project_name` varchar(255) DEFAULT NULL COMMENT '项目依托名称',
  `project_source` varchar(255) DEFAULT NULL COMMENT '项目来源',
  `unit_name` varchar(255) DEFAULT NULL COMMENT '单位名称',
  `organization_code` varchar(255) DEFAULT NULL COMMENT '组织机构代码',
  `legal_representative` varchar(20) DEFAULT NULL COMMENT '法定代表人',
  `competent_department` varchar(25) DEFAULT NULL COMMENT '主管部门',
  `unit_addresses` varchar(255) DEFAULT NULL COMMENT '单位地址',
  `zip_code` bigint(10) DEFAULT NULL COMMENT '邮编',
  `contacts` varchar(10) DEFAULT NULL COMMENT '联系人',
  `mobile_phone` varchar(11) DEFAULT NULL COMMENT '手机',
  `email` varchar(50) DEFAULT NULL COMMENT 'email',
  `fax` varchar(11) DEFAULT NULL COMMENT '传真',
  `telephone` varchar(11) DEFAULT NULL COMMENT '电话',
  `status` int(11) DEFAULT '0' COMMENT '是否提交',
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cxtd_base_info
-- ----------------------------

-- ----------------------------
-- Table structure for cxtd_leader_info
-- ----------------------------
DROP TABLE IF EXISTS `cxtd_leader_info`;
CREATE TABLE `cxtd_leader_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `team_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `sex` varchar(50) DEFAULT NULL COMMENT '性别',
  `country` varchar(50) DEFAULT NULL COMMENT '国籍',
  `minzu` varchar(35) DEFAULT NULL COMMENT '民族',
  `position` varchar(50) DEFAULT NULL COMMENT '专业技术职务',
  `birthday` varchar(50) DEFAULT NULL COMMENT '出生日期',
  `id_type` varchar(50) DEFAULT NULL COMMENT '证件类型',
  `id_num` varchar(100) DEFAULT NULL COMMENT '证件号码',
  `direction` varchar(100) DEFAULT NULL COMMENT '现从事专业或方向',
  `subordinate_subject1` varchar(100) DEFAULT NULL COMMENT '所属学科1',
  `subordinate_subject2` varchar(100) DEFAULT NULL COMMENT '所属学科2',
  `telephone_fax` varchar(100) DEFAULT NULL COMMENT '电话、传真',
  `mobile_phone` varchar(100) DEFAULT NULL COMMENT '手机号',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `zip_code` varchar(100) DEFAULT NULL COMMENT '邮编',
  `addresses` varchar(100) DEFAULT NULL COMMENT '通讯地址',
  `status` int(11) DEFAULT '0' COMMENT '是否提交',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cxtd_leader_info
-- ----------------------------

-- ----------------------------
-- Table structure for cxtd_leader_zuzhi
-- ----------------------------
DROP TABLE IF EXISTS `cxtd_leader_zuzhi`;
CREATE TABLE `cxtd_leader_zuzhi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '组织或期刊名称',
  `job` varchar(255) DEFAULT NULL COMMENT '职务',
  `renqi` varchar(255) DEFAULT NULL COMMENT '任期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cxtd_leader_zuzhi
-- ----------------------------

-- ----------------------------
-- Table structure for cxtd_member_info
-- ----------------------------
DROP TABLE IF EXISTS `cxtd_member_info`;
CREATE TABLE `cxtd_member_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `team_id` varchar(11) NOT NULL COMMENT '团队ID',
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `sex` varchar(10) DEFAULT NULL COMMENT '性别',
  `birthday` varchar(255) DEFAULT NULL COMMENT '出生年月',
  `id_type` varchar(255) DEFAULT NULL COMMENT '证件类型',
  `id_num` varchar(255) DEFAULT NULL COMMENT '证件号码',
  `study_education` varchar(255) DEFAULT NULL COMMENT '学历学位',
  `work_position` varchar(255) DEFAULT NULL COMMENT '职位职称',
  `direction` varchar(255) DEFAULT NULL COMMENT '现从事专业或研究方向',
  `work_company` varchar(255) DEFAULT NULL COMMENT '工作单位',
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cxtd_member_info
-- ----------------------------

-- ----------------------------
-- Table structure for cxtd_member_num
-- ----------------------------
DROP TABLE IF EXISTS `cxtd_member_num`;
CREATE TABLE `cxtd_member_num` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `team_id` int(11) DEFAULT NULL COMMENT '团队ID',
  `num` int(11) DEFAULT NULL COMMENT '人数',
  `age_56` int(11) DEFAULT NULL COMMENT '56岁以上',
  `age_46_55` int(11) DEFAULT NULL,
  `age_36_45` int(11) DEFAULT NULL,
  `age_35` int(11) DEFAULT NULL,
  `gaoji` int(11) DEFAULT NULL,
  `fugao` int(11) DEFAULT NULL,
  `zhongji` int(11) DEFAULT NULL,
  `z_orther` int(11) DEFAULT NULL,
  `boshi` int(11) DEFAULT NULL,
  `shuoshi` int(11) DEFAULT NULL,
  `benke` int(11) DEFAULT NULL,
  `x_orther` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cxtd_member_num
-- ----------------------------

-- ----------------------------
-- Table structure for expert_user
-- ----------------------------
DROP TABLE IF EXISTS `expert_user`;
CREATE TABLE `expert_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `group_id` bigint(20) DEFAULT NULL COMMENT '所属分组id',
  `team_leader_type` int(11) DEFAULT '0' COMMENT '1:组长；2：副组长；3:成员',
  `gender` varchar(5) DEFAULT NULL COMMENT '性别',
  `minzu` varchar(20) DEFAULT NULL COMMENT '民族',
  `birthday` date DEFAULT NULL COMMENT '出生年月',
  `address` varchar(255) DEFAULT NULL COMMENT '通讯地址',
  `zhicheng` varchar(255) DEFAULT NULL COMMENT '技术职称',
  `congshizhuanye` varchar(255) DEFAULT NULL COMMENT '从事专业/研究方向',
  `within_beijing` int(11) DEFAULT NULL COMMENT '1:京内 0:京外',
  PRIMARY KEY (`id`),
  KEY `group_id` (`group_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `expert_user_ibfk_1` FOREIGN KEY (`group_id`) REFERENCES `apply_group` (`id`),
  CONSTRAINT `expert_user_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `acct_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='专家_成员表';

-- ----------------------------
-- Records of expert_user
-- ----------------------------
INSERT INTO `expert_user` VALUES ('1', '3', '1', '0', null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for jcqn_doc01
-- ----------------------------
DROP TABLE IF EXISTS `jcqn_doc01`;
CREATE TABLE `jcqn_doc01` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `name` varchar(11) DEFAULT NULL COMMENT '姓名',
  `sex` varchar(5) DEFAULT NULL COMMENT '性别',
  `minzu` varchar(35) DEFAULT NULL COMMENT '民族',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `title` varchar(255) DEFAULT NULL COMMENT '技术职称',
  `document_type` varchar(255) DEFAULT NULL COMMENT '证件类型',
  `document_number` varchar(255) DEFAULT NULL COMMENT '证件号码',
  `direction` varchar(255) DEFAULT NULL COMMENT '研究方向',
  `declaration_area` varchar(255) DEFAULT NULL COMMENT '申报领域',
  `telephone` varchar(20) DEFAULT NULL COMMENT '电话',
  `fax` varchar(20) DEFAULT NULL COMMENT '传真',
  `mobile_phone` varchar(10) DEFAULT NULL COMMENT '手机号',
  `email` varchar(20) DEFAULT NULL COMMENT '邮箱',
  `zip_code` varchar(10) DEFAULT NULL COMMENT '邮编',
  `addresses` varchar(255) DEFAULT NULL COMMENT '通讯地址',
  `study_country` varchar(255) DEFAULT NULL COMMENT '学习国家',
  `study_colleges` varchar(255) DEFAULT NULL COMMENT '院校',
  `study_major` varchar(255) DEFAULT NULL COMMENT '专业',
  `study_education` varchar(255) DEFAULT NULL COMMENT '学历',
  `study_start_time` date DEFAULT NULL COMMENT '起始时间',
  `study_end_time` date DEFAULT NULL COMMENT '结束时间',
  `work_country` varchar(255) DEFAULT NULL COMMENT '工作国家',
  `work_company` varchar(255) DEFAULT NULL COMMENT '工作单位',
  `work_position` varchar(255) DEFAULT NULL COMMENT '职位',
  `work_start_time` date DEFAULT NULL COMMENT '工作起始时间',
  `work_end_time` date DEFAULT NULL COMMENT '工作结束时间',
  `journal_title` varchar(255) DEFAULT NULL COMMENT '组织期刊名称',
  `organization_position` varchar(255) DEFAULT NULL COMMENT '组织职务',
  `organization_term` varchar(255) DEFAULT NULL COMMENT '任期',
  `journal_titlef` varchar(255) DEFAULT NULL,
  `organization_position1` varchar(255) DEFAULT NULL,
  `organization_term1` varchar(255) DEFAULT NULL,
  `journal_title2` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `organization_position2` varchar(255) DEFAULT NULL,
  `organization_term2` varchar(255) DEFAULT NULL,
  `unit_name` varchar(255) DEFAULT NULL COMMENT '单位名称',
  `organization_code` varchar(255) DEFAULT NULL COMMENT '组织机构代码',
  `legal_representative` varchar(255) DEFAULT NULL COMMENT '法定代表人',
  `supervisor_unit` varchar(255) DEFAULT NULL COMMENT '上级主管单位',
  `unit_address` varchar(255) DEFAULT NULL COMMENT '单位地址',
  `postcode` varchar(10) DEFAULT NULL COMMENT '单位邮编',
  `unit_contact` varchar(255) DEFAULT NULL COMMENT '单位联系人',
  `work_telephone` varchar(10) DEFAULT NULL COMMENT '单位电话',
  `work_fax` varchar(10) DEFAULT NULL COMMENT '单位邮编',
  PRIMARY KEY (`user_id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jcqn_doc01
-- ----------------------------
INSERT INTO `jcqn_doc01` VALUES ('1', '1', '蒋磊', '男', '汉', '1993-01-20', '开发	', 'java开发', '20125', '从入门到简单', '计算机', '13666666666', '大', '1366666666', '99@qq.com', '3621121', '北京', '中国', '交院', '计算机', '计算机专业', '2016-01-01', '2016-08-08', '北京', '联想', '开发', '2015-01-01', '2015-08-08', '2222', '22', '222', '222', '2', '222', '2', '2', '2', '2	', '2', '中国', '山东', '北京', '20566', '单位', '3612200', '北京');

-- ----------------------------
-- Table structure for jcqn_doc02
-- ----------------------------
DROP TABLE IF EXISTS `jcqn_doc02`;
CREATE TABLE `jcqn_doc02` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `serial_number1` bigint(20) DEFAULT NULL COMMENT '科研任务序号',
  `entry_name` varchar(255) DEFAULT NULL COMMENT '项目名称',
  `project_number` varchar(255) DEFAULT NULL COMMENT '立项编号',
  `funds` varchar(255) DEFAULT NULL COMMENT '经费',
  `start_stop_time` varchar(255) DEFAULT NULL COMMENT '起止年月',
  `project_nature` varchar(255) DEFAULT NULL COMMENT '项目性质',
  `role` varchar(255) DEFAULT NULL COMMENT '担任角色',
  `serial_number2` bigint(20) DEFAULT NULL COMMENT '奖项序号',
  `award_item_name` varchar(255) DEFAULT NULL COMMENT '奖励项目名称',
  `prize_name` varchar(255) DEFAULT NULL COMMENT '奖励名称',
  `grade` varchar(255) DEFAULT NULL COMMENT '等级',
  `sort` varchar(20) DEFAULT NULL COMMENT '排序',
  `reward_time` varchar(20) DEFAULT NULL COMMENT '奖励时间',
  `grant_institution` varchar(255) DEFAULT NULL COMMENT '授予机构',
  `serial_number3` bigint(20) DEFAULT NULL COMMENT '论文序号',
  `thesis_topic` varchar(255) DEFAULT NULL COMMENT '论文题目',
  `author_sort` varchar(255) DEFAULT NULL COMMENT '作者排序',
  `journal_title` varchar(255) DEFAULT NULL COMMENT '期刊名称',
  `year_volume_pagenumber` varchar(255) DEFAULT NULL COMMENT '年份、卷期、页码',
  `influence_factor` varchar(255) DEFAULT NULL COMMENT '影响因子',
  `sci_times` varchar(255) DEFAULT NULL COMMENT 'SCI他引次数',
  `number_total` varchar(255) DEFAULT NULL COMMENT '他引总次数',
  `serial_number4` bigint(20) DEFAULT NULL COMMENT '专利序号',
  `patent_name` varchar(255) DEFAULT NULL COMMENT '专利名称',
  `grant_number` varchar(20) DEFAULT NULL COMMENT '授权码',
  `inventor_sort` varchar(20) DEFAULT NULL COMMENT '发明人排序',
  `type` varchar(20) DEFAULT NULL COMMENT '类别',
  `authorized_time` varchar(20) DEFAULT NULL COMMENT '授权时间',
  `authorized_national` varchar(20) DEFAULT NULL COMMENT '授权国别或组织',
  `serial_number5` bigint(20) DEFAULT NULL COMMENT '学术会议报告序号',
  `report_name` varchar(255) DEFAULT NULL COMMENT '报告名称',
  `meeting_name` varchar(255) DEFAULT NULL COMMENT '会议名称',
  `organizers` varchar(255) DEFAULT NULL COMMENT '主办方',
  `meeting_time` varchar(20) DEFAULT NULL COMMENT '时间',
  `meeting_place` varchar(255) DEFAULT NULL COMMENT '地点',
  `report_type` varchar(255) DEFAULT NULL COMMENT '报告类型',
  `serial_number6` bigint(20) DEFAULT NULL COMMENT '重要编著序号',
  `treatise_name` varchar(255) DEFAULT NULL COMMENT '专著名称',
  `press` varchar(255) DEFAULT NULL COMMENT '出版社',
  `issuing_country` varchar(255) DEFAULT NULL COMMENT '发行国家和地区',
  `year` varchar(20) DEFAULT NULL COMMENT '年份',
  PRIMARY KEY (`user_id`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jcqn_doc02
-- ----------------------------

-- ----------------------------
-- Table structure for jcqn_doc02_01
-- ----------------------------
DROP TABLE IF EXISTS `jcqn_doc02_01`;
CREATE TABLE `jcqn_doc02_01` (
  `xuhao_id` bigint(20) DEFAULT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) NOT NULL COMMENT '用户ID',
  `entryName` varchar(255) DEFAULT NULL COMMENT '项目名称',
  `projectNumber` varchar(255) DEFAULT NULL COMMENT '立项编号',
  `funds` varchar(255) DEFAULT NULL COMMENT '经费',
  `startStopTime` varchar(255) DEFAULT NULL COMMENT '起止年月',
  `projectNature` varchar(255) DEFAULT NULL COMMENT '项目性质',
  `role` varchar(255) DEFAULT NULL COMMENT '项目角色',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jcqn_doc02_01
-- ----------------------------
INSERT INTO `jcqn_doc02_01` VALUES ('1', '21', '1', '设计家', 'q0111', '100000', '2015-2016', '设计家', '开发');
INSERT INTO `jcqn_doc02_01` VALUES ('2', '22', '1', '梦之队项目', 'q222232', '1522222', '2014-2016', '中国', '工程师');
INSERT INTO `jcqn_doc02_01` VALUES ('3', '23', '1', '设计', '222', '2222212512', '2013-2016', '中国', 'java开发');
INSERT INTO `jcqn_doc02_01` VALUES ('4', '24', '1', 'aa', 'qww', 'we', 'ewe', 'ewe', 'ew');
INSERT INTO `jcqn_doc02_01` VALUES ('5', '25', '1', 'eq', 'ewq', 'ewq', 'ewqe', 'qwwqe', 'ewq');
INSERT INTO `jcqn_doc02_01` VALUES ('6', '26', '1', 'eq', 'ew', 'ew', 'fds', 'dsa', 'dsa');

-- ----------------------------
-- Table structure for jcqn_doc02_02
-- ----------------------------
DROP TABLE IF EXISTS `jcqn_doc02_02`;
CREATE TABLE `jcqn_doc02_02` (
  `xuhao_id` bigint(20) DEFAULT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `award_item_name` varchar(255) DEFAULT NULL COMMENT '奖项名称',
  `prize_name` varchar(255) DEFAULT NULL COMMENT '奖励名称',
  `grade` varchar(255) DEFAULT NULL COMMENT '等级',
  `sort` varchar(255) DEFAULT NULL COMMENT '排序',
  `reward_time` varchar(255) DEFAULT NULL COMMENT '奖励时间',
  `grant_institution` varchar(255) DEFAULT NULL COMMENT '授予机构',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jcqn_doc02_02
-- ----------------------------
INSERT INTO `jcqn_doc02_02` VALUES ('11', '15', '1', 'ww', 'eq', '国家级', '第二', '2016.08.29', 'eq');
INSERT INTO `jcqn_doc02_02` VALUES ('11', '16', '1', 'ww', 'eq', '国家级', '第二', '2016.08.29', 'eq');

-- ----------------------------
-- Table structure for jcqn_doc02_03
-- ----------------------------
DROP TABLE IF EXISTS `jcqn_doc02_03`;
CREATE TABLE `jcqn_doc02_03` (
  `xuhao_id` bigint(20) DEFAULT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `thesis_topic` varchar(255) DEFAULT NULL COMMENT '论文题目',
  `author_sort` varchar(255) DEFAULT NULL COMMENT '作者排序',
  `journal_title` varchar(255) DEFAULT NULL COMMENT '期刊名称',
  `year_volume_pagenumber` varchar(255) DEFAULT NULL COMMENT '年页、码份、卷期',
  `influence_factor` varchar(255) DEFAULT NULL COMMENT '影响因子',
  `sci_times` varchar(255) DEFAULT NULL COMMENT 'SCI他引次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jcqn_doc02_03
-- ----------------------------
INSERT INTO `jcqn_doc02_03` VALUES ('1', '10', '1', '无', '第一作者', '无', '无', '无', '无');

-- ----------------------------
-- Table structure for jcqn_doc02_04
-- ----------------------------
DROP TABLE IF EXISTS `jcqn_doc02_04`;
CREATE TABLE `jcqn_doc02_04` (
  `xuhao_id` int(20) DEFAULT NULL,
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(20) NOT NULL,
  `patent_name` varchar(255) DEFAULT NULL COMMENT '专利名称',
  `grant_number` varchar(255) DEFAULT NULL COMMENT '授权码',
  `type` varchar(255) DEFAULT NULL COMMENT '发明人排序',
  `inventor_sort` varchar(255) DEFAULT NULL COMMENT '类型',
  `authorized_time` varchar(255) DEFAULT NULL COMMENT '授权时间',
  `authorized_national` varchar(255) DEFAULT NULL COMMENT '授权组织或国别',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jcqn_doc02_04
-- ----------------------------

-- ----------------------------
-- Table structure for jcqn_doc02_05
-- ----------------------------
DROP TABLE IF EXISTS `jcqn_doc02_05`;
CREATE TABLE `jcqn_doc02_05` (
  `xuhao_id` int(10) DEFAULT NULL,
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(20) NOT NULL,
  `report_name` varchar(255) DEFAULT NULL COMMENT '报告名称',
  `meeting_name` varchar(255) DEFAULT NULL COMMENT '会议名称',
  `organizers` varchar(255) DEFAULT NULL COMMENT '主办方',
  `meeting_time` varchar(255) DEFAULT NULL COMMENT '时间',
  `meeting_place` varchar(255) DEFAULT NULL COMMENT '地点',
  `report_type` varchar(255) DEFAULT NULL COMMENT '报告类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jcqn_doc02_05
-- ----------------------------

-- ----------------------------
-- Table structure for jcqn_doc02_06
-- ----------------------------
DROP TABLE IF EXISTS `jcqn_doc02_06`;
CREATE TABLE `jcqn_doc02_06` (
  `xuhao_id` int(11) DEFAULT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `treatise_name` varchar(255) DEFAULT NULL COMMENT '专著名称',
  `press` varchar(255) DEFAULT NULL COMMENT '出版社',
  `issuing_country` varchar(255) DEFAULT NULL COMMENT '发行国家和地区',
  `year` varchar(255) DEFAULT NULL COMMENT '年份',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jcqn_doc02_06
-- ----------------------------
INSERT INTO `jcqn_doc02_06` VALUES ('1', '1', '1', '年', '号', '码', '2016');
INSERT INTO `jcqn_doc02_06` VALUES ('2', '2', '1', null, null, null, null);
INSERT INTO `jcqn_doc02_06` VALUES ('3', '3', '1', null, null, null, null);

-- ----------------------------
-- Table structure for jcqn_doc03
-- ----------------------------
DROP TABLE IF EXISTS `jcqn_doc03`;
CREATE TABLE `jcqn_doc03` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `selfAssessment` mediumtext COMMENT '自我评价',
  PRIMARY KEY (`user_id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jcqn_doc03
-- ----------------------------
INSERT INTO `jcqn_doc03` VALUES ('4', '1', '到点的到点的的的的你好中国扫描二维码登录微信 登录手机微信 手机上 安装 安装 安装 并登录微信 进入“扫一扫” 从“发现”，进入“扫一扫”，扫码登录微信网页版 扫描成功 请在手机上点击确认以登录 返回二维码登录 微信Mac版 微信iPad版 微信PC版 中文 繁扫描二维码登录微信 登录手机微信 手机上 安装 安装 安装 并登录微信 进入“扫一扫” 从“发现”，进入“扫一扫”，扫码登录微信网页版 扫描成功 请在手机上点击确认以登录 返回二维码登录 微信Mac版 微信 \n     iPad版 微信PC版 中文 繁扫描二维码登录微信 登录手机微信 手机上 安装 安装 安装 并登录微信 进入“扫一扫” 从“发现”，进入“扫一扫”，扫码登录微信网页版 扫描成功 请在手机上点击确认以登录 返回二维码登录 微信Mac版 微信iPad版 微信PC版 中文 繁扫描二维码登录微信 登录手机微信 手机上 安装 安装 安装 并登录微信 进入“扫一扫” 从“发现”，进入“扫一扫”，扫码登录微信网页版 扫描成功 请在手机上点击确认以登录 返回二维码登录 微信Mac版 微信iPad版 微信PC版 中文 繁扫描二维码登录微信 登录手机微信 手机上 安装 安装 安装 并登录微信 进入“扫一扫” 从“发现”，进入“扫一扫”，扫码登录微信网页版 扫描成功 请在手机上点击确认以登录 返回二维码登录 微信Mac版 微信iPad版 微信PC版 中文 繁扫描二维码登录微信\n      登录手机微信 手机上 安装 安装 安装 并登录微信 进入“扫一扫” 从“发现”，进入“扫一扫”，扫码登录微信网页版 扫描成功 请在手机上点击确认以登录 返回二维码登录 微信Mac版 微信iPad版 微信PC版 中文 繁扫描二维码登录微信 登录手机微信 手机上 安装 安装 安装 并登录微信 进入“扫一扫” 从“发现”，进入“扫一扫”，扫码登录微信网页版 扫描成功 请在手机上点击确认以登录 返回二维码登录 微信Mac版 微信iPad版 微信PC版 中文 繁扫描二维码登录微信 登录手机微信 手机上 安装 安装 安装 并登录微信 进入“扫一扫” 从“发现”，进入“扫一扫”，扫码登录微信网页版 扫描成功 请在手机上点击确认以登录 返回二维码登录 微信Mac版 微信iPad版 微信PC版 中文 繁');
INSERT INTO `jcqn_doc03` VALUES ('5', '2', 'da');
INSERT INTO `jcqn_doc03` VALUES ('6', '7', '推荐人选自我评价');

-- ----------------------------
-- Table structure for jcqn_doc04
-- ----------------------------
DROP TABLE IF EXISTS `jcqn_doc04`;
CREATE TABLE `jcqn_doc04` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `futurePlans` mediumtext COMMENT '未来计划及当前研究基础',
  PRIMARY KEY (`user_id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jcqn_doc04
-- ----------------------------
INSERT INTO `jcqn_doc04` VALUES ('1', '1', '未来研究计划及当前研究基础的的喀');
INSERT INTO `jcqn_doc04` VALUES ('2', '2', 'dada');
INSERT INTO `jcqn_doc04` VALUES ('3', '7', '未来研究计划及当前研究基础');

-- ----------------------------
-- Table structure for jcqn_doc05
-- ----------------------------
DROP TABLE IF EXISTS `jcqn_doc05`;
CREATE TABLE `jcqn_doc05` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `needsRelevanceSupport` mediumtext COMMENT '工作单位发展需求与推荐人选的相关性及工作单位提供的支持保障措施',
  PRIMARY KEY (`user_id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jcqn_doc05
-- ----------------------------
INSERT INTO `jcqn_doc05` VALUES ('1', '1', '登录手机微信 手机上 安装 安装 安装 并登录微信 进入“扫一扫” 从“发现”，进入“扫一扫”，扫码登录微信网页版 扫描成功 请在手机上点击确认以登录 返回二维码登录 微信Mac版 微信iPad版 微信PC版 中文 繁扫描二维码登录微信 登录手机微信 手机上 安装 安装 安装 并登录微信 进入“扫一扫” 从“发现”，进入“扫一扫”，扫码登录微信网页版 扫描成功 请在手机上点击确认以登录 返回二维码登录 微信Mac版 微信iPad版 微信PC版 中文 繁扫描二维码登录微信 登录手机微信 手机上 安装 安装 安装 并登录微信 进入“扫一扫” 从“发现”，进入“扫一扫”，扫码登录微信网页版 扫描成功 请在手机上点击确认以登录 返回二维码登录 微信Mac版 微信iPad版 微信PC版 中文 繁');
INSERT INTO `jcqn_doc05` VALUES ('2', '2', 'da');
INSERT INTO `jcqn_doc05` VALUES ('3', '7', '工作单位发展需求与推荐人选的相关性及工作单位提供的支持保障措施');

-- ----------------------------
-- Table structure for jcqn_doc06
-- ----------------------------
DROP TABLE IF EXISTS `jcqn_doc06`;
CREATE TABLE `jcqn_doc06` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `work_unit_opinion` mediumtext COMMENT '工作单位意见',
  `recommended_unit_opinion` mediumtext COMMENT '推荐单位意见',
  PRIMARY KEY (`user_id`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jcqn_doc06
-- ----------------------------

-- ----------------------------
-- Table structure for kjlj_doc01
-- ----------------------------
DROP TABLE IF EXISTS `kjlj_doc01`;
CREATE TABLE `kjlj_doc01` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `name` varchar(11) DEFAULT NULL COMMENT '姓名',
  `sex` varchar(5) DEFAULT NULL COMMENT '性别',
  `minzu` varchar(35) DEFAULT NULL COMMENT '民族',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `title` varchar(255) DEFAULT NULL COMMENT '技术职称',
  `document_type` varchar(255) DEFAULT NULL COMMENT '证件类型',
  `document_number` varchar(255) DEFAULT NULL COMMENT '证件号码',
  `direction` varchar(255) DEFAULT NULL COMMENT '研究方向',
  `declaration_area` varchar(255) DEFAULT NULL COMMENT '申报领域',
  `telephone` varchar(20) DEFAULT NULL COMMENT '电话',
  `fax` varchar(20) DEFAULT NULL COMMENT '传真',
  `mobile_phone` varchar(10) DEFAULT NULL COMMENT '手机号',
  `email` varchar(20) DEFAULT NULL COMMENT '邮箱',
  `zip_code` varchar(10) DEFAULT NULL COMMENT '邮编',
  `addresses` varchar(255) DEFAULT NULL COMMENT '通讯地址',
  `study_country` varchar(255) DEFAULT NULL COMMENT '学习国家',
  `study_colleges` varchar(255) DEFAULT NULL COMMENT '院校',
  `study_major` varchar(255) DEFAULT NULL COMMENT '专业',
  `study_education` varchar(255) DEFAULT NULL COMMENT '学历',
  `study_start_time` date DEFAULT NULL COMMENT '起始时间',
  `study_end_time` date DEFAULT NULL COMMENT '结束时间',
  `work_country` varchar(255) DEFAULT NULL COMMENT '工作国家',
  `work_company` varchar(255) DEFAULT NULL COMMENT '工作单位',
  `work_position` varchar(255) DEFAULT NULL COMMENT '职位',
  `work_start_time` date DEFAULT NULL COMMENT '工作起始时间',
  `work_end_time` date DEFAULT NULL COMMENT '工作结束时间',
  `journal_title` varchar(255) DEFAULT NULL COMMENT '组织期刊名称',
  `organization_position` varchar(255) DEFAULT NULL COMMENT '组织职务',
  `organization_term` varchar(255) DEFAULT NULL COMMENT '任期',
  `journal_titlef` varchar(255) DEFAULT NULL,
  `organization_position1` varchar(255) DEFAULT NULL,
  `organization_term1` varchar(255) DEFAULT NULL,
  `journal_title2` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `organization_position2` varchar(255) DEFAULT NULL,
  `organization_term2` varchar(255) DEFAULT NULL,
  `unit_name` varchar(255) DEFAULT NULL COMMENT '单位名称',
  `organization_code` varchar(255) DEFAULT NULL COMMENT '组织机构代码',
  `legal_representative` varchar(255) DEFAULT NULL COMMENT '法定代表人',
  `supervisor_unit` varchar(255) DEFAULT NULL COMMENT '上级主管单位',
  `unit_address` varchar(255) DEFAULT NULL COMMENT '单位地址',
  `postcode` varchar(10) DEFAULT NULL COMMENT '单位邮编',
  `unit_contact` varchar(255) DEFAULT NULL COMMENT '单位联系人',
  `work_telephone` varchar(10) DEFAULT NULL COMMENT '单位电话',
  `work_fax` varchar(10) DEFAULT NULL COMMENT '单位邮编',
  PRIMARY KEY (`user_id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of kjlj_doc01
-- ----------------------------
INSERT INTO `kjlj_doc01` VALUES ('1', '1', '蒋磊', '男', '汉', '1993-01-01', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2016-01-01', '2016-01-01', '1', '1', '1', '2016-01-01', '2016-01-01', '2222', '22', '222', '222', '2', '222', '2', '2', '2', '', '2', '1', '1', '1', '1', '1', '1', '1');

-- ----------------------------
-- Table structure for kjlj_doc02
-- ----------------------------
DROP TABLE IF EXISTS `kjlj_doc02`;
CREATE TABLE `kjlj_doc02` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `serial_number1` bigint(20) DEFAULT NULL COMMENT '科研任务序号',
  `entry_name` varchar(255) DEFAULT NULL COMMENT '项目名称',
  `project_number` varchar(255) DEFAULT NULL COMMENT '立项编号',
  `funds` varchar(255) DEFAULT NULL COMMENT '经费',
  `start_stop_time` varchar(255) DEFAULT NULL COMMENT '起止年月',
  `project_nature` varchar(255) DEFAULT NULL COMMENT '项目性质',
  `role` varchar(255) DEFAULT NULL COMMENT '担任角色',
  `serial_number2` bigint(20) DEFAULT NULL COMMENT '奖项序号',
  `award_item_name` varchar(255) DEFAULT NULL COMMENT '奖励项目名称',
  `prize_name` varchar(255) DEFAULT NULL COMMENT '奖励名称',
  `grade` varchar(255) DEFAULT NULL COMMENT '等级',
  `sort` varchar(20) DEFAULT NULL COMMENT '排序',
  `reward_time` varchar(20) DEFAULT NULL COMMENT '奖励时间',
  `grant_institution` varchar(255) DEFAULT NULL COMMENT '授予机构',
  `serial_number3` bigint(20) DEFAULT NULL COMMENT '论文序号',
  `thesis_topic` varchar(255) DEFAULT NULL COMMENT '论文题目',
  `author_sort` varchar(255) DEFAULT NULL COMMENT '作者排序',
  `journal_title` varchar(255) DEFAULT NULL COMMENT '期刊名称',
  `year_volume_pagenumber` varchar(255) DEFAULT NULL COMMENT '年份、卷期、页码',
  `influence_factor` varchar(255) DEFAULT NULL COMMENT '影响因子',
  `sci_times` varchar(255) DEFAULT NULL COMMENT 'SCI他引次数',
  `number_total` varchar(255) DEFAULT NULL COMMENT '他引总次数',
  `serial_number4` bigint(20) DEFAULT NULL COMMENT '专利序号',
  `patent_name` varchar(255) DEFAULT NULL COMMENT '专利名称',
  `grant_number` varchar(20) DEFAULT NULL COMMENT '授权码',
  `inventor_sort` varchar(20) DEFAULT NULL COMMENT '发明人排序',
  `type` varchar(20) DEFAULT NULL COMMENT '类别',
  `authorized_time` varchar(20) DEFAULT NULL COMMENT '授权时间',
  `authorized_national` varchar(20) DEFAULT NULL COMMENT '授权国别或组织',
  `serial_number5` bigint(20) DEFAULT NULL COMMENT '学术会议报告序号',
  `report_name` varchar(255) DEFAULT NULL COMMENT '报告名称',
  `meeting_name` varchar(255) DEFAULT NULL COMMENT '会议名称',
  `organizers` varchar(255) DEFAULT NULL COMMENT '主办方',
  `meeting_time` varchar(20) DEFAULT NULL COMMENT '时间',
  `meeting_place` varchar(255) DEFAULT NULL COMMENT '地点',
  `report_type` varchar(255) DEFAULT NULL COMMENT '报告类型',
  `serial_number6` bigint(20) DEFAULT NULL COMMENT '重要编著序号',
  `treatise_name` varchar(255) DEFAULT NULL COMMENT '专著名称',
  `press` varchar(255) DEFAULT NULL COMMENT '出版社',
  `issuing_country` varchar(255) DEFAULT NULL COMMENT '发行国家和地区',
  `year` varchar(20) DEFAULT NULL COMMENT '年份',
  PRIMARY KEY (`user_id`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of kjlj_doc02
-- ----------------------------

-- ----------------------------
-- Table structure for kjlj_doc02_01
-- ----------------------------
DROP TABLE IF EXISTS `kjlj_doc02_01`;
CREATE TABLE `kjlj_doc02_01` (
  `xuhao_id` bigint(20) DEFAULT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `entry_name` varchar(255) DEFAULT NULL COMMENT '项目名称',
  `project_number` varchar(255) DEFAULT NULL COMMENT '立项编号',
  `funds` varchar(255) DEFAULT NULL COMMENT '经费',
  `start_stop_time` varchar(255) DEFAULT NULL COMMENT '起止年月',
  `project_nature` varchar(255) DEFAULT NULL COMMENT '项目性质',
  `role` varchar(255) DEFAULT NULL COMMENT '项目角色',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of kjlj_doc02_01
-- ----------------------------
INSERT INTO `kjlj_doc02_01` VALUES ('1', '1', '1', '你好', '1', '11111', '2016.1.20-2016.7.9', '开发', '工程师');
INSERT INTO `kjlj_doc02_01` VALUES ('2', '2', '1', '开发', '2', '1212', '2015-2016', '项目', '我');
INSERT INTO `kjlj_doc02_01` VALUES ('3', '3', '1', '万', '3', '2132', null, '(L额的额的)', '热');
INSERT INTO `kjlj_doc02_01` VALUES ('4', '4', '1', '得', '4', '213', null, '的 ', '额');
INSERT INTO `kjlj_doc02_01` VALUES ('5', '5', '1', '得得', '5', '321', '得', ' 的', '而额');
INSERT INTO `kjlj_doc02_01` VALUES ('6', '6', '1', '得', '6', '321', '得', null, '而得的是');

-- ----------------------------
-- Table structure for kjlj_doc02_02
-- ----------------------------
DROP TABLE IF EXISTS `kjlj_doc02_02`;
CREATE TABLE `kjlj_doc02_02` (
  `xuhao_id` bigint(20) DEFAULT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `award_item_name` varchar(255) DEFAULT NULL COMMENT '奖项名称',
  `prize_name` varchar(255) DEFAULT NULL COMMENT '奖励名称',
  `grade` varchar(255) DEFAULT NULL COMMENT '等级',
  `sort` varchar(255) DEFAULT NULL COMMENT '排序',
  `reward_time` varchar(255) DEFAULT NULL COMMENT '奖励时间',
  `grant_institution` varchar(255) DEFAULT NULL COMMENT '授予机构',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of kjlj_doc02_02
-- ----------------------------
INSERT INTO `kjlj_doc02_02` VALUES ('1', '1', '1', '2012', '单位的', '的', '的', '的', '的');
INSERT INTO `kjlj_doc02_02` VALUES ('2', '2', '1', 'niaho ', 'dde ', 'de ', 'ded', 'fe', 'de');
INSERT INTO `kjlj_doc02_02` VALUES ('3', '3', '1', 'haolde', 'sw', 'ed', 'def', 'dfef', 'fe');
INSERT INTO `kjlj_doc02_02` VALUES ('4', '4', '1', 'dd', 'd3', 'd3', 'd3', 'd3', 'd');

-- ----------------------------
-- Table structure for kjlj_doc02_03
-- ----------------------------
DROP TABLE IF EXISTS `kjlj_doc02_03`;
CREATE TABLE `kjlj_doc02_03` (
  `xuhao_id` bigint(20) DEFAULT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `thesis_topic` varchar(255) DEFAULT NULL COMMENT '论文题目',
  `author_sort` varchar(255) DEFAULT NULL COMMENT '作者排序',
  `journal_title` varchar(255) DEFAULT NULL COMMENT '期刊名称',
  `year_volume_pagenumber` varchar(255) DEFAULT NULL COMMENT '年页、码份、卷期',
  `influence_factor` varchar(255) DEFAULT NULL COMMENT '影响因子',
  `sci_times` varchar(255) DEFAULT NULL COMMENT 'SCI他引次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of kjlj_doc02_03
-- ----------------------------
INSERT INTO `kjlj_doc02_03` VALUES ('1', '1', '1', '你', '好玩', '吗', '1', '1', '1');
INSERT INTO `kjlj_doc02_03` VALUES ('2', '2', '1', null, null, null, null, null, null);
INSERT INTO `kjlj_doc02_03` VALUES ('3', '3', '1', null, null, null, null, null, null);
INSERT INTO `kjlj_doc02_03` VALUES ('4', '4', '1', null, null, null, null, null, null);
INSERT INTO `kjlj_doc02_03` VALUES ('5', '5', '1', null, null, null, null, null, null);
INSERT INTO `kjlj_doc02_03` VALUES ('6', '6', '1', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for kjlj_doc02_04
-- ----------------------------
DROP TABLE IF EXISTS `kjlj_doc02_04`;
CREATE TABLE `kjlj_doc02_04` (
  `xuhao_id` int(20) DEFAULT NULL,
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(20) DEFAULT NULL,
  `patent_name` varchar(255) DEFAULT NULL COMMENT '专利名称',
  `grant_number` varchar(255) DEFAULT NULL COMMENT '授权码',
  `inventor_sort` varchar(255) DEFAULT NULL COMMENT '发明人排序',
  `type` varchar(255) DEFAULT NULL COMMENT '类型',
  `authorized_time` varchar(255) DEFAULT NULL COMMENT '授权时间',
  `authorized_national` varchar(255) DEFAULT NULL COMMENT '授权组织或国别',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of kjlj_doc02_04
-- ----------------------------
INSERT INTO `kjlj_doc02_04` VALUES ('1', '1', '1', '山东', '1', null, null, null, null);
INSERT INTO `kjlj_doc02_04` VALUES ('2', '2', '1', null, null, null, null, null, null);
INSERT INTO `kjlj_doc02_04` VALUES ('3', '3', '1', null, null, null, null, null, null);
INSERT INTO `kjlj_doc02_04` VALUES ('4', '4', '1', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for kjlj_doc02_05
-- ----------------------------
DROP TABLE IF EXISTS `kjlj_doc02_05`;
CREATE TABLE `kjlj_doc02_05` (
  `xuhao_id` int(10) DEFAULT NULL,
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(20) DEFAULT NULL,
  `report_name` varchar(255) DEFAULT NULL COMMENT '报告名称',
  `meeting_name` varchar(255) DEFAULT NULL COMMENT '会议名称',
  `organizers` varchar(255) DEFAULT NULL COMMENT '主办方',
  `meeting_time` varchar(255) DEFAULT NULL COMMENT '时间',
  `meeting_place` varchar(255) DEFAULT NULL COMMENT '地点',
  `report_type` varchar(255) DEFAULT NULL COMMENT '报告类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of kjlj_doc02_05
-- ----------------------------
INSERT INTO `kjlj_doc02_05` VALUES ('1', '1', '1', '年号', '你好', '中国', '2017', '北京', '报告');
INSERT INTO `kjlj_doc02_05` VALUES ('2', '2', '1', null, null, null, null, null, null);
INSERT INTO `kjlj_doc02_05` VALUES ('3', '3', '1', null, null, null, null, null, null);
INSERT INTO `kjlj_doc02_05` VALUES ('4', '4', '1', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for kjlj_doc02_06
-- ----------------------------
DROP TABLE IF EXISTS `kjlj_doc02_06`;
CREATE TABLE `kjlj_doc02_06` (
  `xuhao_id` int(11) DEFAULT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `treatise_name` varchar(255) DEFAULT NULL COMMENT '专著名称',
  `press` varchar(255) DEFAULT NULL COMMENT '出版社',
  `issuing_country` varchar(255) DEFAULT NULL COMMENT '发行国家和地区',
  `year` varchar(255) DEFAULT NULL COMMENT '年份',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of kjlj_doc02_06
-- ----------------------------
INSERT INTO `kjlj_doc02_06` VALUES ('1', '1', '1', '年', '号', '码', '2016');
INSERT INTO `kjlj_doc02_06` VALUES ('2', '2', '1', null, null, null, null);
INSERT INTO `kjlj_doc02_06` VALUES ('3', '3', '1', null, null, null, null);

-- ----------------------------
-- Table structure for kjlj_doc03
-- ----------------------------
DROP TABLE IF EXISTS `kjlj_doc03`;
CREATE TABLE `kjlj_doc03` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `selfAssessment` mediumtext COMMENT '自我评价',
  PRIMARY KEY (`user_id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of kjlj_doc03
-- ----------------------------
INSERT INTO `kjlj_doc03` VALUES ('4', '1', '大 扫描二维码登录微信 登录手机微信 手机上 安装 安装 安装 并登录微信 进入“扫一扫” 从“发现”，进入“扫一扫”，扫码登录微信网页版 扫描成功 请在手机上点击确认以登录 返回二维码登录 微信Mac版 微信iPad版 微信PC版 中文 繁扫描二维码登录微信 登录手机微信 手机上 安装 安装 安装 并登录微信 进入“扫一扫” 从“发现”，进入“扫一扫”，扫码登录微信网页版 扫描成功 请在手机上点击确认以登录 返回二维码登录 微信Mac版 微信 \n     iPad版 微信PC版 中文 繁扫描二维码登录微信 登录手机微信 手机上 安装 安装 安装 并登录微信 进入“扫一扫” 从“发现”，进入“扫一扫”，扫码登录微信网页版 扫描成功 请在手机上点击确认以登录 返回二维码登录 微信Mac版 微信iPad版 微信PC版 中文 繁扫描二维码登录微信 登录手机微信 手机上 安装 安装 安装 并登录微信 进入“扫一扫” 从“发现”，进入“扫一扫”，扫码登录微信网页版 扫描成功 请在手机上点击确认以登录 返回二维码登录 微信Mac版 微信iPad版 微信PC版 中文 繁扫描二维码登录微信 登录手机微信 手机上 安装 安装 安装 并登录微信 进入“扫一扫” 从“发现”，进入“扫一扫”，扫码登录微信网页版 扫描成功 请在手机上点击确认以登录 返回二维码登录 微信Mac版 微信iPad版 微信PC版 中文 繁扫描二维码登录微信\n      登录手机微信 手机上 安装 安装 安装 并登录微信 进入“扫一扫” 从“发现”，进入“扫一扫”，扫码登录微信网页版 扫描成功 请在手机上点击确认以登录 返回二维码登录 微信Mac版 微信iPad版 微信PC版 中文 繁扫描二维码登录微信 登录手机微信 手机上 安装 安装 安装 并登录微信 进入“扫一扫” 从“发现”，进入“扫一扫”，扫码登录微信网页版 扫描成功 请在手机上点击确认以登录 返回二维码登录 微信Mac版 微信iPad版 微信PC版 中文 繁扫描二维码登录微信 登录手机微信 手机上 安装 安装 安装 并登录微信 进入“扫一扫” 从“发现”，进入“扫一扫”，扫码登录微信网页版 扫描成功 请在手机上点击确认以登录 返回二维码登录 微信Mac版 微信iPad版 微信PC版 中文 繁');
INSERT INTO `kjlj_doc03` VALUES ('6', '7', '推荐人选自我评价');
INSERT INTO `kjlj_doc03` VALUES ('5', '26', '推荐人选自我评价');

-- ----------------------------
-- Table structure for kjlj_doc04
-- ----------------------------
DROP TABLE IF EXISTS `kjlj_doc04`;
CREATE TABLE `kjlj_doc04` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `futurePlans` mediumtext COMMENT '未来计划及当前研究基础',
  PRIMARY KEY (`user_id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of kjlj_doc04
-- ----------------------------
INSERT INTO `kjlj_doc04` VALUES ('1', '1', '耳温枪额外去');
INSERT INTO `kjlj_doc04` VALUES ('2', '2', '未来研究计划与当前研究基础');
INSERT INTO `kjlj_doc04` VALUES ('4', '7', '未来研究计划及当前研究基础');
INSERT INTO `kjlj_doc04` VALUES ('3', '26', '未来研究计划及当前研究基础');

-- ----------------------------
-- Table structure for kjlj_doc05
-- ----------------------------
DROP TABLE IF EXISTS `kjlj_doc05`;
CREATE TABLE `kjlj_doc05` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `needsRelevanceSupport` mediumtext COMMENT '工作单位发展需求与推荐人选的相关性及工作单位提供的支持保障措施',
  PRIMARY KEY (`user_id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of kjlj_doc05
-- ----------------------------
INSERT INTO `kjlj_doc05` VALUES ('1', '1', 'iPad版 微信PC版 中文 繁扫饿问问去描二维码登录微信 登录手机微信 手机上 安装 安装 安装 并登录微信 进入“扫一扫” 从“发现”，进入“扫一扫”，扫码登录微信网页版 扫描成功 请在手机上点击确认以登录 返回二维码登录 微信Mac版 微信iPad版 微信PC版 中文 繁扫描二维码登录微信 登录手机微信 手机上 安装 安装 安装 并登录微信 进入“扫一扫” 从“发现”，进入“扫一扫”，扫码登录微信网页版 扫描成功 请在手机上点击确认以登录 返回二维码登录 微信Mac版 微信iPad版 微信PC版 中文 繁扫描二维码登录微信 登录手机微信 手机上 安装 安装 安装 并登录微信 进入“扫一扫” 从“发现”，进入“扫一扫”，扫码登录微信网页版 扫描成功 请在手机上点击确认以登录 返回二维码登录 微信Mac版 微信iPad版 微信PC版 中文 繁扫描二维码登录微信\n      登录手机微信 手机上 安装 安装 安装 并登录微信 进入“扫一扫” 从“发现”，进入“扫一扫”，扫码登录微信网页版 扫描成功 请在手机上点击确认以登录 返回二维码登录 微信Mac版 微信iPad版 微信PC版 中文 繁扫描二维码登录微信 登录手机微信 手机上 安装 安装 安装 并登录微信 进入“扫一扫” 从“发现”，进入“扫一扫”，扫码登录微信网页版 扫描成功 请在手机上点击确认以登录 返回二维码登录 微信Mac版 微信iPad版 微信PC版 中文 繁扫描二维码登录微信 登录手机微信 手机上 安装 安装 安装 并登录微信 进入“扫一扫” 从“发现”，进入“扫一扫”，扫码登录微信网页版 扫描成功 请在手机上点击确认以登录 返回二维码登录 微信Mac版 微信iPad版 微信PC版 中文 繁');
INSERT INTO `kjlj_doc05` VALUES ('2', '2', '工作单位发展需求与推荐人选的相关性及工作单位提供的支持保障措施');
INSERT INTO `kjlj_doc05` VALUES ('4', '7', '工作单位发展需求与推荐人选的相关性及工作单位提供的支持保障措施');
INSERT INTO `kjlj_doc05` VALUES ('3', '26', '工作单位发展需求与推荐人选的相关性及工作单位提供的支持保障措施');

-- ----------------------------
-- Table structure for kjlj_doc06
-- ----------------------------
DROP TABLE IF EXISTS `kjlj_doc06`;
CREATE TABLE `kjlj_doc06` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `work_unit_opinion` mediumtext COMMENT '工作单位意见',
  `recommended_unit_opinion` mediumtext COMMENT '推荐单位意见',
  PRIMARY KEY (`user_id`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of kjlj_doc06
-- ----------------------------

-- ----------------------------
-- Table structure for mark_detail
-- ----------------------------
DROP TABLE IF EXISTS `mark_detail`;
CREATE TABLE `mark_detail` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) DEFAULT NULL COMMENT '1:初选 2：复选',
  `user_id` bigint(20) DEFAULT NULL COMMENT '个人/团队id',
  `expert_id` bigint(20) DEFAULT NULL COMMENT '专家成员id',
  `score` int(11) DEFAULT '0' COMMENT '具体分值',
  PRIMARY KEY (`Id`),
  KEY `expert_id` (`expert_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `mark_detail_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `acct_user` (`id`),
  CONSTRAINT `mark_detail_ibfk_2` FOREIGN KEY (`expert_id`) REFERENCES `expert_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='专家打分表_详情';

-- ----------------------------
-- Records of mark_detail
-- ----------------------------

-- ----------------------------
-- Table structure for mark_infor
-- ----------------------------
DROP TABLE IF EXISTS `mark_infor`;
CREATE TABLE `mark_infor` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `base_info` text COMMENT '基本条件',
  `base_info_score` int(11) DEFAULT '0' COMMENT '基本条件_参考分值',
  `personal_ability` text COMMENT '个人能力/团队构成',
  `personal_ability_score` int(11) DEFAULT '0' COMMENT '个人能力/团队构成_参考分值',
  `research_performance` text COMMENT '研发业绩',
  `research_performance_score` int(11) DEFAULT '0' COMMENT '研发业绩_参考分值',
  `development_plan` text COMMENT '研发规划',
  `development_plan_score` int(11) DEFAULT '0' COMMENT '研发规划_参考分值',
  `security` text COMMENT '条件保障',
  `security_score` int(11) DEFAULT '0' COMMENT '条件保障_参考分值',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='专家打分表_说明';

-- ----------------------------
-- Records of mark_infor
-- ----------------------------

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `type` varchar(255) DEFAULT NULL,
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `pub_date` datetime DEFAULT NULL,
  `content` longtext,
  `top` varchar(50) DEFAULT NULL,
  `first` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='新闻表';

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('0', '6', '“中国地质科学院自然科学系列职称申报系统”试运行通知', '蒋磊', '2016-08-24 17:11:15', '中国地质科学院自然科学系列职称申报系统现已上线试运行，请大家完善自己个人信息，需要职称申报的请在规定时间完成职称申报工作！', 'top', '-1');
INSERT INTO `news` VALUES ('0', '7', '中国地质调查局业务中心建设与管理暂行办法', '蒋磊', '2016-08-24 17:10:48', '第一章　总　则\n    第一条   根据《中国地质调查局中长期发展规划纲要（2011～2025年）》，为了推进地质调查业务发展，规范和加强中国地质调查局业务中心（以下简称“业务中心”）的建设和管理，制定本办法。\n    第二条   业务中心是在地质调查工作重大业务领域从事调查研究的非法人学术性组织，通过凝聚国内外一流科学家，瞄准重大地质科技问题和国际地学前沿，围绕国家需求和地质调查业务发展需求，开展综合研究、信息服务、国际合作、人才培养和学术交流，引领本业务领域的学科发展，使其成为国际上有重要影响的专业研究中心。\n    第三条   业务中心的主管部门是中国地质调查局（以下简称“地调局”）。地调局根据地质调查工作需要，结合局属单位的总体定位、业务优势和区位优势，对业务中心进行合理布局和建设。\n第二章　基本条件\n    第四条   业务中心的发展方向必须是地调局中长期发展规划确定的重点业务领域。\n    第五条   业务中心原则上依托局属单位建设。依托单位必须具备良好的工作基础和运行条件，具有引领本领域发展的实力或潜力。近五年内，同时在该领域具备以下条件：\n    1.   承担过地质调查计划项目；\n    2.   承担过国家级、省部级重大科技项目；\n    3.   以第一完成单位获得过省部级以上奖励；\n    4.   公开出版或完成过有重大影响的专著、成果报告，在核心期刊发表论文15篇以上；\n    第六条   依托单位拥有3名以上有影响力的专家，包括地调局青年英才计划、国土资源部百人计划等人选，地学领域学术性个人荣誉奖的获得者以及国外重要奖项获得者等；\n    第七条   依托单位拥有相对稳定,且有影响的核心业务团队，在职固定科研人员在10人以上，60%为研究生以上学历。\n第三章　职责\n    第八条   业务中心实行地调局和依托单位分级管理。地调局科技外事部会同相关部室统筹全局业务中心建设，相关部室按业务分工负责指导各领域业务中心的建设。\n    第九条   地调局的主要职责是：\n    1．组织专家对业务中心建设进行论证；批准业务中心主任、秘书长和学术委员会委员组成；\n    2．开展业务中心考核与评估工作；\n    3．指导各业务中心发展规划的编制；\n    4．在项目、人才、条件建设和国际合作交流等方面给予支持。\n    第十条   依托单位的主要职责是：\n    1．提出业务中心建设方案，推荐业务中心主任、秘书长和学术委员会委员人选。\n    2．配合主管部门对业务中心进行考核、评估等工作。\n    3．提出业务中心研究方向、任务、目标等方面的重大调整意见和建议。\n    4．为业务中心吸引人才和培养人才提供激励政策。\n    5．负责业务中心的日常管理。\n    第十一条   业务中心的主要职责是：\n    1．跟踪研究国内外本领域的研究动态，开展战略研究，提出本业务领域的发展规划和建议；\n    2．针对地质调查相关业务领域重大问题，开展信息和咨询服务； \n    3．组织专家对地质调查中区域性、专业性的重大科学问题进行综合研究和联合攻关；\n    4．为申报国家科技计划和地质调查计划提出建议；\n    5．组织开展学术交流、业务培训和国际合作，推广成熟地质理论和地质技术方法，培养优秀地质调查专业人才；\n    6．承办相关领域的学术期刊或杂志等。\n第四章　组织机构\n    第十二条   业务中心设立主任、秘书处和学术委员会：\n    1．主任由依托单位的主要领导担任，负责业务中心的管理。\n    2．秘书处主要负责业务中心的日常工作，组织落实业务中心各项任务目标。秘书长一般由依托单位的专业研究室（中心）的主任担任，在业务领域具有较高学术造诣，且具有较强的组织协调能力。\n    3．学术委员会由国内外本领域的知名专家、学者组成，总人数13～17人。其中，依托单位的学术委员不超过总人数的三分之一，学术委员会任期5年。学术委员会主要负责审议业务中心建设发展的目标、任务和研究方向，审议业务中心的重大学术活动、年度工作、重要议案和研究成果等。\n第五章　运行与管理\n    第十三条   局属单位向地调局提交业务中心建设申请报告。地调局组织专家对业务中心建设申请报告进行评审。\n    第十四条   通过申请报告评审后，依托单位编制业务中心建设实施方案，地调局组织专家对该实施方案进行论证。\n    第十五条   实施方案通过地调局论证和批准后，业务中心正式挂牌成立，依托单位启动业务中心建设工作。\n    第十六条   业务中心成立后的日常工作包括：\n    1．每年向地调局提交年度工作报告和经学术委员审定后的本领域的研究进展报告；\n    2．每年至少组织召开一次学术活动；\n    3．建立健全内部管理运行规章制度；\n    4．有条件的应承办相关领域的期刊杂志；\n    5．对业务中心完成的专著、论文、软件、数据库等研究成果均加注业务中心名称。\n    第十七条   业务中心实行定期考核和评估制度。每二年考核一次，考核组由地调局聘请的7～9名专家组成，实行专家回避制度。考核结果作为业务中心下一阶段运行与发展调整的重要依据，并与支持力度挂钩。 \n    第十八条   根据国家对地质调查工作的需要和业务中心运行情况，地调局可调整业务中心的布局与建设，对业务中心进行重组、整合、撤消等。\n    第十九条   业务中心需要更名、变更研究方向，须经业务中心学术委员会同意，依托单位提出书面申请，经地调局组织专家论证和批准后执行。\n第六章　附 则\n    第二十条   本办法由地调局负责解释。\n    第二十一条   本办法自发布之日起执行。\n', 'top', '-1');
INSERT INTO `news` VALUES ('0', '8', '地质力学研究所赴吉尔吉斯斯坦开展野外地质调查', '蒋磊', '2016-08-24 17:10:16', '   2014年8月20日，地质力学研究所《中吉天山成矿带构造背景对比研究》项目组赴吉尔吉斯斯坦开展野外地质调查。\n    20日下午，项目组一行六人抵达比什凯克后，即与吉尔吉斯政府矿产资源管理局、吉尔吉斯地球物理考察队举行了座谈。地质力学所侯春堂副所长首先感谢矿产资源管理局吉拉列夫 杜什别克局长（Duishenbek Zilaliev）对合作的高度重视和支持；并简要介绍了地质力学所基本情况、项目组成员和本次野外地质调查任务，表达了进一步扩大合作的意向。项目负责人王宗秀研究员和哈里洛夫所长介绍了项目进展，取得的成果。吉拉列夫局长诚挚欢迎项目组，表示这是就任局长以来第一次会见国外项目组，指出吉尔吉斯矿产资源丰富，与中国睦邻关系友好，习近平主席与阿坦巴耶夫总统共同提议建立的中-吉战略合作伙伴关系将为两国在地学研究和矿产资源领域的合作注入强大的生命力。他高度评价了地质力学研究所与吉尔吉斯地球物理考察队5年来合作取得的丰硕成果，表示将支持进一步合作。\n    座谈中，吉拉列夫局长还高兴地谈到，已经接受国土资源部邀请，今年十月将到访北京。侯春堂副所长邀请吉拉列夫局长届时到地质力学研究所参观访问，吉拉列夫局长愉快地接受邀请，并表示将以此为契机，把中-吉在地学领域的合作推向更高的发展阶段。\n    会后，项目组与吉尔吉斯地球物理考察队哈里洛夫所长等讨论细化本年度野外地质调查方案，初步探讨了下一步合作研究相关事项。\n\n', 'top', '-1');
INSERT INTO `news` VALUES ('0', '9', '“祁连山冻土区天然气水合物控矿因素研究”取得阶段性成果', '蒋磊', '2016-08-24 17:09:48', ' 由地质力学研究所承担的“祁连山冻土区天然气水合物控矿因素综合研究”项目通过对祁连山冻土区新构造、冻土及冰川的调查与研究取得了阶段性成果，并在新生代地层、天然气水合物、烃源岩样品分析等方面获得了新认识。\n    通过对钻获天然气水合物的DK-9孔进行地温参数测量，获得了天然气水合物成藏的冻土厚度、地温梯度等参数。DK-9孔冻土厚度略大于110m，冻土层下地温梯度为2.4?C/100m。数据显示近地表冻土活动层内温度随时间波动变化明显，活动层之下的温度经过平衡后均趋于稳定，深度越大，钻孔内温度与围岩温度平衡稳定需要的时间越短。同时，通过对位于DK-9孔北侧约500m处的DK-10孔连续两个多月的监测分析出了天然气水合物温度、压力变化曲线。\n    通过对南祁连盆地晚古生代-中生代烃源岩的调查与评价，优选出了有利的气源岩层位。羊虎沟组灰岩和煤为差等气源岩，泥岩为中等-好的烃源岩，主生气辅生油；草地沟组泥岩为中等-好的生油岩；大加连组灰岩生油生气潜力差；尕勒得寺组泥岩为中等-好生油岩、好的气源岩，煤为差等气源岩；窑街组泥岩为好的烃源岩，主生油辅生气，煤为差-中等气源岩。其中羊虎沟组泥岩、草地沟组泥岩、尕勒得寺组泥岩、窑街组泥岩和煤为祁连山冻土区天然气水合物的5套主力烃源岩。\n    重建了祁连山地区新生代隆升过程与第四纪环境演化过程。新生代地层ESR年代学研究表明，火烧沟组、白杨河组、疏勒河组和玉门组年龄分别为?40.2~35.3Ma、32.6~24.3Ma、22.7~13.2Ma和3.4~3.0Ma。岩性和岩相变化及构造关系表明，始新世末-渐新世初（35.3~32.6 Ma）祁连山发生了强烈变形和隆升，并导致了火烧沟组顶部代表的晚始新世高原最早期夷平面的解体。中新世中期（15.0~9.0 Ma）阿尔金断裂带与海原断裂带的左旋走滑作用在祁连山北部形成北西向盆-岭构造，祁连山南部地壳块体向东逆冲和顺时针旋转，形成北北东向逆冲断裂和北西向右旋走滑断裂带。自5.4 Ma起祁连山脉逐步隆起，并3.4Ma开始急剧整体快速隆升，玉门砾岩不整合覆盖于夷平面之上。经过2.4~1.4 Ma和0.3~0.15 Ma的多阶段快速隆升，于中更新世早期进入冰冻圈，并奠定了今日环境格局。\n    祁连山天然气水合物控矿因素综合研究表明，天然气水合物与多年冻土、阿尔金断裂带与海原断裂带左旋走滑右阶岩桥区挤压推覆构造带及晚古生代-中生代烃源岩密切相关，天然气水合物形成于倒数第三冰期，并在中更新世中期发生过分解。盆山边界冲断带成为气体运移和天然气水合物成藏的有利地区。\n\n（地质力学研究所七室供稿）', 'top', '');
INSERT INTO `news` VALUES ('0', '10', '新建项目成功分析', '蒋磊', '2016-08-24 17:14:37', '&nbsp; &nbsp; &nbsp; &nbsp; 项目开始阶段比较困难，但是随着时间慢慢加长，对项目结构及框架的认识，慢慢的熟悉了流程，开发起来更加顺手，能够更加快速的进入开发阶段。<div>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;所以说，世上无难事只怕有心人</div>', 'top', '');

-- ----------------------------
-- Table structure for team_baseinfor
-- ----------------------------
DROP TABLE IF EXISTS `team_baseinfor`;
CREATE TABLE `team_baseinfor` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `group_id` bigint(20) DEFAULT NULL COMMENT '申报领域',
  `project_type` varchar(255) DEFAULT NULL COMMENT '依托项目类别',
  `project_name` varchar(255) DEFAULT NULL COMMENT '依托项目名称',
  `project_source` varchar(255) DEFAULT NULL COMMENT '依托项目来源',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `group_id` (`group_id`),
  CONSTRAINT `team_baseinfor_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `acct_user` (`id`),
  CONSTRAINT `team_baseinfor_ibfk_2` FOREIGN KEY (`group_id`) REFERENCES `apply_group` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='团队_依托项目表';

-- ----------------------------
-- Records of team_baseinfor
-- ----------------------------

-- ----------------------------
-- Table structure for team_user
-- ----------------------------
DROP TABLE IF EXISTS `team_user`;
CREATE TABLE `team_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '真实姓名',
  `gender` varchar(5) DEFAULT NULL COMMENT '性别',
  `birthday` date DEFAULT NULL COMMENT '出生年月',
  `zhicheng` varchar(255) DEFAULT NULL COMMENT '技术职称',
  `congshizhuanye` varchar(255) DEFAULT NULL COMMENT '从事专业/研究方向',
  `id_num` varchar(50) DEFAULT NULL COMMENT '身份证号',
  `xuewei` varchar(10) DEFAULT NULL COMMENT '学位',
  `xueli` varchar(10) DEFAULT NULL COMMENT '学历',
  `body_id` bigint(20) DEFAULT NULL COMMENT '所属组织ID',
  `is_team_leader` int(11) DEFAULT '0' COMMENT '是否是团队负责人',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `team_user_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `acct_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='团队_成员表';

-- ----------------------------
-- Records of team_user
-- ----------------------------

-- ----------------------------
-- Table structure for user_attachfile
-- ----------------------------
DROP TABLE IF EXISTS `user_attachfile`;
CREATE TABLE `user_attachfile` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `file_path` varchar(500) NOT NULL,
  `file_name` varchar(255) DEFAULT NULL,
  `file_size` bigint(20) DEFAULT NULL,
  `upload_time` datetime DEFAULT NULL,
  `file_type` int(11) DEFAULT NULL,
  `file_type_num` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `user_attachfile_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `acct_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户_附件表';

-- ----------------------------
-- Records of user_attachfile
-- ----------------------------

-- ----------------------------
-- Table structure for user_award
-- ----------------------------
DROP TABLE IF EXISTS `user_award`;
CREATE TABLE `user_award` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL DEFAULT '0',
  `date` date DEFAULT NULL COMMENT '获奖时间',
  `project_name` varchar(255) DEFAULT NULL COMMENT '获奖项目名称',
  `name` varchar(255) DEFAULT NULL COMMENT '奖励名称',
  `type` varchar(50) DEFAULT NULL COMMENT '等级',
  `rank` varchar(50) DEFAULT NULL COMMENT '排序',
  `agency` varchar(255) DEFAULT '' COMMENT '授予机构',
  `is_team_leader` int(11) DEFAULT '0' COMMENT '是否是团队负责人主持',
  PRIMARY KEY (`Id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `user_award_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `acct_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户_科研学术奖励表';

-- ----------------------------
-- Records of user_award
-- ----------------------------
INSERT INTO `user_award` VALUES ('1', '1', '2015-05-01', null, '获奖 情况name1', '国家级', '第一作者', '', '0');
INSERT INTO `user_award` VALUES ('2', '1', '2015-05-02', null, '获奖 情况name211', '国家级', '第一作者', '', '0');

-- ----------------------------
-- Table structure for user_baseinfor
-- ----------------------------
DROP TABLE IF EXISTS `user_baseinfor`;
CREATE TABLE `user_baseinfor` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `group_id` bigint(20) DEFAULT NULL COMMENT '申报领域',
  `gender` varchar(5) DEFAULT NULL COMMENT '性别',
  `minzu` varchar(20) DEFAULT NULL COMMENT '民族',
  `birthday` date DEFAULT NULL COMMENT '出生年月',
  `address` varchar(255) DEFAULT NULL COMMENT '通讯地址',
  `zhicheng` varchar(255) DEFAULT NULL COMMENT '技术职称',
  `former_name` varchar(255) DEFAULT NULL,
  `health` varchar(255) DEFAULT NULL,
  `chushengdi` varchar(255) DEFAULT NULL,
  `canjiashijian` varchar(255) DEFAULT NULL,
  `zhengzhi` varchar(255) DEFAULT NULL,
  `yuyan` varchar(255) DEFAULT NULL,
  `jisuanji` varchar(255) DEFAULT NULL,
  `minzhudangpai` varchar(255) DEFAULT NULL,
  `shehuijianzhi` varchar(255) DEFAULT NULL,
  `current_zhicheng` varchar(255) DEFAULT NULL,
  `current_zhicheng_date` varchar(255) DEFAULT NULL,
  `congshizhuanye` varchar(255) DEFAULT NULL,
  `renzhizige` varchar(255) DEFAULT NULL,
  `shenpidanwei` varchar(255) DEFAULT NULL,
  `shenpishijian` varchar(255) DEFAULT NULL,
  `xingzhengzhiwu` varchar(255) DEFAULT NULL,
  `xingzhengshijian` varchar(255) DEFAULT NULL,
  `kaohe` varchar(255) DEFAULT NULL,
  `tiaojian` varchar(255) DEFAULT NULL,
  `yingyu` varchar(255) DEFAULT NULL,
  `gongzi` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `group_id` (`group_id`) USING BTREE,
  CONSTRAINT `user_baseinfor_ibfk_2` FOREIGN KEY (`group_id`) REFERENCES `apply_group` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户_基本信息表';

-- ----------------------------
-- Records of user_baseinfor
-- ----------------------------
INSERT INTO `user_baseinfor` VALUES ('1', '1', '1', '', '汉', '1989-11-11', null, null, '无', '健康', '山东', '2016.06.28', '无', '无', '100', '无', '无', 'Java工程师', '2016.06.29', '计算机', 'Java工程师', '北京', '2016.07.03', '开发', '2016.06.28', '', '', '100', '10000');
INSERT INTO `user_baseinfor` VALUES ('2', '2', '1', '男', '汉', '1993-01-20', null, null, '无', '健康', '山东', '2015.12.15', '无', '英语四级', '三级', '无', '无', 'java开发', '2015.12.15', 'IT', '工程师', '交院', '2016.07.01', '无', '2016.08.26', '', '', '四级', '8888');
INSERT INTO `user_baseinfor` VALUES ('3', '3', '1', '男', '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `user_baseinfor` VALUES ('4', '4', '1', '男', '', '2015-06-23', null, null, '', '', '', null, '', '', '', '', '', '', null, '', '', '', null, '', null, '', '', '', '');
INSERT INTO `user_baseinfor` VALUES ('5', '5', '1', '男', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `user_baseinfor` VALUES ('6', '6', '1', '男', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `user_baseinfor` VALUES ('7', '7', '1', '男', '汉', '1993-09-01', null, null, '无', '健康', '山东', '2012.09.05', '无', '无 ', '四级', '无', '无', '开发员', '2015.09.16', '开发', '工程师', '无', '2016.08.30', '经理', '2016.09.01', '', '', '六级', '5000');
INSERT INTO `user_baseinfor` VALUES ('8', '8', '1', '男', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `user_baseinfor` VALUES ('13', '13', '1', '男', '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `user_baseinfor` VALUES ('14', '14', '1', '男', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `user_baseinfor` VALUES ('15', '15', '1', '男', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `user_baseinfor` VALUES ('16', '22', null, '男', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `user_baseinfor` VALUES ('18', '24', null, '男', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `user_baseinfor` VALUES ('19', '25', null, '男', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `user_baseinfor` VALUES ('20', '26', null, '男', '汉', '1993-07-01', null, null, '无', '健康', '山东', '2015.08.05', '无', '英语 四级', '88', '无', '无', '开发工程师', '2015.12.26', 'java开发', '工程师', '联想', '2015.08.29', '无', null, '', '', '88', '8888');

-- ----------------------------
-- Table structure for user_business
-- ----------------------------
DROP TABLE IF EXISTS `user_business`;
CREATE TABLE `user_business` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `pingjia` text COMMENT '自我评价',
  `guihua` text COMMENT '未来研究计划及当前研究基础',
  `xiangguan` text COMMENT '工作单位与推荐人选的相关性',
  PRIMARY KEY (`Id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `user_business_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `acct_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户_附加信息表';

-- ----------------------------
-- Records of user_business
-- ----------------------------
INSERT INTO `user_business` VALUES ('1', '1', '   XXX，女，汉族，XX年X月生于XX。2006年毕业于XXX学院XX系，现任XX公司XX职位。\n     本人自2006年3月参加工作以来，作为一名刚从大学校园毕业的应届大学毕业生，在一个正在迅速崛起的企业中，挖掘自己的潜力，如饥似渴地学习着新知识，迅速成长起来。\n    按照工作岗位的不同，工作经历可分为以下三个阶段：\n    一、2006年3月至2007年1月：\n    刚大学毕业就被顺利地录取到XX集团总部综合管理中心担任质量管理体系专员。第一次接触到全面的质量管理体系。我的工作职责是全面协助管理者代表开展公司的内部审核、管理评审以及外部审核，包括第二方和第三方审核。因此，在这段时间，我认真学习ISO9001和ISO13485标准，努力提高业务知识。在2006年10月，中国国医械华光认证有限公司（原中国医疗器械质量认证中心）对我公司进行跟踪审核。我负责协助安排各项审核工作，并负责陪同专家对我公司进行审核，回答相关问题。在全体同事的共同努力下，我们顺利地通过了这次审核，并取得了新的CMD质量管理体系和产品认证证书。同年12月，我们又顺利地通过了德国莱茵TUV对我公司进行的CE审核，顺利地取得了欧盟CE质量管理体系及产品认证证书。\n通过认真地学习质量管理体系文件，并多次参与公司内、外部审核，在实践中提高了业务水平，熟悉了质量管理体系的各项要求。在陪同审核中还有不少心得体会。\n     二、2007年1月至2007年8月：\n    由于在质量管理体系专员岗位上的出色表现，2007年1月被公司领导提拔为集团总裁秘书。\n为了走出国门，扩大国际市场，突破新的经济增长点，公司一直主持开发新产品。2004年8月我公司研发生产的“安全自毁式注射器”获国家知识产权局办颁发的专利证书。就此产品开发，给公司带来新的经济增长点，2006年公司出口销售额已达864万元。该产品科学技术含量高，且进入了国家高新技术产品目录。本实用新型安全自毁式注射器，结构简单、生产工艺简单稳定、安全可靠、生产成本低，在使用过程中既有普通注射器的特性又具有自毁特性，还能安全地保证针尖回缩到针筒内不外露，防止重复使用和交叉感染，能有效地保护医务人员和患者。并实现了多项创新。\n为了提高此使用新型产品的知名度，将此科技成果得到更好的推广，增创效益，出口创汇。公司决定要进行科技查新以及XX省科技厅科技成果鉴定，并申请了XX省经贸委2007年新产品。由我主要负责此项目的科技成果鉴定以及新产品验收工作。我认真系统地了解和学习了此项产品的主要技术标准，协调各部门，起草和整理了《安全自毁注射器新产品（成果）鉴定会技术文件》，并安排在我公司举行了鉴定和验收会议，得到与会领导和专家的一致认同，顺利地通过了XX省科技厅的科技成果鉴定和XX省经贸委的新产品验收，并取得了XX省经贸委颁发的2007年度新产品证书。科技成果已完成，奖项将在2008年初评定。\n由于在新产品（成果）鉴定项目中的出色表现，被公司评为“先进工作者”。\n    三、2007年8月至今\n    由于公司人员变动及人事工作的需要，我从总裁秘书职位调动到集团办公室担任人事主管一职。负责公司的人力资源管理、企业文化以及集团文化基金会各项事务。\n我深知人力是有限的，人力资源是无限的。目前正在认真学习相关的业务知识，重新梳理公司的人力资源系统。配合公司2007年薪酬改革，全面完善绩效考核体系。接下来，将逐步整合资源，策划提高员工积极性、团队精神以及凝聚力的各项方案。\n企业文化以及文化基金会的各项事务正待逐步启动。目前已组织完成2007年度员工外出旅游活动。分别安排了4批员工到厦门鼓浪屿以及三清山旅游，获得了基层员工的一致好评。并已经筹建了集团篮球队，于2007年8月26日正式成立。目前正在策划2007年度国庆中秋文艺晚会。相关的文化活动将稍后全面启动。\n\n    作为一名从大学校园毕业不久的大学生，我深知自身经验和阅历的不足将成为自身提高的瓶颈。只有认真学习，虚心向前辈请教，从实践中得到提高。但同时作为一名21世纪的年轻大学毕业生，我还可以发挥自己的学习能力、创造能力，将各项工作做得有声有色。\n在思想上坚持以邓小平理论和“三个代表”重要思想为指导，时刻牢记社会主义的荣辱观，遵守各项法律、法规和有关制度，模范执行党的各项决议和政策，努力在自身工作和日常言行中严格要求自己，树立和维护良好形象，积极向党组织靠拢。\n\n   以上是我加入XXX集团一年来的主要工作经历。总的来说，作为一名企业职员，虽然做了不少的工作，经历了许许多多的酸甜苦辣，也积累了一些有益的管理工作经验，有较为熟悉过硬的专业技术能力，但在今后的工作中，我还将进一步加强学习，努力工作，不断提高自己的专业技能，为企业和自身的生存、改革与发展做出积极的贡献。\n\n\n                                                        XXXXXXXXXX公司\n                                                        XXXXXX\n                                                         2007年8月28日\n', null, null);
INSERT INTO `user_business` VALUES ('2', '2', '11111111111111111111111111111111111+2222222222222+3333333333+444444', null, null);
INSERT INTO `user_business` VALUES ('3', '3', '22222222222222222222', null, null);

-- ----------------------------
-- Table structure for user_exam
-- ----------------------------
DROP TABLE IF EXISTS `user_exam`;
CREATE TABLE `user_exam` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `type` varchar(252) DEFAULT NULL,
  `exam_date` date DEFAULT NULL,
  `kemu` varchar(255) DEFAULT NULL,
  `chengji` varchar(255) DEFAULT NULL,
  `zuzhizhe` varchar(2525) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_exam
-- ----------------------------
INSERT INTO `user_exam` VALUES ('2', '3', '英语六级', '2016-07-31', '英语', '500', '交院');
INSERT INTO `user_exam` VALUES ('3', '3', '国考', '2016-08-01', '数学', '100', '交院');
INSERT INTO `user_exam` VALUES ('4', '2', '国考', '2013-12-25', '英语四级', '500', '交院');
INSERT INTO `user_exam` VALUES ('5', '1', '英语', '2016-08-01', '六级', '500', '教育部');
INSERT INTO `user_exam` VALUES ('6', '1', '会计', '2016-08-01', '会计证书', '80', '交院');
INSERT INTO `user_exam` VALUES ('7', '7', '英语', '2015-09-03', '六级', '500', '交院');

-- ----------------------------
-- Table structure for user_paper
-- ----------------------------
DROP TABLE IF EXISTS `user_paper`;
CREATE TABLE `user_paper` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL DEFAULT '0',
  `name` varchar(255) DEFAULT NULL COMMENT '论文题目',
  `author` varchar(255) DEFAULT NULL COMMENT '作者排序',
  `qikan_name` varchar(255) DEFAULT NULL COMMENT '期刊名称',
  `code` varchar(255) DEFAULT NULL COMMENT '年份、卷期及页码',
  `factor` varchar(255) DEFAULT NULL COMMENT '影响因子',
  `referenced` varchar(255) DEFAULT NULL COMMENT 'SCI他引次数',
  `referenced_total` varchar(255) DEFAULT NULL COMMENT '他引总次数',
  `is_team_leader` int(11) DEFAULT '0' COMMENT '是否是团队负责人主持',
  PRIMARY KEY (`Id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `user_paper_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `acct_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户_代表性论文表';

-- ----------------------------
-- Records of user_paper
-- ----------------------------
INSERT INTO `user_paper` VALUES ('1', '1', '如何提高地质测量专业测量教学质量', null, null, null, null, null, null, '0');
INSERT INTO `user_paper` VALUES ('2', '1', '矿山三维地质建模与可视化研究', null, null, null, null, null, null, '0');

-- ----------------------------
-- Table structure for user_peixun
-- ----------------------------
DROP TABLE IF EXISTS `user_peixun`;
CREATE TABLE `user_peixun` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL DEFAULT '0',
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `major` varchar(255) DEFAULT NULL COMMENT '专业',
  `country` varchar(50) DEFAULT NULL COMMENT '国家	',
  `isTop` varchar(50) DEFAULT NULL COMMENT '是否最高学历',
  `xuezhi` varchar(10) DEFAULT NULL COMMENT '学制',
  `academy` varchar(10) DEFAULT NULL COMMENT '院校',
  `xueli` varchar(10) DEFAULT NULL COMMENT '学位/学历',
  `zhengmingren` varchar(50) DEFAULT NULL COMMENT '证明人',
  PRIMARY KEY (`Id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `user_peixun_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `acct_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='用户_学习经历表';

-- ----------------------------
-- Records of user_peixun
-- ----------------------------
INSERT INTO `user_peixun` VALUES ('15', '4', '2016-08-08', '2016-08-29', '大', '大', '1', '4年', '博士', '博士研究生', '大');
INSERT INTO `user_peixun` VALUES ('16', '26', '2012-09-05', '2016-07-01', '大学学习', '山东交通学院', '1', '4年', '学士', '本科', '冯');
INSERT INTO `user_peixun` VALUES ('17', '2', '2012-09-05', '2016-07-01', '信息管理与信息系统', '中国', '1', '4年', '山东交通学院', '本科', '冯');
INSERT INTO `user_peixun` VALUES ('19', '1', '2012-09-01', '2016-07-01', '信息科学与信息系统', '中国', '1', '4年', '山东交通学院', '本科', '蒋磊');
INSERT INTO `user_peixun` VALUES ('20', '1', '2015-09-12', '2016-08-08', 'java开发', '中国', '1', '1年', '交院', '其它', '李');
INSERT INTO `user_peixun` VALUES ('21', '2', '2015-05-05', '2016-05-05', 'java开发', '中国', '1', '1', '交院', '其它', '磊');
INSERT INTO `user_peixun` VALUES ('22', '7', '2012-09-05', '2016-07-01', '计算机技术与科学', '中国', '1', '4年', '交院', '本科', '李');

-- ----------------------------
-- Table structure for user_project
-- ----------------------------
DROP TABLE IF EXISTS `user_project`;
CREATE TABLE `user_project` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL DEFAULT '0',
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `name` varchar(255) DEFAULT '' COMMENT '项目（课题）名称',
  `code` varchar(255) DEFAULT NULL COMMENT '立项编号',
  `jine` varchar(50) DEFAULT NULL COMMENT '经费(万元)',
  `laiyuan` varchar(255) DEFAULT NULL COMMENT '项目性质及来源',
  `jiaose` varchar(255) DEFAULT NULL COMMENT '担任角色/参与的其他团队成员',
  `is_team_leader` int(11) DEFAULT '0' COMMENT '是否是团队负责人主持',
  PRIMARY KEY (`Id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `user_project_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `acct_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户_科研任务表';

-- ----------------------------
-- Records of user_project
-- ----------------------------
INSERT INTO `user_project` VALUES ('1', '1', '2014-08-05', '2014-08-05', '地质研究', null, '30,000', '研究院', '承担任务1', '0');
INSERT INTO `user_project` VALUES ('2', '1', '2014-06-29', '2014-08-13', '科技情报与科技管理', null, '10,000', '研究院', '承担任务2', '0');
INSERT INTO `user_project` VALUES ('3', '1', '2014-08-12', '2014-07-30', '化学研究', null, '20,000', '研究院', '承担任务3', '0');

-- ----------------------------
-- Table structure for user_report
-- ----------------------------
DROP TABLE IF EXISTS `user_report`;
CREATE TABLE `user_report` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL DEFAULT '0',
  `date` varchar(22) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '报告名称',
  `content_summary` varchar(255) DEFAULT NULL COMMENT '内容提要',
  `situation` varchar(255) DEFAULT '' COMMENT '出版、登载获奖或在学术会议上交流情况',
  `isAlone` varchar(255) DEFAULT NULL COMMENT '合（独）著、译',
  PRIMARY KEY (`Id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `user_report_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `acct_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户_学术会议报告表';

-- ----------------------------
-- Records of user_report
-- ----------------------------
INSERT INTO `user_report` VALUES ('3', '3', '2016-08-01', 'qq                                                                                                                                                                                                                                                             ', 'qq', 'qq', 'qq');
INSERT INTO `user_report` VALUES ('4', '2', '2016-08-01', '现代信息技术研究                                                                                                                                                                                                                                                       ', '信息技术飞速发展', '人民日报', '独著');
INSERT INTO `user_report` VALUES ('6', '7', '2016-09-01', '现代通讯技术的发展                                                                                                                                                                                                                                                      ', '科学技术的发展', '中国期刊', '独著');
INSERT INTO `user_report` VALUES ('7', '1', '1', '1                                                                                                                                                                                                                                                              ', '1', '1', '1');

-- ----------------------------
-- Table structure for user_skill
-- ----------------------------
DROP TABLE IF EXISTS `user_skill`;
CREATE TABLE `user_skill` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `start_date` date DEFAULT NULL,
  `project_name` varchar(255) DEFAULT NULL,
  `jiaose` varchar(255) DEFAULT NULL,
  `project_result` varchar(255) DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_skill
-- ----------------------------
INSERT INTO `user_skill` VALUES ('9', '3', '2016-07-31', 'qq', 'qq', 'qq', '2016-07-31');
INSERT INTO `user_skill` VALUES ('10', '3', '2016-07-31', '关于施工平台项目的调研', '完成独立调研', '顺利完成调研', '2016-08-27');
INSERT INTO `user_skill` VALUES ('11', '2', '2016-08-01', '施工平台的需求调研', '独立调研', '完成独立调研', '2016-08-10');
INSERT INTO `user_skill` VALUES ('12', '1', '2015-12-01', '环境与保护的课题研究', '独立调研', '完成调研', '2016-08-29');
INSERT INTO `user_skill` VALUES ('13', '1', '2016-08-02', '现代通讯技术的研究', '参与调研，整理文档', '实验报告', '2016-08-16');
INSERT INTO `user_skill` VALUES ('14', '7', '2016-01-01', 'java工程师', '独立开发', '独立完成', '2016-09-18');

-- ----------------------------
-- Table structure for user_team
-- ----------------------------
DROP TABLE IF EXISTS `user_team`;
CREATE TABLE `user_team` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_team
-- ----------------------------
INSERT INTO `user_team` VALUES ('7', '13');

-- ----------------------------
-- Table structure for user_work
-- ----------------------------
DROP TABLE IF EXISTS `user_work`;
CREATE TABLE `user_work` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL DEFAULT '0',
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `work_content` varchar(255) DEFAULT NULL COMMENT '单位',
  `country` varchar(255) DEFAULT NULL COMMENT '国家',
  `zhiwu` varchar(255) DEFAULT NULL COMMENT '职务',
  `toNow` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `fk_user_work` FOREIGN KEY (`user_id`) REFERENCES `acct_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 COMMENT='用户_工作经历表';

-- ----------------------------
-- Records of user_work
-- ----------------------------
INSERT INTO `user_work` VALUES ('23', '3', '2016-07-31', '2016-08-22', '交院', '学生', '班干部', null);
INSERT INTO `user_work` VALUES ('24', '3', '2016-07-31', '2016-08-26', 'qq', 'qq', 'qq', null);
INSERT INTO `user_work` VALUES ('25', '2', '2015-12-15', '2016-08-26', '联想', 'java开发', '工程师', null);
INSERT INTO `user_work` VALUES ('35', '1', '2016-08-01', '2016-08-29', '中国地质科学院', '中国', '工程师', '0');
INSERT INTO `user_work` VALUES ('36', '1', '2016-08-01', '2016-08-29', '中国地质科学院', '中国', '研究院', '1');
INSERT INTO `user_work` VALUES ('37', '1', '2016-08-01', '2016-08-29', '联想', '中国', '开发员', '1');
INSERT INTO `user_work` VALUES ('38', '7', '2015-12-15', '2016-09-18', '联想', '中国', '程序员', '1');
INSERT INTO `user_work` VALUES ('39', '7', '2016-09-01', '2016-09-19', '阿里', '北京', '工程师', '1');

-- ----------------------------
-- Table structure for user_zhuanli
-- ----------------------------
DROP TABLE IF EXISTS `user_zhuanli`;
CREATE TABLE `user_zhuanli` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL DEFAULT '0',
  `date` date DEFAULT NULL COMMENT '授权时间',
  `name` varchar(255) DEFAULT NULL COMMENT '专利名称',
  `code` varchar(255) DEFAULT NULL COMMENT '授权号',
  `type` varchar(50) DEFAULT NULL COMMENT '类别',
  `rank` varchar(50) DEFAULT NULL COMMENT '发明人或设计人排序',
  `agency` varchar(255) DEFAULT '' COMMENT '授权国别或组织',
  `is_team_leader` int(11) DEFAULT '0' COMMENT '是否是团队负责人主持',
  PRIMARY KEY (`Id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `user_zhuanli_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `acct_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户_授权专利表';

-- ----------------------------
-- Records of user_zhuanli
-- ----------------------------
INSERT INTO `user_zhuanli` VALUES ('1', '1', '2014-08-05', '专利name1111', null, '国家级', '第一作者', '', '0');
INSERT INTO `user_zhuanli` VALUES ('2', '1', '2014-07-30', '专利name2', null, '国家级', '第一作者', '', '0');

-- ----------------------------
-- Table structure for user_zhuanzhu
-- ----------------------------
DROP TABLE IF EXISTS `user_zhuanzhu`;
CREATE TABLE `user_zhuanzhu` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL DEFAULT '0',
  `date` date DEFAULT NULL COMMENT '年份',
  `name` varchar(255) DEFAULT NULL COMMENT '专著名称',
  `publisher` varchar(255) DEFAULT NULL COMMENT '出版社',
  `area` varchar(255) DEFAULT NULL COMMENT '发行国家和地区',
  `is_team_leader` int(11) DEFAULT '0' COMMENT '是否是团队负责人主持',
  PRIMARY KEY (`Id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `user_zhuanzhu_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `acct_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户_专著情况表';

-- ----------------------------
-- Records of user_zhuanzhu
-- ----------------------------
INSERT INTO `user_zhuanzhu` VALUES ('1', '1', '2014-08-05', '助理工程师', '职称考试', null, '0');
INSERT INTO `user_zhuanzhu` VALUES ('3', '1', '2014-08-12', '注册岩土工程师', '职称考试', null, '0');

-- ----------------------------
-- Table structure for user_zuzhi
-- ----------------------------
DROP TABLE IF EXISTS `user_zuzhi`;
CREATE TABLE `user_zuzhi` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL DEFAULT '0',
  `date` date DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `jiaose` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `other` varchar(255) DEFAULT '',
  PRIMARY KEY (`Id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `user_zuzhi_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `acct_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户_学术组织任职表';

-- ----------------------------
-- Records of user_zuzhi
-- ----------------------------
