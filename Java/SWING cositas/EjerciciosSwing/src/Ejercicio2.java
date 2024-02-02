import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.EventListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
/*Un cuadro desplegable (combo) que muestre 3 opciones 
 * (por ejemplo: gato, perro y caballo), y, al seleccionar, se mostrará una imagen relacionada. */
public class Ejercicio2 extends JFrame implements EventListener, WindowListener, ActionListener {
	ImageIcon imgGato;
	ImageIcon imgPerro;
	ImageIcon imgCaballo;
	JComboBox cboAnimales;
	JLabel lblImagen;
	String Animales[] = {"elige animal", "gato", "perro", "caballo"};
	Ejercicio2(){
		cboAnimales = new JComboBox(Animales);
		lblImagen = new JLabel();
		imgGato = new ImageIcon("E:\\imagenes\\gato.jpg");
		imgPerro = new ImageIcon("E:\\imagenes\\perro.jpg");
		imgCaballo = new ImageIcon("E:\\imagenes\\caballo.jpg");
		
		add(cboAnimales);
		add(lblImagen);
		
		setTitle("Lista de animales");
		Image imgLogo = Toolkit.getDefaultToolkit().getImage("E:\\imagenes\\ej2.jpg");
		setIconImage(imgLogo);
		setSize(720, 420);
		setVisible(true);
		setLayout(new FlowLayout());
		cboAnimales.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String combo = (String) cboAnimales.getSelectedItem();
		if(combo.equals("gato")) {
			lblImagen.setIcon(imgGato);
		}
		else if(combo.equals("perro")) {
			lblImagen.setIcon(imgPerro);
		}
		else if(combo.equals("caballo")) {
			lblImagen.setIcon(imgCaballo);
		}
	}
	public static void main(String[] args) {
		Ejercicio2 Animales = new Ejercicio2();

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

}
