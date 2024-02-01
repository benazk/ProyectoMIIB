import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.EventListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Popurri extends JFrame implements ActionListener, EventListener, WindowListener {
	JPasswordField pswContrasena;
	JButton btnBoton1;
	JLabel lblMostrar;
	JCheckBox chbRojo, chbVerde, chbAzul;
	JRadioButton rdbSennor, rdbSennora, rdbPendejo;
	ButtonGroup bg;
	JComboBox cboPaises;
	JList lstPaises;
	JTable tblTabla;
	JScrollPane Scrollpane;
	JLabel lblImagen;
	ImageIcon imgGatos;
	String Paises[] = {"España", "Francia", "Taiwan", "China", "Perú"};
	String dos[][] = {
			{"1", "Juanjo", "Albacete"},
			{"2", "Zacarias", "Manchester"},
			{"3", "Peter", "Quahog"},
			{"4", "Sponge Bob", "Bikini Bottom"}
	};
	String columnas[] = {"Id", "Nombre", "Lugar"};
	Popurri(){ 
		Image imgIcon = Toolkit.getDefaultToolkit().getImage("C://Users/alu01/Documents/lobotomy.jpg");
		setIconImage(imgIcon);
		setTitle("fire in the hole");
		setSize(700, 700);
		setVisible(true);
		setLayout(new FlowLayout());
		Container c = getContentPane();

		c.setBackground(new java.awt.Color(241, 255, 200));
		pswContrasena = new JPasswordField("Tuvieron un gran impacto");
		JOptionPane.showMessageDialog(this, "Hola mundo");
		btnBoton1 = new JButton("Mostrar");
		lblMostrar = new JLabel();
		chbRojo = new JCheckBox();
		chbVerde = new JCheckBox();
		chbAzul = new JCheckBox();
		rdbSennor = new JRadioButton();
		rdbSennora = new JRadioButton();
		rdbPendejo = new JRadioButton();
		lstPaises = new JList(Paises);
		tblTabla = new JTable(dos, columnas);
		cboPaises = new JComboBox(Paises);
		Scrollpane = new JScrollPane(tblTabla);
		bg = new ButtonGroup();
		imgGatos = new ImageIcon("e:\\imagenes\\gatucos.png");
		lblImagen = new JLabel(imgGatos);
		JScrollBar s=new JScrollBar();  
		s.setBounds(100,100, 50,100);  
		add(s);  
		lblImagen.setSize(20, 20);
		
		add(pswContrasena);
		add(btnBoton1);
		add(lblMostrar);
		add(chbRojo);
		add(chbVerde);
		add(chbAzul);
		add(rdbSennor);
		add(rdbSennora);
		add(rdbPendejo);
		add(cboPaises);
		add(lstPaises);
		add(Scrollpane);
		
		bg.add(rdbSennor);
		bg.add(rdbSennora);
		bg.add(rdbPendejo);
		
		btnBoton1.addActionListener(this);
		add(lblImagen);
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
		String valor = new String(pswContrasena.getPassword());
		lblMostrar.setText("La contraseña es: " +  valor);

	}

	public static void main(String[] args) {
		Popurri app = new Popurri();

	}

}
