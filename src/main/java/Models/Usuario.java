package Models;

public class Usuario {

    private String id;
    private String nombre;
    private String apellido;
    private String cedula;
    private String telefono;
    private String rol;
    private String nombreUsuario;
    private String pwUsuario;
    private Boolean estado;
    private String correo;

    //-----------
    //Constructor
    public Usuario() {
    }

    public Usuario(String id, String nombre, String apellido, String cedula, String telefono, String rol, String nombreUsuario, String pwUsuario, Boolean estado, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.telefono = telefono;
        this.rol = rol;
        this.nombreUsuario = nombreUsuario;
        this.pwUsuario = pwUsuario;
        this.estado = estado;
        this.correo = correo;
    }

    public Usuario(String id, String nombre, String idRol, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.rol = idRol;
        this.correo = correo;
    }

    public Usuario(String id) {
        this.id = id;
    }

    public Usuario(String id, String correo) {
        this.id = id;
        this.correo = correo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPwUsuario() {
        return pwUsuario;
    }

    public void setPwUsuario(String pwUsuario) {
        this.pwUsuario = pwUsuario;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
