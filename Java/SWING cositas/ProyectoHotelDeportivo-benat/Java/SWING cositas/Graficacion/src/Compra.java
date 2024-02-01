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

public class Compra extends JFrame implements EventListener, ActionListener, WindowListener {
	JTextField txtPrecio;
	JTextField txtCant;
	JTextField txtDesc;
	JButton btnCalcular;
	JLabel lblRes;
	Compra(){
		txtPrecio = new JTextField("Precio");
		txtCant = new JTextField("Cantidad");
		txtDesc = new JTextField("Descuento");
		btnCalcular = new JButton("Calcular");
		lblRes = new JLabel();
		add(txtPrecio);
		add(txtCant);
		add(txtDesc);
		add(btnCalcular);
		add(lblRes);
		setTitle("Albion online es un MMORPG no lineal");
		Image imgIcon = Toolkit.getDefaultToolkit().getImage("C://Users/alu01/Documents/lobotomy.jpg");
		setIconImage(imgIcon);
		setVisible(true); 
		setSize(500, 300); 
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setLayout(new FlowLayout());
		btnCalcular.addActionListener(this);
		
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
		int pre = Integer.parseInt(txtPrecio.getText());
		double des = Double.parseDouble(txtDesc.getText());
		int cant = Integer.parseInt(txtCant.getText());
		double res = (pre * cant) - ((pre * cant) * des);
		lblRes.setText(String.valueOf(res));

	}

	public static void main(String[] args) {
		Compra app = new Compra();

	}

}
