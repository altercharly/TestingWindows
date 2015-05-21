package capapresentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import capanegocio.Contpersonas;
import entidades.*;


public class ventana extends JFrame {

	private JPanel contentPane;
	public static JTextField txtdni;
	public static JTextField txtNom;
	private JLabel lblemail;
	public static JTextField txtemail;
	private JLabel lblApellido;
	public static JTextField txtApell;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventana frame = new ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ventana() {
		final Contpersonas cpers = new Contpersonas();
		setBackground(Color.WHITE);
		setTitle("Ventana Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 189);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblDni = new JLabel("Dni :");
		txtdni = new JTextField();
		txtdni.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre :");
		txtNom = new JTextField();
		txtNom.setColumns(10);
		
		lblemail = new JLabel("email :");
		txtemail = new JTextField();
		txtemail.setColumns(10);
		
		lblApellido = new JLabel("Apellido :");
		txtApell = new JTextField();
		txtApell.setColumns(10);
		
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Persona p = cpers.searchPersona((Integer.parseInt(txtdni.getText())));
				if (p == null){
					JOptionPane.showMessageDialog(null, "Persona no encontrada");
				}
				else{
					JOptionPane.showMessageDialog(null, "Persona encontrada");
				txtNom.setText(p.getNombre());
				txtApell.setText(p.getApellido());
				txtemail.setText(p.getEmail());
				}
			}
		});
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message;
				message = cpers.deletePersona((Integer.parseInt(txtdni.getText())));
				JOptionPane.showMessageDialog(null, message);
			}
		});
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message;
				message = cpers.addPersona((Integer.parseInt(txtdni.getText())), txtNom.getText(), txtApell.getText(), txtemail.getText());
				JOptionPane.showMessageDialog(null, message);
			}
		});
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Persona p = cpers.updatePersona((Integer.parseInt(txtdni.getText())), txtNom.getText(), txtApell.getText(), txtemail.getText());
				if (p == null){
					JOptionPane.showMessageDialog(null, "Persona no existente");
				}
				JOptionPane.showMessageDialog(null, "Persona actualizada");
				txtNom.setText(p.getNombre());
				txtApell.setText(p.getApellido());
				txtemail.setText(p.getEmail());
			}
		});
				
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblDni)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtdni, 190, 190, 190))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNombre)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtNom, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnBuscar, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
							.addGap(58)
							.addComponent(btnGuardar, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(14)
							.addComponent(lblemail)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtemail, 204, 204, 204))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblApellido)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtApell, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnActualizar)
									.addGap(47)
									.addComponent(btnBorrar, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)))))
					.addGap(111))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDni)
						.addComponent(txtdni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtemail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblemail, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(txtNom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblApellido)
						.addComponent(txtApell, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnActualizar)
						.addComponent(btnBorrar)
						.addComponent(btnGuardar)
						.addComponent(btnBuscar))
					.addContainerGap(212, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
}
