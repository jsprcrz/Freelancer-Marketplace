-- MySQL dump 10.18  Distrib 10.3.27-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: JobManagementDB
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
-- Current Database: `JobManagementDB`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `JobManagementDB` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `JobManagementDB`;

--
-- Table structure for table `Job`
--

DROP TABLE IF EXISTS `Job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Job` (
  `jobid` int(11) NOT NULL AUTO_INCREMENT,
  `jobname` varchar(20) NOT NULL,
  `jobdesc` varchar(250) DEFAULT NULL,
  `jobcategory` varchar(20) NOT NULL,
  `jobprice` decimal(10,2) NOT NULL,
  `freelancerid` int(11) NOT NULL,
  `locationoffered` varchar(35) DEFAULT NULL,
  `dateadded` date NOT NULL,
  PRIMARY KEY (`jobid`,`freelancerid`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Job`
--

LOCK TABLES `Job` WRITE;
/*!40000 ALTER TABLE `Job` DISABLE KEYS */;
INSERT INTO `Job` VALUES 
	(1,'Event Photographer','I\'ll capture memorable moments at events such as weddings, corporate gatherings, and parties.','Creative',50.00,1,'Ontario','2022-09-21'),
	(2,'Pet Sitter','I care for pets in their own homes, providing feeding, walking, and playtime while their owners are away.','Personal Service',30.00,1,'Ontario','2022-05-16'),
	(3,'House Cleaner','I deep clean homes, including tasks such as dusting, mopping, and scrubbing toilets.','House & Construction',35.00,2,'Alberta','2021-01-28'),
	(4,'Makeup Artist','I enhance clients\' natural beauty for special events such as weddings, proms, and photoshoots.','Personal Service',100.00,2,'Quebec','2019-05-15'),
	(5,'Personal Chef','I prepare nutritious and delicious meals for individuals or families in their own homes.','Personal Service',75.00,3,'Saskatchewan','2020-02-19'),
	(6,'Handyman','I perform various tasks such as fixing leaky faucets, installing light fixtures, and repairing household appliances','House & Construction',25.00,3,'Saskatchewan','2023-07-25'),
	(7,'Tutor','I offer personalized tutoring services in math and science for students of all ages.','Education',40.00,1,'British Columbia','2022-11-03'),
	(8,'Graphic Designer','I create custom logos, business cards, and other visual branding materials for businesses and individuals.','Creative',75.00,1,'Ontario','2022-02-14'),
	(9,'Personal Shopper','I help clients find the perfect outfits for any occasion by curating personalized clothing recommendations.','Marketing & Sales',20.00,3,'Ontario','2021-10-29'),
	(10,'English Teacher','I teach English to non-native speakers, focusing on conversational skills, grammar, and vocabulary.','Education',50.00,2,'Ontario','2021-03-18'),
	(11,'Science Teacher','I demonstrate science experiments to elementary school students, making learning fun and engaging.','Education',25.00,2,'Alberta','2022-08-03'),
	(12,'Sales Representative','I sell products for a variety of businesses, using my persuasive skills and knowledge of the products to close deals.','Marketing & Sales',70.00,3,'British Columbia','2022-03-07'),
	(13,'Marketing Specialist','I design and send email campaigns for e-commerce businesses, helping them increase sales and customer engagement.','Marketing & Sales',45.00,3,'Ontario','2022-01-29');
/*!40000 ALTER TABLE `Job` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-10 17:12:29
