CREATE TABLE IF NOT EXISTS `filme` (
  `id` varchar(255) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `capa` varchar(255) DEFAULT NULL,
  `valor` numeric(4,2) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci