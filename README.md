# TheMagicPan
Mini-projet J2E de gestion de recette de cuisine

Utilisation de JSF et Primefaces.
Compilé avec Java 1.8.0 & Java 1.7.0.67

## Installation
1. Charger le script d'initialisation SQL présent dans le dossier SQL (MagicPanSQL.sql)
2. Modifier les identifiants de connexions à la base de donnée dans la classe src/dao/fabric/ConfMysql.java avec vos identifiants
   Ou utiliser la configuration par défaut (localhost:3306 root:<MDP vide>)
3. Déployer le site sur Tomcat (WAR fourni dans le répertoire out au cas où)
4. Accéder au site (http://localhost:8080/)

## Comptes Utilisateurs

login / password
Admin/Admin : Compte administrateur
jean/jean : Compte utilisateur

## Etat du projet

* Recherche de recette par critères fonctionnelles
* Création de commentaire sur les recettes avec AJAX
* Interface d'administration fonctionnelle
* Sécurisation des accés en AJAX (Login obligatoire pour poster un commentaire, être admin pour acceder au panel d'administration)
* interface agréable




