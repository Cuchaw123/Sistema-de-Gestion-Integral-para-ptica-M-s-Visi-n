package vista;

import controlador.HospitalControlador;
import modelo.Cita;
import modelo.Doctor;
import modelo.Paciente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaHospital extends JFrame {

    private JTextField txtPaciente;
    private JTextField txtEdad;
    private JTextField txtDni;
    private JTextField txtDoctor;
    private JTextField txtEspecialidad;
    private JTextField txtFecha;
    private JTextField txtHora;

    private JTextArea areaCitas;

    private HospitalControlador controlador;

    public VentanaHospital() {

        controlador = new HospitalControlador();

        setTitle("Sistema Hospital");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Paciente"));
        txtPaciente = new JTextField(20);
        add(txtPaciente);

        add(new JLabel("Edad"));
        txtEdad = new JTextField(20);
        add(txtEdad);

        add(new JLabel("DNI"));
        txtDni = new JTextField(20);
        add(txtDni);

        add(new JLabel("Doctor"));
        txtDoctor = new JTextField(20);
        add(txtDoctor);

        add(new JLabel("Especialidad"));
        txtEspecialidad = new JTextField(20);
        add(txtEspecialidad);

        add(new JLabel("Fecha"));
        txtFecha = new JTextField(20);
        add(txtFecha);

        add(new JLabel("Hora"));
        txtHora = new JTextField(20);
        add(txtHora);

        JButton btnRegistrar = new JButton("Registrar Cita");
        add(btnRegistrar);

        areaCitas = new JTextArea(15, 40);
        add(new JScrollPane(areaCitas));

        btnRegistrar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String nombrePaciente = txtPaciente.getText();
                int edad = Integer.parseInt(txtEdad.getText());
                String dni = txtDni.getText();

                Paciente paciente =
                        new Paciente(nombrePaciente, edad, dni);

                String nombreDoctor = txtDoctor.getText();
                String especialidad = txtEspecialidad.getText();

                Doctor doctor =
                        new Doctor(nombreDoctor, especialidad);

                String fecha = txtFecha.getText();
                String hora = txtHora.getText();

                Cita cita =
                        new Cita(paciente, doctor, fecha, hora);

                controlador.agregarCita(cita);

                areaCitas.append(cita.toString() + "\n\n");

                limpiarCampos();
            }
        });

        setVisible(true);
    }

    public void limpiarCampos() {

        txtPaciente.setText("");
        txtEdad.setText("");
        txtDni.setText("");
        txtDoctor.setText("");
        txtEspecialidad.setText("");
        txtFecha.setText("");
        txtHora.setText("");
    }
}