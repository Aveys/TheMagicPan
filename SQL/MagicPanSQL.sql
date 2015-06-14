-- phpMyAdmin SQL Dump
-- version 4.2.10
-- http://www.phpmyadmin.net
--
-- Host: localhost:3306
-- Generation Time: Jun 14, 2015 at 09:07 PM
-- Server version: 5.5.38
-- PHP Version: 5.6.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `themagicpanbd`
--

-- --------------------------------------------------------

--
-- Table structure for table `assoc_recette_ingredients`
--

CREATE TABLE `assoc_recette_ingredients` (
  `id_recette` bigint(20) NOT NULL,
  `id_ingredient` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `assoc_recette_ingredients`
--

INSERT INTO `assoc_recette_ingredients` (`id_recette`, `id_ingredient`) VALUES
  (1, 1),
  (1, 3),
  (1, 8),
  (1, 9),
  (1, 1),
  (1, 3),
  (1, 8),
  (1, 9),
  (1, 1),
  (1, 3),
  (1, 8),
  (1, 9);

-- --------------------------------------------------------

--
-- Table structure for table `commentaire`
--

CREATE TABLE `commentaire` (
  `id_commentaire` bigint(20) unsigned NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_recette` int(11) NOT NULL,
  `titre` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `contenu` varchar(1000) COLLATE utf8_unicode_ci NOT NULL,
  `note` tinyint(4) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `commentaire`
--

INSERT INTO `commentaire` (`id_commentaire`, `id_user`, `id_recette`, `titre`, `contenu`, `note`) VALUES
  (1, 1, 1, 'Recette superbe', 'C''est trop bon avec un peu de vinaigre balsamique en plus', 4),
  (2, 2, 1, 'Magnifique', 'Rien à redire.', 5),
  (3, 2, 2, 'Bon', 'Cette recette est bonne.', 4),
  (4, 2, 3, 'Cool', 'On ne s''en lasse pas !', 5);

-- --------------------------------------------------------

--
-- Table structure for table `ingredients`
--

CREATE TABLE `ingredients` (
  `id_ingredient` bigint(20) unsigned NOT NULL,
  `nom` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `ingredients`
--

INSERT INTO `ingredients` (`id_ingredient`, `nom`) VALUES
  (1, 'Tomate'),
  (2, 'Emmental'),
  (3, 'Mozzarella'),
  (4, 'Anchois'),
  (5, 'Riz'),
  (6, 'Poulet'),
  (7, 'Boeuf'),
  (8, 'Basilic'),
  (9, 'Huile d''olive');

-- --------------------------------------------------------

--
-- Table structure for table `recette`
--

CREATE TABLE `recette` (
  `id_recette` bigint(20) unsigned NOT NULL,
  `titre` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(1000) COLLATE utf8_unicode_ci NOT NULL,
  `note` tinyint(4) NOT NULL,
  `type` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `temps` int(11) NOT NULL,
  `personnes` tinyint(4) NOT NULL,
  `image` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `recette`
--

INSERT INTO `recette` (`id_recette`, `titre`, `description`, `note`, `type`, `temps`, `personnes`, `image`) VALUES
  (1, 'Tomate Mozzarella', 'Ingrédients (pour 4 personnes):\r\n- 4 grosses tomates\r\n- 400g de mozzarella di buffala\r\n- 1 bouquet de basilic\r\n- 2 cuillières à soupe de vinaigre balsamique\r\n- 5 cuillières à soupes d''huile d''olive\r\n- 1 oignon\r\n- sel et poivre\r\n\r\nPréparation de la recette : \r\nLaver le basilic et le réserver. Couper la mozzarella en tranches fines. Couper les tomates en lamelles.\r\n\r\nEplucher, puis émincer l''oignon.\r\n\r\nCiseler le basilic et le réserver.\r\n\r\nMettre le tout dans un saladier. ', 5, 'Salad', 10, 4, ''),
  (2, 'Pâte à crepes', 'Ingrédients (pour 15 crèpes):\r\n- 300g de farine\r\n- 3 oeufs\r\n- 3 cuillières à soupe de sucre\r\n- 2 cuillières à soupe d''huile\r\n- 50g de beurre fondu\r\n- lait (30cl)\r\n- petit verre à liqueur de rhum', 4, 'Dessert', 10, 5, ''),
  (3, 'La seule l''unique tartiflette', 'Ingrédients (pour 4 personnes):\r\n- 1 kg de pommes de terre\r\n- 200g de lardons fumés\r\n- 200g d''oignons émincés\r\n- 1 reblochon\r\n- huile (2 cuillières à soupe)\r\n- ail, sel, poivre', 5, 'Salad', 15, 4, '');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` bigint(20) unsigned NOT NULL,
  `lastname` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `surname` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `age` tinyint(4) NOT NULL,
  `mail` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `login` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `admin` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `lastname`, `surname`, `age`, `mail`, `login`, `password`, `admin`) VALUES
  (1, 'Doe', 'John', 20, 'admin@admin.com', 'admin', 'admin', 1),
  (2, 'Dupont', 'Jean', 45, 'aze@aze.fr', 'jean', 'jean', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `commentaire`
--
ALTER TABLE `commentaire`
ADD PRIMARY KEY (`id_commentaire`), ADD UNIQUE KEY `id_commentaire` (`id_commentaire`);

--
-- Indexes for table `ingredients`
--
ALTER TABLE `ingredients`
ADD PRIMARY KEY (`id_ingredient`), ADD UNIQUE KEY `id_ingredient` (`id_ingredient`);

--
-- Indexes for table `recette`
--
ALTER TABLE `recette`
ADD PRIMARY KEY (`id_recette`), ADD UNIQUE KEY `id_recette` (`id_recette`), ADD UNIQUE KEY `id_recette_2` (`id_recette`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
ADD PRIMARY KEY (`id_user`), ADD UNIQUE KEY `id_user` (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `commentaire`
--
ALTER TABLE `commentaire`
MODIFY `id_commentaire` bigint(20) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `ingredients`
--
ALTER TABLE `ingredients`
MODIFY `id_ingredient` bigint(20) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `recette`
--
ALTER TABLE `recette`
MODIFY `id_recette` bigint(20) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
MODIFY `id_user` bigint(20) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;