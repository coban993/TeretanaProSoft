-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 01, 2023 at 02:30 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sofrveriprojekat`
--

-- --------------------------------------------------------

--
-- Table structure for table `plantreninga`
--

CREATE TABLE `plantreninga` (
  `treningID` int(10) NOT NULL,
  `nazivTreninga` varchar(50) DEFAULT NULL,
  `svrhaTreninga` varchar(50) DEFAULT NULL,
  `duzinaTrajanja` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `plantreninga`
--

INSERT INTO `plantreninga` (`treningID`, `nazivTreninga`, `svrhaTreninga`, `duzinaTrajanja`) VALUES
(21, 'SBD!', 'sbd trening!', 120),
(22, 'probniasdasdasdas', 'probni3', 12000),
(24, 'aaa', 'aaa', 111),
(29, 'trening', 'trening', 120),
(30, 'bbb', 'bbb', 222),
(31, 'Deload123', 'oporavak123', 601);

-- --------------------------------------------------------

--
-- Table structure for table `sprava`
--

CREATE TABLE `sprava` (
  `spravaID` int(10) NOT NULL,
  `naziv` varchar(50) DEFAULT NULL,
  `namena` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sprava`
--

INSERT INTO `sprava` (`spravaID`, `naziv`, `namena`) VALUES
(1, 'bench press', 'grudi'),
(2, 'kosi bench', 'grudi'),
(3, 'sucanj', 'noge'),
(4, 'mrtvo dizanje', 'donja ledja'),
(5, 'Propadanja', 'triceps/grudi');

-- --------------------------------------------------------

--
-- Table structure for table `stavkaplanatreninga`
--

CREATE TABLE `stavkaplanatreninga` (
  `treningID` int(10) NOT NULL,
  `rbStavke` int(10) NOT NULL,
  `brojSerija` int(10) DEFAULT NULL,
  `brojPonavljanja` int(10) DEFAULT NULL,
  `duzinaOdmora` int(10) DEFAULT NULL,
  `opisVezbe` varchar(50) DEFAULT NULL,
  `spravaID` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `stavkaplanatreninga`
--

INSERT INTO `stavkaplanatreninga` (`treningID`, `rbStavke`, `brojSerija`, `brojPonavljanja`, `duzinaOdmora`, `opisVezbe`, `spravaID`) VALUES
(21, 1, 5, 5, 5, '  pauzirani benc', 1),
(21, 2, 3, 3, 7, '  tempo cucanj', 3),
(21, 3, 3, 2, 10, '  tempo cucanj', 4),
(22, 1, 11, 11, 11, '    probna', 1),
(29, 1, 11, 11, 11, ' opis1', 1),
(29, 2, 22, 22, 22, ' opis2', 2),
(29, 3, 33, 33, 33, ' opis3', 3),
(29, 4, 44, 44, 44, ' opis4', 4),
(31, 1, 33, 3, 3, '  Razvijanje donjih grudi', 5);

-- --------------------------------------------------------

--
-- Table structure for table `trener`
--

CREATE TABLE `trener` (
  `trenerID` int(10) NOT NULL,
  `ime` varchar(50) DEFAULT NULL,
  `prezime` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `lozinka` varchar(50) DEFAULT NULL,
  `ulogovan` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `trener`
--

INSERT INTO `trener` (`trenerID`, `ime`, `prezime`, `email`, `lozinka`, `ulogovan`) VALUES
(1, 'jovan', 'jovan', 'jovan', 'jovan', 1),
(2, 'jovan1', 'asdas', 'jovan1', 'jovan1', 0);

-- --------------------------------------------------------

--
-- Table structure for table `trenutniplantreninga`
--

CREATE TABLE `trenutniplantreninga` (
  `treningID` int(10) NOT NULL,
  `vezbacID` int(10) NOT NULL,
  `status` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `trenutniplantreninga`
--

INSERT INTO `trenutniplantreninga` (`treningID`, `vezbacID`, `status`) VALUES
(21, 9, 'novemabr/decembar'),
(22, 9, 'probni'),
(29, 8, 'trening'),
(30, 2, 'aaa'),
(31, 10, 'Svaka prva nedelja u planu');

-- --------------------------------------------------------

--
-- Table structure for table `vezbac`
--

CREATE TABLE `vezbac` (
  `vezbacID` int(10) NOT NULL,
  `ime` varchar(50) DEFAULT NULL,
  `prezime` varchar(50) DEFAULT NULL,
  `adresa` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `vezbac`
--

INSERT INTO `vezbac` (`vezbacID`, `ime`, `prezime`, `adresa`) VALUES
(1, 'Mihajlo', 'Nisavic', 'Konjarnik Rudo'),
(2, 'Mikarica', 'MIkic', 'Medak'),
(8, 'Andrej13', 'Jokic13', 'Novi Beograd nbgdw'),
(9, 'Danilo ', 'Popovic', 'Olimp2'),
(10, 'Petar', 'Petrovic', 'Cara Dusana 12');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `plantreninga`
--
ALTER TABLE `plantreninga`
  ADD PRIMARY KEY (`treningID`);

--
-- Indexes for table `sprava`
--
ALTER TABLE `sprava`
  ADD PRIMARY KEY (`spravaID`);

--
-- Indexes for table `stavkaplanatreninga`
--
ALTER TABLE `stavkaplanatreninga`
  ADD PRIMARY KEY (`treningID`,`rbStavke`),
  ADD KEY `fk_sprava` (`spravaID`);

--
-- Indexes for table `trener`
--
ALTER TABLE `trener`
  ADD PRIMARY KEY (`trenerID`);

--
-- Indexes for table `trenutniplantreninga`
--
ALTER TABLE `trenutniplantreninga`
  ADD PRIMARY KEY (`treningID`,`vezbacID`);

--
-- Indexes for table `vezbac`
--
ALTER TABLE `vezbac`
  ADD PRIMARY KEY (`vezbacID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `plantreninga`
--
ALTER TABLE `plantreninga`
  MODIFY `treningID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT for table `sprava`
--
ALTER TABLE `sprava`
  MODIFY `spravaID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `trener`
--
ALTER TABLE `trener`
  MODIFY `trenerID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `vezbac`
--
ALTER TABLE `vezbac`
  MODIFY `vezbacID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `stavkaplanatreninga`
--
ALTER TABLE `stavkaplanatreninga`
  ADD CONSTRAINT `fk_sprava` FOREIGN KEY (`SpravaID`) REFERENCES `sprava` (`spravaID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
