import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JPanel;

public class panel7  extends JPanel {

	int m, n;
	int[][] arr;
	int herx, hery;
	public void load() {
		try {
			Scanner sc = new Scanner(new File("D:\\Roma\\game.txt"));
			m = sc.nextInt();
			n = sc.nextInt();
			herx = sc.nextInt();
			hery = sc.nextInt();
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
	public void moveDown() {
		if (arr[hery + 1][herx] != 1)
		{
			hery++;
		}
		repaint();
	}
	
	public void moveUp() {
		if (arr[hery - 1][herx] != 1)
		{
			hery--;
		}
		repaint();
	}
	
	public void moveLeft() {
		if (arr[hery][herx - 1] != 1)
		{
			herx--;
		}
		repaint();
	}
	
	public void moveRight() {
		if (arr[hery][herx + 1] != 1)
		{
			herx++;
		}
		repaint();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		int y = 0;
			for(int i = 0; i < m; i++) {
				int x = 0;
				for(int j = 0; j < n; j++) {
				
					if (arr[i][j] == 1) {
						g.setColor(Color.ORANGE);
						g.fillRect(x, y, 40, 40);
					} else if (arr[i][j] == 0) {
						g.setColor(Color.CYAN);
						g.fillRect(x, y, 40, 40);
					}
					x += 40;
			}
			y += 40;
		}	
			g.setColor(Color.red);
			g.fillRect(herx * 40, hery * 40, 40, 40);
			//g.drawImage(img, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, observer)
	}
}

