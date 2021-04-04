package Graphs.TraversalAlgorithms;

import Graphs.Domain.Graph;
import Graphs.Domain.Vertex;

import java.util.HashMap;
import java.util.LinkedList;

public class BreadthFirstTraversal {
    public static LinkedList<Vertex> breadthFirstTraversal(Graph graph, String start, String end) {

        Vertex startVertex = graph.getVertices().get(start);
        Vertex endVertex = graph.getVertices().get(end);

        LinkedList<Vertex> vertexQueue = new LinkedList<>();
        HashMap<Vertex, Vertex> visitedVertex = new HashMap<>();

        visitedVertex.put(startVertex, null);

        Vertex currentVertex = startVertex;

        while(currentVertex != endVertex) {

            LinkedList<Vertex> adjacents = currentVertex.getAdjacents();

            for(Vertex vertex: adjacents) {
                if(!visitedVertex.containsKey(vertex)) {
                    vertexQueue.add(vertex);
                    visitedVertex.put(vertex, currentVertex);
                }
            }
            currentVertex = vertexQueue.remove();
        }

        LinkedList<Vertex> path = createPath(visitedVertex, currentVertex);
        return path;
    }

    private static LinkedList<Vertex> createPath(HashMap<Vertex, Vertex> visitedVertex, Vertex endVertex) {
        LinkedList<Vertex> path = new LinkedList<>();
        while(endVertex != null) {
            path.addFirst(endVertex);
            endVertex = visitedVertex.get(endVertex);
        }
        return path;
    }
}
