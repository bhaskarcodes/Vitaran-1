-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 03, 2017 at 09:57 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `vitaran`
--

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE IF NOT EXISTS `category` (
  `categoryID` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`categoryID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`categoryID`, `name`) VALUES
(1, 'Food'),
(4, 'Cutlery'),
(7, 'beverages');

-- --------------------------------------------------------

--
-- Table structure for table `donation`
--

CREATE TABLE IF NOT EXISTS `donation` (
  `DonationID` int(10) NOT NULL AUTO_INCREMENT,
  `Date` date NOT NULL,
  `DonorID` int(10) NOT NULL,
  `Location` varchar(50) NOT NULL,
  `ItemID` int(10) NOT NULL,
  `Details` varchar(50) NOT NULL,
  `CategoryID` int(10) NOT NULL,
  PRIMARY KEY (`DonationID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `donation`
--

INSERT INTO `donation` (`DonationID`, `Date`, `DonorID`, `Location`, `ItemID`, `Details`, `CategoryID`) VALUES
(1, '2017-05-01', 21, 'keshtopur', 32, '', 0),
(3, '2017-05-01', 21, 'keshtopur', 2, 'hello vitaran', 23);

-- --------------------------------------------------------

--
-- Table structure for table `donoritem`
--

CREATE TABLE IF NOT EXISTS `donoritem` (
  `ItemID` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `category` varchar(20) NOT NULL,
  `quantity` int(10) NOT NULL,
  `unit` varchar(10) NOT NULL,
  PRIMARY KEY (`ItemID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `donoritem`
--

INSERT INTO `donoritem` (`ItemID`, `name`, `category`, `quantity`, `unit`) VALUES
(1, 'noodles', 'food', 2, 'units'),
(2, 'brown rice', 'food', 5, 'Kg');

-- --------------------------------------------------------

--
-- Table structure for table `items`
--

CREATE TABLE IF NOT EXISTS `items` (
  `ItemID` int(10) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) NOT NULL,
  `Quantity` int(10) unsigned NOT NULL,
  `Unit` varchar(10) NOT NULL,
  PRIMARY KEY (`ItemID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=23 ;

--
-- Dumping data for table `items`
--

INSERT INTO `items` (`ItemID`, `Name`, `Quantity`, `Unit`) VALUES
(11, 'Brown rice', 5, 'Kg'),
(18, 'Detergent', 2, 'units'),
(19, 'Rice', 43, 'kg'),
(20, 'Rice', 34, 'kg'),
(21, 'Pulses', 43, 'kg'),
(22, 'pepsi', 5, 'units');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
