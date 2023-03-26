import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.concurrent.TimeUnit;

/**
 * @author : Yohann Manseau-Glémot
 * @author : Alex Chevrier
 * @Version 1.00 (12 juillet 2022) 
 * La classe Main contient des méthodes propres 
 * à chaque attributs de la classe Cours. Ces méthodes
 * demande à l'utilisateur d'entrer les informations
 * lui permettant de créer un cours. Ces méthodes contiennent
 * aussi des exceptions qui redemande à l'utilisateur
 * d'entrer une info si celui avait entré quelque chose
 * d'erroné
 */

public class Main{
    //Scanner static qui est utilisé dans toutes les méthodes
    //plus bas qui sont elles aussi static
    private static Scanner scanner = new Scanner(System.in);

    
    
    /** 
     * Déclaration de la méthode matiere qui
     * recueille la matière entré par l'utilisateur
     * @return String
     */
    public static String matiere(){

        String matiere = "";

        //while loop infini qui s'arrête seulement lorsque 
        //l'entrée de l'utilisateur est valide
        while (true){
            
            System.out.println("Entrer la matière du cours: (3 lettres)");
                
            //Dans ce try block, si l'utilisateur entre autre chose que des lettres
            //on lance une exception et si il entre plus ou moins que 3 charactère
            //on lance une exception aussi
            try{
                matiere = scanner.next();

                for (int i = 0; i < matiere.length(); i++){
                    if (!Character.isAlphabetic(matiere.toCharArray()[i]))
                        throw new InputException("La matière doit seulement contenir des lettres");
                        //On utilise notre classe InputException pour annoncer à 
                        //l'utilisateur que son entré est invalide
                }

                if (matiere.length() != 3){
                    throw new InputException("La matière doit contenir trois charactères");
    
                }
                    
            }
                     
            catch (InputException e){
                System.out.println(e.toString());
                continue;
                    
            }
            break; //Si l'entrée est valide on brise la boucle               
        }
        return matiere;
    }
    
    /** 
     * Déclaration de la méthode numero qui recueille
     * le numero du cours entré par l'utilisateur
     * @return int
     */
    public static int numero(){

        int numero = 0;

        //On utilise le même processus pour toutes les variables d'un cours.
        //Les conditions sont différentes pour chacune des variables
        while (true){

            System.out.println("Entrer le numero du cours (4 chiffres): ");
                
            try{

                numero = scanner.nextInt();
                    
                if(Integer.toString(numero).length()!= 4){

                    throw new InputException("Le numéro doit contenir 4 chiffres");
                }
                    
            }
            //On utilise l'exception InputMismatch exception de Java
            //si l'utilisateur entre autre chose qu'un integer   
            catch (InputMismatchException e){

                System.out.println("Vous devez entrer un chiffre");
                //On utilise la ligne ci-dessous pour effacer le contenu du scanner
                //avant de redemander à l'utilisateur d'entrer le numéro du cours
                scanner.nextLine();                    
                continue;  
            }

            catch (InputException e){

                System.out.println(e.toString());
                scanner.nextLine();
                continue;
            }
                
            break; 
        }
        return numero;
        
    }
    
    /** 
     * Déclaration de la méthode jour qui
     * recueille la journée du cours entré
     * par l'utilisateur
     * @return String
     */
    public static String jour(){

        String jour = "";

        //Pour la journée désiré du cours on vérifie si le jour entré par
        //l'utilisateur est présent dans le tableau listejours.
        //Si il ne l'est pas on lance une exception.
        while (true){

            System.out.println("Entrer la journée desire du cours (Lundi à Vendredi): ");
            String[] listeJours = {"Lundi", "Mardi","Mercredi", "Jeudi", "Vendredi"};
            boolean j = false; 

            try{

                jour = scanner.next();
                    
                for (int g = 0; g<listeJours.length; g++){

                    if(listeJours[g].equalsIgnoreCase(jour) == true){

                        j = true;
                    }
                }
                if (j == false){
                    throw new InputException("Journée invalide!");

                }    
    
            }
                     
            catch (InputException e){

                System.out.println(e.toString());
                scanner.nextLine();
                continue;
            }
                
            break;
                
        }
        return jour;
        
    }
    
    /** 
     * Déclaration de la méthode debut qui
     * recueille l'heure de début du cours
     * entré par l'utilisateur
     * @return int
     */
    public static int debut(){

        int debut = 0;

        //Pour l'heure de début on demande à l'utilisateur d'entrer une heure entre 8h et 20h
        //Si l'heure entré se trouve à l'extérieur de cette plage horaire on lance
        //une exception
        while (true){

            System.out.println("Entrer l'heure du debut (entre 8h et 20h): ");
                
            try{

                debut = scanner.nextInt();
                    
                if (debut < 8 || debut>20){

                    throw new InputException("Veuiller respecter la plage horaire");
                }                  
            }
                     
            catch (InputMismatchException e){

                System.out.println("Vous devez entrer un chiffre");
                scanner.nextLine();
                continue;  
            }

            catch (InputException e){
                System.out.println(e.toString());
                scanner.nextLine();
                continue;
            }
                
            break;
                
        }

        return debut;
    }
    
    /** 
     * Déclaration de la méthode fin
     * qui recueille l'heure de fin du cours
     * entré par l'utilisateur
     * @param hDebut
     * @return int
     */
    public static int fin(int hDebut){

        int fin = 0;

        //Pour l'heure de fin, on utilise le même processus que pour l'heure de début
        // sauf que si l'heure de fin est plus petite que l'heure de début
        //on lance aussi une exception. Aussi, la plage horaire pour
        //l'heure de fin est de 9h à 20h car un élève ne peut pas
        //finir un cours à 8h
        while (true){

            System.out.println("Entrer l'heure du fin (entre 9h et 20h): ");
                
            try{

                fin = scanner.nextInt();
                    
                if (fin < 9 || fin>20){

                    throw new InputException("Veuiller respecter la plage horaire");
                }

                if(fin < hDebut){

                    throw new InputException("L'heure de fin doit être plus grande que l'heure de début");
                }
                 
            }
                     
            catch (InputMismatchException e){

                System.out.println("Vous devez entrer un chiffre");
                scanner.nextLine();
                continue;  
            }

            catch (InputException e){

                System.out.println(e.toString());
                scanner.nextLine();
                continue;
            }
                
            break;               
        }
        return fin;
    }
    
    /** 
     * Déclaration de la méthode credits qui
     * recueille le nombre de crédits du cours
     * entré par l'utilisateur
     * @return int
     */
    public static int credits(){

        int credits = 0;

        //Finalement pour le nombre de crédits on demande à l'utilisateur
        //d'entrer un nombre entre 1 et 4, sinon on lance un exception

        while (true){

            System.out.println("Entrer le nombre de credits du cours: (entre 1 et 4 crédits)");
                
            try{

                credits = scanner.nextInt();
                    
                if (credits > 4 || credits<1){

                    throw new InputException("Le chiffre doit se trouver entre 1 et 4");
 
                }
                 
            }
                     
            catch (InputMismatchException e){

                System.out.println("Vous devez entrer un chiffre");
                scanner.nextLine();
                continue;  
            }

            catch (InputException e){

                System.out.println(e.toString());
                scanner.nextLine();
                continue;
            }
                
            break;              
        }
        return credits;
    }
    
    /** 
     * Déclaration de la méthode ajouter
     * qui permet à l'utilisateur d'ajouter
     * le nombre de cours qu'il désire dans sa liste
     * (max 10 cours)
     * @param liste
     */
    public static void ajouter(ArrayList<Cours> liste){

        if(liste.size() >= 10){

            System.out.println("Vous ne pouvez pas ajouter plus de cours");
        }

        else{

            while(liste.size() < 10) {

                System.out.println("Veuillez créer un cours");
                
                //On demande à l'utilisateur d'entré toutes
                // les valeurs des attributs du cours
                // qu'il veut de créer
                String matiere = matiere(); 
                int numero = numero();
                String jour = jour();
                int debut = debut();
                int fin = fin(debut);
                int credits = credits();

                //Ici on ajoute le cours fait par l'utilisateur à la liste
                //déclaré plus haut
                Cours cours = new Cours(numero, matiere, jour, debut, fin, credits);
                liste.add(cours);
                String reponse = "";

                while(true){
                    
                    //On demande à l'utilisateur si il s'ajouter un autre cours
                    System.out.println("Voulez-vous ajouter un autre cours? (Oui/Non): ");
                    //Nous avons ensuite un block try-catch qui lance une exception
                    // si l'utilisateur entre autre chose que Oui ou Non
                    try{
                        reponse = scanner.next();
                        
                        if(reponse.equalsIgnoreCase("Oui") == false){
                            if(reponse.equalsIgnoreCase("Non") == true){
                                break;
                            }
                            else
                                throw new InputException("Veuillez entrez Oui ou Non");
    
                        }
                        else if(reponse.equalsIgnoreCase("Non") == false){
                            if(reponse.equalsIgnoreCase("Oui") == true)
                                break;
                            else
                                throw new InputException("Veuillez entrez Oui ou Non");
                        }
                    }
                    
                    catch(InputException e){
                        System.out.println(e.toString());
                        scanner.nextLine();
                        continue;
                    }
                    break;
                }
                System.out.println(reponse);
                if(reponse.equalsIgnoreCase("Oui")){
                    scanner.nextLine();
                    
                    continue;
                }
                else{
                    break;
                }
            }
        }
    }
    /** 
     * Méthode main qui permet à l'utilisateur de faire
     * sa liste de cours. Par la suite, il peut retirer autant de
     * cours qu'il veut et finalement il pourra modifier autant de cours
     * qu'il veut
     * @param args
     */
    public static void main(String[] args){

        //On créer une ArrayList qui contiendra la liste de cours
        //créer par l'utilisateur
        ArrayList<Cours> liste;
        liste = new ArrayList<Cours>();

       
       
        //On demande à l'utilisateur d'ajouter tous les cours voulu dans sa liste
        //avant de pouvoir en retirer ou en modifier
        System.out.println("Commencez par ajouter tous vos cours (Maximum de 10 cours)");
        ajouter(liste);

       
        //Boucle while infini qui permet à l'utilisateur de retirer
        //le nombre de cours qu'il désire.Celui-ci doit entrer le
        //numéro du cours qu'il désire retirer pour le retirer
        //de sa liste
        String reponse2 = "";
        while(true){

            while(true){
                System.out.println("Voulez-vous retirer un cours? (Oui/Non): ");
                try{
                    reponse2 = scanner.next();
                    if(reponse2.equalsIgnoreCase("Oui") == false){
                        if(reponse2.equalsIgnoreCase("Non") == true){
                            break;
                        }
                        else
                            throw new InputException("Veuillez entrez Oui ou Non");
  
                    }
                    else if(reponse2.equalsIgnoreCase("Non") == false){
                        if(reponse2.equalsIgnoreCase("Oui") == true)
                            break;
                        else
                            throw new InputException("Veuillez entrez Oui ou Non");
                    }
                }
                catch(InputException e){
                    System.out.println(e.toString());
                    scanner.nextLine();
                    continue;
                }
                break;
            }
            

            if(reponse2.equalsIgnoreCase("Oui")){
                //Pour retirer un cours l'utilisateur doit entrer le numero du cours
                System.out.println("Pour retirer un cours, il faut entrer son numero" );
                int reponse3 = numero();
                //Ensuite on retire de la liste le cours correspondant au numero
                for(int k = 0; k<liste.size(); k++){

                    if(liste.get(k).getNum() == reponse3){

                        liste.remove(k);
                        break;
                    }
                  
                }
            }
            else{
                
                break;
            }
        }

        //Boucle while infini qui permet à l'utilisateur de modifier
        //autant de cours qu'il désire. Pour modifier un cours
        //il doit entrer le numéro de ce cours et ensuite
        //on lui demande d'entrer toutes les informations
        //d'un cours afin qu'il puisse le modifier
        String reponse4 = "";
        while(true){

            while(true){

                System.out.println("Voulez-vous modifier un cours? (Oui/Non): ");

                try{

                    reponse4 = scanner.next();

                    if(reponse4.equalsIgnoreCase("Oui") == false){

                        if(reponse4.equalsIgnoreCase("Non") == true){

                            break;
                        }
                        else
                            throw new InputException("Veuillez entrez Oui ou Non");

                    }
                    else if(reponse4.equalsIgnoreCase("Non") == false){

                        if(reponse4.equalsIgnoreCase("Oui") == true)
                            break;
                        else
                            throw new InputException("Veuillez entrez Oui ou Non");
                    }
                }
                catch(InputException e){

                    System.out.println(e.toString());
                    scanner.nextLine();
                    continue;
                }
                break;
            }
            
            if(reponse4.equalsIgnoreCase("Oui")){

                System.out.println("Pour modifier un cours, vous devez entrer son numero");
                int reponse5 = numero();
               

                for(int k = 0; k<liste.size(); k++){

                    if(liste.get(k).getNum() == reponse5){
                        
                        System.out.println("Veuillez créer le cours qui remplacera celui à modifier");
                    
                        String matiere1 = matiere();

                        int numero1 = numero();

                        String jour1 = jour();

                        int debut1 = debut();

                        int fin1 = fin(debut1);

                        int credits1 = credits();

                        //Après avoir entré les nouvelles informations du cours
                        //qu'il veut modifier, on remplace celles-ci par celles
                        //du cours qu'il voulait modifier au départ
                        liste.get(k).setMatiere(matiere1);
                        liste.get(k).setNum(numero1);
                        liste.get(k).setJour(jour1);
                        liste.get(k).setDebut(debut1);
                        liste.get(k).setFin(fin1);
                        liste.get(k).setCredits(credits1);
                                          
                    }                      
                }
            }
            else{
                
                break;
            }
        }
       // Lorsque l'utilisateur a terminé de retirer et de modifier ses cours
       // on construit l'horaire en commençant par vérifier si 
       // il y a un conflit d'horaire
        System.out.println("Construction de l'horaire...");
        //Ici il y a un petit délai pour la construction de l'horaire
        try {
            TimeUnit.SECONDS.sleep(3);
        }
        catch (Exception e) {
            System.out.println("Erreur");
        }
        //Si la liste et vide on ne peut pas construire l'horaire
        if(liste.size() == 0){
            System.out.println("Impossible de construire votre horaire, car vous n'avez aucun cours");
        }
        else{
        
            //Ici on rempli le tableau horaire (qui est rempli de booelan false)
            //par des boolean true aux endroits du tableau qui correspond
            //aux heures et aux journées de chacun des cours de la liste
            BuildHoraire horaire = new BuildHoraire();
            String[] rep = horaire.remplirHoraire(liste);
            
            //Si il y a un conflit d'horaire
            if(Boolean.parseBoolean(rep[0]) == false){

                
                //On demande à l'utilisateur de modifier les heures ou la journée
                // du cours qui est en conflit
                //jusqu'à ce qu'il n'y ait plus de conflits
                while(rep[0] != "true"){

                    System.out.println("Il y a un conflit d'horaire. Vous devez modifier l'heure de debut et/ou " +
                    "l'heure de fin et/ou la journée de votre "+ (Integer.parseInt(rep[1])+1) +" ième cours");

                    System.out.println("Nouvelle journée: ");
                    String jour2 = jour();

                    liste.get(Integer.parseInt(rep[1])).setJour(jour2);

                    System.out.println("Nouvelle heure de debut: ");
                    int debut2 = debut();

                    liste.get(Integer.parseInt(rep[1])).setDebut(debut2);

                    System.out.println("Nouvelle heure de fin: ");
                    int fin2 = fin(debut2);
                    
                    liste.get(Integer.parseInt(rep[1])).setFin(fin2);

                    BuildHoraire nouvHoraire = new BuildHoraire();
                    rep = nouvHoraire.remplirHoraire(liste);
                
                    
                }
                
            }
            scanner.close();//On ferme le scanner

            System.out.println("Félicitaions! Voici à quoi ressemble votre horaire: ");
            System.out.println();
            horaire.afficherHoraire(liste);//On affiche l'horaire final qui ne contient
                                        //pas de conflits d'horaire  
        }
    }
}
