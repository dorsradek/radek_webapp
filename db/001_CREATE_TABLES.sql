CREATE TABLE IF NOT EXISTS `security_role` (
`id` INT(11) NOT NULL AUTO_INCREMENT ,
`name` VARCHAR(50) NULL DEFAULT NULL ,
PRIMARY KEY (`id`) )
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;
 
CREATE TABLE IF NOT EXISTS `user` (
`id` INT(11) NOT NULL AUTO_INCREMENT ,
`first_name` VARCHAR(45) NULL DEFAULT NULL ,
`family_name` VARCHAR(45) NULL DEFAULT NULL ,
`dob` DATE NULL DEFAULT NULL ,
`password` VARCHAR(45) NOT NULL ,
`username` VARCHAR(45) NOT NULL ,
`confirm_password` VARCHAR(45) NOT NULL ,
`active` TINYINT(1) NOT NULL ,
PRIMARY KEY (`id`) ,
UNIQUE INDEX `username` (`username` ASC) )
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = latin1;
 
CREATE TABLE IF NOT EXISTS `user_security_role` (
`user_id` INT(11) NOT NULL ,
`security_role_id` INT(11) NOT NULL ,
PRIMARY KEY (`user_id`, `security_role_id`) ,
INDEX `security_role_id` (`security_role_id` ASC) ,
CONSTRAINT `user_security_role_ibfk_1`
FOREIGN KEY (`user_id` )
REFERENCES `user` (`id` ),
CONSTRAINT `user_security_role_ibfk_2`
FOREIGN KEY (`security_role_id` )
REFERENCES `security_role` (`id` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;