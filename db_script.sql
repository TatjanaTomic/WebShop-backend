-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema shop_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema shop_db
-- -----------------------------------------------------

DROP SCHEMA IF EXISTS `shop_db`;
CREATE SCHEMA IF NOT EXISTS `shop_db` DEFAULT CHARACTER SET utf8mb3 ;
USE `shop_db` ;

-- -----------------------------------------------------
-- Table `shop_db`.`account_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shop_db`.`account_type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `shop_db`.`account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shop_db`.`account` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `id_account_type` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_ACCOUNT_ACCOUNT_TYPE_idx` (`id_account_type` ASC) VISIBLE,
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE,
  CONSTRAINT `fk_ACCOUNT_ACCOUNT_TYPE`
    FOREIGN KEY (`id_account_type`)
    REFERENCES `shop_db`.`account_type` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `shop_db`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shop_db`.`category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `is_deleted` TINYINT NOT NULL DEFAULT 0,
  `id_parent_category` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE,
  INDEX `fk_category_category1_idx` (`id_parent_category` ASC) VISIBLE,
  CONSTRAINT `fk_category_category1`
    FOREIGN KEY (`id_parent_category`)
    REFERENCES `shop_db`.`category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `shop_db`.`attribute`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shop_db`.`attribute` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_category` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `is_deleted` TINYINT NOT NULL,
  PRIMARY KEY (`id`, `id_category`),
  INDEX `fk_ATTRIBUTE_CATEGORY1_idx` (`id_category` ASC) VISIBLE,
  CONSTRAINT `fk_ATTRIBUTE_CATEGORY1`
    FOREIGN KEY (`id_category`)
    REFERENCES `shop_db`.`category` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `shop_db`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shop_db`.`product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` TEXT NOT NULL,
  `price` DECIMAL(12,2) NOT NULL,
  `is_new` TINYINT NOT NULL,
  `contact` VARCHAR(45) NOT NULL,
  `id_category` INT NOT NULL,
  `address` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_PRODUCT_CATEGORY1_idx` (`id_category` ASC) VISIBLE,
  CONSTRAINT `fk_PRODUCT_CATEGORY1`
    FOREIGN KEY (`id_category`)
    REFERENCES `shop_db`.`category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `shop_db`.`user_account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shop_db`.`user_account` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  `avatar` VARCHAR(500) NULL DEFAULT NULL,
  `mail` VARCHAR(45) NOT NULL,
  `pin` VARCHAR(45) NOT NULL,
  `is_activated` TINYINT NOT NULL DEFAULT 0,
  `is_deleted` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  INDEX `fk_USER_ACCOUNT_ACCOUNT1_idx` (`id` ASC) VISIBLE,
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `shop_db`.`offer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shop_db`.`offer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_user` INT NOT NULL,
  `id_product` INT NOT NULL,
  `is_active` TINYINT NOT NULL DEFAULT '1',
  `is_deleted` TINYINT NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  INDEX `fk_OFFER_USER_ACCOUNT1_idx` (`id_user` ASC) VISIBLE,
  INDEX `fk_OFFER_PRODUCT1_idx` (`id_product` ASC) VISIBLE,
  CONSTRAINT `fk_OFFER_PRODUCT1`
    FOREIGN KEY (`id_product`)
    REFERENCES `shop_db`.`product` (`id`),
  CONSTRAINT `fk_OFFER_USER_ACCOUNT1`
    FOREIGN KEY (`id_user`)
    REFERENCES `shop_db`.`user_account` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `shop_db`.`comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shop_db`.`comment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `content` TEXT NOT NULL,
  `id_user` INT NOT NULL,
  `id_offer` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_COMMENT_USER_ACCOUNT1_idx` (`id_user` ASC) VISIBLE,
  INDEX `fk_COMMENT_OFFER1_idx` (`id_offer` ASC) VISIBLE,
  CONSTRAINT `fk_COMMENT_OFFER1`
    FOREIGN KEY (`id_offer`)
    REFERENCES `shop_db`.`offer` (`id`),
  CONSTRAINT `fk_COMMENT_USER_ACCOUNT1`
    FOREIGN KEY (`id_user`)
    REFERENCES `shop_db`.`user_account` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `shop_db`.`image`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shop_db`.`image` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `url` VARCHAR(500) NOT NULL,
  `id_product` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_IMAGE_PRODUCT1_idx` (`id_product` ASC) VISIBLE,
  CONSTRAINT `fk_IMAGE_PRODUCT1`
    FOREIGN KEY (`id_product`)
    REFERENCES `shop_db`.`product` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `shop_db`.`log`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shop_db`.`log` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `content` TEXT NOT NULL,
  `date_time` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `shop_db`.`message`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shop_db`.`message` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `content` TEXT NOT NULL,
  `id_user` INT NOT NULL,
  `is_read` TINYINT NOT NULL DEFAULT '0',
  `date_time` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_MESSAGE_USER_ACCOUNT1_idx` (`id_user` ASC) VISIBLE,
  CONSTRAINT `fk_MESSAGE_USER_ACCOUNT1`
    FOREIGN KEY (`id_user`)
    REFERENCES `shop_db`.`user_account` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `shop_db`.`payment_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shop_db`.`payment_type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `shop_db`.`purchase`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shop_db`.`purchase` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_offer` INT NOT NULL,
  `id_payment_type` INT NOT NULL,
  `id_user` INT NOT NULL,
  `date_time` VARCHAR(255) NOT NULL,
  `card_number` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_PURCHASE_OFFER1_idx` (`id_offer` ASC) VISIBLE,
  INDEX `fk_PURCHASE_PAYMENT_TYPE1_idx` (`id_payment_type` ASC) VISIBLE,
  INDEX `fk_PURCHASE_USER_ACCOUNT1_idx` (`id_user` ASC) VISIBLE,
  CONSTRAINT `fk_PURCHASE_OFFER1`
    FOREIGN KEY (`id_offer`)
    REFERENCES `shop_db`.`offer` (`id`),
  CONSTRAINT `fk_PURCHASE_PAYMENT_TYPE1`
    FOREIGN KEY (`id_payment_type`)
    REFERENCES `shop_db`.`payment_type` (`id`),
  CONSTRAINT `fk_PURCHASE_USER_ACCOUNT1`
    FOREIGN KEY (`id_user`)
    REFERENCES `shop_db`.`user_account` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `shop_db`.`value`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shop_db`.`value` (
  `id_product` INT NOT NULL,
  `id_attribute` INT NOT NULL,
  `id_category` INT NOT NULL,
  `value` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id_product`, `id_attribute`, `id_category`),
  INDEX `fk_value_product_idx` (`id_product` ASC) VISIBLE,
  INDEX `fk_value_attribute1_idx` (`id_attribute` ASC, `id_category` ASC) VISIBLE,
  CONSTRAINT `fk_value_product`
    FOREIGN KEY (`id_product`)
    REFERENCES `shop_db`.`product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_value_attribute1`
    FOREIGN KEY (`id_attribute` , `id_category`)
    REFERENCES `shop_db`.`attribute` (`id` , `id_category`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

insert into account_type values (null, 'admin');
insert into account_type values (null, 'operater');

insert into account values (null, 'ime1', 'prezime1', 'admin1', 'admin1', 1);
insert into account values (null, 'ime4', 'prezime4', 'oper1', 'oper1', 2);

insert into user_account values (null, 'ime1', 'prezime1', 'user1', 'user1', 'Banja Luka', 'https://ps.w.org/user-avatar-reloaded/assets/icon-256x256.png?rev=2540745', 'user1@mail.com', '1234', true, false);
insert into user_account values (null, 'ime2', 'prezime2', 'user2', 'user2', 'Prijedor', 'https://www.pngkey.com/png/detail/114-1149878_setting-user-avatar-in-specific-size-without-breaking.png', 'user2@mail.com', '1234', true, false);
insert into user_account values (null, "Tatjana", "Tomic", "tatjana", "tatjana", "Prijedor", 'https://img.freepik.com/premium-vector/businesswoman-female-elegant-avatar_24877-18073.jpg', "tatjanatomic997@yahoo.com", "1234", true, false);
insert into user_account values (null, 'ime3', 'prezime3', 'user3', 'user3', 'Novi Grad', null, 'user3@mail.com', '1234', false, false);
insert into user_account values (null, 'ime4', 'prezime4', 'user4', 'user4', 'Banja Luka', null, 'user4@mail.com', '1234', true, true);

insert into payment_type values (null, 'KARTICNO');
insert into payment_type values (null, 'PRILIKOM PREUZIMANJA');

insert into category values (null, 'Telefoni', false, null);
insert into category values (null, 'Racunari', false, null);
insert into category values (null, 'Nekretnine', false, null);
insert into category values (null, 'Kuce', false, 3);
insert into category values (null, 'Vikendice', false, 4);
insert into category values (null, 'Stanovi', false, 3);
insert into category values (null, 'Vozila', false, null);
insert into category values (null, 'Automobili', false, 7);

insert into attribute values (null, 1, 'Proizvodjac', false);
insert into attribute values (null, 1, 'Kamera', false);
insert into attribute values (null, 2, 'RAM', false);
insert into attribute values (null, 2, 'HDD', false);
insert into attribute values (null, 4, 'Broj kvadrata', false);
insert into attribute values (null, 5, 'Poseban atribut vikendice', false);
insert into attribute values (null, 6, 'Broj kvadrata', false);
insert into attribute values (null, 6, 'Broj soba', false);
insert into attribute values (null, 6, 'Sprat', false);
insert into attribute values (null, 6, 'Vrsta grijanja', false);
insert into attribute values (null, 8, 'Proizvodjac', false);
insert into attribute values (null, 8, 'Model', false);
insert into attribute values (null, 8, 'Godiste', false);
insert into attribute values (null, 8, 'Kilometraza', false);

insert into product values (null, 'Samsung A52', "U odličnom stanju", 350.0, false, '000-111-111', 1, "Vuka Karadzica 1, Banja Luka");
insert into product values (null, 'Samsung s22', "Nije koristen, dolazi u originalnom pakovanju", 1000.0, false, '000-111-111', 1, "Vuka Karadzica 1, Banja Luka"); 
insert into product values (null, 'Porodicna kuca', "Ima bazen i veliko dvoriste", 500000.0, false, '000-111-222', 4, "Desanke Maksimovic, Prijedor"); 
insert into product values (null, 'Stan', 'Na odličnoj lokaciji', 100000, false, '000-222-222', 6, "Nikole Pasica, Banja Luka");
insert into product values (null, 'Automobil', 'Uradjen veliki i mali servis', 30000, false, '000-555-222', 8, "Omarska bb, Prijedor");

insert into value values (1, 1, 1, "SAMSUNG");
insert into value values (1, 2, 1, "64MP");
insert into value values (2, 1, 1, "SAMSUNG");
insert into value values (2, 2, 1, "128MP");
insert into value values (3, 5, 4, "128MP");
insert into value values (4, 7, 6, "75");
insert into value values (4, 8, 6, "3");
insert into value values (4, 9, 6, "6");
insert into value values (4, 10, 6, "Na struju");
insert into value values (5, 11, 8, "Mercedes");
insert into value values (5, 12, 8, "c220");
insert into value values (5, 13, 8, "2020");
insert into value values (5, 14, 8, "100.000");

insert into image values (null, "https://cdn.mos.cms.futurecdn.net/uXRPCFseYGPxjG45pFyRpR.jpg", 1);
insert into image values (null, "https://images.samsung.com/is/image/samsung/assets/ba/galaxy-a52/buy/galaxy-a52/03_colorsection/a52_04_colorselection/a52/A52_Violet_ColorSelection_MO_img.jpg", 1);
insert into image values (null, "https://www.leparisien.fr/resizer/bdUyFmvEaF7CjIqgXN967qqvKXs=/932x582/cloudfront-eu-central-1.images.arcpublishing.com/lpguideshopping/ZO547QVKNVER7IML5SZMPAUM2Y.jpg", 2);
insert into image values (null, "https://images.frandroid.com/wp-content/uploads/2022/03/samsung-galaxy-s22-4-scaled.jpg", 2);
insert into image values (null, "https://images.samsung.com/is/image/samsung/assets/ba/smartphones/galaxy-s22/images/galaxy-s22-share-image.jpg?$ORIGIN_JPG$", 2);
insert into image values (null, "https://manager.ba/sites/default/files/Moderna%20ku%C4%87a%20s%20potkrovljem%20DETALJAN%20PLAN%20%2810%29.jpg", 3);
insert into image values (null, "https://www.area.ba/wp-content/uploads/2021/02/1660_1_1612176870-1024x684.jpg", 4);
insert into image values (null, "https://www.hidrokop.com/images/panorama/slider/donji-slajder.jpg", 4);
insert into image values (null, "https://www.hidrokop.com/images/panorama/slider/no%C4%87-2.jpg", 4);
insert into image values (null, "https://www.motorbeam.com/wp-content/uploads/2015-Mercedes-C-Class-Diesel-Test-Drive-Review.jpg", 5);
insert into image values (null, "https://bluesky.cdn.imgeng.in/cogstock-images/cit-1ed7034bb19ef0c0fa07813e3d6883f8551bfe20.jpg?width=150", 5);

insert into offer values (null, 1, 1, true, false);
insert into offer values (null, 1, 2, true, false);
insert into offer values (null, 2, 3, true, false);
insert into offer values (null, 3, 4, true, false);
insert into offer values (null, 3, 5, true, false);

insert into message values (null, "Moja prva poruka korisnickoj podrsci...", 3, true, "2023/02/06 14:22:57");
insert into message values (null, "Moja druga poruka korisnickoj podrsci...", 3, false, "2023/02/06 17:05:57");
insert into message values (null, "Jos jedna poruka...", 3, false, "2023/02/06 20:53:57");
insert into message values (null, "Nova poruka korisnickoj podrsci", 3, false, "2023/02/06 22:17:22");
insert into message values (null, "Saljem pozdrave!", 3, false, "2023/02/06 23:53:57");

insert into log values (null, "Testni log 1", "2023/02/06 21:53:57");
insert into log values (null, "Testni log 2", "2023/02/06 21:53:58");
insert into log values (null, "Testni log 3", "2023/02/06 21:53:59");

insert into comment values (null, "Visoka cijena", 2, 1);
insert into comment values (null, "Lijep bazen", 1, 3);
insert into comment values (null, "Sta ima od dodatne opreme?", 1, 5);
