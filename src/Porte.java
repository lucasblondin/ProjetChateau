public class Porte {
    private String nom;
    private String direction ;
    public Porte(String nom,String direction){
        this.nom = nom;
        this.direction = direction;
    }
    
    String getDirection(){
        return this.nom;
    }

    public String getNom() {
        return nom;
    }
    
    public String getdirection(){
        return direction;
    }
    
}
