

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



public class Controller implements MouseListener {

	 static int x,y;
	 
	enum ClickSide{
		Right,Left;
	}
	
	static ClickSide clickSide;
	
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	     x=arg0.getX();
	     y=arg0.getY();
		if(arg0.getButton()==1) {
			clickSide=ClickSide.Left;
		}else {
			clickSide=ClickSide.Right;
		}

	
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}

	public int getX() {
		return x;
	}


	public int getY() {
		return y;
	}


}