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

/**
 * Esta es una clase que crea un JFrame, cuyo objetivo es mostrar una tabla con
 * datos de sector de restauracion. Esta clase incluye el método constructor que
 * crea un JFrame para mostrar una ventana de Swing, además de tener el método
 * ActionPerformed() y el método main, en el que se crea la ventana.
 */
public class ConsultasRest extends JFrame implements ActionListener, WindowListener, EventListener {
	/**
	 * JComboBox cboQueMostrarRest se usa para elegir de que tabla sacar los datos
	 * JButton btnRest confirma la selección
	 * JTextField txtFiltro es un TextField oculto solo mostrado si se elige una opcion especifica
	 * JButton btnFiltro confirma la seleccion filtrada
	 * JTable tblResultado es la tabla que muestra los datos
	 * String RestOptions[] Es un array que contiene los textos de las opciones que va a tener el JComboBox 
	 */
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

		cboQueMostrarRest = new JComboBox(RestOptions); // Crear los objetos previamente declarados
		btnRest = new JButton("Mostrar Tabla");
		txtFiltro = new JTextField();
		btnFiltro = new JButton("Filtrar Tabla");

		txtFiltro.setColumns(8); // Estilo de los objetos que estan en el Frame
		cboQueMostrarRest.setSize(210, 40);
		cboQueMostrarRest.setLocation(255, 50);
		cboQueMostrarRest.setBackground(new Color(8, 170, 170));
		cboQueMostrarRest.setBorder(null);
		btnRest.setSize(100, 40);
		btnRest.setLocation(420, 100);
		btnRest.setBackground(new Color(120, 190, 190));
		btnRest.setBorder(null);
		txtFiltro.setSize(210, 40);
		txtFiltro.setLocation(200, 100);

		add(cboQueMostrarRest); // Añadir los objetos al Frame
		add(btnRest);
		add(txtFiltro);

		btnRest.setVisible(false); // Ocultar btnRest y txtFiltro
		txtFiltro.setVisible(false);
		cboQueMostrarRest.addActionListener(this);
		btnRest.addActionListener(this); // Añadir un action listener a los objetos
		txtFiltro.addActionListener(this);

		tblResultado = new JTable(); // Crear una JTable y asignarle un modelo
		tblResultado.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tblResultado.setFillsViewportHeight(true);
		tblResultado.setSize(800, 2000); // Cambiar tamaño y posicion de la tabla
		tblResultado.setLocation(0, 150);

		scroll = new JScrollPane(tblResultado); // Crear una JScrollBar para la tabla
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setSize(700, 400);
		scroll.setLocation(0, 150);

		add(tblResultado); // Añadir tblResultado y scroll al Frame
		add(scroll);
		tblResultado.setVisible(false);

		setVisible(true); // Personalizar el Frame
		setSize(800, 600);
		setLayout(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		Image imgIcon = Toolkit.getDefaultToolkit().getImage("MIIB.jpg");
		setIconImage(imgIcon);
		setTitle("Consultas al Restaurante");
		Container c = getContentPane();
		c.setBackground(new java.awt.Color(120, 200, 200));
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

	/**
	 * En este metodo actionPerformed, se guarda el valor seleccionado de
	 * cboEligeSector y dependiendo de ese valor, se ejecuta una condicion u otra.
	 * Aqui se crea la conexión a la base de datos dentro de un bloque try/catch y
	 * se dibuja la tabla con sus datos de la base de datos
	 */
	public void actionPerformed(ActionEvent e) {
		String item = (String) cboQueMostrarRest.getSelectedItem();
		Connection conRest = null;
		try {
			DefaultTableModel LimpiarTabla = (DefaultTableModel) tblResultado.getModel();
			while (LimpiarTabla.getRowCount() > 0) {
				LimpiarTabla.removeRow(0); // Cada vez que elijas una opcion, se limpiará la tabla de los anteriores
											// datos y dejará paso a la nueva tabla
			}
			Class.forName("com.mysql.cj.jdbc.Driver"); // Se importa el driver
			final String url = "jdbc:mysql://dbrds.c1cqmqwa0ite.us-east-1.rds.amazonaws.com:3306/BBDDProyectoGym1";
			final String user = "admin"; // Credenciales del servidor de bases de datos
			final String password = "ASdiioqw--ad45";
			conRest = DriverManager.getConnection(url, user, password); // Variable que crea la conexion

			if (conRest == null) { // Comprueba la conexion
				System.out.println("No se ha establecido la conexión");
				return;
			} else {
				System.out.println("¡Felicidades! Se ha establecido la conexión");

			}

			if ("   Mostrar todos los Comensales".equals(item)) { // Dependiendo de que elijas, se te mostrara una tabla
																	// u otra
				System.out.println(1); // En este caso, mostrara todos los comensales
				System.out.println(1);
				model.setColumnIdentifiers(new Object[] { "idComensal", "NombreC", "ApellidoC", "Email", "Telefono",
						"DiaYHora", "idMesa", "idMenu" });
				tblResultado.setModel(model);
				Statement comState = conRest.createStatement(); // Crea y ejecuta la query en la base de datos
				ResultSet com = comState.executeQuery("SELECT * FROM Comensales");
				while (com.next()) {
					int id = 0;
					String nombreC = "";
					String apellidoC = "";
					String email = "";
					String telefono = "";
					String DiaYHora = "";
					int idMesa = 0;
					int idMenu = 0;
					id = com.getInt(1); // Le asigna a la variable el valor que le corresponde de la base de datos
					nombreC = com.getString(2);
					apellidoC = com.getString(3);
					email = com.getString(4);
					telefono = com.getString(5);
					DiaYHora = com.getString(6);
					idMesa = com.getInt(7);
					idMenu = com.getInt(8);

					model.addRow(new Object[] { id, nombreC, apellidoC, email, telefono, DiaYHora, idMesa, idMenu }); // Dibuja
																														

				}

			}

			else if ("   Filtrar por nombre".equals(item)) {	//En este caso, mostrara todos los comensales, filtrado por nombre
				txtFiltro.setVisible(true);
				btnRest.setVisible(true);
				if (e.getSource() == btnRest) {

					String NombreC = txtFiltro.getText();
					model.setColumnIdentifiers(new Object[] { "idComensal", "NombreC", "ApellidoC", "Email", "Telefono",
							"DiaYHora", "idMesa", "idMenu" });
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

				}
			} else if ("   Mostrar todas las mesas".equals(item)) { // En este caso mostrará todas las mesas

				model.setColumnIdentifiers(new Object[] { "idMesa", "MesaNum" });
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

			} else if ("   Mostrar todos los menus".equals(item)) { // En este caso mostrará todos los menús

				model.setColumnIdentifiers(new Object[] { "idMenu", "ObjetoMenu", "Precio" });
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
			tblResultado.setVisible(true);

		} catch (

		Exception o) {
			o.printStackTrace();
		}

		finally {	//Este finally (que cierra la conexion a la base de datos) solo se ejecutara cuando hayas cerrado el programa
			try {
				conRest.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

	}
	/**
	 * El metodo main crea el Frame en el que va a estar el contenido
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		new ConsultasRest();

	}
}
