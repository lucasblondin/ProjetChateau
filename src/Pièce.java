import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Pièce {
   ArrayList<Porte> porte = new ArrayList<Porte>();
   private String nom;
   private int etage;
   
   Scanner in = new Scanner(System.in);
   Random rand = new Random();
   private boolean princesse = false;
   private Item item;
   private Ennemie res;
   
   
    public Pièce(String nom,int etage){
            this.etage = etage;
            this.nom = nom;
        }
    
    public String getNom(){
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
   
    int getNiveau(){
        return this.etage;
    }
    
    boolean getPrincesse(){
        return princesse;
    }
    void addPrincesse(){
        princesse = true;
    }
    
    int getNbPièce(){
        return porte.size() ;
    }
    
    Item creatItem(){
    int alea = rand.nextInt(3);
        if(alea == 0){
            item = new Epee();
        }else if(alea == 1){
            item = new Potion();
        }else{
            item = new Protection();
        }
        return item ;
    }
    
    
    Item creatItem(int i){
    int alea = rand.nextInt(3);
        if(alea == 0){
            item = new Epee(i);
        }else if(alea == 1){
            item = new Potion(i);
        }else{
            item = new Protection(i);
        }
        return item ;
    }
      
     
  void foundEnnemie(Playeur p) {
    if (rand.nextInt(20) > 10){
            Ennemie enemy = new Ennemie(this.getNom());
            System.out.println("un ennemie vient d'apparaitre !\n Ennemie : " + enemy.getNom()); 
            boolean fuite = false;
            int rep ;
                do{
                    System.out.println( enemy.getNom() + " à " + enemy.vie + " points de vie");
                    System.out.println("il vous reste " + p.getVie() + " points de vie");
                    System.out.println("\t 1. attaque\n\t 2. inventaire\n\t 3. fuir");
                    System.out.print("réponse : ");
                    rep = in.nextInt();
                
                     if(rep==1){
                         if(enemy.getRep()){
                        enemy.getDamage(p.getAttaque());
                         }else{
                        p.getDamage(enemy.getAttaque());
                         }
                    }else if(rep==2){
                        p.useItem(); 
                    }else if(rep==3){
                        fuite=true;
                        p.getDamage(enemy.getAttaque()/2);
                    }
                }while(!enemy.mort() && !p.mort() && !fuite);
                
                if(enemy.mort()){
                this.creatItem(enemy.getDifficulté()).foundItem(p);     
                }

            
        }    
   }
}

