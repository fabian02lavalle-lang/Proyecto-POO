package Vista;

import Control.ControlConductor;
import Control.ControlPasajero;
import Control.ControlVehiculo;
import Modelo.entidades.Conductor;
import Modelo.entidades.Pasajero;
import Modelo.entidades.Vehiculo;
import Modelo.entidades.Viaje;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Font;

public class LoginFrame extends JFrame {

    private JLabel lblTitulo;
    private JLabel lblId;
    private JLabel lblNombre;
    private JLabel lblRol;
    private JLabel lblPlaca;
    private JLabel lblModelo;
    private JLabel lblPuestos;
    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtPlaca;
    private JTextField txtModelo;
    private JTextField txtPuestos;
    private JComboBox<String> cmbRol;
    private JButton btnEntrar;

    // almacenamiento en memoria de usuarios y viajes
    private static ArrayList<Viaje> viajesDisponibles = new ArrayList<>();
    private static HashMap<Integer, Conductor> conductores = new HashMap<>();
    private static HashMap<Integer, Pasajero> pasajeros = new HashMap<>();
    private static HashMap<Viaje, ArrayList<String>> pasajerosEnEspera = new HashMap<>();

    public LoginFrame() {
        initComponents();
    }

    private void initComponents() {
        lblTitulo = new JLabel();
        lblId = new JLabel();
        lblNombre = new JLabel();
        lblRol = new JLabel();
        lblPlaca = new JLabel();
        lblModelo = new JLabel();
        lblPuestos = new JLabel();
        txtId = new JTextField();
        txtNombre = new JTextField();
        txtPlaca = new JTextField();
        txtModelo = new JTextField();
        txtPuestos = new JTextField();
        cmbRol = new JComboBox<>(new String[]{"Pasajero", "Conductor"});
        btnEntrar = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Carreras - Iniciar Sesion");
        setResizable(false);
        getContentPane().setLayout(null);

        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitulo.setText("Bienvenido a Carreras");
        getContentPane().add(lblTitulo);
        lblTitulo.setBounds(90, 20, 200, 25);

        lblId.setText("ID:");
        getContentPane().add(lblId);
        lblId.setBounds(40, 65, 100, 25);

        getContentPane().add(txtId);
        txtId.setBounds(150, 65, 150, 25);

        lblNombre.setText("Nombre:");
        getContentPane().add(lblNombre);
        lblNombre.setBounds(40, 100, 100, 25);

        getContentPane().add(txtNombre);
        txtNombre.setBounds(150, 100, 150, 25);

        lblRol.setText("Rol:");
        getContentPane().add(lblRol);
        lblRol.setBounds(40, 135, 100, 25);

        getContentPane().add(cmbRol);
        cmbRol.setBounds(150, 135, 150, 25);

        lblPlaca.setText("Placa:");
        lblPlaca.setVisible(false);
        getContentPane().add(lblPlaca);
        lblPlaca.setBounds(40, 170, 100, 25);

        txtPlaca.setVisible(false);
        getContentPane().add(txtPlaca);
        txtPlaca.setBounds(150, 170, 150, 25);

        lblModelo.setText("Modelo carro:");
        lblModelo.setVisible(false);
        getContentPane().add(lblModelo);
        lblModelo.setBounds(40, 205, 110, 25);

        txtModelo.setVisible(false);
        getContentPane().add(txtModelo);
        txtModelo.setBounds(150, 205, 150, 25);

        lblPuestos.setText("Puestos:");
        lblPuestos.setVisible(false);
        getContentPane().add(lblPuestos);
        lblPuestos.setBounds(40, 240, 100, 25);

        txtPuestos.setVisible(false);
        getContentPane().add(txtPuestos);
        txtPuestos.setBounds(150, 240, 150, 25);

        btnEntrar.setText("Entrar");
        getContentPane().add(btnEntrar);
        btnEntrar.setBounds(110, 290, 120, 30);

        cmbRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbRolActionPerformed(evt);
            }
        });

        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        setSize(350, 380);
        setLocationRelativeTo(null);
    }

    private void cmbRolActionPerformed(java.awt.event.ActionEvent evt) {
        boolean esConductor = cmbRol.getSelectedItem().equals("Conductor");
        lblPlaca.setVisible(esConductor);
        txtPlaca.setVisible(esConductor);
        lblModelo.setVisible(esConductor);
        txtModelo.setVisible(esConductor);
        lblPuestos.setVisible(esConductor);
        txtPuestos.setVisible(esConductor);
    }

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {
        String idTexto = txtId.getText().trim();
        String nombre = txtNombre.getText().trim();

        if (idTexto.isEmpty() || nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor llena todos los campos.");
            return;
        }

        int id;
        try {
            id = Integer.parseInt(idTexto);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El ID debe ser un numero.");
            return;
        }

        String rol = (String) cmbRol.getSelectedItem();

        if (rol.equals("Conductor")) {
            Conductor conductor;

            if (conductores.containsKey(id)) {
                conductor = conductores.get(id);
                JOptionPane.showMessageDialog(this, "Bienvenido de nuevo, " + conductor.getNombre() + "!");
            } else {
                String placa = txtPlaca.getText().trim();
                String modelo = txtModelo.getText().trim();
                String puestosTexto = txtPuestos.getText().trim();

                if (placa.isEmpty() || modelo.isEmpty() || puestosTexto.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Por favor llena los datos del vehiculo.");
                    return;
                }

                int puestos;
                try {
                    puestos = Integer.parseInt(puestosTexto);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Los puestos deben ser un numero.");
                    return;
                }

                ControlVehiculo controlVehiculo = new ControlVehiculo();
                Vehiculo vehiculo = controlVehiculo.crearVehiculo(placa, modelo, puestos);

                ControlConductor controlConductor = new ControlConductor();
                conductor = controlConductor.crearConductor(id, nombre, vehiculo);
                conductores.put(id, conductor);
            }

            this.dispose();
            ConductorFrame cf = new ConductorFrame(conductor, viajesDisponibles, conductores, pasajeros, pasajerosEnEspera);
            cf.setVisible(true);

        } else {
            Pasajero pasajero;

            if (pasajeros.containsKey(id)) {
                pasajero = pasajeros.get(id);
                JOptionPane.showMessageDialog(this, "Bienvenido de nuevo, " + pasajero.getNombre() + "!");
            } else {
                ControlPasajero controlPasajero = new ControlPasajero();
                pasajero = controlPasajero.crearPasajero(id, nombre);
                pasajeros.put(id, pasajero);
            }

            this.dispose();
            PasajeroFrame pf = new PasajeroFrame(pasajero, viajesDisponibles, conductores, pasajeros, pasajerosEnEspera);
            pf.setVisible(true);
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }
}
