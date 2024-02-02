import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
public class GestorNuevoGrid extends JFrame implements ActionListener, WindowListener {
	JButton tabla[] = new JButton [16];
	
	GestorNuevoGrid(){
		
		for (int i = 0; i < tabla.length; i++) {
			tabla[i] = new JButton(String.valueOf(i+1));
			add(tabla[i]);
			tabla[i].addActionListener(this);
		}
		
		setTitle("Hola");
		setSize(800, 800);
		setVisible(true);
		setLayout(new GridLayout(4,4));
		
	}
	public static void main(String[] args) {
		GestorNuevoGrid app = new GestorNuevoGrid();

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
		var num = e.getSource();
		for (int i = 0; i < tabla.length; i++) {
			if (e.getSource() == tabla[i]) {
				System.out.println("has clicado al boton " + (i + 1));
				tabla[i].setVisible(false);
			}
		}
		
		
	}

}
