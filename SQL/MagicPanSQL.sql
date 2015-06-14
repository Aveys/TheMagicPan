-- phpMyAdmin SQL Dump
-- version 4.2.10
-- http://www.phpmyadmin.net
--
-- Host: localhost:3306
-- Generation Time: Jun 14, 2015 at 08:38 PM
-- Server version: 5.5.38
-- PHP Version: 5.6.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `themagicpanbd`
--

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

--
-- Indexes for dumped tables
--

--
-- Indexes for table `commentaire`
--
ALTER TABLE `commentaire`
ADD PRIMARY KEY (`id_commentaire`), ADD UNIQUE KEY `id_commentaire` (`id_commentaire`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `commentaire`
--
ALTER TABLE `commentaire`
MODIFY `id_commentaire` bigint(20) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;