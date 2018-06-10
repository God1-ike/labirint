package lab6Home;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JPanel;

public class hPanel extends JPanel {

	int m, n;
	int[][] arr;
	public void load() {
		try {
			Scanner sc = new Scanner(new File("D:\\Roma\\input.txt"));
			m = sc.nextInt();
			n = sc.nextInt();
			arr = new int[m][n];
			for(int i = 0; i < m; i++) {
				for(int j = 0; j < n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			sc.close();
		} catch (FileNotFoundException el) {
			el.printStackTrace();
		}
	}
	
	public void delet() {
		for(int i = 0; i < m; i++) {
			boolean chek  = true;
			for(int j = 0; j < n; j++) {
				if(arr[i][j] % 2 == 0) {
					chek = false;
				}
			}
			if (chek == true) {
				for(int j = 0; j < n; j++) {
					arr[i][j] = 0;
				}
			}
		}
		repaint();
	}
	public void paint(Graphics g) {
		super.paint(g);
		int y = 10;
			for(int i = 0; i < m; i++) {
			int x = 10;
			for(int j = 0; j < n; j++) {
				
				if (arr[i][j] == 1) {
					g.setColor(Color.BLACK);
				} else if (arr[i][j] == 2) {
					g.setColor(Color.YELLOW);
				} else if (arr[i][j] == 3) {
					g.setColor(Color.BLUE);
				} else if (arr[i][j] == 4) {
					g.setColor(Color.GREEN);
				} else if (arr[i][j] == 5) {
					g.setColor(Color.GRAY);
				} else if (arr[i][j] == 6) {
					g.setColor(Color.CYAN);
				} else if (arr[i][j] == 7) {
					g.setColor(Color.MAGENTA);
				} else if (arr[i][j] == 8) {
					g.setColor(Color.PINK);
				} else if (arr[i][j] == 9) {
					g.setColor(Color.ORANGE);
				} else if (arr[i][j] == 0) {
					g.setColor(Color.RED);
				}	
				g.fillRect(x, y, 40, 40);
				x += 44;
			}
			y += 44;
		}	
	}
}
