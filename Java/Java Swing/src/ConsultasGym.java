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

	/**
	 * Esta es una clase que crea un JFrame, cuyo objetivo es mostrar una tabla con datos de sector de deportes. Esta clase incluye el método constructor que crea un JFrame para mostrar una ventana de Swing,
	 * además de tener el método ActionPerformed() y el método main, en el que se crea la ventana. 
	 */

public class ConsultasGym extends JFrame implements ActionListener, WindowListener, EventListener {
	/**
	 * JComboBox cboQueMostrarGym se usa para elegir de que tabla sacar los datos
	 * JButton btnGym confirma la selección
	 * JTextField txtFiltro es un TextField oculto solo mostrado si se elige una opcion especifica
	 * JButton btnFiltro confirma la seleccion filtrada
	 * JTable tblResultado es la tabla que muestra los datos
	 * String GymOptions[] Es un array que contiene los textos de las opciones que va a tener el JComboBox 
	 */
	JComboBox cboQueMostrarGym;
	JButton btnGym;
	JTextField txtFiltro;
	JTable tblResultado;
	JButton btnFiltro;
	String GymOptions[] = { "   Elige lo que se va a mostrar", "   Mostrar todos los Deportistas",
			"   Filtrar por nombre", "   Mostrar todas las Suscripciones", "   Mostrar todos los Zonas" };
	
	JScrollPane scroll;
	
	static DefaultTableModel model = new DefaultTableModel();
	
	/**
	 * Este es el método constructor, aqui es donde se crea e incluye todo dentro de el Frame. esta formado por un JComboBox que te deja elegir entre lo que extraer de la base de datos,
	 * además de un JTextBox para filtrar los registros por nombre y una JTable para mostrar los datos en la ventana
	 */
	ConsultasGym() {
		

		cboQueMostrarGym = new JComboBox(GymOptions); // Crear los objetos previamente declarados
		btnGym = new JButton("Mostrar Tabla"); 
		txtFiltro = new JTextField(); 
		btnFiltro = new JButton("Filtrar Tabla"); 

		txtFiltro.setColumns(8);	//Estilo de los objetos que estan en el Frame
		cboQueMostrarGym.setSize(210, 40);
		cboQueMostrarGym.setLocation(255, 50);
		cboQueMostrarGym.setBackground(new Color(8, 170, 170));
		cboQueMostrarGym.setBorder(null);
		btnGym.setSize(100, 40);
		btnGym.setLocation(420, 100);
		btnGym.setBackground(new Color(120, 190, 190));
		btnGym.setBorder(null);
		txtFiltro.setSize(210, 40);
		txtFiltro.setLocation(200, 100);

		add(cboQueMostrarGym); // Añadir los objetos al Frame
		add(btnGym);
		add(txtFiltro);

		btnGym.setVisible(false); // Ocultar btnGym y txtFiltro
		txtFiltro.setVisible(false);
		cboQueMostrarGym.addActionListener(this);
		btnGym.addActionListener(this);	// Añadir un action listener a los objetos
		txtFiltro.addActionListener(this);

		tblResultado = new JTable(model);	// Crear una JTable y asignarle un modelo
		tblResultado.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tblResultado.setFillsViewportHeight(true); 
		tblResultado.setSize(800,2000);	//Cambiar tamaño y posicion de la tabla
		tblResultado.setLocation(0, 150);
		
		scroll = new JScrollPane(tblResultado);	//Crear una JScrollBar para la tabla
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setSize(700, 400); 
		scroll.setLocation(0, 150);
		
		add(tblResultado); //Añadir tblResultado y scroll al Frame
		add(scroll);
		
		tblResultado.setVisible(false);

		setVisible(true);	// Personalizar el Frame
		setSize(800, 600);
		setLayout(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		Image imgIcon = Toolkit.getDefaultToolkit().getImage("MIIB.jpg");
		setIconImage(imgIcon);
		setTitle("Consultas al Gimnasio");
		Container c = getContentPane();
		c.setBackground(new java.awt.Color(120, 200, 200));
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
	
	/**
	 * En este metodo actionPerformed, se guarda el valor seleccionado de cboEligeSector y dependiendo de ese valor, se ejecuta una condicion u otra.
	 * Aqui se crea la conexión a la base de datos dentro de un bloque try/catch y se dibuja la tabla con sus datos de la base de datos 
	 */

	public void actionPerformed(ActionEvent e) {
		String item = (String) cboQueMostrarGym.getSelectedItem();
		System.out.println(item);
		Connection con = null;
		try {
			DefaultTableModel LimpiarTabla = (DefaultTableModel)tblResultado.getModel(); 
			while(LimpiarTabla.getRowCount() > 0)
			{
				LimpiarTabla.removeRow(0);	// Cada vez que elijas una opcion, se limpiará la tabla de los anteriores datos y dejará paso a la nueva tabla
			}
			Class.forName("com.mysql.cj.jdbc.Driver");	// Se importa el driver
			final String url = "jdbc:mysql://dbrds.c1cqmqwa0ite.us-east-1.rds.amazonaws.com:3306/BBDDProyectoGym1";
			final String user = "admin";		// Credenciales del servidor de bases de datos
			final String password = "ASdiioqw--ad45";
			con = DriverManager.getConnection(url, user, password);	// Variable que crea la conexion

			if (con == null) {	//Comprueba la conexion
				System.out.println("No se ha establecido la conexión");
				return;
			} else {
				System.out.println("¡Felicidades! Se ha establecido la conexión");
			}
			if ("   Mostrar todos los Deportistas".equals(item)) {	//Dependiendo de que elijas, se te mostrara una tabla u otra
				System.out.println(1);								//En este caso, mostrara todos los deportistas
				model.setColumnIdentifiers(new Object[] {"idDeportista", "NombreD", "ApellidoD", "Email", "Telefono", "FechaInicio", "idSubs"}); // Posiciona la cabezera con el nombre de la columna
				Statement depState = con.createStatement();	// Crea y ejecuta la query en la base de datos
				ResultSet dep = depState.executeQuery("SELECT * FROM Deportistas");
				while (dep.next()) {

					int id = 0;	// Variables para guardar los datos de la tabla
					String nombreD = "";
					String apellidoD = "";
					String email = "";
					String telefono = "";
					String FechaInicio = "";
					int idSubs = 0;
					id = dep.getInt(1);	// Le asigna a la variable el valor que le corresponde de la base de datos
					nombreD = dep.getString(2);
					apellidoD = dep.getString(3);
					email = dep.getString(4);
					telefono = dep.getString(5);
					FechaInicio = dep.getString(6);
					idSubs = dep.getInt(7);
					model.addRow(new Object[] { id, nombreD, apellidoD, email, telefono, FechaInicio, idSubs }); // Dibuja la tabla en el Frame
				}

			} else if ("   Filtrar por nombre".equals(item)) {	//En este caso, mostrara todos los deportistas, filtrado por nombre
				txtFiltro.setVisible(true);
				btnGym.setVisible(true);
				if (e.getSource() == btnGym) {

					String Filtro = txtFiltro.getText();
					model.setColumnIdentifiers(new Object[] {"idDeportista", "NombreD", "ApellidoD", "Email", "Telefono", "FechaInicio", "idSubs"});
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
			} else if ("   Mostrar todas las suscripciones".equals(item)) {	//En este caso, mostrara todas las suscripciones
				model.setColumnIdentifiers(new Object[] {"idSubs", "PrecioSubs", "TipoSubs"});

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

			} else if ("   Mostrar todas las zonas".equals(item)) {	//En este caso, mostrara todas las zonas de deporte
				model.setColumnIdentifiers(new Object[] {"idZona", "NumTarjeta", "Zona"});
				Statement zonaState = con.createStatement();
				ResultSet zona = zonaState.executeQuery("select * from ZonaDeporte");

				while (zona.next()) {
					int idZona = 0;
					int NumTarjeta;
					String Zona = "";
					idZona = zona.getInt(1);
					NumTarjeta = zona.getInt(2);
					Zona = zona.getString(3);
					model.addRow(new Object[] { idZona, NumTarjeta, Zona });
				}

				
			}
			tblResultado.setVisible(true);
		} catch (

		Exception o) {
			o.printStackTrace();
		} finally { //Este finally (que cierra la conexion a la base de datos) solo se ejecutara cuando hayas cerrado el programa
			try {
				con.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		tblResultado.updateUI();
		
	}
	/**
	 * El metodo main crea el Frame en el que va a estar el contenido
	 * @param args
	 * @throws Exception
	 */

	public static void main(String[] args) throws Exception {
		new ConsultasGym();

	}
}
