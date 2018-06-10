package lab8Home;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class lab8h {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lab8h window = new lab8h();
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
	public lab8h() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1010, 520);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(12, 13, 785, 212);
		frame.getContentPane().add(textArea);
		
		JButton btnNewButton = new JButton("\u0412\u044B\u043F\u043E\u043B\u043D\u0438\u0442\u044C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str = " ";
				String end = " ";
				int l = 0;
				char[] arr1 = new char[] {'a', 'b','c','d','e','f','g','g','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','h'};
				try {
					Scanner sc = new Scanner(new File("D:\\Roma\\lab8.txt"));
					while (sc.hasNextLine()) {
						str = str + sc.nextLine() + "\n";
					}
					sc.close();
				} catch (FileNotFoundException el) {
					el.printStackTrace();
				}	
				end = "Оригинал: " + str + "\n";
				StringBuilder sb = new StringBuilder(str.length());				
	            for ( char c : str.toCharArray() ) {
	            	l = 0;
	            	for (int i = 0; i < 26; i++) {
		            	if (c == arr1[i]) {
		                	c = Character.toUpperCase(c);
		                	sb.append(c);
		                	l++;
		            	}		     
	            	}	
	            	if (l == 0) {
	                	sb.append(c);
	            	}	
	            }
				end = end + "Исправление: " + sb.toString();
				textArea.setText(end);
				
				 try(BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\Roma\\result8.txt")))
			        {
			          bw.write(end);
			        } catch(IOException ex){
			             
			            System.out.println(ex.getMessage());
			        } 
				 
			}
		});
		btnNewButton.setBounds(669, 238, 128, 38);
		frame.getContentPane().add(btnNewButton);
	}
}
