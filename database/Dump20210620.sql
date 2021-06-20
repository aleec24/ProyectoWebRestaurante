CREATE DATABASE  IF NOT EXISTS `deweb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `deweb`;
-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: deweb
-- ------------------------------------------------------
-- Server version	8.0.25

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
  `idCliente` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `apellidos` varchar(45) NOT NULL,
  `cedula` varchar(10) NOT NULL,
  `direccion` varchar(120) DEFAULT NULL,
  `estado` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Bryan','Sanabria','1234','Heredia',0);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_ventas`
--

DROP TABLE IF EXISTS `detalle_ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_ventas` (
  `idDetalle_ventas` int NOT NULL,
  `idVentas` int NOT NULL,
  `idProducto` int NOT NULL,
  `cantidad` int NOT NULL,
  `precioUnitario` decimal(10,2) NOT NULL,
  `total` varchar(45) NOT NULL,
  PRIMARY KEY (`idDetalle_ventas`),
  KEY `id_ventas_detalleventas_fk` (`idVentas`),
  KEY `id_producto_detalleventas` (`idProducto`),
  CONSTRAINT `id_producto_detalleventas` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`),
  CONSTRAINT `id_ventas_detalleventas_fk` FOREIGN KEY (`idVentas`) REFERENCES `ventas` (`idVentas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_ventas`
--

LOCK TABLES `detalle_ventas` WRITE;
/*!40000 ALTER TABLE `detalle_ventas` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_ventas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `idProducto` int NOT NULL,
  `codigo` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `stock` int NOT NULL,
  `estado` tinyint(1) NOT NULL,
  PRIMARY KEY (`idProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id` int NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `cedula` varchar(10) NOT NULL,
  `telefono` varchar(10) NOT NULL,
  `rol` varchar(45) NOT NULL,
  `nombreUsuario` varchar(50) NOT NULL,
  `claveUsuario` longtext NOT NULL,
  `estado` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Bryan','Sanabria','9182918833','99999999','Admin','bsanabria','12345',1),(2,'Alexa','Cabalceta','1245646764','88888888','Admin','acabalceta','12345',1),(3,'Yirlani','Hernandez','1231424545','77777777','Admin','yhernandez','12345',1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ventas`
--

DROP TABLE IF EXISTS `ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ventas` (
  `idVentas` int NOT NULL,
  `idCliente` int NOT NULL,
  `idEmpleado` int NOT NULL,
  `fecha` datetime NOT NULL,
  `subtotal` decimal(10,2) NOT NULL,
  `iva` decimal(10,2) NOT NULL,
  `total` decimal(10,2) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  PRIMARY KEY (`idVentas`),
  KEY `id_cliente_venta_fk_idx` (`idCliente`),
  KEY `id_empleado_ventas_fk_idx` (`idEmpleado`),
  CONSTRAINT `id_cliente_venta_fk` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`),
  CONSTRAINT `id_empleado_ventas_fk` FOREIGN KEY (`idEmpleado`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ventas`
--

LOCK TABLES `ventas` WRITE;
/*!40000 ALTER TABLE `ventas` DISABLE KEYS */;
/*!40000 ALTER TABLE `ventas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-20 10:37:57
