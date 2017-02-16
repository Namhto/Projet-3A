# Projet-3A
Projet de 3e année informatique et réseaux - ENSISA

Etudiants : MARCIA Maxime, TENICH Othman
Encadrant : BOURGEOIS Florent

La branche principale contient un projet IntelliJ avec les sources. Le projet consiste en : 

 - Une application JAVA
 - Des sources prolog contenant un serveur
 - Un dossier **Application** contenant un .jar exécutable

*Utilisation de l'application :*

On peut ajouter des enseignants, des cours et des salles.

Vue principale de l'application
https://lh5.googleusercontent.com/oSyldKBfkiF1XBUepsXWJhYh8azzNFXGKXwiJC8vyItovAtyIKgBNPi0DF3xbtgde-mqUw2yxlJ7-Jg=w1920-h918

Ajouter la relation "enseigne" entre un prof et une matière
https://lh4.googleusercontent.com/ihREc842M_uQbRoTLzTln-uVuXdpYdoU1-NiAqc5XWExYag2k0FHIxnFQv7MxLlG5Pbm8d1Fis0TqLM=w1920-h918

**Il faut impérativement ajouter au moins une fois cette relation pour que l'algorithme fonctionne.**

Enfin dans l'onglet "Fichier" du menu il faut "Exporter" puis "Générer". L'emplois du temps est alors stocké sous format XML.

*Structure du code JAVA :*

La classe principale est **MainApp.java**
Cette classe permet de lancer l'application en peuplant par défaut le modèle avec quelques profs / cours / salles.

Pour enlever ce comportement, il suffit de supprimer les lignes dans le constructeur de la classe.

**Attention :** Ne pas enlever ces lignes car c'est le menu de gauche

    items.add("Enseignants");
    items.add("Cours");
    items.add("Salles");

Le package **Model** contient le modèle métier des objets manipulés (Teacher, Room...).

Le package **View** contient les fichier .fxml et leur contrôleurs. Ces fichiers servent à construire l'interface graphique.

Ainsi, l'action du bouton "Exporter" est décrit dans le méthode **export()** de la classe **RootController**.

Pour modifier ce comportement, c'est dans la classe **ExportToProlog** du package **controller**.

Ce package contient également la classe qui lance le serveur prolog : **TestServer**,
et celle qui parse la réponse du serveur : **TestParseResponse**.

Le serveur est lancé par la ligne de code suivante de la méthode **run()** de **TestServer** :

    Runtime.getRuntime().exec("cmd /c start server\\server.bat");

Cette commande est faite pour **Windows**. Il suffit donc de la remplacer par la commande qu'il faut pour Mac.

Le serveur est lancé par un jar exécutable : **Prolog-Server-Test.jar**. Il se trouve dans le dossier **server**.

Ce .jar est le résultat de la compilation du projet **Prolog-Server-Test**.

Dans la classe principale de ce projet se trouve la méthode main lançant un serveur prolog *a priori* selon l'OS.

    String OS = System.getProperty("os.name").toLowerCase();

        if(OS.indexOf("win") >= 0) {
            ProcessBuilder runServer = new
            ProcessBuilder("powershell.exe");
            runServer.redirectErrorStream(true);
            Process p = runServer.start();
            BufferedWriter p_stdin = new BufferedWriter(new 
            OutputStreamWriter(p.getOutputStream()));
            p_stdin.write("cd 'C:\\Program Files\\swipl\\bin'");
            p_stdin.newLine();
            p_stdin.flush();

            File file = new File("server/prolog/server.pl");
            p_stdin.write(".\\swipl.exe -s"+file.getAbsolutePath());
            p_stdin.newLine();
            p_stdin.flush();

            BufferedReader r = new BufferedReader(new 
            InputStreamReader(p.getInputStream()));
            String line;
            while (true) {
                line = r.readLine();
                if (line == null)
                    break;
                System.out.println(line);
            }
        }
        else if(OS.indexOf("mac") >= 0) {
            ProcessBuilder runServer = new ProcessBuilder("/bin/bash");
            runServer.redirectErrorStream(true);
            Process p = runServer.start();

            BufferedWriter p_stdin = new BufferedWriter(new 
            OutputStreamWriter(p.getOutputStream()));
            p_stdin.write("cd /Applications");
            p_stdin.newLine();
            p_stdin.flush();

            File file = new File("server/prolog/server.pl");
            p_stdin.write("./SWI-Prolog.app -s "+file.getAbsolutePath());
            p_stdin.newLine();
            p_stdin.flush();

            BufferedReader r = new BufferedReader(new 
            InputStreamReader(p.getInputStream()));
            String line;
            while (true) {
                line = r.readLine();
                if (line == null)
                    break;
            }
        }

Je ne suis pas sûr de la commande qui lance le serveur sur Mac. Il faudra surement la corriger.
