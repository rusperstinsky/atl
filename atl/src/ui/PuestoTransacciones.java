package ui;

import javax.swing.JPanel;

import core.db.PuestosDB;
import model.Puestos;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JButton;

public class PuestoTransacciones extends JPanel {
	
	private List<Puestos> lstPuestos = PuestosDB.obtienePuestos();
	JComboBox comboBox;
	JCheckBox chckbxInsertar;
	JCheckBox chckbxActualizar;
	JCheckBox chckbxBorrar;
	JLabel lblHuboUnProblema;

	/**
	 * Create the panel.
	 */
	public PuestoTransacciones() {
		setLayout(new MigLayout("", "[][][][][][][grow]", "[][][][][][][][][]"));
		
		JLabel lblPuesto = new JLabel("Puesto");
		add(lblPuesto, "cell 5 2,alignx trailing");
		
		comboBox = new JComboBox();
		for(Puestos p : lstPuestos){
			comboBox.addItem("[" + p.getIdPuesto() + "] " + p.getDescPuesto());
		}
		add(comboBox, "cell 6 2,growx");
		
		JLabel lblTransaccionesAutorizadas = new JLabel("Transacciones Autorizadas");
		add(lblTransaccionesAutorizadas, "cell 6 3,alignx center");
		
		chckbxInsertar = new JCheckBox("Insertar");	
		add(chckbxInsertar, "cell 6 4,alignx center");
		
		chckbxActualizar = new JCheckBox("Actualizar");
		add(chckbxActualizar, "cell 6 5,alignx center");
		
		chckbxBorrar = new JCheckBox("Borrar");
		add(chckbxBorrar, "cell 6 6,alignx center");
		
		JButton btnAplicar = new JButton("Aplicar");
		btnAplicar.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer idPuesto = null;
				String transacciones = "";
				String[] p = comboBox.getSelectedItem().toString().split("]");
				String[] p1 = p[0].toString().split(Pattern.quote("["));
				String puesto = p1[1];
				Boolean valid = true;
				if( chckbxInsertar.isSelected() || chckbxActualizar.isSelected() || chckbxBorrar.isSelected() ){
					transacciones = chckbxInsertar.isSelected() ? transacciones + "Insertar" : transacciones;					
					transacciones = chckbxActualizar.isSelected() ? transacciones + ",Actualizar" : transacciones;					
					transacciones = chckbxBorrar.isSelected() ? transacciones + ",Borrar" : transacciones;					
				} else {
					valid = false;
				}
				try{
					idPuesto = Integer.parseInt(puesto);					
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
					valid = false;
				}
				if( valid && PuestosDB.insertaPuestosXUsuario(idPuesto, transacciones)){
					lblHuboUnProblema.setVisible(false);
					onClean();
				} else {
					lblHuboUnProblema.setVisible(true);
				}
			}
		});
		
		lblHuboUnProblema = new JLabel("Hubo un problema al asignar las transacciones");
		lblHuboUnProblema.setForeground(Color.RED);
		lblHuboUnProblema.setVisible(false);
		add(lblHuboUnProblema, "cell 6 7,alignx center");
		add(btnAplicar, "cell 6 8,alignx center");

	}

	
	private void onClean(){
		comboBox.setSelectedIndex(0);
		chckbxInsertar.setSelected(false);
		chckbxActualizar.setSelected(false);
		chckbxBorrar.setSelected(false);
	}
	
	
}
