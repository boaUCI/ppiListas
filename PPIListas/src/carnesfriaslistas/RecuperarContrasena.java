package carnesfriaslistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RecuperarContrasena extends JFrame implements ActionListener, KeyListener {

    // Declarando atributos de la clase
    JLabel lblusuario, lblCorreoElectronico, lblPalabraSecreta, imagenFondo;

    JTextField txtusuario, txtCorreoElectronico, txtPalabraSecreta;

    JButton btnAceptar, btnCancelar;

    public RecuperarContrasena() {//se empienza a configurar cada uno de los atributos

        setSize(560, 300);//Tamano de la ventana(formulario)
        setTitle("Recuperar contraseña");// Titulo en barra titulo
        setLocation(190, 190);// Ubicacion en pantalla
        setResizable(false);
        setVisible(true);
        getContentPane().setLayout(null);//obtener area de trabajo
        getContentPane().setBackground(new Color(255, 255, 255));//Agregra color fondo
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //icono cabecera
        setIconImage(new ImageIcon(getClass().getResource("/images2/carnelogo.png")).getImage());
        ImageIcon icaceptar = new ImageIcon(getClass().getResource("/images2/login.png"));
        ImageIcon icsalir = new ImageIcon(getClass().getResource("/images2/cerrarsesion.png"));
        ImageIcon fondo = new ImageIcon(getClass().getResource("/images2/recordar contraseña.jpg"));

        //se nombran los elementos
        lblusuario = new JLabel("Usuario ");
        lblCorreoElectronico = new JLabel("Correo electrónico");
        lblPalabraSecreta = new JLabel("Palabra Secreta");
        imagenFondo = new JLabel(fondo);

        txtusuario = new JTextField("");
        txtCorreoElectronico = new JTextField("");
        txtPalabraSecreta = new JPasswordField("");

        btnAceptar = new JButton(icaceptar);
        btnCancelar = new JButton(icsalir);

        btnAceptar.setToolTipText("Recuperar Contraseña");
        btnCancelar.setToolTipText("Regresar al Inicio de Sesión");

        lblusuario.setBounds(50, 40, 200, 40); //posicion columna,fila,largo y ancho
        lblCorreoElectronico.setBounds(50, 90, 200, 40);
        lblPalabraSecreta.setBounds(50, 140, 200, 25); //posicion columna,fila,largo y ancho
        imagenFondo.setBounds(0, 0, 560, 300);

        //textfield
        txtusuario.setBounds(200, 40, 280, 25);//posicion columna,fila,largo y ancho
        txtCorreoElectronico.setBounds(200, 90, 280, 25);
        txtPalabraSecreta.setBounds(200, 140, 280, 25);

//        // botones
        btnAceptar.setBounds(140, 200, 110, 50);// columna,fila,largo y ancho
        btnCancelar.setBounds(320, 200, 110, 50);// columna,fila,largo y ancho

        btnAceptar.setBorder(null);
        btnAceptar.setBackground(Color.white);

        btnCancelar.setBorder(null);
        btnCancelar.setBackground(Color.white);

        //se agregan los getContentPane
        getContentPane().add(lblusuario);
        getContentPane().add(lblCorreoElectronico);
        getContentPane().add(lblPalabraSecreta);
        getContentPane().add(txtPalabraSecreta);
        getContentPane().add(txtusuario);
        getContentPane().add(txtCorreoElectronico);
        getContentPane().add(btnAceptar);
        getContentPane().add(btnCancelar);
        getContentPane().add(imagenFondo);

        btnAceptar.addActionListener(this);
        btnCancelar.addActionListener(this);

        setVisible(true);
        this.repaint();

    }

    @Override
    public void actionPerformed(ActionEvent e)//aqui se configura a fondo la funcion del boton salir
    {
        if (e.getSource() == btnCancelar) {
            dispose();
            IngresoSistema ingreso = new IngresoSistema();
            ingreso.setVisible(true);
        }

        if (e.getSource() == btnAceptar) {

            if (txtusuario.getText().equals("Alexander") && txtCorreoElectronico.getText().equals("alexcuba96@hotmail.com") && txtPalabraSecreta.getText().equals("orelma")) //el equals es que sea igual alde aqui
            {
                JOptionPane.showMessageDialog(null, "<html>Su contraseña es: <br> 123");
            } else {
                JOptionPane.showMessageDialog(null, "Información incorrecta");
            }

        }
        Object jbtRecuperarContrasena = null;
        if (e.getSource() == jbtRecuperarContrasena) {

            dispose();
            RecuperarContrasena recuperar = new RecuperarContrasena();

        }

    }

    public void itemStateChanged(ItemEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

}
