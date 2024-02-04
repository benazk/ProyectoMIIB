import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.util.EventListener;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GridRandom extends JFrame implements EventListener, WindowListener, ActionListener {
	JButton tabla[] = new JButton [9];
	GridRandom() {
		for (int i = 0; i < tabla.length; i++) {
			int ran = (int)Math.floor(Math.random()* 99);
			tabla[i] = new JButton(String.valueOf(ran));
			add(tabla[i]);
			tabla[i].addActionListener(this);
		}
		
		setTitle("Hola");
		setSize(800, 800);
		setVisible(true);
		setLayout(new GridLayout(3,3));
	}
	
	public void actionPerformed(ActionEvent e) {
		
			
		for (int i = 0; i < tabla.length; i++) {
			int a = Integer.parseInt(tabla[i].getText()) + 1;
			if (e.getSource() == tabla[i]) {
				tabla[i].setText(String.valueOf(a));
			}
		}
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

	public static void main(String[] args) {
		GridRandom app = new GridRandom(); 

	}

}
