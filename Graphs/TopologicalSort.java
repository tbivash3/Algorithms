package Graphs;

import Graphs.Domain.Graph;
import Graphs.Domain.Vertex;

import java.util.*;

public class TopologicalSort {

    static LinkedList<Vertex> topSortList = new LinkedList<>();

    public static void topSort(Graph graph) {
        Set<Vertex> visited = new HashSet<>();

        for(Vertex vertex: graph.getVertices().values()) {

            if(!visited.contains(vertex)) {
                visited.add(vertex);
            } else {
                continue;
            }

            dfs(graph, vertex, visited);
        }
    }

    private static void dfs(Graph graph, Vertex currentVertex, Set<Vertex> visited) {

        List<Vertex> adjacentVertices = currentVertex.getAdjacents();

        for(Vertex adjacentVertex: adjacentVertices) {
            if(!visited.contains(adjacentVertex)) {
                visited.add(adjacentVertex);
                dfs(graph, adjacentVertex, visited);
            }
        }
        topSortList.addFirst(currentVertex);
    }

    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");
        graph.addVertex("I");
        graph.addVertex("J");
        graph.addVertex("K");

        graph.addUnidirectionalEdge("A", "B");
        graph.addUnidirectionalEdge("A", "D");
        graph.addUnidirectionalEdge("B", "E");
        graph.addUnidirectionalEdge("C", "F");
        graph.addUnidirectionalEdge("D", "E");
        graph.addUnidirectionalEdge("D", "F");
        graph.addUnidirectionalEdge("E", "H");
        graph.addUnidirectionalEdge("E", "G");
        graph.addUnidirectionalEdge("F", "I");
        graph.addUnidirectionalEdge("G", "I");
        graph.addUnidirectionalEdge("G", "J");
        graph.addUnidirectionalEdge("H", "J");

        topSort(graph);

        for(Vertex vertex: topSortList) {
            System.out.println(graph.getVertexName(vertex));
        }
    }
}
