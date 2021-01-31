-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: limedb
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `attendance`
--

DROP TABLE IF EXISTS `attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `attendance` (
  `NO` int(11) NOT NULL AUTO_INCREMENT,
  `USER_ID` varchar(10) DEFAULT NULL,
  `DATE` date DEFAULT NULL,
  `DATE_CNT` int(11) DEFAULT '1',
  `CODE` int(11) DEFAULT NULL,
  `APPROVAL_YN` char(1) DEFAULT NULL,
  `ANNUAL_CNT` int(11) DEFAULT NULL,
  `REMARK` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`NO`),
  KEY `FK_USER_ID` (`USER_ID`),
  KEY `FK_CODE` (`CODE`),
  CONSTRAINT `FK_CODE` FOREIGN KEY (`CODE`) REFERENCES `code` (`NO`),
  CONSTRAINT `FK_USER_ID` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendance`
--

LOCK TABLES `attendance` WRITE;
/*!40000 ALTER TABLE `attendance` DISABLE KEYS */;
INSERT INTO `attendance` VALUES (1,'임용휘','2019-03-07',1,1,'Y',1,'연차신청'),(2,'임용휘','2019-03-07',1,1,'Y',1,'연차신청'),(3,'임용휘','2019-03-07',1,1,'Y',1,'연차신청'),(4,'임용휘','2019-03-07',1,1,'Y',1,'연차신청'),(5,'임용휘','2019-03-07',1,1,'Y',1,'연차신청'),(6,'임용휘','2019-03-07',1,1,'Y',1,'연차신청'),(7,'임용휘','2019-03-07',1,1,'Y',1,'연차신청'),(8,'임용휘','2019-03-07',1,1,'Y',1,'연차신청'),(9,'임용휘','2019-03-07',1,1,'Y',1,'연차신청'),(10,'임용휘','2019-03-07',1,1,'Y',1,'연차신청'),(11,'임용휘','2019-03-07',1,1,'Y',1,'연차신청'),(12,'임용휘','2019-03-07',1,1,'Y',1,'연차신청'),(13,'임용휘','2019-03-07',1,1,'Y',1,'연차신청'),(14,'임용휘','2019-03-07',1,1,'Y',1,'연차신청'),(15,'임용휘','2019-03-07',1,1,'Y',1,'연차신청'),(16,'임용휘','2019-03-07',1,1,'Y',1,'연차신청'),(17,'임용휘','2019-03-07',1,1,'Y',1,'연차신청'),(18,'임용휘','2019-03-07',1,1,'Y',1,'연차신청'),(25,'임용휘2','2019-03-01',1,2,'Y',1,'너무아파요'),(26,'임용휘2','2019-03-12',1,1,'Y',1,''),(27,'임용휘2','2019-03-12',1,1,'Y',1,''),(28,'임용휘2','2019-03-11',1,3,'Y',1,'늦잠잤습니다.'),(29,'임용휘','2019-03-14',1,2,'Y',1,'감기에심하게걸렸습니다.');
/*!40000 ALTER TABLE `attendance` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-18 17:28:32
