public class Epee extends Item {
    String [] epee = new String[]
    {"épée en bois","glaive","fleuret","rapière","excalibur"};
    
    String [] descrip = new String[]
    {"tu ferais mieux de la changer vite"
     ,"bon pour le combat rapprocher"
     ,"attention à ne pas la casser"
     ,"bonne épée","l'épée des élus"};
    
    public Epee(){
      this.nom = epee[this.getEtoile()];
      this.force = 25 * this.getEtoile(); 
    }
    
    public Epee (int i){
      this.etoile = this.getEtoileIndex(i);
      this.nom = epee[this.getEtoile()];
      this.force = 25 * this.getEtoile();  
    }
    
    int getUse() {
        return this.force ;
    }
    
    String getDescription(){
        return "";
    }
    
    String type(){
      return "epee";  
    };

 
void foundItem(Playeur moi) {
    if (rand.nextInt(20) > 10){
            Epee epee = new Epee();
            System.out.println(" Objet trouvé : " + epee.getNom() +
                    "\n tu la prend ?");
            System.out.println("\t 1. bien sûr\n\t 2. description\n\t 3. pas besoin");
            int repd;
            do{
                System.out.print("réponse : " );
                repd = input.nextInt();
                if( repd == 1){
                    //moi.addItem(epee);
                    moi.dejaVu(epee);
                    moi.force += epee.force;
                }else if (repd == 2){
                    System.out.println(epee.descrip[epee.getEtoile()]);
                }
          }while (repd == 2);
        }    
   }
  
  void foundItemIndex(Playeur moi) {
    if (rand.nextInt(20) > 10){
          Epee epee = new Epee(this.getEtoile());
            System.out.println(" Objet trouvé : " + epee.getNom() +
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
