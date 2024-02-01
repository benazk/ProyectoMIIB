import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SaludosSwing extends JFrame implements ActionListener, WindowListener {

	JTextField txtNombre; //declara el objeto
	JLabel lblSaludo;
	JButton btnSaludar;
	
	SaludosSwing(){
		txtNombre = new JTextField(""); //Crea el objeto
		lblSaludo = new JLabel("");
		btnSaludar = new JButton("Saludar");
		add(txtNombre); //Añade el objeto a la app (add(objeto))
		txtNombre.setColumns(20); //darle una anchura al textfield
		add(btnSaludar);
		add(lblSaludo);
		setTitle("Hey muy buenas a todos guapisimos"); //Setea el titulo del programa
		setVisible(true); //Setea que todo sea visible
		setSize(300, 100); //Setea el tamaño del programa
		setDefaultCloseOperation(EXIT_ON_CLOSE); //Setea para que el programa se pueda cerrar
		setLayout(new FlowLayout()); //Setea una layout para ordenarlo todo
		btnSaludar.addActionListener(this); //Hace que el boton tenga una funcion para que este haga algo
 	
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
	public void actionPerformed(ActionEvent e) { //Al pulsar el boton, se ejecuta esta funcion 
		String saludo = lblSaludo.getText(); //Extrae el texto de el textfield
		lblSaludo.setText("Hola, " + txtNombre.getText()); //Le pone un texto al label Saludo
	}

	public static void main(String[] args) {
		SaludosSwing app = new SaludosSwing();

	}

}
