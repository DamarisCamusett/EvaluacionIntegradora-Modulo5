-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: alkewallet_db
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `cliente_id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) COLLATE utf8mb3_spanish_ci NOT NULL,
  `apellido` varchar(45) COLLATE utf8mb3_spanish_ci NOT NULL,
  `rutcliente` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci NOT NULL,
  PRIMARY KEY (`cliente_id`),
  KEY `rut_idx` (`rutcliente`),
  CONSTRAINT `bancacliente` FOREIGN KEY (`cliente_id`) REFERENCES `cuenta` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Manuel','User','15926348-7');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuenta`
--

DROP TABLE IF EXISTS `cuenta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cuenta` (
  `id` int NOT NULL AUTO_INCREMENT,
  `numeroCta` int NOT NULL,
  `rut_cliente` varchar(45) COLLATE utf8mb3_spanish_ci NOT NULL,
  `apodo` varchar(45) COLLATE utf8mb3_spanish_ci NOT NULL,
  `banco` varchar(45) COLLATE utf8mb3_spanish_ci NOT NULL,
  `saldo` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuenta`
--

LOCK TABLES `cuenta` WRITE;
/*!40000 ALTER TABLE `cuenta` DISABLE KEYS */;
INSERT INTO `cuenta` VALUES (1,265,'12365498-7','Miguel','BCI',30000);
/*!40000 ALTER TABLE `cuenta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `moneda`
--

DROP TABLE IF EXISTS `moneda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `moneda` (
  `currency_id` int NOT NULL AUTO_INCREMENT,
  `currency_name` varchar(45) COLLATE utf8mb3_spanish_ci NOT NULL,
  `currency_simbol` varchar(45) COLLATE utf8mb3_spanish_ci NOT NULL,
  PRIMARY KEY (`currency_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `moneda`
--

LOCK TABLES `moneda` WRITE;
/*!40000 ALTER TABLE `moneda` DISABLE KEYS */;
INSERT INTO `moneda` VALUES (1,'Dolar Estadounidense','USD'),(2,'Euro','EUR'),(3,'Peso Chileno','CLP'),(4,'Yen','JPY');
/*!40000 ALTER TABLE `moneda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaccion`
--

DROP TABLE IF EXISTS `transaccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaccion` (
  `transaccion_id` int NOT NULL AUTO_INCREMENT,
  `sender_user_id` int NOT NULL,
  `receiver_user_id` int NOT NULL,
  `importe` decimal(10,2) NOT NULL,
  `transaction_date` date NOT NULL,
  `currency_id` int NOT NULL,
  PRIMARY KEY (`transaccion_id`),
  KEY `currency_id_idx` (`currency_id`),
  KEY `receiver_user_id_idx` (`receiver_user_id`),
  KEY `sender_user_id_idx` (`sender_user_id`),
  CONSTRAINT `currency_id` FOREIGN KEY (`currency_id`) REFERENCES `moneda` (`currency_id`),
  CONSTRAINT `receiver_user_id` FOREIGN KEY (`receiver_user_id`) REFERENCES `usuario` (`user_id`),
  CONSTRAINT `sender_user_id` FOREIGN KEY (`sender_user_id`) REFERENCES `usuario` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaccion`
--

LOCK TABLES `transaccion` WRITE;
/*!40000 ALTER TABLE `transaccion` DISABLE KEYS */;
INSERT INTO `transaccion` VALUES (4,1,3,500000.00,'2024-01-06',1),(5,3,2,60000.00,'2024-06-01',2);
/*!40000 ALTER TABLE `transaccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) COLLATE utf8mb3_spanish_ci NOT NULL,
  `apellido` varchar(45) COLLATE utf8mb3_spanish_ci NOT NULL,
  `user_rut` varchar(45) COLLATE utf8mb3_spanish_ci NOT NULL,
  `fechanacimiento` date NOT NULL,
  `contrasena` varchar(45) COLLATE utf8mb3_spanish_ci NOT NULL,
  `currency_id` int NOT NULL,
  PRIMARY KEY (`user_id`),
  KEY `currency_id_idx` (`currency_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Manuel','Usuario','12345678-9','1993-10-28','11223344',1),(2,'Martina','Reff','15935748-9','1995-05-23','336699',2),(3,'Gabriel','Loft','13245698-7','1996-06-23','665544',3),(4,'Rita','Martinez','14725836-9','1999-04-20','789789',4),(5,'Sara','Mil','12398745-6','1990-06-10','7532951',5);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-01 10:57:15
