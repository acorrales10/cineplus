CREATE DATABASE  IF NOT EXISTS `cine` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `cine`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: cine
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `cartelera`
--

DROP TABLE IF EXISTS `cartelera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cartelera` (
  `id` int NOT NULL AUTO_INCREMENT,
  `pelicula_id` int NOT NULL,
  `agenda_id` int NOT NULL,
  `sala_id` int NOT NULL,
  `precio` double NOT NULL,
  `activo` tinyint DEFAULT NULL,
  `preventa` tinyint DEFAULT NULL,
  `home` tinyint DEFAULT NULL,
  PRIMARY KEY (`id`,`pelicula_id`,`agenda_id`,`sala_id`),
  KEY `FK5y28cey2nf3qna6qru85a21jp` (`agenda_id`),
  KEY `FK1j2phe4yjs0nr7kk29qkb2ig1` (`pelicula_id`),
  KEY `FKet6a338cprs0v6mjmr7e4g50i` (`sala_id`),
  CONSTRAINT `FK1j2phe4yjs0nr7kk29qkb2ig1` FOREIGN KEY (`pelicula_id`) REFERENCES `peliculas` (`id`),
  CONSTRAINT `FK5y28cey2nf3qna6qru85a21jp` FOREIGN KEY (`agenda_id`) REFERENCES `horario` (`id`),
  CONSTRAINT `FKet6a338cprs0v6mjmr7e4g50i` FOREIGN KEY (`sala_id`) REFERENCES `salas` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cartelera`
--

LOCK TABLES `cartelera` WRITE;
/*!40000 ALTER TABLE `cartelera` DISABLE KEYS */;
INSERT INTO `cartelera` VALUES (1,2,2,1,5000,0,1,1),(2,3,3,1,6000,1,0,1),(3,4,3,2,6000,1,0,1),(5,7,6,5,5000,1,1,1),(6,8,6,5,5000,1,1,1);
/*!40000 ALTER TABLE `cartelera` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `food`
--

DROP TABLE IF EXISTS `food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `food` (
  `id` int NOT NULL AUTO_INCREMENT,
  `producto` varchar(80) DEFAULT NULL,
  `precio` decimal(12,2) NOT NULL,
  `imagen` varchar(250) DEFAULT NULL,
  `descripcion` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `food`
--

LOCK TABLES `food` WRITE;
/*!40000 ALTER TABLE `food` DISABLE KEYS */;
INSERT INTO `food` VALUES (1,'Palomitas Salada',3100.00,'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT9ZY7t5HT5DZIUeDijCGmIhLrrZ7URWmdMww&usqp=CAU','Grande Web'),(2,'Palomitas Dulce',3100.00,'https://i.ytimg.com/vi/9jU_1oLyeBc/maxresdefault.jpg','Grande web'),(3,'Palomitas Mixta',3100.00,'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT7RoYjqXkT6twE_z_BQ6sQlo3-50a0fyk37Q&usqp=CAU','Grande web'),(4,'Coca Cola',1500.00,'https://s7d1.scene7.com/is/image/mcdonalds/t-mcdonalds-Coca-Cola-Classic-Small-1:1-3-product-tile-desktop?wid=765&hei=472&dpr=off','500 ML');
/*!40000 ALTER TABLE `food` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `horario`
--

DROP TABLE IF EXISTS `horario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `horario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `agenda` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horario`
--

LOCK TABLES `horario` WRITE;
/*!40000 ALTER TABLE `horario` DISABLE KEYS */;
INSERT INTO `horario` VALUES (2,'5:00 pm'),(3,'5:30 PM - 9:30 PM'),(4,'2:00pm'),(6,'Lunes 7:00 - 10:00 PM');
/*!40000 ALTER TABLE `horario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `peliculas`
--

DROP TABLE IF EXISTS `peliculas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `peliculas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `pelicula` varchar(45) COLLATE utf8_spanish2_ci NOT NULL,
  `imagen` varchar(250) COLLATE utf8_spanish2_ci NOT NULL,
  `genero` enum('Accion','Ciencia Ficcion','Comedia','Drama','Terror','Suspenso','Aventuras','Fantasia') COLLATE utf8_spanish2_ci NOT NULL,
  `clasificacion` enum('TP','+7','+12','+16','+18') COLLATE utf8_spanish2_ci NOT NULL,
  `descripcion` longtext COLLATE utf8_spanish2_ci,
  `actores` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `duracion` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `imagen_back` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `year` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `peliculas`
--

LOCK TABLES `peliculas` WRITE;
/*!40000 ALTER TABLE `peliculas` DISABLE KEYS */;
INSERT INTO `peliculas` VALUES (2,'game','https://lumiere-a.akamaihd.net/v1/images/doctor_strange_in_the_multiverse_of_madness_0_4be9d58f.jpeg?region=0,0,582,327','Ciencia Ficcion','+16','Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.','Benedict Cumberbatch','150 Min','https://www.novacinemas.cr/wp-content/uploads/2022/08/banner_1280x600_dragonball_preventa.jpg',2016),(3,'game','https://image.shutterstock.com/image-photo/young-woman-watching-projector-tv-600w-1734341717.jpg','Accion','TP','asdasd','Benedict Cumberbatch','140 Min','https://image.shutterstock.com/image-photo/young-woman-watching-projector-tv-600w-1734341717.jpg',2020),(4,'Test','https://image.shutterstock.com/image-photo/portrait-nice-attractive-lovely-positive-600w-1489157471.jpg','Ciencia Ficcion','+7','asdfasdfsdf','Benedict Cumberbatch','130 Min','https://image.shutterstock.com/image-photo/portrait-nice-attractive-lovely-positive-600w-1489157471.jpg',2010),(5,'afdasdf','https://image.shutterstock.com/image-photo/portrait-nice-attractive-lovely-positive-600w-1489157471.jpg','Drama','TP','asddasd',NULL,NULL,NULL,0),(6,'asdfasdf','https://image.shutterstock.com/image-photo/portrait-nice-attractive-lovely-positive-600w-1489157471.jpg','Terror','+12','adasdasds',NULL,NULL,NULL,0),(7,'Dragon Ball Super Super Hero','https://www.novacinemas.cr/wp-content/uploads/2022/07/banner_356x514_DragonBall_imax.jpg','Fantasia','TP','Son Goku destruyó en su momento al Ejército del Listón Rojo. Ahora, ciertos individuos han decidido continuar con su legado y han creado a los androides definitivos: Gamma 1 y Gamma 2. Estos dos androides se autoproclaman «superhéroes» y deciden atacar a Piccolo y a Gohan. ¿Cuál es el objetivo del Nuevo Ejército del Listón Rojo? Ante un peligro inminente, ¡llega el momento del despertar del Superhéroe!','Goku, Vegeta','100 Min','https://www.novacinemas.cr/wp-content/uploads/2022/08/banner_1280x600_dragonball_preventa.jpg',2022),(8,'Alarido','https://www.novacinemas.cr/wp-content/uploads/2022/08/banner_356x514_alarido.jpg','Fantasia','+16','pelicula de suspenso para mayores','Benedict Cumberbatch','100 min','https://www.novacinemas.cr/wp-content/uploads/2022/08/banner_356x514_alarido.jpg',2022);
/*!40000 ALTER TABLE `peliculas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salas`
--

DROP TABLE IF EXISTS `salas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `salas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) COLLATE utf8_spanish2_ci NOT NULL,
  `descripcion` longtext COLLATE utf8_spanish2_ci,
  `imagen` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salas`
--

LOCK TABLES `salas` WRITE;
/*!40000 ALTER TABLE `salas` DISABLE KEYS */;
INSERT INTO `salas` VALUES (1,'SALA VIP 1','Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum','https://image.shutterstock.com/image-illustration/movie-theater-without-people-blank-600w-1915629427.jpg'),(2,'VIP 2','afasdfadsf','https://image.shutterstock.com/image-photo/portrait-nice-attractive-lovely-positive-600w-1489157471.jpg'),(3,'sala2','sala comum','https://lumiere-a.akamaihd.net/v1/images/image_06aa7fbd.jpeg?region=0%2C0%2C540%2C810'),(4,'sala2','sala economica','https://lumiere-a.akamaihd.net/v1/images/image_06aa7fbd.jpeg?region=0%2C0%2C540%2C810'),(5,'ONE MAX','IMAX, marca líder mundial en formato amplio, sus estándares de proyección cinematográfica tienen la capacidad de grabar y mostrar imágenes de mucho mayor tamaño y resolución que cualquier otro formato.\r\n\r\nLa sala IMAX posee una pantalla gigante lo cual extiende la proyección de imágenes más allá de la visión periférica del ser humano. El sonido permite entregar una potencia digital envolvente.\r\n\r\nNuestros complejos en Avenida Escazú y Ciudad del Este cuentan con una sala IMAX, con la particularidad de que la ubicada en Curridabat fue diseñada bajo el concepto de sala híbrida: que incluye un área principal de butacas regulares tipo anfiteatro y un área VIP con asientos de cuero reclinables, y servicio de atención directo en la butaca.','https://www.adslzone.net/app/uploads-adslzone.net/2018/04/IMAXNewTheater.jpg');
/*!40000 ALTER TABLE `salas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tiquete`
--

DROP TABLE IF EXISTS `tiquete`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tiquete` (
  `id` int NOT NULL AUTO_INCREMENT,
  `usuario_id` int NOT NULL,
  `cartelera_id` int NOT NULL,
  `asiento_c` varchar(45) DEFAULT NULL,
  `asiento_p` varchar(45) DEFAULT NULL,
  `nombres` varchar(250) DEFAULT NULL,
  `apellidos` varchar(250) DEFAULT NULL,
  `email` varchar(250) DEFAULT NULL,
  `direccion` varchar(250) DEFAULT NULL,
  `total` decimal(12,2) DEFAULT NULL,
  `codigo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`,`usuario_id`,`cartelera_id`),
  KEY `FKqv8t2dloo1fhjgub60ftnpi1i` (`cartelera_id`),
  KEY `FK4y5ws1a3jslvvjmsnhfyo6nvu` (`usuario_id`),
  CONSTRAINT `FK4y5ws1a3jslvvjmsnhfyo6nvu` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`),
  CONSTRAINT `FKqv8t2dloo1fhjgub60ftnpi1i` FOREIGN KEY (`cartelera_id`) REFERENCES `cartelera` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tiquete`
--

LOCK TABLES `tiquete` WRITE;
/*!40000 ALTER TABLE `tiquete` DISABLE KEYS */;
INSERT INTO `tiquete` VALUES (2,3,3,'A1','A1','Amy','Corrales','amcg1003@gmail.com','barrio san jose',9100.00,'d0ae56e7-4733-43e3-a125-83279795b5dc'),(3,3,3,'A1','A1','Amy','Corrales','amcg1003@gmail.com','barrio san jose',9100.00,'43cc1dbd-dc87-4661-ba89-70fb8f2cb24e'),(4,2,2,'A2','A2','Juan','Fernandez','j@test.com','test test',9100.00,'ec46d278-abd9-4876-85e9-c56f625a3504'),(5,2,2,'A5','A5','Amy ','Corrales','amcg1003@gmail.com','barrio san jose',6000.00,'5e2d9e98-8de3-45c0-86b8-8a0d57e052c7'),(6,3,3,'A4','A4','ada','lara','lara@gmail.com','San Jose, escazu',6000.00,'9ca7d139-f628-4007-9e8a-05df75882c82'),(7,2,5,'F5','F5','Pedro','Mata','p@gmail.com','test test',9600.00,'5377dd72-61e2-49e1-b77c-6634eccc220f'),(8,3,5,'B3','B3','carlos ','pererz','c@gamil.com','San Jose, escazu',9600.00,'9f081ed4-178d-4140-be81-944fb6b0197b');
/*!40000 ALTER TABLE `tiquete` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tproductos`
--

DROP TABLE IF EXISTS `tproductos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tproductos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tiquete_id` int NOT NULL,
  `nombre` varchar(250) DEFAULT NULL,
  `cantidad` double DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `total` double DEFAULT NULL,
  `imagen` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`,`tiquete_id`),
  KEY `FKqs2xoyobqe77vgn46ge2ewl70` (`tiquete_id`),
  CONSTRAINT `FKqs2xoyobqe77vgn46ge2ewl70` FOREIGN KEY (`tiquete_id`) REFERENCES `tiquete` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tproductos`
--

LOCK TABLES `tproductos` WRITE;
/*!40000 ALTER TABLE `tproductos` DISABLE KEYS */;
INSERT INTO `tproductos` VALUES (1,2,'Test',1,6000,6000,'https://image.shutterstock.com/image-photo/portrait-nice-attractive-lovely-positive-600w-1489157471.jpg'),(2,2,'Palomitas Salada',1,3100,3100,'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT9ZY7t5HT5DZIUeDijCGmIhLrrZ7URWmdMww&usqp=CAU'),(3,3,'Test',1,6000,6000,'https://image.shutterstock.com/image-photo/portrait-nice-attractive-lovely-positive-600w-1489157471.jpg'),(4,3,'Palomitas Salada',1,3100,3100,'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT9ZY7t5HT5DZIUeDijCGmIhLrrZ7URWmdMww&usqp=CAU'),(5,4,'game',1,6000,6000,'https://image.shutterstock.com/image-photo/young-woman-watching-projector-tv-600w-1734341717.jpg'),(6,4,'Palomitas Salada',1,3100,3100,'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT9ZY7t5HT5DZIUeDijCGmIhLrrZ7URWmdMww&usqp=CAU'),(7,5,'game',1,6000,6000,'https://image.shutterstock.com/image-photo/young-woman-watching-projector-tv-600w-1734341717.jpg'),(8,6,'Test',1,6000,6000,'https://image.shutterstock.com/image-photo/portrait-nice-attractive-lovely-positive-600w-1489157471.jpg'),(9,7,'Dragon Ball Super Super Hero',1,5000,5000,'https://www.novacinemas.cr/wp-content/uploads/2022/07/banner_356x514_DragonBall_imax.jpg'),(10,7,'Palomitas Mixta',1,3100,3100,'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT7RoYjqXkT6twE_z_BQ6sQlo3-50a0fyk37Q&usqp=CAU'),(11,7,'Coca Cola',1,1500,1500,'https://s7d1.scene7.com/is/image/mcdonalds/t-mcdonalds-Coca-Cola-Classic-Small-1:1-3-product-tile-desktop?wid=765&hei=472&dpr=off'),(12,8,'Dragon Ball Super Super Hero',1,5000,5000,'https://www.novacinemas.cr/wp-content/uploads/2022/07/banner_356x514_DragonBall_imax.jpg'),(13,8,'Palomitas Salada',1,3100,3100,'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT9ZY7t5HT5DZIUeDijCGmIhLrrZ7URWmdMww&usqp=CAU'),(14,8,'Coca Cola',1,1500,1500,'https://s7d1.scene7.com/is/image/mcdonalds/t-mcdonalds-Coca-Cola-Classic-Small-1:1-3-product-tile-desktop?wid=765&hei=472&dpr=off');
/*!40000 ALTER TABLE `tproductos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `correo` varchar(250) NOT NULL,
  `contrasena` varchar(250) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `rol` varchar(255) DEFAULT NULL,
  `active` int DEFAULT NULL,
  `permisos` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (2,'Amy Maria corrales Garcia ','amcg@gmail.com','$2a$12$X3jD/g1UoyHzBYHTygo1L.a7mn4JH8l4zbYHQTZN94oxNzfiObZRy',NULL,'Admin',1,'Admin'),(3,'guest','guest@cineplus.com','-',NULL,'Cliente',0,'Cliente'),(4,'carla gonzales','karla@gmail,com','123',NULL,NULL,0,NULL),(5,'Marlon Acosta','m@gmail.com','testtest',NULL,NULL,0,NULL),(6,'Marlon Acosta','m@gmail.com','testtest',NULL,NULL,1,NULL),(7,'Juan Pedro','p@gmail.com','testest',NULL,NULL,1,NULL),(8,'Mario Bros','m@gmail.com','testtest',NULL,'Cliente',1,'Cliente');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-24 21:23:47
