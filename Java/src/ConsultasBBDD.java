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
/*
 * Esta es una clase que crea un JFrame, es una superclase cuyo objetivo es redirigir a las otras ventanas. Esta incluye el método constructor que crea un JFrame para mostrar una ventana de Swing,
 * además de tener el método ActionPerformed() y el método main, en el que se crea la ventana. 
 */


public class ConsultasBBDD extends JFrame implements ActionListener, WindowListener, EventListener{
	/*
	 * JComboBox cboEligeSector se usa para elegir entre sectores
	 * JButton btnSector se usa para confirmar la seleccion
	 * String sector[] es una array que contiene el nombre de las opciones del JComboBox
	 * ImageIcon imgLogo es la imagen que va en el Frame
	 * JLabel lblImagen es el contenedor que va a tener la imagen
	 */	
	JComboBox cboEligeSector;
	JButton btnSector;
	String sector[] = {" Elige el Sector"," Restauracion"," Gimnasio"};
	ImageIcon imgLogo;
	static JLabel lblImagen;
	
	/*
	 * Este es el método constructor, esta formado por un JComboBox que te deja elegir entre sector y un botón con el que confirmar la acción.
	 * Además, tiene el logo de MIIB Image imgIcon. Tiene un fondo azul, y un nombre de programa personalizado además de boton y combobox de color azul.
	 */
	ConsultasBBDD(){
		imgLogo = new ImageIcon("logo_miib.png"); // Crear los objetos previamente declarados
		lblImagen = new JLabel(imgLogo);
		cboEligeSector = new JComboBox(sector); 
		btnSector = new JButton("Elegir!");
		
		lblImagen.setSize(300, 300);  //Estilo de los objetos que estan en el Frame
		lblImagen.setLocation(200, 0);
		
		cboEligeSector.setSize(150, 35);
		cboEligeSector.setLocation(40, 140);
		cboEligeSector.setBackground(new Color(8, 170, 170));
		cboEligeSector.setBorder(null);
		
		btnSector.setSize(80, 35);
		btnSector.setLocation(50, 90);
		btnSector.setBackground(new Color(8, 170, 170));
		btnSector.setBorder(null);
		
		add(lblImagen);	// Añadir los objetos al Frame
		add(cboEligeSector);
		add(btnSector);
		
		cboEligeSector.addActionListener(this); // Añadir un action listener a los objetos
		btnSector.addActionListener(this);
		
		setLayout(null); // Personalizar el Frame
		setVisible(true); 
		setSize(500, 300); 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		Image imgIcon = Toolkit.getDefaultToolkit().getImage("MIIB.jpg");
		setIconImage(imgIcon);
		setTitle("Elige el Sector");
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
	 * En este metodo actionPerformed, se guarda el valor seleccionado de cboEligeSector y dependiendo de ese valor,
	 * te abre una clase o la otra. 
	 */
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
				return;
			}
		}
	}
	/**
	 * El metodo main crea el Frame en el que va a estar el contenido
	 */
	public static void main(String[] args) throws Exception {
		ConsultasBBDD programa = new ConsultasBBDD();
	}

}

