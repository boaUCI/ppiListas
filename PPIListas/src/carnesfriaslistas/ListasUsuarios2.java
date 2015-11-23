
package carnesfriaslistas;
import carnesfriaslistas.NodoUsuarios2;
import carnesfriaslistas.Usuarios;
import java.util.Iterator;


public class ListasUsuarios2 {
    
    
    private NodoUsuarios2 cab, cola;
    private int nroNodos;

    public ListasUsuarios2() {
        cab = cola = null;
        nroNodos = 0;
    }
    
      public void insertarAlfinal(Usuarios usuario) {
        NodoUsuarios2 p = new NodoUsuarios2(); 

        p.dato = usuario;
        p.sig = null;

        if (cab == null) {
            cab = cola = p;
            p.ant = null;
        } else {
            cola.sig = p;
            p.ant = cola;
            cola = p;
        }
        nroNodos++;
    }
      
      
    public Iterator<Usuarios> iterator() {
        return new IteradorLista();
    }

    public Usuarios infoEnPosicion(int pos) {
        NodoUsuarios2 t = cab;
        if (pos <= nroNodos) {
            for (int i = 1; i < pos; i++) {
                t = t.sig;
            }
            return t.dato;
        } else {
            return null;
        }
    }

    public void borrar(int pos) {
        NodoUsuarios2 t = cab;
        if (pos <= nroNodos) {
            for (int i = 1; i < pos; i++) {
                t = t.sig;
            }
            if (cab == cola) {
                cab = cola = null;
            } else if (cab == t) {
                cab = cab.sig;
                cab.ant = null;
            } else if (cola == t) {
                cola = cola.ant;
                cola.sig = null;
            } else {
                t.ant.sig = t.sig;
                t.sig.ant = t.ant;
            }
        }
    }

    private class IteradorLista implements Iterator {

        private NodoUsuarios2 actual = cab;

        @Override
        public boolean hasNext() {
            return (actual != null);
        }

        @Override
        public Usuarios next() {
            Usuarios usuarios = actual.dato;
            actual = actual.sig;
            return usuarios;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

}
