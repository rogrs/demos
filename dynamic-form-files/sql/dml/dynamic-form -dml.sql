
INSERT INTO `pergunta` (`id`, `pergunta`, `componente`, `sequencia`) VALUES
(1, 'Qual é o seu nome?', 'text', 1),
(2, 'Você estuda?', 'radio', 2),
(3, 'Você cumprimenta estranhos na rua?', 'radio', 3),
(4, 'Quem faz os serviços domésticos na sua casa?', 'text', 4),
(5, 'Você acha que as vezes acaba comprando produtos sem necessidade?', 'radio', 5),
(6, 'Você fuma?', 'radio', 6),
(7, 'Qual é a cor dos seus olhos?', 'select', 7),
(8, 'Qual a sua altura?', 'text', 8),
(9, 'Usa aparelho, tem pirceng ou tatuagem?', 'text', 9),
(10, 'Você acha que os produtos caros são os melhores?', 'radio', 10),
(11, 'O que você queria ser quando era criança?', 'text', 11),
(12, 'Qual o nome do seu melhor amigo??', 'text', 12),
(13, 'Você tem algum aninal?', 'radio', 13),
(14, 'Você já saiu do país?', 'radio', 14),
(15, 'Qual tipo de filme favorito?', 'select', 15),
(16, 'Qual seu programa de TV favorito?', 'text', 16),
(17, 'Qual seu livro favorito?', 'text', 17),
(18, 'Bebida favorita?', 'text', 18),
(19, 'Loja de roupa favorita?', 'text', 19),
(20, 'Lugar favorito?', 'text', 20),
(21, 'Você prefere Facebook ou Twitter?', 'radio', 21),
(22, 'Qual é o modelo do seu celular?', 'select', 22),
(23, 'Você quer ter quantos filhos?', 'text', 23),
(24, 'Você acredita em Deus?', 'radio', 24),
(25, 'O YouTube é coisa de quem não tem o que fazer?', 'radio', 25),
(26, 'O que você mais gosta de fazer?', 'radio', 26),
(27, 'Qual foi o último filme que você assistiu?', 'radio', 27),
(28, 'Para qual time que você torce?', 'text', 28),
(29, 'Quantas pessoas moram com você?', 'number', 29),
(30, 'Qual é a sua data de nascimento?', 'date', 30);


INSERT INTO `pergunta_values` (`id`, `idpergunta`, `chave`, `valor`) VALUES
(1, 2, 'radioSim', 'Sim'),
(2, 2, 'radioNao', 'Não'),
(3, 3, 'radioSim', 'Sim'),
(4, 3, 'radioNao', 'Não'),
(5, 7, 'optionA', 'Azuis'),
(6, 7, 'optionB', 'Castanhos'),
(7, 7, 'optionC', 'Castanhos Claros'),
(8, 7, 'optionD', 'Negros'),
(9, 15, 'filmeA', 'Ação'),
(10, 15, 'filmeB', 'Drama'),
(11, 15, 'filmeC', 'Romance'),
(12, 15, 'filmeD', 'Suspense'),
(13, 15, 'filmeE', 'Terror'),
(14, 22, 'modelSOCellA', 'Motorola'),
(15, 22, 'modelSOCellB', 'Samsung'),
(16, 22, 'modelSOCellC', 'Iphone'),
(17, 22, 'modelSOCellD', 'Windows'),
(18, 22, 'modelSOCellE', 'Outros');


INSERT INTO `projeto` (`id`, `dtcreate`, `enabled`, `nmprojeto`) VALUES
(1, NULL, 1, 'OiFixoControle'),
(2, NULL, 1, 'OiTV'),
(3, NULL, 1, 'OiControle'),
(4, NULL, 1, 'TIM Fiber');


INSERT INTO `propriedades` (`id`, `chave`, `dtcreate`, `enabled`, `valor`) VALUES
(1, 'UPLOAD_PATH', NULL, 1, '/home/rogerio/arquivos/');


INSERT INTO `usuarios` (`id`, `username`, `fullname`, `pwd`, `salt`, role, `dtcreate`, `enable`) VALUES
(1, 'admin', 'Administrador', 'admin2015', 'salt2015', 'ADMIN', '2015-04-09 21:15:10', 1);
INSERT INTO `usuarios` (`id`, `username`, `fullname`, `pwd`, `salt`, role, `dtcreate`, `enable`) VALUES
(2, 'user', 'User', 'user2015', 'saltu2015', 'USER', '2015-04-09 21:15:10', 1);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
