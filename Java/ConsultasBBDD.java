import javax.swing.JFrame;
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

public class ConsultasBBDD extends JFrame implements ActionListener, WindowListener, EventListener{
	JComboBox cboEligeSector;
	JButton btnSector;
	ConsultasBBDD(){
		
		setLayout(new FlowLayout());
		setVisible(true); 
		setSize(300, 100); 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		cboEligeSector = new JComboBox();
		btnSector = new JButton();
		
		add(cboEligeSector);
		add(btnSector);
		
		cboEligeSector.addActionListener(this);
		btnSector.addActionListener(this);
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
	      // Cerrar la conexión JDBC
	      con.close();

	}

}
