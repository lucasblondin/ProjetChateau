import java.util.ArrayList;
public class Playeur extends Etre{
    ArrayList<Item> objet = new ArrayList<Item>();
    Pièce ici ;
    
    public Playeur(String nom,Pièce p){
        this.nom = nom;
        this.vie = 700;
        this.force = 40;
        ici = p;
    }

    public Pièce getIciPièce() {
        return ici;
    }
    
    int getVie(){
        return this.vie;
    }
    
    public String getIciString(){
        return ici.getNom();
    }
    
    void changeDePièce(Pièce p){
        ici = p;
    }
    
    String getItem(){
        String res = "";
        if(this.objet.size() == 0){
            res = "\t Il n'y a pas d'objet";
        }else {
        for(int i = 0 ; i < this.objet.size();i++){
            res +=("\t" + (i+1) + ". " + this.objet.get(i).getNom());
            }
        }return res;
    } 
    
    String getItemChoisie(String r){
        String res = "";
        for(int i = 0 ; i < this.objet.size();i++){
            if(this.objet.get(i).type().equals(r)){
                res = this.objet.get(i).getNom() + " force : " + this.objet.get(i).force;
            }
        }
        return res ;
    }
    
    void dejaVu (Item itm){
        boolean res = false;
        int idx = 0;
        for(int i = 0 ; i < objet.size();i++){
            if(itm.type().equals(this.objet.get(i).type())){
                res = true;
                idx = i;
                    }  
            }
        if(res){
            System.out.println(
                  "vous allez devoir jeter votre arme précédente ?" );
            System.out.println("(trouvé) " + itm.getNom() + " force : "+ itm.force +  " -----> " + this.getItemChoisie(itm.type()));
            System.out.println("\t 1. garder\n\t 2. changer");
            System.out.print("réponse : ");
            int change = input.nextInt();
            if(change == 2){
            if(this.objet.get(idx).type().equals("epee")){
                this.force -= this.objet.get(idx).force;
            }else{
                this.vie -= this.objet.get(idx).force;
            }
            this.objet.remove(idx);
            this.addItem(itm); 
                }
            }else{
            this.addItem(itm);
        }
    }
    
    void addItem(Item i){
        objet.add(i);
    }
    
    void useItem(){       
        int choix;
        do{
            System.out.println("\t Nom : " + this.getNom() + " Vie : " + this.vie + " Force : " + this.force);
            System.out.println(this.getItem());
            if(objet.size() != 0){
            System.out.println("\t Veux-tu utiliser une potion ? : ");
            System.out.println("\t 0. quitter : ");
            System.out.print("réponse : ");
            choix = input.nextInt()-1;
            if(choix < -1 || choix > this.objet.size()-1){
                System.out.println("\t ce n'est pas dans la liste");
            }
            else if( choix == -1){
                
            }
            else if(!this.objet.get(choix).type().equals("potion")){
                System.out.println("\t ce n'est pas une potion ");
            }else{
                this.vie += this.objet.get(choix).getUse();
                this.objet.remove(choix);
                System.out.println("\t potion bue ");
            }
          }else{
          System.out.println("\t 0. quitter : ");
          System.out.print("réponse : ");
          choix = input.nextInt()-1;
            }
        }while(choix != -1);
        
    }
    
    void changeDePiece(Chateau c){
        for(int i = 0 ; i < this.ici.getNbPièce() ; i++){
            System.out.println( "\t" + i + " " + this.ici.porte.get(i).getNom());
         }
        System.out.print("réponse : ");
        int endroit = input.nextInt();
        //System.out.println(moi.ici.porte.get(endroit).getdirection());
        for(Pièce p : c.piece){
            if (this.ici.porte.get(endroit).getdirection().equals(p.getNom())){
                 //System.out.println(p.getNom());
                 this.changeDePièce(p);  
                 
                 break;
            }
        } 
    }
 
    void foundItem() {
    if (rand.nextInt(20) > 10){
            Epee epee = new Epee();
            System.out.println("Objet trouvé : " + epee.getNom() +
                    "\ntu la prend ?");
            System.out.println("\t 1. bien sûr\n\t 2. description\n\t 3. pas besoin");
            int repd;
            do{
                System.out.print("réponse : " );
                repd = input.nextInt();
                if( repd == 1){
                    this.addItem(epee);
                }else if (repd == 2){
                    System.out.println(epee.descrip[epee.getEtoile()]);
                }
          }while (repd == 2);
        }    
   }
}
