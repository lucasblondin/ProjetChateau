 import java.util.Random;
import java.util.Scanner;

public class Action {
    
    public static void main(String[]args){
       Random rand = new Random();
       Scanner in = new Scanner(System.in);
       System.out.print("bienvenue de le chateau : ");
       String n = in.nextLine();
       
       Chateau hante = new Chateau();
       Playeur moi = new Playeur(n,hante.piece.get(0));
       Scanner input = new Scanner(System.in);
       
       //System.out.println(hanter.getPiece());
       while (true){
        System.out.println("\033[H\033[2J");
        System.out.flush();
        
        
        
        System.out.println("position : " + moi.getIciString());
        System.out.println
        ("que veux-tu faire ? :\n"
        +"\t 1. Inspecter la pièce\n"
        +"\t 2. Changer de pièce\n"
        +"\t 3. Regarder ton inventaire\n"
        +"\t 4. Ouvrir ta carte\n");
        
        System.out.print("réponse : ");
        int choix = input.nextInt();
        
        if(choix == 1){
       // moi.foundItem(); 
            moi.getIciPièce().creatItem().foundItem(moi);
        }else if(choix == 2){
            moi.changeDePiece(hante);  
            moi.getIciPièce().foundEnnemie(moi);
        }else if(choix == 3){
            moi.useItem();
        }else{
            System.out.println(hante.getMap(moi));
        }
       
       }
    }
}