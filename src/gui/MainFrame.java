import javax.swing.JFrame;
import java.awt.BorderLayout;

public class MainFrame extends JFrame {
	
	private JButton btn;
	private JTextArea textArea;
	
	public MainFrame() {
		super("App Name");
		
		setLayout(new BorderLayout());
        
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
	}
}