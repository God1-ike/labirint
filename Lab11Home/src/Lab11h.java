import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Lab11h {

	public class lis {
		String surname;
		String name;
		String midlname;
		String number;
		lis next;
		lis prev;
	}
	
	lis head = null;
	lis tail = null;
	int len = 0;
	
	
	private JFrame frame;
	private JTextField surname;
	private JTextField Name;
	private JTextField midlname;
	private JTextField number;
	private JTextField textFind;
	private JTextField textDel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lab11h window = new Lab11h();
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
	public Lab11h() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 853, 578);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		surname = new JTextField();
		surname.setText("");
		surname.setToolTipText("");
		surname.setBounds(496, 29, 128, 20);
		frame.getContentPane().add(surname);
		surname.setColumns(10);
		
		Name = new JTextField();
		Name.setText("");
		Name.setToolTipText("");
		Name.setBounds(496, 62, 128, 20);
		frame.getContentPane().add(Name);
		Name.setColumns(10);
		
		midlname = new JTextField();
		midlname.setText("");
		midlname.setToolTipText("");
		midlname.setBounds(496, 95, 128, 20);
		frame.getContentPane().add(midlname);
		midlname.setColumns(10);
		
		number = new JTextField();
		number.setText("");
		number.setToolTipText("");
		number.setBounds(496, 125, 128, 20);
		frame.getContentPane().add(number);
		number.setColumns(10);
		
		textFind = new JTextField();
		textFind.setBounds(5, 28, 86, 20);
		frame.getContentPane().add(textFind);
		textFind.setColumns(10);
		
		
		JTextArea textAreaOutAll = new JTextArea();
		textAreaOutAll.setEditable(false);
		textAreaOutAll.setBounds(106, 29, 378, 231);
		frame.getContentPane().add(textAreaOutAll);
		
		JButton prymoi = new JButton("\u041F\u0440\u044F\u043C\u043E\u0439");
		prymoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lis time = head;
				String str = "";
				int i = 0;
				while(i < len){
					str += time.surname + " " + time.name + " " + time.midlname + " " + time.number + "\n";
					time = time.next;
					i++;
				}
				textAreaOutAll.setText(str);
				
			}
		});
		prymoi.setBounds(116, 273, 114, 23);
		frame.getContentPane().add(prymoi);
		
		JTextArea OutFind = new JTextArea();
		OutFind.setEditable(false);
		OutFind.setBounds(5, 97, 86, 84);
		frame.getContentPane().add(OutFind);
		
		JButton btnAdd = new JButton("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lis next = new lis();
				next.surname = surname.getText();
				next.name = Name.getText();
				next.midlname = midlname.getText();
				next.number = number.getText();
					
				if(len == 0) {
					head = next;
					tail = next;
					
				} else {
					tail.next = next;
					next.prev = tail;
					tail = next;
				}
				len++;
			}
		});
		btnAdd.setBounds(496, 158, 128, 23);
		frame.getContentPane().add(btnAdd);
		
		JButton obratn = new JButton("\u041E\u0431\u0440\u0430\u0442\u043D\u044B\u0439");
		obratn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lis time = tail;
				String str = "";
				int i = 0;
				while(i < len){
					str += time.surname + " " + time.name + " " + time.midlname + " " + time.number + "\n";
					time = time.prev;
					i++;
				}
				textAreaOutAll.setText(str);
				
			}
		});
		obratn.setBounds(344, 273, 114, 23);
		frame.getContentPane().add(obratn);
		
		JButton btnFind = new JButton("\u041D\u0430\u0439\u0442\u0438");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lis time = head;
				String str = "";
				int i = 0;
				while(i < len){
					if(time.surname.startsWith(textFind.getText())) {
						str += time.surname + " " + time.name + " " + time.midlname + " " + time.number + "\n";
					}
					time = time.next;
					i++;
				}
				OutFind.setText(str);
			}
		});
		btnFind.setBounds(5, 61, 89, 23);
		frame.getContentPane().add(btnFind);
		
		textDel = new JTextField();
		textDel.setBounds(496, 194, 186, 39);
		frame.getContentPane().add(textDel);
		textDel.setColumns(10);
		
		JButton Delete = new JButton("\u0423\u0434\u0430\u043B\u0438\u0442\u044C");
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				lis time = head;
				int i = 0;
				String str = "";
				while(i < len){
					if(time.name.startsWith(textDel.getText())) {
						str = "Удалено:" + time.surname + " " + time.name + " " + time.midlname + " " + time.number;
						if(len == 1) {
							head = null;
							tail = null;
						} else if(head == time) {
							head = time.next;
						} else if(tail == time) {
							tail = time.prev;
						} else {
							time.prev.next = time.next;
							time.next.prev = time.prev;
						}
						
						
						i = len + 1;
						len--;
					}
					time = time.next;
					i++;
				}
				textDel.setText(str);				
			}
		});
		Delete.setBounds(496, 238, 86, 31);
		frame.getContentPane().add(Delete);
		
		JLabel label = new JLabel("\u041D\u043E\u043C\u0435\u0440");
		label.setBounds(636, 125, 72, 20);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u041E\u0442\u0447\u0435\u0441\u0442\u0432\u043E");
		label_1.setBounds(636, 97, 72, 20);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u0418\u043C\u044F");
		label_2.setBounds(639, 64, 72, 20);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\u0424\u0430\u043C\u0438\u043B\u0438\u044F");
		label_3.setBounds(636, 29, 72, 20);
		frame.getContentPane().add(label_3);
		
	}
}
