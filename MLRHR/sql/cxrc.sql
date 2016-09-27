CREATE DATABASE  IF NOT EXISTS `cxrc` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `cxrc`;
-- MySQL dump 10.13  Distrib 5.7.9, for linux-glibc2.5 (x86_64)
--
-- Host: 127.0.0.1    Database: cxrc
-- ------------------------------------------------------
-- Server version	5.5.49-0ubuntu0.14.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `acct_authority`
--

DROP TABLE IF EXISTS `acct_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `acct_authority` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 NOT NULL,
  `url` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=gbk ROW_FORMAT=COMPACT COMMENT='权限表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `acct_role`
--

DROP TABLE IF EXISTS `acct_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `acct_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=gbk ROW_FORMAT=COMPACT COMMENT='角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `acct_role_authority`
--

DROP TABLE IF EXISTS `acct_role_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `acct_role_authority` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL,
  `authority_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKAE243466DE3FB930` (`role_id`),
  KEY `FKAE2434663FE97564` (`authority_id`),
  CONSTRAINT `acct_role_authority_ibfk_1` FOREIGN KEY (`authority_id`) REFERENCES `acct_authority` (`id`),
  CONSTRAINT `FKAE243466DE3FB930` FOREIGN KEY (`role_id`) REFERENCES `acct_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=gbk ROW_FORMAT=COMPACT COMMENT='角色-权限对应表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `acct_user`
--

DROP TABLE IF EXISTS `acct_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `acct_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `apply_name` int(11) DEFAULT NULL COMMENT '0:领军人才。1:杰出青年 。2：创新团队',
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
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `acct_user_role`
--

DROP TABLE IF EXISTS `acct_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `acct_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKFE85CB3EDE3FB930` (`role_id`),
  KEY `FKFE85CB3E836A7D10` (`user_id`),
  CONSTRAINT `acct_user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `acct_user` (`id`),
  CONSTRAINT `acct_user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `acct_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=gbk ROW_FORMAT=COMPACT COMMENT='用户角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `apply`
--

DROP TABLE IF EXISTS `apply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `apply` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL DEFAULT '0',
  `apply_date` datetime DEFAULT NULL COMMENT '申请时间',
  `apply_type` varchar(10) DEFAULT NULL,
  `apply_name` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT '0' COMMENT '0:初试状态;1:提交初审;2:初审通过;3:初审公示;4:进入复审;5:提交复审;6:复审通过;7:复审公示;7:领导审核;8:评审通过;9:评审不通过',
  `pre_approve_date` date DEFAULT NULL COMMENT '主管单位操作时间',
  `pre_approve_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '主管单位操作者id',
  `pre_approve_sug` text COMMENT '主管单位意见',
  `finial_approve_date` date DEFAULT NULL COMMENT '评审小组操作时间',
  `finial_approve_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '评审小组操作者id',
  `finial_approve_sug` text COMMENT '评审小组意见',
  `expert1_date` date DEFAULT NULL COMMENT '初审专家操作时间',
  `expert1_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '初审专家操作者id',
  `expert1_score` int(11) DEFAULT '0' COMMENT '初审专家平均分',
  `expert1_sug` text COMMENT '初审专家意见',
  `expert2_date` date DEFAULT NULL COMMENT '复审专家操作时间',
  `expert2_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '复审专家操作者id',
  `expert2_score` int(11) DEFAULT '0' COMMENT '复审专家平均分',
  `expert2_sug` text COMMENT '复审专家意见',
  PRIMARY KEY (`Id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `apply_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `acct_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='申请记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `apply_group`
--

DROP TABLE IF EXISTS `apply_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `apply_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '分组名称',
  `pId` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='申报领域分组表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `body`
--

DROP TABLE IF EXISTS `body`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=263 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='组织结构表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `calendar`
--

DROP TABLE IF EXISTS `calendar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `calendar` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `jieshao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cxtd_doc01`
--

DROP TABLE IF EXISTS `cxtd_doc01`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cxtd_doc01` (
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cxtd_doc02`
--

DROP TABLE IF EXISTS `cxtd_doc02`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cxtd_doc02` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `team_id` int(11) DEFAULT NULL,
  `name` varchar(11) DEFAULT NULL COMMENT '姓名',
  `sex` varchar(5) DEFAULT NULL COMMENT '性别',
  `country` varchar(50) DEFAULT NULL COMMENT '国籍',
  `minzu` varchar(35) DEFAULT NULL COMMENT '民族',
  `position` varchar(50) DEFAULT NULL COMMENT '专业技术职务',
  `birthday` varchar(50) DEFAULT NULL COMMENT '出生日期',
  `document_type` varchar(50) DEFAULT NULL COMMENT '证件类型',
  `document_number` varchar(100) DEFAULT NULL COMMENT '证件号码',
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cxtd_doc02_study`
--

DROP TABLE IF EXISTS `cxtd_doc02_study`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cxtd_doc02_study` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `team_id` int(11) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `college` varchar(255) DEFAULT NULL,
  `major` varchar(255) DEFAULT NULL,
  `degree` varchar(255) DEFAULT NULL,
  `start_time` varchar(100) DEFAULT NULL,
  `end_time` varchar(100) DEFAULT NULL,
  `status` int(11) DEFAULT '0' COMMENT '是否提交（0；1）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cxtd_doc02_work`
--

DROP TABLE IF EXISTS `cxtd_doc02_work`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cxtd_doc02_work` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `team_id` int(11) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `body` varchar(255) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  `start_time` varchar(100) DEFAULT NULL,
  `end_time` varchar(100) DEFAULT NULL,
  `status` int(10) DEFAULT '0' COMMENT '是否提交（0；1）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cxtd_doc03`
--

DROP TABLE IF EXISTS `cxtd_doc03`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cxtd_doc03` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `team_id` varchar(11) NOT NULL COMMENT '团队ID',
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `sex` varchar(10) DEFAULT NULL COMMENT '性别',
  `birthday` varchar(255) DEFAULT NULL COMMENT '出生年月',
  `document_type` varchar(255) DEFAULT NULL COMMENT '证件类型',
  `document_number` varchar(255) DEFAULT NULL COMMENT '证件号码',
  `study_education` varchar(255) DEFAULT NULL COMMENT '学历学位',
  `work_position` varchar(255) DEFAULT NULL COMMENT '职位职称',
  `direction` varchar(255) DEFAULT NULL COMMENT '现从事专业或研究方向',
  `work_company` varchar(255) DEFAULT NULL COMMENT '工作单位',
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cxtd_paper_doc09`
--

DROP TABLE IF EXISTS `cxtd_paper_doc09`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cxtd_paper_doc09` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `status` int(11) NOT NULL COMMENT '0:团队负责人主导；1：团队核心成员主导',
  `paper_name` varchar(50) DEFAULT NULL COMMENT 'l论文名称',
  `author` varchar(50) DEFAULT NULL COMMENT '主要作者',
  `qikan_name` varchar(50) DEFAULT NULL COMMENT '期刊名称',
  `year_volume_pagenumber` varchar(255) DEFAULT NULL COMMENT '年份、卷期及页码',
  `influence_factor` varchar(255) DEFAULT NULL COMMENT '影响因子',
  `sci_times` varchar(255) DEFAULT NULL COMMENT 'SCI他引次数',
  `number_total` varchar(255) DEFAULT NULL COMMENT '他引总次数',
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cxtd_patent_doc05`
--

DROP TABLE IF EXISTS `cxtd_patent_doc05`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cxtd_patent_doc05` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `status` int(11) DEFAULT NULL COMMENT '0:团队负责人主导；1：团队核心成员主导',
  `patent_name` varchar(255) DEFAULT NULL COMMENT '专利名称',
  `grant_number` varchar(255) DEFAULT NULL COMMENT '授权号',
  `type` varchar(255) DEFAULT NULL COMMENT '类型',
  `inventor_sort` varchar(255) DEFAULT NULL COMMENT '发明人或者设计人排序',
  `authorized_time` varchar(255) DEFAULT NULL COMMENT '授权时间',
  `authorized_national` varchar(255) DEFAULT NULL COMMENT '授权国别或组织',
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cxtd_project_doc04`
--

DROP TABLE IF EXISTS `cxtd_project_doc04`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cxtd_project_doc04` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `status` int(11) NOT NULL COMMENT '0:团队负责人主导；1：团队核心成员主导',
  `project_name` varchar(255) DEFAULT NULL COMMENT '项目名称',
  `project_number` varchar(255) DEFAULT NULL COMMENT '立项编号',
  `funding` varchar(255) DEFAULT NULL COMMENT '经费（万元）',
  `start_stop_time` varchar(255) DEFAULT NULL COMMENT '起止时间',
  `source` varchar(255) DEFAULT NULL COMMENT '性质及来源',
  `other_member` varchar(255) DEFAULT NULL COMMENT '团队其他成员',
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cxtd_report_doc07`
--

DROP TABLE IF EXISTS `cxtd_report_doc07`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cxtd_report_doc07` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `status` int(11) DEFAULT NULL COMMENT '0:团队负责人主导；1：团队核心成员主导',
  `report_name` varchar(255) DEFAULT NULL COMMENT '报告名称',
  `meeting_name` varchar(255) DEFAULT NULL COMMENT '会议名称',
  `organizers` varchar(255) DEFAULT NULL COMMENT '主办方',
  `time` varchar(255) DEFAULT NULL COMMENT '时间',
  `place` varchar(255) DEFAULT NULL COMMENT '地点',
  `report_type` varchar(255) DEFAULT NULL COMMENT '报告类型',
  `reporter` varchar(255) DEFAULT NULL COMMENT '报告人',
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cxtd_reward_doc06`
--

DROP TABLE IF EXISTS `cxtd_reward_doc06`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cxtd_reward_doc06` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `starts` int(11) DEFAULT NULL COMMENT '0:团队负责人主导；1：团队核心成员主导',
  `project_name` varchar(255) DEFAULT NULL COMMENT '项目名称',
  `reward_name` varchar(255) DEFAULT NULL COMMENT '奖项名称',
  `level` varchar(11) DEFAULT NULL COMMENT '等级',
  `grant_institution` varchar(50) DEFAULT NULL COMMENT '授予机构',
  `reward_name_level` varchar(50) DEFAULT NULL COMMENT '获奖人与等级',
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cxtd_zhuzuo_doc08`
--

DROP TABLE IF EXISTS `cxtd_zhuzuo_doc08`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cxtd_zhuzuo_doc08` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `status` int(11) NOT NULL COMMENT '0:团队负责人主导；1：团队核心成员主导',
  `zhuozuo_name` varchar(255) DEFAULT NULL COMMENT '著作名称',
  `press` varchar(255) DEFAULT NULL COMMENT '出版社',
  `author` varchar(50) DEFAULT NULL COMMENT '作者',
  `country` varchar(50) DEFAULT NULL COMMENT '发行国家和地区',
  `year` varchar(50) DEFAULT NULL COMMENT '年份',
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `expert_user`
--

DROP TABLE IF EXISTS `expert_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `jcqn_doc01`
--

DROP TABLE IF EXISTS `jcqn_doc01`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `jcqn_doc02`
--

DROP TABLE IF EXISTS `jcqn_doc02`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `jcqn_doc02_01`
--

DROP TABLE IF EXISTS `jcqn_doc02_01`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jcqn_doc02_01` (
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `jcqn_doc02_02`
--

DROP TABLE IF EXISTS `jcqn_doc02_02`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jcqn_doc02_02` (
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `jcqn_doc02_03`
--

DROP TABLE IF EXISTS `jcqn_doc02_03`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jcqn_doc02_03` (
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `jcqn_doc02_04`
--

DROP TABLE IF EXISTS `jcqn_doc02_04`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jcqn_doc02_04` (
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `jcqn_doc02_05`
--

DROP TABLE IF EXISTS `jcqn_doc02_05`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jcqn_doc02_05` (
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `jcqn_doc02_06`
--

DROP TABLE IF EXISTS `jcqn_doc02_06`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jcqn_doc02_06` (
  `xuhao_id` int(11) DEFAULT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `treatise_name` varchar(255) DEFAULT NULL COMMENT '专著名称',
  `press` varchar(255) DEFAULT NULL COMMENT '出版社',
  `issuing_country` varchar(255) DEFAULT NULL COMMENT '发行国家和地区',
  `year` varchar(255) DEFAULT NULL COMMENT '年份',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `jcqn_doc03`
--

DROP TABLE IF EXISTS `jcqn_doc03`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jcqn_doc03` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `selfAssessment` mediumtext COMMENT '自我评价',
  PRIMARY KEY (`user_id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `jcqn_doc04`
--

DROP TABLE IF EXISTS `jcqn_doc04`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jcqn_doc04` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `futurePlans` mediumtext COMMENT '未来计划及当前研究基础',
  PRIMARY KEY (`user_id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `jcqn_doc05`
--

DROP TABLE IF EXISTS `jcqn_doc05`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jcqn_doc05` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `needsRelevanceSupport` mediumtext COMMENT '工作单位发展需求与推荐人选的相关性及工作单位提供的支持保障措施',
  PRIMARY KEY (`user_id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `jcqn_doc06`
--

DROP TABLE IF EXISTS `jcqn_doc06`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jcqn_doc06` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `work_unit_opinion` mediumtext COMMENT '工作单位意见',
  `recommended_unit_opinion` mediumtext COMMENT '推荐单位意见',
  PRIMARY KEY (`user_id`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `mark_detail`
--

DROP TABLE IF EXISTS `mark_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `mark_infor`
--

DROP TABLE IF EXISTS `mark_infor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `news`
--

DROP TABLE IF EXISTS `news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `team_baseinfor`
--

DROP TABLE IF EXISTS `team_baseinfor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `team_user`
--

DROP TABLE IF EXISTS `team_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_attachfile`
--

DROP TABLE IF EXISTS `user_attachfile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_award`
--

DROP TABLE IF EXISTS `user_award`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_baseinfor`
--

DROP TABLE IF EXISTS `user_baseinfor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户_基本信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_business`
--

DROP TABLE IF EXISTS `user_business`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_exam`
--

DROP TABLE IF EXISTS `user_exam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_exam` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `type` varchar(252) DEFAULT NULL,
  `exam_date` date DEFAULT NULL,
  `kemu` varchar(255) DEFAULT NULL,
  `chengji` varchar(255) DEFAULT NULL,
  `zuzhizhe` varchar(2525) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_paper`
--

DROP TABLE IF EXISTS `user_paper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_peixun`
--

DROP TABLE IF EXISTS `user_peixun`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_peixun` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL DEFAULT '0',
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL COMMENT '国家',
  `place` varchar(50) DEFAULT NULL,
  `isTop` varchar(50) DEFAULT NULL,
  `xuezhi` varchar(10) DEFAULT NULL,
  `xuewei` varchar(10) DEFAULT NULL,
  `xueli` varchar(10) DEFAULT NULL,
  `zhengmingren` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `user_peixun_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `acct_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='用户_学习经历表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_project`
--

DROP TABLE IF EXISTS `user_project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_report`
--

DROP TABLE IF EXISTS `user_report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_report` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL DEFAULT '0',
  `date` date DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '报告名称',
  `content_summary` varchar(255) DEFAULT NULL COMMENT '内容提要',
  `situation` varchar(255) DEFAULT '' COMMENT '出版、登载获奖或在学术会议上交流情况',
  `isAlone` varchar(255) DEFAULT NULL COMMENT '合（独）著、译',
  PRIMARY KEY (`Id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `user_report_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `acct_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户_学术会议报告表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_skill`
--

DROP TABLE IF EXISTS `user_skill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_team`
--

DROP TABLE IF EXISTS `user_team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_team` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_work`
--

DROP TABLE IF EXISTS `user_work`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_work` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL DEFAULT '0',
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `work_content` varchar(255) DEFAULT NULL,
  `zhiwu` varchar(255) DEFAULT NULL,
  `job` varchar(255) DEFAULT NULL,
  `toNow` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `fk_user_work` FOREIGN KEY (`user_id`) REFERENCES `acct_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='用户_工作经历表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_zhuanli`
--

DROP TABLE IF EXISTS `user_zhuanli`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_zhuanzhu`
--

DROP TABLE IF EXISTS `user_zhuanzhu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_zuzhi`
--

DROP TABLE IF EXISTS `user_zuzhi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping events for database 'cxrc'
--

--
-- Dumping routines for database 'cxrc'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-08-25 18:24:11
