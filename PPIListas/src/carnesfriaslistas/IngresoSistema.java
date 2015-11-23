package carnesfriaslistas;

import javax.swing.*; //Utilizar label, buttons...
import java.awt.*;//Font, Color
import java.awt.event.*; //programa eventos como click

public class IngresoSistema extends JFrame implements ActionListener, KeyListener, MouseListener {

    //Declarando atributos de la clase
    JLabel lblUsuario, lblolvidarcontra, lblContrasena, lblRegistro, lblImagen, Imagen1;

    JTextField txtUsuario, txtContrasena;

    JButton btnAceptar, btnCancelar, btnRecuperarContrasena;

    //se  crea el atributo del icono
    Image icoCabecera;

    String contrasena, usuario;

    public IngresoSistema() {//se empienza a configurar cada uno de los atributos
        //icono cabecera
        setIconImage(new ImageIcon(getClass().getResource("/images2/carnelogo.png")).getImage());
        ImageIcon icaceptar = new ImageIcon(getClass().getResource("/images2/login.png"));
        ImageIcon icsalir = new ImageIcon(getClass().getResource("/images2/salir.png"));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(500, 350);//Tamano de la ventana(formulario)
        setTitle("Inicio de Sesión");
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);//Poder visualizar el formulario(ventana)
        getContentPane().setLayout(null);//obtener area de trabajo
        this.getContentPane().setBackground(Color.WHITE);//Agregra color fondo

        //se nombran los elementos
        lblUsuario = new JLabel("Usuario: * ");
        lblContrasena = new JLabel("Contraseña: * ");

        txtUsuario = new JTextField("");

        txtContrasena = new JPasswordField("");

        btnAceptar = new JButton(icaceptar);

        btnCancelar = new JButton(icsalir);

        btnRecuperarContrasena = new JButton("Recuperar Contraseña");
        btnRecuperarContrasena.setBorder(null);

        btnAceptar.setBorder(null);
        btnAceptar.setBackground(Color.white);

        btnCancelar.setBorder(null);
        btnCancelar.setBackground(Color.white);

        btnAceptar.setToolTipText("Ingreso al Sistema");
        btnCancelar.setToolTipText("Salir");

        // color de los label
        lblUsuario.setForeground(Color.BLACK);//color  de  la letra

        lblContrasena.setForeground(Color.BLACK);
        btnRecuperarContrasena.setBackground(Color.WHITE);
        btnRecuperarContrasena.setForeground(Color.BLUE);
        // posicion de cada uno de los elementos
        // label
        lblUsuario.setBounds(20, 30, 300, 100); //posicion columna,fila,largo y ancho
        lblContrasena.setBounds(20, 70, 300, 100); //posicion columna,fila,largo y ancho
        // textfield
        txtUsuario.setBounds(120, 70, 200, 20);//posicion columna,fila,largo y ancho
        txtContrasena.setBounds(120, 110, 200, 20);//posicion columna,fila,largo y ancho
        // botones
        btnAceptar.setBounds(20, 200, 90, 40);// columna,fila,largo y ancho
        btnCancelar.setBounds(110, 200, 90, 40);// columna,fila,largo y ancho
        btnRecuperarContrasena.setBounds(40, 160, 170, 20);

        // se agregan los getContentPane
        getContentPane().add(lblUsuario);//ser visible en el contenedor o ventana
        getContentPane().add(lblContrasena);
        getContentPane().add(txtUsuario);
        getContentPane().add(txtContrasena);
        getContentPane().add(btnAceptar);
        getContentPane().add(btnCancelar);
        getContentPane().add(btnRecuperarContrasena);

        // se agregan a los actionListener + KeyListener
        txtUsuario.addActionListener(this);
        txtContrasena.addActionListener(this);
        btnAceptar.addActionListener(this);
        btnCancelar.addActionListener(this);
        btnRecuperarContrasena.addActionListener(this);

        txtUsuario.addKeyListener(this);
        txtContrasena.addKeyListener(this);
        btnAceptar.addKeyListener(this);
        btnRecuperarContrasena.addKeyListener(this);

//        // imagen de fondo 
        JLabel Imagen1 = new JLabel();
        Imagen1.setIcon(new ImageIcon(getClass().getResource("/images2/cerdologin.gif")));
        Imagen1.setBounds(235, 30, 250, 280);
        getContentPane().add(Imagen1);

        this.repaint();

    }

    public void actionPerformed(ActionEvent e)//aqui se configura a fondo la funcion del boton salir
    {
        if (e.getSource() == btnCancelar) {
            System.exit(0);

        }

        if (e.getSource() == btnAceptar) {

            if (txtUsuario.getText().equals("Alexander") && txtContrasena.getText().equals("123")) {
                dispose();
                MenuPpal Men = new MenuPpal();
                Men.setVisible(true);
                Men.setExtendedState(JFrame.MAXIMIZED_BOTH);

            } else {
                JOptionPane.showMessageDialog(rootPane, "Usuario ó Contraseña Incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                txtUsuario.setText("");
                txtContrasena.setText("");

                txtUsuario.requestFocusInWindow();

            }
        }
        if (e.getSource() == btnRecuperarContrasena) {

            dispose();
            RecuperarContrasena recuperar = new RecuperarContrasena();
            recuperar.setVisible(true);

        }

    }

    public void keyTyped(KeyEvent e) {
        char caracter = e.getKeyChar();
        int numero = (int) (caracter);

        if (e.getSource() == txtUsuario) {
            if (numero == 10) {
                txtContrasena.requestFocus();
            }
        }

        if (e.getSource() == txtContrasena) {

            if (numero == 10) {
                btnAceptar.requestFocus();
            }
        }

        if (e.getSource() == btnAceptar) {
            if (numero == 10) {

                if (txtUsuario.getText().equalsIgnoreCase("Alexander") && txtContrasena.getText().equals("123")) //el equals es que sea igual alde aqui
                {
                    dispose();
                    MenuPpal Men = new MenuPpal();//Sirve para instanciar el menu principal
                    Men.setVisible(true);

                } else {

                    JOptionPane.showMessageDialog(rootPane, "Usuario ó Contraseña Incorrectos");

                }
            }
        }

    }

    //metodos obligatoris
    public void keyPressed(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {

    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == lblolvidarcontra) {
            Registrarse reg = new Registrarse();
            dispose();
        }
    }

    public void windowActivated(WindowEvent e) {
    }

    public void windowClosed(WindowEvent e) {
    }

    public void windowClosing(WindowEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void windowDeactivated(WindowEvent e) {
    }

    public void windowDeiconified(WindowEvent e) {
    }

    public void windowIconified(WindowEvent e) {
    }

    public void windowOpened(WindowEvent e) {
    }

    public void itemStateChanged(ItemEvent e) {
    }

}
