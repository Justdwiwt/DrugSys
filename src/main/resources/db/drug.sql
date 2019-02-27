-- MySQL dump 10.13  Distrib 5.7.16, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: db_drug
-- ------------------------------------------------------
-- Server version	5.7.16-log

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
-- Table structure for table `tb_med_info`
--

DROP TABLE IF EXISTS `tb_med_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_med_info` (
  `med_id` int(11) NOT NULL AUTO_INCREMENT,
  `med_num` varchar(100) NOT NULL,
  `med_name` varchar(100) NOT NULL,
  `med_factory` varchar(100) DEFAULT NULL,
  `med_desc` text,
  `med_price` double NOT NULL,
  `med_count` int(11) DEFAULT NULL,
  `med_pic` varchar(255) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`med_id`),
  UNIQUE KEY `tb_med_info_med_num_uindex` (`med_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_med_info`
--

LOCK TABLES `tb_med_info` WRITE;
/*!40000 ALTER TABLE `tb_med_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_med_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_med_type`
--

DROP TABLE IF EXISTS `tb_med_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_med_type` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(100) NOT NULL,
  `type_desc` text,
  `ctime` datetime DEFAULT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_med_type`
--

LOCK TABLES `tb_med_type` WRITE;
/*!40000 ALTER TABLE `tb_med_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_med_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_root`
--

DROP TABLE IF EXISTS `tb_root`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_root` (
  `root_id` int(11) NOT NULL AUTO_INCREMENT,
  `root_name` varchar(50) NOT NULL,
  `root_pwd` varchar(50) NOT NULL,
  `ctime` datetime DEFAULT NULL,
  PRIMARY KEY (`root_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_root`
--

LOCK TABLES `tb_root` WRITE;
/*!40000 ALTER TABLE `tb_root` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_root` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_root_info`
--

DROP TABLE IF EXISTS `tb_root_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_root_info` (
  `root_id` int(11) NOT NULL,
  `root_num` varchar(20) NOT NULL,
  `root_age` int(11) NOT NULL,
  `root_sex` char(1) NOT NULL,
  `root_email` varchar(50) NOT NULL,
  `root_phone` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_root_info`
--

LOCK TABLES `tb_root_info` WRITE;
/*!40000 ALTER TABLE `tb_root_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_root_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_sell_info`
--

DROP TABLE IF EXISTS `tb_sell_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_sell_info` (
  `sell_id` int(11) NOT NULL AUTO_INCREMENT,
  `sell_name` varchar(200) NOT NULL,
  `sell_price` double NOT NULL,
  `sell_count` int(11) NOT NULL,
  `sell_time` datetime NOT NULL,
  `med_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`sell_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_sell_info`
--

LOCK TABLES `tb_sell_info` WRITE;
/*!40000 ALTER TABLE `tb_sell_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_sell_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user`
--

DROP TABLE IF EXISTS `tb_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL,
  `user_pwd` varchar(50) NOT NULL,
  `user_num` varchar(20) NOT NULL,
  `ctime` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user`
--

LOCK TABLES `tb_user` WRITE;
/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user_info`
--

DROP TABLE IF EXISTS `tb_user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_user_info` (
  `user_id` int(11) NOT NULL,
  `user_age` int(11) NOT NULL,
  `user_sex` char(1) NOT NULL,
  `user_email` varchar(50) NOT NULL,
  `user_phone` varchar(11) NOT NULL,
  `user_pro` varchar(50) NOT NULL,
  `user_address` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user_info`
--

LOCK TABLES `tb_user_info` WRITE;
/*!40000 ALTER TABLE `tb_user_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_user_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-05 22:30:37
