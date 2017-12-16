import java.util.ArrayList;
import java.util.Random;

public class Chateau {
    ArrayList<Pièce> piece = new ArrayList<Pièce>();
    Random rand = new Random();
    int endroit = rand.nextInt(4) + 8;
    
    public Chateau(){
        //rez de chaussé ( niveau 0 )
        Pièce pont = new Pièce("pont",0);
        Pièce entree = new Pièce("entree",0);
        Pièce bal = new Pièce("bal",0);
        Pièce jardin = new Pièce("jardin",0);
        Pièce cuisine = new Pièce("cuisine",0);
        
        //première étage ( niveau 1 )
        Pièce rempart = new Pièce ("rempart",1);
        Pièce trone = new Pièce ("trône",1);
        Pièce tourNord = new Pièce ("tourNord",1);
        Pièce tourSud = new Pièce ("tourSud",1);
        
        // étages inférieurs ( niveau -1 & niveau -2)
        Pièce arme = new Pièce ("arme",-1);
        Pièce egout = new Pièce("égout",-2);
        Pièce cellule = new Pièce ("cellule",-2);
        
        //0
        piece.add(pont);
        pont.porte.add(new Porte("salle d'entrée","entree"));
        pont.porte.add(new Porte("égout","égout"));
        
        //1
        piece.add(entree);
        entree.porte.add(new Porte("escalier vers le haut","trône"));
        entree.porte.add(new Porte("escalier vers le bas ","arme"));
        entree.porte.add(new Porte("porte central","bal"));
        entree.porte.add(new Porte("porte d'entrée","pont"));
        
        //2
        piece.add(bal);
        bal.porte.add(new Porte("porte central","entree"));
        bal.porte.add(new Porte("porte vers l'extérieur","jardin"));
        bal.porte.add(new Porte("porte à droite","cuisine"));
        
        //3
        piece.add(jardin);
        jardin.porte.add(new Porte("porte vers le bal","bal"));
        jardin.porte.add(new Porte("escalier vers le haut","rempart"));
        
        //4
        piece.add(cuisine);  
        cuisine.porte.add(new Porte("escalier vers le haut","trône"));
        cuisine.porte.add(new Porte("escalier vers le bas ","arme"));
        cuisine.porte.add(new Porte("porte de gauche","bal"));
        
        //5
        piece.add(egout);
        egout.porte.add(new Porte("égout vers le pont","pont"));
        egout.porte.add(new Porte("porte de cellule","cellule"));
        
        //6
        piece.add(arme);
        arme.porte.add(new Porte("escalier vers l'entrée","entree"));
        arme.porte.add(new Porte("escalier vers les remparts","rempart"));
        arme.porte.add(new Porte("escalier vers le cachot","cellule"));
        
        //7
        piece.add(rempart);
        rempart.porte.add(new Porte("chemin vers tour sud","tourSud"));
        rempart.porte.add(new Porte("chemin vers tour nord","tourNord"));
        rempart.porte.add(new Porte("escalier vers la salle d'arme","arme"));
        
        //8
        piece.add(cellule);
        cellule.porte.add(new Porte("escalier vers salle d'arme","arme"));
        cellule.porte.add(new Porte("passage dans les égouts","égout"));
        
        //9
        piece.add(trone);
        trone.porte.add(new Porte("escalier vers la salle d'entrée","entree"));
        trone.porte.add(new Porte("escalier vers la cuisine","cuisine"));
        trone.porte.add(new Porte("porte vers les remparts","rempart"));
          
        //10
        piece.add(tourNord);
        tourNord.porte.add(new Porte("porte vers les remparts","rempart"));
        tourNord.porte.add(new Porte("sauter par la fenêtre","égout"));
        
        //11
        piece.add(tourSud);
        tourSud.porte.add(new Porte("porte vers les remparts","rempart"));
        tourSud.porte.add(new Porte("sauter par la fenêtre","égout"));
        
       
        piece.get(endroit).addPrincesse();
        
       System.out.println("la princesse ce trouve : " + piece.get(endroit).getNom());
    }
    
    String getOrdreDesPièces(){
        String res ="";
        for (Pièce p : piece) {
            res += piece.lastIndexOf(p) + " " +p.getNom();
		} return res;
    }
    
    String getMap(Playeur p){
        String res = "";
        if( p.getIciPièce().getNiveau() == 1){
            res ="    |J| \n"
               + "    |B| \n"
               + "    |E| |C| \n"
               + "  --|P| ----\n"
               + " rez de chaussé";
        }else{
           res = "  |J| \n"
               + "  |B| \n"
               + "  |E| |C| \n"
               + "--|P| ----\n"; 
        } return res ;
    }
    String getPiece(){
      String res = "";
      res += ("Printing list of Rooms:\n");
        for (Pièce p : piece) {
            res +=" " + p.getNom() + " niveau " + p.getNiveau() + " avec " + p.getNbPièce() + " passages\n";
        } return res ;
    }
    
    String getIndice(){
         
        
        
        return "";
    }
}
