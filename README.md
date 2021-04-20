# OpenClassrooms

Ce dépôt contient une mini-application pour le P3 du parcours **Grande École du Numérique**.


Voici comment obtenir cette application :

1 : Cliquez sur le bouton vert "Code" et sélectionnez "Download ZIP".

2 : Sélectionnez le dossier contenant le code de l'application et placez le à l'emplacement
souhaité sur votre machine.

3 : Lancez Android Studio.

4 : Sur la page d'accueil cliquez sur "Open an Existing Project".

5 : Sélectionnez le fichier de l'application.

6 : Vous devez avoir installé un émulateur virtuel ou bien branché un smartphone physique à votre machine

7 : Vérifiez que "App" est sélectionnez dans la liste déroulante en haut à droite du marteau vert

8 : Dans la liste déroulante à droite de "App" sélectionnez l'émulateur souhaité puis cliquez sur la
flèche verte à droite ("Run App") pour lancer l'application



Modifications et ajouts apportés par Gabrielle Freville :

* Ajout de la page de détails des voisins et son activité

* Ajout du lien Facebook

* Création de la liste des favoris

* Ajout des méthodes d'ajout et de suppression d'un voisin favori

* Ajout de la méthode d'accès à la liste des favoris

* Ajout d'un boolean au fragment pour que celui-ci affiche la vue des voisins de base ou la vue des voisins favoris

* Réception du clic de l'utilisateur par le RecyclerView puis transmission du message via EventBus

* Ajout d'un nouvel Event pour le clic sur un voisin spécifique

* Ajout d'un paramètre boolean pour les deux Events déterminant s'il s'agit d'un voisin favori ou non

* Comparaison des boolean par le fragment

* Ajout des méthodes appelées après réception des messages de clic dans le fragment

* Activation du fragment des favoris dans ListNeighbourPagerAdapter

* Ajout de quatre tests unitaires locaux pour les fonctions liées à la liste des favoris et à la
fonction d'ajout d'un voisin

* Ajout de deux tests instrumentalisés vérifiant l'affichage de l'écran d'ajout et de l'écran de détails