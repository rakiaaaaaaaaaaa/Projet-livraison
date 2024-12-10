Description du Projet : 
Ce projet simule un système de gestion de livraison de colis avec une interface graphique intuitive. Il permet d'ajouter des colis, de suivre leur état (en attente, en transit, livré), et de gérer plusieurs utilisateurs grâce à des outils de synchronisation.

Le projet utilise JavaFX pour l'interface graphique et des outils de concurrence comme les threads et les sémaphores pour garantir la sécurité des données.

Fonctionnalités :

Enregistrement des Colis :
Ajoutez des colis avec un ID unique, une description et une destination.
Les colis sont initialement marqués comme "En attente".

Mise en Transit :
Mettez un colis en état "En transit" pour simuler le déplacement vers sa destination.

Livraison des Colis :

Marquez un colis comme "Livré" une fois arrivé à destination.
Affichage des Colis :
Une table interactive dans l'interface graphique affiche les colis ajoutés avec leurs états.

Gestion Concurrente :
Plusieurs threads peuvent ajouter ou modifier les colis simultanément grâce à des mécanismes de synchronisation (sémaphores et moniteurs).


Technologies Utilisées :

Langage : Java
Interface Graphique : JavaFX
Synchronisation : Threads, Sémaphores
Outils de Développement :Eclipse


Installation et Exécution
Clonez le dépôt GitHub 
Importez le projet dans votre IDE préféré (IntelliJ IDEA ou Eclipse).
Exécutez la classe Main comme programme principal.

Structure du Projet
Packages et Classes
Colis : Représente un colis avec ses propriétés (ID, description, destination, état).
GestionnaireColis : Gère les colis et assure la synchronisation des threads.
InterfaceGraphique : Interface utilisateur pour interagir avec le système.

Gestion de Concurrence
Le projet garantit la sécurité des données en utilisant :

Threads : Chaque action (ajout, mise en transit, livraison) est exécutée dans un thread pour éviter le blocage de l'interface graphique.
Sémaphores : Limitent l'accès aux ressources critiques lors de l'ajout ou de la modification d’un colis.
Moniteurs : Assurent que les données des colis restent cohérentes en cas d'accès simultané.
