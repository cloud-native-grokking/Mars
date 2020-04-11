CREATE SCHEMA `mars` DEFAULT CHARACTER SET utf8 ;

Use mercury;
CREATE TABLE `mars`.`Message` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `content` VARCHAR(255) NULL,
  PRIMARY KEY (`id`));
