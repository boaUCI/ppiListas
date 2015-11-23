package carnesfriaslistas;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class frmUsuarios2 extends JFrame implements ActionListener, KeyListener {

    JLabel lblIdUsuario, lblNombre, lblApellido, lblCorreo, lblContrasena, lblConfirmarContrasena, lblMensaje;
    JTextField txtIdUsuario, txtNombre, txtApellido, txtCorreo;
    JPasswordField txtContrasena, txtConfirmarContrasena;
    JButton btnGuardar, btnNuevo, btnEditar, btnEliminar, btnBuscar, btnSalir;
    JList jlstUsuarios;
    DefaultListModel defaultListModel; //Modelo tabla
    Usuarios usuario;
    //Archivo archivo;

    ListasUsuarios2 listaUsuario;
    private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    Object[][] datos = new Object[0][7];//estructura interna de la tabla( son 7 campos)
    Object[] Columnas = {"IDUsuario", "Nombre", "Apellido", "Correo Electronico"};
    Integer pos;

    KeyAdapter e;
    Image iconCabecera;

    public frmUsuarios2() {

        setTitle("Usuarios");
        setSize(900, 600);
        setLocationRelativeTo(null);
        //setVisible(true);
        setResizable(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setLayout(null);

        //Remplazamos la taza de te de java por uno mio
        setIconImage(new ImageIcon(getClass().getResource("/images2/carnelogo.png")).getImage());

        defaultListModel = new DefaultListModel();
        listaUsuario = new ListasUsuarios2();

        listaUsuario.insertarAlfinal(new Usuarios("123", "Alexander", "Chalarca", "alexcuba96@hotmail.com", "1234", "1234"));
        listaUsuario.insertarAlfinal(new Usuarios("1234", "Mateo", "Chalarca", "mateo@hotmail.com", "1234", "1234"));
        llenarLista();

        jlstUsuarios = new JList(defaultListModel);

        this.add(new JScrollPane(jlstUsuarios), BorderLayout.CENTER);

        jlstUsuarios.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                int indiceSeleccionado = jlstUsuarios.getSelectedIndex();

                //JOptionPane.showMessageDialog(null, "Indice seleccionado " + indiceSeleccionado);              
            }
        });

        // archivo = new Archivo("c:\\ArchivoUsuarios\\Usuarios.txt");
        //listaUsuario = archivo.leer();
        lblIdUsuario = new JLabel("Id Usuario: *");
        lblNombre = new JLabel("Nombres: *");
        lblApellido = new JLabel("Apellidos: *");
        lblCorreo = new JLabel("Correo Electronico:");
        lblContrasena = new JLabel("Contraseña: *");
        lblConfirmarContrasena = new JLabel("Confirmar Contraseña: *");
        lblMensaje = new JLabel("Tdos los Campos Marcados Con * Son Obligatorios");

        btnBuscar = new JButton("Buscar");
        btnEditar = new JButton("Editar");
        btnEliminar = new JButton("Eliminar");
        btnGuardar = new JButton("Guardar");
        btnNuevo = new JButton("Nuevo");
        btnSalir = new JButton("Salir");

        btnNuevo.setIcon(new ImageIcon(getClass().getResource("/images2/nuevo.png")));
        btnGuardar.setIcon(new ImageIcon(getClass().getResource("/images2/Guardar.png")));
        btnEliminar.setIcon(new ImageIcon(getClass().getResource("/images2/eliminar.png")));
        btnSalir.setIcon(new ImageIcon(getClass().getResource("/images2/salir.png")));
        btnEditar.setIcon(new ImageIcon(getClass().getResource("/images2/editar.png")));
        btnBuscar.setIcon(new ImageIcon(getClass().getResource("/images2/buscar.png")));

        txtIdUsuario = new JTextField(15);
        txtNombre = new JTextField(15);
        txtApellido = new JTextField(15);
        txtCorreo = new JTextField(15);
        txtContrasena = new JPasswordField(15);
        txtConfirmarContrasena = new JPasswordField(15);

        lblIdUsuario.setBounds(20, 20, 100, 20);
        lblNombre.setBounds(20, 70, 100, 20);
        lblApellido.setBounds(20, 120, 100, 20);
        lblCorreo.setBounds(20, 170, 170, 20);
        lblContrasena.setBounds(20, 220, 100, 20);
        lblConfirmarContrasena.setBounds(20, 265, 170, 20);

        txtIdUsuario.setBounds(170, 20, 250, 25);
        txtNombre.setBounds(170, 70, 250, 25);
        txtApellido.setBounds(170, 120, 250, 25);
        txtCorreo.setBounds(170, 170, 250, 25);
        txtContrasena.setBounds(170, 220, 250, 25);
        txtConfirmarContrasena.setBounds(170, 265, 250, 25);

        jlstUsuarios.setBounds(15, 310, 860, 200);

        btnBuscar.setBounds(685, 520, 150, 50);
        btnNuevo.setBounds(20, 520, 130, 50);
        btnGuardar.setBounds(155, 520, 130, 50);
        btnEliminar.setBounds(295, 520, 130, 50);
        btnEditar.setBounds(435, 520, 130, 50);
        btnSalir.setBounds(575, 520, 130, 50);

        getContentPane().add(jlstUsuarios);
        getContentPane().add(lblIdUsuario);
        getContentPane().add(lblNombre);
        getContentPane().add(lblApellido);
        getContentPane().add(lblCorreo);
        getContentPane().add(lblContrasena);
        getContentPane().add(lblConfirmarContrasena);

        getContentPane().add(txtIdUsuario);
        getContentPane().add(txtNombre);
        getContentPane().add(txtApellido);
        getContentPane().add(txtCorreo);
        getContentPane().add(txtContrasena);
        getContentPane().add(txtConfirmarContrasena);

        getContentPane().add(btnNuevo);
        getContentPane().add(btnGuardar);
        getContentPane().add(btnEliminar);
        getContentPane().add(btnEditar);
        getContentPane().add(btnSalir);
        getContentPane().add(btnBuscar);

        txtIdUsuario.addActionListener(this);
        txtNombre.addActionListener(this);
        txtApellido.addActionListener(this);
        txtCorreo.addActionListener(this);
        txtContrasena.addActionListener(this);
        txtConfirmarContrasena.addActionListener(this);
        btnBuscar.addActionListener(this);
        btnEditar.addActionListener(this);
        btnEliminar.addActionListener(this);
        btnGuardar.addActionListener(this);
        btnNuevo.addActionListener(this);
        btnSalir.addActionListener(this);

        btnSalir.setEnabled(false);
        //btnEliminar.setEnabled(false);

        txtIdUsuario.addKeyListener(e);

        e = new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar()) && !Character.isLetter(e.getKeyChar())) {
                    e.consume();
                    Toolkit.getDefaultToolkit().beep();

                }
                if (e.getSource() == txtIdUsuario) {
                    if (txtIdUsuario.getText().length() == 0 && e.getKeyChar() == '0') {
                        e.consume();
                        Toolkit.getDefaultToolkit().beep();

                    }

                } else if (e.getSource() == txtNombre) {
                    if (txtNombre.getText().length() == 0 && e.getKeyChar() == '0') {
                        e.consume();
                        Toolkit.getDefaultToolkit().beep();

                    }
                } else if (e.getSource() == txtApellido) {
                    if (txtApellido.getText().length() == 0 && e.getKeyChar() == '0') {
                        e.consume();
                        Toolkit.getDefaultToolkit().beep();

                    }
                } else if (e.getSource() == txtCorreo) {
                    if (txtCorreo.getText().length() == 0 && e.getKeyChar() == '0') {
                        e.consume();
                        Toolkit.getDefaultToolkit().beep();

                    }
                }
            }

        };

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                String id = txtIdUsuario.getText();
                String nombre = txtNombre.getText();
                String apellido = txtApellido.getText();
                String correo = txtCorreo.getText();
                String contrasena = txtContrasena.getText();
                String confirmar = txtConfirmarContrasena.getText();

                if (txtIdUsuario.getText().equals("")) {

                    JOptionPane.showMessageDialog(rootPane, "Debe ingresar El Id del Usuario");
                } else {
                    if (txtNombre.getText().equals("")) {
                        JOptionPane.showMessageDialog(rootPane, "Debe ingresar el nombre del ususario");
                    } else {

                        if (txtApellido.getText().equals("")) {
                            JOptionPane.showMessageDialog(rootPane, "Debe Ingresar el Apellido del Usuario");

                        } else {
                            if (txtCorreo.getText().equals("")) {
                                JOptionPane.showMessageDialog(rootPane, "Debe Ingresar el correo Electronico");
                            }
                        }
                    }

                }

                if (!txtContrasena.getText().equals(txtConfirmarContrasena.getText())) {

                    JOptionPane.showMessageDialog(rootPane, "Las Contraseñas no coinciden");
                    txtContrasena.setText("");
                    txtConfirmarContrasena.setText("");
                    txtContrasena.requestFocusInWindow();
                    return;
                }

                if (usuario == null) {

                    usuario = new Usuarios(id, nombre, apellido, correo, contrasena, confirmar);
                } else {
                    usuario.setIdUsuario(id);
                    usuario.setNombre(nombre);
                    usuario.setApellido(apellido);
                    usuario.setCorreo(correo);

                }

                listaUsuario.insertarAlfinal(usuario);
                JOptionPane.showMessageDialog(null, "Usuario Guardado correctamente");
                llenarLista();

                // archivo.guardar(listaUsuario);
                txtIdUsuario.setText("");
                txtNombre.setText("");
                txtApellido.setText("");
                txtCorreo.setText("");
                txtContrasena.setText("");
                txtConfirmarContrasena.setText("");

            }
        });

        btnEditar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

            }
        });

        btnBuscar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

            }
        });

        btnNuevo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                btnGuardar.setEnabled(true);
                btnSalir.setEnabled(true);
                txtIdUsuario.setText("");
                txtNombre.setText("");
                txtApellido.setText("");
                txtCorreo.setText("");
                txtContrasena.setText("");
                txtConfirmarContrasena.setText("");

            }
        });

        btnEliminar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                int posicion = jlstUsuarios.getSelectedIndex();
                if (posicion >= 0) {
                    if (JOptionPane.showConfirmDialog(rootPane, "Realmente desea borrar este estudiante") == JOptionPane.YES_OPTION) {
                        listaUsuario.borrar(posicion);
                        llenarLista();
                        // archivo.guardar(listaEstudiante);
                    }

                } else {
                    JOptionPane.showMessageDialog(rootPane, "Debe seleccionar un estudiante", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        soloNumeros(txtIdUsuario);
        soloLetras(txtNombre);
        soloLetras(txtApellido);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

    }

    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void llenarLista() {

        defaultListModel.removeAllElements();
        for (Iterator iterador = listaUsuario.iterator(); iterador.hasNext();) {
            Usuarios usuario = (Usuarios) iterador.next();
            defaultListModel.addElement(usuario);
        }

    }

    public void soloNumeros(JTextField a) {

        //permite la llamada a un evento
        a.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                //va a extraer la variable que se ingresa
                char c = e.getKeyChar();

                if (Character.isLetter(c)) {//Si es una letra no funciona

                    getToolkit().beep();//Sonido cuando ingrese un dato incorrecto
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Debe Ingresar Solo Numeros");
                }

            }
        });

    }

    public void soloLetras(JTextField a) {

        //permite la llamada a un evento
        a.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                //va a extraer la variable que se ingresa
                char c = e.getKeyChar();

                if (Character.isDigit(c)) {//Si es un numero no funciona

                    getToolkit().beep();//Sonido cuando ingrese un dato incorrecto
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Debe Ingresar Solo Letras");
                }

            }
        });

    }

}
