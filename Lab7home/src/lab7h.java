import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

public class lab7h {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lab7h window = new lab7h();
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
	public lab7h() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		panel7 panel = new panel7();
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				switch(arg0.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					panel.moveLeft();
					break;
				case KeyEvent.VK_RIGHT:
					panel.moveRight();
					break;
				case KeyEvent.VK_UP:
					panel.moveUp();
					break;
				case KeyEvent.VK_DOWN:
					panel.moveDown();
					break;
				}
			}
		});
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1056, 669);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel.load();
		panel.setBackground(Color.WHITE);
		panel.setBounds(12, 13, 954, 560);
		frame.getContentPane().add(panel);
	}

}
