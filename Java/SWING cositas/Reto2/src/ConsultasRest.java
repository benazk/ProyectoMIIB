import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.EventListener;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class ConsultasRest extends JFrame  implements ActionListener, WindowListener, EventListener{
	JComboBox cboQueMostrarRest;
	JButton btnRest;
	JTextField txtFiltro;
	JTable tblResultado;
	JButton btnFiltro;
	String RestOptions[] = { "Elige lo que se va a mostrar", "Mostrar todos los Comensales", "Filtrar por nombre",
			"Mostrar todas las mesas", "Mostrar todos los menus" };
	String RestColumns[] = { "idComensal", "NombreC", "ApellidoC", "Email", "Telefono", "DiaYHora", "idMesa", "idMenu" };
	String MesaColumns[] = {"idMesa", "idMenu"};
	String MenuColumns[] = {"idMenu", "ObjetoMenu", "Precio"};
	static DefaultTableModel model = new DefaultTableModel();
	static Connection con;
	
	ConsultasRest(){
		
		
		cboQueMostrarRest = new JComboBox(RestOptions);
		btnRest = new JButton();
		txtFiltro = new JTextField();
		btnFiltro = new JButton();
		
		txtFiltro.setColumns(8);
		add(cboQueMostrarRest);
		add(btnRest);
		add(txtFiltro);
		add(btnFiltro);
		
		txtFiltro.setVisible(false);
		btnFiltro.setVisible(false);
		
		cboQueMostrarRest.addActionListener(this);
		btnRest.addActionListener(this);
		txtFiltro.addActionListener(this);
		
		setVisible(true); 
		setSize(500, 300);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
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
		String item = (String) cboQueMostrarRest.getSelectedItem();
		
		try {
		
		if (e.getSource() == btnRest) {
			if (item == "Mostrar todos los Comensales") {
				
				Statement comState = con.createStatement();
				ResultSet com = comState.executeQuery("select * from Comensales");
				model.setColumnIdentifiers(RestColumns);
				tblResultado = new JTable(model);
				tblResultado.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
				tblResultado.setFillsViewportHeight(true);
				JScrollPane scroll = new JScrollPane(tblResultado);
				scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
				
				while (com.next()) {
					int id;
					String nombreC = "";
					String apellidoC = "";
					String email = "";
					String telefono = "";
					String DiaYHora = "";
					int idMesa;
					int idMenu;
					id = com.getInt("idComensal");
					nombreC = com.getString("NombreD");
					apellidoC = com.getString("ApellidoD");
					email = com.getString("Email");
					telefono = com.getString("Telefono");
					DiaYHora = com.getString("DiaYHora");
					idMesa = com.getInt("idMenu");
					idMenu = com.getInt("idMesa");
					model.addRow(new Object[] { id, nombreC, apellidoC, email, telefono, DiaYHora, idMesa, idMenu });
				}
			
			} else if (item == "Filtrar por nombre") {
				txtFiltro.setVisible(true);
				btnFiltro.setVisible(true);
				String NombreC = txtFiltro.getText();
				
				if (e.getSource() == btnFiltro)
				model.setColumnIdentifiers(RestColumns);
				tblResultado = new JTable(model);
				tblResultado.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
				tblResultado.setFillsViewportHeight(true);
				JScrollPane scroll = new JScrollPane(tblResultado);
				scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
				Statement comnState = con.createStatement();
				ResultSet comn = comnState.executeQuery("select * from Comensales WHERE NombreC = " + "'" + NombreC + "'");
				
				while (comn.next()) {
					int id;
					String nombreC = "";
					String apellidoC = "";
					String email = "";
					String telefono = "";
					String DiaYHora = "";
					int idMesa;
					int idMenu;
					id = comn.getInt("idComensal");
					nombreC = comn.getString("NombreD");
					apellidoC = comn.getString("ApellidoD");
					email = comn.getString("Email");
					telefono = comn.getString("Telefono");
					DiaYHora = comn.getString("DiaYHora");
					idMesa = comn.getInt("idMenu");
					idMenu = comn.getInt("idMesa");
					model.addRow(new Object[] { id, nombreC, apellidoC, email, telefono, DiaYHora, idMesa, idMenu });
				}

			} else if (item == "Mostrar todas las mesas") {
				
				model.setColumnIdentifiers(MesaColumns);
				tblResultado = new JTable(model);
				tblResultado.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
				tblResultado.setFillsViewportHeight(true);
				JScrollPane scroll = new JScrollPane(tblResultado);
				scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
				Statement mesaState = con.createStatement();
				ResultSet mesa = mesaState.executeQuery("select * from ZonaRestauracion");
				
				while (mesa.next()) {
					int idMesa = 0;
					int MesaNum = 0;
					idMesa = mesa.getInt("idMesa");
					MesaNum = mesa.getInt("MesaNum");
					model.addRow(new Object[] { idMesa, MesaNum});
				}
			
			} else {
				
				model.setColumnIdentifiers(MenuColumns);
				tblResultado = new JTable(model);
				tblResultado.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
				tblResultado.setFillsViewportHeight(true);
				JScrollPane scroll = new JScrollPane(tblResultado);
				scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
				Statement menuState = con.createStatement();
				ResultSet menu = menuState.executeQuery("select * from Menu");
				
				while (menu.next()) {
					int i = 0;
					int idMenu = 0;
					String ObjetoMenu = "";
					Double Precio = 0.00;
					idMenu = menu.getInt("NumTarjeta");
					ObjetoMenu = menu.getString("idZona");
					Precio = menu.getDouble("Zona");
					model.addRow(new Object[] { idMenu, ObjetoMenu, Precio });
					i++;
				}
				
			
			}
			tblResultado.setVisible(true);
			}
	
		} catch(Exception exc) {
			System.out.println("Ha ocurrido un error");
		}
		
	}
	public static void main(String[] args) throws Exception {
		new ConsultasRest();
		// Conectar el Driver JDBC
	      Class.forName("com.mysql.cj.jdbc.Driver");

	      final String url = "dbrds.c1cqmqwa0ite.us-east-1.rds.amazonaws.com";
	      final String user = "admin";
	      final String password = "ASdiioqw--ad45";
	      
	      con = DriverManager.getConnection(url, user, password);

	      if (con == null) {
	         System.out.println("No se ha establecido la conexión");
	         return;
	      } else {
	         System.out.println("¡Felicidades! Se ha establecido la conexión");
	      } 
	      
	      con.close();

	}

}