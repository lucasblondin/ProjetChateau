public class clef extends Item {
    int nombre;
    
    
    @Override
    int getUse() {
     return nombre;   
    }

    @Override
    String getDescription() {
       return "cette clef permet d'ouvrir une porte";
    }

    @Override
    void foundItem(Playeur m) {
      
    }

    @Override
    String type() {
        return "clef";
    }
    
}
