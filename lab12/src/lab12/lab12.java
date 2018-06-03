package lab12;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.ListIterator;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class lab12 {

	public class lis {
		String surN;
		String nam;
		String midllN;
		String number;
	}
	
	LinkedList<lis> pers = new LinkedList<lis>();
	
	private JFrame frame;
	private JTextField surname;
	private JTextField midlname;
	private JTextField number;
	private JTextField nameDel;
	private JTextField Name;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lab12 window = new lab12();
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
	public lab12() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 840, 587);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		surname = new JTextField();
		surname.setText("");
		surname.setToolTipText("\u0418\u043C\u044F");
		surname.setBounds(586, 30, 108, 20);
		frame.getContentPane().add(surname);
		surname.setColumns(10);
		
		Name = new JTextField();
		Name.setText("");
		Name.setToolTipText("\u0424\u0430\u043C\u0438\u043B\u0438\u044F");
		Name.setBounds(586, 63, 108, 20);
		frame.getContentPane().add(Name);
		Name.setColumns(10);
		
		midlname = new JTextField();
		midlname.setText("");
		midlname.setToolTipText("\u041E\u0442\u0447\u0435\u0441\u0442\u0432\u043E");
		midlname.setBounds(586, 96, 108, 20);
		frame.getContentPane().add(midlname);
		midlname.setColumns(10);
		
		number = new JTextField();
		number.setText("");
		number.setToolTipText("\u041D\u043E\u043C\u0435\u0440");
		number.setBounds(585, 135, 109, 20);
		frame.getContentPane().add(number);
		number.setColumns(10);
		
		
		JTextArea out = new JTextArea();
		out.setEditable(false);
		out.setBounds(147, 30, 408, 181);
		frame.getContentPane().add(out);
		
		JButton btnStraight = new JButton("Обновить");
		btnStraight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = "";				
				ListIterator<lis> iterator = pers.listIterator();
				lis temp = new lis();
				while (iterator.hasNext()) {
					temp = iterator.next();
					s += temp.surN + " " + temp.nam + " " + temp.midllN + " " + temp.number + "\n";
				
				}
				out.setText(s);
				
			}
		});
		btnStraight.setBounds(435, 221, 120, 23);
		frame.getContentPane().add(btnStraight);
		
		JButton btnAdd = new JButton("Добавить");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lis elem = new lis();
				elem.surN = surname.getText();
				elem.nam = Name.getText();
				elem.midllN = midlname.getText();
				elem.number = number.getText();
				pers.addLast(elem);
			}
		});
		btnAdd.setBounds(585, 173, 109, 38);
		frame.getContentPane().add(btnAdd);
		
		JTextArea Delete = new JTextArea();
		Delete.setEditable(false);
		Delete.setBounds(12, 124, 123, 31);
		frame.getContentPane().add(Delete);
		
		
		nameDel = new JTextField();
		nameDel.setBounds(34, 71, 86, 31);
		frame.getContentPane().add(nameDel);
		nameDel.setColumns(10);
		
		JButton buttonDelete = new JButton("Удалить");
		buttonDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = "";
				ListIterator<lis> iterator = pers.listIterator(pers.size());
				lis temp = new lis();
				boolean chek = true;
				while (iterator.hasPrevious() && chek) {
					temp = iterator.previous();
					if(temp.surN.startsWith(nameDel.getText())) {
						s += "Успешно удалено";
						iterator.remove();
						chek = false;
					}
				}
				if (chek == true)
					s += "Не найден элемент";
				Delete.setText(s);				
			}
		});
		buttonDelete.setBounds(34, 21, 86, 31);
		frame.getContentPane().add(buttonDelete);
		
		label = new JLabel("\u0424\u0430\u043C\u0438\u043B\u0438\u044F");
		label.setBounds(703, 30, 72, 20);
		frame.getContentPane().add(label);
		
		label_1 = new JLabel("\u0418\u043C\u044F");
		label_1.setBounds(706, 65, 72, 20);
		frame.getContentPane().add(label_1);
		
		label_2 = new JLabel("\u041E\u0442\u0447\u0435\u0441\u0442\u0432\u043E");
		label_2.setBounds(703, 98, 72, 20);
		frame.getContentPane().add(label_2);
		
		label_3 = new JLabel("\u041D\u043E\u043C\u0435\u0440");
		label_3.setBounds(703, 135, 72, 20);
		frame.getContentPane().add(label_3);
		
		label_4 = new JLabel("\u0420\u0435\u0437\u0443\u043B\u044C\u044F\u0442\u0430\u0442 \u0443\u0434\u0430\u043B\u0435\u043D\u0438\u044F");
		label_4.setBounds(12, 153, 135, 20);
		frame.getContentPane().add(label_4);
		
		label_5 = new JLabel("\u041F\u043E \u0438\u043C\u0435\u043D\u0438");
		label_5.setBounds(34, 51, 86, 16);
		frame.getContentPane().add(label_5);
		
	}
}
