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
-- Table `user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user` (
  `id_user` INT NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(40) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_user`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `table`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `table` (
  `id_table` INT NOT NULL AUTO_INCREMENT,
  `id_user` INT NOT NULL,
  `title` VARCHAR(45) NOT NULL DEFAULT 'My Table',
  `description` VARCHAR(200) NULL,
  `color` VARCHAR(15) NULL,
  PRIMARY KEY (`id_table`, `id_user`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `task`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `task` (
  `id_task` INT NOT NULL AUTO_INCREMENT,
  `id_table` INT NOT NULL,
  `title` VARCHAR(45) NOT NULL DEFAULT 'My Task',
  `description` VARCHAR(200) NULL DEFAULT 'Sin descripcion',
  `importance` TINYINT NULL DEFAULT 0,
  `created_at` DATETIME NULL DEFAULT now(),
  `limit_date` DATETIME NULL,
  `done` TINYINT NULL DEFAULT 0,
  PRIMARY KEY (`id_task`, `id_table`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `topic`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `topic` (
  `id_topic` INT NOT NULL AUTO_INCREMENT,
  `id_table` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `description` VARCHAR(200) NULL,
  PRIMARY KEY (`id_topic`, `id_table`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `topic_has_task`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `topic_has_task` (
  `id_topic` INT NOT NULL,
  `id_task` INT NOT NULL,
  PRIMARY KEY (`id_topic`, `id_task`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
