import javax.swing.JFrame;
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
	ConsultasRest(){
		setLayout(new FlowLayout());
		setVisible(true); 
		setSize(500, 300); 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		cboQueMostrarRest = new JComboBox();
		btnRest = new JButton();
		
		add(cboQueMostrarRest);
		add(btnRest);
		
		cboQueMostrarRest.addActionListener(this);
		btnRest.addActionListener(this);
		
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers();
		//DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames()); 
		//table = new JTable(model);
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
		ConsultasRest programa = new ConsultasRest();
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
	      Statement statement1 = con.createStatement();
	      ResultSet resultSet1 = statement1.executeQuery("select * from Comensales");
	      while (resultSet1.next()) {
	    	  
	          System.out.println(resultSet1.getInt(1) + " " + resultSet1.getString(2));	          
	      }
	      //Statement statement3 = con.createStatement();
	      //ResultSet resultSet3 = statement3.executeQuery("select * from Comensales WHERE NombreC = " + NombreC);
	      Statement statement5 = con.createStatement();
	      ResultSet resultSet5 = statement5.executeQuery("select * from Menu");
	      Statement statement7 = con.createStatement();
	      ResultSet resultSet7 = statement7.executeQuery("select * from ZonaRestauracion");
	      
	      
	      // Cerrar la conexión JDBC
	      con.close();

	}

}