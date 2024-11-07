CREATE DATABASE  IF NOT EXISTS `cocktails_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `cocktails_db`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: cocktails_db
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `favorites`
--

DROP TABLE IF EXISTS `favorites`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `favorites` (
  `id` int NOT NULL AUTO_INCREMENT,
  `drink_id` varchar(50) NOT NULL,
  `drink_name` varchar(100) DEFAULT NULL,
  `drink_category` varchar(50) DEFAULT NULL,
  `drink_alcoholic` varchar(50) DEFAULT NULL,
  `drink_glass` varchar(50) DEFAULT NULL,
  `drink_instructions` text,
  `drink_image_url` varchar(255) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `favorites`
--

LOCK TABLES `favorites` WRITE;
/*!40000 ALTER TABLE `favorites` DISABLE KEYS */;
INSERT INTO `favorites` VALUES (1,'15346','155 Belmont','Cocktail','Alcoholic','White wine glass','Blend with ice. Serve in a wine glass. Garnish with carrot.','https://www.thecocktaildb.com/images/media/drink/yqvvqs1475667388.jpg','2024-11-07 04:39:37'),(2,'14029','57 Chevy with a White License Plate','Cocktail','Alcoholic','Highball glass','1. Fill a rocks glass with ice 2.add white creme de cacao and vodka 3.stir','https://www.thecocktaildb.com/images/media/drink/qyyvtu1468878544.jpg','2024-11-07 04:47:52'),(3,'16108','9 1/2 Weeks','Cocktail','Alcoholic','Cocktail glass','Combine all ingredients in glass mixer. Chill and strain into Cocktail glass. Garnish with sliced strawberry.','https://www.thecocktaildb.com/images/media/drink/xvwusr1472669302.jpg','2024-11-07 05:05:57'),(4,'17222','A1','Cocktail','Alcoholic','Cocktail glass','Pour all ingredients into a cocktail shaker, mix and serve over ice into a chilled glass.','https://www.thecocktaildb.com/images/media/drink/2x8thr1504816928.jpg','2024-11-07 05:06:33'),(5,'17224','Absolutely Fabulous','Cocktail','Alcoholic','Champagne flute','Mix the Vodka and Cranberry juice together in a shaker and strain into a glass. Top up with Champagne.','https://www.thecocktaildb.com/images/media/drink/abcpwr1504817734.jpg','2024-11-07 07:15:58');
/*!40000 ALTER TABLE `favorites` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-07 11:12:18
