-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: spring
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tbl_dream_inquiry`
--

DROP TABLE IF EXISTS `tbl_dream_inquiry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_dream_inquiry` (
  `inquiry_id` int unsigned NOT NULL AUTO_INCREMENT,
  `inquiry_content` text NOT NULL,
  `inquiry_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `member_id` int unsigned NOT NULL,
  PRIMARY KEY (`inquiry_id`),
  KEY `member_id` (`member_id`),
  CONSTRAINT `tbl_dream_inquiry_ibfk_1` FOREIGN KEY (`member_id`) REFERENCES `tbl_dream_member` (`member_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_dream_inquiry`
--

LOCK TABLES `tbl_dream_inquiry` WRITE;
/*!40000 ALTER TABLE `tbl_dream_inquiry` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_dream_inquiry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_dream_inquiry_file`
--

DROP TABLE IF EXISTS `tbl_dream_inquiry_file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_dream_inquiry_file` (
  `inquiry_file_id` int unsigned NOT NULL AUTO_INCREMENT,
  `inquiry_file_upload_path` varchar(500) DEFAULT NULL,
  `inquiry_file_uuid` varchar(500) DEFAULT NULL,
  `inquiry_file_type` varchar(50) DEFAULT NULL,
  `inquiry_id` int unsigned NOT NULL,
  PRIMARY KEY (`inquiry_file_id`),
  KEY `inquiry_id` (`inquiry_id`),
  CONSTRAINT `tbl_dream_inquiry_file_ibfk_1` FOREIGN KEY (`inquiry_id`) REFERENCES `tbl_dream_inquiry` (`inquiry_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_dream_inquiry_file`
--

LOCK TABLES `tbl_dream_inquiry_file` WRITE;
/*!40000 ALTER TABLE `tbl_dream_inquiry_file` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_dream_inquiry_file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_dream_learning_trip`
--

DROP TABLE IF EXISTS `tbl_dream_learning_trip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_dream_learning_trip` (
  `trip_id` int unsigned NOT NULL AUTO_INCREMENT,
  `trip_title` varchar(500) NOT NULL,
  `trip_description` text NOT NULL,
  `trip_price` int NOT NULL,
  `member_id` int unsigned NOT NULL,
  `trip_address` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`trip_id`),
  KEY `fk_tbl_dream_experience_learning_member_id` (`member_id`),
  CONSTRAINT `fk_tbl_dream_experience_learning_member_id` FOREIGN KEY (`member_id`) REFERENCES `tbl_dream_organization` (`member_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_dream_learning_trip`
--

LOCK TABLES `tbl_dream_learning_trip` WRITE;
/*!40000 ALTER TABLE `tbl_dream_learning_trip` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_dream_learning_trip` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_dream_learning_trip_file`
--

DROP TABLE IF EXISTS `tbl_dream_learning_trip_file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_dream_learning_trip_file` (
  `trip_file_number` int unsigned NOT NULL AUTO_INCREMENT,
  `trip_file_upload_path` varchar(500) DEFAULT NULL,
  `trip_file_uuid` varchar(500) DEFAULT NULL,
  `trip_file_original_name` varchar(500) DEFAULT NULL,
  `trip_file_type` varchar(50) DEFAULT NULL,
  `trip_id` int unsigned NOT NULL,
  PRIMARY KEY (`trip_file_number`),
  KEY `trip_id` (`trip_id`),
  CONSTRAINT `tbl_dream_learning_trip_file_ibfk_1` FOREIGN KEY (`trip_id`) REFERENCES `tbl_dream_learning_trip` (`trip_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_dream_learning_trip_file`
--

LOCK TABLES `tbl_dream_learning_trip_file` WRITE;
/*!40000 ALTER TABLE `tbl_dream_learning_trip_file` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_dream_learning_trip_file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_dream_learning_trip_report`
--

DROP TABLE IF EXISTS `tbl_dream_learning_trip_report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_dream_learning_trip_report` (
  `report_id` int unsigned NOT NULL AUTO_INCREMENT,
  `report_title` varchar(500) NOT NULL,
  `report_content` text NOT NULL,
  `report_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `member_id` int unsigned NOT NULL,
  `trip_id` int unsigned NOT NULL,
  PRIMARY KEY (`report_id`),
  KEY `member_id` (`member_id`),
  KEY `trip_id` (`trip_id`),
  CONSTRAINT `tbl_dream_learning_trip_report_ibfk_1` FOREIGN KEY (`member_id`) REFERENCES `tbl_dream_member` (`member_id`) ON DELETE CASCADE,
  CONSTRAINT `tbl_dream_learning_trip_report_ibfk_2` FOREIGN KEY (`trip_id`) REFERENCES `tbl_dream_learning_trip` (`trip_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_dream_learning_trip_report`
--

LOCK TABLES `tbl_dream_learning_trip_report` WRITE;
/*!40000 ALTER TABLE `tbl_dream_learning_trip_report` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_dream_learning_trip_report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_dream_learning_trip_report_file`
--

DROP TABLE IF EXISTS `tbl_dream_learning_trip_report_file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_dream_learning_trip_report_file` (
  `report_file_id` int unsigned NOT NULL AUTO_INCREMENT,
  `report_file_upload_path` varchar(500) DEFAULT NULL,
  `report_file_uuid` varchar(500) DEFAULT NULL,
  `report_file_type` varchar(50) DEFAULT NULL,
  `report_id` int unsigned NOT NULL,
  PRIMARY KEY (`report_file_id`),
  KEY `report_id` (`report_id`),
  CONSTRAINT `tbl_dream_learning_trip_report_file_ibfk_1` FOREIGN KEY (`report_id`) REFERENCES `tbl_dream_learning_trip_report` (`report_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_dream_learning_trip_report_file`
--

LOCK TABLES `tbl_dream_learning_trip_report_file` WRITE;
/*!40000 ALTER TABLE `tbl_dream_learning_trip_report_file` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_dream_learning_trip_report_file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_dream_learning_trip_review`
--

DROP TABLE IF EXISTS `tbl_dream_learning_trip_review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_dream_learning_trip_review` (
  `review_id` int unsigned NOT NULL AUTO_INCREMENT,
  `review_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `review_update_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `review_content` text NOT NULL,
  `review_star_rating` int NOT NULL,
  `review_like_count` int NOT NULL DEFAULT '0',
  `trip_id` int unsigned NOT NULL,
  `member_id` int unsigned NOT NULL,
  PRIMARY KEY (`review_id`),
  KEY `fk_tbl_dream_learning_review_trip_id` (`trip_id`),
  KEY `fk_tbl_dream_learning_review_member_id` (`member_id`),
  CONSTRAINT `fk_tbl_dream_learning_review_member_id` FOREIGN KEY (`member_id`) REFERENCES `tbl_dream_member` (`member_id`) ON DELETE CASCADE,
  CONSTRAINT `fk_tbl_dream_learning_review_trip_id` FOREIGN KEY (`trip_id`) REFERENCES `tbl_dream_learning_trip` (`trip_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_dream_learning_trip_review`
--

LOCK TABLES `tbl_dream_learning_trip_review` WRITE;
/*!40000 ALTER TABLE `tbl_dream_learning_trip_review` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_dream_learning_trip_review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_dream_member`
--

DROP TABLE IF EXISTS `tbl_dream_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_dream_member` (
  `member_id` int unsigned NOT NULL AUTO_INCREMENT,
  `member_identification` varchar(500) DEFAULT NULL,
  `member_pw` varchar(500) DEFAULT NULL,
  `member_email` varchar(500) DEFAULT NULL,
  `member_status` int DEFAULT '0',
  `joined_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `is_admin` tinyint(1) DEFAULT '0',
  `is_withdrawn` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_dream_member`
--

LOCK TABLES `tbl_dream_member` WRITE;
/*!40000 ALTER TABLE `tbl_dream_member` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_dream_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_dream_organization`
--

DROP TABLE IF EXISTS `tbl_dream_organization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_dream_organization` (
  `member_id` int unsigned NOT NULL AUTO_INCREMENT,
  `organization_name` varchar(500) NOT NULL,
  `organization_address` varchar(500) DEFAULT NULL,
  `organization_phone` varchar(50) DEFAULT NULL,
  `organization_email` varchar(500) DEFAULT NULL,
  `organization_registration_number` varchar(50) NOT NULL,
  PRIMARY KEY (`member_id`),
  CONSTRAINT `fk_tbl_dream_organization_info_member_id` FOREIGN KEY (`member_id`) REFERENCES `tbl_dream_member` (`member_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_dream_organization`
--

LOCK TABLES `tbl_dream_organization` WRITE;
/*!40000 ALTER TABLE `tbl_dream_organization` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_dream_organization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_dream_payment`
--

DROP TABLE IF EXISTS `tbl_dream_payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_dream_payment` (
  `payment_id` int unsigned NOT NULL AUTO_INCREMENT,
  `payment_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `payment_amount` int unsigned NOT NULL,
  `payment_method` varchar(100) DEFAULT NULL,
  `member_id` int unsigned NOT NULL,
  PRIMARY KEY (`payment_id`),
  KEY `member_id` (`member_id`),
  CONSTRAINT `tbl_dream_payment_ibfk_1` FOREIGN KEY (`member_id`) REFERENCES `tbl_dream_member` (`member_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_dream_payment`
--

LOCK TABLES `tbl_dream_payment` WRITE;
/*!40000 ALTER TABLE `tbl_dream_payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_dream_payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_dream_personal_info`
--

DROP TABLE IF EXISTS `tbl_dream_personal_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_dream_personal_info` (
  `member_id` int unsigned NOT NULL AUTO_INCREMENT,
  `member_name` varchar(500) NOT NULL,
  `member_nickname` varchar(500) NOT NULL,
  `member_mobile` varchar(500) NOT NULL,
  `member_address` varchar(500) NOT NULL,
  `member_rank` char(1) DEFAULT '0',
  PRIMARY KEY (`member_id`),
  CONSTRAINT `fk_tbl_dream_personal_info_member_id` FOREIGN KEY (`member_id`) REFERENCES `tbl_dream_member` (`member_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_dream_personal_info`
--

LOCK TABLES `tbl_dream_personal_info` WRITE;
/*!40000 ALTER TABLE `tbl_dream_personal_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_dream_personal_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_dream_point`
--

DROP TABLE IF EXISTS `tbl_dream_point`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_dream_point` (
  `point_id` int unsigned NOT NULL AUTO_INCREMENT,
  `current_point` int unsigned NOT NULL DEFAULT '500',
  `total_point` int unsigned NOT NULL DEFAULT '500',
  `point_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `member_id` int unsigned NOT NULL,
  PRIMARY KEY (`point_id`),
  KEY `member_id` (`member_id`),
  CONSTRAINT `tbl_dream_point_ibfk_1` FOREIGN KEY (`member_id`) REFERENCES `tbl_dream_member` (`member_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_dream_point`
--

LOCK TABLES `tbl_dream_point` WRITE;
/*!40000 ALTER TABLE `tbl_dream_point` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_dream_point` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_dream_trip_like`
--

DROP TABLE IF EXISTS `tbl_dream_trip_like`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_dream_trip_like` (
  `like_id` int unsigned NOT NULL AUTO_INCREMENT,
  `member_id` int unsigned NOT NULL,
  `trip_id` int unsigned NOT NULL,
  `like_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`like_id`),
  UNIQUE KEY `unique_like` (`member_id`,`trip_id`),
  KEY `trip_id` (`trip_id`),
  CONSTRAINT `tbl_dream_trip_like_ibfk_1` FOREIGN KEY (`member_id`) REFERENCES `tbl_dream_member` (`member_id`) ON DELETE CASCADE,
  CONSTRAINT `tbl_dream_trip_like_ibfk_2` FOREIGN KEY (`trip_id`) REFERENCES `tbl_dream_learning_trip` (`trip_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_dream_trip_like`
--

LOCK TABLES `tbl_dream_trip_like` WRITE;
/*!40000 ALTER TABLE `tbl_dream_trip_like` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_dream_trip_like` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'spring'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-02  1:30:34
