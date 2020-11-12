package Display;



import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {

	private JFrame frame;
	private String title;
	private int height,width;
	private Canvas canvas;
	
	public Display(String title,int width,int height) {
		this.height=height;
		this.title=title;
		this.width=width;
		createDisplay();		
	}
	
	public void createDisplay() {
		frame = new JFrame();
		frame.setSize(width,height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle(title);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width,height));
		canvas.setMaximumSize(new Dimension(width,height));
		canvas.setMinimumSize(new Dimension(width,height));
		canvas.setBackground(Color.darkGray);
		canvas.setFocusable(false);
		
		frame.add(canvas);
		frame.pack();

		
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public Canvas getCanvas() {
		return canvas;
	}

	
	
}
