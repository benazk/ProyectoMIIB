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
	String sector[] = {"","Restauracion","Gimnasio"};
	ConsultasBBDD(){
		
		setLayout(new FlowLayout());
		setVisible(true); 
		setSize(500, 300); 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		cboEligeSector = new JComboBox(sector);
		btnSector = new JButton("Elegir!");
		
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
		var sector = cboEligeSector.getSelectedItem();
		if (e.getSource() == btnSector) {
			if(sector == "Restauracion") {
				new ConsultasRest();
			}
			else {
				new ConsultasGym();
			}
		}
	}

	public static void main(String[] args) throws Exception {
		ConsultasBBDD programa = new ConsultasBBDD();
	}

}
