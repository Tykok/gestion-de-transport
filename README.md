# Consignes

Dans ce TP vous devez mettre en place une API pour la Gestion de transport style
Uber
L’application doit disposer de deux types d’utilisateurs
- Les Clients
- Les chauffeurs qui comportent deux types :
- Les chauffeurs de voiture
- Les motard

## Base de données monotable
Mettez en place la base de données avec la table utilisateur
Un utilisateur dispose d’un id d’un nom, prénom d’une date de naissance,
d’une date d’inscription et d’un type.

## CRUD Simple :
- [ ] Ajouter le service permettant d’insérer un utilisateur en base.
- [ ] Ajouter le service permettant de récupérer la liste de tous les utilisateurs.
- [ ] Ajouter le service permettant de récupérer un utilisateur par son Id.
- [ ] Ajouter le service permettant de supprimer un utilisateur avec son Id.

## Exploitation des données.
- [ ] Ajouter un point de terminaison permettant de compter le nombre
  d’utilisateurs par type


Exemple :
```json
{
"Clients" : 59 ,
"Motards" : 12,
"Chauffeur" : 33,
}
```

CDAN 2022
- [ ] Ajouter un point de terminaison permettant renvoyer l’âge moyen de tout
  de tous les utilisateurs.
- [ ] Ajouter un service permettant de récupérer les informations d’un utilisateur
  sous ce format :

```json
{
"Type" : "CHAUFFEUR",
"DisplayName" : "Thomas CLAMON",
"Age" : 31,
"NbJourActif" : 456
}
```

# Partie 3 Bonus

## Base de données multi table
- [ ] Ajoutez la table course à votre base de données. Une course possède

- un ID unique,
- l’ID du client
- l’ID du chauffeur
- la date de la course
- le temps de trajet
- la distance parcouru

## Exploitation des données

- [ ] Ajouter un point de terminaison d’afficher le nombre de course d’un client, et la somme de la distance parcouru.

Exemple :

```json
{
"Client" : "Thomas CLAMON",
"NbCourse" :12,
"Distance_total" : 7532
}
```

# Mise en place

## Fichier ``application.properties`

Avant de démarrer l'application, vous devez créer votre base de données MySQL.

```sql
CREATE DATABASE IF NOT EXISTS `gestionnaire_transport`;
USE `gestionnaire_transport`;
```

Par la suite, il suffira d'utiliser le script SQL ``create_tables.sql`` afin de créer les tables.

```bash
mysql -u <user> -p < create_tables.sql
```

Par la suite, il suffira de modifier le fichier ``application.properties`` en ajoutant les informations de connexion à votre base de données (user, password).

# Documentation API

Le [lien](https://documenter.getpostman.com/view/12631609/Uyr5oesV) vers la documentation du projet.

Celle-ci a été générer avec Postman.

# MCD

![image](https://user-images.githubusercontent.com/56304246/164949247-3bc242af-3735-4c83-9334-3649516cdf0e.png)
