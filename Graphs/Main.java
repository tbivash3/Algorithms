package Graphs;

import Graphs.Domain.Graph;
import Graphs.Domain.Vertex;
import Graphs.TraversalAlgorithms.BreadthFirstTraversal;
import Graphs.TraversalAlgorithms.DepthFirstTraversal;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");

        graph.addBidirectionalEdge("A", "E");
        graph.addBidirectionalEdge("E", "A");
        graph.addBidirectionalEdge("E", "D");
        graph.addBidirectionalEdge("D", "E");
        graph.addBidirectionalEdge("D", "F");
        graph.addBidirectionalEdge("F", "D");
        graph.addBidirectionalEdge("D", "C");
        graph.addBidirectionalEdge("C", "D");
        graph.addBidirectionalEdge("F", "C");
        graph.addBidirectionalEdge("C", "F");
        graph.addBidirectionalEdge("C", "B");
        graph.addBidirectionalEdge("B", "C");
        graph.addBidirectionalEdge("F", "B");
        graph.addBidirectionalEdge("B", "F");
        graph.addBidirectionalEdge("C", "G");
        graph.addBidirectionalEdge("G", "C");

        BreadthFirstTraversal bfs = new BreadthFirstTraversal();
        LinkedList<Vertex> pathBFS = bfs.breadthFirstTraversal(graph, "A", "G");

        DepthFirstTraversal dfs = new DepthFirstTraversal();
        LinkedList<Vertex> pathDFSRecursive = dfs.depthFirstTraversalRecursive(graph, "A", "G");

        LinkedList<Vertex> pathDFSIterative = dfs.depthFirstTraversalIterative(graph, "A", "G");


        System.out.println("-------- BFS ---------");
        for(int num=0; num<pathBFS.size(); num++)
        {
            System.out.println(graph.getVertexName(pathBFS.get(num)));
        }

        System.out.println("-------- DFS Recursive ---------");
        for(int num=0; num<pathDFSRecursive.size(); num++)
        {
            System.out.println(graph.getVertexName(pathDFSRecursive.get(num)));
        }

        System.out.println("-------- DFS Iterative ---------");
        for(int num=0; num<pathDFSIterative.size(); num++)
        {
            System.out.println(graph.getVertexName(pathDFSIterative.get(num)));
        }
    }
}
