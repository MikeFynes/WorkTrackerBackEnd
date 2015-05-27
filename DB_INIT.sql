-- phpMyAdmin SQL Dump
-- version 4.3.10
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 05, 2015 at 06:47 PM
-- Server version: 5.5.42
-- PHP Version: 5.4.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `michaef`
--

-- --------------------------------------------------------

--
-- Table structure for table `AA_project_challenges`
--

--
-- Table structure for table `codes`
--

CREATE TABLE IF NOT EXISTS `codes` (
  `ID` varchar(15) NOT NULL,
  `EMPLOYEE` int(11) NOT NULL,
  `WIFI` char(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE IF NOT EXISTS `employee` (
  `ID` int(11) NOT NULL,
  `FNAME` char(25) DEFAULT NULL,
  `LNAME` char(25) DEFAULT NULL,
  `ROLE` int(11) DEFAULT NULL,
  `SUPERVISOR` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;



-- --------------------------------------------------------

--
-- Table structure for table `permissionlevel`
--

CREATE TABLE IF NOT EXISTS `permissionlevel` (
  `ID` int(11) NOT NULL,
  `NAME` char(25) DEFAULT NULL,
  `DESCRIPTION` char(100) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;



-- --------------------------------------------------------

--
-- Table structure for table `trackingtype`
--

CREATE TABLE IF NOT EXISTS `trackingtype` (
  `ID` int(11) NOT NULL,
  `NAME` char(25) DEFAULT NULL,
  `DESCRIPTION` char(100) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;



-- --------------------------------------------------------

--
-- Table structure for table `worktime`
--

CREATE TABLE IF NOT EXISTS `worktime` (
  `ID` bigint(40) NOT NULL,
  `EMPLOYEE` int(11) DEFAULT NULL,
  `TRACKINGTYPE` int(11) DEFAULT NULL,
  `STARTTIME` bigint(20) DEFAULT NULL,
  `ENDTIME` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Indexes for dumped tables
--

--
-- Indexes for table `AA_project_challenges`
--
ALTER TABLE `AA_project_challenges`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `AA_project_users`
--
ALTER TABLE `AA_project_users`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `codes`
--
ALTER TABLE `codes`
  ADD PRIMARY KEY (`ID`), ADD KEY `EMPLOYEE` (`EMPLOYEE`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`ID`), ADD KEY `ROLE` (`ROLE`), ADD KEY `SUPERVISOR` (`SUPERVISOR`);

--
-- Indexes for table `permissionlevel`
--
ALTER TABLE `permissionlevel`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `trackingtype`
--
ALTER TABLE `trackingtype`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `worktime`
--
ALTER TABLE `worktime`
  ADD PRIMARY KEY (`ID`), ADD KEY `EMPLOYEE` (`EMPLOYEE`), ADD KEY `TRACKINGTYPE` (`TRACKINGTYPE`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `AA_project_challenges`
--
ALTER TABLE `AA_project_challenges`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `AA_project_users`
--
ALTER TABLE `AA_project_users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `permissionlevel`
--
ALTER TABLE `permissionlevel`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `trackingtype`
--
ALTER TABLE `trackingtype`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `codes`
--
ALTER TABLE `codes`
ADD CONSTRAINT `codes_ibfk_1` FOREIGN KEY (`EMPLOYEE`) REFERENCES `employee` (`ID`);

--
-- Constraints for table `employee`
--
ALTER TABLE `employee`
ADD CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`ROLE`) REFERENCES `permissionlevel` (`ID`),
ADD CONSTRAINT `employee_ibfk_2` FOREIGN KEY (`SUPERVISOR`) REFERENCES `employee` (`ID`);

--
-- Constraints for table `worktime`
--
ALTER TABLE `worktime`
ADD CONSTRAINT `worktime_ibfk_1` FOREIGN KEY (`TRACKINGTYPE`) REFERENCES `trackingtype` (`ID`),
ADD CONSTRAINT `worktime_ibfk_2` FOREIGN KEY (`EMPLOYEE`) REFERENCES `employee` (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
