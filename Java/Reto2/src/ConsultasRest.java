import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.EventListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class ConsultasRest extends JFrame implements ActionListener, WindowListener, EventListener {
	JComboBox cboQueMostrarRest;
	JButton btnRest;
	JTextField txtFiltro;
	JTable tblResultado;
	JButton btnFiltro;
	ImageIcon imgLogo;
	String RestOptions[] = { "   Elige lo que se va a mostrar", "   Mostrar todos los Comensales",
			"   Filtrar por nombre", "   Mostrar todas las mesas", "   Mostrar todos los menus" };
	static DefaultTableModel model = new DefaultTableModel();
	JScrollPane scroll;
	static Connection conRest;
	ConsultasRest() {
		
		Color cbo = new Color(8, 170, 170);
		Image imgIcon = Toolkit.getDefaultToolkit().getImage("MIIB.jpg");
		setIconImage(imgIcon);
		setTitle("Consultas al Restaurante");
		Container c = getContentPane();

		c.setBackground(new java.awt.Color(120, 200, 200));

		cboQueMostrarRest = new JComboBox(RestOptions);
		btnRest = new JButton("Mostrar Tabla");
		txtFiltro = new JTextField();
		btnFiltro = new JButton("Filtrar Tabla");
		txtFiltro.setColumns(8);
		
		cboQueMostrarRest.setSize(210, 40);
		cboQueMostrarRest.setLocation(255, 50);
		cboQueMostrarRest.setBackground(cbo);
		cboQueMostrarRest.setBorder(null);
		
		btnRest.setSize(100, 40);
		btnRest.setLocation(420, 100);
		btnRest.setBackground(new Color(120, 190, 190));
		btnRest.setBorder(null);
		
		txtFiltro.setSize(210, 40);
		txtFiltro.setLocation(200, 100);
		
		add(cboQueMostrarRest);
		add(btnRest);
		add(txtFiltro);

		btnRest.setVisible(false);
		txtFiltro.setVisible(false);
		cboQueMostrarRest.addActionListener(this);
		btnRest.addActionListener(this);
		txtFiltro.addActionListener(this);

		
		tblResultado = new JTable();
		tblResultado.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tblResultado.setFillsViewportHeight(true);
		tblResultado.setPreferredScrollableViewportSize(new Dimension(800, 400));
		tblResultado.setSize(800,2000);
		tblResultado.setLocation(0, 150);
		
		scroll = new JScrollPane(tblResultado);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setSize(700, 400); 
		scroll.setLocation(0, 150);
	
		add(tblResultado);	
		add(scroll);
		tblResultado.setVisible(false);
		
		setVisible(true);
		setSize(800, 600);
		setLayout(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	@Override
	public void windowOpened(WindowEvent e) {

	}

	@Override
	public void windowClosing(WindowEvent e) {
		
	}

	@Override
	public void windowClosed(WindowEvent e) {

	}

	@Override
	public void windowIconified(WindowEvent e) {

	}

	@Override
	public void windowDeiconified(WindowEvent e) {

	}

	@Override
	public void windowActivated(WindowEvent e) {

	}

	@Override
	public void windowDeactivated(WindowEvent e) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String item = (String) cboQueMostrarRest.getSelectedItem();
		Connection conRest = null;
		try {
			DefaultTableModel LimpiarTabla = (DefaultTableModel)tblResultado.getModel();
			while(LimpiarTabla.getRowCount() > 0)
			{
				LimpiarTabla.removeRow(0);
			}
			Class.forName("com.mysql.cj.jdbc.Driver");
			final String url = "jdbc:mysql://dbrds.c1cqmqwa0ite.us-east-1.rds.amazonaws.com:3306/BBDDProyectoGym1";
			final String user = "admin";
			final String password = "ASdiioqw--ad45";
			conRest = DriverManager.getConnection(url, user, password);
			
			if (conRest == null) {
			    System.out.println("No se ha establecido la conexión");
			    return;
			} else {
			    System.out.println("¡Felicidades! Se ha establecido la conexión");
			    
			}
			  

			if ("   Mostrar todos los Comensales".equals(item)) {
				System.out.println(1);					
				int id = 0;
				String nombreC = "";
				String apellidoC = "";
				String email = "";
				String telefono = "";
				String DiaYHora = "";
				int idMesa = 0;
				int idMenu = 0;
				model.setColumnIdentifiers(new Object[] {"idComensal", "NombreC", "ApellidoC", "Email", "Telefono", "DiaYHora", "idMesa",
				"idMenu"});
		tblResultado.setModel(model);
				Statement comState = conRest.createStatement();
				ResultSet com = comState.executeQuery("SELECT * FROM Comensales");
				while (com.next()) {
					
					id = com.getInt(1);
					nombreC = com.getString(2);
					apellidoC = com.getString(3);
					email = com.getString(4);
					telefono = com.getString(5);
					DiaYHora = com.getString(6);
					idMesa = com.getInt(7);
					idMenu = com.getInt(8);
					
					model.addRow(new Object[] { id, nombreC, apellidoC, email, telefono, DiaYHora, idMesa, idMenu });
					
				}
				
				tblResultado.setVisible(true);
			
			} 
			
			else if ("   Filtrar por nombre".equals(item)) {
				txtFiltro.setVisible(true);
				btnRest.setVisible(true);
				if (e.getSource() == btnRest) {

					String NombreC = txtFiltro.getText();
					model.setColumnIdentifiers(new Object[] {"idComensal", "NombreC", "ApellidoC", "Email", "Telefono", "DiaYHora", "idMesa",
							"idMenu"});
					tblResultado.setModel(model);
					Statement comnState = conRest.createStatement();
					ResultSet comn = comnState
							.executeQuery("select * from Comensales WHERE NombreC = " + "'" + NombreC + "'");

					while (comn.next()) {
						int id;
						String nombreC = "";
						String apellidoC = "";
						String email = "";
						String telefono = "";
						String DiaYHora = "";
						int idMesa;
						int idMenu;
						id = comn.getInt(1);
						nombreC = comn.getString(2);
						apellidoC = comn.getString(3);
						email = comn.getString(4);
						telefono = comn.getString(5);
						DiaYHora = comn.getString(6);
						idMesa = comn.getInt(7);
						idMenu = comn.getInt(8);
						model.addRow(
								new Object[] { id, nombreC, apellidoC, email, telefono, DiaYHora, idMesa, idMenu });
					}
					tblResultado.setVisible(true);
				}
			} else if ("   Mostrar todas las mesas".equals(item)) {

				model.setColumnIdentifiers(new Object[] {"idMesa", "MesaNum"});
				tblResultado.setModel(model);
				Statement mesaState = conRest.createStatement();
				ResultSet mesa = mesaState.executeQuery("select * from ZonaRestauracion");

				while (mesa.next()) {
					int idMesa = 0;
					String MesaNum = "";
					idMesa = mesa.getInt(1);
					MesaNum = mesa.getString(2);
					model.addRow(new Object[] { idMesa, MesaNum });
				}
				tblResultado.setVisible(true);

			} else if ("   Mostrar todos los menus".equals(item)) {

				model.setColumnIdentifiers(new Object[] {"idMenu", "ObjetoMenu", "Precio"});
				tblResultado.setModel(model);
				Statement menuState = conRest.createStatement();
				ResultSet menu = menuState.executeQuery("select * from Menu");

				while (menu.next()) {
					int idMenu;
					String ObjetoMenu;
					Double Precio;
					idMenu = menu.getInt(1);
					ObjetoMenu = menu.getString(2);
					Precio = menu.getDouble(3);
					model.addRow(new Object[] { idMenu, ObjetoMenu, Precio });
				}
			}
			
			}
		catch (
		
				Exception o) {
					o.printStackTrace();
				} 
		
		finally {
					try {
						conRest.close();
					} catch (SQLException e1) {						
						e1.printStackTrace();
					}
				}
		

	}

	public static void main(String[] args) throws Exception {
	    new ConsultasRest();
	        

	    } 
	}
