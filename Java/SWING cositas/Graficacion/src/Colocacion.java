import javax.swing.JButton;
import javax.swing.JFrame;

public class Colocacion extends JFrame {
	
	JButton b1;
	JButton b2;
	JButton b3;
	Colocacion(){
		
		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		
		b1.setLocation(0, 0);
		b1.setSize(getSize(), getSize()/3);
		b2.setLocation(0, 400/3);
		b2.setSize(getSize(), 400/3);
		b3.setLocation(0, (400*2/3));
		b3.setSize(getSize(), 400/3);
		
		setTitle("El montapuercos se desbloquea en la arena 5");
		setSize(800, 800);
		setVisible(true);
		setLayout(null);
		
		add(b1);
		add(b2);
		add(b3);
		
		
	}
	public static void main(String[] args) {
		Colocacion app = new Colocacion();
	}

}
