package Trains;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import javax.swing.JFileChooser;

public class Graph<TYPE> {
	
	private ArrayList<Vertex<TYPE>> vertexs;
    private ArrayList<Edge<TYPE>> edges;
    private int counter = 1;
    
    // constructor
    public Graph(){
        this.vertexs = new ArrayList<Vertex<TYPE>>();
        this.edges = new ArrayList<Edge<TYPE>>();
    }
    
    // method to create the vertex
    public void createVertex(String vtx, Graph<String> v) {
		String[] list = vtx.split(", ");		
		int sizeV = list.length;	
		for(int i = 0; i < sizeV; i++) {
			v.addVertex(Character.toString(list[i].charAt(0)));
		}
	}
    
    // upload the text file for vertex
    public void uploadFileVertex(Graph<String> g) throws FileNotFoundException, IOException {
    	final JFileChooser fileup = new JFileChooser();
		int valueRet = fileup.showOpenDialog(null);
		if (valueRet == JFileChooser.APPROVE_OPTION) {
		    File file = fileup.getSelectedFile();
		    try (FileInputStream fis = new FileInputStream(file)) {
		    	String data = "";
		        Scanner reader = new Scanner(fis);
		        while (reader.hasNextLine()) {
		        	data = reader.nextLine();
		        }
		        reader.close();
		        g.createVertex(data, g);
		    }
		}
    }
    
    // upload the file text for graph
    public void uploadFileGraph(Graph<String> g) throws FileNotFoundException, IOException {
    	final JFileChooser fileup = new JFileChooser();
		int valueRet = fileup.showOpenDialog(null);
		if (valueRet == JFileChooser.APPROVE_OPTION) {
		    File file = fileup.getSelectedFile();
		    try (FileInputStream fis = new FileInputStream(file)) {
		    	String data = "";
		        Scanner reader = new Scanner(fis);
		        while (reader.hasNextLine()) {
		           data = reader.nextLine();
		        }
		        reader.close();
		        g.createGraph(data, g);
		    }
		}
    }
    
    // method to create the graph
    public void createGraph(String ls, Graph<String> g) {
		String[] list = ls.split(", ");		
		int sizeL = list.length;		
		for(int i = 0; i < sizeL; i++) {
			g.addEdge(Character.toString(list[i].charAt(0)), Character.toString(list[i].charAt(1)),
										 Integer.parseInt(String.valueOf(list[i].charAt(2))));
		}
	}
    
    // Get the distance of two vertexes
    public int getEdgesDistance(String origin, String destiny) {
    	int distance = 0;
    	for(int i = 0; i < edges.size(); i++) {
    		if(edges.get(i).getOrigin().getData().equals(origin) &&
    			edges.get(i).getDestiny().getData().equals(destiny)) {
    			distance = edges.get(i).getDistance();
    		}    	    		
    	}
    	if(distance != 0) {
    		return distance;
    	} else {
    		return 0;
    	}
    }
    
    // Calculate the distance of a given route
    public void calculateRoute(String... position) {
    	int distance = 0;
    	for(int i = 0; i < position.length - 1; i++) {    		
    		if(getEdgesDistance(position[i], position[i+1]) != 0) {
    			distance += getEdgesDistance(position[i], position[i+1]);
    		} else {
    			distance = 0;
    			break;
    		}    		
    	}
    	if(distance == 0) {
    		System.out.println("Output #"+this.counter+ " NO SUCH ROUTE");
    	} else {
    		System.out.println("Output #"+this.counter+ " " + distance);
    	}
    	this.counter++;
    }
    
    // Add a new Vertex
    public void addVertex(TYPE data){
        Vertex<TYPE> newVertex = new Vertex<TYPE>(data);
        this.vertexs.add(newVertex);
    }
    
    // add a new Edge
    public void addEdge(TYPE origin, TYPE destiny, int distance){
        Vertex<TYPE> originInfo = this.getVertex(origin);
        Vertex<TYPE> destinyInfo = this.getVertex(destiny);
        Edge<TYPE> edge = new Edge<TYPE>(originInfo, destinyInfo, distance);
        originInfo.addEdgeOutput(edge);
        destinyInfo.addEdgeInput(edge);
        this.edges.add(edge);
    }
    
    // return the vertex
    public Vertex<TYPE> getVertex(TYPE data){
        Vertex<TYPE> vertex = null;
        for(int i=0; i < this.vertexs.size(); i++){
            if (this.vertexs.get(i).getData().equals(data)){
                vertex = this.vertexs.get(i);
                break;
            }
        }
        return vertex;
    }
    
    // testing routes
    public void Test(Graph<String> g) {
    	g.calculateRoute("A", "B", "C");
		g.calculateRoute("A", "D");
		g.calculateRoute("A", "D", "C");
		g.calculateRoute("A", "E", "B", "C", "D");
		g.calculateRoute("A", "E", "D");
    }
            
}
