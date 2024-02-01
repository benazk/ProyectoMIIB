import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.EventListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ejercicio3 extends JFrame implements ActionListener, EventListener, WindowListener {
	JComboBox cboProvincia;
	JComboBox cboLocalidad;
	JOptionPane opDialogo;
	String Provincias[] = {"Elige provincia", "Gipuzkoa", "Araba", "Bizkaia"};
	String LocalidadesG[] = {"Donosti", "Zarautz", "Andoain"};
	String LocalidadesA[] = {"Berberana", "Villanañe", "Lantarron"};
	String LocalidadesB[] = {"Bilbao", "Mutriku", "Amurrio"};
	Ejercicio3(){
		cboProvincia = new JComboBox(Provincias);
		cboLocalidad = new JComboBox();
		add(cboProvincia);
		add(cboLocalidad);
		setTitle("Lista de Localidades");
		setSize(400, 200);
		setVisible(true);
		cboLocalidad.setVisible(false);
		setLayout(new FlowLayout());
		cboProvincia.addActionListener(this);
	}
	public void windowOpened(WindowEvent e) {
		

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
		String combo = (String) cboProvincia.getSelectedItem();
		if(combo.equalsIgnoreCase("gipuzkoa")) {
			
			cboLocalidad.setItems();
			}
	}

	public static void main(String[] args) {
		Ejercicio3 localidades = new Ejercicio3();

	}

}
