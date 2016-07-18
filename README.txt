Ce projet est un projet maven séparé en 1 pom parent et 3 modules:
	- Un module jar, commun contenant les beans et les enums nécessaires à la bonne exécution du programme
	- Un module jar service exposable à un programme externe: main, client web service etc.
	- Un module jar main représentant la partie cliente, utilisant les services, permettant de répondre aux besoins mowitnow
	
Actuellement le module main a une dépendence sur le module service. A terme on pourrait créer des controllers et exposer les services sous une forme de webservices pour que n'importe quel client souhaitant 
utiliser les services puisse se référer au contrat de service et faire ses appels comme il le souhaite.

Pour utiliser le projet il suffit de lancer la commande "mvn clean install package" dans le dossier du projet parent. Ensuite aller chercher le jar executable "mowItNow.jar".
Enfin executer la commande "java -jar mowItNow.jar <pathFileIn> <namePathFileOut>"
