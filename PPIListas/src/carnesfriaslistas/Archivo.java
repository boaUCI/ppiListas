package carnesfriaslistas;

import carnesfriaslistas.Usuarios;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class Archivo {

    private String camino;

    public Archivo(String camino) {
        this.camino = camino;
    }

    public void guardar(LinkedList<Usuarios> ListaUsuarios) {
        try {
            FileWriter fileWriter = new FileWriter(camino, false);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            for (Usuarios e : ListaUsuarios) {
                printWriter.println(e);
            }
           /* for (Usuarios e : ListaUsuarios) {
                printWriter.println(e);
            }*/
            printWriter.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public ListasUsuarios2 leer() {
        ListasUsuarios2 ListaUsuarios = new ListasUsuarios2();

        FileReader fileReader;

        try {
            File file = new File(camino);

            if (file.exists()) {
                fileReader = new FileReader(file);

                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String linea;

                while ((linea = bufferedReader.readLine()) != null) {
                    String[] campoUsuarios = linea.split(" ");
                    Usuarios e = new Usuarios(campoUsuarios[0], campoUsuarios[1], campoUsuarios[2], campoUsuarios[3], campoUsuarios[4], campoUsuarios[5]);
                    ListaUsuarios.insertarAlfinal(e);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return ListaUsuarios;
    }
}
