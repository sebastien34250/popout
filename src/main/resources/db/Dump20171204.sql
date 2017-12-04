-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 10.111.61.108    Database: popout
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comments` (
  `comment_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `master_id` int(5) unsigned DEFAULT NULL,
  `write_date` date DEFAULT NULL,
  `event_id` int(10) unsigned DEFAULT NULL,
  `message` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `master_id` (`master_id`),
  KEY `event_id` (`event_id`),
  CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`master_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `comments_ibfk_2` FOREIGN KEY (`event_id`) REFERENCES `events` (`event_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` VALUES (1,1,'2018-01-01',1,'Trop cool ce nouvel an!');
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_comments`
--

DROP TABLE IF EXISTS `event_comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event_comments` (
  `event_id` int(10) unsigned NOT NULL,
  `comment_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`event_id`,`comment_id`),
  KEY `comment_id` (`comment_id`),
  CONSTRAINT `event_comments_ibfk_1` FOREIGN KEY (`event_id`) REFERENCES `events` (`event_id`),
  CONSTRAINT `event_comments_ibfk_2` FOREIGN KEY (`comment_id`) REFERENCES `comments` (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_comments`
--

LOCK TABLES `event_comments` WRITE;
/*!40000 ALTER TABLE `event_comments` DISABLE KEYS */;
INSERT INTO `event_comments` VALUES (1,1);
/*!40000 ALTER TABLE `event_comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_pictograms`
--

DROP TABLE IF EXISTS `event_pictograms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event_pictograms` (
  `event_id` int(10) unsigned NOT NULL,
  `pictogram_id` int(2) unsigned NOT NULL,
  PRIMARY KEY (`event_id`,`pictogram_id`),
  KEY `pictogram_id` (`pictogram_id`),
  CONSTRAINT `event_pictograms_ibfk_1` FOREIGN KEY (`event_id`) REFERENCES `events` (`event_id`),
  CONSTRAINT `event_pictograms_ibfk_2` FOREIGN KEY (`pictogram_id`) REFERENCES `pictograms` (`pictogram_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_pictograms`
--

LOCK TABLES `event_pictograms` WRITE;
/*!40000 ALTER TABLE `event_pictograms` DISABLE KEYS */;
INSERT INTO `event_pictograms` VALUES (1,7);
/*!40000 ALTER TABLE `event_pictograms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_users`
--

DROP TABLE IF EXISTS `event_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event_users` (
  `event_id` int(10) unsigned NOT NULL,
  `user_id` int(5) unsigned NOT NULL,
  PRIMARY KEY (`event_id`,`user_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `event_users_ibfk_1` FOREIGN KEY (`event_id`) REFERENCES `events` (`event_id`),
  CONSTRAINT `event_users_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_users`
--

LOCK TABLES `event_users` WRITE;
/*!40000 ALTER TABLE `event_users` DISABLE KEYS */;
INSERT INTO `event_users` VALUES (1,1);
/*!40000 ALTER TABLE `event_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `events`
--

DROP TABLE IF EXISTS `events`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `events` (
  `event_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `event_date` date DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `master_id` int(10) unsigned DEFAULT NULL,
  `start_time` time DEFAULT NULL,
  `end_time` time DEFAULT NULL,
  `bio_light` varchar(200) DEFAULT NULL,
  `bio` varchar(400) DEFAULT NULL,
  `photo_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`event_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `events`
--

LOCK TABLES `events` WRITE;
/*!40000 ALTER TABLE `events` DISABLE KEYS */;
INSERT INTO `events` VALUES (1,'Aquaponey de la mort !','2017-12-31','MONTPELLIER',1,'19:00:00','23:30:00',NULL,NULL,NULL);
/*!40000 ALTER TABLE `events` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pictograms`
--

DROP TABLE IF EXISTS `pictograms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pictograms` (
  `pictogram_id` int(2) unsigned NOT NULL AUTO_INCREMENT,
  `pictogram_name` varchar(50) DEFAULT NULL,
  `pictograms_path` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`pictogram_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pictograms`
--

LOCK TABLES `pictograms` WRITE;
/*!40000 ALTER TABLE `pictograms` DISABLE KEYS */;
INSERT INTO `pictograms` VALUES (1,'animaux','animaux.png'),(2,'arbre','arbre.png'),(3,'art','art.jpg'),(4,'beignade','beignade.png'),(5,'jeu de cartes','carteAJouer.png'),(6,'cinema','cinema.jpg'),(7,'coktail','soirer.png'),(8,'sport','sport_real.jpg'),(9,'theatre','Theatres.png'),(10,'Découverte','decouverte.jpg'),(11,'Culture','eventail.png'),(12,'apprentissage','livre.png');
/*!40000 ALTER TABLE `pictograms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_pictograms`
--

DROP TABLE IF EXISTS `user_pictograms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_pictograms` (
  `user_id` int(5) unsigned NOT NULL,
  `pictogram_id` int(2) unsigned NOT NULL,
  PRIMARY KEY (`user_id`,`pictogram_id`),
  KEY `fk_user_pictograms_pictogram` (`pictogram_id`),
  CONSTRAINT `fk_user_pictograms_pictogram` FOREIGN KEY (`pictogram_id`) REFERENCES `pictograms` (`pictogram_id`),
  CONSTRAINT `fk_user_pictograms_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_pictograms`
--

LOCK TABLES `user_pictograms` WRITE;
/*!40000 ALTER TABLE `user_pictograms` DISABLE KEYS */;
INSERT INTO `user_pictograms` VALUES (1,1),(1,5);
/*!40000 ALTER TABLE `user_pictograms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `user_id` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `lastname` varchar(50) DEFAULT NULL,
  `firstname` varchar(50) DEFAULT NULL,
  `age` int(2) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `bio_light` varchar(200) DEFAULT NULL,
  `bio` varchar(400) DEFAULT NULL,
  `photo_name` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `user_password` varchar(150) DEFAULT NULL,
  `pseudo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'DERAMOND','SIGRID',29,'CASTELNAU LE LEZ','Biographie light','Biographie longue',NULL,'sigrid.c@hotmail.fr','0000','LADYS');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-04 16:46:20
