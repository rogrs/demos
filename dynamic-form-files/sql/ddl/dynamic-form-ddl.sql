SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

CREATE TABLE IF NOT EXISTS `projetos` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `projeto` varchar(255) NOT NULL,
  `dtcreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `enabled` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `casotestes` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `casoteste` varchar(255) NOT NULL,
  `dtcreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `enabled`  int(11) NOT NULL DEFAULT '1',
  `idprojeto` bigint(20) NOT NULL,
  PRIMARY KEY(`id`),
  KEY `fk_casoteste_projeto` (`idprojeto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `eventos` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dtcreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `hostname` varchar(255) DEFAULT NULL,
  `msg` varchar(255) DEFAULT NULL,
  `sistema` varchar(255) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `usuario` varchar(255) DEFAULT NULL,
   PRIMARY KEY(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `formulario` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `estuda` varchar(10) DEFAULT NULL,
  `cumprimenta` varchar(10) DEFAULT NULL,
  `domesticos` varchar(100) DEFAULT NULL,
  `compra` varchar(100) DEFAULT NULL,
  `fuma` varchar(100) DEFAULT NULL,
  `olhos` varchar(100) DEFAULT NULL,
  `altura` varchar(100) DEFAULT NULL,
  `aparelho` varchar(100) DEFAULT NULL,
  `caros` varchar(100) DEFAULT NULL,
  `crescer` varchar(100) DEFAULT NULL,
  `amigo` varchar(100) DEFAULT NULL,
  `animal` varchar(100) DEFAULT NULL,
  `pais` varchar(100) DEFAULT NULL,
  `filme` varchar(100) DEFAULT NULL,
  `tv` varchar(100) DEFAULT NULL,
  `livro` varchar(100) DEFAULT NULL,
  `bebida` varchar(100) DEFAULT NULL,
  `loja` varchar(100) DEFAULT NULL,
  `lugar` varchar(100) DEFAULT NULL,
  `rede` varchar(100) DEFAULT NULL,
  `modelo` varchar(100) DEFAULT NULL,
  `filhos` varchar(100) DEFAULT NULL,
  `deus` varchar(100) DEFAULT NULL,
  `youtube` varchar(100) DEFAULT NULL,
  `fazer` varchar(100) DEFAULT NULL,
  `assistiu` varchar(100) DEFAULT NULL,
  `torcida` varchar(100) DEFAULT NULL,
  `oculos` varchar(100) DEFAULT NULL,
  `moram` varchar(100) DEFAULT NULL,
  `dtcreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
   PRIMARY KEY(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `formularios` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `formulario` varchar(80) NOT NULL,
  `dtcreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `enabled`  int(11) NOT NULL DEFAULT '1',
   PRIMARY KEY(`id`)
)  ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `perguntas` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pergunta` varchar(200) NOT NULL,
  `componente` varchar(80) DEFAULT NULL,
  `sequencia` int(11) DEFAULT NULL,
  `idformulario` bigint(20) NOT NULL,
   PRIMARY KEY(`id`),
   KEY `fk_pergunta_formulario` (`idformulario`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `pergunta_values` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `idpergunta` bigint(20) NOT NULL,
  `chave` varchar(30) NOT NULL,
  `valor` varchar(50) NOT NULL,
  PRIMARY KEY(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `propriedades` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `chave` varchar(255) DEFAULT NULL,
  `enabled` int(11) DEFAULT NULL,
  `valor` varchar(255) DEFAULT NULL,
  `dtcreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=latin1;


CREATE TABLE IF NOT EXISTS `respostas` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `idpergunta` bigint(20) NOT NULL,
  `resposta` varchar(100) NOT NULL,
  `dtcreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY(`id`),
  KEY `fk_resposta_pergunta` (`idpergunta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE IF NOT EXISTS `formulario_files` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `idformulario` bigint(20) NOT NULL,
  `filepath` varchar(300) NOT NULL,
  `dtcreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `tarefas` (
  `id` bigint(20) NOT NULL,
  `tarefa` varchar(80) DEFAULT NULL,
  `dtcreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `enabled` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` bigint(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  `fullname` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `pwd` varchar(1024) NOT NULL,
  `salt` varchar(512) NOT NULL,
  `role` varchar(30) NOT NULL,
  `dtcreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `enable` int(11) NOT NULL DEFAULT '1',
   PRIMARY KEY(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=latin1;



CREATE TABLE IF NOT EXISTS `pais` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(60) DEFAULT NULL,
  `sigla` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=0;


CREATE TABLE IF NOT EXISTS `estado` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(75) DEFAULT NULL,
  `uf` varchar(5) DEFAULT NULL,
  `pais` int(7) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Estado_pais` (`pais`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=0;


CREATE TABLE IF NOT EXISTS `cidade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(120) DEFAULT NULL,
  `estado` int(5) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Cidade_estado` (`estado`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=0;



/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
