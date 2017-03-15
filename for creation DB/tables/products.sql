CREATE SCHEMA IF NOT EXISTS `hmc_example` DEFAULT CHARACTER SET utf8 ;

use `hmc_example`;

CREATE TABLE IF NOT EXISTS `hmc_example`.`drive_heads` (
  `productId` VARCHAR(255) NOT NULL,
  `model` VARCHAR(255) NULL DEFAULT NULL,
  `type` VARCHAR(255) NULL DEFAULT NULL,
  `instrumentTypeEn` VARCHAR(255) NULL DEFAULT NULL,
  `instrumentTypeRu` VARCHAR(255) NULL DEFAULT NULL,
  `brand` VARCHAR(255) NULL DEFAULT NULL,
  `producingCountry` VARCHAR(255) NULL DEFAULT NULL,
  `landingDiameter` VARCHAR(255) NULL DEFAULT NULL,
  `driveType` VARCHAR(255) NULL DEFAULT NULL,
  `toolHolder` VARCHAR(255) NULL DEFAULT NULL,
  `clampingRange` VARCHAR(255) NULL DEFAULT '0',
  `n1n2` VARCHAR(255) NULL DEFAULT NULL,
  `torqueMax` VARCHAR(255) NULL DEFAULT NULL,
  `lengthWorkingPart` VARCHAR(255) NULL DEFAULT NULL,
  `displacement` VARCHAR(255) NULL DEFAULT NULL,
  `internalSupply` VARCHAR(255) NULL DEFAULT NULL,
  `weight` INT(11) NULL DEFAULT NULL,
  `photo1` VARCHAR(255) NULL DEFAULT NULL,
  `photo2` VARCHAR(255) NULL DEFAULT NULL,
  `photo3` VARCHAR(255) NULL DEFAULT NULL,
  `drawing` VARCHAR(255) NULL DEFAULT NULL,
  `price` DOUBLE(20, 8) NULL DEFAULT NULL,
  `description` VARCHAR(1023) NULL DEFAULT NULL,
  `isSold` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`productId`),
  UNIQUE INDEX `productId_UNIQUE` (`productId` ASC))
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `hmc_example`.`robot` (
  `product_id` varchar(145),
  `robot_type` varchar(250) DEFAULT NULL,
  `model` varchar(155) DEFAULT NULL,
  `manufacturer` varchar(145) DEFAULT NULL,
  `producing_year` int(11) DEFAULT NULL,
  `robot_condition` varchar(245) DEFAULT NULL,
  `location` varchar(145) DEFAULT NULL,
  `axes` VARCHAR(100) DEFAULT NULL COMMENT 'axis',
  `robot_load` int(11) DEFAULT NULL COMMENT 'kg',
  `reach` VARCHAR(145) DEFAULT NULL COMMENT 'like radius, mm',
  `footprint` varchar(145) DEFAULT NULL,
  `repeatability` int(11) DEFAULT NULL COMMENT '0.08',
  `weight` int(11) DEFAULT NULL COMMENT 'kg',
  `price` int(11) DEFAULT NULL,
  `photo1` varchar(145) DEFAULT NULL,
  `photo2` varchar(145) DEFAULT NULL,
  `photo3` varchar(145) DEFAULT NULL,
  `descriptionen` VARCHAR (1023),
  `descriptionru` VARCHAR (1023),
  `video1` varchar(145) DEFAULT NULL,
  `video2` varchar(145) DEFAULT NULL,
  `video3` varchar(145) DEFAULT NULL,
  `sold` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;