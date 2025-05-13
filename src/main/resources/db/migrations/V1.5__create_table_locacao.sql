CREATE TABLE IF NOT EXISTS `locacao` (
  `id` varchar(255) NOT NULL,
  `usuario_id` varchar(255) NOT NULL,
  `filme_id` varchar(255) DEFAULT NULL,
  `valor` numeric(4,2) DEFAULT NULL,
  `data_locacao` datetime(6) NOT NULL,
  `data_devolucao` datetime(6) NOT NULL,
  `valor_locacao` numeric(4,2) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`),
  FOREIGN KEY (`filme_id`) REFERENCES `filme` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci