-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Apr 05, 2022 at 09:42 AM
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
  `vardas_pavarde` varchar(255) DEFAULT NULL,
  `autoservisas_id` bigint(20) NOT NULL,
  `ivertinimas_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `meistrai`
--

INSERT INTO `meistrai` (`id`, `vardas_pavarde`, `autoservisas_id`, `ivertinimas_id`) VALUES
(19, 'Jonas Janavicius', 2, 1),
(20, 'Jonas Petravicius', 2, 2),
(21, 'Sigitas Petrauskas', 4, 3),
(22, 'Kazys Vilimas', 3, 4),
(23, 'Antanas Vilimas', 5, 5),
(24, 'Petras Jonaitis', 5, 6),
(25, 'Algis Kontrimas', 6, 7),
(26, 'Virginijus Alekna', 1, 8),
(27, 'Mantas Sakalauskas', 1, 9);

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `specializacija`
--

INSERT INTO `specializacija` (`id`, `pavadinimas`) VALUES
(1, 'Varikliu remontas'),
(2, 'Kėbulo remontas, dažymas'),
(3, 'Elektronikos remontas'),
(4, 'Važiuoklės remontas'),
(5, 'Padadangos'),
(6, 'Ratų geometrija');

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
-- Table structure for table `vartotojas`
--

DROP TABLE IF EXISTS `vartotojas`;
CREATE TABLE IF NOT EXISTS `vartotojas` (
  `id` bigint(20) NOT NULL,
  `passsword` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `autoservisai`
--
ALTER TABLE `autoservisai`
  ADD CONSTRAINT `FKopkr86k14hfn9i7uwg54kk8tq` FOREIGN KEY (`meistrai_id`) REFERENCES `meistrai` (`id`);

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
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
