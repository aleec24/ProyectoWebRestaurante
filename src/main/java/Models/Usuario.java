package Models;

/**
 *
 * @author bryansa
 */
public class Usuario {

    private String idUsuario;
    private String pwUsuario;
    private String nombreUsuario;
    private String idRol;

    //-----------
    //Constructor
    public Usuario() {
    }

    public Usuario(String idUsuario, String nombreUsuario, String idRol) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.idRol = idRol;
    }

    //-----------
    //Getters and Setters
    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getIdRol() {
        return idRol;
    }

    public void setIdRol(String idRol) {
        this.idRol = idRol;
    }

    public String getPwUsuario() {
        return pwUsuario;
    }

    public void setPwUsuario(String pwUsuario) {
        this.pwUsuario = pwUsuario;
    }

}
