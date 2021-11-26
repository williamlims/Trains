package Trains;

public class Edge<TYPE> {
    private Vertex<TYPE> origin;
    private Vertex<TYPE> destiny;
	private int distance;
    
    public Edge(Vertex<TYPE> origin, Vertex<TYPE> destiny, int distance){
        this.origin = origin;
        this.destiny = destiny;
        this.distance = distance;
    }

    public Vertex<TYPE> getOrigin() {
        return origin;
    }

    public void setOrigin(Vertex<TYPE> origin) {
        this.origin = origin;
    }

    public Vertex<TYPE> getDestiny() {
        return destiny;
    }

    public void setDestiny(Vertex<TYPE> destiny) {
        this.destiny = destiny;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
    
}
