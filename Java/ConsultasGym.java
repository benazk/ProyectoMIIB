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

public class ConsultasGym extends JFrame implements ActionListener, WindowListener, EventListener{
	JComboBox cboQueMostrarGym;
	JButton btnGym;
	JTextField txtNomFiltro;
	JTable tblResultado;
	static String Resultado[][];
	String GymOptions[] = {"Elige lo que se va a mostrar", "Mostrar todos los Deportistas", "Filtrar por nombre", "Mostrar todos los tier de Suscripcion", "Mostrar todas las zonas del gimnasio" };
	String GymColumns[] = {"idDeportista", "NombreD", "ApellidoD", "Email", "Telefono", "FechaInicio", "idSubs"};
	
	ConsultasGym(){
		
		
		
		cboQueMostrarGym = new JComboBox(GymOptions);
		btnGym = new JButton("Mostrar");
		txtNomFiltro = new JTextField();
		
		add(cboQueMostrarGym);
		add(btnGym);
		add(txtNomFiltro);
		
		txtNomFiltro.setVisible(false);
		
		
					
		DefaultTableModel model = new DefaultTableModel();
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
	
	void TablaConsultas(){
		
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
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) throws Exception {
		
		ConsultasGym programa = new ConsultasGym();
		int id;
		String nom= "";
		String ape = "";
		String email = "";
		String tlfn = "";
		String fecha = "";
		int idSubs;
		// Conectar el Driver JDBC
	      Class.forName("com.mysql.cj.jdbc.Driver");

	      // variables, cambiar según corresponda
	      final String url = "dbrds.c1cqmqwa0ite.us-east-1.rds.amazonaws.com";
	      final String user = "admin";
	      final String password = "ASdiioqw--ad45";

	      // establecer la conexión
	      Connection con = DriverManager.getConnection(url, user, password);

	      // mostrar mensaje de conexión exitosa o fallo
	      if (con == null) {
	         System.out.println("No se ha establecido la conexión");
	         return;
	      } else {
	         System.out.println("¡Felicidades! Se ha establecido la conexión");
	      } 
	     
	      Statement depState = con.createStatement();
	      ResultSet dep = depState.executeQuery("select * from Deportistas");
	      
	      while (dep.next()) {
	    	  int i = 0;
	    	  id = dep.getInt("idDeportista");
	    	  nom = dep.getString("NombreD");
	    	  ape = dep.getString("ApellidoD");
	    	  email = dep.getString("Email");
	    	  tlfn = dep.getString("Telefono");
	    	  fecha = dep.getString("FechaInicio");
	    	  idSubs = dep.getInt("idSubs");
	    	  model.addRow(new Object[]{roll, name, cl, sec});
	          i++;
	      }
	      
	      Statement depnState = con.createStatement();
	     // ResultSet depn = depnState.executeQuery("select * from Deportistas WHERE NombreD = " + NombreD);
	      Statement suscState = con.createStatement();
	      ResultSet susc = suscState.executeQuery("select * from Suscripciones");	      
	      Statement zonaState = con.createStatement();
	      ResultSet zona = zonaState.executeQuery("select * from ZonaDeporte");
	      // Cerrar la conexión JDBC
	      con.close();

	}

}