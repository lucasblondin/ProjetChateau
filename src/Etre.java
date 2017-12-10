import java.util.Random;
import java.util.Scanner;

public class Etre {
     Random rand = new Random();
     Scanner input = new Scanner(System.in);
     Item item ;
     String nom;
     int vie;
     int force;
    
    boolean mort(){
        boolean res = false;
        if (vie < 0){
            res = true;
        } return res ;
    }
       
    int getAttaque(){
        return this.force;
    }
    
    void getDamage(int i){
        vie -= i;
    }
    
    String getNom(){
        return "" + this.nom ;
    }
}
