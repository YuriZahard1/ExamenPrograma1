package programaExamen;

import java.awt.EventQueue;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Agenda {
	HashMap<String, String> agenda=new HashMap<>();
	private JFrame frame;
	private JTextField txtNombre;
	private JTextField txtNumero;
	private JTextField txtBuscar;
	private JTextField txtBorrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Agenda window = new Agenda();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Agenda() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(12, 29, 60, 17);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblNumero = new JLabel("Numero telefonico:");
		lblNumero.setBounds(12, 74, 122, 17);
		frame.getContentPane().add(lblNumero);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(90, 27, 114, 21);
		frame.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(152, 72, 114, 21);
		frame.getContentPane().add(txtNumero);
		txtNumero.setColumns(10);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtNombre.getText().isEmpty()) {
					JOptionPane.showMessageDialog(frame, "No debes dejar vacio el nombre!",
				               "Datos Vacios", JOptionPane.ERROR_MESSAGE);
				}else if(txtNumero.getText().isEmpty()) {
					JOptionPane.showMessageDialog(frame, "No debes dejar vacio el numero de telefono!",
				               "Datos Vacios", JOptionPane.ERROR_MESSAGE);
				}else if(!txtNumero.getText().matches("^[67]\\d{8}$")) {
					JOptionPane.showMessageDialog(frame, "El numero debe tener 9 digitas y empezar por 6 o 7!",
				               "Datos Vacios", JOptionPane.ERROR_MESSAGE);
				}else {
				agenda.put(txtNombre.getText(), txtNumero.getText());
				JOptionPane.showMessageDialog(null, "Creado correctamente");
				}
			}
		});
		btnCrear.setBounds(12, 117, 105, 27);
		frame.getContentPane().add(btnCrear);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(334, 29, 104, 115);
		frame.getContentPane().add(scrollPane);
		
		JTextArea txtrMostrar = new JTextArea();
		scrollPane.setViewportView(txtrMostrar);
		
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtrMostrar.setText("");
				for(String s:agenda.keySet()) {
					txtrMostrar.setText(txtrMostrar.getText()+s+":"+agenda.get(s)+"\n");
				}
			}
		});
		btnMostrar.setBounds(333, 159, 105, 27);
		frame.getContentPane().add(btnMostrar);
		
		JLabel lblBuscar = new JLabel("Introduce Nombre:");
		lblBuscar.setBounds(12, 156, 122, 17);
		frame.getContentPane().add(lblBuscar);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(134, 159, 114, 21);
		frame.getContentPane().add(txtBuscar);
		txtBuscar.setColumns(10);
		
		JLabel lblNumbuscar = new JLabel("");
		lblNumbuscar.setBounds(134, 190, 94, 17);
		frame.getContentPane().add(lblNumbuscar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNumbuscar.setText(agenda.get(txtBuscar.getText()));
			}
		});
		btnBuscar.setBounds(12, 185, 105, 27);
		frame.getContentPane().add(btnBuscar);
		
		JLabel lblBorrar = new JLabel("Introduzca Nombre:");
		lblBorrar.setBounds(194, 218, 132, 17);
		frame.getContentPane().add(lblBorrar);
		
		txtBorrar = new JTextField();
		txtBorrar.setBounds(334, 216, 114, 21);
		frame.getContentPane().add(txtBorrar);
		txtBorrar.setColumns(10);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agenda.remove(txtBorrar.getText());
			}
		});
		btnBorrar.setBounds(204, 233, 105, 27);
		frame.getContentPane().add(btnBorrar);
	}
}
