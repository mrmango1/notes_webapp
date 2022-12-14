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
  PRIMARY KEY (`id_table`, `id_user`),
  foreign key (id_user) references user (id_user) on delete cascade
)ENGINE = InnoDB;


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
  `limit_date` DATE NULL,
  `done` TINYINT NULL DEFAULT 0,
  PRIMARY KEY (`id_task`, `id_table`),
  foreign key (id_table) references `table` (id_table) on delete cascade
)ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `topic`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `topic` (
  `id_topic` INT NOT NULL AUTO_INCREMENT,
  `id_table` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `description` VARCHAR(200) NULL,
  PRIMARY KEY (`id_topic`, `id_table`),
  foreign key (id_table) references `table` (id_table) on delete cascade
)ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `topic_has_task`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `topic_has_task` (
  `id_topic` INT NOT NULL,
  `id_task` INT NOT NULL,
  PRIMARY KEY (`id_topic`, `id_task`),
  foreign key (id_topic) references `topic` (id_topic) on delete cascade,
  foreign key (id_task) references `task` (id_task) on delete cascade
)ENGINE = InnoDB;
