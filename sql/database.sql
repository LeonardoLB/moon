SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `moon` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE IF NOT EXISTS `moon`.`costumer` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `phone_country_code` INT(11) NOT NULL,
  `phone_area_code` INT(11) NOT NULL,
  `phone_number` INT(11) NOT NULL,
  `birth_date` VARCHAR(100) NOT NULL,
  `document_number` VARCHAR(45) NOT NULL,
  `costumer_andress_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_costumer_costumer_andress1_idx` (`costumer_andress_id` ASC) VISIBLE,
  CONSTRAINT `fk_costumer_costumer_andress1`
    FOREIGN KEY (`costumer_andress_id`)
    REFERENCES `moon`.`costumer_andress` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `moon`.`costumer_andress` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `street` VARCHAR(255) NOT NULL,
  `number` INT(11) NOT NULL,
  `complement` VARCHAR(255) NOT NULL,
  `district` VARCHAR(255) NOT NULL,
  `state` VARCHAR(100) NOT NULL,
  `country` VARCHAR(45) NOT NULL,
  `zipcode` INT(11) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `moon`.`payment_card` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `method` VARCHAR(150) NOT NULL,
  `number` VARCHAR(255) NOT NULL,
  `cvc` INT(11) NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  `document_number` VARCHAR(255) NOT NULL,
  `expiration_month` INT(11) NOT NULL,
  `expiration_year` INT(11) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `moon`.`payment_item` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  `quantity` INT(11) NULL DEFAULT NULL,
  `price_in_cents` INT(11) NULL DEFAULT NULL,
  `payment_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_item_payment1_idx` (`payment_id` ASC) VISIBLE,
  CONSTRAINT `fk_item_payment1`
    FOREIGN KEY (`payment_id`)
    REFERENCES `moon`.`payment` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `moon`.`payment` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `unique_id` VARCHAR(200) NOT NULL,
  `currency` VARCHAR(45) NOT NULL,
  `value_in_cents` INT(11) NOT NULL,
  `installments` INT(11) NOT NULL,
  `costumer_id` INT(11) NOT NULL,
  `payment_card_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_payment_costumer_idx` (`costumer_id` ASC) VISIBLE,
  INDEX `fk_payment_costumer_card1_idx` (`payment_card_id` ASC) VISIBLE,
  CONSTRAINT `fk_payment_costumer`
    FOREIGN KEY (`costumer_id`)
    REFERENCES `moon`.`costumer` (`id`),
  CONSTRAINT `fk_payment_costumer_card1`
    FOREIGN KEY (`payment_card_id`)
    REFERENCES `moon`.`payment_card` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
