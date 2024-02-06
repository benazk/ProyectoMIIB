import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.EventListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class ConsultasBBDD extends JFrame implements ActionListener, WindowListener, EventListener{
	JComboBox cboEligeSector;
	JButton btnSector;
	String sector[] = {" Elige el Sector"," Restauracion"," Gimnasio"};
	ImageIcon imgLogo;
	JLabel lblImagen;
	ConsultasBBDD(){
		imgLogo = new ImageIcon("E:\\gatucos.png");
		lblImagen = new JLabel(imgLogo);
		Image imgIcon = Toolkit.getDefaultToolkit().getImage("C://Users/alu01/Documents/lobotomy.jpg");
		setIconImage(imgIcon);
		setTitle("qConsultas a la Base de Datos");
		Container c = getContentPane();

		c.setBackground(new java.awt.Color(120, 200, 200));
		cboEligeSector = new JComboBox(sector);
		btnSector = new JButton("Elegir!");
		
		lblImagen.setSize(300, 300);
		lblImagen.setLocation(100, 100);
		
		cboEligeSector.setSize(150, 35);
		cboEligeSector.setLocation(120, 50);
		cboEligeSector.setBackground(new Color(8, 170, 170));
		cboEligeSector.setBorder(null);
		
		btnSector.setSize(80, 35);
		btnSector.setLocation(290, 50);
		btnSector.setBackground(new Color(8, 170, 170));
		btnSector.setBorder(null);
		
		add(lblImagen);
		add(cboEligeSector);
		add(btnSector);
		
		cboEligeSector.addActionListener(this);
		btnSector.addActionListener(this);
		
		setLayout(null);
		setVisible(true); 
		setSize(500, 300); 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
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
			if(sector.equals(" Restauracion")) {
				new ConsultasRest();
			}
			else if(sector.equals(" Gimnasio")) {
				new ConsultasGym();
			}
			else if(sector.equals(" Elige el Sector")) {
				assert true;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		ConsultasBBDD programa = new ConsultasBBDD();
	}

}
