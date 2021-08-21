CREATE DATABASE  IF NOT EXISTS `deweb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `deweb`;
-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: deweb
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
-- Table structure for table `carrito`
--

DROP TABLE IF EXISTS `carrito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carrito` (
  `idCarrito` int NOT NULL AUTO_INCREMENT,
  `idUsuario` int NOT NULL,
  `estadoCarrito` varchar(20) NOT NULL,
  `carritoActivo` tinyint NOT NULL,
  PRIMARY KEY (`idCarrito`),
  KEY `id_usuario_carrito_fk_idx` (`idUsuario`),
  CONSTRAINT `id_usuario_carrito_fk` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrito`
--

LOCK TABLES `carrito` WRITE;
/*!40000 ALTER TABLE `carrito` DISABLE KEYS */;
INSERT INTO `carrito` VALUES (1,1,'vacio',1);
/*!40000 ALTER TABLE `carrito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carrito_producto`
--

DROP TABLE IF EXISTS `carrito_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carrito_producto` (
  `idCarrito` int NOT NULL,
  `idProducto` int NOT NULL,
  `estadoCompra` varchar(20) NOT NULL,
  `cantidad` int NOT NULL,
  PRIMARY KEY (`idCarrito`,`idProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrito_producto`
--

LOCK TABLES `carrito_producto` WRITE;
/*!40000 ALTER TABLE `carrito_producto` DISABLE KEYS */;
INSERT INTO `carrito_producto` VALUES (1,4,'pendiente',2),(1,5,'pendiente',1);
/*!40000 ALTER TABLE `carrito_producto` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Table structure for table `comentarios`
--

DROP TABLE IF EXISTS `comentarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comentarios` (
  `idComentarios` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `telefono` varchar(50) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `comentario` varchar(50) NOT NULL,
  PRIMARY KEY (`idComentarios`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comentarios`
--

LOCK TABLES `comentarios` WRITE;
/*!40000 ALTER TABLE `comentarios` DISABLE KEYS */;
INSERT INTO `comentarios` VALUES (2,'Bryan','605205','bsanabriaj@hotmail.com','Muy buena '),(3,'Emily','6058','emy@hotmail.com','Exelente Lugar'),(4,'Yirlani','2344','yir@hotmail.com','Excelente');
/*!40000 ALTER TABLE `comentarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_ventas`
--

DROP TABLE IF EXISTS `detalle_ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_ventas` (
  `idDetalle_ventas` int NOT NULL AUTO_INCREMENT,
  `idVentas` int NOT NULL,
  `idProducto` int NOT NULL,
  `cantidad` int NOT NULL,
  `precioUnitario` decimal(10,2) NOT NULL,
  `total` varchar(45) NOT NULL,
  PRIMARY KEY (`idDetalle_ventas`),
  KEY `id_ventas_detalleventas_fk_idx` (`idVentas`),
  KEY `id_producto_detalleventas_fk_idx` (`idProducto`),
  CONSTRAINT `id_producto_detalleventas_fk` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`),
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
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado` (
  `idEmpleado` int NOT NULL,
  `nombres` varchar(50) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `cedula` varchar(10) NOT NULL,
  `telefono` varchar(10) NOT NULL,
  `rol` varchar(45) NOT NULL,
  `password` longtext NOT NULL,
  `estado` tinyint(1) NOT NULL,
  PRIMARY KEY (`idEmpleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `envios`
--

DROP TABLE IF EXISTS `envios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `envios` (
  `idEnvios` int NOT NULL AUTO_INCREMENT,
  `idCliente` int NOT NULL,
  `idDetalle_ventas` int NOT NULL,
  `idEmpleado` int NOT NULL,
  `estado` varchar(45) NOT NULL,
  PRIMARY KEY (`idEnvios`),
  KEY `id_cliente_envios_idx` (`idCliente`),
  KEY `id_detalle_ventas_envios_idx` (`idDetalle_ventas`),
  KEY `id_empleado_envios_idx` (`idEmpleado`),
  CONSTRAINT `id_cliente_envios` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`),
  CONSTRAINT `id_detalle_ventas_envios` FOREIGN KEY (`idDetalle_ventas`) REFERENCES `detalle_ventas` (`idDetalle_ventas`),
  CONSTRAINT `id_empleado_envios` FOREIGN KEY (`idEmpleado`) REFERENCES `empleado` (`idEmpleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `envios`
--

LOCK TABLES `envios` WRITE;
/*!40000 ALTER TABLE `envios` DISABLE KEYS */;
/*!40000 ALTER TABLE `envios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `factura`
--

DROP TABLE IF EXISTS `factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `factura` (
  `idFactura` int NOT NULL AUTO_INCREMENT,
  `idUsuario` int NOT NULL,
  `total` int NOT NULL,
  `fecha` date DEFAULT NULL,
  `iva` int NOT NULL,
  `subTotal` int NOT NULL,
  PRIMARY KEY (`idFactura`),
  KEY `id_usuario_factura_idx` (`idUsuario`),
  CONSTRAINT `id_usuario_factura` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factura`
--

LOCK TABLES `factura` WRITE;
/*!40000 ALTER TABLE `factura` DISABLE KEYS */;
/*!40000 ALTER TABLE `factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `idProducto` int NOT NULL AUTO_INCREMENT,
  `codigo` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `estado` varchar(50) NOT NULL,
  `descripcion` varchar(250) NOT NULL,
  `stock` int DEFAULT NULL,
  `nombreImagen` varchar(50) NOT NULL,
  PRIMARY KEY (`idProducto`),
  UNIQUE KEY `codigo_UNIQUE` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (4,'100','Philadelphia',4500.00,'Disponible','Carne 150 gr, cebolla caramelizada, queso americano, tocineta en trocitos, queso philadelphia, salsa BBQ Jack Daniel',NULL,'hamburguesaPhila'),(5,'101','Deluxe',5500.00,'Disponible','Carne 150 gr, trozos de chicharrón, tocineta, queso americano, salsa de la casa, tomate',NULL,'hamburguesaDelu'),(6,'102','Rústica',4000.00,'Disponible','Carne 150 gr, cerdo desmechado con salsa barbacoa, queso americano, BBQ Jack Daniel`s, lechuga y salsa de rústica',NULL,'hamburguesaRusti'),(7,'103','Chicago',5000.00,'Disponible','Carne 150 gr, salsa de queso cheddar, tocineta, pepinillos, cebolla caramelizada y lechuga.',NULL,'hamburguesaChica'),(8,'104','Rellena',6500.00,'Disponible','Carne 300 gr, rellena de doble queso mozzarella y tocineta, lechuga, tomate, salsa de la casa.',NULL,'hamburguesaRelle'),(9,'105','Doble',7000.00,'Disponible','2 carnes de 150 gr c/u, doble queso americano, lechuga, tomate, salsa de la casa.',NULL,'hamburguesaDoble'),(10,'106','Vegetariana',4500.00,'Disponible','Hamburguesa de lenteja o garbanzo, cebolla caramelizada, totopos triturados, doble queso mozzarella, lechuga, tomate.',NULL,'hamburguesaVege'),(11,'200','Pizza Maisha',8000.00,'Disponible','Bacon, aceitunas negras, champiñón, cebolla (Mediana)',NULL,'pizzaMais'),(12,'201','Pizza Mediterránea ',8500.00,'Disponible','Jamón york, champiñón, gulas (Mediana)',NULL,'pizzaMedi'),(13,'202','Pizza tierra y mar',8500.00,'Disponible','Jamón, pimiento, gulas, pollo (Mediana)',NULL,'pizzaTiMa'),(14,'203','Pizza Vegetal',8000.00,'Disponible','Maiz, Pimientos frescos,Cebolla,Espinaca (Mediana)',NULL,'pizzaVege'),(15,'300','CRUMBLE DE FRUTAS DE TEMPORADA',5000.00,'Disponible','Fruta de temporada / helado de vainilla / fruta caramelizada /\nchips de fruta / crumble clásico / curd de limón con chocolate\nblanco\n',NULL,'CrumbleFrutas'),(16,'301','PASTEL GOLOSO DE CHOCOLATE GLUTEN FREE\n',5000.00,'Disponible','Helado de crema ácida / crumble de almendras ',NULL,'PastelChocolate'),(17,'303','CHURROS',3500.00,'Disponible','Tradicionales churros rellenos / buñuelos / chocolate\ncaliente',NULL,'Churros'),(18,'304','CHEESE CAKE DE DULCE DE LECHE',5000.00,'Disponible','Plátano macho / salsa capuchino con tequila / helado\nde banana split ',NULL,'CheeseCakeDulce'),(19,'400','CAFÉ MEXICANO',4000.00,'Disponible','tequila / kahlua / café expresso / crema batida con\nesencia de canela',NULL,'CafeMexicano'),(20,'401','EXPRESSO MARTINI',4500.00,'Disponible','vodka absolut vainilla / kahlua / café expresso',NULL,'ExpressoMartini'),(22,'402','MARTINI DE PAY DE LIMÓN',4500.00,'Disponible','vodka infusionado con vainilla / crema de coco /\nlimón amarillo',NULL,'MartiniPayLimon'),(23,'403','MARTINI DE CHOCOLATE',4500.00,'Disponible','vodka naranja / licor de café / cerveza stouth',NULL,'MartiniChocolate'),(24,'501','DAVID`S ALE - LIGHT SCOTCH ALE',2300.00,'Disponible','6,5% Alc. Una cerveza para dar rienda suelta a los sentidos. Aromas a caramelo y Toffe, característica que se transfiere a\nun dulzor en el gusto, con trazas a pasas y nueces. Muy poco lupulada, y por lo tanto, nada amarga.',NULL,'DadviAleLight'),(25,'500','BABELIN - Hefeweizen clásica',2000.00,'Disponible','5% Alc. Color narnja pálido, turbio natural. En boca refrescante. Aromas a fruta madura y clavo.',NULL,'Babelin'),(26,'502','IMPERIAL IPA',2500.00,'Disponible','7% Alc. El aroma hecho placer. Cuando se prueba, deja a su paso un intenso sabor amargo que permanece arropado por\nnotas de maracuyá, mango y uvas. ¡Todo un reto! ',NULL,'ImperialIPA'),(27,'503','BARLEY WINE',2500.00,'Disponible','9% Alc. Su color es ambar oscuro, sus aromas son maltosos con toques a fruta muy madura y un sabor dulce con trozos\nde frutos secos',NULL,'BarleyWine'),(28,'504','RUBIA - BLONDE ALE',3000.00,'Disponible','4,5% Alc. Muy ligera y refrescante, con cierto aroma a lúpulos florales y un ligero retrogusto a cítricos. Se elabora con\ndiferentes variedades de lúpulos. ',NULL,'RubiaBlondeALE'),(29,'600','Chocolate',1500.00,'Disponible','Caliente y espumoso',NULL,'Chocolate'),(30,'601','Café Helado',1500.00,'Disponible','Frío',NULL,'CafeHelado'),(31,'602','Café Tinto',1500.00,'Disponible','Caliente',NULL,'CafeTinto'),(32,'603','Café Mocha Blanco',1500.00,'Disponible','Caliente',NULL,'CafeMochaBlanco'),(33,'604','Café Mocha',1500.00,'Disponible','Caliente',NULL,'CafeMocha'),(34,'605','Caramel Macchiato',1500.00,'Disponible','Caliente',NULL,'CaramelMacchiato'),(35,'606','Vainilla Latte',1500.00,'Disponible','Caliente',NULL,'VainillaLatte'),(36,'607','Café Latte',1500.00,'Disponible','Caliente',NULL,'CafeLatte'),(37,'608','Cappuccino',1500.00,'Disponible','Caliente',NULL,'Cappuccino'),(38,'609','Espresso Americano',1500.00,'Disponible','Caliente',NULL,'EspressoAmericano'),(39,'610','Espresso Panna',1500.00,'Disponible','Caliente',NULL,'EspressoPanna'),(40,'611','Espresso Macchiato',1500.00,'Disponible','Caliente',NULL,'EspressoMacchiato'),(41,'612','Espresso',1500.00,'Disponible','Caliente',NULL,'Expresso');
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
  `correo` varchar(60) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombreUsuario_UNIQUE` (`nombreUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Bryan','Sanabria','9182918833','99999999','Admin','bsanabria','12345',1,'bsanabriaj@hotmail.com'),(2,'Alexa','Cabalceta','1245646764','88888888','Admin','acabalceta','12345',1,'ale@ufide.ac.cr'),(3,'Yirlani','Hernandez','1231424545','77777777','Admin','yhernandez','12345',1,'yir@ufide.ac.cr');
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

-- Dump completed on 2021-08-21 15:10:05
