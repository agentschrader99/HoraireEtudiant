//La classe InputException permet d'afficher un message
//d'erreur personnalisé à l'utilisateur si il entre une
//donnée invalide dans la classe Main
//
/**
 * @author : Yohann Manseau-Glémot
 * @author : Alex Chevrier
 * @Version 1.00 (12 juillet 2022) 
 */

public class InputException extends Exception {

    String s;//Contiendra le message personnalisé
    //Constructeur qui met à jour la String ci-dessus
    public InputException(String s){

        this.s = s;
    }
    
    /** 
     * On Override la methode toString pour
     * retourné le message personnalisé en cas d'erreur
     * @return String
     * @Override
     */
    
    public String toString(){
        
        return s;
    }

}
