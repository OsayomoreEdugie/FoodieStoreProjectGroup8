-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: foodiestore
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `meals`
--

DROP TABLE IF EXISTS `meals`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `meals` (
  `name` varchar(45) NOT NULL,
  `price` double NOT NULL,
  `Quantity` int(11) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meals`
--

LOCK TABLES `meals` WRITE;
/*!40000 ALTER TABLE `meals` DISABLE KEYS */;
/*!40000 ALTER TABLE `meals` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `orderId` int(11) NOT NULL AUTO_INCREMENT,
  `customerName` varchar(45) NOT NULL,
  `Date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `amountPay` varchar(20) NOT NULL,
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'zain@gmail.com','2020-05-23 23:23:54','90.0'),(2,'zain@gmail.com','2020-05-23 23:25:26','270.0'),(3,'zain@gmail.com','2020-05-25 00:22:02','6210.0'),(4,'zain@gmail.com','2020-05-25 00:25:05','1980.0'),(5,'zaid@gmail.com','2020-05-25 15:36:00','90.0'),(6,'zaid@gmail.com','2020-05-25 15:37:11','480.0'),(7,'abd@gmail.com','2020-05-28 16:25:07','90.0'),(8,'paul@gmail.com','2020-05-31 01:47:48','390.0');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `NAME` varchar(45) NOT NULL,
  `PRICE` varchar(20) NOT NULL,
  `TYPE` varchar(45) NOT NULL,
  `AMMOUNT` varchar(45) NOT NULL,
  PRIMARY KEY (`NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES ('7up','10','Soft Drink','10'),('American Pizza','10','Pizza','0'),('Chicken Burger','90','Burger','184'),('Chicken Pizza','90','Pizza','0'),('Coke','10','Soft Drink','120'),('Cola Zero','10','Soft Drink','200'),('Crush Lime','10','Soft Drink','200'),('Fanta','10','Soft Drink','100'),('Loka','10','Soft Drink','200'),('null','','null',''),('Pepperroni Pizza','100','Pizza','197'),('Pepsi','10','Soft Drink','200'),('Power Burger','90','Burger','160'),('Sandwich Burger','90','Burger','188'),('Sprite','10','Soft Drink','160'),('Veg Burger','90','Burger','196'),('Veg Pizza','10','Pizza','7');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `firstName` varchar(20) NOT NULL,
  `lastName` varchar(20) NOT NULL,
  `birthday` date NOT NULL,
  `userName` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `email` varchar(45) NOT NULL,
  `phoneNumber` varchar(20) NOT NULL,
  `type` varchar(20) NOT NULL DEFAULT 'Customer',
  `street` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  `zipcode` int(11) NOT NULL,
  PRIMARY KEY (`email`),
  UNIQUE KEY `userName_UNIQUE` (`userName`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('Abdullah ','Butt','2020-05-01','abd1122','abdbutt1122','abd@gmail.com','0046123212345','customer','Street no 1','Malmö',123123),('Ahmad','barsar','2020-05-07','ahmad','ahmad1122','ahamd@gmail.com','0046123456543','customer','Street No 35','Kristianstad',2121),('Muhammad','ali','2020-05-01','mirza','ali12345','ali@gmail.com','0048123456789','customer','CHAK NO 335','Kristianstad',23432),('ansfldan','falsjdfl','2020-05-01','faldfjl','jfl32422','flasjldfjasljfl@gmail.com','0046123432345','customer','jfl','Malmö',2131),('Muhammad ','Haneef','2020-05-06','khan','haneef1122','haneef@gmail.com','0046123454321','customer','Street 1','Kristianstad',13123),('paul','jane','2020-04-28','jan123','jane1234','jane123@gmail.com','0046123456548','customer','no 33 jane nfg','Kristianstad',45777),('kelvin','little','2017-05-16','Kelvin23','kelvin123','Kelvin@gmail.com','0048123456783','customer','No 4 street','Malmö',2345),('peter','paul','2020-05-13','pau12','paul12345','paul@gmail.com','0046123456543','customer','No 12 ewanbore','Kristianstad',1234),('philip','Edu','2020-05-21','pli22','plip12345','pli@gmail.com','0048123456789','customer','No 5 street','Kristianstad',12345),('MUHAMMAD ','rafi','2020-04-30','rafi','rafi1122','rafi@gmail.com','0048123456543','customer','Sterrt 332','Kristianstad',2342),('Sandra','John','2020-05-05','sandra1233','sandra1234','sandra@gmail.com','0046123456548','customer','no vmakes','Kristianstad',123456),('waleed','rafi','2020-05-02','waleed','waleedrafi19','waleed@gmail.com','0046123232388','customer','street no 1','Malmö',32431),('zain','ali','1999-05-25','zain_335','ericssonk750','xadevil335@gmail.com','0046123456890','customer','street no 1 chak # 335','Kristianstad',12321),('zaid','ali','2020-05-13','zaid','zaidali335','zaid@gmail.com','0046987654566','customer','Street 2 ttd','Malmö',24234);
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

-- Dump completed on 2020-05-31 14:21:08
