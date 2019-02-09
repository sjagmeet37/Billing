-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Feb 08, 2019 at 11:41 PM
-- Server version: 5.7.19
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bill`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer_credit`
--

DROP TABLE IF EXISTS `customer_credit`;
CREATE TABLE IF NOT EXISTS `customer_credit` (
  `customer_id` int(11) NOT NULL,
  `invoice_id` int(11) NOT NULL,
  `bill_amount` float NOT NULL,
  `previous_balance` float NOT NULL,
  `updated_balance` float NOT NULL,
  `amount_debited` float NOT NULL,
  `date` varchar(10) NOT NULL,
  PRIMARY KEY (`customer_id`,`invoice_id`),
  KEY `invoice_id` (`invoice_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer_credit`
--

INSERT INTO `customer_credit` (`customer_id`, `invoice_id`, `bill_amount`, `previous_balance`, `updated_balance`, `amount_debited`, `date`) VALUES
(1, 21, 10000, 0, 10000, 0, '15/09/2017'),
(1, 22, 2000, 0, 2000, 0, '15/09/2017'),
(1, 24, 2000, 0, 2000, 0, '11/09/2017'),
(1, 25, 5000, 0, 5000, 0, '07/09/2017'),
(1, 26, 5000, 0, 5000, 0, '12/09/2017'),
(1, 27, 1000, 5000, 6000, 0, '12/09/2017'),
(3, 19, 7000, 0, 7000, 0, '15/09/2017');

-- --------------------------------------------------------

--
-- Table structure for table `customer_details`
--

DROP TABLE IF EXISTS `customer_details`;
CREATE TABLE IF NOT EXISTS `customer_details` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `father_name` varchar(45) NOT NULL,
  `address` varchar(100) NOT NULL,
  `city` varchar(40) NOT NULL,
  `state` varchar(30) NOT NULL,
  `mobile_no` varchar(10) NOT NULL,
  `email` varchar(30) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer_details`
--

INSERT INTO `customer_details` (`customer_id`, `name`, `father_name`, `address`, `city`, `state`, `mobile_no`, `email`, `date`) VALUES
(1, 'singh', 'singh', 'every where', 'jalandhar', 'Punjab', '1234567890', '', '2017-08-16 19:01:32'),
(2, 'jagmeet sandhu', 'sarbjit singh', 'gndu', 'asr', 'Punjab', '9872953303', 'sjagmeet37@gmail.com', '2017-08-16 19:03:19'),
(3, 'harman', 'avtar', 'asb', 'asr', 'Punjab', '1122334455', '', '2017-08-17 18:02:54'),
(4, 'abc', 'xzy', 'appe pata karo', 'london', 'Punjab', '1234567890', '', '2017-08-19 10:42:03'),
(5, 'maharaj', 'ji', 'niwasi aligarh', 'cooran wali', 'Punjab', '1010101010', 'qqweqw@fgff.cd', '2017-10-09 17:54:27'),
(6, 'fhsfhdh', 'dfhshgf', 'fgshshgfh', 'sghsghsfh', 'Punjab', '6784375658', 'sdhgfjg@xyz.com', '2018-01-06 10:21:25');

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
CREATE TABLE IF NOT EXISTS `invoice` (
  `invoice_id` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `manufacturer` varchar(40) NOT NULL,
  `unit_price` float NOT NULL,
  `total_units` int(11) NOT NULL,
  `total_price` float NOT NULL,
  `manfac_date` varchar(10) NOT NULL,
  `expiry_date` varchar(10) NOT NULL,
  `type` varchar(30) NOT NULL,
  `sgst` varchar(5) NOT NULL,
  `cgst` varchar(5) NOT NULL,
  `batch_no.` varchar(15) NOT NULL,
  `date` varchar(10) NOT NULL,
  PRIMARY KEY (`invoice_id`,`customer_id`,`product_id`),
  KEY `customer_id` (`customer_id`),
  KEY `product_id` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `invoice`
--

INSERT INTO `invoice` (`invoice_id`, `customer_id`, `product_id`, `manufacturer`, `unit_price`, `total_units`, `total_price`, `manfac_date`, `expiry_date`, `type`, `sgst`, `cgst`, `batch_no.`, `date`) VALUES
(1, 1, 1, '', 20, 5, 100, '', '', 'cash', '', '', '', '2017-08-22'),
(1, 1, 2, '', 20, 5, 100, '', '', 'cash', '', '', '', '2017-08-22'),
(2, 2, 1, 'Item 1', 200, 5, 1000, '07-17', '07-18', 'cash', '3%', '3%', 'kjjsg', '30/08/2017'),
(2, 2, 5, 'Item 2', 200, 10, 2000, '07-19', '07-21', 'cash', '9%', '9%', 'jjsb', '30/08/2017'),
(3, 1, 3, 'Item 1', 100, 10, 1000, '07-17', '07-19', 'cash', '6%', '6%', 'fgkd', '31/08/2017'),
(3, 1, 7, 'Item 1', 200, 5, 1000, '07-17', '07-19', 'cash', '9%', '9%', 'wjfk`', '31/08/2017'),
(4, 3, 1, 'Item 1', 100, 5, 500, '07-17', '07-19', 'cash', '14%', '14%', 'ksengj', '07/09/2017'),
(5, 2, 5, 'Item 2', 1000, 10, 10000, '07-24', '07-26', 'cash', '9%', '9%', 'prod2', '14/09/2017'),
(5, 2, 7, 'Item 1', 1000, 5, 5000, '09-21', '09-23', 'cash', '3%', '3%', 'skjf', '14/09/2017'),
(6, 2, 7, 'Item 1', 1000, 5, 5000, '09-21', '09-23', 'cash', '3%', '3%', 'skjf', '14/09/2017'),
(7, 3, 1, 'Item 1', 1000, 10, 10000, '07-19', '07-20', 'credit', '9%', '9%', 'sefj', '14/09/2017'),
(8, 2, 1, 'Item 1', 100, 5, 500, '07-30', '07-42', 'cash', '9%', '9%', 'fakf', '22/09/2017'),
(9, 2, 1, 'Item 1', 100, 5, 500, '07-30', '07-42', 'cash', '9%', '9%', 'fakf', '22/09/2017'),
(10, 2, 1, 'Item 1', 100, 5, 500, '07-30', '07-42', 'credit', '9%', '9%', 'fakf', '22/09/2017'),
(11, 2, 1, 'Item 1', 100, 5, 500, '07-30', '07-42', 'credit', '9%', '9%', 'fakf', '22/09/2017'),
(12, 2, 1, 'Item 1', 100, 10, 1000, '07-19', '07-17', 'cash', '9%', '9%', 'akj', '09/09/2017'),
(13, 2, 1, 'Item 1', 100, 10, 1000, '07-19', '07-17', 'credit', '9%', '9%', 'akj', '09/09/2017'),
(14, 3, 1, 'Item 1', 100, 10, 1000, '07-17', '07-19', 'cash', '9%', '9%', '0skdjh', '07/09/2017'),
(15, 3, 1, 'Item 1', 100, 10, 1000, '07-17', '07-19', 'credit', '9%', '9%', '0skdjh', '07/09/2017'),
(16, 2, 1, 'Item 1', 500, 6, 3000, '07-19', '07-17', 'credit', '3%', '3%', 'skf.', '15/09/2017'),
(17, 3, 1, 'Item 1', 1000, 7, 7000, '07-17', '07-18', 'cash', '9%', '9%', 'hwjfb', '15/09/2017'),
(18, 3, 1, 'Item 1', 1000, 7, 7000, '07-17', '07-18', 'credit', '9%', '9%', 'hwjfb', '15/09/2017'),
(19, 3, 1, 'Item 1', 1000, 7, 7000, '07-17', '07-18', 'credit', '9%', '9%', 'hwjfb', '15/09/2017'),
(20, 1, 6, 'Item 1', 1000, 10, 10000, '07-19', '07-21', 'cash', '9%', '9%', 'ahkaf', '15/09/2017'),
(21, 1, 6, 'Item 1', 1000, 10, 10000, '07-19', '07-21', 'credit', '9%', '9%', 'ahkaf', '15/09/2017'),
(22, 1, 4, 'Item 1', 1000, 2, 2000, '07-17', '07-20', 'credit', '14%', '14%', 'eng.w', '15/09/2017'),
(23, 1, 6, 'Item 1', 20, 100, 2000, '07-17', '07-21', 'cash', '9%', '9%', 'sccfb', '11/09/2017'),
(24, 1, 6, 'Item 1', 20, 100, 2000, '07-17', '07-21', 'credit', '9%', '9%', 'sccfb', '11/09/2017'),
(25, 1, 4, 'Item 1', 1000, 5, 5000, '07-17', '07-19', 'credit', '3%', '3%', 'ddnnvg', '07/09/2017'),
(26, 1, 1, 'Item 1', 1000, 5, 5000, '07-21', '09-23', 'credit', '14%', '14%', 'mngl', '12/09/2017'),
(27, 1, 1, 'Item 1', 100, 10, 1000, '07-17', '07-19', 'credit', '3%', '3%', 'rgrhwr', '12/09/2017'),
(28, 3, 5, 'Item 2', 100, 5, 500, '07-17', '07-19', 'cash', '3%', '3%', 'ejkjfv', '13/09/2017'),
(29, 2, 4, 'Item 1', 100, 5, 500, '07-14', '07-17', 'cash', '3%', '3%', 'ekjvevk', '21/09/2017'),
(30, 3, 4, 'Item 1', 100, 2, 200, '07-14', '07-19', 'cash', '3%', '3%', 'kjbdjq', '21/09/2017'),
(31, 3, 7, 'Item 1', 100, 3, 300, '07-11', '07-19', 'cash', '3%', '3%', 'sdjh', '14/09/2017');

-- --------------------------------------------------------

--
-- Table structure for table `product_info`
--

DROP TABLE IF EXISTS `product_info`;
CREATE TABLE IF NOT EXISTS `product_info` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(50) NOT NULL,
  `type` varchar(25) NOT NULL,
  `manufacturer` varchar(70) NOT NULL,
  `packing` varchar(10) NOT NULL,
  `description` varchar(200) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product_info`
--

INSERT INTO `product_info` (`product_id`, `product_name`, `type`, `manufacturer`, `packing`, `description`, `date`) VALUES
(1, 'tata tea', 'Item 1', 'Item 1', '100lt', 'pee jao ', '2017-08-17 17:46:22'),
(2, 'reliance tea', 'Item 1', 'Item 1', '10Gram', 'ambani ki taraf se free chai', '2017-08-17 17:51:38'),
(3, 'ice cream', 'Item 1', 'Item 1', '10Gram', 'cool cool', '2017-08-17 17:53:43'),
(4, 'coca cola', 'Item 1', 'Item 1', '2Litre', 'open happiness', '2017-08-17 17:54:47'),
(5, 'aaaaa', 'Item 3', 'Item 2', '1lt', 'aaaa', '2017-08-19 18:53:30'),
(6, 'ice c', 'Item 1', 'Item 1', '10g', 'cool cool', '2017-08-19 20:46:08'),
(7, 'yaar  hellooo', 'Item 1', 'Item 1', '10g', 'cool cool', '2017-08-19 20:46:29'),
(8, 'aaaaaaaaaaa', 'Item 1', 'Item 1', '10g', 'wefw', '2017-08-19 21:06:26'),
(9, 'aquafina', 'Item 3', 'Item 3', '1lt', '', '2017-10-06 18:46:16'),
(10, 'abcde12', 'Item 2', 'Item 2', '2g', '', '2017-10-09 14:06:49'),
(11, 'jsqghkqqr', 'Item 2', 'Item 2', '25kg', 'kfkewfk', '2017-10-09 14:19:52'),
(12, 'kjdjv.n', 'Item 4', 'Item 3', '70lt', 'd.kvjkrklvr', '2017-10-09 14:23:03');

-- --------------------------------------------------------

--
-- Table structure for table `stock_available`
--

DROP TABLE IF EXISTS `stock_available`;
CREATE TABLE IF NOT EXISTS `stock_available` (
  `product_id` int(11) NOT NULL,
  `available_units` int(11) NOT NULL,
  `total_units` int(11) NOT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stock_available`
--

INSERT INTO `stock_available` (`product_id`, `available_units`, `total_units`) VALUES
(1, 0, 0),
(2, 40, 40),
(3, 50, 110),
(4, 3, 10),
(5, 10, 10),
(6, 10, 10),
(7, 4, 10),
(8, 10, 10);

-- --------------------------------------------------------

--
-- Table structure for table `stock_new`
--

DROP TABLE IF EXISTS `stock_new`;
CREATE TABLE IF NOT EXISTS `stock_new` (
  `stock_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `supplier_id` int(11) NOT NULL,
  `new_units` int(11) NOT NULL,
  `date` varchar(10) NOT NULL,
  PRIMARY KEY (`stock_id`),
  KEY `product_id` (`product_id`) USING BTREE,
  KEY `supplier_id` (`supplier_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stock_new`
--

INSERT INTO `stock_new` (`stock_id`, `product_id`, `supplier_id`, `new_units`, `date`) VALUES
(1, 1, 1001, 50, '19/09/2017'),
(2, 1, 1003, 110, '19/09/2017'),
(3, 3, 1004, 10, '07/09/2017'),
(4, 3, 1004, 10, '07/09/2017'),
(5, 3, 1004, 10, '07/09/2017'),
(6, 3, 1004, 10, '07/09/2017'),
(7, 2, 1002, 10, '20/09/2017'),
(8, 2, 1002, 10, '20/09/2017'),
(9, 2, 1002, 10, '20/09/2017'),
(10, 2, 1002, 10, '20/09/2017'),
(11, 3, 1002, 10, '20/09/2017'),
(12, 4, 1002, 10, '20/09/2017'),
(13, 5, 1002, 10, '20/09/2017'),
(14, 6, 1002, 10, '20/09/2017'),
(15, 7, 1002, 10, '20/09/2017'),
(16, 8, 1002, 10, '20/09/2017');

-- --------------------------------------------------------

--
-- Table structure for table `supplier_details`
--

DROP TABLE IF EXISTS `supplier_details`;
CREATE TABLE IF NOT EXISTS `supplier_details` (
  `supplier_id` int(11) NOT NULL AUTO_INCREMENT,
  `supplier_name` varchar(50) NOT NULL,
  `address` varchar(100) NOT NULL,
  `city` varchar(30) NOT NULL,
  `state` varchar(30) NOT NULL,
  `mobile_no` varchar(12) NOT NULL,
  `email` varchar(30) NOT NULL,
  `type` varchar(20) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`supplier_id`),
  UNIQUE KEY `supplier_name` (`supplier_name`)
) ENGINE=InnoDB AUTO_INCREMENT=1008 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplier_details`
--

INSERT INTO `supplier_details` (`supplier_id`, `supplier_name`, `address`, `city`, `state`, `mobile_no`, `email`, `type`, `date`) VALUES
(1001, 'Tata Sons', 'godrej waterside salt city', 'mumbai', 'Maharashtra', '6666666777', 'tata@tatagroup.com', 'Manufacturer', '2017-08-17 06:00:51'),
(1002, 'shiva traders', 'lawrence road', 'amritsar', 'Punjab', '1234567890', '', 'Distibutor', '2017-08-17 06:03:35'),
(1003, 'ravi trading company', 'mall road', 'amritsar', 'Punjab', '9876543210', '', 'Distibutor', '2017-08-17 06:04:27'),
(1004, 'guru nanak traders', 'queens road', 'amritsar', 'Punjab', '8348756138', '', 'Manufacturer', '2017-08-17 06:05:51'),
(1005, 'sac', 'model town', 'jalandhar', 'Punjab', '9876543210', '', 'Distibutor', '2017-08-18 18:38:42'),
(1006, 'bec', 'holy city', 'asr', 'Punjab', '5555566666', '', 'Manufacturer', '2017-08-18 18:40:50'),
(1007, 'RK', 'pata nahi', 'sade kol na aoo', 'Punjab', '9998776576', '', 'Manufacturer', '2017-08-18 18:42:25');

-- --------------------------------------------------------

--
-- Table structure for table `units`
--

DROP TABLE IF EXISTS `units`;
CREATE TABLE IF NOT EXISTS `units` (
  `unit` varchar(20) NOT NULL,
  `abbreviation` varchar(4) NOT NULL,
  PRIMARY KEY (`unit`),
  UNIQUE KEY `abbreviation` (`abbreviation`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `units`
--

INSERT INTO `units` (`unit`, `abbreviation`) VALUES
('Gram', 'g'),
('Kilogram', 'kg'),
('Liter', 'lt'),
('Milligram', 'mg'),
('Milliliters', 'ml'),
('Metric ton', 't');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `customer_credit`
--
ALTER TABLE `customer_credit`
  ADD CONSTRAINT `customer_credit_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer_details` (`customer_id`),
  ADD CONSTRAINT `customer_credit_ibfk_2` FOREIGN KEY (`invoice_id`) REFERENCES `invoice` (`invoice_id`),
  ADD CONSTRAINT `customer_credit_ibfk_3` FOREIGN KEY (`customer_id`) REFERENCES `customer_details` (`customer_id`);

--
-- Constraints for table `invoice`
--
ALTER TABLE `invoice`
  ADD CONSTRAINT `invoice_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer_details` (`customer_id`),
  ADD CONSTRAINT `invoice_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product_info` (`product_id`);

--
-- Constraints for table `stock_available`
--
ALTER TABLE `stock_available`
  ADD CONSTRAINT `stock_available_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product_info` (`product_id`);

--
-- Constraints for table `stock_new`
--
ALTER TABLE `stock_new`
  ADD CONSTRAINT `stock_new_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product_info` (`product_id`),
  ADD CONSTRAINT `stock_new_ibfk_2` FOREIGN KEY (`supplier_id`) REFERENCES `supplier_details` (`supplier_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
