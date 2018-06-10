import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;
import java.awt.event.ActionEvent;

public class lab10h {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lab10h window = new lab10h();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public lab10h() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 569);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(12, 13, 438, 458);
		frame.getContentPane().add(textArea);
		
		JButton button = new JButton("\u0412\u044B\u043F\u043E\u043B\u043D\u0438\u0442\u044C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str = textArea.getText();
				StringTokenizer st = new StringTokenizer(str, " \t\n\r,."); 
				String[] mass = new String[st.countTokens()]; 
				int quan = 0; 
				
				while(st.hasMoreTokens()) { 
					mass[quan] = st.nextToken(); 
					quan++; 
				} 
				
				for (int nomb = 0; nomb < quan; nomb++) {
					for(int i = 0; i < mass.length - 1; i++) { 
						if(mass[i].compareTo(mass[i + 1]) > 0) { 
							String s = mass[i]; 
							mass[i] = mass[i + 1]; 
							mass[i + 1] = s; 
						} 
					}
				}
				
				String end = str + "\n"; 
				for(int i = 0; i < mass.length; i++) { 
					end += mass[i] + "\n"; 
				} 
				
				textArea.setText(end);
			}
		});
		button.setBounds(462, 13, 165, 44);
		frame.getContentPane().add(button);
	}
}
