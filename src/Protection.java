/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lucas
 */
public class Protection extends Item {
     String [] protection = new String[]
    {"bouclier en paille","bouclier en bois","bouclier en cuir","bouclier en metal","bouclier en diamant"};
    
    String [] descrip = new String[]
    {"tu ferais mieux de la changer vite"
     ,"bon pour le combat rapprocher"
     ,"attention à ne pas la casser"
     ,"bonne épée","l'épée des élus"};
//    
    public Protection(){
       this.nom = protection[this.getEtoile()];
       this.force = 25 * this.getEtoile(); 
    }

    public Protection(int i){
      this.etoile = this.getEtoileIndex(i);
      this.nom = protection[this.getEtoile()];
      this.force = 25 * this.getEtoile();  
    }
    
    @Override
    int getUse() {
        return 1;
    }

    @Override
    String getDescription() {
     return "";  
    }
    
    String type(){
      return "protection";  
    };
    
    @Override
    void foundItem(Playeur moi) {
    if (rand.nextInt(20) > 10){
            Protection epee = new Protection();
            System.out.println(" Objet trouvé : " + epee.getNom() +
                    "\n tu la prend ?");
            System.out.println("\t 1. bien sûr\n\t 2. description\n\t 3. pas besoin");
            int repd;
            do{
                System.out.print("réponse : " );
                repd = input.nextInt();
                if( repd == 1){
                    moi.dejaVu(epee);
                    moi.vie += epee.force;
                }else if (repd == 2){
                    System.out.println(epee.descrip[epee.getEtoile()]);
                }
          }while (repd == 2);
        }   
   }
    
    void foundItemIndex(Playeur moi) {
    if (rand.nextInt(20) > 10){
          Protection epee = new Protection(this.getEtoile());
            System.out.println("Un objet vient de tomber");
            System.out.println("Objet trouvé : " + epee.getNom() +
                    "\n tu la prend ?");
            System.out.println("\t 1. bien sûr\n\t 2. description\n\t 3. pas besoin");
            int repd;
            do{
                System.out.print("réponse : " );
                repd = input.nextInt();
                if( repd == 1){
                    moi.addItem(this);
                }else if (repd == 2){
                    System.out.println(this.descrip[epee.getEtoile()]);
                }
          }while (repd == 2);
        }    
   }
}
