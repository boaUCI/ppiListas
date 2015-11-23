package carnesfriaslistas;

public class ListaUsuarios {

    private static NodoUsuarios primero, auxPrimero;

    public ListaUsuarios() {
        this.primero = null;
    }//constructor

    public void nuevo(NodoUsuarios n) {
        n.setLiga(primero);
        primero = n;
    }//insertNode

    public void printList() {
        String impri = "";
        auxPrimero = primero;
        while (auxPrimero != null) {
            System.out.println(primero.getApellido() + "\n--------\n");
            auxPrimero = auxPrimero.getLiga();
        }//while

    }//printList

    public boolean eliminar(String nombre, String apellido) {
        auxPrimero = primero;
        while (auxPrimero != null) {
            if (auxPrimero.getLiga().getNombre().equals(nombre) && auxPrimero.getLiga().getApellido().equals(apellido)) {
                auxPrimero.setLiga(auxPrimero.getLiga().getLiga());
                return true;
            }

            auxPrimero = auxPrimero.getLiga();
        }
        return false;
    }

    public boolean modificar(NodoUsuarios n) {
        auxPrimero = buscar(n.getNombre(), n.getApellido());
        if (auxPrimero != null) {
            auxPrimero.setNombre(n.getNombre());
            auxPrimero.setApellido(n.getApellido());
            auxPrimero.setCorreo(n.getCorreo());
            auxPrimero.setContrasena(n.getContrasena());
            auxPrimero.setConfirmarContrasena(n.getConfirmarContrasena());

        }
        return false;
    }

    public NodoUsuarios buscar(String idUsuario, String Nombre) {
        auxPrimero = primero;
        while (auxPrimero != null) {
            if (idUsuario.equals(auxPrimero.getIdUsuario()) && Nombre.equals(auxPrimero.getNombre())) {
                return auxPrimero;
            }
            auxPrimero = auxPrimero.getLiga();
        }

        return null;
    }
}
