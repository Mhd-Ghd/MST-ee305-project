import java.util.ArrayList;

public class Tree{
		Vertix root;
		
		public Tree(Vertix root) {
			this.root = root;
		}
		
		public void addEdge(Vertix a,Vertix b,double wieght) {
			a.addEdge(new Edge(a,b,wieght));
			b.addEdge(new Edge(b,a,wieght));
		}
		
		public ArrayList<Vertix> findMST(Vertix root,int numOfVert) {
			ArrayList<Vertix> path = new ArrayList<>();
			int vistedVert=1;
			path.add(root);
		
			while(vistedVert<numOfVert) {
				double minWieght= Double.MAX_VALUE;
				Vertix minVert=path.get(0);
			for (Vertix vert:path) {
				for(Edge edge:vert.edges) {
					if(edge.wieght<minWieght) {
						if(!path.contains(edge.vertA)) {
							minWieght=edge.wieght;
							minVert=edge.vertA;
						}else if(!path.contains(edge.vertB)) {
							minWieght=edge.wieght;
							minVert=edge.vertB;
						}
					}
				}
			}
			if(path.contains(minVert)) {
				return path;
			}
			path.add(minVert);
			vistedVert++;
		}
		
		return path;
	}




public ArrayList<Edge> findMSTedges(Vertix root,int numOfVert) {
	ArrayList<Vertix> path = new ArrayList<>();
	ArrayList<Edge> pathEdge = new ArrayList<>();
	
	int vistedVert=1;
	path.add(root);
	Edge currentEdge = new Edge(new Vertix(),new Vertix(),Integer.MAX_VALUE);
	if(!root.edges.isEmpty()) {
		currentEdge = root.edges.get(0);
	}
	while(vistedVert<numOfVert) {
		double minWieght= Double.MAX_VALUE;
		Vertix minVert=path.get(0);
		
	for (Vertix vert:path) {
		for(Edge edge:vert.edges) {
			if(edge.wieght<minWieght) {
				if(!path.contains(edge.vertA)) {
					minWieght=edge.wieght;
					minVert=edge.vertA;
					currentEdge=edge;
				}else if(!path.contains(edge.vertB)) {
					minWieght=edge.wieght;
					minVert=edge.vertB;
					currentEdge=edge;
				}
			}
		}
	}
	if(path.contains(minVert)) {
		return pathEdge;
	}
	path.add(minVert);
	pathEdge.add(currentEdge);
	vistedVert++;
}

return pathEdge;
}

}



class Vertix {
	String value;
	ArrayList<Edge> edges;
	
	public Vertix(String value) {
		 edges = new ArrayList<>();
		 this.value = value;
	}
	
	public Vertix() {
		edges = new ArrayList<>();
	}
	public void addEdge(Edge edge) {
		edges.add(edge);
	}
	
}

	class Edge{
		Vertix vertA;
		Vertix vertB;
		double wieght;
		
		public Edge(Vertix vertA, Vertix vertB, double wieght) {
			this.vertA = vertA;
			this.vertB = vertB;
			this.wieght = wieght;
		}
		
		
		
	}

	
	



