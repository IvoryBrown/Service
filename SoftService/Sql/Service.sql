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
CREATE SCHEMA IF NOT EXISTS `Service` DEFAULT CHARACTER SET utf8 ;
USE `Service` ;

-- -----------------------------------------------------
-- Table `Service`.`megrendelo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Service`.`megrendelo` (
  `ID_m` INT NOT NULL,
  `azonosito_m` INT NOT NULL,
  `nev` VARCHAR(255) NOT NULL,
  `kapcsolat` VARCHAR(255) NOT NULL,
  `lakcim` VARCHAR(255) NULL,
  `megjegyzes_m` VARCHAR(255) NULL,
  PRIMARY KEY (`azonosito_m`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_hungarian_ci;


-- -----------------------------------------------------
-- Table `Service`.`gepadatok`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Service`.`gepadatok` (
  `ID_g` INT NOT NULL,
  `azonosito_g` INT NOT NULL,
  `eszkoz_g` VARCHAR(255) NOT NULL,
  `allapot` VARCHAR(255) NOT NULL,
  `megjegyzes_g` VARCHAR(255) NULL,
  `megrendelo_azonosito_m` INT NOT NULL,
  PRIMARY KEY (`azonosito_g`),
  INDEX `fk_gepadatok_megrendelo_idx` (`megrendelo_azonosito_m` ASC),
  CONSTRAINT `fk_gepadatok_megrendelo`
    FOREIGN KEY (`megrendelo_azonosito_m`)
    REFERENCES `Service`.`megrendelo` (`azonosito_m`)
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
  PRIMARY KEY (`azonosito_a`),
  INDEX `fk_uj_alaktresz_gepadatok1_idx` (`gepadatok_azonosito_g` ASC),
  CONSTRAINT `fk_uj_alaktresz_gepadatok1`
    FOREIGN KEY (`gepadatok_azonosito_g`)
    REFERENCES `Service`.`gepadatok` (`azonosito_g`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_hungarian_ci;


-- -----------------------------------------------------
-- Table `Service`.`image_alkatresz`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Service`.`image_alkatresz` (
  `Image_a` LONGBLOB NULL,
  `uj_alaktresz_azonosito_a` INT NOT NULL,
  INDEX `fk_image_alkatresz_uj_alaktresz1_idx` (`uj_alaktresz_azonosito_a` ASC),
  CONSTRAINT `fk_image_alkatresz_uj_alaktresz1`
    FOREIGN KEY (`uj_alaktresz_azonosito_a`)
    REFERENCES `Service`.`uj_alaktresz` (`azonosito_a`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_hungarian_ci;


-- -----------------------------------------------------
-- Table `Service`.`munka_ido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Service`.`munka_ido` (
  `rogzites` DATE NOT NULL,
  `hatarido` DATE NOT NULL,
  `ra_forditott_ido` INT NULL,
  `tenyleges_teljesites` DATE NULL,
  `megjegyzes_i` VARCHAR(255) NULL,
  `gepadatok_azonosito_g` INT NOT NULL,
  INDEX `fk_munka_ido_gepadatok1_idx` (`gepadatok_azonosito_g` ASC),
  CONSTRAINT `fk_munka_ido_gepadatok1`
    FOREIGN KEY (`gepadatok_azonosito_g`)
    REFERENCES `Service`.`gepadatok` (`azonosito_g`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_hungarian_ci;


-- -----------------------------------------------------
-- Table `Service`.`software`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Service`.`software` (
  `software` VARCHAR(255) NULL,
  `megjegyzes_s` VARCHAR(255) NULL,
  `gepadatok_azonosito_g` INT NOT NULL,
  INDEX `fk_softver_gepadatok1_idx` (`gepadatok_azonosito_g` ASC),
  CONSTRAINT `fk_softver_gepadatok1`
    FOREIGN KEY (`gepadatok_azonosito_g`)
    REFERENCES `Service`.`gepadatok` (`azonosito_g`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_hungarian_ci;


-- -----------------------------------------------------
-- Table `Service`.`image_gep`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Service`.`image_gep` (
  `Image_g` LONGBLOB NULL,
  `gepadatok_azonosito_g` INT NOT NULL,
  INDEX `fk_image_gep_gepadatok1_idx` (`gepadatok_azonosito_g` ASC),
  CONSTRAINT `fk_image_gep_gepadatok1`
    FOREIGN KEY (`gepadatok_azonosito_g`)
    REFERENCES `Service`.`gepadatok` (`azonosito_g`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
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
  PRIMARY KEY (`azonosito_h`),
  INDEX `fk_hasznalt_alaktresz_gepadatok1_idx` (`gepadatok_azonosito_g` ASC),
  CONSTRAINT `fk_hasznalt_alaktresz_gepadatok1`
    FOREIGN KEY (`gepadatok_azonosito_g`)
    REFERENCES `Service`.`gepadatok` (`azonosito_g`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_hungarian_ci;


-- -----------------------------------------------------
-- Table `Service`.`image_hasznalt`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Service`.`image_hasznalt` (
  `Image_h` LONGBLOB NULL,
  `hasznalt_alaktresz_azonosito_h` INT NOT NULL,
  INDEX `fk_image_hasznalt_hasznalt_alaktresz1_idx` (`hasznalt_alaktresz_azonosito_h` ASC),
  CONSTRAINT `fk_image_hasznalt_hasznalt_alaktresz1`
    FOREIGN KEY (`hasznalt_alaktresz_azonosito_h`)
    REFERENCES `Service`.`hasznalt_alaktresz` (`azonosito_h`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_hungarian_ci;


-- -----------------------------------------------------
-- Table `Service`.`szervizes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Service`.`szervizes` (
  `szervizes` VARCHAR(255) NOT NULL,
  `gepadatok_azonosito_g` INT NOT NULL,
  INDEX `fk_szervizes_gepadatok1_idx` (`gepadatok_azonosito_g` ASC),
  CONSTRAINT `fk_szervizes_gepadatok1`
    FOREIGN KEY (`gepadatok_azonosito_g`)
    REFERENCES `Service`.`gepadatok` (`azonosito_g`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;