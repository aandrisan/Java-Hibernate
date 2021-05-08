CREATE DATABASE  IF NOT EXISTS `tema1ps` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `tema1ps`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: tema1ps
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `idadmin` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `parola` varchar(255) NOT NULL,
  PRIMARY KEY (`idadmin`),
  UNIQUE KEY `UK_c0r9atamxvbhjjvy5j8da1kam` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('608524c3-d430-4040-b69e-676b839c8094','an@and.com','Andreea','asdf');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `document`
--

DROP TABLE IF EXISTS `document`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `document` (
  `iddocument` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`iddocument`),
  UNIQUE KEY `UK_36vs45u76s1n950kwxfa5lyhc` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `document`
--

LOCK TABLES `document` WRITE;
/*!40000 ALTER TABLE `document` DISABLE KEYS */;
INSERT INTO `document` VALUES ('2323a3cd-2860-415b-8080-4fde39c752c1','Cerere alocatie'),('1701ab07-0f73-4451-b5f8-6e9603b5bac1','Cerere casatorie'),('51ecfb97-8758-49cb-8b7a-7ac9ac390b7f','Cerere pensie');
/*!40000 ALTER TABLE `document` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `request`
--

DROP TABLE IF EXISTS `request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `request` (
  `idrequest` varchar(255) NOT NULL,
  `data` datetime NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `document` varchar(255) NOT NULL,
  `owner` varchar(255) NOT NULL,
  `residence` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  PRIMARY KEY (`idrequest`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `request`
--

LOCK TABLES `request` WRITE;
/*!40000 ALTER TABLE `request` DISABLE KEYS */;
INSERT INTO `request` VALUES ('08f0e3db-ca46-4daf-8aa5-2ab13dd82ab8','2021-03-25 18:16:07','copil','2323a3cd-2860-415b-8080-4fde39c752c1','d778a3f6-7d13-4482-b979-ebb79556b733','65570c4c-bb4d-4448-b2f7-e45a33715b58','sent'),('41abe57a-c051-4d8f-89ec-cdf6063ac103','2021-03-25 18:16:09','copil','2323a3cd-2860-415b-8080-4fde39c752c1','d778a3f6-7d13-4482-b979-ebb79556b733','65570c4c-bb4d-4448-b2f7-e45a33715b58','approved'),('93cd53f1-0679-4299-90c3-5258629eca34','2021-03-25 18:16:06','copil','2323a3cd-2860-415b-8080-4fde39c752c1','d778a3f6-7d13-4482-b979-ebb79556b733','65570c4c-bb4d-4448-b2f7-e45a33715b58','disapproved'),('d4b775fd-e156-462d-b2ba-5802e2292089','2021-03-25 18:16:29','copil','51ecfb97-8758-49cb-8b7a-7ac9ac390b7f','d778a3f6-7d13-4482-b979-ebb79556b733','88d21d8a-a65e-4ac9-85f3-7a244c6bcede','sent');
/*!40000 ALTER TABLE `request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `residence`
--

DROP TABLE IF EXISTS `residence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `residence` (
  `idresidence` varchar(255) NOT NULL,
  `location` varchar(255) NOT NULL,
  `owner` varchar(255) NOT NULL,
  PRIMARY KEY (`idresidence`),
  UNIQUE KEY `UK_c2dsffvip2f50x17l7d3ft84` (`location`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `residence`
--

LOCK TABLES `residence` WRITE;
/*!40000 ALTER TABLE `residence` DISABLE KEYS */;
INSERT INTO `residence` VALUES ('65570c4c-bb4d-4448-b2f7-e45a33715b58','Radauti nr1','d778a3f6-7d13-4482-b979-ebb79556b733'),('88d21d8a-a65e-4ac9-85f3-7a244c6bcede','Radauti nr2','d778a3f6-7d13-4482-b979-ebb79556b733');
/*!40000 ALTER TABLE `residence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `iduser` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `parola` varchar(255) NOT NULL,
  PRIMARY KEY (`iduser`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('17ba9a3d-ae1a-490e-bc9f-c3410b1818bf','daniela@and.com','Daniela','asdf'),('1f5790ba-9b24-4c64-b461-b546c403ff7d','mada@and.com','Madalina','asdf'),('d778a3f6-7d13-4482-b979-ebb79556b733','ral@and.com','Raluca','asdf');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'tema1ps'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-25 18:50:28
