CREATE DATABASE  IF NOT EXISTS `optica_mas_vision` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `optica_mas_vision`;
-- MySQL dump 10.13  Distrib 8.0.46, for Win64 (x86_64)
--
-- Host: localhost    Database: optica_mas_vision
-- ------------------------------------------------------
-- Server version	8.0.46

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
-- Table structure for table `citas_optometricas`
--

DROP TABLE IF EXISTS `citas_optometricas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `citas_optometricas` (
  `id` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `paciente_id` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `optometrista_id` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `fecha_hora` datetime NOT NULL,
  `motivo` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `estado` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'PENDIENTE',
  PRIMARY KEY (`id`),
  KEY `fk_cita_optometrista` (`optometrista_id`),
  CONSTRAINT `fk_cita_optometrista` FOREIGN KEY (`optometrista_id`) REFERENCES `optometristas` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `citas_optometricas`
--

LOCK TABLES `citas_optometricas` WRITE;
/*!40000 ALTER TABLE `citas_optometricas` DISABLE KEYS */;
INSERT INTO `citas_optometricas` VALUES ('CIT-1782343383289','PAC-001','OPT-1782342784299','2026-06-25 18:23:03','Evaluación visual general','PENDIENTE'),('CIT-1782344823078','PAC-001','OPT-1782342784299','2026-06-25 18:47:03','Evaluación visual general','PENDIENTE');
/*!40000 ALTER TABLE `citas_optometricas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `optometristas`
--

DROP TABLE IF EXISTS `optometristas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `optometristas` (
  `id` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nombre` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `apellido` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `area_atencion` varchar(120) COLLATE utf8mb4_unicode_ci NOT NULL,
  `registro_profesional` varchar(80) COLLATE utf8mb4_unicode_ci NOT NULL,
  `disponible` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `registro_profesional` (`registro_profesional`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `optometristas`
--

LOCK TABLES `optometristas` WRITE;
/*!40000 ALTER TABLE `optometristas` DISABLE KEYS */;
INSERT INTO `optometristas` VALUES ('OPT-1782342745926','Ana','Torres','Optometría general','REG-1782342745926',1),('OPT-1782342784299','Javier','Flores','Optometría general','REG-1782342784299',1),('OPT-1782343114378','Javier','Flores','Optometría general','REG-1782343114378',1),('OPT-1782343311852','Javier','Flores','Optometría general','REG-1782343311852',1);
/*!40000 ALTER TABLE `optometristas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `id` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nombre` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `categoria` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `descripcion` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `precio` decimal(10,2) NOT NULL,
  `stock` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES ('001','Javier','Montura','Montura métalica para adulto',120.00,40);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-06-24 20:30:48
