-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema Service
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Service
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Service` DEFAULT CHARACTER SET utf8 COLLATE utf8_hungarian_ci ;
USE `Service` ;

-- -----------------------------------------------------
-- Table `Service`.`image_alkatresz`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Service`.`image_alkatresz` (
  `Image_a` LONGBLOB NULL,
  `uj_alaktresz_azonosito_a` INT NOT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_hungarian_ci;


-- -----------------------------------------------------
-- Table `Service`.`software`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Service`.`software` (
  `ID_sofware` INT NOT NULL AUTO_INCREMENT,
  `software` VARCHAR(255) NULL,
  `megjegyzes_s` VARCHAR(255) NULL,
  `gepadatok_azonosito_g` INT NOT NULL,
  PRIMARY KEY (`ID_sofware`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_hungarian_ci;


-- -----------------------------------------------------
-- Table `Service`.`megrendelo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Service`.`megrendelo` (
  `ID_m` INT NOT NULL AUTO_INCREMENT,
  `azonosito_m` INT NOT NULL,
  `nev` VARCHAR(255) NOT NULL,
  `kapcsolat` VARCHAR(255) NOT NULL,
  `lakcim` VARCHAR(255) NULL,
  `megjegyzes_m` VARCHAR(255) NULL,
  PRIMARY KEY (`ID_m`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_hungarian_ci;


-- -----------------------------------------------------
-- Table `Service`.`gepadatok`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Service`.`gepadatok` (
  `ID_g` INT NOT NULL AUTO_INCREMENT,
  `ugyfel_nev` VARCHAR(255) NOT NULL,
  `eszkoz_g` VARCHAR(255) NOT NULL,
  `sorozatszam_g` VARCHAR(255) NOT NULL,
  `allapot` VARCHAR(255) NOT NULL,
  `prioritas` VARCHAR(60) NULL,
  `rogzites` DATETIME NOT NULL,
  `hatarido` DATE NOT NULL,
  `teljesitve` DATETIME NULL,
  `megjegyzes_g` VARCHAR(255) NULL,
  `megrendelo_ID_m` INT NOT NULL,
  PRIMARY KEY (`ID_g`),
  INDEX `fk_gepadatok_megrendelo_idx` (`megrendelo_ID_m` ASC),
  CONSTRAINT `fk_gepadatok_megrendelo`
    FOREIGN KEY (`megrendelo_ID_m`)
    REFERENCES `Service`.`megrendelo` (`ID_m`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_hungarian_ci;


-- -----------------------------------------------------
-- Table `Service`.`image_gep`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Service`.`image_gep` (
  `ID_image_gep` INT NOT NULL AUTO_INCREMENT,
  `ugyfel_nev_i` VARCHAR(255) NOT NULL,
  `eszkoz_nev` VARCHAR(255) NULL,
  `sorozatszam_i` VARCHAR(255) NOT NULL,
  `gepadatok_ID_g` INT NOT NULL,
  `Image_i` LONGBLOB NULL,
  INDEX `fk_image_gep_gepadatok1_idx` (`gepadatok_ID_g` ASC),
  PRIMARY KEY (`ID_image_gep`),
  CONSTRAINT `fk_image_gep_gepadatok1`
    FOREIGN KEY (`gepadatok_ID_g`)
    REFERENCES `Service`.`gepadatok` (`ID_g`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_hungarian_ci;


-- -----------------------------------------------------
-- Table `Service`.`uj_alaktresz`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Service`.`uj_alaktresz` (
  `ID_a` INT NOT NULL,
  `azonosito_a` INT NOT NULL,
  `eszkoz_a` VARCHAR(255) NULL,
  `megjegyzes_a` VARCHAR(255) NULL,
  `gepadatok_azonosito_g` INT NOT NULL,
  PRIMARY KEY (`azonosito_a`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_hungarian_ci;


-- -----------------------------------------------------
-- Table `Service`.`hasznalt_alaktresz`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Service`.`hasznalt_alaktresz` (
  `ID_h` INT NOT NULL,
  `azonosito_h` INT NOT NULL,
  `eszkoz_h` VARCHAR(255) NULL,
  `megjegyzes_h` VARCHAR(255) NULL,
  `gepadatok_azonosito_g` INT NOT NULL,
  PRIMARY KEY (`azonosito_h`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_hungarian_ci;


-- -----------------------------------------------------
-- Table `Service`.`image_hasznalt`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Service`.`image_hasznalt` (
  `Image_h` LONGBLOB NULL,
  `hasznalt_alaktresz_azonosito_h` INT NOT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_hungarian_ci;


-- -----------------------------------------------------
-- Table `Service`.`szervizes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Service`.`szervizes` (
  `szervizes` VARCHAR(255) NOT NULL,
  `gepadatok_azonosito_g` INT NOT NULL);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
