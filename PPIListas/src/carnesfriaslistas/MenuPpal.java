package carnesfriaslistas;

import java.awt.*;//Font, Color
import java.awt.event.*; //programa eventos como click

import javax.swing.*; //Utilizar label, buttons...

public class MenuPpal extends JFrame implements ActionListener {

    //Declarando atributos de la clase
    JLabel jlblArrendamientos;
    JLabel jlblimage;
    JLabel Imagen1;

    JMenuBar barra = new JMenuBar();

    //se  crea el atributo del icono
    JMenu MenProcedimientos;

    JMenu reportes;
    JMenu ayuda;
    JMenu salir;

    //subsmenu
    JMenuItem MniClientes, MniProductos, MniUsuarios, salir1, cerrarc;

    //fondo
    Image icoCabecera;

    public MenuPpal() {//se empienza a configurar cada uno de los atributos

        
        icoCabecera = Toolkit.getDefaultToolkit().getImage("/images2/carnelogo.png");
        setIconImage(icoCabecera);

        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setBackground(Color.red);

        setTitle("Carnes Frias Could Meats");

        getContentPane().setLayout(null);//obtener area de trabajo
        this.getContentPane().setBackground(Color.WHITE);//Agregra color fondo

        MenProcedimientos = new JMenu("Procedimientos");

        JMenu reportes = new JMenu("Reportes");
        JMenu ayuda = new JMenu("Ayuda");
        JMenu salir = new JMenu("Salir");

        MniUsuarios = new JMenuItem("Usuarios");
        MniClientes = new JMenuItem("Clientes");
        MniProductos = new JMenuItem("Productos");

        salir1 = new JMenuItem("salir");
        cerrarc = new JMenuItem("Cerrar sesión");

       

        //SELECCIONAMOS LA BARRA DE MENUS
        setJMenuBar(barra);

        //A LA BARRA LE AGREGAMOS LOS MENUS.
        barra.add(MenProcedimientos);

        barra.add(reportes);
        barra.add(ayuda);
        barra.add(salir);

        //AHORA A LOS MENUS LE AGREGAMOS LAS OPCIONES Y EL SUBMENU(MenProcedimientos)
        MenProcedimientos.add(MniUsuarios);
        MenProcedimientos.add(MniClientes);
        MenProcedimientos.add(MniProductos);

        //AHORA A LOS MENUS LE AGREGAMOS LAS OPCIONES Y EL SUBMENU(archivosmo)
        salir.add(salir1);
        salir.add(cerrarc);

        //agregamos al actionlistener
        salir1.addActionListener(this);
        MniProductos.addActionListener(this);
        MniUsuarios.addActionListener(this);
        cerrarc.addActionListener(this);

        JLabel Imagen1 = new JLabel();
        Imagen1.setIcon(new ImageIcon(getClass().getResource("/images2/Fondo.gif")));
        Imagen1.setBounds(0, 0, 900, 500);
        getContentPane().add(Imagen1);

        setVisible(true);
        this.repaint();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == MniUsuarios) {
            
            frmUsuarios2 frmUsu = new frmUsuarios2();
            frmUsu.setVisible(true);
            dispose();
        }

        if (e.getSource() == salir1) {
            System.exit(0);

        }

        if (e.getSource() == MniProductos) {

        }

        if (e.getSource() == cerrarc) {
            dispose();
            IngresoSistema ini = new IngresoSistema();
            ini.setVisible(true);

        }
    }

}
