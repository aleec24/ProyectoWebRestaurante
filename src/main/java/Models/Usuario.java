package Models;

public class Usuario {

    private String id;
    private String pwUsuario;
    private String nombreUsuario;
    private String idRol;
	private String nombre;
	private String apellido;
	private String correo;
	private String cedula;

    //-----------
    //Constructor
    public Usuario() {
    }

    public Usuario(String id, String nombre, String idRol, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.idRol = idRol;
		this.correo = correo;
    }
	
	public Usuario(String id) {
        this.id = id;
    }
	
	public Usuario(String id,String correo) {
		this.id = id;
        this.correo = correo;
    }

	
    //-----------
    //Getters and Setters
    public String getIdUsuario() {
        return id;
    }

    public void setIdUsuario(String idUsuario) {
        this.id = idUsuario;
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

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	
}
