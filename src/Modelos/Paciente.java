package Modelos;

public class Paciente {
    private int identificacion;
    private int telefono;
    private String nombres;
    private String apellidos;
    private String direccion;
    private int idAlergia;

    public Paciente(int identificacion, int telefono, String nombres, String apellidos, String direccion, int idAlergia){
        this.identificacion = identificacion;
        this.telefono = telefono;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.idAlergia = idAlergia;
    }

    // Get

    public int getIdentificacion(){
        return identificacion;
    }

    public int getTelefono(){
        return telefono;
    }

    public String getNombres(){
        return nombres;
    }

    public String getApellidos(){
        return apellidos;
    }

    public String getDireccion(){
        return direccion;
    }

    public int getAlergias(){
        return idAlergia;
    }

    // set

    public void setIdentificacion(int identificacion){
        this.identificacion = identificacion;
    }

    public void setTelefono(int telefono){
        this.telefono = telefono;
    }

    public void setNombres(String nombres){
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }

    public void setDireccion(String direccion){
        this.direccion = direccion;
    }

    public void setIdAlergia(int idAlergia){
        this.idAlergia = idAlergia;
    }
}
