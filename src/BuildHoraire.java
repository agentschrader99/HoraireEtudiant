import java.util.ArrayList;

/**
 * La classe BuildHoraire permet de vérifier
 * si un ensemble de cours contient un ou plusieurs
 * conflits d'horaires. Elle permet aussi d'afficher
 * l'horaire en question
 * @author : Yohann Manseau-Glémot
 * @author : Alex Chevrier
 * @Version 1.00 (12 juillet 2022) 
 */
public class BuildHoraire{

    private boolean[][] horaire; // tableau de boolean pour vérifier si une
                                 // plage horaire est déjà prise par un autre cours

    // Constructeur BuildHoraire qui créer un tableau 5 par 15
    // ou 5 représente les jours de la semaine et 15 les heures
    //de 8h à 20h
    public BuildHoraire(){

        this.horaire = new boolean[5][14];
    }
    
    /** 
     * La méthode build rempli tout simplement le tableau
     * horaire par le boolean false
     * @param horaire
     */
    public void build(boolean[][] horaire){

        for(int i = 0; i < horaire.length; i++){

            for(int j = 0; j< horaire[i].length; j++){

                this.horaire[i][j] = false;
            }
        }
    }
    
    /** 
     * La méthode calculCrédits retourne l'indice de la liste
     * de cours ou les cours avant l'indice (incluant celui à l'indice)
     * ont un total de 15 crédits ou moins (15 est le 
     * maximum de crédits qu'un étudiant peut avoir dans une session)
     * @param liste
     * @return int
     */
    public int calculCredits(ArrayList<Cours> liste){

        int indice = 0;
        int compteCred = 0;

        for(int i = 0; i< liste.size(); i++){

            compteCred += liste.get(i).getCredits();
        }

        if(compteCred <= 15){

            indice = liste.size();
        }
        else if(compteCred > 15){

            compteCred = 0;

            for(int j = 0; j< liste.size(); j++){

                compteCred += liste.get(j).getCredits();

                if(compteCred > 15){

                    indice = j;
                    break;
                }
            }
        }
        
        return indice;
    }
    
    /** 
     * La méthode jourEnInt retourne un chiffre correspondant
     * à un jour de la semaine
     * @param cours
     * @return int
     */
    public int jourEnInt(Cours cours){

        String[] jours = {"Lundi", "Mardi","Mercredi", "Jeudi", "Vendredi"};
        int temp = 0;

        for(int i = 0; i< jours.length; i++){

            if(cours.getJour().equalsIgnoreCase(jours[i])){

                temp = i;
                break;
            }
        }
        return temp;

        
    }
    
    /** 
     * La méthode afficherHoraire permet d'afficher
     * les cours présent dans la liste de cours de
     * manière à ce qu'ils soient alligné avec la journée
     * et l'heure de début et de fin de chaque cours
     * @param liste
     */
    public void afficherHoraire(ArrayList<Cours> liste){

        String[][] affichage = new String[6][14];
        String[] jours = {" Lundi ", " Mardi ","  Mercredi ", " Jeudi ", "  Vendredi"};
        int hDebut = 8;
        int indiceH = calculCredits(liste);
        
        
        //Ici on rempli toutes les cases du tableau affichage
        // à partir de la 2e ligne et 2e colonne par un nombre
        //d'espace propre à chaque journée. Ceci sert à bien
        //alligné les cours lors de l'affichage
        for(int i = 1; i < affichage.length; i++){

            for(int j = 1; j< affichage[0].length; j++){

                if(i == 1)
                    affichage[i][j] = "        "; 
                else if(i == 2)
                    affichage[i][j] = "         "; 
                else if(i == 3)
                    affichage[i][j] = "           ";
                else if(i == 4)
                    affichage[i][j] = "          ";
                else if(i == 5)
                    affichage[i][j] = "        ";
               
            }
        }
        affichage[0][0] = "     ";

        //Ici on ajoute les heures de la journée (8h à 20h)
        // à chaque case de la première colonne
        for(int w = 1; w<affichage[0].length; w++){

            if(w == 1 || w == 2){
                affichage[0][w] = hDebut + ":00  ";
                hDebut++;
            }
            else{
                affichage[0][w] = hDebut + ":00 ";
                hDebut++;
            }
             
        }
        //On ajoute les jours de la semaine à la première ligne
        for(int s = 1; s< affichage.length; s++){

            affichage[s][0] = jours[s-1] + " ";
        }
        
        //Ici on ajoute les matières ainsi que les numéros de chaque cours
        //aux cases vis-à-vis la journée et les heures adéquates
        for(int z = 0; z < indiceH; z++){

            //On accède à l'informations de chaque cours
            int journee = jourEnInt(liste.get(z));
          
            int duree = liste.get(z).getFin() - liste.get(z).getDebut();
            int debut = liste.get(z).getDebut();

            String nomCours = liste.get(z).getMatiere() + liste.get(z).getNum();

           
            //on rempli les bonnes cases(ex: un cours est le lundi de 12h à 14, alors
            // son sigle et son numéro seront aligné avec la colonne du lundi et vis-à-vis
            // les cases contenant 12h et 13h et non 14h car le cours termine à cette heure)
            for(int u = 0; u< duree; u++){

                String temp = affichage[journee+1][(debut-7)+u].replaceAll("       ", nomCours);
                affichage[journee+1][(debut-7)+u] = temp;

            }
       }
       
       //On affiche le tableau final ligne par ligne
       for(int a = 0; a<affichage[0].length; a++){

            for(int b = 0; b< affichage.length; b++){

                System.out.print(affichage[b][a]);
            }
            System.out.println();
            
       }
       


    }
   
    /** 
     * La méthode remplirHoraire place les boolean true
     * aux cases correspondant à l'horaire des cours dans le
     * tableau horaire.
     * @param liste
     * @return String[]
     */
    public String[] remplirHoraire(ArrayList<Cours> liste){

       //Le tableau tab contient deux cases
       //une qui indique si il y a un conflit d'horaire
       //et l'autre indique quel cours est en conflit si
       //il y en a un
        String[] tab = new String[2];
        tab[0] = "true";

        
        //Si la liste contient seulement un cours
        // on place les true tout simplement et
        //il n'y a pas de conflit d'horaire
        if(liste.size() == 1){

            
            int debut0 = liste.get(0).getDebut();
            int fin0 = liste.get(0).getFin();
            int jour0 = jourEnInt(liste.get(0));

            for(int a = 0; a<fin0-debut0; a++){

                this.horaire[jour0][(debut0-7)+a] = true;
            }
            
        }
        //Sinon on commence par placer le premier cours de la liste
        else{

            int ind = calculCredits(liste);
            int debut = liste.get(0).getDebut();
            int fin = liste.get(0).getFin();
            int jour = jourEnInt(liste.get(0));

            for(int a = 0; a<fin-debut; a++){

                this.horaire[jour][(debut-7)+a] = true;
            }

            
            //Ensuite on commence à placer les cours suivants
            for(int j = 1; j < ind; j++){

                debut = liste.get(j).getDebut();
                fin = liste.get(j).getFin();
                jour = jourEnInt(liste.get(j));

                int b = debut;

                while(b != fin+1){

                    //Si il y à déjà un true à l'endroit voulue
                    //alors on ajoute la string false au tableau plus haut
                    //cela veut dire qu'il y a un conflit d'horaire
                    if(this.horaire[jour][b-7] == true){
                        
                        tab[0] = "false";

                        tab[1] = j+"";//indice du cours qui entre en conflit

                        break;
                    }
                    //Si il n'y a pas de conflit on ajoute true aux
                    //cases adéquates
                    else{

                        this.horaire[jour][b-7] = true;
                        b++;
                    }
                }
                //Si après avoir placé un cours il n'y a pas de conflit
                //on continue la boucle while afin de placer un autre cours
                if(tab[0] == "true"){
                    
                    continue;
                }
                //Si il y a un conflit alors on break la boucle
                else
                     
                    break;

            }
        }
        return tab;//et on retourne le tableau
    }
   
}
