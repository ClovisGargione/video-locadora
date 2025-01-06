CREATE TABLE IF NOT EXISTS `authority` (
  `id` varchar(255) NOT NULL,
  `name` enum('ROLE_ADMIN','ROLE_SUPER_ADMIN','ROLE_USER') NOT NULL,
  `usuario_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7p6ubyq3p0xx7skxuibjcm1va` (`usuario_id`),
  CONSTRAINT `FK7p6ubyq3p0xx7skxuibjcm1va` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci