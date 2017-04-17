CREATE TABLE IF NOT EXISTS `hmc_example`.`users` (
  `num` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(255) NOT NULL,
  `userPassword` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`num`),
  UNIQUE INDEX `num_UNIQUE` (`num` ASC))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `hmc_example`.`machine_order` (
  `orderId` VARCHAR(255) NOT NULL,
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


