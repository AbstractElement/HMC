CREATE SCHEMA IF NOT EXISTS `hmc_example` DEFAULT CHARACTER SET utf8 ;

use `hmc_example`;

CREATE TABLE IF NOT EXISTS `hmc_example`.`manufacturer_filter` (
  `id` INT(11) NOT NULL,
  `nameManufacturer` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`nameManufacturer`),
  UNIQUE INDEX `id_UNIQUE` (`nameManufacturer` ASC))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `hmc_example`.`filter_location` (
  `id` INT(11) NOT NULL,
  `countryName` VARCHAR(255) NOT NULL,
  'typeProduct' VARCHAR(255) NOT NULL,
  PRIMARY KEY (`countryName`),
  UNIQUE INDEX `id_UNIQUE` (`countryName` ASC))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `hmc_example`.`filter_axes` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `axes` VARCHAR(100) ,
  `numPosition` INT(11),
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
  ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `hmc_example`.`filter_load` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `loadValue` VARCHAR(100),
  `numPosition` INT(11),
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
  ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `hmc_example`.`filter_reach` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `reachValue` VARCHAR(100),
  `numPosition` INT(11),
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
  ENGINE = InnoDB;

#
# CREATE TABLE IF NOT EXISTS `hmc_example`.`sliders_filter` (
#   `id` INT(11) NOT NULL AUTO_INCREMENT,
#   `axes` VARCHAR(100) ,
#   `loadValues` VARCHAR(100),
#   `reachValues` VARCHAR(100),
#   PRIMARY KEY (`id`),
#   UNIQUE INDEX `id_UNIQUE` (`id` ASC))
#   ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `hmc_example`.`brand_filter` (
  `brand` VARCHAR(255) NOT NULL,
  `num` INT(11) NOT NULL,
  PRIMARY KEY (`brand`),
  UNIQUE INDEX `brand_UNIQUE` (`brand` ASC))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `hmc_example`.`filter_driveType` (
  `driveType` VARCHAR(255) NOT NULL,
  `num` INT(11) NOT NULL,
  PRIMARY KEY (`driveType`),
  UNIQUE INDEX `brand_UNIQUE` (`driveType` ASC))
  ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `hmc_example`.`filter_toolHolder` (
  `toolHolder` VARCHAR(255) NOT NULL,
  `num` INT(11) NOT NULL,
  PRIMARY KEY (`toolHolder`),
  UNIQUE INDEX `brand_UNIQUE` (`toolHolder` ASC))
  ENGINE = InnoDB;