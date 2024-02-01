import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.EventListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

public class Ejercicio4 extends JFrame implements EventListener, ActionListener, WindowListener {

	JButton btn1;
	JLabel lblNum1;
	JLabel lblNum2;
	JLabel lblNum3;
	JLabel lblRes;
	Ejercicio4(){
		btn1 = new JButton("GENERAR");
		lblNum1 = new JLabel();
		lblNum2 = new JLabel();
		lblNum3 = new JLabel();
		lblRes = new JLabel();
		Border blackline = BorderFactory.createLineBorder(Color.black);
		add(btn1);
		add(lblNum1);
		add(lblNum2);
		add(lblNum3);
		add(lblRes);
		setTitle("Numeros aleatorios");
		Image imgLogo = Toolkit.getDefaultToolkit().getImage("E:\\imagenes\\ej3.png");
		setIconImage(imgLogo);
		setSize(300, 160);
		setVisible(true);
		setLayout(new FlowLayout());
		btn1.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		int rand1 = (int)Math.floor(Math.random() * 10);
		int rand2 = (int)Math.floor(Math.random() * 10);
		int rand3 = (int)Math.floor(Math.random() * 10);
		lblNum1.setText(String.valueOf(rand1));
		lblNum2.setText(String.valueOf(rand2));
		lblNum3.setText(String.valueOf(rand3));
		if (lblNum1.getText().equals(lblNum2.getText()) && lblNum1.getText().equals(lblNum3.getText())) {
			JOptionPane.showMessageDialog(this, "Los tres numeros son iguales");
		}
		else if (lblNum1.getText().equals(lblNum2.getText()) || lblNum1.getText().equals(lblNum3.getText()) || lblNum2.getText().equals(lblNum3.getText())){
			JOptionPane.showMessageDialog(this, "Dos Numeros son iguales");
		}
		else {
			JOptionPane.showMessageDialog(this, "Los 3 Numeros son diferentes");
		}
	}
	public static void main(String[] args) {
		Ejercicio4 aleatorio = new Ejercicio4();

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
