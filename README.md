# Partie 1

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
- Ajouter le service permettant d’insérer un utilisateur en base.
- Ajouter le service permettant de récupérer la liste de tous les utilisateurs.
- Ajouter le service permettant de récupérer un utilisateur par son Id.
- Ajouter le service permettant de supprimer un utilisateur avec son Id.

## Exploitation des données.
- Ajouter un point de terminaison permettant de compter le nombre
  d’utilisateurs par type


Exemple :
```json
{
Clients : 59 ,
Motards : 12,
Chauffeur : 33,
}
```

CDAN 2022
- Ajouter un point de terminaison permettant renvoyer l’âge moyen de tout
  de tous les utilisateurs.
- Ajouter un service permettant de récupérer les informations d’un utilisateur
  sous ce format :

```json
{
Type : CHAUFFEUR,
DisplayName : Thomas CLAMON
Age : 31
NbJourActif : 456
}
```

# Partie 3 Bonus

## Base de données multi table
Ajoutez la table course à votre base de données. Une course possède

- un ID unique,
- l’ID du client
- l’ID du chauffeur
- la date de la course
- le temps de trajet
- la distance parcouru

## Exploitation des données

Ajouter un point de terminaison d’afficher le nombre de course
d’un client, et la somme de la distance parcouru.

Exemple :
```json
{
Client : "Thomas CLAMON" ,
 NbCourse :12
Distance_total : 7532
}
```
