package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;

public class MainWindow extends JFrame {

	private LoginPanel loginPanel;
	private AltaTablas altaTablas;
	private Integer puesto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
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
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		loginPanel = new LoginPanel( this );
		//loginPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(loginPanel);
		loginPanel.setLayout(new MigLayout("wrap,center", "[fill,center][fill,center]", "[center]"));		
	}

	public void correctCredentials( Integer puesto ){
		loginPanel.setVisible(false);
		altaTablas = new AltaTablas();
		setContentPane(altaTablas);
		setVisible(true);
	}
	
	
}