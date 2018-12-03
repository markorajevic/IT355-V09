-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.1.9-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win32
-- HeidiSQL Version:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping structure for table test.categories
CREATE TABLE IF NOT EXISTS `categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `enabled` bit(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table test.products
CREATE TABLE IF NOT EXISTS `products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `CATEGORY_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ryvopwisinq0s8st54rhloewo` (`CATEGORY_ID`),
  CONSTRAINT `FK_ryvopwisinq0s8st54rhloewo` FOREIGN KEY (`CATEGORY_ID`) REFERENCES `categories` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table test.shoppingcartitems
CREATE TABLE IF NOT EXISTS `shoppingcartitems` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `enabled` bit(1) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `total` double DEFAULT NULL,
  `PRODUCT_ID` int(11) DEFAULT NULL,
  `SHOPPINGCART_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_40f3gpbr9gb3sdysm5shnpafb` (`PRODUCT_ID`),
  KEY `FK_ov1j8rdhdehh7tn7rf07ex30l` (`SHOPPINGCART_ID`),
  CONSTRAINT `FK_40f3gpbr9gb3sdysm5shnpafb` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `products` (`id`),
  CONSTRAINT `FK_ov1j8rdhdehh7tn7rf07ex30l` FOREIGN KEY (`SHOPPINGCART_ID`) REFERENCES `shoppingcarts` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.


-- Dumping structure for table test.shoppingcarts
CREATE TABLE IF NOT EXISTS `shoppingcarts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `enabled` bit(1) DEFAULT NULL,
  `paymentMethod` varchar(255) DEFAULT NULL,
  `shoppingDate` date DEFAULT NULL,
  `totalCost` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
