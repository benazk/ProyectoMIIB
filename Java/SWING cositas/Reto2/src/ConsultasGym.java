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
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.EventListener;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class ConsultasGym extends JFrame implements ActionListener, WindowListener, EventListener {
	JComboBox cboQueMostrarGym;
	JButton btnGym;
	JTextField txtNomFiltro;
	JTable tblResultado;
	static String Resultado[][];
	String GymOptions[] = { "Elige lo que se va a mostrar", "Mostrar todos los Deportistas", "Filtrar por nombre",
			"Mostrar todos los tier de Suscripcion", "Mostrar todas las zonas del gimnasio" };
	String GymColumns[] = { "idDeportista", "NombreD", "ApellidoD", "Email", "Telefono", "FechaInicio", "idSubs" };
	static DefaultTableModel model = new DefaultTableModel();
	static Connection con;

	ConsultasGym() {

		cboQueMostrarGym = new JComboBox(GymOptions);
		btnGym = new JButton("Mostrar");
		txtNomFiltro = new JTextField();

		add(cboQueMostrarGym);
		add(btnGym);
		add(txtNomFiltro);

		txtNomFiltro.setVisible(false);

		model.setColumnIdentifiers(GymColumns);
		tblResultado = new JTable(model);
		tblResultado.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tblResultado.setFillsViewportHeight(true);
		JScrollPane scroll = new JScrollPane(tblResultado);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		add(tblResultado);
		tblResultado.setVisible(true);
		cboQueMostrarGym.addActionListener(this);
		btnGym.addActionListener(this);

		setLayout(new FlowLayout());
		setVisible(true);
		setSize(500, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	void TablaConsultas() {

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
		String item = (String) cboQueMostrarGym.getSelectedItem();
		
		try {
		
		if (e.getSource() == cboQueMostrarGym) {
			if (item == "Mostrar todos los Deportistas") {
				Statement depState = con.createStatement();
				ResultSet dep = depState.executeQuery("select * from Deportistas");

				while (dep.next()) {
					int i = 0;
					int id;
					String nom = "";
					String ape = "";
					String email = "";
					String tlfn = "";
					String fecha = "";
					int idSubs;
					id = dep.getInt("idDeportista");
					nom = dep.getString("NombreD");
					ape = dep.getString("ApellidoD");
					email = dep.getString("Email");
					tlfn = dep.getString("Telefono");
					fecha = dep.getString("FechaInicio");
					idSubs = dep.getInt("idSubs");
					model.addRow(new Object[] { id, nom, ape, email, tlfn, fecha, idSubs });
					i++;
				}
			} else if (item == "Filtrar por nombre") {
				txtNomFiltro.setVisible(true);
				String NombreD = txtNomFiltro.getText();
				Statement depnState = con.createStatement();
				ResultSet depn = depnState.executeQuery("select * from Deportistas WHERE NombreD = " + NombreD);
				while (depn.next()) {
					int i = 0;
					int id;
					String nom = "";
					String ape = "";
					String email = "";
					String tlfn = "";
					String fecha = "";
					int idSubs;
					id = depn.getInt("idDeportista");
					nom = depn.getString("NombreD");
					ape = depn.getString("ApellidoD");
					email = depn.getString("Email");
					tlfn = depn.getString("Telefono");
					fecha = depn.getString("FechaInicio");
					idSubs = depn.getInt("idSubs");
					model.addRow(new Object[] { id, nom, ape, email, tlfn, fecha, idSubs });
					i++;
				}

			} else if (item == "Mostrar todos los tier de Suscripcion") {
				Statement suscState = con.createStatement();
				ResultSet susc = suscState.executeQuery("select * from Suscripciones");
				while (susc.next()) {
					int i = 0;
					int idSubs = 0;
					String tipoSubs = "";
					double PrecioSubs = 0;
					idSubs = susc.getInt("idSubs");
					tipoSubs = susc.getString("tipoSubs");
					PrecioSubs = susc.getDouble("PrecioSubs");
					model.addRow(new Object[] { idSubs, tipoSubs, PrecioSubs });
				}
			} else {
				Statement zonaState = con.createStatement();
				ResultSet zona = zonaState.executeQuery("select * from ZonaDeporte");
				while (zona.next()) {
					int i = 0;
					int NumTarjeta = 0;
					int idZona = 0;
					String Zona = "";
					NumTarjeta = zona.getInt("NumTarjeta");
					idZona = zona.getInt("idZona");
					Zona = zona.getString("Zona");
					model.addRow(new Object[] { NumTarjeta, idZona, Zona });
				}
			}
		}
		
		} catch(Exception exc) {
			System.out.println("Ha ocurrido un error");
		}

	}

	public static void main(String[] args) throws Exception {

		ConsultasGym programa = new ConsultasGym();
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