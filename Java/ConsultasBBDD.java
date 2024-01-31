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

public class ConsultasBBDD  implements ActionListener, WindowListener, EventListener{
	JComboBox cboEligeSector;
	JComboBox cboQueMostrarGym;
	JComboBox cboQueMostrarRest;
	JButton btnSector;
	JButton btnGym;
	JButton btnRest;
	ConsultasBBDD(){
		setLayout(new FlowLayout());
		setVisible(true); 
		setSize(300, 100); 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		cboEligeSector = new JComboBox();
		cboQueMostrarGym = new JComboBox();
		cboQueMostrarRest = new JComboBox();
		btnSector = new JButton();
		btnGym = new JButton();
		btnRest = new JButton();
		
		add(cboEligeSector);
		add(cboQueMostrarGym);
		add(cboQueMostrarRest);
		add(btnSector);
		add(btnGym);
		add(btnRest);
		
		
		cboEligeSector.addActionListener(this);
		cboQueMostrarGym.addActionListener(this);
		cboQueMostrarRest.addActionListener(this);
		btnSector.addActionListener(this);
		btnGym.addActionListener(this);
		btnRest.addActionListener(this);
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
		ConsultasBBDD programa = new ConsultasBBDD();
		// Conectar el Driver JDBC
	      Class.forName("com.mysql.cj.jdbc.Driver");

	      // variables, cambiar según corresponda
	      final String url = "jdbc:mysql://localhost:3306/demo";
	      final String user = "root";
	      final String password = "";

	      // establecer la conexión
	      Connection con = DriverManager.getConnection(url, user, password);

	      // mostrar mensaje de conexión exitosa o fallo
	      if (con == null) {
	         System.out.println("No se ha establecido la conexión");
	         return;
	      } else {
	         System.out.println("¡Felicidades! Se ha establecido la conexión");
	      } 
	      Statement statement1 = con.createStatement();
	      ResultSet resultSet1 = statement1.executeQuery("select * from Comensales");
	      Statement statement2 = con.createStatement();
	      ResultSet resultSet2 = statement2.executeQuery("select * from Deportistas");
	      Statement statement3 = con.createStatement();
	      ResultSet resultSet3 = statement3.executeQuery("select * from Comensales WHERE NombreC = " + NombreC);
	      Statement statement4 = con.createStatement();
	      ResultSet resultSet4 = statement4.executeQuery("select * from Deportistas WHERE NombreD = " + NombreD);
	      Statement statement5 = con.createStatement();
	      ResultSet resultSet5 = statement5.executeQuery("select * from Menu");
	      Statement statement6 = con.createStatement();
	      ResultSet resultSet6 = statement6.executeQuery("select * from Suscripciones");
	      Statement statement7 = con.createStatement();
	      ResultSet resultSet7 = statement7.executeQuery("select * from ZonaRestauracion");
	      Statement statement8 = con.createStatement();
	      ResultSet resultSet8 = statement8.executeQuery("select * from ZonaDeporte");
	      // Cerrar la conexión JDBC
	      con.close();

	}

}
