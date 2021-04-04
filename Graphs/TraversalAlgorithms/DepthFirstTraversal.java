package Graphs.TraversalAlgorithms;

import Graphs.Domain.Graph;
import Graphs.Domain.Vertex;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class DepthFirstTraversal {

    public static LinkedList<Vertex> depthFirstTraversalIterative(Graph graph, String start, String end) {

        Vertex startVertex = graph.getVertices().get(start);
        Vertex endVertex = graph.getVertices().get(end);

        Stack<Vertex> vertexStack = new Stack<>();
        HashMap<Vertex, Vertex> visitedVertex = new HashMap<>();

        visitedVertex.put(startVertex, null);

        Vertex currentVertex = startVertex;

        while(currentVertex != endVertex) {

            LinkedList<Vertex> adjacentVertex = currentVertex.getAdjacents();

            for(Vertex vertex: adjacentVertex) {
                if(!visitedVertex.containsKey(vertex)) {
                    vertexStack.push(vertex);
                    visitedVertex.put(vertex, currentVertex);
                }
            }

            currentVertex = vertexStack.pop();
        }

        return createPath(visitedVertex, endVertex);
    }

    public static LinkedList<Vertex> depthFirstTraversalRecursive(Graph graph, String start, String end) {
        Vertex startVertex = graph.getVertices().get(start);
        Vertex endVertex = graph.getVertices().get(end);

        HashMap<Vertex, Vertex> visitedVertex = new HashMap<>();
        visitedVertex.put(startVertex, null);

        dfs(startVertex, endVertex, visitedVertex);

        return createPath(visitedVertex, endVertex);
    }

    private static void dfs(Vertex currentVertex, Vertex endVertex, HashMap<Vertex, Vertex> visitedVertex) {

        if(currentVertex == endVertex) {
            return;
        }

        LinkedList<Vertex> adjacentVertex = currentVertex.getAdjacents();
        for(Vertex vertex: adjacentVertex) {
            if(!visitedVertex.containsKey(vertex)) {
                visitedVertex.put(vertex, currentVertex);
                dfs(vertex, endVertex, visitedVertex);
            }
        }
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
