/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lucas
 */
public class Potion extends Item {
    String [] potion = new String[]
    {"de l'eau","potion mineur","potion","potion puissante","potion majeur"};
    
    String [] descrip = new String[]
    {"tu ferais mieux de la changer vite"
     ,"bon pour le combat rapprocher"
     ,"attention à ne pas la casser"
     ,"bonne épée","l'épée des élus"};
    
    public Potion(){
       this.nom = potion[this.getEtoile()];
       this.force = 25 * this.getEtoile(); 
    }
    
    @Override
    int getUse() {
        return this.force;
    }

    @Override
    String getDescription() {
     return "";  
    }
    
    String type(){
      return "potion";  
    };
    
    @Override
    void foundItem(Playeur moi) {
    if (rand.nextInt(20) > 10){
            Potion epee = new Potion();
            System.out.println(" Objet trouvé : " + epee.getNom() +
                    "\n tu la prend ?");
            System.out.println("\t 1. bien sûr\n\t 2. description\n\t 3. pas besoin");
            int repd;
            do{
                System.out.print("réponse : " );
                repd = input.nextInt();
                if( repd == 1){
                    moi.addItem(epee);
                }else if (repd == 2){
                    System.out.println(epee.descrip[epee.getEtoile()]);
                }
          }while (repd == 2);
        }    
   }
}
