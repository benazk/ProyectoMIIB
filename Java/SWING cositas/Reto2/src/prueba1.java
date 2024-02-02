import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.EventListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class prueba1 extends JFrame implements EventListener, ActionListener, WindowListener {
	JTable tblResultado;
	String RestColumns[] = { "idComensal", "NombreC", "ApellidoC", "Email", "Telefono", "DiaYHora", "idMesa",
	"idMenu" };
	prueba1(){
		tblResultado = new JTable(null, RestColumns);
		tblResultado.setSize(400, 300);
		tblResultado.setLocation(20, 20);
		setVisible(true);
		setSize(800, 400);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
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
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		new prueba1();

	}

}
