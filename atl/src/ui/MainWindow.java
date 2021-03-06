package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MainWindow extends JFrame {

	private LoginPanel loginPanel;
	private AltaTablas altaTablas;
	private Transaciones transaciones;
	private AltaUsuarios altaUsuarios;
	private PuestoTransacciones puestoTransacciones;
	private Integer puesto;
	private static MainWindow frame;
	private JMenu mnMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new MainWindow();
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
		setBounds(100, 100, 713, 520);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnMenu = new JMenu("Menu");
		mnMenu.setVisible(false);
		menuBar.add(mnMenu);
		
		JMenuItem mntmAltaDeTablas = new JMenuItem("Alta de Tablas");
		mntmAltaDeTablas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				altaTablasMenu();
			}
		});
		mnMenu.add(mntmAltaDeTablas);
		
		JMenuItem mntmTransacciones = new JMenuItem("Transacciones");
		mntmTransacciones.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				transaccionesMenu( loginPanel.getPuesto() );
				
			}
		});
		mnMenu.add(mntmTransacciones);
		
		JMenuItem mntmAltaUsuario = new JMenuItem("Alta Usuario");
		mntmAltaUsuario.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				altaUsuario( 1 );
			}
		});
		mnMenu.add(mntmAltaUsuario);
		
		JMenuItem mntmTransaccionesXUsuario = new JMenuItem("Transacciones X Usuario");
		mntmTransaccionesXUsuario.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				transXUsuario( 1 );
				
			}
		});
		mnMenu.add(mntmTransaccionesXUsuario);
		
		JMenu mnVentana = new JMenu("Herramientas");
		menuBar.add(mnVentana);
		
		JMenuItem mntmCerrarSesin = new JMenuItem("Cerrar Sesi\u00F3n");
		mntmCerrarSesin.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {						
				if( transaciones != null ){
					transaciones.setVisible(false);					
				}
				if( altaTablas != null ){
					altaTablas.setVisible(false);
				}
				if( altaUsuarios != null ){
					altaUsuarios.setVisible(false);
				}
				if( puestoTransacciones != null ){
					puestoTransacciones.setVisible(false);
				}
				mnMenu.setVisible(false);
				loginPanel.setVisible(true);
				setContentPane(loginPanel);
				setVisible(true);
			}
		});
		mnVentana.add(mntmCerrarSesin);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);				
			}
		});
		mnVentana.add(mntmSalir);
		loginPanel = new LoginPanel( this );
		//loginPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(loginPanel);
		loginPanel.setLayout(new MigLayout("wrap,center", "[fill,center][fill,center]", "[center]"));		
	}

	public void altaTablasMenu( ){
		mnMenu.setVisible(true);
		loginPanel.setVisible(false);
		if( transaciones!= null ){
			transaciones.setVisible(false);	
		}		
		if( altaUsuarios != null ){
			altaUsuarios.setVisible(false);			
		}		
		if( puestoTransacciones != null ){
			puestoTransacciones.setVisible(false);
		}
		if( altaTablas == null ){
			altaTablas = new AltaTablas();	
		}			
		altaTablas.setVisible(true);
		setContentPane(altaTablas);
		setVisible(true);
	}
	
	
	public void transaccionesMenu( Integer puesto ){
		if( puesto == 1 ){
			mnMenu.setVisible(true);	
		}		
		loginPanel.setVisible(false);
		if( altaTablas != null ){
			altaTablas.setVisible(false);	
		}		
		if( altaUsuarios != null ){
			altaUsuarios.setVisible(false);	
		}
		if( puestoTransacciones != null ){
			puestoTransacciones.setVisible(false);
		}
		if( transaciones == null ){
			transaciones = new Transaciones( puesto );	
		}		
		transaciones.setVisible(true);
		setContentPane(transaciones);
		setVisible(true);
	}
	
	
	
	public void altaUsuario( Integer puesto ){
		if( puesto == 1 || puesto == 2 ){
			mnMenu.setVisible(true);	
		}		
		loginPanel.setVisible(false);
		if( altaTablas != null ){
			altaTablas.setVisible(false);	
		}		
		if( transaciones != null ){
			transaciones.setVisible(false);	
		}
		if( puestoTransacciones != null ){
			puestoTransacciones.setVisible(false);
		}
		if( altaUsuarios == null ){
			altaUsuarios = new AltaUsuarios( );	
		}				
		altaUsuarios.setVisible(true);
		setContentPane(altaUsuarios);
		setVisible(true);
	}
	
	
	public void transXUsuario( Integer puesto ){
		if( puesto == 1 || puesto == 2 ){
			mnMenu.setVisible(true);	
		}		
		loginPanel.setVisible(false);
		if( altaTablas != null ){
			altaTablas.setVisible(false);	
		}		
		if( transaciones != null ){
			transaciones.setVisible(false);	
		}
		if( altaUsuarios != null ){
			altaUsuarios.setVisible(false);
		}
		if( puestoTransacciones == null ){
			puestoTransacciones = new PuestoTransacciones();	
		}				
		puestoTransacciones.setVisible(true);
		setContentPane(puestoTransacciones);
		setVisible(true);
	}
	
}
