public class Ennemie extends Etre {

    public Ennemie(String p){
        if(p.equals("entree")){
          this.nom = "armure vide";
          this.force = 50;
          this.vie = 300;
        }else if(p.equals("bal")){
          this.nom = "fantôme";
          this.force = 50;
          this.vie = 200; 
        }else if(p.equals("jardin")){
          this.nom = "plante carnivore";
          this.force = 30;
          this.vie = 70;   
        }else if(p.equals("cuisine")){
          this.nom = "cochon zombie";
          this.force = 150;
          this.vie = 100;  
        }else if(p.equals("trône")){
         this.nom = "vampire";
          this.force = 300;
          this.vie = 200;   
        }else if(p.equals("arme")){
          this.nom = "squelette";
          this.force = 100;
          this.vie = 100;  
        }else if(p.equals("cellule")){
          this.nom = "rat";
          this.force = 50;
          this.vie = 75;  
        }else if(p.equals("égout")){
          this.nom = "crapeau baveux";
          this.force = 50;
          this.vie = 50;  
        }else if(p.equals("tourSud") || p.equals("tourNord")){
          this.nom = "sorcier";
          this.force = 200;
          this.vie = 50;  
        }else{
          this.nom = "gnome";
          this.force = 50;
          this.vie = 100;   
        }
    }
    
    boolean getRep(){
        boolean res = false; 
        int r = this.rand.nextInt(3);
        int input;
        int resultat;
        
        if(r == 0){
            int x = this.rand.nextInt(15);
            int y = this.rand.nextInt(10);
            int z = this.rand.nextInt(10);
            
            resultat = (x*y)/(z+3);
            System.out.println("\t calcule : " + x + " X " + y + " / " + z + " + " + "3");
            
            input = this.input.nextInt();
            if(input == resultat){
               res = true;
               System.out.println(" bonne réponse");
            }
        }else if(r == 1){
            int x = this.rand.nextInt(15);
            int y = this.rand.nextInt(10);
            int z = this.rand.nextInt(10);
            
            resultat = (x*z)+z-x;
            System.out.println("\t calcule : " + x + " X " + z + " + " + z + " - " + x);
            
             input = this.input.nextInt();
            if(input == resultat){
               res = true;
               System.out.println(" bonne réponse");
            }
        }else{
            int x = this.rand.nextInt(15);
            int y = this.rand.nextInt(10);
            int z = this.rand.nextInt(5);
            
            resultat = x + y - z + y -x;
            System.out.println("\t calcule : " + x + " + " + y + " - " + z + " + " + y + " - " + x);
            
             input = this.input.nextInt();
            if(input == resultat){
               res = true;
               System.out.println(" bonne réponse");
            }
        } return res ;
    }
}
