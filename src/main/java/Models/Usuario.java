package Models;

public class Usuario {

    private String id;
    private String pwUsuario;
    private String nombreUsuario;
    private String idRol;
	private String nombre;

    //-----------
    //Constructor
    public Usuario() {
    }

    public Usuario(String id, String nombre, String idRol) {
        this.id = id;
        this.nombre = nombre;
        this.idRol = idRol;
    }

    //-----------
    //Getters and Setters
    public String getIdUsuario() {
        return id;
    }

    public void setIdUsuario(String idUsuario) {
        this.id = id;
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

	
}
