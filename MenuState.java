import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class MenuState extends State {

	int prevX,prevY;
	int scene;
	
	int circleCounter;
	 Circle selected;
	 Circle preSelected;
	 
	ArrayList<Circle> circles;
	ArrayList <Vertix> verts;
	ArrayList<Edge> edges;
	ArrayList<Line> lines;
	
	Tree tree;
	ArrayList<Edge> pathEdges;
	int counter;
	
	public MenuState(Game game) {
		super(game);
		circles=new ArrayList<>();
		lines=new ArrayList<>();
		verts=new ArrayList<>();
		edges=new ArrayList<>();
		pathEdges=new ArrayList<>();

	}
	
	
	@Override
	public void tick() {

	}

	@Override
	public void render(Graphics g) {
		if(scene==0) {

			selected=null;
		g.setFont(new Font("Minecrafter", 0, 90));
		g.drawString("Initalize", 230, 200);
		
		g.setColor(new Color(177, 106, 231, 100));
		g.setFont(new Font("Minecrafter", 0 , 20));
		g.drawString("Now You will Place where the Keys to be Collected, the first", 70, 400);
		g.drawString("    		point is where the player is going to start. ", 110, 430);
		
		g.fillRect(350, 600, 200, 70);
		
		g.setColor(Color.white);

		g.drawString("Start", 415, 645);
		
		

		if((Controller.x>350 && Controller.x<550)  &&  (Controller.y>600 && Controller.y<670)  ){
			scene=1;
			prevX=Controller.x;
			prevY=Controller.y;
		}
		}else if(scene==1) {
			
			if(Controller.clickSide==Controller.clickSide.Left) {
			if((prevX!=Controller.x || prevY!=Controller.y )&&  ! ((Controller.x>750 && Controller.x<850)  &&  (Controller.y>800 && Controller.y<900))  ) {
				 
			verts.add(new Vertix(String.valueOf(counter++)));
			circles.add(new Circle(Controller.x,Controller.y));
			prevX=Controller.x;
			prevY=Controller.y;
			}
			
			
			}else {
				for(Circle circle:circles) {
					if((circle.getX()<Controller.x  && circle.getX()+60>Controller.x) && (circle.getY()<Controller.y  && circle.getY()+60>Controller.y) && circle!=selected){
						if(prevX!=Controller.x || prevY!=Controller.y) {
						if(selected!=null) {
							Line line = new Line(circle.getX(),circle.getY(),selected.getX(),selected.getY());
							lines.add(line);
							edges.add(new Edge(verts.get(circles.indexOf(circle)) , verts.get(circles.indexOf(selected)) , line.getLength()));
							selected=null;
						}else {
							selected=circle;
						}
						}

						prevX=Controller.x;
						prevY=Controller.y;
					}
				}
			}
			
			for(Circle circle:circles) {
				if(circle==selected) {
					g.setColor(new Color(71, 93, 255, 100));
				}
				g.fillOval(circle.getX(), circle.getY(), 50, 50);
				g.setColor(new Color(0, 22, 31, 100));
			}
			
			
			
			for(Line line:lines) {
				g.drawLine(line.getStartX()+25,line.getStartY()+25,line.getEndX()+25,line.getEndY()+25);
				g.setFont(new Font("Arial", 1 , 16));
				g.drawString(String.valueOf(line.getLength()), (line.getStartX()+line.getEndX())/2, (line.getStartY()+line.getEndY())/2);
			}
			
			
			

			
			g.setColor(Color.white);
			g.setFont(new Font("Minecrafter", 0 , 17));
			g.drawString("Start >>", 800, 850);
			
			
			if((Controller.x>750 && Controller.x<850)  &&  (Controller.y>800 && Controller.y<900)  ){
				scene=2;
				prevX=Controller.x;
				prevY=Controller.y;
				
			}
			
			if(!verts.isEmpty()) {
			  	tree =initSim();
			}	

		}else if(scene==2) {
			
			
			for(Circle circle:circles) {
				g.fillOval(circle.getX(), circle.getY(), 50, 50);
				g.setColor(new Color(0, 22, 31, 100));
			}
			
			
			
			for(Line line:lines) {
				g.drawLine(line.getStartX()+25,line.getStartY()+25,line.getEndX()+25,line.getEndY()+25);
				g.setFont(new Font("Arial", 1 , 16));
				g.drawString(String.valueOf(line.getLength()), (line.getStartX()+line.getEndX())/2, (line.getStartY()+line.getEndY())/2);
			}
			
			if(!verts.isEmpty()) {
			  	tree =initSim();
			  	pathEdges = tree.findMSTedges(verts.get(0), verts.size());
			  	ArrayList<Vertix> MST =tree.findMST(verts.get(0), verts.size());
			  	Circle prevCircle=circles.get(0);
			  	for(int i =0;i<MST.size();i++) {
			  		Vertix vert=MST.get(i);
			  		Circle circle =circles.get(verts.indexOf(vert));
			  		g.setColor(new Color(71, 93, 255, 100));
					g.fillOval(circle.getX(), circle.getY(), 50, 50);

					
					for(Edge edge : pathEdges) {
						Vertix vertA=edge.vertA;
						Vertix vertB=edge.vertB;
						Circle circleA =circles.get(verts.indexOf(vertA));
						Circle circleB =circles.get(verts.indexOf(vertB));
						Line line = new Line(circleA.getX(),circleA.getY(),circleB.getX(),circleB.getY());

						g.drawLine(line.getStartX()+25,line.getStartY()+25,line.getEndX()+25,line.getEndY()+25);
						g.setFont(new Font("Arial", 1 , 16));
						g.drawString(String.valueOf(line.getLength()), (line.getStartX()+line.getEndX())/2, (line.getStartY()+line.getEndY())/2);
					}
					
					
					
				
					
					}

					
			  	}

			g.setColor(Color.white);
			g.setFont(new Font("Minecrafter", 0 , 17));
			g.drawString("Menu >>", 800, 850);
			
			
			if((prevX!=Controller.x || prevY!=Controller.y ) && (Controller.x>750 && Controller.x<850)  &&  (Controller.y>800 && Controller.y<900)  ){
				scene=0;
				prevX=Controller.x;
				prevY=Controller.y;
				
			}
			
			
			}
			
			
			
			
			
		}
		
			
		
		
		
		
	

	public Tree initSim() {
		
		
		
		
		Tree tree=new Tree(verts.get(0));
		
		for(Edge edge:edges) {
			tree.addEdge(edge.vertA, edge.vertB, edge.wieght);
		}
		return tree;
	}
	
	


}
