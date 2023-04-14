-- MySQL dump 10.18  Distrib 10.3.27-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: UserManagementDB
-- ------------------------------------------------------
-- Server version	10.3.27-MariaDB-0+deb10u1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `UserManagementDB`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `UserManagementDB` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `UserManagementDB`;

--
-- Table structure for table `RegisteredUser`
--

DROP TABLE IF EXISTS `RegisteredUser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `RegisteredUser` (
  `registereduserid` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(15) NOT NULL,
  `lastname` varchar(15) NOT NULL,
  `phonenumber` varchar(30) DEFAULT NULL,
  `email` varchar(30) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  PRIMARY KEY (`registereduserid`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RegisteredUser`
--

LOCK TABLES `RegisteredUser` WRITE;
/*!40000 ALTER TABLE `RegisteredUser` DISABLE KEYS */;
INSERT INTO `RegisteredUser` VALUES 
	(1,'Kirsten','Hutchinson','381-454-3416','arcu@icloud.org','foo','bar'),
	(2,'Dai','Snow','723 334-1243','vulputate@google.com','xdai123','password');
/*!40000 ALTER TABLE `RegisteredUser` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-10 17:12:50
