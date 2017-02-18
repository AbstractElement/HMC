

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

CREATE TABLE IF NOT EXISTS `hmc_example`.`brand_filter` (
  `brand` VARCHAR(255) NOT NULL,
  `num` INT(11) NOT NULL,
  PRIMARY KEY (`brand`),
  UNIQUE INDEX `brand_UNIQUE` (`brand` ASC))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `hmc_example`.`users` (
  `num` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(255) NOT NULL,
  `userPassword` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`num`),
  UNIQUE INDEX `num_UNIQUE` (`num` ASC))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `hmc`.`machine_order` (
  `orderId` VARCHAR(255) NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(255) NOT NULL,
  `lastName` VARCHAR(255) NOT NULL,
  `company` VARCHAR(255) NOT NULL,
  `address` VARCHAR(255) NOT NULL,
  `postcode` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `phone` VARCHAR(255) NOT NULL,
  `orderList` VARCHAR(511) NOT NULL,
  `total` VARCHAR(255) NOT NULL,
  `date` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`orderId`),
  UNIQUE INDEX `id_UNIQUE` (`orderId` ASC))
ENGINE = InnoDB;


insert into users value (1, '1111', '1111', '1111@11.11', 'ROLE_ADMIN');
insert into users value (2, '22', '22', '1111@11.11', 'ROLE_ADMIN');


