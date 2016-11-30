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
-- Dumping data for table `acct_authority`
--

LOCK TABLES `acct_authority` WRITE;
/*!40000 ALTER TABLE `acct_authority` DISABLE KEYS */;
INSERT INTO `acct_authority` VALUES (1,'LOGIN',''),(2,'ADMIN',''),(3,'USER',NULL),(4,'HR',NULL),(5,'PROFESSOR',NULL),(6,'EXPERT1',NULL),(7,'EXPERT2',NULL);
/*!40000 ALTER TABLE `acct_authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `acct_role`
--

LOCK TABLES `acct_role` WRITE;
/*!40000 ALTER TABLE `acct_role` DISABLE KEYS */;
INSERT INTO `acct_role` VALUES (1,'Admin'),(4,'初审专家'),(3,'初级管理员'),(5,'复审专家'),(2,'普通职工'),(6,'高级管理员');
/*!40000 ALTER TABLE `acct_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `acct_role_authority`
--

LOCK TABLES `acct_role_authority` WRITE;
/*!40000 ALTER TABLE `acct_role_authority` DISABLE KEYS */;
INSERT INTO `acct_role_authority` VALUES (1,1,1),(2,1,3),(3,3,4),(4,1,2),(7,4,6),(8,5,7),(10,4,1),(11,1,4),(12,5,1),(13,6,1),(17,1,5),(23,2,3),(24,2,1),(25,3,1),(31,6,5),(32,6,4);
/*!40000 ALTER TABLE `acct_role_authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `acct_user`
--

LOCK TABLES `acct_user` WRITE;
/*!40000 ALTER TABLE `acct_user` DISABLE KEYS */;
INSERT INTO `acct_user` VALUES (1,0,'jl@qq.com','tongdehui','蒋磊','96e79218965eb72c92a549dd5a330112',1,'12313244545','','','',NULL),(28,NULL,'13556588554@16.com','123','普通职工1','96e79218965eb72c92a549dd5a330112',1,'123',NULL,NULL,NULL,NULL),(29,NULL,'18366132576@163.com','1234','初级审核人员','96e79218965eb72c92a549dd5a330112',1,'1234',NULL,NULL,NULL,NULL),(30,NULL,'18366132455@163.com','123456','高级审核人员','96e79218965eb72c92a549dd5a330112',1,'123456',NULL,NULL,NULL,NULL),(31,NULL,'182255525@163.com','121','普通职工2','96e79218965eb72c92a549dd5a330112',2,'121','','','',NULL),(32,NULL,'151515674@163.com','122','普通职工3','96e79218965eb72c92a549dd5a330112',3,'122','','','',NULL),(33,NULL,'156751576@163.com','124','普通职工4','96e79218965eb72c92a549dd5a330112',1,'124',NULL,NULL,NULL,NULL),(34,NULL,'454165156@163.com','expert1','初审专家','96e79218965eb72c92a549dd5a330112',1,'1234567',NULL,NULL,NULL,NULL),(35,NULL,'45164654@163.com','expert2','复审专家','96e79218965eb72c92a549dd5a330112',1,'125255',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `acct_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `acct_user_role`
--

LOCK TABLES `acct_user_role` WRITE;
/*!40000 ALTER TABLE `acct_user_role` DISABLE KEYS */;
INSERT INTO `acct_user_role` VALUES (1,1,1),(61,28,2),(62,29,3),(63,30,6),(64,31,2),(65,32,2),(66,33,2),(67,34,4),(68,35,5);
/*!40000 ALTER TABLE `acct_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `apply`
--

LOCK TABLES `apply` WRITE;
/*!40000 ALTER TABLE `apply` DISABLE KEYS */;
INSERT INTO `apply` VALUES (1,31,1,'2016-11-23 23:00:46','杰出青年','待审核','','','','','','','','','','','','','',''),(46,33,2,'2016-11-30 18:11:07','杰出青年','待审核','','','','','','','','','','','','','',''),(55,34,1,'2016-11-30 19:50:08','杰出青年','待审核','','','','','','','','','','','','','','');
/*!40000 ALTER TABLE `apply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `apply_group`
--

LOCK TABLES `apply_group` WRITE;
/*!40000 ALTER TABLE `apply_group` DISABLE KEYS */;
INSERT INTO `apply_group` VALUES (1,1,1,1);
/*!40000 ALTER TABLE `apply_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `apply_menu`
--

LOCK TABLES `apply_menu` WRITE;
/*!40000 ALTER TABLE `apply_menu` DISABLE KEYS */;
INSERT INTO `apply_menu` VALUES (1,'jcqnDoc01','1. 基本信息','杰出青年'),(2,'jcqnDoc02','2.近五年科研情况','杰出青年'),(3,'jcqnDoc03','3.推荐人选自我评价','杰出青年'),(4,'jcqnDoc04','4.未来研究计划及当前研究基础','杰出青年'),(5,'jcqnDoc05','5. 工作单位发展需求与推荐人选的相关性及工作单位提供的支持保障措施','杰出青年'),(6,'jcqnDoc06','6.承诺与推荐意见','杰出青年'),(7,'jcqnDoc07','7. 专家评分','杰出青年'),(8,'kjljDoc01','1.基本信息','科技领军'),(9,'kjljDoc02','2.近五年科研情况','科技领军'),(10,'kjljDoc03','3.推荐人选自我评价','科技领军'),(11,'kjljDoc04','4.未来研究计划及当前研究基础','科技领军'),(12,'kjljDoc05','5. 工作单位发展需求与推荐人选的相关性及工作单位提供的支持保障措施','科技领军'),(13,'kjljDoc06','6.承诺与推荐意见','科技领军'),(14,'kjljDoc07','7. 专家评分','科技领军'),(15,'cxtdDoc01','1.基本信息','创新团队'),(16,'cxtdDoc02','2.近五年主要科研情况','创新团队'),(17,'ctxdDoc03','3.团队及负责人自我评价','创新团队'),(18,'cxtdDoc04','4.团队发展规划及基础情况','创新团队'),(19,'cxtdDoc05','5.工作单位发展需求与推荐团队的相关性及工作单位提供的支持保障措施','创新团队'),(20,'cxtdDoc06','6.承诺与推荐意见','创新团队'),(21,'cxtdDoc07','7. 专家打分','创新团队');
/*!40000 ALTER TABLE `apply_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `body`
--

LOCK TABLES `body` WRITE;
/*!40000 ALTER TABLE `body` DISABLE KEYS */;
INSERT INTO `body` VALUES (1,'汇总','0','010-00000000','010-00000000','事业单位','http://www.cgs.gov.cn/','待定','北京市西城区阜外大街45号院','webmaster@mail.cgs.gov.cn',NULL,NULL,NULL,NULL),(2,'专家组2','1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,'地调局天津中心','1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(5,'地调局南京中心','1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'地调局武汉中心','1',NULL,NULL,NULL,'http://www.yichang.cgs.gov.cn',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'地调局成都中心','1',NULL,NULL,NULL,'http://www.chengdu.cgs.gov.cn',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'地调局西安中心','1',NULL,NULL,NULL,'http://www.xian.cgs.gov.cn/',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(9,'地调局青岛海洋所','1',NULL,NULL,NULL,'http://www.qimg.cgs.gov.cn/',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(10,'地调局航遥中心','1',NULL,NULL,NULL,'http://www.agrs.cn/',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(11,'地调局广州海洋局','1',NULL,NULL,NULL,'http://www.gmgs.com.cn',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(12,'地调局水环中心','1',NULL,NULL,NULL,'http://www.chegs.cn',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(13,'地调局油气调查中心','1',NULL,NULL,NULL,'http://www.ogs-cgs.cn',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(14,'地调局发展中心','1',NULL,NULL,NULL,'http://www.drc.cgs.gov.cn',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(15,'地调局实物资料中心','1',NULL,NULL,NULL,'http://swzx.org.cn/',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(16,'地调局环境监测院','1',NULL,NULL,NULL,'http://www.cigem.info/',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(17,'地调局图书馆','1',NULL,NULL,NULL,'http://library.cgs.gov.cn',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(18,'地科院院机关','1',NULL,NULL,NULL,'http://www.cags.ac.cn',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(19,'地科院地质所','1',NULL,NULL,NULL,'http://igeo.cags.ac.cn/',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(20,'地科院资源所','1',NULL,NULL,NULL,'http://imr.cags.ac.cn/',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(21,'地科院力学所','1',NULL,NULL,NULL,'http://www.geomech.ac.cn/',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(22,'地科院测试中心','1',NULL,NULL,NULL,'http://nrcga.cags.ac.cn/',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(23,'地科院水环所','1',NULL,NULL,NULL,'http://www.iheg.org.cn',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(24,'地科院物化探所','1',NULL,NULL,NULL,'http://igge.cags.ac.cn/',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(25,'地科院岩溶所','1',NULL,NULL,NULL,'http://www.karst.ac.cn/',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(26,'地调局成都综合所','1',NULL,NULL,NULL,'http://www.imumr.cn',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(27,'地调局郑州综合所','1',NULL,NULL,NULL,'http://www.imu.ac.cn/',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(28,'地调局勘探所','1',NULL,NULL,NULL,'http://www.cniet.com',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(29,'地调局成都工艺所','1',NULL,NULL,NULL,'http://www.cgiet.com/',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(30,'地调局北京探工所','1',NULL,NULL,NULL,'http://www.bjiee.com.cn/',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `body` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `calendar`
--

LOCK TABLES `calendar` WRITE;
/*!40000 ALTER TABLE `calendar` DISABLE KEYS */;
INSERT INTO `calendar` VALUES (1,'2010-01-01','2016-12-31','根据打分表，独立打出分数，并提出合理意见。打分过程一定要按照公平公正的原则，合理打分。严禁一切形式的徇私舞弊，违者直接取消申报资格。<div><br></div><div>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 谢谢</div>');
/*!40000 ALTER TABLE `calendar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `cxtd_base_info`
--

LOCK TABLES `cxtd_base_info` WRITE;
/*!40000 ALTER TABLE `cxtd_base_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `cxtd_base_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `cxtd_leader_info`
--

LOCK TABLES `cxtd_leader_info` WRITE;
/*!40000 ALTER TABLE `cxtd_leader_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `cxtd_leader_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `cxtd_leader_zuzhi`
--

LOCK TABLES `cxtd_leader_zuzhi` WRITE;
/*!40000 ALTER TABLE `cxtd_leader_zuzhi` DISABLE KEYS */;
/*!40000 ALTER TABLE `cxtd_leader_zuzhi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `cxtd_member_info`
--

LOCK TABLES `cxtd_member_info` WRITE;
/*!40000 ALTER TABLE `cxtd_member_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `cxtd_member_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `cxtd_member_num`
--

LOCK TABLES `cxtd_member_num` WRITE;
/*!40000 ALTER TABLE `cxtd_member_num` DISABLE KEYS */;
/*!40000 ALTER TABLE `cxtd_member_num` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `expert_score`
--

LOCK TABLES `expert_score` WRITE;
/*!40000 ALTER TABLE `expert_score` DISABLE KEYS */;
INSERT INTO `expert_score` VALUES (1,34,31,'100','很好，很不错',32),(2,39,31,'59','申报材料不足，申报人选不达标',32),(3,34,31,'100','很好，很不错',1),(4,34,33,'100','很好',46);
/*!40000 ALTER TABLE `expert_score` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `expert_user`
--

LOCK TABLES `expert_user` WRITE;
/*!40000 ALTER TABLE `expert_user` DISABLE KEYS */;
INSERT INTO `expert_user` VALUES (2,34,2,2,'男','汉','2016-11-27','111','111','111',1),(3,35,1,3,'男','汉','2016-11-22','111','111','111',0);
/*!40000 ALTER TABLE `expert_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `group_tree`
--

LOCK TABLES `group_tree` WRITE;
/*!40000 ALTER TABLE `group_tree` DISABLE KEYS */;
INSERT INTO `group_tree` VALUES (1,'汇总','0'),(2,'专家组2','1'),(3,'专家组3','1'),(6,'专家组4','1'),(8,'专家组5','1'),(9,'专家组6','1');
/*!40000 ALTER TABLE `group_tree` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `jcqn_doc01`
--

LOCK TABLES `jcqn_doc01` WRITE;
/*!40000 ALTER TABLE `jcqn_doc01` DISABLE KEYS */;
INSERT INTO `jcqn_doc01` VALUES (2,31,'蒋磊','','汉','1993-11-08','工程师','身份证','3714231993','计算机','3612200','3612200','18366132576','18366132576@163.com','10000','北京','律典科技',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'156120','蒋磊','中国','天畅园','1000','蒋磊','3612205','25623155','31'),(3,32,'冯永刚','','汉','1993-11-03','工程师','身份证','3546121665131','计算机','23323144','124531324','18366132455','564@163.com','56444','北京','世界玖玖',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'754456465','冯永刚','中国','北京','44444','','','','32'),(4,33,'蒋磊','','','1995-11-22','','','','','','','','','','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'','','','','','','','','33');
/*!40000 ALTER TABLE `jcqn_doc01` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `jcqn_doc02`
--

LOCK TABLES `jcqn_doc02` WRITE;
/*!40000 ALTER TABLE `jcqn_doc02` DISABLE KEYS */;
/*!40000 ALTER TABLE `jcqn_doc02` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `jcqn_doc02_01`
--

LOCK TABLES `jcqn_doc02_01` WRITE;
/*!40000 ALTER TABLE `jcqn_doc02_01` DISABLE KEYS */;
INSERT INTO `jcqn_doc02_01` VALUES (1,27,31,'设计家','1001','25000000','2015.09-2017.11','居然之家','开发');
/*!40000 ALTER TABLE `jcqn_doc02_01` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `jcqn_doc02_02`
--

LOCK TABLES `jcqn_doc02_02` WRITE;
/*!40000 ALTER TABLE `jcqn_doc02_02` DISABLE KEYS */;
INSERT INTO `jcqn_doc02_02` VALUES (1,17,31,'创新技术','科学技术奖','国家级','第一','2016.11.01','中科院');
/*!40000 ALTER TABLE `jcqn_doc02_02` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `jcqn_doc02_03`
--

LOCK TABLES `jcqn_doc02_03` WRITE;
/*!40000 ALTER TABLE `jcqn_doc02_03` DISABLE KEYS */;
INSERT INTO `jcqn_doc02_03` VALUES (1,11,31,'创新性人才的培养','第一作者','中国杂志','11','无','无');
/*!40000 ALTER TABLE `jcqn_doc02_03` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `jcqn_doc02_04`
--

LOCK TABLES `jcqn_doc02_04` WRITE;
/*!40000 ALTER TABLE `jcqn_doc02_04` DISABLE KEYS */;
INSERT INTO `jcqn_doc02_04` VALUES (1,1,31,'人才遴选技术','10502','科技','第一发明人','2015.11.25','中国');
/*!40000 ALTER TABLE `jcqn_doc02_04` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `jcqn_doc02_05`
--

LOCK TABLES `jcqn_doc02_05` WRITE;
/*!40000 ALTER TABLE `jcqn_doc02_05` DISABLE KEYS */;
INSERT INTO `jcqn_doc02_05` VALUES (1,1,31,'技术论','一号会议','地科院','2016.11.15','北京','技术类');
/*!40000 ALTER TABLE `jcqn_doc02_05` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `jcqn_doc02_06`
--

LOCK TABLES `jcqn_doc02_06` WRITE;
/*!40000 ALTER TABLE `jcqn_doc02_06` DISABLE KEYS */;
INSERT INTO `jcqn_doc02_06` VALUES (1,2,31,'论信息技术的重要性','中国出版社','中国','2016');
/*!40000 ALTER TABLE `jcqn_doc02_06` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `jcqn_doc03`
--

LOCK TABLES `jcqn_doc03` WRITE;
/*!40000 ALTER TABLE `jcqn_doc03` DISABLE KEYS */;
INSERT INTO `jcqn_doc03` VALUES (8,31,'我热爱祖国，热爱党，技术过硬，态度良好'),(9,33,'自我感觉良好');
/*!40000 ALTER TABLE `jcqn_doc03` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `jcqn_doc04`
--

LOCK TABLES `jcqn_doc04` WRITE;
/*!40000 ALTER TABLE `jcqn_doc04` DISABLE KEYS */;
INSERT INTO `jcqn_doc04` VALUES (4,31,'未来是美好的，是光明的，是值得期待的，是需要我们共同创建的');
/*!40000 ALTER TABLE `jcqn_doc04` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `jcqn_doc05`
--

LOCK TABLES `jcqn_doc05` WRITE;
/*!40000 ALTER TABLE `jcqn_doc05` DISABLE KEYS */;
INSERT INTO `jcqn_doc05` VALUES (4,31,'积极思考，加强自身技术，好好工作，努力学习');
/*!40000 ALTER TABLE `jcqn_doc05` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `jcqn_doc06`
--

LOCK TABLES `jcqn_doc06` WRITE;
/*!40000 ALTER TABLE `jcqn_doc06` DISABLE KEYS */;
/*!40000 ALTER TABLE `jcqn_doc06` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `kjlj_doc01`
--

LOCK TABLES `kjlj_doc01` WRITE;
/*!40000 ALTER TABLE `kjlj_doc01` DISABLE KEYS */;
/*!40000 ALTER TABLE `kjlj_doc01` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `kjlj_doc02`
--

LOCK TABLES `kjlj_doc02` WRITE;
/*!40000 ALTER TABLE `kjlj_doc02` DISABLE KEYS */;
/*!40000 ALTER TABLE `kjlj_doc02` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `kjlj_doc02_01`
--

LOCK TABLES `kjlj_doc02_01` WRITE;
/*!40000 ALTER TABLE `kjlj_doc02_01` DISABLE KEYS */;
/*!40000 ALTER TABLE `kjlj_doc02_01` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `kjlj_doc02_02`
--

LOCK TABLES `kjlj_doc02_02` WRITE;
/*!40000 ALTER TABLE `kjlj_doc02_02` DISABLE KEYS */;
/*!40000 ALTER TABLE `kjlj_doc02_02` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `kjlj_doc02_03`
--

LOCK TABLES `kjlj_doc02_03` WRITE;
/*!40000 ALTER TABLE `kjlj_doc02_03` DISABLE KEYS */;
/*!40000 ALTER TABLE `kjlj_doc02_03` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `kjlj_doc02_04`
--

LOCK TABLES `kjlj_doc02_04` WRITE;
/*!40000 ALTER TABLE `kjlj_doc02_04` DISABLE KEYS */;
/*!40000 ALTER TABLE `kjlj_doc02_04` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `kjlj_doc02_05`
--

LOCK TABLES `kjlj_doc02_05` WRITE;
/*!40000 ALTER TABLE `kjlj_doc02_05` DISABLE KEYS */;
/*!40000 ALTER TABLE `kjlj_doc02_05` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `kjlj_doc02_06`
--

LOCK TABLES `kjlj_doc02_06` WRITE;
/*!40000 ALTER TABLE `kjlj_doc02_06` DISABLE KEYS */;
/*!40000 ALTER TABLE `kjlj_doc02_06` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `kjlj_doc03`
--

LOCK TABLES `kjlj_doc03` WRITE;
/*!40000 ALTER TABLE `kjlj_doc03` DISABLE KEYS */;
/*!40000 ALTER TABLE `kjlj_doc03` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `kjlj_doc04`
--

LOCK TABLES `kjlj_doc04` WRITE;
/*!40000 ALTER TABLE `kjlj_doc04` DISABLE KEYS */;
/*!40000 ALTER TABLE `kjlj_doc04` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `kjlj_doc05`
--

LOCK TABLES `kjlj_doc05` WRITE;
/*!40000 ALTER TABLE `kjlj_doc05` DISABLE KEYS */;
/*!40000 ALTER TABLE `kjlj_doc05` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `kjlj_doc06`
--

LOCK TABLES `kjlj_doc06` WRITE;
/*!40000 ALTER TABLE `kjlj_doc06` DISABLE KEYS */;
/*!40000 ALTER TABLE `kjlj_doc06` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `mark_detail`
--

LOCK TABLES `mark_detail` WRITE;
/*!40000 ALTER TABLE `mark_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `mark_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `mark_infor`
--

LOCK TABLES `mark_infor` WRITE;
/*!40000 ALTER TABLE `mark_infor` DISABLE KEYS */;
/*!40000 ALTER TABLE `mark_infor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `news`
--

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` VALUES ('0',6,'“中国地质科学院自然科学系列职称申报系统”试运行通知','蒋磊','2016-08-24 17:11:15','中国地质科学院自然科学系列职称申报系统现已上线试运行，请大家完善自己个人信息，需要职称申报的请在规定时间完成职称申报工作！','top','-1'),('0',7,'中国地质调查局业务中心建设与管理暂行办法','蒋磊','2016-08-24 17:10:48','第一章　总　则\n    第一条   根据《中国地质调查局中长期发展规划纲要（2011～2025年）》，为了推进地质调查业务发展，规范和加强中国地质调查局业务中心（以下简称“业务中心”）的建设和管理，制定本办法。\n    第二条   业务中心是在地质调查工作重大业务领域从事调查研究的非法人学术性组织，通过凝聚国内外一流科学家，瞄准重大地质科技问题和国际地学前沿，围绕国家需求和地质调查业务发展需求，开展综合研究、信息服务、国际合作、人才培养和学术交流，引领本业务领域的学科发展，使其成为国际上有重要影响的专业研究中心。\n    第三条   业务中心的主管部门是中国地质调查局（以下简称“地调局”）。地调局根据地质调查工作需要，结合局属单位的总体定位、业务优势和区位优势，对业务中心进行合理布局和建设。\n第二章　基本条件\n    第四条   业务中心的发展方向必须是地调局中长期发展规划确定的重点业务领域。\n    第五条   业务中心原则上依托局属单位建设。依托单位必须具备良好的工作基础和运行条件，具有引领本领域发展的实力或潜力。近五年内，同时在该领域具备以下条件：\n    1.   承担过地质调查计划项目；\n    2.   承担过国家级、省部级重大科技项目；\n    3.   以第一完成单位获得过省部级以上奖励；\n    4.   公开出版或完成过有重大影响的专著、成果报告，在核心期刊发表论文15篇以上；\n    第六条   依托单位拥有3名以上有影响力的专家，包括地调局青年英才计划、国土资源部百人计划等人选，地学领域学术性个人荣誉奖的获得者以及国外重要奖项获得者等；\n    第七条   依托单位拥有相对稳定,且有影响的核心业务团队，在职固定科研人员在10人以上，60%为研究生以上学历。\n第三章　职责\n    第八条   业务中心实行地调局和依托单位分级管理。地调局科技外事部会同相关部室统筹全局业务中心建设，相关部室按业务分工负责指导各领域业务中心的建设。\n    第九条   地调局的主要职责是：\n    1．组织专家对业务中心建设进行论证；批准业务中心主任、秘书长和学术委员会委员组成；\n    2．开展业务中心考核与评估工作；\n    3．指导各业务中心发展规划的编制；\n    4．在项目、人才、条件建设和国际合作交流等方面给予支持。\n    第十条   依托单位的主要职责是：\n    1．提出业务中心建设方案，推荐业务中心主任、秘书长和学术委员会委员人选。\n    2．配合主管部门对业务中心进行考核、评估等工作。\n    3．提出业务中心研究方向、任务、目标等方面的重大调整意见和建议。\n    4．为业务中心吸引人才和培养人才提供激励政策。\n    5．负责业务中心的日常管理。\n    第十一条   业务中心的主要职责是：\n    1．跟踪研究国内外本领域的研究动态，开展战略研究，提出本业务领域的发展规划和建议；\n    2．针对地质调查相关业务领域重大问题，开展信息和咨询服务； \n    3．组织专家对地质调查中区域性、专业性的重大科学问题进行综合研究和联合攻关；\n    4．为申报国家科技计划和地质调查计划提出建议；\n    5．组织开展学术交流、业务培训和国际合作，推广成熟地质理论和地质技术方法，培养优秀地质调查专业人才；\n    6．承办相关领域的学术期刊或杂志等。\n第四章　组织机构\n    第十二条   业务中心设立主任、秘书处和学术委员会：\n    1．主任由依托单位的主要领导担任，负责业务中心的管理。\n    2．秘书处主要负责业务中心的日常工作，组织落实业务中心各项任务目标。秘书长一般由依托单位的专业研究室（中心）的主任担任，在业务领域具有较高学术造诣，且具有较强的组织协调能力。\n    3．学术委员会由国内外本领域的知名专家、学者组成，总人数13～17人。其中，依托单位的学术委员不超过总人数的三分之一，学术委员会任期5年。学术委员会主要负责审议业务中心建设发展的目标、任务和研究方向，审议业务中心的重大学术活动、年度工作、重要议案和研究成果等。\n第五章　运行与管理\n    第十三条   局属单位向地调局提交业务中心建设申请报告。地调局组织专家对业务中心建设申请报告进行评审。\n    第十四条   通过申请报告评审后，依托单位编制业务中心建设实施方案，地调局组织专家对该实施方案进行论证。\n    第十五条   实施方案通过地调局论证和批准后，业务中心正式挂牌成立，依托单位启动业务中心建设工作。\n    第十六条   业务中心成立后的日常工作包括：\n    1．每年向地调局提交年度工作报告和经学术委员审定后的本领域的研究进展报告；\n    2．每年至少组织召开一次学术活动；\n    3．建立健全内部管理运行规章制度；\n    4．有条件的应承办相关领域的期刊杂志；\n    5．对业务中心完成的专著、论文、软件、数据库等研究成果均加注业务中心名称。\n    第十七条   业务中心实行定期考核和评估制度。每二年考核一次，考核组由地调局聘请的7～9名专家组成，实行专家回避制度。考核结果作为业务中心下一阶段运行与发展调整的重要依据，并与支持力度挂钩。 \n    第十八条   根据国家对地质调查工作的需要和业务中心运行情况，地调局可调整业务中心的布局与建设，对业务中心进行重组、整合、撤消等。\n    第十九条   业务中心需要更名、变更研究方向，须经业务中心学术委员会同意，依托单位提出书面申请，经地调局组织专家论证和批准后执行。\n第六章　附 则\n    第二十条   本办法由地调局负责解释。\n    第二十一条   本办法自发布之日起执行。\n','top','-1'),('0',8,'地质力学研究所赴吉尔吉斯斯坦开展野外地质调查','蒋磊','2016-08-24 17:10:16','   2014年8月20日，地质力学研究所《中吉天山成矿带构造背景对比研究》项目组赴吉尔吉斯斯坦开展野外地质调查。\n    20日下午，项目组一行六人抵达比什凯克后，即与吉尔吉斯政府矿产资源管理局、吉尔吉斯地球物理考察队举行了座谈。地质力学所侯春堂副所长首先感谢矿产资源管理局吉拉列夫 杜什别克局长（Duishenbek Zilaliev）对合作的高度重视和支持；并简要介绍了地质力学所基本情况、项目组成员和本次野外地质调查任务，表达了进一步扩大合作的意向。项目负责人王宗秀研究员和哈里洛夫所长介绍了项目进展，取得的成果。吉拉列夫局长诚挚欢迎项目组，表示这是就任局长以来第一次会见国外项目组，指出吉尔吉斯矿产资源丰富，与中国睦邻关系友好，习近平主席与阿坦巴耶夫总统共同提议建立的中-吉战略合作伙伴关系将为两国在地学研究和矿产资源领域的合作注入强大的生命力。他高度评价了地质力学研究所与吉尔吉斯地球物理考察队5年来合作取得的丰硕成果，表示将支持进一步合作。\n    座谈中，吉拉列夫局长还高兴地谈到，已经接受国土资源部邀请，今年十月将到访北京。侯春堂副所长邀请吉拉列夫局长届时到地质力学研究所参观访问，吉拉列夫局长愉快地接受邀请，并表示将以此为契机，把中-吉在地学领域的合作推向更高的发展阶段。\n    会后，项目组与吉尔吉斯地球物理考察队哈里洛夫所长等讨论细化本年度野外地质调查方案，初步探讨了下一步合作研究相关事项。\n\n','top','-1'),('0',9,'“祁连山冻土区天然气水合物控矿因素研究”取得阶段性成果','蒋磊','2016-08-24 17:09:48',' 由地质力学研究所承担的“祁连山冻土区天然气水合物控矿因素综合研究”项目通过对祁连山冻土区新构造、冻土及冰川的调查与研究取得了阶段性成果，并在新生代地层、天然气水合物、烃源岩样品分析等方面获得了新认识。\n    通过对钻获天然气水合物的DK-9孔进行地温参数测量，获得了天然气水合物成藏的冻土厚度、地温梯度等参数。DK-9孔冻土厚度略大于110m，冻土层下地温梯度为2.4?C/100m。数据显示近地表冻土活动层内温度随时间波动变化明显，活动层之下的温度经过平衡后均趋于稳定，深度越大，钻孔内温度与围岩温度平衡稳定需要的时间越短。同时，通过对位于DK-9孔北侧约500m处的DK-10孔连续两个多月的监测分析出了天然气水合物温度、压力变化曲线。\n    通过对南祁连盆地晚古生代-中生代烃源岩的调查与评价，优选出了有利的气源岩层位。羊虎沟组灰岩和煤为差等气源岩，泥岩为中等-好的烃源岩，主生气辅生油；草地沟组泥岩为中等-好的生油岩；大加连组灰岩生油生气潜力差；尕勒得寺组泥岩为中等-好生油岩、好的气源岩，煤为差等气源岩；窑街组泥岩为好的烃源岩，主生油辅生气，煤为差-中等气源岩。其中羊虎沟组泥岩、草地沟组泥岩、尕勒得寺组泥岩、窑街组泥岩和煤为祁连山冻土区天然气水合物的5套主力烃源岩。\n    重建了祁连山地区新生代隆升过程与第四纪环境演化过程。新生代地层ESR年代学研究表明，火烧沟组、白杨河组、疏勒河组和玉门组年龄分别为?40.2~35.3Ma、32.6~24.3Ma、22.7~13.2Ma和3.4~3.0Ma。岩性和岩相变化及构造关系表明，始新世末-渐新世初（35.3~32.6 Ma）祁连山发生了强烈变形和隆升，并导致了火烧沟组顶部代表的晚始新世高原最早期夷平面的解体。中新世中期（15.0~9.0 Ma）阿尔金断裂带与海原断裂带的左旋走滑作用在祁连山北部形成北西向盆-岭构造，祁连山南部地壳块体向东逆冲和顺时针旋转，形成北北东向逆冲断裂和北西向右旋走滑断裂带。自5.4 Ma起祁连山脉逐步隆起，并3.4Ma开始急剧整体快速隆升，玉门砾岩不整合覆盖于夷平面之上。经过2.4~1.4 Ma和0.3~0.15 Ma的多阶段快速隆升，于中更新世早期进入冰冻圈，并奠定了今日环境格局。\n    祁连山天然气水合物控矿因素综合研究表明，天然气水合物与多年冻土、阿尔金断裂带与海原断裂带左旋走滑右阶岩桥区挤压推覆构造带及晚古生代-中生代烃源岩密切相关，天然气水合物形成于倒数第三冰期，并在中更新世中期发生过分解。盆山边界冲断带成为气体运移和天然气水合物成藏的有利地区。\n\n（地质力学研究所七室供稿）','top',''),('0',10,'新建项目成功分析','蒋磊','2016-08-24 17:14:37','&nbsp; &nbsp; &nbsp; &nbsp; 项目开始阶段比较困难，但是随着时间慢慢加长，对项目结构及框架的认识，慢慢的熟悉了流程，开发起来更加顺手，能够更加快速的进入开发阶段。<div>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;所以说，世上无难事只怕有心人</div>','top','');
/*!40000 ALTER TABLE `news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `team_baseinfor`
--

LOCK TABLES `team_baseinfor` WRITE;
/*!40000 ALTER TABLE `team_baseinfor` DISABLE KEYS */;
/*!40000 ALTER TABLE `team_baseinfor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `team_user`
--

LOCK TABLES `team_user` WRITE;
/*!40000 ALTER TABLE `team_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `team_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_attachfile`
--

LOCK TABLES `user_attachfile` WRITE;
/*!40000 ALTER TABLE `user_attachfile` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_attachfile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_award`
--

LOCK TABLES `user_award` WRITE;
/*!40000 ALTER TABLE `user_award` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_award` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_baseinfor`
--

LOCK TABLES `user_baseinfor` WRITE;
/*!40000 ALTER TABLE `user_baseinfor` DISABLE KEYS */;
INSERT INTO `user_baseinfor` VALUES (22,28,NULL,'男',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(23,29,NULL,'男',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(24,30,NULL,'男',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(25,31,NULL,'男','',NULL,NULL,NULL,'','','',NULL,'','','','','','',NULL,'','','',NULL,'',NULL,'','','',''),(26,32,NULL,'男','',NULL,NULL,NULL,'','','',NULL,'','','','','','',NULL,'','','',NULL,'',NULL,'','','',''),(27,33,NULL,'男',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `user_baseinfor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_business`
--

LOCK TABLES `user_business` WRITE;
/*!40000 ALTER TABLE `user_business` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_business` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_exam`
--

LOCK TABLES `user_exam` WRITE;
/*!40000 ALTER TABLE `user_exam` DISABLE KEYS */;
INSERT INTO `user_exam` VALUES (8,31,'英语','2014-10-29','英语六级','540','山东交通学院');
/*!40000 ALTER TABLE `user_exam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_paper`
--

LOCK TABLES `user_paper` WRITE;
/*!40000 ALTER TABLE `user_paper` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_paper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_peixun`
--

LOCK TABLES `user_peixun` WRITE;
/*!40000 ALTER TABLE `user_peixun` DISABLE KEYS */;
INSERT INTO `user_peixun` VALUES (23,31,'2012-11-15','2016-11-16','计算机技术与科学','中国','1','4年','山东交通学院','本科','蒋磊');
/*!40000 ALTER TABLE `user_peixun` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_project`
--

LOCK TABLES `user_project` WRITE;
/*!40000 ALTER TABLE `user_project` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_report`
--

LOCK TABLES `user_report` WRITE;
/*!40000 ALTER TABLE `user_report` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_skill`
--

LOCK TABLES `user_skill` WRITE;
/*!40000 ALTER TABLE `user_skill` DISABLE KEYS */;
INSERT INTO `user_skill` VALUES (16,31,'2015-11-27','设计家项目设计与开发','软件开发','设计家项目正式上线','2016-11-16');
/*!40000 ALTER TABLE `user_skill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_team`
--

LOCK TABLES `user_team` WRITE;
/*!40000 ALTER TABLE `user_team` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_team` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_work`
--

LOCK TABLES `user_work` WRITE;
/*!40000 ALTER TABLE `user_work` DISABLE KEYS */;
INSERT INTO `user_work` VALUES (40,31,'2015-11-18','2016-11-23','联想科技','中国','工程师','1');
/*!40000 ALTER TABLE `user_work` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_zhuanli`
--

LOCK TABLES `user_zhuanli` WRITE;
/*!40000 ALTER TABLE `user_zhuanli` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_zhuanli` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_zhuanzhu`
--

LOCK TABLES `user_zhuanzhu` WRITE;
/*!40000 ALTER TABLE `user_zhuanzhu` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_zhuanzhu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_zuzhi`
--

LOCK TABLES `user_zuzhi` WRITE;
/*!40000 ALTER TABLE `user_zuzhi` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_zuzhi` ENABLE KEYS */;
UNLOCK TABLES;

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

-- Dump completed on 2016-11-30 20:00:20