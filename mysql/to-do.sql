-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema to-do
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema to-do
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `to-do` ;
USE `to-do` ;

-- -----------------------------------------------------
-- Table `to-do`.`person`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `to-do`.`person` (
  `id_person` INT NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(40) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_person`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `to-do`.`table`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `to-do`.`table` (
  `id_table` INT NOT NULL AUTO_INCREMENT,
  `id_person` INT NOT NULL,
  `title` VARCHAR(45) NOT NULL DEFAULT 'My Table',
  `description` VARCHAR(200) NULL,
  `color` VARCHAR(7) NULL,
  PRIMARY KEY (`id_table`, `id_person`),
  CONSTRAINT `fk_table_person`
    FOREIGN KEY (`id_person`)
    REFERENCES `to-do`.`person` (`id_person`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `to-do`.`task`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `to-do`.`task` (
  `id_task` INT NOT NULL AUTO_INCREMENT,
  `id_table` INT NOT NULL,
  `title` VARCHAR(45) NOT NULL DEFAULT 'My Task',
  `description` VARCHAR(200) NULL DEFAULT 'Sin descripcion',
  `importance` TINYINT NULL DEFAULT 0,
  `created_at` DATETIME NULL DEFAULT now(),
  `update_at` DATETIME NULL DEFAULT now(),
  `limit_date` DATETIME NULL,
  `done` TINYINT NULL DEFAULT 0,
  PRIMARY KEY (`id_task`, `id_table`),
  CONSTRAINT `fk_task_table1`
    FOREIGN KEY (`id_table`)
    REFERENCES `to-do`.`table` (`id_table`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `to-do`.`topic`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `to-do`.`topic` (
  `id_topic` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `description` VARCHAR(200) NULL,
  PRIMARY KEY (`id_topic`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `to-do`.`task_has_topic`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `to-do`.`task_has_topic` (
  `id_task` INT NOT NULL,
  `id_table` INT NOT NULL,
  `id_topic` INT NOT NULL,
  PRIMARY KEY (`id_task`, `id_table`, `id_topic`),
  CONSTRAINT `fk_task_has_topic_task1`
    FOREIGN KEY (`id_task` , `id_table`)
    REFERENCES `to-do`.`task` (`id_task` , `id_table`),
  CONSTRAINT `fk_task_has_topic_topic1`
    FOREIGN KEY (`id_topic`)
    REFERENCES `to-do`.`topic` (`id_topic`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
