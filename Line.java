
public class Line {
int startX,endX,startY,endY;


public Line(int startX, int startY,  int endX,int endY) {
	this.startX = startX;
	this.endX = endX;
	this.startY = startY;
	this.endY = endY;
}

public int getStartX() {
	return startX;
}

public void setStartX(int startX) {
	this.startX = startX;
}

public int getEndX() {
	return endX;
}

public void setEndX(int endX) {
	this.endX = endX;
}

public int getStartY() {
	return startY;
}

public void setStartY(int startY) {
	this.startY = startY;
}

public int getEndY() {
	return endY;
}

public void setEndY(int endY) {
	this.endY = endY;
}



public int getLength() {
	return (int)Math.sqrt(Math.pow(endY-startY,2)+Math.pow(endX-startX,2));
}


}
