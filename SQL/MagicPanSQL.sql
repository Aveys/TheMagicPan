SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;


DROP TABLE IF EXISTS assoc_recette_ingredients;
CREATE TABLE IF NOT EXISTS assoc_recette_ingredients (
  id_recette bigint(20) NOT NULL,
  id_ingredient bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO assoc_recette_ingredients (id_recette, id_ingredient) VALUES
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

DROP TABLE IF EXISTS commentaire;
CREATE TABLE IF NOT EXISTS commentaire (
  id_commentaire bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  id_user int(11) NOT NULL,
  id_recette int(11) NOT NULL,
  titre varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  contenu varchar(1000) COLLATE utf8_unicode_ci NOT NULL,
  note tinyint(4) NOT NULL,
  PRIMARY KEY (id_commentaire),
  UNIQUE KEY id_commentaire (id_commentaire)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=3 ;

INSERT INTO commentaire (id_commentaire, id_user, id_recette, titre, contenu, note) VALUES
  (1, 1, 1, 'Recette de ouf', 'C''eest trop bon avec un peu de vinaigre balsamique en plus', 4),
  (2, 1, 1, 'Ouais', 'IL a raison', 5);

DROP TABLE IF EXISTS ingredients;
CREATE TABLE IF NOT EXISTS ingredients (
  id_ingredient bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  nom varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (id_ingredient),
  UNIQUE KEY id_ingredient (id_ingredient)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=10 ;

INSERT INTO ingredients (id_ingredient, nom) VALUES
  (1, 'Tomate'),
  (2, 'Emmental'),
  (3, 'Mozzarella'),
  (4, 'Anchois'),
  (5, 'Riz'),
  (6, 'Poulet'),
  (7, 'Boeuf'),
  (8, 'Basilic'),
  (9, 'Huile d''olive');

DROP TABLE IF EXISTS recette;
CREATE TABLE IF NOT EXISTS recette (
  id_recette bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  titre varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  description varchar(1000) COLLATE utf8_unicode_ci NOT NULL,
  note tinyint(4) NOT NULL,
  `type` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  temps int(11) NOT NULL,
  personnes tinyint(4) NOT NULL,
  image varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (id_recette),
  UNIQUE KEY id_recette (id_recette),
  UNIQUE KEY id_recette_2 (id_recette)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=2 ;

INSERT INTO recette (id_recette, titre, description, note, type, temps, personnes, image) VALUES
  (1, 'Tomate Mozzarella', 'Une tomate mozza quoi! ', 5, 'Salad', 0, 4, '');

DROP TABLE IF EXISTS user;
CREATE TABLE IF NOT EXISTS `user` (
  id_user bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  lastname varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  surname varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  age tinyint(4) NOT NULL,
  mail varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  login varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  admin tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (id_user),
  UNIQUE KEY id_user (id_user)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=3 ;

INSERT INTO user (id_user, lastname, surname, age, mail, login, password, admin) VALUES
  (1, 'admin', 'admin', 20, 'admin@admin.com', 'admin', 'admin', 1),
  (2, 'aze', 'aze', 12, 'aze@aze.aze', 'aze', 'aze', 0);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
