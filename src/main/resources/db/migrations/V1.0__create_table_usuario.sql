CREATE TABLE IF NOT EXISTS `usuario` (
  `id` varchar(255) NOT NULL,
  `conta_nao_bloqueada` bit(1) DEFAULT NULL,
  `conta_nao_expirada` bit(1) DEFAULT NULL,
  `credencial_nao_expirada` bit(1) DEFAULT NULL,
  `data_ultima_redefinicao_de_senha` datetime(6) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `habilitado` bit(1) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci