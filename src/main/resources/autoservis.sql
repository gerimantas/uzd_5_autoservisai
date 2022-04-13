-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Apr 13, 2022 at 07:06 AM
-- Server version: 5.7.36
-- PHP Version: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `autoservis`
--

-- --------------------------------------------------------

--
-- Table structure for table `adresai`
--

DROP TABLE IF EXISTS `adresai`;
CREATE TABLE IF NOT EXISTS `adresai` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `gatve` varchar(255) DEFAULT NULL,
  `namas` bigint(20) NOT NULL,
  `pasto_kodas` bigint(20) NOT NULL,
  `autoservisai_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK18ve3s8vcx2skb1uuf3qwp07n` (`autoservisai_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `adresai`
--

INSERT INTO `adresai` (`id`, `gatve`, `namas`, `pasto_kodas`, `autoservisai_id`) VALUES
(1, 'Europos', 10, 50177, 1),
(2, 'Utenos', 11, 51222, 2),
(3, 'Pajūrio', 19, 55601, 3),
(4, 'Užupio', 2, 52010, 4),
(5, 'Ilgoji', 98, 59014, 5),
(6, 'Ukmergės', 151, 53023, 6);

-- --------------------------------------------------------

--
-- Table structure for table `autoservisai`
--

DROP TABLE IF EXISTS `autoservisai`;
CREATE TABLE IF NOT EXISTS `autoservisai` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `miestas_id` bigint(20) NOT NULL,
  `pavadinimas` varchar(255) DEFAULT NULL,
  `vadovas` varchar(255) DEFAULT NULL,
  `meistrai_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKopkr86k14hfn9i7uwg54kk8tq` (`meistrai_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `autoservisai`
--

INSERT INTO `autoservisai` (`id`, `miestas_id`, `pavadinimas`, `vadovas`, `meistrai_id`) VALUES
(1, 2, 'Kemi', 'Kostas Kubilinskas', NULL),
(2, 1, 'Melga', 'Rimas Asmenskas', NULL),
(3, 4, 'Raivinta', 'Jonas Šustauskas', NULL),
(4, 3, 'Savja', 'Zigmas Freidas', NULL),
(5, 5, 'Autobroliai', 'Josifas Majoras', NULL),
(6, 6, 'Autotoja', 'Algis Jurevicius', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `meistrai`
--

DROP TABLE IF EXISTS `meistrai`;
CREATE TABLE IF NOT EXISTS `meistrai` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `autoservisai_id` bigint(20) NOT NULL,
  `vardas_pavarde` varchar(255) DEFAULT NULL,
  `vertinimas_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2ovd9cqbqwhup9agh25mv9rxt` (`autoservisai_id`),
  KEY `FKjmarnfvf1yhl91n5e4h0rjvfa` (`vertinimas_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `meistrai`
--

INSERT INTO `meistrai` (`id`, `autoservisai_id`, `vardas_pavarde`, `vertinimas_id`) VALUES
(1, 2, 'Jonas Janavicius', NULL),
(2, 2, 'Jonas Petravicius', NULL),
(3, 4, 'Sigitas Petrauskas', NULL),
(4, 3, 'Kazys Vilimas', NULL),
(5, 5, 'Antanas Vilimas', NULL),
(6, 5, 'Petras Jonaitis', NULL),
(7, 6, 'Algis Kontrimas', NULL),
(8, 1, 'Virginijus Alekna', NULL),
(9, 1, 'Mantas Sakalauskas', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `miestai`
--

DROP TABLE IF EXISTS `miestai`;
CREATE TABLE IF NOT EXISTS `miestai` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pavadinimas` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `miestai`
--

INSERT INTO `miestai` (`id`, `pavadinimas`) VALUES
(1, 'Vilnius'),
(2, 'Kaunas'),
(3, 'Klaipeda'),
(4, 'Siauliai'),
(5, 'Panevezys'),
(6, 'Kedainiai');

-- --------------------------------------------------------

--
-- Table structure for table `specializacija`
--

DROP TABLE IF EXISTS `specializacija`;
CREATE TABLE IF NOT EXISTS `specializacija` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pavadinimas` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `specializacija`
--

INSERT INTO `specializacija` (`id`, `pavadinimas`) VALUES
(1, 'Varikliu remontas'),
(2, 'Kėbulo remontas, dažymas'),
(3, 'Elektronikos remontas'),
(4, 'Važiuoklės remontas'),
(5, 'Padangos'),
(6, 'Ratų geometrija'),
(7, 'Duju iranga');

-- --------------------------------------------------------

--
-- Table structure for table `sujungimas_autoservisai_miestai`
--

DROP TABLE IF EXISTS `sujungimas_autoservisai_miestai`;
CREATE TABLE IF NOT EXISTS `sujungimas_autoservisai_miestai` (
  `miestai_id` bigint(20) NOT NULL,
  `autoservisai_id` bigint(20) NOT NULL,
  PRIMARY KEY (`autoservisai_id`,`miestai_id`),
  KEY `FKkkpiu9nnu2ixfexljwa5v64ho` (`miestai_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sujungimas_autoservisai_miestai`
--

INSERT INTO `sujungimas_autoservisai_miestai` (`miestai_id`, `autoservisai_id`) VALUES
(1, 2),
(2, 1),
(3, 4),
(4, 3),
(5, 5),
(6, 6);

-- --------------------------------------------------------

--
-- Table structure for table `sujungimas_autoservisai_specializacija`
--

DROP TABLE IF EXISTS `sujungimas_autoservisai_specializacija`;
CREATE TABLE IF NOT EXISTS `sujungimas_autoservisai_specializacija` (
  `specializacija_id` bigint(20) NOT NULL,
  `autoservisai_id` bigint(20) NOT NULL,
  PRIMARY KEY (`autoservisai_id`,`specializacija_id`),
  KEY `FK8n6cjw9l2lka8rd3sqrqry1ir` (`specializacija_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sujungimas_autoservisai_specializacija`
--

INSERT INTO `sujungimas_autoservisai_specializacija` (`specializacija_id`, `autoservisai_id`) VALUES
(1, 1),
(2, 1),
(2, 5),
(3, 1),
(3, 4),
(4, 1),
(4, 3),
(5, 1),
(5, 3),
(6, 1),
(6, 2);

-- --------------------------------------------------------

--
-- Table structure for table `sujungimas_meistrai_specializacija`
--

DROP TABLE IF EXISTS `sujungimas_meistrai_specializacija`;
CREATE TABLE IF NOT EXISTS `sujungimas_meistrai_specializacija` (
  `specializacija_id` bigint(20) NOT NULL,
  `meistrai_id` bigint(20) NOT NULL,
  PRIMARY KEY (`specializacija_id`,`meistrai_id`),
  KEY `FK2juhf4wiceq233suk2lwo2na1` (`meistrai_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `telefonai`
--

DROP TABLE IF EXISTS `telefonai`;
CREATE TABLE IF NOT EXISTS `telefonai` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `numeris` bigint(20) NOT NULL,
  `autoservisai_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKao1d9ac8mcdbjuhy7xfnjbhog` (`autoservisai_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `telefonai`
--

INSERT INTO `telefonai` (`id`, `numeris`, `autoservisai_id`) VALUES
(1, 865521356, 1),
(2, 865521366, 1),
(3, 865521376, 2),
(4, 865521386, 2),
(5, 865521396, 3),
(6, 865521406, 4),
(7, 865521416, 5),
(8, 865521426, 6),
(9, 865521436, 6);

-- --------------------------------------------------------

--
-- Table structure for table `vartotojas`
--

DROP TABLE IF EXISTS `vartotojas`;
CREATE TABLE IF NOT EXISTS `vartotojas` (
  `id` bigint(20) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `vartotojas`
--

INSERT INTO `vartotojas` (`id`, `password`, `username`) VALUES
(1, '1111', 'Administratorius'),
(2, '2222', 'Darbuotojas'),
(3, '3333', 'Klientas1');

-- --------------------------------------------------------

--
-- Table structure for table `vartotoju_roles`
--

DROP TABLE IF EXISTS `vartotoju_roles`;
CREATE TABLE IF NOT EXISTS `vartotoju_roles` (
  `id` bigint(20) NOT NULL,
  `pavadinimas` varchar(255) DEFAULT NULL,
  `vartotojas_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1efadiu7bx6uaoq95o0iu4lv4` (`vartotojas_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `vartotoju_roles`
--

INSERT INTO `vartotoju_roles` (`id`, `pavadinimas`, `vartotojas_id`) VALUES
(1, 'admin', 1),
(2, 'darbuotojas', 2),
(3, 'klientas', 3);

-- --------------------------------------------------------

--
-- Table structure for table `vertinimas`
--

DROP TABLE IF EXISTS `vertinimas`;
CREATE TABLE IF NOT EXISTS `vertinimas` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `balas` int(11) NOT NULL,
  `data` date DEFAULT NULL,
  `komentaras` varchar(255) DEFAULT NULL,
  `meistrai_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `adresai`
--
ALTER TABLE `adresai`
  ADD CONSTRAINT `FK18ve3s8vcx2skb1uuf3qwp07n` FOREIGN KEY (`autoservisai_id`) REFERENCES `autoservisai` (`id`);

--
-- Constraints for table `autoservisai`
--
ALTER TABLE `autoservisai`
  ADD CONSTRAINT `FKopkr86k14hfn9i7uwg54kk8tq` FOREIGN KEY (`meistrai_id`) REFERENCES `meistrai` (`id`);

--
-- Constraints for table `meistrai`
--
ALTER TABLE `meistrai`
  ADD CONSTRAINT `FK2ovd9cqbqwhup9agh25mv9rxt` FOREIGN KEY (`autoservisai_id`) REFERENCES `autoservisai` (`id`),
  ADD CONSTRAINT `FKjmarnfvf1yhl91n5e4h0rjvfa` FOREIGN KEY (`vertinimas_id`) REFERENCES `vertinimas` (`id`);

--
-- Constraints for table `sujungimas_autoservisai_miestai`
--
ALTER TABLE `sujungimas_autoservisai_miestai`
  ADD CONSTRAINT `FKgeksey073h024q4epnvmmunf7` FOREIGN KEY (`autoservisai_id`) REFERENCES `miestai` (`id`),
  ADD CONSTRAINT `FKk5myxwatbqg5hnrkqpcg4jijh` FOREIGN KEY (`autoservisai_id`) REFERENCES `autoservisai` (`id`),
  ADD CONSTRAINT `FKkkpiu9nnu2ixfexljwa5v64ho` FOREIGN KEY (`miestai_id`) REFERENCES `miestai` (`id`);

--
-- Constraints for table `sujungimas_autoservisai_specializacija`
--
ALTER TABLE `sujungimas_autoservisai_specializacija`
  ADD CONSTRAINT `FK8n6cjw9l2lka8rd3sqrqry1ir` FOREIGN KEY (`specializacija_id`) REFERENCES `specializacija` (`id`),
  ADD CONSTRAINT `FKt81usrd2mkoa8xkdwoxxdqyrt` FOREIGN KEY (`autoservisai_id`) REFERENCES `autoservisai` (`id`);

--
-- Constraints for table `sujungimas_meistrai_specializacija`
--
ALTER TABLE `sujungimas_meistrai_specializacija`
  ADD CONSTRAINT `FK2juhf4wiceq233suk2lwo2na1` FOREIGN KEY (`meistrai_id`) REFERENCES `meistrai` (`id`),
  ADD CONSTRAINT `FKj449ufvxt1v2p07s02e78qd7q` FOREIGN KEY (`meistrai_id`) REFERENCES `specializacija` (`id`),
  ADD CONSTRAINT `FKj8n894ce8hevs0xojqtawdlyh` FOREIGN KEY (`specializacija_id`) REFERENCES `meistrai` (`id`),
  ADD CONSTRAINT `FKsa1rkwkksxgk2popqiaf2soa7` FOREIGN KEY (`specializacija_id`) REFERENCES `specializacija` (`id`);

--
-- Constraints for table `telefonai`
--
ALTER TABLE `telefonai`
  ADD CONSTRAINT `FKao1d9ac8mcdbjuhy7xfnjbhog` FOREIGN KEY (`autoservisai_id`) REFERENCES `autoservisai` (`id`);

--
-- Constraints for table `vartotoju_roles`
--
ALTER TABLE `vartotoju_roles`
  ADD CONSTRAINT `FK1efadiu7bx6uaoq95o0iu4lv4` FOREIGN KEY (`vartotojas_id`) REFERENCES `vartotojas` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
