package Modelos;

public class Alergias {
    private int id;
    private String nombreAlergia;

    public Alergias(int id, String nombreAlergia){
        this.id = id;
        this.nombreAlergia = nombreAlergia;
    }

    //get
    public int getId(){
        return id;
    }

    public String getNombreAlergia(){
        return nombreAlergia;
    }

    // set
    public void setId(int id){
        this.id = id;
    }

    public void setNombreAlergia(String nombreAlergia){
        this.nombreAlergia = nombreAlergia;
    }

}
