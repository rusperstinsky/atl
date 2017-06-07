package ui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import core.db.Tables;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;

public class Transaciones extends JPanel {
	private JTextField textField;
	private JComboBox<String> comboBox;
	private JTable table;
	DefaultTableModel model;
	String[] columns = new String[] { "Columna", "Valor" };
	Object[][] data = new Object[][] { { } };
	private JLabel lblNoExiste;
	private JButton btnBuscar;

	/**
	 * Create the panel.
	 */
	public Transaciones( Integer puesto ) {
		setLayout(new MigLayout("", "[][][][][grow][grow]", "[][][][][][][][grow]"));			
		
		JLabel lblTabla = new JLabel("Tabla");
		add(lblTabla, "cell 3 3,alignx trailing");
		if( puesto == 1 ){
			comboBox.addItem("Borrar");			
		}
		
		textField = new JTextField();
		add(textField, "cell 4 3,growx");
		textField.setColumns(10);
		
		JLabel lblTransaccin = new JLabel("Transacci\u00F3n");
		add(lblTransaccin, "cell 3 4,alignx trailing");
		
		comboBox = new JComboBox<String>();
		comboBox.addItem("");
		comboBox.addItem("Insertar");
		comboBox.addItem("Actualizar");		
		add(comboBox, "cell 4 4,growx");
		
		DefaultTableModel modelo = new DefaultTableModel();
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				onBuscar();			
			}
		});
		add(btnBuscar, "cell 4 6");		
		
		model = new DefaultTableModel(data, columns);
		
		lblNoExiste = new JLabel("No existe la tabla seleccionada");
		lblNoExiste.setForeground(Color.red);
		lblNoExiste.setVisible(false);
		add(lblNoExiste, "cell 5 6");
		table = new JTable( model );		
		//table = new JTable(data, columns);		
		add(new JScrollPane(table), "cell 3 7 3 1,grow");

	}

	
	private void onBuscar( ){
		if(textField.getText().trim().length() > 0 && comboBox.getSelectedItem().toString().trim().length() > 0 ){
			if( comboBox.getSelectedItem().toString().trim().equalsIgnoreCase("Insertar") ){
				List<String> lstCampos = Tables.verificaTabla(textField.getText().trim());
				if( lstCampos.size() > 0 ){
					lblNoExiste.setVisible(false);
					btnBuscar.setEnabled(false);
					for( String column : lstCampos ){
						model.addRow(new Object[]{column, ""});
					}			        
				} else {
				    lblNoExiste.setVisible(true);
				}
			}
		} else{
			System.out.println("Datos invalidos");			
		}
	}
	
	
}
