package Trains;
import java.util.*;

public class Vertex<TYPE> {
    private ArrayList<Edge<TYPE>> edgeInput;
    private ArrayList<Edge<TYPE>> edgeOutput;
	private TYPE data;
    
    public Vertex(TYPE data){
        this.edgeInput = new ArrayList<Edge<TYPE>>();
        this.edgeOutput = new ArrayList<Edge<TYPE>>();
        this.data = data;
    }
    
    public void addEdgeInput(Edge<TYPE> edge){
        this.edgeInput.add(edge);
    }
    
    public void addEdgeOutput(Edge<TYPE> edge){
        this.edgeOutput.add(edge);
    }

    public ArrayList<Edge<TYPE>> getEdgeInput() {
        return edgeInput;
    }

    public ArrayList<Edge<TYPE>> getEdgeOutput() {
        return edgeOutput;
    }

    public TYPE getData() {
        return data;
    }

    public void setData(TYPE data) {
        this.data = data;
    }
}
