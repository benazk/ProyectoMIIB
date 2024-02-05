import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Container;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.EventListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;


@SuppressWarnings("serial")
public class ConsultasGym2 extends JFrame implements ActionListener, WindowListener, EventListener {
	//JComboBox cboQueMostrarGym;
	JButton btnGym;
	JTextField txtFiltro;
	JTable tblResultado;
	JButton btnFiltro;
	JLabel lblImagen;
	ImageIcon imgLogo;
	String GymOptions[] = { "   Elige lo que se va a mostrar", "   Mostrar todos los Deportistas",
			"   Filtrar por nombre", "   Mostrar todas las Suscripciones", "   Mostrar todos los Zonas" };
	String GymColumns[] = { "idDeportista", "NombreD", "ApellidoD", "Email", "Telefono", "FechaInicio", "idSubs" };
	String SusColumns[] = { "idSubs", "PrecioSubs", "TipoSubs" };
	String ZonaColumns[] = { "idZona", "NumTarjeta", "Zona" };
	static DefaultTableModel model = new DefaultTableModel();
	static Connection con;

	ConsultasGym2() {
		
		//imgLogo = new ImageIcon("E:\\gatucos.png");
		//lblImagen = new JLabel(imgLogo);
		//Color cbo = new Color(8, 170, 170);
		//Image imgIcon = Toolkit.getDefaultToolkit().getImage("C://Users/alu01/Documents/MIIB.jpg");
		//setIconImage(imgIcon);
		
		setTitle("Consultas al Gimnasio");
		//Container c = getContentPane();

		//c.setBackground(new java.awt.Color(120, 200, 200));

		//cboQueMostrarGym = new JComboBox(GymOptions);
		btnGym = new JButton("Mostrar Tabla");
		txtFiltro = new JTextField();
		btnFiltro = new JButton("Filtrar Tabla");

		txtFiltro.setColumns(8);
		//cboQueMostrarGym.setSize(210, 40);
		//cboQueMostrarGym.setLocation(255, 50);
		//cboQueMostrarGym.setBackground(cbo);
		//cboQueMostrarGym.setBorder(null);
		btnGym.setSize(100, 40);
		btnGym.setLocation(420, 100);
		btnGym.setBackground(new Color(120, 190, 190));
		btnGym.setBorder(null);
		txtFiltro.setSize(210, 40);
		txtFiltro.setLocation(200, 100);
		//lblImagen.setSize(80, 80);
		//lblImagen.setLocation(500, 100);
		//add(cboQueMostrarGym);
		add(btnGym);
		add(txtFiltro);
		//add(lblImagen);
		
		
		
		btnGym.setVisible(true);
		txtFiltro.setVisible(true);
		//cboQueMostrarGym.addActionListener(this);
		btnGym.addActionListener(this);
		txtFiltro.addActionListener(this);

		
		tblResultado = new JTable(model);
		tblResultado.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tblResultado.setFillsViewportHeight(true);
		JScrollPane scroll = new JScrollPane(tblResultado);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		
		setVisible(true);
		setSize(800, 600);
		setLayout(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
	/*	String item = (String) cboQueMostrarGym.getSelectedItem();
		System.out.println(item);
		
		try {
			
			if ("Mostrar todos los Deportistas".equals(item)) {
				System.out.println(1);					
				
				model.setColumnIdentifiers(GymColumns);
				Statement depState = con.createStatement();
				ResultSet dep = depState.executeQuery("SELECT * FROM Deportistas");
				while (dep.next()) {
					
					int id = 0;
					String nombreD = "";
					String apellidoD = "";
					String email = "";
					String telefono = "";
					String FechaInicio = "";
					int idSubs = 0;
					id = dep.getInt(1);
					nombreD = dep.getString(2);
					apellidoD = dep.getString(3);
					email = dep.getString(4);
					telefono = dep.getString(5);
					FechaInicio = dep.getString(6);
					idSubs = dep.getInt(7);
					model.addRow(new Object[] { id, nombreD, apellidoD, email, telefono, FechaInicio, idSubs });
					
				}
				
				
			} else if ("Filtrar por nombre".equals(item)) {
				txtFiltro.setVisible(true);
				btnGym.setVisible(true);
				if (e.getSource() == btnGym) {

					String Filtro = txtFiltro.getText();
					model.setColumnIdentifiers(GymColumns);
					Statement depnState = con.createStatement();
					ResultSet depn = depnState
							.executeQuery("select * from Deportistas WHERE NombreD = " + "'" + Filtro + "'");

					while (depn.next()) {
						int id = 0;
						String nombreD = "";
						String apellidoD = "";
						String email = "";
						String telefono = "";
						String FechaInicio = "";
						int idSubs = 0;
						id = depn.getInt(1);
						nombreD = depn.getString(2);
						apellidoD = depn.getString(3);
						email = depn.getString(4);
						telefono = depn.getString(5);
						FechaInicio = depn.getString(6);
						idSubs = depn.getInt(7);
						model.addRow(new Object[] { id, nombreD, apellidoD, email, telefono, FechaInicio, idSubs });
					}
				}
			} else if ("Mostrar todas las suscripciones".equals(item)) {

				model.setColumnIdentifiers(SusColumns);
				
				Statement susState = con.createStatement();
				ResultSet sus = susState.executeQuery("select * from Suscripcion");

				while (sus.next()) {
					int idSubs = 0;
					double PrecioSubs;
					String TipoSubs = "";
					idSubs = sus.getInt(1);
					PrecioSubs = sus.getDouble(2);
					TipoSubs = sus.getString(3);
					model.addRow(new Object[] { idSubs, PrecioSubs, TipoSubs });
				}

			} else if ("Mostrar todas las zonas".equals(item)) {

				model.setColumnIdentifiers(ZonaColumns);
				 if (con == null) {
			            System.out.println("No se ha establecido la conexión");
				 }
				Statement zonaState = con.createStatement();
				ResultSet zona = zonaState.executeQuery("select * from ZonaDeporte");

				while (zona.next()) {
					int idZona = 0;
					int NumTarjeta;
					String Zona= "";
					idZona = zona.getInt(1);
					NumTarjeta= zona.getInt(2);
					Zona = zona.getString(3);
					model.addRow(new Object[] { idZona, NumTarjeta, Zona});
				}

			}
			tblResultado.setVisible(true);

		} catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
	        try {
	            if (con != null && !con.isClosed()) {
	                con.close();
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }
*/
	}

	public static void main(String[] args) throws Exception {
	   new ConsultasGym2();
/*
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        final String url = "jdbc:mysql://dbrds.c1cqmqwa0ite.us-east-1.rds.amazonaws.com:3306/BBDDProyectoGym1";
	        final String user = "admin";
	        final String password = "ASdiioqw--ad45";
	        con = DriverManager.getConnection(url, user, password);

	        if (con == null) {
	            System.out.println("No se ha establecido la conexión");
	            return;
	        } else {
	            System.out.println("¡Felicidades! Se ha establecido la conexión");
	            return;
	        }
*/
	    } 
	}
