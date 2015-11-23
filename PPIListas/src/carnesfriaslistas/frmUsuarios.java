package carnesfriaslistas;

//import static carnesfriaslistas.frmUsuarios.validateEmail;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class frmUsuarios extends JFrame implements ActionListener, KeyListener {

    JLabel lblIdUsuario, lblNombre, lblApellido, lblCorreo, lblContrasena, lblConfirmarContrasena, lblMensaje;
    JTextField txtIdUsuario, txtNombre, txtApellido, txtCorreo;
    JPasswordField txtContrasena, txtConfirmarContrasena;
    JButton btnGuardar, btnNuevo, btnEditar, btnEliminar, btnBuscar, btnSalir;
    JTable TablaDatos; //crear tabla
    DefaultTableModel dtm; //Modelo tabla
    JScrollPane tablapanel; //panel para la tabla
    private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    Object[][] datos = new Object[0][7];//estructura interna de la tabla( son 7 campos)
    Object[] Columnas = {"IDUsuario", "Nombre", "Apellido", "Correo Electronico"};
    Integer pos;

    ListaUsuarios lista = new ListaUsuarios();

    KeyAdapter e;
    Image iconCabecera;

    public frmUsuarios() {//Constructor

        setTitle("Usuarios");
        setSize(900, 600);
        setLocationRelativeTo(null);
        //setVisible(true);
        setResizable(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setLayout(null);

        //Remplazamos la taza de te de java por uno mio
        setIconImage(new ImageIcon(getClass().getResource("/images2/carnelogo.png")).getImage());

        dtm = new DefaultTableModel(datos, Columnas);// forma de la tabla
        TablaDatos = new JTable(dtm); // indican el modelo de la tabla
        TablaDatos.setModel(dtm);
        tablapanel = new JScrollPane(TablaDatos); //se agrega la tabla al panel con scroll

        tablapanel.setVisible(true);
        getContentPane().add(tablapanel);

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

        tablapanel.setBounds(15, 310, 860, 200);

        btnBuscar.setBounds(685, 520, 150, 50);
        btnNuevo.setBounds(20, 520, 130, 50);
        btnGuardar.setBounds(155, 520, 130, 50);
        btnEliminar.setBounds(295, 520, 130, 50);
        btnEditar.setBounds(435, 520, 130, 50);
        btnSalir.setBounds(575, 520, 130, 50);

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

        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);

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

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //*******SALIR*******
        if (e.getSource() == btnSalir) {
            dispose();
            MenuPpal Men = new MenuPpal();
            Men.setVisible(true);
        }

        //*********Nuevo*********
        if (e.getSource() == btnNuevo) {

            txtIdUsuario.setText("");
            txtNombre.setText("");
            txtApellido.setText("");
            txtCorreo.setText("");
            txtContrasena.setText("");
            txtConfirmarContrasena.setText("");

            btnGuardar.setEnabled(true);
            btnEditar.setEnabled(false);
            btnEliminar.setEnabled(false);
        }

        //*********Guardar*********
        if (e.getSource() == btnGuardar) {

            boolean a = validateEmail(txtCorreo.getText());
            if (a == false && !txtCorreo.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Correo Incorrecto Ejemplo: ejemplo@hotmail.com");
            } else {
                if (txtIdUsuario.getText().equals("") || txtNombre.getText().equals("") || txtApellido.getText().equals("") || txtContrasena.getText().equals("") || txtConfirmarContrasena.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Favor llenar los Campos obligatorios");
                } else {
                    if (verificarDatoUnico(txtIdUsuario.getText())) {
                        JOptionPane.showMessageDialog(null, "El Usuario ya existe");
                    } else {
                        NodoUsuarios n = new NodoUsuarios();
                        n.setIdUsuario(txtIdUsuario.getText());
                        n.setNombre(txtNombre.getText());
                        n.setApellido(txtApellido.getText());
                        n.setCorreo(txtCorreo.getText());

                        n.setContrasena(txtContrasena.getText());
                        n.setConfirmarContrasena(txtConfirmarContrasena.getText());

                        lista.nuevo(n);

                        Object datos1[] = new Object[9];

                        datos1[0] = txtIdUsuario.getText();
                        datos1[1] = txtNombre.getText();
                        datos1[2] = txtApellido.getText();
                        datos1[3] = txtCorreo.getText();

                        dtm.addRow(datos1);
                        TablaDatos = new JTable(dtm);
                        JOptionPane.showMessageDialog(null, "Usuario Guardado con exito");

                        txtIdUsuario.setText("");
                        txtNombre.setText("");
                        txtApellido.setText("");
                        txtCorreo.setText("");
                        txtContrasena.setText("");
                        txtConfirmarContrasena.setText("");

                    }
                }
            }
        }
        //*******Eliminar******
        if (e.getSource() == btnEliminar) {

            Integer c = JOptionPane.showConfirmDialog(null, "Esta seguro que desea eliminar este Usuario?");
            if (c == 0) {
                if (verificarDatoUnico(txtNombre.getText())) {
                    txtIdUsuario.setEnabled(false);
                    txtNombre.setText("");
                    txtApellido.setText("");
                    txtCorreo.setText("");
                    txtContrasena.setText("");
                    txtConfirmarContrasena.setText("");

                    btnEditar.setEnabled(false);
                    btnEliminar.setEnabled(false);

                    btnGuardar.setEnabled(false);
                    dtm.removeRow(pos);
                } else {
                    JOptionPane.showMessageDialog(null, "El Usuario no existe");
                }
            }
        }

        //***********Buscar***********
        if (e.getSource() == btnBuscar) {

            if (txtIdUsuario.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Ingrese el ID Usuario");
            } else {
                if (verificarDatoUnico(txtNombre.getText())) {
                    int x;
                    x = verificarDatoEditar(txtNombre.getText());

                    NodoUsuarios n = lista.buscar(txtIdUsuario.getText(), txtNombre.getText());
                    if (n != null) {

                        txtIdUsuario.setText(n.getIdUsuario());
                        txtNombre.setText(n.getNombre());
                        txtApellido.setText(n.getApellido());
                        txtCorreo.setText(n.getCorreo());
                        txtContrasena.setText(n.getContrasena());
                        txtConfirmarContrasena.setText(n.getConfirmarContrasena());
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontro el Regsitro");
                    }

                    btnEditar.setEnabled(true);
                    btnEliminar.setEnabled(true);
                    btnGuardar.setEnabled(false);
                    txtIdUsuario.setEnabled(false);

                } else {
                    JOptionPane.showMessageDialog(null, "No se ha encontrado el Usuario");
                }
            }
        }

        if (e.getSource() == btnEditar) {

            
            if (verificarDatoUnico(txtNombre.getText()) && validateEmail(txtApellido.getText())) {
                int x;
                x = verificarDatoEditar(txtNombre.getText());

                //TablaDatos.setValueAt(opcionComboTipoDoc(jcbtipoDoc.getSelectedIndex()), x, 0);
                TablaDatos.setValueAt(txtNombre.getText(), x, 0);
                TablaDatos.setValueAt(txtApellido.getText(), x, 1);
                TablaDatos.setValueAt(txtCorreo.getText(), x, 2);
                TablaDatos.setValueAt(txtContrasena.getText(), x, 3);
                TablaDatos.setValueAt(txtConfirmarContrasena.getText(), x, 4);

                NodoUsuarios n = new NodoUsuarios();
                n.setNombre(txtNombre.getText());
                n.setApellido(txtApellido.getText());
                n.setCorreo(txtCorreo.getText());
                n.setContrasena(txtContrasena.getText());
                n.setConfirmarContrasena(txtConfirmarContrasena.getText());
                
                
                txtIdUsuario.setText("");
                txtNombre.setText("");
                txtApellido.setText("");
                txtCorreo.setText("");
                txtContrasena.setText("");
                txtConfirmarContrasena.setText("");
                
                lista.modificar(n);
                btnEditar.setEnabled(false);
                btnEliminar.setEnabled(false);
               
                btnGuardar.setEnabled(true);
                JOptionPane.showMessageDialog(null, "Usuario Modificado con exito");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo editar el Usuario");
            }
        }

    }

    public static boolean validateEmail(String email) {

        Pattern pattern = Pattern.compile(PATTERN_EMAIL);

        Matcher matcher = pattern.matcher(email);
        return matcher.matches();

    }

    public boolean verificarDatoUnico(String Nombre) {
        boolean resp = false;
        for (Integer i = 0; i < TablaDatos.getRowCount(); i++) {
            if (TablaDatos.getValueAt(i, 1).toString().equals(Nombre)) {
                resp = true;
                pos = i;
            }
        }
        return resp;
    }

    public int verificarDatoEditar(String Nombre) {
        int pos = 0;
        for (Integer i = 0; i < TablaDatos.getRowCount(); i++) {
            if (TablaDatos.getValueAt(i, 1).toString().equals(Nombre)) {
                pos = i;
            }
        }
        return pos;
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

}
