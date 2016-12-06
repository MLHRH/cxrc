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
-- Dumping data for table `acct_authority`
--

LOCK TABLES `acct_authority` WRITE;
/*!40000 ALTER TABLE `acct_authority` DISABLE KEYS */;
INSERT INTO `acct_authority` VALUES (1,'LOGIN',''),(2,'ADMIN',''),(3,'USER',NULL),(4,'HR',NULL),(5,'PROFESSOR',NULL),(6,'EXPERT1',NULL),(7,'EXPERT2',NULL);
/*!40000 ALTER TABLE `acct_authority` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `acct_role`
--

LOCK TABLES `acct_role` WRITE;
/*!40000 ALTER TABLE `acct_role` DISABLE KEYS */;
INSERT INTO `acct_role` VALUES (1,'Admin'),(4,'初审专家'),(3,'初级管理员'),(5,'复审专家'),(2,'普通职工'),(6,'高级管理员');
/*!40000 ALTER TABLE `acct_role` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=gbk ROW_FORMAT=COMPACT COMMENT='角色-权限对应表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acct_role_authority`
--

LOCK TABLES `acct_role_authority` WRITE;
/*!40000 ALTER TABLE `acct_role_authority` DISABLE KEYS */;
INSERT INTO `acct_role_authority` VALUES (1,1,1),(3,3,4),(4,1,2),(7,4,6),(8,5,7),(10,4,1),(11,1,4),(12,5,1),(13,6,1),(17,1,5),(23,2,3),(24,2,1),(25,3,1),(31,6,5),(32,6,4);
/*!40000 ALTER TABLE `acct_role_authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `acct_user`
--

DROP TABLE IF EXISTS `acct_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acct_user`
--

LOCK TABLES `acct_user` WRITE;
/*!40000 ALTER TABLE `acct_user` DISABLE KEYS */;
INSERT INTO `acct_user` VALUES (1,0,'jl@qq.com','tongdehui','蒋磊','96e79218965eb72c92a549dd5a330112',1,'12313244545','','','',NULL),(28,NULL,'13556588554@16.com','123','普通职工1','96e79218965eb72c92a549dd5a330112',6,'123','','','',NULL),(29,NULL,'18366132576@163.com','1234','初级审核人员','96e79218965eb72c92a549dd5a330112',1,'1234',NULL,NULL,NULL,NULL),(30,NULL,'18366132455@163.com','123456','高级审核人员','96e79218965eb72c92a549dd5a330112',1,'123456',NULL,NULL,NULL,NULL),(31,NULL,'182255525@163.com','121','普通职工2','96e79218965eb72c92a549dd5a330112',2,'121','','','',NULL),(32,NULL,'151515674@163.com','122','普通职工3','96e79218965eb72c92a549dd5a330112',3,'122','','','',NULL),(33,NULL,'156751576@163.com','124','普通职工4','96e79218965eb72c92a549dd5a330112',5,'124','','','',NULL),(34,NULL,'454165156@163.com','expert1','初审专家','96e79218965eb72c92a549dd5a330112',1,'1234567',NULL,NULL,NULL,NULL),(35,NULL,'45164654@163.com','expert2','复审专家','96e79218965eb72c92a549dd5a330112',1,'125255',NULL,NULL,NULL,NULL),(37,NULL,'1234@163.com','12344','初审专家1','96e79218965eb72c92a549dd5a330112',2,'12344',NULL,NULL,NULL,NULL),(38,NULL,'1233@163.com','1233','复审专家2','96e79218965eb72c92a549dd5a330112',3,'1233',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `acct_user` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=gbk ROW_FORMAT=COMPACT COMMENT='用户角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acct_user_role`
--

LOCK TABLES `acct_user_role` WRITE;
/*!40000 ALTER TABLE `acct_user_role` DISABLE KEYS */;
INSERT INTO `acct_user_role` VALUES (1,1,1),(61,28,2),(62,29,3),(63,30,6),(64,31,2),(65,32,2),(66,33,2),(67,34,4),(68,35,5),(70,37,4),(71,38,5);
/*!40000 ALTER TABLE `acct_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `apply`
--

DROP TABLE IF EXISTS `apply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `apply` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL DEFAULT '0',
  `group_id` int(11) NOT NULL DEFAULT '1' COMMENT '分组ID',
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
  KEY `group_1sa` (`group_id`),
  CONSTRAINT `apply_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `acct_user` (`id`),
  CONSTRAINT `group_1sa` FOREIGN KEY (`group_id`) REFERENCES `group_tree` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8 COMMENT='申请记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apply`
--

LOCK TABLES `apply` WRITE;
/*!40000 ALTER TABLE `apply` DISABLE KEYS */;
INSERT INTO `apply` VALUES (62,31,2,'2016-12-05 18:17:35','杰出青年','打分阶段',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(63,32,3,'2016-12-06 10:32:54','杰出青年','已提交',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(64,33,1,'2016-12-06 11:48:47','杰出青年','已结束',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(65,28,1,'2016-12-06 14:19:54','杰出青年','打分完成',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `apply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `apply_group`
--

DROP TABLE IF EXISTS `apply_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `apply_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `apply_id` int(11) DEFAULT NULL COMMENT '申请ID',
  `group_id` int(255) DEFAULT NULL COMMENT '分组ID',
  `expert_id` int(255) DEFAULT NULL COMMENT '专家ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='申报领域分组表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apply_group`
--

LOCK TABLES `apply_group` WRITE;
/*!40000 ALTER TABLE `apply_group` DISABLE KEYS */;
INSERT INTO `apply_group` VALUES (1,1,1,1);
/*!40000 ALTER TABLE `apply_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `apply_menu`
--

DROP TABLE IF EXISTS `apply_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `apply_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_id` varchar(50) DEFAULT NULL COMMENT '申请文件的ID',
  `menu_details` varchar(255) DEFAULT NULL COMMENT '申请文件的名称',
  `menu_type` varchar(255) DEFAULT NULL COMMENT '申请文件类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apply_menu`
--

LOCK TABLES `apply_menu` WRITE;
/*!40000 ALTER TABLE `apply_menu` DISABLE KEYS */;
INSERT INTO `apply_menu` VALUES (1,'jcqnDoc01','1. 基本信息','杰出青年'),(2,'jcqnDoc02','2.近五年科研情况','杰出青年'),(3,'jcqnDoc03','3.推荐人选自我评价','杰出青年'),(4,'jcqnDoc04','4.未来研究计划及当前研究基础','杰出青年'),(5,'jcqnDoc05','5. 工作单位发展需求与推荐人选的相关性及工作单位提供的支持保障措施','杰出青年'),(6,'jcqnDoc06','6.承诺与推荐意见','杰出青年'),(7,'jcqnDoc07','7. 专家评分','杰出青年'),(8,'kjljDoc01','1.基本信息','科技领军'),(9,'kjljDoc02','2.近五年科研情况','科技领军'),(10,'kjljDoc03','3.推荐人选自我评价','科技领军'),(11,'kjljDoc04','4.未来研究计划及当前研究基础','科技领军'),(12,'kjljDoc05','5. 工作单位发展需求与推荐人选的相关性及工作单位提供的支持保障措施','科技领军'),(13,'kjljDoc06','6.承诺与推荐意见','科技领军'),(14,'kjljDoc07','7. 专家评分','科技领军'),(15,'cxtdDoc01','1.基本信息','创新团队'),(16,'cxtdDoc02','2.近五年主要科研情况','创新团队'),(17,'ctxdDoc03','3.团队及负责人自我评价','创新团队'),(18,'cxtdDoc04','4.团队发展规划及基础情况','创新团队'),(19,'cxtdDoc05','5.工作单位发展需求与推荐团队的相关性及工作单位提供的支持保障措施','创新团队'),(20,'cxtdDoc06','6.承诺与推荐意见','创新团队'),(21,'cxtdDoc07','7. 专家打分','创新团队');
/*!40000 ALTER TABLE `apply_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `body`
--

DROP TABLE IF EXISTS `body`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `body` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(4000) DEFAULT NULL COMMENT '单位名称',
  `pId` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL COMMENT '电话',
  `telefax` varchar(255) DEFAULT NULL COMMENT '传真',
  `bodyType` varchar(255) DEFAULT NULL,
  `web` varchar(255) DEFAULT NULL,
  `legal_person` varchar(255) DEFAULT NULL COMMENT '法定代表人',
  `address` varchar(255) DEFAULT NULL COMMENT '单位地址',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `code` varchar(255) DEFAULT NULL COMMENT '组织机构代码',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机',
  `zip_code` varchar(255) DEFAULT NULL COMMENT '邮编',
  `contact` varchar(255) DEFAULT NULL COMMENT '单位联系人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='组织结构表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `body`
--

LOCK TABLES `body` WRITE;
/*!40000 ALTER TABLE `body` DISABLE KEYS */;
INSERT INTO `body` VALUES (1,'汇总','0','010-00000000','010-00000000','事业单位','http://www.cgs.gov.cn/','待定','北京市西城区阜外大街45号院','webmaster@mail.cgs.gov.cn',NULL,NULL,NULL,NULL),(2,'地调局局机关','1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,'地调局天津中心','1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(5,'地调局南京中心','1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'地调局武汉中心','1',NULL,NULL,NULL,'http://www.yichang.cgs.gov.cn',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'地调局成都中心','1',NULL,NULL,NULL,'http://www.chengdu.cgs.gov.cn',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'地调局西安中心','1',NULL,NULL,NULL,'http://www.xian.cgs.gov.cn/',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(9,'地调局青岛海洋所','1',NULL,NULL,NULL,'http://www.qimg.cgs.gov.cn/',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(10,'地调局航遥中心','1',NULL,NULL,NULL,'http://www.agrs.cn/',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(11,'地调局广州海洋局','1',NULL,NULL,NULL,'http://www.gmgs.com.cn',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(12,'地调局水环中心','1',NULL,NULL,NULL,'http://www.chegs.cn',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(13,'地调局油气调查中心','1',NULL,NULL,NULL,'http://www.ogs-cgs.cn',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(14,'地调局发展中心','1',NULL,NULL,NULL,'http://www.drc.cgs.gov.cn',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(15,'地调局实物资料中心','1',NULL,NULL,NULL,'http://swzx.org.cn/',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(16,'地调局环境监测院','1',NULL,NULL,NULL,'http://www.cigem.info/',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(17,'地调局图书馆','1',NULL,NULL,NULL,'http://library.cgs.gov.cn',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(18,'地科院院机关','1',NULL,NULL,NULL,'http://www.cags.ac.cn',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(19,'地科院地质所','1',NULL,NULL,NULL,'http://igeo.cags.ac.cn/',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(20,'地科院资源所','1',NULL,NULL,NULL,'http://imr.cags.ac.cn/',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(21,'地科院力学所','1',NULL,NULL,NULL,'http://www.geomech.ac.cn/',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(22,'地科院测试中心','1',NULL,NULL,NULL,'http://nrcga.cags.ac.cn/',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(23,'地科院水环所','1',NULL,NULL,NULL,'http://www.iheg.org.cn',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(24,'地科院物化探所','1',NULL,NULL,NULL,'http://igge.cags.ac.cn/',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(25,'地科院岩溶所','1',NULL,NULL,NULL,'http://www.karst.ac.cn/',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(26,'地调局成都综合所','1',NULL,NULL,NULL,'http://www.imumr.cn',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(27,'地调局郑州综合所','1',NULL,NULL,NULL,'http://www.imu.ac.cn/',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(28,'地调局勘探所','1',NULL,NULL,NULL,'http://www.cniet.com',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(29,'地调局成都工艺所','1',NULL,NULL,NULL,'http://www.cgiet.com/',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(30,'地调局北京探工所','1',NULL,NULL,NULL,'http://www.bjiee.com.cn/',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `body` ENABLE KEYS */;
UNLOCK TABLES;

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
  `jieshao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calendar`
--

LOCK TABLES `calendar` WRITE;
/*!40000 ALTER TABLE `calendar` DISABLE KEYS */;
INSERT INTO `calendar` VALUES (1,'2016-01-01','2016-12-31','根据打分表，独立打出分数，并提出合理意见。打分过程一定要按照公平公正的原则，合理打分。严禁一切形式的徇私舞弊，违者直接取消评审资格。<div><br></div><div>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 谢谢</div>');
/*!40000 ALTER TABLE `calendar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cxtd_base_info`
--

DROP TABLE IF EXISTS `cxtd_base_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cxtd_base_info`
--

LOCK TABLES `cxtd_base_info` WRITE;
/*!40000 ALTER TABLE `cxtd_base_info` DISABLE KEYS */;
INSERT INTO `cxtd_base_info` VALUES (2,32,4,'sss','','','',NULL,'','','','','','','','',0,'','','','','',0),(3,32,4,'sss','qeqw','ewqe','ewq','0','','eq','ewq','qe','eq','eqe','eqeq','eqe',123056,'ewq','13835355','ewq','35165','1ewq',0),(4,32,4,'sss','qeqw','ewqe','ewq','0','','eq','ewq','qe','eq','eqe','eqeq','eqe',123056,'ewq','13835355','ewq','35165','1ewq',0),(5,32,4,'sss','qeqw','ewqe','ewq','0','','eq','ewq','qe','eq','eqe','eqeq','eqe',123056,'ewq','13835355','ewq','35165','1ewq',0),(6,32,4,'sss','qeqw','ewqe','ewq','0','','eq','ewq','qe','eq','eqe','eqeq','eqe',123056,'ewq','13835355','ewq','35165','1ewq',0),(7,32,4,'sss','qeqw','ewqe','ewq','0','','eq','ewq','qe','eq','eqe','eqeq','eqe',123056,'ewq','13835355','ewq','35165','1ewq',0),(8,32,4,'sss','qeqw','ewqe','ewq','0','','eq','ewq','qe','eq','eqe','eqeq','eqe',123056,'ewq','13835355','ewq','35165','1ewq',0),(9,32,4,'sss','qeqw','ewqe','ewq','0','','eq','ewq','qe','eq','eqe','eqeq','eqe',123056,'ewq','13835355','ewq','35165','1ewq',0),(10,32,4,'sss','qeqw','ewqe','ewq','0','','eq','ewq','qe','eq','eqe','eqeq','eqe',123056,'ewq','13835355','ewq','35165','1ewq',0),(11,32,4,'sss','qeqw','ewqe','ewq','0','','eq','ewq','qe','eq','eqe','eqeq','eqe',123056,'ewq','13835355','ewq','35165','1ewq',0),(12,32,4,'sss','qeqw','ewqe','ewq','0','','eq','ewq','qe','eq','eqe','eqeq','eqe',123056,'ewq','13835355','ewq','35165','1ewq',0),(13,32,4,'sss','qeqw','ewqe','ewq','0','','eq','ewq','qe','eq','eqe','eqeq','eqe',123056,'ewq','13835355','ewq','35165','1ewq',0);
/*!40000 ALTER TABLE `cxtd_base_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cxtd_leader_info`
--

DROP TABLE IF EXISTS `cxtd_leader_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cxtd_leader_info`
--

LOCK TABLES `cxtd_leader_info` WRITE;
/*!40000 ALTER TABLE `cxtd_leader_info` DISABLE KEYS */;
INSERT INTO `cxtd_leader_info` VALUES (1,32,4,'无名','男','中国','汉','java','1987','身份证','341787415785631567','单位','单位','单位','3856922','18018018018','','135236','北京',0);
/*!40000 ALTER TABLE `cxtd_leader_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cxtd_leader_zuzhi`
--

DROP TABLE IF EXISTS `cxtd_leader_zuzhi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cxtd_leader_zuzhi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '组织或期刊名称',
  `job` varchar(255) DEFAULT NULL COMMENT '职务',
  `renqi` varchar(255) DEFAULT NULL COMMENT '任期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cxtd_leader_zuzhi`
--

LOCK TABLES `cxtd_leader_zuzhi` WRITE;
/*!40000 ALTER TABLE `cxtd_leader_zuzhi` DISABLE KEYS */;
INSERT INTO `cxtd_leader_zuzhi` VALUES (11,32,'','','');
/*!40000 ALTER TABLE `cxtd_leader_zuzhi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cxtd_member_info`
--

DROP TABLE IF EXISTS `cxtd_member_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cxtd_member_info`
--

LOCK TABLES `cxtd_member_info` WRITE;
/*!40000 ALTER TABLE `cxtd_member_info` DISABLE KEYS */;
INSERT INTO `cxtd_member_info` VALUES (13,'4','无名','男','1855','身份证','533341545','本科','开发商',NULL,NULL);
/*!40000 ALTER TABLE `cxtd_member_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cxtd_member_num`
--

DROP TABLE IF EXISTS `cxtd_member_num`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cxtd_member_num`
--

LOCK TABLES `cxtd_member_num` WRITE;
/*!40000 ALTER TABLE `cxtd_member_num` DISABLE KEYS */;
INSERT INTO `cxtd_member_num` VALUES (1,4,NULL,1,1,1,1,1,1,1,1,1,1,1,NULL);
/*!40000 ALTER TABLE `cxtd_member_num` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expert_score`
--

DROP TABLE IF EXISTS `expert_score`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `expert_score` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `expert_id` int(12) DEFAULT NULL,
  `user_id` int(12) DEFAULT NULL,
  `expert_score` varchar(50) DEFAULT NULL,
  `expert_pingyu` varchar(255) DEFAULT NULL,
  `apply_id` int(12) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expert_score`
--

LOCK TABLES `expert_score` WRITE;
/*!40000 ALTER TABLE `expert_score` DISABLE KEYS */;
INSERT INTO `expert_score` VALUES (3,34,31,'100','很好，很不错',1),(4,34,33,'100','很好',46),(5,34,32,'100','很好，很不错',63),(6,35,32,'60','材料资质一般',63);
/*!40000 ALTER TABLE `expert_score` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expert_user`
--

DROP TABLE IF EXISTS `expert_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `expert_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `group_id` int(11) DEFAULT '1' COMMENT '所属分组id',
  `team_leader_type` int(11) DEFAULT '0' COMMENT '1:组长；2：副组长；3:成员',
  `gender` varchar(25) DEFAULT NULL COMMENT '性别',
  `minzu` varchar(20) DEFAULT NULL COMMENT '民族',
  `birthday` varchar(255) DEFAULT NULL COMMENT '出生年月',
  `address` varchar(255) DEFAULT NULL COMMENT '通讯地址',
  `zhicheng` varchar(255) DEFAULT NULL COMMENT '技术职称',
  `congshizhuanye` varchar(255) DEFAULT NULL COMMENT '从事专业/研究方向',
  `within_beijing` varchar(11) DEFAULT NULL COMMENT '1:京内 0:京外',
  `xingzhengzhiwu` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `group_id` (`group_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `expert_user_ibfk_1` FOREIGN KEY (`group_id`) REFERENCES `group_tree` (`id`),
  CONSTRAINT `expert_user_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `acct_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='专家_成员表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expert_user`
--

LOCK TABLES `expert_user` WRITE;
/*!40000 ALTER TABLE `expert_user` DISABLE KEYS */;
INSERT INTO `expert_user` VALUES (10,37,2,1,'男','汉','1967','北京','工程师','开发','是','专家'),(11,34,3,1,'男','汉','1987','北京市朝阳区北苑路','java工程师','工程师','是','专家1'),(12,35,3,2,'女','汉','196','北京','工程师','工程','是','专家'),(14,38,2,2,'男','汉','1966','北京','','','','');
/*!40000 ALTER TABLE `expert_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group_tree`
--

DROP TABLE IF EXISTS `group_tree`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `group_tree` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '分组名称',
  `pId` varchar(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_tree`
--

LOCK TABLES `group_tree` WRITE;
/*!40000 ALTER TABLE `group_tree` DISABLE KEYS */;
INSERT INTO `group_tree` VALUES (1,'汇总','0'),(2,'专家组2','1'),(3,'专家组3','1'),(6,'专家组4','1'),(8,'专家组5','1'),(9,'专家组6','1');
/*!40000 ALTER TABLE `group_tree` ENABLE KEYS */;
UNLOCK TABLES;

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
  `sex` varchar(20) DEFAULT NULL COMMENT '性别',
  `minzu` varchar(35) DEFAULT NULL COMMENT '民族',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `title` varchar(255) DEFAULT NULL COMMENT '技术职称',
  `document_type` varchar(255) DEFAULT NULL COMMENT '证件类型',
  `document_number` varchar(255) DEFAULT NULL COMMENT '证件号码',
  `direction` varchar(255) DEFAULT NULL COMMENT '研究方向',
  `declaration_area` varchar(255) DEFAULT NULL COMMENT '申报领域',
  `telephone` varchar(20) DEFAULT NULL COMMENT '电话',
  `fax` varchar(20) DEFAULT NULL COMMENT '传真',
  `mobile_phone` varchar(20) DEFAULT NULL COMMENT '手机号',
  `email` varchar(20) DEFAULT NULL COMMENT '邮箱',
  `zip_code` varchar(20) DEFAULT NULL COMMENT '邮编',
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
  `postcode` varchar(20) DEFAULT NULL COMMENT '单位邮编',
  `unit_contact` varchar(255) DEFAULT NULL COMMENT '单位联系人',
  `work_telephone` varchar(20) DEFAULT NULL COMMENT '单位电话',
  `work_fax` varchar(20) DEFAULT NULL COMMENT '单位邮编',
  PRIMARY KEY (`user_id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jcqn_doc01`
--

LOCK TABLES `jcqn_doc01` WRITE;
/*!40000 ALTER TABLE `jcqn_doc01` DISABLE KEYS */;
INSERT INTO `jcqn_doc01` VALUES (2,31,'蒋磊','','汉','1993-11-08','工程师','身份证','3714231993','计算机','3612200','3612200','18366132576','18366132576@163.com','10000','北京','律典科技',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'156120','蒋磊','中国','天畅园','1000','蒋磊','3612205','25623155','31'),(3,32,'冯永刚','','汉','1993-11-03','工程师','身份证','3546121665131','计算机','23323144','124531324','18366132455','564@163.com','56444','北京','世界玖玖',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'754456465','冯永刚','中国','北京','44444','1121','w','ww','32'),(4,33,'蒋磊','','','1995-11-22','','','','','','','','','','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'','','','','','','','','33');
/*!40000 ALTER TABLE `jcqn_doc01` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `jcqn_doc02`
--

LOCK TABLES `jcqn_doc02` WRITE;
/*!40000 ALTER TABLE `jcqn_doc02` DISABLE KEYS */;
/*!40000 ALTER TABLE `jcqn_doc02` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jcqn_doc02_01`
--

DROP TABLE IF EXISTS `jcqn_doc02_01`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jcqn_doc02_01`
--

LOCK TABLES `jcqn_doc02_01` WRITE;
/*!40000 ALTER TABLE `jcqn_doc02_01` DISABLE KEYS */;
INSERT INTO `jcqn_doc02_01` VALUES (1,27,31,'设计家','1001','25000000','2015.09-2017.11','居然之家','开发'),(2,28,32,'2','2','2','2','2','2');
/*!40000 ALTER TABLE `jcqn_doc02_01` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jcqn_doc02_02`
--

DROP TABLE IF EXISTS `jcqn_doc02_02`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jcqn_doc02_02`
--

LOCK TABLES `jcqn_doc02_02` WRITE;
/*!40000 ALTER TABLE `jcqn_doc02_02` DISABLE KEYS */;
INSERT INTO `jcqn_doc02_02` VALUES (1,17,31,'创新技术','科学技术奖','国家级','第一','2016.11.01','中科院'),(2,18,32,'2','2','国家级','第二','2016.11.28','2');
/*!40000 ALTER TABLE `jcqn_doc02_02` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jcqn_doc02_03`
--

DROP TABLE IF EXISTS `jcqn_doc02_03`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jcqn_doc02_03`
--

LOCK TABLES `jcqn_doc02_03` WRITE;
/*!40000 ALTER TABLE `jcqn_doc02_03` DISABLE KEYS */;
INSERT INTO `jcqn_doc02_03` VALUES (1,11,31,'创新性人才的培养','第一作者','中国杂志','11','无','无'),(2,12,32,'2','第二作者(通讯作者)','2','2','2','2');
/*!40000 ALTER TABLE `jcqn_doc02_03` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jcqn_doc02_04`
--

DROP TABLE IF EXISTS `jcqn_doc02_04`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jcqn_doc02_04`
--

LOCK TABLES `jcqn_doc02_04` WRITE;
/*!40000 ALTER TABLE `jcqn_doc02_04` DISABLE KEYS */;
INSERT INTO `jcqn_doc02_04` VALUES (1,1,31,'人才遴选技术','10502','科技','第一发明人','2015.11.25','中国'),(2,2,32,'2','2','2','2','2016.11.29','2');
/*!40000 ALTER TABLE `jcqn_doc02_04` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jcqn_doc02_05`
--

DROP TABLE IF EXISTS `jcqn_doc02_05`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jcqn_doc02_05`
--

LOCK TABLES `jcqn_doc02_05` WRITE;
/*!40000 ALTER TABLE `jcqn_doc02_05` DISABLE KEYS */;
INSERT INTO `jcqn_doc02_05` VALUES (1,1,31,'技术论','一号会议','地科院','2016.11.15','北京','技术类'),(2,2,32,'2','2','2','2016.11.30','2','2');
/*!40000 ALTER TABLE `jcqn_doc02_05` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jcqn_doc02_06`
--

DROP TABLE IF EXISTS `jcqn_doc02_06`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jcqn_doc02_06`
--

LOCK TABLES `jcqn_doc02_06` WRITE;
/*!40000 ALTER TABLE `jcqn_doc02_06` DISABLE KEYS */;
INSERT INTO `jcqn_doc02_06` VALUES (1,2,31,'论信息技术的重要性','中国出版社','中国','2016'),(2,3,32,'2','2','2','2');
/*!40000 ALTER TABLE `jcqn_doc02_06` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jcqn_doc03`
--

LOCK TABLES `jcqn_doc03` WRITE;
/*!40000 ALTER TABLE `jcqn_doc03` DISABLE KEYS */;
INSERT INTO `jcqn_doc03` VALUES (8,31,'我热爱祖国，热爱党，技术过硬，态度良好'),(10,32,'推荐人自我评价'),(9,33,'自我感觉良好');
/*!40000 ALTER TABLE `jcqn_doc03` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jcqn_doc04`
--

LOCK TABLES `jcqn_doc04` WRITE;
/*!40000 ALTER TABLE `jcqn_doc04` DISABLE KEYS */;
INSERT INTO `jcqn_doc04` VALUES (4,31,'未来是美好的，是光明的，是值得期待的，是需要我们共同创建的'),(5,32,'未来研究计划及当前研究基础');
/*!40000 ALTER TABLE `jcqn_doc04` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jcqn_doc05`
--

LOCK TABLES `jcqn_doc05` WRITE;
/*!40000 ALTER TABLE `jcqn_doc05` DISABLE KEYS */;
INSERT INTO `jcqn_doc05` VALUES (4,31,'积极思考，加强自身技术，好好工作，努力学习'),(5,32,'工作单位发展需求与推荐人选的相关性及工作单位提供的支持保障措施');
/*!40000 ALTER TABLE `jcqn_doc05` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `jcqn_doc06`
--

LOCK TABLES `jcqn_doc06` WRITE;
/*!40000 ALTER TABLE `jcqn_doc06` DISABLE KEYS */;
/*!40000 ALTER TABLE `jcqn_doc06` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kjlj_doc01`
--

DROP TABLE IF EXISTS `kjlj_doc01`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kjlj_doc01`
--

LOCK TABLES `kjlj_doc01` WRITE;
/*!40000 ALTER TABLE `kjlj_doc01` DISABLE KEYS */;
/*!40000 ALTER TABLE `kjlj_doc01` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kjlj_doc02`
--

DROP TABLE IF EXISTS `kjlj_doc02`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kjlj_doc02`
--

LOCK TABLES `kjlj_doc02` WRITE;
/*!40000 ALTER TABLE `kjlj_doc02` DISABLE KEYS */;
/*!40000 ALTER TABLE `kjlj_doc02` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kjlj_doc02_01`
--

DROP TABLE IF EXISTS `kjlj_doc02_01`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kjlj_doc02_01`
--

LOCK TABLES `kjlj_doc02_01` WRITE;
/*!40000 ALTER TABLE `kjlj_doc02_01` DISABLE KEYS */;
/*!40000 ALTER TABLE `kjlj_doc02_01` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kjlj_doc02_02`
--

DROP TABLE IF EXISTS `kjlj_doc02_02`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kjlj_doc02_02`
--

LOCK TABLES `kjlj_doc02_02` WRITE;
/*!40000 ALTER TABLE `kjlj_doc02_02` DISABLE KEYS */;
/*!40000 ALTER TABLE `kjlj_doc02_02` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kjlj_doc02_03`
--

DROP TABLE IF EXISTS `kjlj_doc02_03`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kjlj_doc02_03`
--

LOCK TABLES `kjlj_doc02_03` WRITE;
/*!40000 ALTER TABLE `kjlj_doc02_03` DISABLE KEYS */;
/*!40000 ALTER TABLE `kjlj_doc02_03` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kjlj_doc02_04`
--

DROP TABLE IF EXISTS `kjlj_doc02_04`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kjlj_doc02_04`
--

LOCK TABLES `kjlj_doc02_04` WRITE;
/*!40000 ALTER TABLE `kjlj_doc02_04` DISABLE KEYS */;
/*!40000 ALTER TABLE `kjlj_doc02_04` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kjlj_doc02_05`
--

DROP TABLE IF EXISTS `kjlj_doc02_05`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kjlj_doc02_05`
--

LOCK TABLES `kjlj_doc02_05` WRITE;
/*!40000 ALTER TABLE `kjlj_doc02_05` DISABLE KEYS */;
/*!40000 ALTER TABLE `kjlj_doc02_05` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kjlj_doc02_06`
--

DROP TABLE IF EXISTS `kjlj_doc02_06`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kjlj_doc02_06` (
  `xuhao_id` int(11) DEFAULT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `treatise_name` varchar(255) DEFAULT NULL COMMENT '专著名称',
  `press` varchar(255) DEFAULT NULL COMMENT '出版社',
  `issuing_country` varchar(255) DEFAULT NULL COMMENT '发行国家和地区',
  `year` varchar(255) DEFAULT NULL COMMENT '年份',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kjlj_doc02_06`
--

LOCK TABLES `kjlj_doc02_06` WRITE;
/*!40000 ALTER TABLE `kjlj_doc02_06` DISABLE KEYS */;
/*!40000 ALTER TABLE `kjlj_doc02_06` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kjlj_doc03`
--

DROP TABLE IF EXISTS `kjlj_doc03`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kjlj_doc03` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `selfAssessment` mediumtext COMMENT '自我评价',
  PRIMARY KEY (`user_id`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kjlj_doc03`
--

LOCK TABLES `kjlj_doc03` WRITE;
/*!40000 ALTER TABLE `kjlj_doc03` DISABLE KEYS */;
/*!40000 ALTER TABLE `kjlj_doc03` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kjlj_doc04`
--

DROP TABLE IF EXISTS `kjlj_doc04`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kjlj_doc04` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `futurePlans` mediumtext COMMENT '未来计划及当前研究基础',
  PRIMARY KEY (`user_id`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kjlj_doc04`
--

LOCK TABLES `kjlj_doc04` WRITE;
/*!40000 ALTER TABLE `kjlj_doc04` DISABLE KEYS */;
/*!40000 ALTER TABLE `kjlj_doc04` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kjlj_doc05`
--

DROP TABLE IF EXISTS `kjlj_doc05`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kjlj_doc05` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `needsRelevanceSupport` mediumtext COMMENT '工作单位发展需求与推荐人选的相关性及工作单位提供的支持保障措施',
  PRIMARY KEY (`user_id`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kjlj_doc05`
--

LOCK TABLES `kjlj_doc05` WRITE;
/*!40000 ALTER TABLE `kjlj_doc05` DISABLE KEYS */;
/*!40000 ALTER TABLE `kjlj_doc05` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kjlj_doc06`
--

DROP TABLE IF EXISTS `kjlj_doc06`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kjlj_doc06` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `work_unit_opinion` mediumtext COMMENT '工作单位意见',
  `recommended_unit_opinion` mediumtext COMMENT '推荐单位意见',
  PRIMARY KEY (`user_id`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kjlj_doc06`
--

LOCK TABLES `kjlj_doc06` WRITE;
/*!40000 ALTER TABLE `kjlj_doc06` DISABLE KEYS */;
/*!40000 ALTER TABLE `kjlj_doc06` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `mark_detail`
--

LOCK TABLES `mark_detail` WRITE;
/*!40000 ALTER TABLE `mark_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `mark_detail` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `mark_infor`
--

LOCK TABLES `mark_infor` WRITE;
/*!40000 ALTER TABLE `mark_infor` DISABLE KEYS */;
/*!40000 ALTER TABLE `mark_infor` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `news`
--

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` VALUES ('0',6,'“中国地质科学院自然科学系列职称申报系统”试运行通知','蒋磊','2016-08-24 17:11:15','中国地质科学院自然科学系列职称申报系统现已上线试运行，请大家完善自己个人信息，需要职称申报的请在规定时间完成职称申报工作！','top','-1'),('0',7,'中国地质调查局业务中心建设与管理暂行办法','蒋磊','2016-08-24 17:10:48','第一章　总　则\n    第一条   根据《中国地质调查局中长期发展规划纲要（2011～2025年）》，为了推进地质调查业务发展，规范和加强中国地质调查局业务中心（以下简称“业务中心”）的建设和管理，制定本办法。\n    第二条   业务中心是在地质调查工作重大业务领域从事调查研究的非法人学术性组织，通过凝聚国内外一流科学家，瞄准重大地质科技问题和国际地学前沿，围绕国家需求和地质调查业务发展需求，开展综合研究、信息服务、国际合作、人才培养和学术交流，引领本业务领域的学科发展，使其成为国际上有重要影响的专业研究中心。\n    第三条   业务中心的主管部门是中国地质调查局（以下简称“地调局”）。地调局根据地质调查工作需要，结合局属单位的总体定位、业务优势和区位优势，对业务中心进行合理布局和建设。\n第二章　基本条件\n    第四条   业务中心的发展方向必须是地调局中长期发展规划确定的重点业务领域。\n    第五条   业务中心原则上依托局属单位建设。依托单位必须具备良好的工作基础和运行条件，具有引领本领域发展的实力或潜力。近五年内，同时在该领域具备以下条件：\n    1.   承担过地质调查计划项目；\n    2.   承担过国家级、省部级重大科技项目；\n    3.   以第一完成单位获得过省部级以上奖励；\n    4.   公开出版或完成过有重大影响的专著、成果报告，在核心期刊发表论文15篇以上；\n    第六条   依托单位拥有3名以上有影响力的专家，包括地调局青年英才计划、国土资源部百人计划等人选，地学领域学术性个人荣誉奖的获得者以及国外重要奖项获得者等；\n    第七条   依托单位拥有相对稳定,且有影响的核心业务团队，在职固定科研人员在10人以上，60%为研究生以上学历。\n第三章　职责\n    第八条   业务中心实行地调局和依托单位分级管理。地调局科技外事部会同相关部室统筹全局业务中心建设，相关部室按业务分工负责指导各领域业务中心的建设。\n    第九条   地调局的主要职责是：\n    1．组织专家对业务中心建设进行论证；批准业务中心主任、秘书长和学术委员会委员组成；\n    2．开展业务中心考核与评估工作；\n    3．指导各业务中心发展规划的编制；\n    4．在项目、人才、条件建设和国际合作交流等方面给予支持。\n    第十条   依托单位的主要职责是：\n    1．提出业务中心建设方案，推荐业务中心主任、秘书长和学术委员会委员人选。\n    2．配合主管部门对业务中心进行考核、评估等工作。\n    3．提出业务中心研究方向、任务、目标等方面的重大调整意见和建议。\n    4．为业务中心吸引人才和培养人才提供激励政策。\n    5．负责业务中心的日常管理。\n    第十一条   业务中心的主要职责是：\n    1．跟踪研究国内外本领域的研究动态，开展战略研究，提出本业务领域的发展规划和建议；\n    2．针对地质调查相关业务领域重大问题，开展信息和咨询服务； \n    3．组织专家对地质调查中区域性、专业性的重大科学问题进行综合研究和联合攻关；\n    4．为申报国家科技计划和地质调查计划提出建议；\n    5．组织开展学术交流、业务培训和国际合作，推广成熟地质理论和地质技术方法，培养优秀地质调查专业人才；\n    6．承办相关领域的学术期刊或杂志等。\n第四章　组织机构\n    第十二条   业务中心设立主任、秘书处和学术委员会：\n    1．主任由依托单位的主要领导担任，负责业务中心的管理。\n    2．秘书处主要负责业务中心的日常工作，组织落实业务中心各项任务目标。秘书长一般由依托单位的专业研究室（中心）的主任担任，在业务领域具有较高学术造诣，且具有较强的组织协调能力。\n    3．学术委员会由国内外本领域的知名专家、学者组成，总人数13～17人。其中，依托单位的学术委员不超过总人数的三分之一，学术委员会任期5年。学术委员会主要负责审议业务中心建设发展的目标、任务和研究方向，审议业务中心的重大学术活动、年度工作、重要议案和研究成果等。\n第五章　运行与管理\n    第十三条   局属单位向地调局提交业务中心建设申请报告。地调局组织专家对业务中心建设申请报告进行评审。\n    第十四条   通过申请报告评审后，依托单位编制业务中心建设实施方案，地调局组织专家对该实施方案进行论证。\n    第十五条   实施方案通过地调局论证和批准后，业务中心正式挂牌成立，依托单位启动业务中心建设工作。\n    第十六条   业务中心成立后的日常工作包括：\n    1．每年向地调局提交年度工作报告和经学术委员审定后的本领域的研究进展报告；\n    2．每年至少组织召开一次学术活动；\n    3．建立健全内部管理运行规章制度；\n    4．有条件的应承办相关领域的期刊杂志；\n    5．对业务中心完成的专著、论文、软件、数据库等研究成果均加注业务中心名称。\n    第十七条   业务中心实行定期考核和评估制度。每二年考核一次，考核组由地调局聘请的7～9名专家组成，实行专家回避制度。考核结果作为业务中心下一阶段运行与发展调整的重要依据，并与支持力度挂钩。 \n    第十八条   根据国家对地质调查工作的需要和业务中心运行情况，地调局可调整业务中心的布局与建设，对业务中心进行重组、整合、撤消等。\n    第十九条   业务中心需要更名、变更研究方向，须经业务中心学术委员会同意，依托单位提出书面申请，经地调局组织专家论证和批准后执行。\n第六章　附 则\n    第二十条   本办法由地调局负责解释。\n    第二十一条   本办法自发布之日起执行。\n','top','-1'),('0',8,'地质力学研究所赴吉尔吉斯斯坦开展野外地质调查','蒋磊','2016-08-24 17:10:16','   2014年8月20日，地质力学研究所《中吉天山成矿带构造背景对比研究》项目组赴吉尔吉斯斯坦开展野外地质调查。\n    20日下午，项目组一行六人抵达比什凯克后，即与吉尔吉斯政府矿产资源管理局、吉尔吉斯地球物理考察队举行了座谈。地质力学所侯春堂副所长首先感谢矿产资源管理局吉拉列夫 杜什别克局长（Duishenbek Zilaliev）对合作的高度重视和支持；并简要介绍了地质力学所基本情况、项目组成员和本次野外地质调查任务，表达了进一步扩大合作的意向。项目负责人王宗秀研究员和哈里洛夫所长介绍了项目进展，取得的成果。吉拉列夫局长诚挚欢迎项目组，表示这是就任局长以来第一次会见国外项目组，指出吉尔吉斯矿产资源丰富，与中国睦邻关系友好，习近平主席与阿坦巴耶夫总统共同提议建立的中-吉战略合作伙伴关系将为两国在地学研究和矿产资源领域的合作注入强大的生命力。他高度评价了地质力学研究所与吉尔吉斯地球物理考察队5年来合作取得的丰硕成果，表示将支持进一步合作。\n    座谈中，吉拉列夫局长还高兴地谈到，已经接受国土资源部邀请，今年十月将到访北京。侯春堂副所长邀请吉拉列夫局长届时到地质力学研究所参观访问，吉拉列夫局长愉快地接受邀请，并表示将以此为契机，把中-吉在地学领域的合作推向更高的发展阶段。\n    会后，项目组与吉尔吉斯地球物理考察队哈里洛夫所长等讨论细化本年度野外地质调查方案，初步探讨了下一步合作研究相关事项。\n\n','top','-1'),('0',9,'“祁连山冻土区天然气水合物控矿因素研究”取得阶段性成果','蒋磊','2016-08-24 17:09:48',' 由地质力学研究所承担的“祁连山冻土区天然气水合物控矿因素综合研究”项目通过对祁连山冻土区新构造、冻土及冰川的调查与研究取得了阶段性成果，并在新生代地层、天然气水合物、烃源岩样品分析等方面获得了新认识。\n    通过对钻获天然气水合物的DK-9孔进行地温参数测量，获得了天然气水合物成藏的冻土厚度、地温梯度等参数。DK-9孔冻土厚度略大于110m，冻土层下地温梯度为2.4?C/100m。数据显示近地表冻土活动层内温度随时间波动变化明显，活动层之下的温度经过平衡后均趋于稳定，深度越大，钻孔内温度与围岩温度平衡稳定需要的时间越短。同时，通过对位于DK-9孔北侧约500m处的DK-10孔连续两个多月的监测分析出了天然气水合物温度、压力变化曲线。\n    通过对南祁连盆地晚古生代-中生代烃源岩的调查与评价，优选出了有利的气源岩层位。羊虎沟组灰岩和煤为差等气源岩，泥岩为中等-好的烃源岩，主生气辅生油；草地沟组泥岩为中等-好的生油岩；大加连组灰岩生油生气潜力差；尕勒得寺组泥岩为中等-好生油岩、好的气源岩，煤为差等气源岩；窑街组泥岩为好的烃源岩，主生油辅生气，煤为差-中等气源岩。其中羊虎沟组泥岩、草地沟组泥岩、尕勒得寺组泥岩、窑街组泥岩和煤为祁连山冻土区天然气水合物的5套主力烃源岩。\n    重建了祁连山地区新生代隆升过程与第四纪环境演化过程。新生代地层ESR年代学研究表明，火烧沟组、白杨河组、疏勒河组和玉门组年龄分别为?40.2~35.3Ma、32.6~24.3Ma、22.7~13.2Ma和3.4~3.0Ma。岩性和岩相变化及构造关系表明，始新世末-渐新世初（35.3~32.6 Ma）祁连山发生了强烈变形和隆升，并导致了火烧沟组顶部代表的晚始新世高原最早期夷平面的解体。中新世中期（15.0~9.0 Ma）阿尔金断裂带与海原断裂带的左旋走滑作用在祁连山北部形成北西向盆-岭构造，祁连山南部地壳块体向东逆冲和顺时针旋转，形成北北东向逆冲断裂和北西向右旋走滑断裂带。自5.4 Ma起祁连山脉逐步隆起，并3.4Ma开始急剧整体快速隆升，玉门砾岩不整合覆盖于夷平面之上。经过2.4~1.4 Ma和0.3~0.15 Ma的多阶段快速隆升，于中更新世早期进入冰冻圈，并奠定了今日环境格局。\n    祁连山天然气水合物控矿因素综合研究表明，天然气水合物与多年冻土、阿尔金断裂带与海原断裂带左旋走滑右阶岩桥区挤压推覆构造带及晚古生代-中生代烃源岩密切相关，天然气水合物形成于倒数第三冰期，并在中更新世中期发生过分解。盆山边界冲断带成为气体运移和天然气水合物成藏的有利地区。\n\n（地质力学研究所七室供稿）','top',''),('0',10,'新建项目成功分析','蒋磊','2016-08-24 17:14:37','&nbsp; &nbsp; &nbsp; &nbsp; 项目开始阶段比较困难，但是随着时间慢慢加长，对项目结构及框架的认识，慢慢的熟悉了流程，开发起来更加顺手，能够更加快速的进入开发阶段。<div>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;所以说，世上无难事只怕有心人</div>','top','');
/*!40000 ALTER TABLE `news` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `team_baseinfor`
--

LOCK TABLES `team_baseinfor` WRITE;
/*!40000 ALTER TABLE `team_baseinfor` DISABLE KEYS */;
/*!40000 ALTER TABLE `team_baseinfor` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `team_user`
--

LOCK TABLES `team_user` WRITE;
/*!40000 ALTER TABLE `team_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `team_user` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `user_attachfile`
--

LOCK TABLES `user_attachfile` WRITE;
/*!40000 ALTER TABLE `user_attachfile` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_attachfile` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户_科研学术奖励表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_award`
--

LOCK TABLES `user_award` WRITE;
/*!40000 ALTER TABLE `user_award` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_award` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户_基本信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_baseinfor`
--

LOCK TABLES `user_baseinfor` WRITE;
/*!40000 ALTER TABLE `user_baseinfor` DISABLE KEYS */;
INSERT INTO `user_baseinfor` VALUES (22,28,NULL,'男','',NULL,NULL,NULL,'','','',NULL,'','','','','','',NULL,'','','',NULL,'',NULL,'','','',''),(23,29,NULL,'男',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(24,30,NULL,'男',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(25,31,NULL,'男','',NULL,NULL,NULL,'','','',NULL,'','','','','','',NULL,'','','',NULL,'',NULL,'','','',''),(26,32,NULL,'男','',NULL,NULL,NULL,'','','',NULL,'','','','','','',NULL,'','','',NULL,'',NULL,'','','',''),(27,33,NULL,'男','',NULL,NULL,NULL,'','','',NULL,'','','','','','',NULL,'','','',NULL,'',NULL,'','','',''),(29,37,NULL,'男',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(30,38,NULL,'男',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `user_baseinfor` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户_附加信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_business`
--

LOCK TABLES `user_business` WRITE;
/*!40000 ALTER TABLE `user_business` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_business` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_exam`
--

LOCK TABLES `user_exam` WRITE;
/*!40000 ALTER TABLE `user_exam` DISABLE KEYS */;
INSERT INTO `user_exam` VALUES (8,31,'英语','2014-10-29','英语六级','540','山东交通学院'),(9,32,'2','2016-11-28','2','2','2');
/*!40000 ALTER TABLE `user_exam` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户_代表性论文表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_paper`
--

LOCK TABLES `user_paper` WRITE;
/*!40000 ALTER TABLE `user_paper` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_paper` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COMMENT='用户_学习经历表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_peixun`
--

LOCK TABLES `user_peixun` WRITE;
/*!40000 ALTER TABLE `user_peixun` DISABLE KEYS */;
INSERT INTO `user_peixun` VALUES (23,31,'2012-11-15','2016-11-16','计算机技术与科学','中国','1','4年','山东交通学院','本科','蒋磊'),(24,32,'2016-12-05','2016-12-31','1','1','0','1年','1','中专/高中','1'),(25,32,'2016-11-29','2016-12-30','qwq','qwq','1','1年','wq','中专/高中','wq');
/*!40000 ALTER TABLE `user_peixun` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户_科研任务表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_project`
--

LOCK TABLES `user_project` WRITE;
/*!40000 ALTER TABLE `user_project` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_report`
--

DROP TABLE IF EXISTS `user_report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户_学术会议报告表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_report`
--

LOCK TABLES `user_report` WRITE;
/*!40000 ALTER TABLE `user_report` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_report` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_skill`
--

LOCK TABLES `user_skill` WRITE;
/*!40000 ALTER TABLE `user_skill` DISABLE KEYS */;
INSERT INTO `user_skill` VALUES (16,31,'2015-11-27','设计家项目设计与开发','软件开发','设计家项目正式上线','2016-11-16'),(17,32,'2016-12-05','2','2','2','2017-01-07');
/*!40000 ALTER TABLE `user_skill` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_team`
--

LOCK TABLES `user_team` WRITE;
/*!40000 ALTER TABLE `user_team` DISABLE KEYS */;
INSERT INTO `user_team` VALUES (4,32);
/*!40000 ALTER TABLE `user_team` ENABLE KEYS */;
UNLOCK TABLES;

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
  `work_content` varchar(255) DEFAULT NULL COMMENT '单位',
  `country` varchar(255) DEFAULT NULL COMMENT '国家',
  `zhiwu` varchar(255) DEFAULT NULL COMMENT '职务',
  `toNow` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `fk_user_work` FOREIGN KEY (`user_id`) REFERENCES `acct_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 COMMENT='用户_工作经历表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_work`
--

LOCK TABLES `user_work` WRITE;
/*!40000 ALTER TABLE `user_work` DISABLE KEYS */;
INSERT INTO `user_work` VALUES (40,31,'2015-11-18','2016-11-23','联想科技','中国','工程师','1'),(41,32,'2016-12-04','2017-01-06','1','1','1','0');
/*!40000 ALTER TABLE `user_work` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户_授权专利表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_zhuanli`
--

LOCK TABLES `user_zhuanli` WRITE;
/*!40000 ALTER TABLE `user_zhuanli` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_zhuanli` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户_专著情况表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_zhuanzhu`
--

LOCK TABLES `user_zhuanzhu` WRITE;
/*!40000 ALTER TABLE `user_zhuanzhu` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_zhuanzhu` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `user_zuzhi`
--

LOCK TABLES `user_zuzhi` WRITE;
/*!40000 ALTER TABLE `user_zuzhi` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_zuzhi` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-06 17:39:39