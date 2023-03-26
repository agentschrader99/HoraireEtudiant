
/**
 * @author : Yohann Manseau-Glémot
 * @author : Alex Chevrier
 * @Version 1.00 (12 juillet 2022) 
 * 
 * La classe Cours ci-dessous contient les informations
 * classiques d'un cours d'université. Elle contient aussi 
 * de nombreux getters et setters pour accéder et modifier
 * les attributs de chaque objet Cours.
 */

public class Cours {

   private int numero;
   private String matiere;
   private String jour;
   private int debut;
   private int fin;
   private int credits;

   /**
    * Constructeur de la classe cours contenant les paramètres suivants
    * @param numero numéro du cours à 4 chiffres
    * @param matiere sigle du cours (3 lettres majuscules)
    * @param jour journée du cours
    * @param debut heure de début du cours
    * @param fin heure de fin du cours
    * @param credits nombre de crédits du cours
    */
   public Cours(int numero, String matiere,String jour, int debut, int fin, int credits){
        this.numero = numero;
        this.matiere = matiere;
        this.jour = jour;
        this.debut = debut;
        this.fin = fin;
        this.credits = credits;
   }
   
   /** 
    * Méthode getJour qui retourne la journée d'un cours
    * @return String
    */
   public String getJour(){
        return this.jour;
   }
   
   /** 
    * Méthode setJour qui met à jour l'attribut jour
    * @param jour
    */
   public void setJour(String jour){
        this.jour = jour;
   }
   
   /** 
    * Méthode getNum qui retourne le numéro du cours
    * @return int
    */
   public int getNum(){
        return this.numero;
   }
   
   /** 
    * Méthode setNum qui met à jour le numéro d'un cours
    * @param numero
    */
   public void setNum(int numero){
        this.numero = numero;
   }
   
   /** 
    * Méthode getMatière qui retourne la matière d'un cours
    * @return String
    */
   public String getMatiere(){
        return this.matiere;
   }
   
   /** 
    * Méthode setMatière qui met à jour la matière d'un cours
    * @param matiere
    */
   public void setMatiere(String matiere){
        this.matiere = matiere;
   }
   
   /** 
    * Méthode getDebut qui retourne l'heure de début d'un cours
    * @return int
    */
   public int getDebut(){
        return this.debut;
   }
   
   /** Méthode setDebut qui met à jour l'heure de début d'un cours
    * @param debut
    */
   public void setDebut(int debut){
        this.debut = debut;
   }
   
   /** 
    * Méthode getFin qui retourne l'heure de fin d'un cours
    * @return int
    */
   public int getFin(){
        return this.fin;
   }
   
   /** 
    * Méthode setFin qui met à jour l'heure de fin d'un cours
    * @param fin
    */
   public void setFin(int fin){
        this.fin = fin;
   }
   
   /** 
    * Méthode getCredits qui retourne le nombre de crédits d'un cours
    * @return int
    */
   public int getCredits(){
        return this.credits;
   }
   
   /** 
    * Méthode setCredits qui met à jour le nombre de crédits d'un cours
    * @param credits
    */
   public void setCredits(int credits){
        this.credits = credits;
   }



}
