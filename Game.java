import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;

import Display.Display;

public class Game implements Runnable {
	
	
	
private Display display;
private int width,height;
private String title;
private Thread thread;
private boolean running;
private BufferStrategy bs;
private Graphics g;
private MenuState menuState;
private Controller controller;

//private Controller controller

public Game(String title, int width, int height) {
	this.width = width;
	this.height = height;
	this.title=title;
	controller = new Controller();

}

public void tick() {
	if(State.getCurrentState()!=null) {
		State.getCurrentState().tick();
	}
	
}



public void render() {
	
	bs=display.getCanvas().getBufferStrategy();
	
	if(bs == null) {
		display.getCanvas().createBufferStrategy(3);
		return;
	}
	g=bs.getDrawGraphics();
	g.clearRect(0, 0, width, height);
	
	
	
	
	if(State.getCurrentState()!=null) {
		State.getCurrentState().render(g);;
	}
	
	bs.show();
	g.dispose();
	
}

@Override
public void run() {
	
	init();
	int fps=60;
	
	double timePerTick = 1000000000/fps;
	double delta = 0;
	long now;
	long lastTime=System.nanoTime();
	
	
	while(running) {
		now=System.nanoTime();
		delta+=(now-lastTime)/timePerTick;
		lastTime=now;
		
		if(delta>=1) {
		
		tick();
		render();
		delta--;
		}
	}
	stop();
}

public void init() {
	display = new Display(title,width,height);
	
	display.getCanvas().addMouseListener(controller);

	menuState = new MenuState(this);
	
	State.setCurrentState(menuState);
	
	}

public synchronized void start() {
	if(running) {
		return;
	}
	running = true;
	thread = new Thread(this);
	thread.start();
}

public synchronized void stop() {
	if(!running) {
		return;
	}
	running = false;
	try {
		thread.join();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
}


public Controller getController() {
	return controller;
}
}
