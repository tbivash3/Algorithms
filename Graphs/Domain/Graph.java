package Graphs.Domain;

import java.util.HashMap;
import java.util.Map;

public class Graph {
    
    private HashMap<String, Vertex> vertices;

    public HashMap<String, Vertex> getVertices() {
        return vertices;
    }

    public Graph() {
        this.vertices = new HashMap<>();
    }
    
    public Vertex addVertex(String name) {
        Vertex vertex = new Vertex();
        vertices.put(name, vertex);
        return vertex;
    }
    
    public void addBidirectionalEdge(String vertex1, String vertex2) {
        Vertex v1 = vertices.get(vertex1);
        Vertex v2 = vertices.get(vertex2);
        
        v1.addAdjacent(v2);
        v2.addAdjacent(v1);
    }

    public void addUnidirectionalEdge(String vertex1, String vertex2) {
        Vertex v1 = vertices.get(vertex1);
        Vertex v2 = vertices.get(vertex2);

        v1.addAdjacent(v2);
    }

    public String getVertexName(Vertex vertex) {
        String vertexName = "";
        for(Map.Entry<String, Vertex> entry: vertices.entrySet()) {
            if(entry.getValue().equals(vertex)) {
                vertexName = entry.getKey();
                break;
            }
        }
        return vertexName;
    }
}
