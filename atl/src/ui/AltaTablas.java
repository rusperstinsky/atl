package ui;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import core.db.Tables;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;

public class AltaTablas extends JPanel {
	private JTextField txtNombreTabla;
	private JButton btnAlta;
	private JLabel lblNoExiste;

	/**
	 * Create the panel.
	 */
	public AltaTablas() {
		setLayout(new MigLayout("", "[][][][][][grow]", "[][][][][]"));
		
		JLabel lblNombreTabla = new JLabel("Nombre Tabla");
		add(lblNombreTabla, "cell 4 2,alignx trailing");
		
		txtNombreTabla = new JTextField();
		add(txtNombreTabla, "cell 5 2,growx");
		txtNombreTabla.setColumns(10);
		
		btnAlta = new JButton("Dar de Alta");
		lblNoExiste = new JLabel("No existe la tabla ingresada");
		btnAlta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				List<String> campos = Tables.verificaTabla( txtNombreTabla.getText().trim() );
				if( campos.size() > 0 ){
					System.out.println("La tabla contiene: " + campos.size());
					lblNoExiste.setVisible(false);
					if( Tables.validaTablaEdit(txtNombreTabla.getText().trim())){
						Tables.insertaTablaEdit(txtNombreTabla.getText().trim());
						clean();
					} else {
						lblNoExiste.setText("La tabla ya est� dada de alta");
						lblNoExiste.setVisible(true);
					}					
				} else {
					System.out.println("No existe la tabla");
					lblNoExiste.setVisible(true);
				}
			}
		});
				
		lblNoExiste.setVisible(false);
		lblNoExiste.setForeground(Color.RED);
		add(lblNoExiste, "cell 5 3");		
		add(btnAlta, "cell 5 4");

	}
	
	private void clean(){
		txtNombreTabla.setText("");
		lblNoExiste.setText("No existe la tabla");
		lblNoExiste.setVisible(false);
	}

}