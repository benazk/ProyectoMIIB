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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
/*Sistema de validación de usuario y contraseña. Si se escribe “admin” y con contraseña “admin1234” 
 * se mostrará un diálogo diciendo “La contraseña es correcta”, en caso contrario 
 * el diálogo mostrará “La Contraseña no es correcta”.
*/
public class Ejercicio1 extends JFrame implements EventListener, WindowListener, ActionListener {
	JLabel lblUsuario;
	JTextField txtUsuario;
	JLabel lblContrasenna;
	JPasswordField pwdContrasenna;
	JButton btnValidar;
	JLabel lblConfirmacion;
	Ejercicio1(){
		
		lblUsuario = new JLabel("Pon aqui tu usuario:");
		txtUsuario = new JTextField();
		lblContrasenna = new JLabel("Pon aqui tu contraseña:");
		pwdContrasenna = new JPasswordField();
		btnValidar = new JButton("Validar");
		lblConfirmacion = new JLabel();
		btnValidar.setBackground(new java.awt.Color(241, 255, 200));
		add(lblUsuario);
		add(txtUsuario);
		add(lblContrasenna);
		add(pwdContrasenna);
		add(btnValidar);
		add(lblConfirmacion);
		lblConfirmacion.setLocation(10, 220);
		setTitle("Validacion de Contraseña");
		Image imgLogo = Toolkit.getDefaultToolkit().getImage("E:\\imagenes\\ej1.jpg");
		setIconImage(imgLogo);
		setSize(250, 250);
		setVisible(true);
		setLayout(new GridLayout(6, 1));
		btnValidar.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		String User = txtUsuario.getText();
		String Password = new String(pwdContrasenna.getPassword());
		if(User.equalsIgnoreCase("admin") && Password.equals("admin1234")) {
			lblConfirmacion.setText("Usuario y contraseña correctas");
		}
		else {
				lblConfirmacion.setText("Usuario y/o contraseña incorrectas");			
		}

	}
	//combo: getSelectedItem();
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
		Ejercicio1 User_Password = new Ejercicio1();

	}

}
