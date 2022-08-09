-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Aug 02, 2022 at 09:32 PM
-- Server version: 10.5.12-MariaDB-cll-lve
-- PHP Version: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `u355634419_autoservis`
--

-- --------------------------------------------------------

--
-- Table structure for table `adresai`
--

CREATE TABLE `adresai` (
  `id` bigint(20) NOT NULL,
  `gatve` varchar(255) DEFAULT NULL,
  `namas` bigint(20) NOT NULL,
  `pasto_kodas` bigint(20) NOT NULL,
  `autoservisai_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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

CREATE TABLE `autoservisai` (
  `id` bigint(20) NOT NULL,
  `pavadinimas` varchar(255) DEFAULT NULL,
  `vadovas` varchar(255) DEFAULT NULL,
  `meistrai_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `autoservisai`
--

INSERT INTO `autoservisai` (`id`, `pavadinimas`, `vadovas`, `meistrai_id`) VALUES
(1, 'LALA dar karta pataisytas', 'ABC-xxxxx', NULL),
(2, 'Melga3', 'Rimas Asmenskas3', NULL),
(3, 'Raivinta2', 'Jonas Šustauskas2', NULL),
(4, 'Savja', 'Zigmas Freidas', NULL),
(5, 'Autobroliai', 'Josifas Majoras', NULL),
(6, 'Autotoja', 'Algis Jurevicius', NULL),
(25, 'Paradas', 'Tamas Tamas', NULL),
(26, 'Paradas5', 'vadas7', NULL),
(27, 'ABC', 'Jonas Janavicius', NULL),
(28, '2022-0627', 'Vadovas 27', NULL),
(29, '2022-0727', 'Liepos27', NULL),
(30, '2022-0727', 'Liepos27', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
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

CREATE TABLE `meistrai` (
  `id` bigint(20) NOT NULL,
  `autoservisai_id` bigint(20) NOT NULL,
  `vardas_pavarde` varchar(255) DEFAULT NULL,
  `vertinimas_id` bigint(20) DEFAULT NULL,
  `meistro_vertinimas` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `meistrai`
--

INSERT INTO `meistrai` (`id`, `autoservisai_id`, `vardas_pavarde`, `vertinimas_id`, `meistro_vertinimas`) VALUES
(1, 2, 'Jonas Janavicius', NULL, NULL),
(2, 2, 'Jonas Petravicius', NULL, NULL),
(3, 4, 'Sigitas Petrauskas', NULL, NULL),
(4, 3, 'Kazys Vilimas', NULL, NULL),
(5, 5, 'Antanas Vilimas', NULL, NULL),
(6, 5, 'Petras Jonaitis', NULL, NULL),
(7, 6, 'Algis Kontrimas', NULL, NULL),
(8, 1, 'Virginijus Alekna', NULL, NULL),
(9, 1, 'Mantas Sakalauskas', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `miestai`
--

CREATE TABLE `miestai` (
  `id` bigint(20) NOT NULL,
  `pavadinimas` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
-- Table structure for table `privilegijos`
--

CREATE TABLE `privilegijos` (
  `id` tinyint(1) UNSIGNED NOT NULL,
  `name` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `privilegijos`
--

INSERT INTO `privilegijos` (`id`, `name`) VALUES
(1, 'vadovas'),
(2, 'administratorius'),
(3, 'meistras'),
(4, 'klientas'),
(5, 'svecias');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
(1, 'admin'),
(2, 'creator'),
(3, 'editor'),
(4, 'user');

-- --------------------------------------------------------

--
-- Table structure for table `specializacija`
--

CREATE TABLE `specializacija` (
  `id` bigint(20) NOT NULL,
  `pavadinimas` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
(7, 'Duju iranga'),
(8, 'Kompiuterine diagnostika');

-- --------------------------------------------------------

--
-- Table structure for table `sujungimas_autoservisai_miestai`
--

CREATE TABLE `sujungimas_autoservisai_miestai` (
  `miestai_id` bigint(20) NOT NULL,
  `autoservisai_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sujungimas_autoservisai_miestai`
--

INSERT INTO `sujungimas_autoservisai_miestai` (`miestai_id`, `autoservisai_id`) VALUES
(3, 4),
(5, 5),
(6, 6),
(1, 25),
(1, 27),
(2, 28),
(1, 29),
(1, 30);

-- --------------------------------------------------------

--
-- Table structure for table `sujungimas_autoservisai_specializacija`
--

CREATE TABLE `sujungimas_autoservisai_specializacija` (
  `specializacija_id` bigint(20) NOT NULL,
  `autoservisai_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sujungimas_autoservisai_specializacija`
--

INSERT INTO `sujungimas_autoservisai_specializacija` (`specializacija_id`, `autoservisai_id`) VALUES
(1, 1),
(3, 4),
(2, 5),
(7, 5),
(6, 6),
(8, 6),
(1, 25),
(1, 27),
(1, 28),
(5, 29),
(5, 30);

-- --------------------------------------------------------

--
-- Table structure for table `sujungimas_meistrai_specializacija`
--

CREATE TABLE `sujungimas_meistrai_specializacija` (
  `specializacija_id` bigint(20) NOT NULL,
  `meistrai_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sujungimas_meistrai_specializacija`
--

INSERT INTO `sujungimas_meistrai_specializacija` (`specializacija_id`, `meistrai_id`) VALUES
(1, 8),
(2, 5),
(2, 9),
(3, 3),
(4, 4),
(6, 1),
(6, 2),
(6, 7),
(7, 6),
(8, 4);

-- --------------------------------------------------------

--
-- Table structure for table `telefonai`
--

CREATE TABLE `telefonai` (
  `id` bigint(20) NOT NULL,
  `numeris` bigint(20) NOT NULL,
  `autoservisai_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
-- Table structure for table `users_roles`
--

CREATE TABLE `users_roles` (
  `vartotojo_id` bigint(20) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `vartotojas`
--

CREATE TABLE `vartotojas` (
  `id` bigint(20) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `enabled` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `vartotojas`
--

INSERT INTO `vartotojas` (`id`, `password`, `username`, `enabled`) VALUES
(1, '1111', 'Administratorius', b'0'),
(2, '2222', 'Darbuotojas', b'0'),
(3, '3333', 'Klientas1', b'0'),
(0, NULL, NULL, b'0'),
(0, 'grmt123', 'grmt', b'0');

-- --------------------------------------------------------

--
-- Table structure for table `vartotoju_roles`
--

CREATE TABLE `vartotoju_roles` (
  `id` bigint(20) NOT NULL,
  `pavadinimas` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `vartotojas_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `vartotoju_vertinimai`
--

CREATE TABLE `vartotoju_vertinimai` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `vartotojo_id` bigint(20) UNSIGNED DEFAULT NULL,
  `vertinimas_id` bigint(20) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `vertinimas`
--

CREATE TABLE `vertinimas` (
  `id` bigint(20) NOT NULL,
  `balas` int(11) NOT NULL,
  `data` date DEFAULT NULL,
  `komentaras` varchar(255) DEFAULT NULL,
  `meistrai_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `vertinimas`
--

INSERT INTO `vertinimas` (`id`, `balas`, `data`, `komentaras`, `meistrai_id`) VALUES
(1, 2, '2022-05-18', 'Yahoo', 1),
(2, 4, '2022-05-02', 'Yahoo2', 1),
(3, 4, '2022-05-02', 'Yahoo3', 1),
(4, 5, '2022-05-03', 'Yahoo5', 1),
(5, 5, '2022-05-05', 'Yahoo6', 1),
(6, 5, '2022-05-06', 'Komentaras 1 2-o meistro', 2),
(7, 2, '2022-05-07', '4-0 meistro komentaras', 4);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `adresai`
--
ALTER TABLE `adresai`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK18ve3s8vcx2skb1uuf3qwp07n` (`autoservisai_id`);

--
-- Indexes for table `autoservisai`
--
ALTER TABLE `autoservisai`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKopkr86k14hfn9i7uwg54kk8tq` (`meistrai_id`);

--
-- Indexes for table `meistrai`
--
ALTER TABLE `meistrai`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `miestai`
--
ALTER TABLE `miestai`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `privilegijos`
--
ALTER TABLE `privilegijos`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `specializacija`
--
ALTER TABLE `specializacija`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sujungimas_autoservisai_miestai`
--
ALTER TABLE `sujungimas_autoservisai_miestai`
  ADD PRIMARY KEY (`autoservisai_id`,`miestai_id`),
  ADD KEY `FKgeksey073h024q4epnvmmunf7` (`miestai_id`);

--
-- Indexes for table `sujungimas_autoservisai_specializacija`
--
ALTER TABLE `sujungimas_autoservisai_specializacija`
  ADD PRIMARY KEY (`autoservisai_id`,`specializacija_id`),
  ADD KEY `FK8n6cjw9l2lka8rd3sqrqry1ir` (`specializacija_id`);

--
-- Indexes for table `sujungimas_meistrai_specializacija`
--
ALTER TABLE `sujungimas_meistrai_specializacija`
  ADD PRIMARY KEY (`specializacija_id`,`meistrai_id`),
  ADD KEY `FK2juhf4wiceq233suk2lwo2na1` (`meistrai_id`);

--
-- Indexes for table `telefonai`
--
ALTER TABLE `telefonai`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKao1d9ac8mcdbjuhy7xfnjbhog` (`autoservisai_id`);

--
-- Indexes for table `users_roles`
--
ALTER TABLE `users_roles`
  ADD PRIMARY KEY (`vartotojo_id`,`role_id`);

--
-- Indexes for table `vartotoju_roles`
--
ALTER TABLE `vartotoju_roles`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `vartotoju_vertinimai`
--
ALTER TABLE `vartotoju_vertinimai`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `vertinimas`
--
ALTER TABLE `vertinimas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKhsrsqf6e7b8f8pme63jad8pra` (`meistrai_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `adresai`
--
ALTER TABLE `adresai`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `autoservisai`
--
ALTER TABLE `autoservisai`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `meistrai`
--
ALTER TABLE `meistrai`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `miestai`
--
ALTER TABLE `miestai`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `privilegijos`
--
ALTER TABLE `privilegijos`
  MODIFY `id` tinyint(1) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `specializacija`
--
ALTER TABLE `specializacija`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `telefonai`
--
ALTER TABLE `telefonai`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `vartotoju_vertinimai`
--
ALTER TABLE `vartotoju_vertinimai`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `vertinimas`
--
ALTER TABLE `vertinimas`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

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
-- Constraints for table `sujungimas_autoservisai_miestai`
--
ALTER TABLE `sujungimas_autoservisai_miestai`
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
  ADD CONSTRAINT `FKsa1rkwkksxgk2popqiaf2soa7` FOREIGN KEY (`specializacija_id`) REFERENCES `specializacija` (`id`);

--
-- Constraints for table `telefonai`
--
ALTER TABLE `telefonai`
  ADD CONSTRAINT `FKao1d9ac8mcdbjuhy7xfnjbhog` FOREIGN KEY (`autoservisai_id`) REFERENCES `autoservisai` (`id`);

--
-- Constraints for table `vertinimas`
--
ALTER TABLE `vertinimas`
  ADD CONSTRAINT `FKhsrsqf6e7b8f8pme63jad8pra` FOREIGN KEY (`meistrai_id`) REFERENCES `meistrai` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;