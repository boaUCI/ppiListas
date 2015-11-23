
package carnesfriaslistas;


public class NodoUsuarios {
    
    private String idUsuario,Nombre,Apellido,Correo,Contrasena,ConfirmarContrasena;
    private NodoUsuarios liga;

    //Este Nodo es Mejor para el PPI
    //By: Alexander Chalarca
    public NodoUsuarios() {
    }

    public NodoUsuarios(String idUsuario, String Nombre, String Apellido, String Correo, String Contrasena, String ConfirmarContrasena) {
        this.idUsuario = idUsuario;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Correo = Correo;
        this.Contrasena = Contrasena;
        this.ConfirmarContrasena = ConfirmarContrasena;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

    public String getConfirmarContrasena() {
        return ConfirmarContrasena;
    }

    public void setConfirmarContrasena(String ConfirmarContrasena) {
        this.ConfirmarContrasena = ConfirmarContrasena;
    }
    
     public NodoUsuarios getLiga() {
        return liga;
    }

    public void setLiga(NodoUsuarios liga) {
        this.liga = liga;
    }
    
    
}
