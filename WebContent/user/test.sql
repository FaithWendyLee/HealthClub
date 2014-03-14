CREATE TABLE `payments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `money` int(11) NOT NULL,
  `card_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK526A0F2D9BB41B7F` (`card_id`),
  CONSTRAINT `FK526A0F2D9BB41B7F` FOREIGN KEY (`card_id`) REFERENCES `cards` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(50) NOT NULL,
  `age` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `sex` int(11) NOT NULL,
  `card_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6A68E089BB41B7F` (`card_id`),
  CONSTRAINT `FK6A68E089BB41B7F` FOREIGN KEY (`card_id`) REFERENCES `cards` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `activities` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `place` varchar(50) NOT NULL,
  `time` date NOT NULL,
  `coach_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7A1B3BED1B34AED3` (`coach_id`),
  CONSTRAINT `FK7A1B3BED1B34AED3` FOREIGN KEY (`coach_id`) REFERENCES `employees` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `attendances` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `activity_id` int(11) NOT NULL DEFAULT '0',
  `card_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`activity_id`,`card_id`),
  KEY `FKB1E47AAA739F3C9F` (`activity_id`),
  KEY `FKB1E47AAA9BB41B7F` (`card_id`),
  CONSTRAINT `FKB1E47AAA9BB41B7F` FOREIGN KEY (`card_id`) REFERENCES `cards` (`id`),
  CONSTRAINT `FKB1E47AAA739F3C9F` FOREIGN KEY (`activity_id`) REFERENCES `activities` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;