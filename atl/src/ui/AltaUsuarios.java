package ui;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class AltaUsuarios extends JPanel {
	private JTextField txtNombre;
	private JTextField txtPass;
	private JTextField txtIdEmp;

	/**
	 * Create the panel.
	 */
	public AltaUsuarios() {
		setLayout(new MigLayout("", "[][][][][][][][grow]", "[][][][][][]"));
		
		JLabel lblPuesto = new JLabel("Puesto");
		add(lblPuesto, "cell 6 2,alignx trailing");
		
		JComboBox comboBox = new JComboBox();
		add(comboBox, "cell 7 2,growx");
		
		JLabel lblNombre = new JLabel("Nombre");
		add(lblNombre, "cell 6 3,alignx trailing");
		
		txtNombre = new JTextField();
		add(txtNombre, "cell 7 3,growx");
		txtNombre.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		add(lblPassword, "cell 6 4,alignx trailing");
		
		txtPass = new JTextField();
		add(txtPass, "cell 7 4,growx");
		txtPass.setColumns(10);
		
		JLabel lblIdEmpleado = new JLabel("Id Empleado");
		add(lblIdEmpleado, "cell 6 5,alignx trailing");
		
		txtIdEmp = new JTextField();
		add(txtIdEmp, "cell 7 5,growx");
		txtIdEmp.setColumns(10);

	}

}
