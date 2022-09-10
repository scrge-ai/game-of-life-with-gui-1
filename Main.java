import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import java.awt.Component;
import java.util.Timer;

public class Main extends JPanel implements MouseListener {
	private int RECT_X = 5;
	private int RECT_Y = RECT_X;
	private int RECT_WIDTH = 20;
	private int RECT_HEIGHT = RECT_WIDTH;
	Boolean started = false;
	public Game game = new Game();
	long curtime = System.currentTimeMillis();
	long start = curtime;

	public Main(){
		//addMouseListener(new MouseListener(){});
		addMouseListener(this);
	}

public void mouseClicked(MouseEvent e) {
	int mx = e.getX();
	int my = e.getY();

	//System.out.print("aaaaaaa");
	//System.out.println(mx);
	//System.out.println(my);
	start = System.currentTimeMillis();
	if((int) mx/20 >= 12 || (int) my/20 >= 12){
		started = !started;
		System.out.println("playing: " + started);
		return;
	}
	game.addCell((int) mx/20, (int) my/20);
		/*try {
	    	Thread.sleep(1000);
		} catch (InterruptedException exc){
			
		}*/
}

public void mouseEntered(MouseEvent arg0) {
	//System.out.println("event");
}

public void mouseExited(MouseEvent arg0) {
}

public void mousePressed(MouseEvent arg0) {
}

public void mouseReleased(MouseEvent arg0) {
}

public void mouseDragged(MouseEvent arg0) {
}

public void mouseMoved(MouseEvent arg0) {
    // TODO Auto-generated method stub
}

	public void paint(Graphics g) {
		// super.paintComponent(g);
		// draw the rectangle here
		if(System.currentTimeMillis()-start > 1000){
			game.update();
			start = System.currentTimeMillis();
		}
		/*for(int i = 1; i < 11; i++){
			for(int j = 1; j < 11; j++){
				System.out.print(game.grid[i][j]);
			}
			System.out.println();
		}*/
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 600, 600);
		g.setColor(Color.BLACK);
		for (int i = 1; i < 11; i++) {
			for (int j = 1; j < 11; j++) {
				if (game.grid[i][j] == 0) {
					g.drawRect(i * 20, j * 20, 20, 20);
				} else {
					g.fillRect(i * 20, j * 20, 20, 20);
				}
			}
		}
		/*if(started){try {
	    	Thread.sleep(100);
		} catch (InterruptedException exc){
			
		}}*/

		// g.fillRect(RECT_X, RECT_Y, RECT_WIDTH, RECT_HEIGHT);
		// RECT_X++;
		repaint();
	}

	@Override
	public Dimension getPreferredSize() {
		// so that our GUI is big enough
		return new Dimension(600, 600);
	}

	// create the GUI explicitly on the Swing event thread
	private static void createAndShowGui() {
		Main mainPanel = new Main();

		JFrame frame = new JFrame("DrawRect");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(mainPanel);
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// Game game = new Game();
		System.out.println("Hi click on the cells to add cells and click outside the grid to play/pause");
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGui();
			}
		});
	}
}