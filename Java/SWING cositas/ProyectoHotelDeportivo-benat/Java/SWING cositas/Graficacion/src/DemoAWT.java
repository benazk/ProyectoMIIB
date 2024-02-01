import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.*;    
import java.awt.event.WindowEvent;    
import java.awt.event.WindowListener;

import javax.swing.ImageIcon; 

public class DemoAWT extends Frame implements ActionListener,WindowListener {
	Image img1;
	Label lblEdad, lblResultado;
	TextField txtEdad;
	Button btnComprobar;
	
	public static void main(String[] args) {
		DemoAWT aplicacion = new DemoAWT();
	}
	
	DemoAWT(){
		super("Image Frame");
		MediaTracker mt = new MediaTracker(this);
		lblEdad = new Label("Edad");
		txtEdad = new TextField("");
		btnComprobar = new Button("Comprobar");
		lblResultado = new Label("Aqui aparecera el resultado");
		add(lblEdad);
		add(txtEdad);
		add(btnComprobar);
		add(lblResultado);
		
		setTitle("Fire in da hole");
		Image imgIcon = Toolkit.getDefaultToolkit().getImage("C://Users/alu01/Documents/lobotomy.jpg");
		Image img1 = Toolkit.getDefaultToolkit().getImage("C://Users/alu01/Documents/lobotomy1.jpg");
		setIconImage(imgIcon);
		mt.addImage(img1, 1);
		
		setSize(450, 310);
		setVisible(true);
		setLayout(new FlowLayout());
		
		 
		btnComprobar.addActionListener(this);
		
		addWindowListener(this);
   
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		int edad = Integer.valueOf(txtEdad.getText());
		if(edad >= 18) {
			lblResultado.setText("sad spongebob sound");
		}
		else {
			lblResultado.setText("tienes 14? activa cam");
		}
		
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		dispose();
		
	}
	public void update(Graphics g){
		paint(g);
		}
		  
	public void paint(Graphics g){
		if(img1 != null)
		g.drawImage(img1, 100, 100, this);
		else
		g.clearRect(0, 0, getSize().width, getSize().height);
	}
	@Override
	public void windowOpened(WindowEvent e) {
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
	


