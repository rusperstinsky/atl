package ui;

import javax.swing.JPanel;

import core.db.PuestosDB;
import model.Puestos;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

import java.util.List;

import javax.swing.JButton;

public class PuestoTransacciones extends JPanel {
	
	private List<Puestos> lstPuestos = PuestosDB.obtienePuestos();

	/**
	 * Create the panel.
	 */
	public PuestoTransacciones() {
		setLayout(new MigLayout("", "[][][][][][][grow]", "[][][][][][][][]"));
		
		JLabel lblPuesto = new JLabel("Puesto");
		add(lblPuesto, "cell 5 2,alignx trailing");
		
		JComboBox comboBox = new JComboBox();
		for(Puestos p : lstPuestos){
			comboBox.addItem("[" + p.getIdPuesto() + "] " + p.getDescPuesto());
		}
		add(comboBox, "cell 6 2,growx");
		
		JLabel lblTransaccionesAutorizadas = new JLabel("Transacciones Autorizadas");
		add(lblTransaccionesAutorizadas, "cell 6 3,alignx center");
		
		JCheckBox chckbxInsertar = new JCheckBox("Insertar");
		add(chckbxInsertar, "cell 6 4,alignx center");
		
		JCheckBox chckbxActualizar = new JCheckBox("Actualizar");
		add(chckbxActualizar, "cell 6 5,alignx center");
		
		JCheckBox chckbxBorrar = new JCheckBox("Borrar");
		add(chckbxBorrar, "cell 6 6,alignx center");
		
		JButton btnAplicar = new JButton("Aplicar");
		add(btnAplicar, "cell 6 7,alignx center");

	}

}
