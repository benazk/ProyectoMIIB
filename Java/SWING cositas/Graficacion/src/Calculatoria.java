import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.EventListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Calculatoria extends JFrame implements EventListener, WindowListener, ActionListener {
	JTextField txtNum1;
	JTextField txtNum2;
	JButton btnSumar;
	JLabel lblRes;
	
	Calculatoria(){
		txtNum1 = new JTextField();
		txtNum2 = new JTextField();
		btnSumar = new JButton("+");
		lblRes = new JLabel();
		add(txtNum1);
		txtNum1.setColumns(2);
		add(btnSumar);
		btnSumar.setSize(50, 50);
		add(txtNum2);
		txtNum2.setColumns(2);
		add(lblRes);
		setTitle("Hey muy buenas a todos guapisimos"); 
		Image imgIcon = Toolkit.getDefaultToolkit().getImage("C://Users/alu01/Documents/lobotomy.jpg");
		setIconImage(imgIcon);
		setVisible(true); 
		setSize(300, 100); 
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setLayout(new FlowLayout()); 
		btnSumar.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		int num1 = Integer.parseInt(txtNum1.getText());
		int num2 = Integer.parseInt(txtNum2.getText());
		int res = num1 + num2;
		lblRes.setText(String.valueOf(res));
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
		Calculatoria app = new Calculatoria();

	}

}
