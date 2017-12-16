import java.util.Random;
import java.util.Scanner;

public abstract class Item {
   Scanner input = new Scanner(System.in);
   Random rand = new Random();
   Item item;
   String nom;
   int force;
   int etoile = rand.nextInt(5);
   
   abstract int getUse();
   
   abstract String getDescription();
   
   abstract void foundItem(Playeur m);
   
   abstract void foundItemIndex(Playeur m);
   
   abstract String type();
    
   public String getNom(){
       return nom;
   }
   
   public int getEtoile(){
       return etoile;
   }
   
   public int getEtoileIndex(int i){
       if(i<5){
            return rand.nextInt(5-i)+i;
       }
       return 0;
   }
   
   
}
