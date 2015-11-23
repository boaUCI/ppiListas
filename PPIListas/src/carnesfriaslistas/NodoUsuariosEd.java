package carnesfriaslistas;

public class NodoUsuariosEd {

    private String Documento, nombre, apellidos, correo, Direccion, celular;
    private int tipodocumento, telefonofijo, municipio;
    private NodoUsuariosEd liga;//enlace al siguiente formulario

    public NodoUsuariosEd() {

    }

    public NodoUsuariosEd(int tipodocumento, int municipio, String identificacion, String nombre, String apellidos, String correo, int telefonofijo, String celular, String Direccion, NodoUsuariosEd liga) {
        this.tipodocumento = tipodocumento;
        this.municipio = municipio;
        this.Documento = identificacion;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefonofijo = telefonofijo;
        this.celular = celular;
        this.Direccion = Direccion;
        this.liga = liga;
    }

    public int getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(int tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public int getmunicipio() {
        return municipio;
    }

    public void setmunicipio(int municipio) {
        this.municipio = municipio;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getDocumento() {
        return Documento;
    }

    public void setDocumento(String Documento) {
        this.Documento = Documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefonofijo() {
        return telefonofijo;
    }

    public void setTelefonofijo(int telefonofijo) {
        this.telefonofijo = telefonofijo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public NodoUsuariosEd getLiga() {
        return liga;
    }

    public void setLiga(NodoUsuariosEd liga) {
        this.liga = liga;
    }

}
