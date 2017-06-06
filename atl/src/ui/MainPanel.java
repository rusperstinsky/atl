package ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import core.db.Login;

public class MainPanel {

	private JFrame frame;
	private JTextField txtUsuario;
	private JTextField txtPass;
	private JButton btnAceptar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPanel window = new MainPanel();
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
	public MainPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[][][][][157.00][136.00,grow][][]", "[][][][][][]"));
		
		JLabel lblLogin = new JLabel("Login");
		frame.getContentPane().add(lblLogin, "cell 5 2");
		
		JLabel lblUsuario = new JLabel("Usuario");
		frame.getContentPane().add(lblUsuario, "cell 4 3,alignx trailing");
		
		txtUsuario = new JTextField();
		frame.getContentPane().add(txtUsuario, "cell 5 3,alignx leading");
		txtUsuario.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		frame.getContentPane().add(lblPassword, "cell 4 4,alignx trailing");
		
		txtPass = new JTextField();
		frame.getContentPane().add(txtPass, "cell 5 4,alignx leading");
		txtPass.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				login(txtUsuario.getText().trim(), txtPass.getText().trim());
			}
		});
		frame.getContentPane().add(btnAceptar, "cell 5 5");
	}
	
	private void login( String usuario, String pass ){
		if( Login.verificaCredenciales(usuario, pass) ){
			System.out.println( "Verificado" );
		}
	}
	
	

}