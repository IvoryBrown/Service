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
  `tipus` VARCHAR(255) NOT NULL,
  `sorozatszam_g` VARCHAR(255) NOT NULL,
  `allapot` VARCHAR(255) NOT NULL,
  `prioritas` VARCHAR(60) NULL,
  `vasarlas_ido` DATE NULL,
  `rogzites` DATE NOT NULL,
  `hatarido` DATE NOT NULL,
  `teljesitve` DATE NULL,
  `softwer` VARCHAR(255) NOT NULL,
  `hardwer` VARCHAR(255) NOT NULL,
  `takaritas` VARCHAR(255) NOT NULL,
  `jelszo` VARCHAR(45) NULL,
  `tartozekok` VARCHAR(255) NULL,
  `serules` VARCHAR(255) NULL,
  `hiba_leiras` VARCHAR(255) NOT NULL,
  `valos_hiba` VARCHAR(255) NOT NULL,
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
-- Table `Service`.`software`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Service`.`software` (
  `ID_sofware` INT NOT NULL AUTO_INCREMENT,
  `eszkoz_nev_s` VARCHAR(255) NULL,
  `serial` VARCHAR(255) NULL,
  `software` VARCHAR(255) NULL,
  `megjegyzes_s` VARCHAR(255) NULL,
  `gepadatok_ID_gs` INT NOT NULL,
  PRIMARY KEY (`ID_sofware`),
  INDEX `fk_software_gepadatok1_idx` (`gepadatok_ID_gs` ASC),
  CONSTRAINT `fk_software_gepadatok1`
    FOREIGN KEY (`gepadatok_ID_gs`)
    REFERENCES `Service`.`gepadatok` (`ID_g`)
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
-- Table `Service`.`alkatresz`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Service`.`alkatresz` (
  `ID_a` INT NOT NULL,
  `eszkoz_nev_a` VARCHAR(255) NULL,
  `eszkoz_serial_a` VARCHAR(255) NULL,
  `alkatresz_tipus` VARCHAR(255) NULL,
  `alkatresz_serial` VARCHAR(255) NULL,
  `megjegyzes_a` VARCHAR(255) NULL,
  `gepadatok_ID_ga` INT NOT NULL,
  PRIMARY KEY (`ID_a`),
  INDEX `fk_alkatresz_gepadatok1_idx` (`gepadatok_ID_ga` ASC),
  CONSTRAINT `fk_alkatresz_gepadatok1`
    FOREIGN KEY (`gepadatok_ID_ga`)
    REFERENCES `Service`.`gepadatok` (`ID_g`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;