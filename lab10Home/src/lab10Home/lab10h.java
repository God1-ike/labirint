package lab10Home;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
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
		frame.setBounds(100, 100,600, 700); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.getContentPane().setLayout(null); 

		JTextArea textArea = new JTextArea(); 
		textArea.setEditable(false); 
		textArea.setBounds(10, 11, 314, 514); 
		frame.getContentPane().add(textArea); 

		JButton btnNewButton = new JButton("Scan+Sort"); 
		btnNewButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) { 
				String[] arr = start(); 
				textArea.setText(sort(arr)); 
			} 
		}); 
		btnNewButton.setBounds(336, 13, 215, 23); 
		frame.getContentPane().add(btnNewButton); 
		} 

		protected String sort(String[] arr) { 
			boolean changed = false; 
			do { 
				changed = false; 
				for(int i = 0; i < arr.length - 1; i++) { 
					if(arr[i].compareTo(arr[i + 1]) > 0) { 
						String s = arr[i]; 
						arr[i] = arr[i + 1]; 
						arr[i + 1] = s; 
						changed = true; 
					} 
				} 
			} while(changed); 



			String out = ""; 
			for(int i = 0; i < arr.length; i++) { 
				out += arr[i] + "\n"; 
			} 
			return out; 
		} 

		protected String[] start() { 
		try { 
			Scanner sc = new Scanner(new File("D:\\Roma\\Lab10.txt")); 
			String s = ""; 
			while(sc.hasNextLine()) { 
				s += sc.nextLine(); 
			} 
	
			StringTokenizer st = new StringTokenizer(s, " \t\n\r,."); 
			String[] arr = new String[st.countTokens()]; 
			int i = 0; 
			while(st.hasMoreTokens()) { 
				arr[i] = st.nextToken(); 
				i++; 
			} 
	
			sc.close(); 
			return arr; 
		} catch (FileNotFoundException e) { 
		// TODO Auto-generated catch block 
		e.printStackTrace(); 
		return null; 
		} 

		} 
}
