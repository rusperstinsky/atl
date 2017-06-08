package ui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import core.db.Tables;
import core.db.TransaccionesDB;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;

public class Transaciones extends JPanel {
	private JComboBox<String> comboBox;
	private List<String> lstTablas = Tables.tablasEdit();
	private JTable table;
	DefaultTableModel model;
	String[] columns = new String[] { "Columna", "Valor" };
	Object[][] data = new Object[][] { };
	private JLabel lblNoExiste;
	private JButton btnBuscar;
	private JButton btnAplicar;
	private JComboBox comboBox_1;
	private JLabel lblWarning;
	private JButton btnLimpiar;
	private JLabel lblQuery;
	private JTextField txtQuery;
	private JButton btnAplicaQuery;

	/**
	 * Create the panel.
	 */
	public Transaciones( Integer puesto ) {
		setLayout(new MigLayout("", "[][][][][grow][grow]", "[][][][][][][][][grow][]"));			
		
		JLabel lblTabla = new JLabel("Tabla");
		add(lblTabla, "cell 3 3,alignx trailing");
		if( puesto == 1 ){
			comboBox.addItem("Borrar");			
		}
		
		comboBox_1 = new JComboBox();
		comboBox_1.addItem("");
		for(String tabla : lstTablas){
			comboBox_1.addItem(tabla);
		}
		add(comboBox_1, "cell 4 3,growx");
		
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
		
		lblQuery = new JLabel("");
		lblQuery.setVisible(false);
		add(lblQuery, "cell 3 5,alignx trailing");
		
		txtQuery = new JTextField();
		txtQuery.setVisible(false);
		add(txtQuery, "cell 4 5,growx");
		txtQuery.setColumns(10);
		
		btnAplicaQuery = new JButton("Aplica Query");
		btnAplicaQuery.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
								
			}
		});
		btnAplicaQuery.setVisible(false);
		add(btnAplicaQuery, "cell 5 5");
		add(btnBuscar, "flowx,cell 4 7");		
		
		model = new DefaultTableModel(data, columns){
			public boolean isCellEditable(int rowIndex,int columnIndex){
				if( columnIndex == 0 ){
					return false;
				}
				return true;
			}
		};
		
		lblNoExiste = new JLabel("No existe la tabla seleccionada");
		lblNoExiste.setForeground(Color.red);
		lblNoExiste.setVisible(false);
		add(lblNoExiste, "cell 5 7");
		table = new JTable( model );		
		//table = new JTable(data, columns);		
		add(new JScrollPane(table), "cell 3 8 3 1,grow");
		
		btnAplicar = new JButton("Aplicar");
		btnAplicar.setEnabled(false);
		btnAplicar.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {				
				if(comboBox.getSelectedItem().toString().trim().length() > 0 ){
					if(comboBox.getSelectedItem().toString().trim().equalsIgnoreCase("Insertar")){
						List<String> lstColumnas = new ArrayList<String>();
						List<String> lstValores = new ArrayList<String>();
						for (int i = 0; i < table.getRowCount(); i++) {
				            for (int j = 0; j < table.getColumnCount(); j++) {
				            	Object dato=table.getValueAt(i, j);				                
				                if(j%2 == 0){				                	
				                	lstColumnas.add(dato.toString());
				                } else {
				                	lstValores.add(dato.toString());
				                }				            	
				            }
				        }
						String error = TransaccionesDB.inserta(comboBox_1.getSelectedItem().toString(), lstColumnas, lstValores);
						if( error.trim().length() > 0){
							lblWarning.setText(error);
							lblWarning.setVisible(true);
						} else {
							lblWarning.setText("Se realizo la transaccion correctamente");
							lblWarning.setVisible(true);
						}
					}
				}
			}
		});
		
		lblWarning = new JLabel("");
		lblWarning.setForeground(Color.red);
		lblWarning.setVisible(false);
		add(lblWarning, "cell 4 9");
		add(btnAplicar, "cell 5 9,alignx right");
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				onClean();				
			}
		});
		add(btnLimpiar, "cell 4 7");

	}

	
	private void onBuscar( ){
		if(comboBox_1.getSelectedItem().toString().trim().length() > 0 && comboBox.getSelectedItem().toString().trim().length() > 0 ){
			if( comboBox.getSelectedItem().toString().trim().equalsIgnoreCase("Insertar") ){
				List<String> lstCampos = Tables.verificaTabla(comboBox_1.getSelectedItem().toString().trim());
				if( lstCampos.size() > 0 ){
					lblNoExiste.setVisible(false);
					btnBuscar.setEnabled(false);
					comboBox.setEnabled(false);
					comboBox_1.setEnabled(false);
					btnAplicar.setEnabled(true);
					for( String column : lstCampos ){
						model.addRow(new Object[]{column, ""});						
					}			        
				} else {
				    lblNoExiste.setVisible(true);
				}
			} else if( comboBox.getSelectedItem().toString().trim().equalsIgnoreCase("Actualizar") ){
				lblQuery.setText(String.format("SELECT * FROM %s WHERE ", comboBox.getSelectedItem().toString()));
				lblQuery.setVisible(true);
				txtQuery.setVisible(true);
			}
		} else{
			System.out.println("Datos invalidos");			
		}
	}
	

	private void onClean( ){
		comboBox.setEnabled(true);
		comboBox.setSelectedIndex(0);
		comboBox_1.setEnabled(true);
		comboBox_1.setSelectedIndex(0);
		model.setRowCount(0);
		btnBuscar.setEnabled(true);
		btnAplicar.setEnabled(false);
		lblWarning.setText("");
	}
	
	
}
