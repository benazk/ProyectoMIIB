import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DemoSwing extends JFrame implements ActionListener, WindowListener {

	JButton btnMenos;
	JButton btnMas;
	JLabel lblNum;
	
	DemoSwing(){
		btnMenos = new JButton("-");
		btnMas = new JButton("+");
		lblNum = new JLabel("0");
		
		add(btnMenos);
		add(lblNum);
		add(btnMas);
		setTitle("Fire in da hole");
		setSize(320, 100);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		btnMas.addActionListener(this);
		btnMenos.addActionListener(this);
		
		addWindowListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		int num = Integer.parseInt(lblNum.getText());
		if (e.getSource() == btnMas) {
			num++;
			lblNum.setText(String.valueOf(num));
		}
		else if (e.getSource() == btnMenos) {
			num--;
			lblNum.setText(String.valueOf(num));
		} 

	}

	public static void main(String[] args) {
		DemoSwing aplicacion = new DemoSwing();

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
