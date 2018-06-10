package lab9H;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JTextField;

public class lab9h {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lab9h window = new lab9h();
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
	public lab9h() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1134, 617);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(12, 13, 473, 170);
		frame.getContentPane().add(textArea);
		
		JTextArea textArea1 = new JTextArea();
		textArea1.setBounds(497, 95, 159, 24);
		frame.getContentPane().add(textArea1);
		
		JButton button = new JButton("\u0432\u044B\u043F\u043E\u043B\u043D\u0438\u0442\u044C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int chek = 0;
				String str = "";
				String pr = textArea1.getText();
				try {
					Scanner sc = new Scanner(new File("D:\\Roma\\lab9.txt"));
					while (sc.hasNextLine()) {
						str = str + sc.nextLine() + "\n";
					}
					sc.close();
				} catch (FileNotFoundException el) {
					el.printStackTrace();
				}
				
				textArea.setText(str);
				StringTokenizer st = new StringTokenizer(str, " \t\n\r,.");
				char[] prov = pr.toCharArray();
				int i = 0;
				int t = 0;
				while(st.hasMoreTokens()) {
		             char[] stArray = st.nextToken().toCharArray();
		             i = 0;
		             t = 0;
		             if (stArray.length >= pr.length()) { 
			             while(i < pr.length()) {
				             if (stArray[i] == prov[i]) {
				                    t++;
				             }
				             i++;
			            }
		            }    
		            if (t == pr.length()) {
		            	chek++;
		            }
		        } 
				String end = "<html><head> </head><body>  <p align =" + "center" +"><b>ЛАБОРАТОРНАЯ РАБОТА №9</b> <br> <i> Вариант A</i>  </p> <br> ";
				end = end + "Выполник студент группы:<i> ИВТВМбд-11</i> <b>Саликов Р.С</b> <br>";
				end = end + "Файл: <b>lab9.txt</b> <br>";
				end = end + "Начало слова: <b>" + pr + "</b> <br>";
				end = end + "Количество найденных слов: <b>" + chek + "</b> <br> </body></html>" ;
				try (BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\Roma\\result9h.html"))) {
			         bw.write(end);
			    } catch (IOException ex) {
			    	System.out.println(ex.getMessage());
			    }  
			}
		});
		button.setBounds(497, 13, 159, 45);
		frame.getContentPane().add(button);
		
		textField = new JTextField();
		textField.setForeground(Color.BLACK);
		textField.setBackground(Color.WHITE);
		textField.setText("\u0432\u044B\u0440\u0430\u0436\u0435\u043D\u0438\u0435 \u0434\u043B\u044F \u043F\u0440\u043E\u0432\u0435\u0440\u043A\u0438");
		textField.setBounds(497, 71, 179, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
	
	}
}
